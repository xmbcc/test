package com.lujiaxin.sop.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lujiaxin.sop.domain.ClientEntity;
import com.lujiaxin.sop.domain.LoginUserInfo;
import com.lujiaxin.sop.mapper.ClientEntityMapper;
import com.lujiaxin.sop.service.ClientEntityService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Optional;

@Service
public class ClientEntityServiceImpl extends ServiceImpl<ClientEntityMapper, ClientEntity> implements ClientEntityService {

    @Autowired
    private ClientEntityMapper clientEntityMapper;

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

    private HashMap<String, Object> claimsUserInfo(ClientEntity client) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("clientName",client.getClientName());
        map.put("clientSex",client.getSex());
        map.put("clientId",client.getClientId());
        return map;
    }
}
