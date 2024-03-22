package com.lujiaxin.sop.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
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
@TableName(value = "client")
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
        private Boolean clientSex;
        @TableField("client_email")
        private String clientEmail;
        @TableField("client_feishu_open_id")
        private String feishuOpenId;
        @TableField("client_password")
        private String clientPassword;
        @TableField("client_status")
        private Boolean clientStatus;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        @TableField("client_create_time")
        private Timestamp clientCreateTime;
        @TableField("client_create_user")
        private Long clientCreateUser;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        @TableField("client_update_time")
        private Timestamp clientUpdateTime;
        @TableField("client_update_user")
        private Long clientUpdateUser;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        @TableField("client_start_time")
        private Timestamp clientStartTime;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        @TableField("client_end_time")
        private Timestamp clientEndTime;
        @TableField("client_last_login_time")
        private Timestamp clientLastLoginTime;

}
