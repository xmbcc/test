package com.lujiaxin.sop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lujiaxin.sop.domain.ClientEntity;
import com.lujiaxin.sop.domain.RoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RoleEntityMapper extends BaseMapper<RoleEntity> {

    @Select("select * from role where role_name = #{roleName}")
    RoleEntity findByRoleName(String roleName);

    @Select("select * from role limit #{cur},#{size}")
    List<RoleEntity> findAllByPage(@Param("cur") Integer cur, @Param("size") Integer size);

    @Select("select * from role where role_id = #{roleId}")
    RoleEntity findByRoleId(@Param("roleId") Long roleId);
}

