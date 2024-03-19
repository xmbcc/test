package com.lujiaxin.sop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lujiaxin.sop.domain.ClientEntity;
import com.lujiaxin.sop.domain.LoginUserInfo;

public interface ClientEntityService extends IService<ClientEntity> {
    String login(LoginUserInfo userInfo);
}
