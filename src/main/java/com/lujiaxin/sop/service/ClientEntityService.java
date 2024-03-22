package com.lujiaxin.sop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lujiaxin.sop.domain.*;

import java.util.List;

public interface ClientEntityService extends IService<ClientEntity> {
    String login(LoginUserInfo userInfo);

    List<ClientEntityDto> listAll(Integer cur, Integer size);

    void saveClients(ClientEntity client, Long roleId);

    List<SendMessageClient> listAllSendMessageClients(Integer cur, Integer size);

    Boolean sendMessage(SendMessageDto dto);
}
