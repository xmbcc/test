package com.lujiaxin.sop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lujiaxin.sop.commons.CommonsCode;
import com.lujiaxin.sop.domain.ClientEntity;
import com.lujiaxin.sop.domain.SendAccountConfig;
import com.lujiaxin.sop.domain.dto.ConfigRequestDto;
import com.lujiaxin.sop.mapper.ConfigMapper;
import com.lujiaxin.sop.service.ClientEntityService;
import com.lujiaxin.sop.service.ConfigSerivce;
import com.lujiaxin.sop.util.TokenUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, SendAccountConfig> implements ConfigSerivce {

    private final ConfigMapper configMapper;

    private final ClientEntityService clientEntityService;

    public ConfigServiceImpl(ConfigMapper configMapper,ClientEntityService clientEntityService){
        this.configMapper = configMapper;
        this.clientEntityService = clientEntityService;
    }

    @Override
    public List<SendAccountConfig> getAllConfig(ConfigRequestDto dto,String token) throws Exception {
        String configType = dto.getConfigType();
        Integer limit = dto.getLimit();
        Integer page = dto.getPage();
        String selectType = dto.getSelectType();

        Long clientId = TokenUtil.getClientIdByToken(token);
        if(!Optional.ofNullable(clientId).isPresent()){
            throw new Exception("登录用户id解析错误！");
        }

        ClientEntity client = clientEntityService.getById(clientId);
        if(!Optional.ofNullable(client).isPresent()){
            throw new Exception("登录用户解析错误！");
        }

        QueryWrapper<SendAccountConfig> wrapper = new QueryWrapper<>();
        IPage<SendAccountConfig> iPage = new Page<>();
        iPage.setCurrent(page);
        iPage.setSize(limit);

        if(Optional.ofNullable(selectType).isPresent()){
            if(selectType.equals(CommonsCode.SELECT_MYCONFIG)){
                wrapper.eq("client_id",clientId);
            }
        }

        Optional.ofNullable(configType).ifPresent(c -> wrapper.eq("type",c));

        return configMapper.selectList(iPage,wrapper);
    }
}
