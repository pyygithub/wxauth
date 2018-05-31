/**
 * Copyright (C), 2015-2018, XXX有限公司
 * 项目名称:
 * 文件名称:
 * 作者: wolf
 * 日期: 2018/5/31 16:15
 * 描述:
 * 版本: V1.0
 */
package com.pyy.wxauth.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * 微信认证auth工具类
 *
 * @author wolf
 * @create 2018/5/31
 * @since 1.0.0
 */
public class AuthUtil {

    private static Logger logger = LoggerFactory.getLogger(AuthUtil.class);


    public static final String APPID = "wxfa24f3e0742394d6";//开发者ID

    public static final String APPSECRET = "ef0b949bc85c069af5e9ded6648da296";//开发者密码


    /**
     * httpClient get请求
     * @param url
     * @return
     * @throws IOException
     */
    public static JSONObject doGetJSON(String url) throws IOException {
        JSONObject jsonObject = null;
        CloseableHttpResponse response = null;
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            response = httpclient.execute(httpGet);

            //建立的http连接，仍旧被response保持着，允许我们从网络socket中获取返回的数据
            //为了释放资源，我们必须手动消耗掉response或者取消连接（使用CloseableHttpResponse类的close方法）

            HttpEntity entity = response.getEntity();
            if(entity != null) {
                String result = EntityUtils.toString(entity, "utf-8");
                // do something useful with the response body
                // and ensure it is fully consumed
                EntityUtils.consume(entity);
                jsonObject = JSONObject.parseObject(result);
                logger.debug("get请求发送完毕：{}", result);
            }
        }catch(Exception e) {
            logger.error("get请求异常");
            e.printStackTrace();
        } finally {
            response.close();
        }
        return jsonObject;
    }
}