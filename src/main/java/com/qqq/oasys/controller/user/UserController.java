package com.qqq.oasys.controller.user;


import com.qqq.oasys.common.result.ResultData;
import com.qqq.oasys.mapper.UserMapper;
import com.qqq.oasys.model.dao.UserDao;
import com.qqq.oasys.model.entity.User;
import com.qqq.oasys.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDao userDao;

    @RequestMapping("/userlogmanage")
    public ResultData<String> userlogmanage() {
        return ResultUtils.getResultData("user/userlogmanger");
    }

    @RequestMapping("/usermanage")
    public ResultData<String> usermanage(HttpServletRequest request) {
        return ResultUtils.getResultData("user/userlogmanger");
    }

    @RequestMapping("/showAllUsers")
    public ResultData<List<User>> showAllUsers(HttpServletRequest request) {
        //List<User> users = userMapper.selectList(null);
        List<User> users = userDao.findAll();
        return ResultUtils.getResultData(users);
    }
}
