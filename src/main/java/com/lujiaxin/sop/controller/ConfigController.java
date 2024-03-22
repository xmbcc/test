package com.lujiaxin.sop.controller;

import com.lujiaxin.sop.R.R;
import com.lujiaxin.sop.commons.CommonsCode;
import com.lujiaxin.sop.domain.SendAccountConfig;
import com.lujiaxin.sop.domain.dto.ConfigRequestDto;
import com.lujiaxin.sop.service.ConfigSerivce;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "/config")
public class ConfigController {

    private final ConfigSerivce configSerivce;

    public ConfigController(ConfigSerivce configSerivce){
        this.configSerivce = configSerivce;
    }


    @ApiOperation(value = "获取配置信息")
    @GetMapping("/getAllConfig")
    public R getAllConfig(@RequestParam(value = "selectType",required = false) String selectType,
                          @RequestParam(value = "configType",required = false) String configType,
                          @RequestParam(value = "page",required = false) Integer page,
                          @RequestParam(value = "limit",required = false) Integer limit,
                          @RequestHeader(value = "Authorization") String token){

        ConfigRequestDto dto = new ConfigRequestDto();
        Optional.ofNullable(selectType).ifPresent(dto::setSelectType);
        Optional.ofNullable(configType).ifPresent(dto::setConfigType);
        Optional.ofNullable(page).ifPresent(dto::setPage);
        Optional.ofNullable(limit).ifPresent(dto::setLimit);

        try {
            List<SendAccountConfig> list = configSerivce.getAllConfig(dto,token);
            int size = list.size();
            return R.successs(list,CommonsCode.REQ_SUCCESS_CODE,size);
        }catch (Exception e){
            log.error("system has catch a expection params:{} excrption:{}", dto,e.getMessage());
            return R.fail(CommonsCode.REQ_FIAL_CODE,false,"查询列表出错");
        }

    }

//    @ApiOperation(value = "添加配置信息")
//    @PostMapping("/addConfig")
//    public R addConfig(){
//
//    }

}
