package com.ruoyi.quartz.wxTask;

import lombok.Data;

/**
 * @className: PpContent
 * @Description: pushplus消息实体类
 * @version: v1.8.0
 * @author: hahaen
 * @date: 2023/2/3 16:45
 */
@Data
public class PpContent {
    /**
     * 用户令牌，可直接加到请求地址后(是)
     */
    private String token;

    /**
     * 消息标题
     */
    private String title;

    /**
     * 具体消息内容，根据不同template支持不同格式(是)
     */
    private String content;


    /**
     * 群组编码，不填仅发送给自己；channel为webhook时无效
     */
    private String topic;

    /**
     * 发送模板
     */
    private String template;

    /**
     * 发送渠道
     */
    private String channel;

    /**
     * 	webhook编码
     */
    private String webhook;

    /**
     * 发送结果回调地址
     */
    private String callbackUrl;

    /**
     * 毫秒时间戳
     */
    private String timestamp;

    /**
     * 好友令牌，微信公众号渠道填写好友令牌，企业微信渠道填写企业微信用户id
     */
    private String to;

}
