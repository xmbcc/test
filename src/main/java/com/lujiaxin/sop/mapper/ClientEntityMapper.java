package com.lujiaxin.sop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lujiaxin.sop.domain.ClientEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Repository
@Mapper
public interface ClientEntityMapper extends BaseMapper<ClientEntity> {

    @Select("select * from client where client_name = #{clientName}")
    ClientEntity findByClientName(String clientName);

    @Select("select * from client limit #{cur},#{size}")
    List<ClientEntity> findAllByPage(@Param("cur") Integer cur,@Param("size") Integer size);

    @Select("select * from client where client_id = #{clientId}")
    ClientEntity findByClientId(@Param("clientId") Long clientId);
}
