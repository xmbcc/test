package com.lujiaxin.sop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lujiaxin.sop.domain.ClientEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ClientEntityMapper extends BaseMapper<ClientEntity> {

    @Select("select * from client where client_name = #{clientName}")
    ClientEntity findByClientName(String clientName);
}
