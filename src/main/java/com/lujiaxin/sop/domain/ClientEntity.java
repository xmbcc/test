package com.lujiaxin.sop.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientEntity implements Serializable {

        @TableId(value = "client_id",type = IdType.AUTO)
        private Long clientId;
        @TableField("client_name")
        private String clientName;
        @TableField("client_nick_name")
        private String clientNickName;
        @TableField("client_phone")
        private String clientPhone;
        @TableField("client_sex")
        private Boolean sex;
        @TableField("client_email")
        private String email;
        @TableField("client_feishu_open_id")
        private String feishuOpenId;
        @TableField("client_password")
        private String clientPassword;
        @TableField("client_status")
        private Boolean clientStatus;
        @TableField("client_create_time")
        private Timestamp clientCreateTime;
        @TableField("client_create_user")
        private Long clientCreateUser;
        @TableField("client_update_time")
        private Timestamp clientUpdateTime;
        @TableField("client_update_user")
        private Long clientUpdateUser;
        @TableField("client_start_time")
        private Timestamp clientStartTime;
        @TableField("client_end_time")
        private Timestamp clientEndTime;
        @TableField("client_last_login_time")
        private Timestamp clientLastLoginTime;

}
