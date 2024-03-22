package com.lujiaxin.sop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 发送任务参数
 * @author lujiaxin
 * @date 2024/3/21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SendMessageDto {

    /**
     * 发送账号id
     */
    private Long clientId;

    /**
     * 发送方式
     * email
     */
    private String sendType;

    /**
     * 邮件标题
     */
    private String title;

    /**
     * 邮件内容
     */
    private String content;

    /**
     * 勾选发送目标
     */
    private List<ClientEntityDto> selectClients;

}
