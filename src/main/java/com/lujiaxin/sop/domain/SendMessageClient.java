package com.lujiaxin.sop.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName(value = "send_message_client")
public class SendMessageClient {

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    @TableField(value = "client_name")
    private String clientName;
    @TableField(value = "client_id")
    private Long clientId;
    @TableField(value = "account")
    private String account;
    @TableField(value = "account_pwd")
    private String accountPwd;
    @TableField(value = "type")
    private String type;

}
