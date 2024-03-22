package com.lujiaxin.sop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lujiaxin.sop.domain.ClientRoleEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ClientRoleMapper extends BaseMapper<ClientRoleEntity> {

    @Insert("insert into client_role value(#{clientId},#{roleId})")
    public void insertClientRole(@Param("clientId") Long clientId,@Param("roleId") Long roleId);
}
