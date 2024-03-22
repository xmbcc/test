package com.lujiaxin.sop.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.lujiaxin.sop.domain.SendAccountConfig;
import com.lujiaxin.sop.domain.dto.ConfigRequestDto;

import java.util.List;

public interface ConfigSerivce extends IService<SendAccountConfig> {
    List<SendAccountConfig> getAllConfig(ConfigRequestDto dto,String token) throws Exception;
}
