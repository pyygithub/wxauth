/**
 * Copyright (C), 2015-2018, XXX有限公司
 * 项目名称:
 * 文件名称:
 * 作者: wolf
 * 日期: 2018/5/31 17:37
 * 描述:
 * 版本: V1.0
 */
package com.pyy.wxauth.controller;

import com.pyy.wxauth.util.AuthUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户Controller
 *
 * @author wolf
 * @create 2018/5/31
 * @since 1.0.0
 */
@RestController
public class UserController {

    public ResponseEntity login() {
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize"
                + "?appid=" + AuthUtil.APPID
                + "&redirect_uri=REDIRECT_URI"
                + "&response_type=code"
                + "&scope=SCOPE"
                + "&state=STATE#wechat_redirect";

        return new ResponseEntity("0", HttpStatus.OK);
    }
}