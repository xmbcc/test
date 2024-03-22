package com.lujiaxin.sop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lujiaxin.sop.domain.SendMessageClient;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SendMessageClientMapper extends BaseMapper<SendMessageClient> {

    @Select("select * from send_message_client limit #{cur},#{size}")
    List<SendMessageClient> findAllSendMessageClientsByPage(@Param("cur") int cur, @Param("size") Integer size);

    @Select("select * from send_message_client where client_id = #{clientId}")
    SendMessageClient findByClientId(@Param("clientId") Long clientId);
}
