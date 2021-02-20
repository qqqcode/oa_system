package com.qqq.oasys.service;

import com.qqq.oasys.model.user.User;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Johnson
 * 2021/2/20
 */
public interface SystemMenuService {

    void findMenuSys(HttpServletRequest req, User user);

}
