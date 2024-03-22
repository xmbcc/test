package com.lujiaxin.sop.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 接受查询配置信息的请求类
 * @author lujiaxin
 * @date 2024/3/21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConfigRequestDto {

    /**
     * 筛选类型：
     * 个人
     * 全部
     */
    private String selectType;

    /**
     * 渠道类型：
     * 邮件......
     */
    private String configType;

    private Integer page;

    private Integer limit;

    @Override
    public String toString() {
        return "ConfigRequestDto{" +
                "selectType='" + selectType + '\'' +
                ", configType='" + configType + '\'' +
                '}';
    }
}
