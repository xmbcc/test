package com.lujiaxin.sop.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 配置信息统一类
 * @author lujiaxin
 * @date 2024/3/21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName(value = "send_account_config")
public class SendAccountConfig {

    @TableField(value = "client_id")
    private Long clientId;

    @TableField(value = "type")
    private String type;

    @TableField(value = "config")
    private String config;

}
