package com.lujiaxin.sop.controller;

import com.lujiaxin.sop.R.R;
import com.lujiaxin.sop.commons.CommonsCode;
import com.lujiaxin.sop.domain.RoleEntity;
import com.lujiaxin.sop.mapper.RoleEntityMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.annotation.Repeatable;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/Role")
public class RoleController {

    @Resource
    private RoleEntityMapper roleEntityMapper;

    @PostMapping("/list")
    public R getRoleList(@RequestParam("page") Integer page,@RequestParam("limit") Integer limit){
        List<RoleEntity> all = roleEntityMapper.findAllByPage((page - 1) * 10, limit);
        int size = all.size();
        if(all == null || size == 0){
            return R.fail(CommonsCode.REQ_FIAL_CODE,false,"查询列表出错");
        }

        return R.successs(all,CommonsCode.REQ_SUCCESS_CODE,size);
    }

}
