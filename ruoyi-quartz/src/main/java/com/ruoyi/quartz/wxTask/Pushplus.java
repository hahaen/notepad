package com.ruoyi.quartz.wxTask;

import cn.hutool.http.HttpUtil;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: Pushplus
 * @Description: Pushplus消息推送
 * @version: v1.8.0
 * @author: hahaen
 * @date: 2023/2/3 16:06
 */
@Component("pushplus")
public class Pushplus {

    public static void sendGst() {

        //您的token
        String token = "xxx";
        //消息的标题
        String title = "标题";
        //消息的内容,包含文字、换行和图片
        String content = "内容<br/><img src='http://www.pushplus.plus/doc/img/push.png' />";
        String url = "https://www.pushplus.plus/send?title=" + title + "&content=" + content + "&token=" + token;

        //服务器发送Get请求，接收响应内容
        String response = HttpUtil.get(url);
        //把返回的字符串结果变成对象
        System.out.println(response);
    }

    public static void sendPost() {

        //您的token
        String token = "xxx";
        //消息的标题
        String title = "11标题";
        //消息的内容,包含文字、换行和图片
        String content = "内容<br/><img src='http://www.pushplus.plus/doc/img/push.png' />";
        String url = "https://www.pushplus.plus/send/";

        PpContent ppContent = new PpContent();

        ppContent.setToken(token);
        ppContent.setTitle(title);
        ppContent.setContent(content);


        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("title", title);
        map.put("content", content);

        //服务器发送POST请求，接收响应内容
        String response = HttpUtil.post(url, BeanMap.create(ppContent));

        System.out.println(response);

    }


    public static void main(String[] args) {
        sendPost();
    }

}
