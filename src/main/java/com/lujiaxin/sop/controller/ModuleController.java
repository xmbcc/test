package com.lujiaxin.sop.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lujiaxin.sop.R.R;
import com.lujiaxin.sop.domain.ModuleDto;
import com.lujiaxin.sop.domain.ModuleEntity;
import com.lujiaxin.sop.mapper.ModuleEntityMapper;
import com.lujiaxin.sop.service.ModuleEntityService;
import com.lujiaxin.sop.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Module")
@Slf4j
public class ModuleController {

    @Autowired
    private ModuleEntityService moduleEntityService;

    @Autowired
    private ModuleEntityMapper moduleEntityMapper;

    @PostMapping("/list")
    public R getModuleLists(){
        Page<ModuleEntity> page = new Page<>();
        page.setCurrent(1);
        page.setSize(10);
        QueryWrapper<ModuleEntity> wrapper = new QueryWrapper<>();
        wrapper.isNull("parent_id");
        List<ModuleEntity> list = moduleEntityService.list(page, wrapper);

        ArrayList<ModuleDto> result = new ArrayList<>();

        for (ModuleEntity module : list) {
            Long moduleId = module.getModuleId();
            List<ModuleEntity> subNodes = moduleEntityService.lambdaQuery().eq(ModuleEntity::getParentId, moduleId).list();
            ModuleDto dto = new ModuleDto();
            BeanUtils.copyProperties(module,dto);
            dto.setModuleNodes(subNodes);
            result.add(dto);
        }

        return R.successs(result,200,10);
    }

    @PostMapping("/nodes")
    public R getModuleLists(@RequestParam("page")Integer page,@RequestParam("limit") Integer limit){
        Page<ModuleEntity> pageEntity = new Page<>();
        pageEntity.setCurrent(page);
        pageEntity.setSize(limit);
        QueryWrapper<ModuleEntity> wrapper = new QueryWrapper<>();
        wrapper.isNull("parent_id");
        List<ModuleEntity> list = moduleEntityService.list(pageEntity, wrapper);

        ArrayList<ModuleDto> result = new ArrayList<>();

        for (ModuleEntity module : list) {
            Long moduleId = module.getModuleId();
            List<ModuleEntity> subNodes = moduleEntityService.lambdaQuery().eq(ModuleEntity::getParentId, moduleId).list();
            ModuleDto dto = new ModuleDto();
            BeanUtils.copyProperties(module,dto);
            dto.setModuleNodes(subNodes);
            result.add(dto);
        }

        return R.successs(result,200,10);
    }

    @GetMapping("/get/{moduleId}")
    public R getNodeDetail(@PathVariable("moduleId") Long moduleId){
        ModuleEntity module = moduleEntityService.getById(moduleId);
        return R.successs(module,200,1);

    }

    @PostMapping("/save")
    public R save(@RequestParam("parentId")Long parentId,@RequestParam("moduleIcon") String moduleIcon,
                  @RequestParam("moduleOrder") Integer moduleOrder,@RequestParam("moduleUrl") String moduleUrl,
                  @RequestParam("moduleName") String moduleName){
        ModuleEntity moduleEntity = ModuleEntity.builder().moduleName(moduleName).parentId(parentId).moduleIcon(moduleIcon).moduleOrder(moduleOrder).moduleUrl(moduleUrl).build();
        moduleEntityService.save(moduleEntity);
        return R.successs(null,200,1);
    }
}
