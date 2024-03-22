package com.lujiaxin.sop.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Builder
public class ClientEntityDto {

    private Long clientId;
    private String clientName;
    private String clientNickName;
    private String clientPhone;
    private String clientSex;
    private String clientEmail;
    private Boolean clientStatus;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp clientCreateTime;
    private Long clientCreateUser;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp clientUpdateTime;
    private Long clientUpdateUser;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp clientStartTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp clientEndTime;
    private Timestamp clientLastLoginTime;

}
