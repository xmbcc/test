package com.lujiaxin.sop.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lujiaxin.sop.commons.CommonsCode;
import com.lujiaxin.sop.domain.*;
import com.lujiaxin.sop.mapper.ClientEntityMapper;
import com.lujiaxin.sop.mapper.ClientRoleMapper;
import com.lujiaxin.sop.mapper.RoleEntityMapper;
import com.lujiaxin.sop.mapper.SendMessageClientMapper;
import com.lujiaxin.sop.service.ClientEntityService;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.*;

@Service
@Slf4j
public class ClientEntityServiceImpl extends ServiceImpl<ClientEntityMapper, ClientEntity> implements ClientEntityService {

    @Autowired
    private ClientEntityMapper clientEntityMapper;

    @Resource
    private RoleEntityMapper roleEntityMapper;

    @Resource
    private ClientRoleMapper clientRoleMapper;

    @Resource
    private SendMessageClientMapper sendMessageClientMapper;

    @Resource
    private JavaMailSender javaMailSender;

    @Override
    public String login(LoginUserInfo userInfo) {
        String username = userInfo.getUsername();
        String password = userInfo.getPassword();

        ClientEntity client = clientEntityMapper.findByClientName(username);

        ClientEntity entity = Optional.ofNullable(client).filter(o -> o.getClientPassword().equals(password)).orElse(null);
        if(entity == null){
            return null;
        }

        HashMap<String, Object> map = claimsUserInfo(client);

        Date expire = new Date(1000 * 60 * 30l);
        String subject = "ljx3335";

        String token = Jwts.builder().setClaims(map)
                .setExpiration(expire)
                .setSubject(subject)
                .compact();

        return token;
    }

    @Override
    public List<ClientEntityDto> listAll(Integer cur, Integer size) {
        Page<ClientEntity> page = new Page<>(cur, size);
        List<ClientEntity> all = clientEntityMapper.findAllByPage((cur-1)*10, size);
        log.info("clients:{}", JSON.toJSONString(all));
        ArrayList<ClientEntityDto> result = new ArrayList<>();
        for (ClientEntity client : all) {
            ClientEntityDto dto = new ClientEntityDto();
            BeanUtils.copyProperties(client,dto);
            Boolean sex = client.getClientSex();
            String sexScript = sex ? CommonsCode.MAN : CommonsCode.WOMAN;
            dto.setClientSex(sexScript);
            result.add(dto);
        }

        return result;
    }

    @Override
    public void saveClients(ClientEntity client, Long roleId) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        client.setClientCreateTime(now);
        client.setClientUpdateTime(now);
        clientEntityMapper.insert(client);
        Long clientId = client.getClientId();
        RoleEntity role = roleEntityMapper.findByRoleId(roleId);
        ClientRoleEntity clientRoleEntity = new ClientRoleEntity();
        clientRoleMapper.insertClientRole(clientId,role.getRoleId());
    }

    @Override
    public List<SendMessageClient> listAllSendMessageClients(Integer cur, Integer size) {
        List<SendMessageClient> clients = sendMessageClientMapper.findAllSendMessageClientsByPage((cur - 1) * 10, size);
        return clients;
    }

    @Override
    public Boolean sendMessage(SendMessageDto dto) {
        String content = dto.getContent();
        String title = dto.getTitle();
        Long clientId = dto.getClientId();
        SendMessageClient sendAccount = sendMessageClientMapper.findByClientId(clientId);
        String account = sendAccount.getAccount();
        String accountPwd = sendAccount.getAccountPwd();

        List<ClientEntityDto> clients = dto.getSelectClients();
        for (ClientEntityDto client : clients) {
            String clientEmail = client.getClientEmail();
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject(title);
            message.setFrom(account);
            message.setTo(clientEmail);
            message.setSentDate(new Date());
            message.setText(content);
            javaMailSender.send(message);
        }
        return true;

    }

    private HashMap<String, Object> claimsUserInfo(ClientEntity client) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("clientName",client.getClientName());
        map.put("clientSex",client.getClientSex());
        map.put("clientId",client.getClientId());
        return map;
    }
}
