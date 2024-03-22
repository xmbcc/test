package com.lujiaxin.sop.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lujiaxin.sop.R.R;
import com.lujiaxin.sop.commons.CommonsCode;
import com.lujiaxin.sop.domain.ClientEntity;
import com.lujiaxin.sop.domain.ClientEntityDto;
import com.lujiaxin.sop.domain.SendMessageClient;
import com.lujiaxin.sop.domain.SendMessageDto;
import com.lujiaxin.sop.service.ClientEntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RequestMapping("/User")
@RestController
public class ClientController {

    @Resource
    private ClientEntityService clientEntityService;

    @PostMapping("/list")
    public R getClientList(@RequestParam("page") Integer cur,@RequestParam("limit") Integer size){

        List<ClientEntityDto> dtos = clientEntityService.listAll(cur, size);
        int length = dtos.size();
        if(dtos == null || length == 0){
            return R.fail(CommonsCode.REQ_FIAL_CODE,false,"查询列表出错");
        }

        return R.successs(dtos,CommonsCode.REQ_SUCCESS_CODE,length);
    }

    @PostMapping("/save")
    public R saveClient(@RequestParam("userName") String clientNickName,
                        @RequestParam("userRealName") String clientName,
                        @RequestParam("roleId") Long roleId,
                        @RequestParam("userMobile") String clientPhone,
                        @RequestParam("userEmail") String clientEmail,
                        @RequestParam("userSex") String clientSex){

        if(clientSex == null || StringUtils.isEmpty(clientSex)){
            return R.fail(CommonsCode.REQ_FIAL_CODE,false,"保存失败,信息不完全");
        }

        Boolean sex = clientSex.equals(CommonsCode.MAN) ? true : false;

        ClientEntity client = ClientEntity.builder().clientName(clientNickName)
                .clientNickName(clientName)
                .clientEmail(clientEmail)
                .clientPhone(clientPhone)
                .clientSex(sex)
                .build();

        clientEntityService.saveClients(client,roleId);

        return R.successs(null,CommonsCode.REQ_SUCCESS_CODE,0);

    }

    @PostMapping("/sendMessageClientList")
    public R getSendMessageClientList(@RequestParam("page") Integer cur,@RequestParam("limit") Integer size){

        List<SendMessageClient> dtos = clientEntityService.listAllSendMessageClients(cur, size);
        int length = dtos.size();
        if(dtos == null || length == 0){
            return R.fail(CommonsCode.REQ_FIAL_CODE,false,"查询列表出错");
        }

        return R.successs(dtos,CommonsCode.REQ_SUCCESS_CODE,length);
    }

    @PostMapping("/sendMessage")
    public R getSendMessage(@RequestParam("clientId") Long clientId,
                            @RequestParam("sendType") String sendType,
                            @RequestParam("content") String content,
                            @RequestParam("title") String title,
                            @RequestParam("selectClients") String json){

        SendMessageDto dto = SendMessageDto.builder()
                .clientId(clientId)
                .sendType(sendType)
                .content(content)
                .title(title)
                .selectClients(JSON.parseArray(json, ClientEntityDto.class))
                .build();
        Boolean res = clientEntityService.sendMessage(dto);
        return R.successs(null,CommonsCode.REQ_SUCCESS_CODE,0);
    }

}
