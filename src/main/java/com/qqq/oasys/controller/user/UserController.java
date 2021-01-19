package com.qqq.oasys.controller.user;


import com.github.pagehelper.Page;

import com.qqq.oasys.common.result.ResultData;
import com.qqq.oasys.utils.ResultUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/userlogmanage")
    public ResultData<String> userlogmanage() {
        return ResultUtils.getResultData("user/userlogmanger");
    }

    @RequestMapping("/usermanage")
    public ResultData<String> usermanage(HttpServletRequest request) {
        return ResultUtils.getResultData("user/userlogmanger");
    }
}
