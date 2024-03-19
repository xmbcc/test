package com.lujiaxin.sop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lujiaxin.sop.domain.ModuleEntity;
import com.lujiaxin.sop.mapper.ModuleEntityMapper;
import com.lujiaxin.sop.service.ModuleEntityService;
import org.springframework.stereotype.Service;

@Service
public class ModuleEntityServiceImpl extends ServiceImpl<ModuleEntityMapper, ModuleEntity> implements ModuleEntityService{
}
