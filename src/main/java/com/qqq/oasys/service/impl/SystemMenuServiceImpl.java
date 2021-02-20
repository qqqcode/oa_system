package com.qqq.oasys.service.impl;

import com.qqq.oasys.mapper.RolePowerListMapper;
import com.qqq.oasys.model.role.RoleMenu;
import com.qqq.oasys.model.user.User;
import com.qqq.oasys.service.SystemMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Johnson
 * 2021/2/20
 */
@Service
public class SystemMenuServiceImpl implements SystemMenuService {

    @Autowired
    private RolePowerListMapper rolePowerListMapper;

    @Override
    public void findMenuSys(HttpServletRequest req, User user) {
        List<RoleMenu> oneMenuAll = rolePowerListMapper.findbyparentxianall(0L, user.getRole().getRoleId(), true, true);
        List<RoleMenu> twoMenuAll = rolePowerListMapper.findbyparentsxian(0L, user.getRole().getRoleId(), true, true);
        req.setAttribute("oneMenuAll", oneMenuAll);
        req.setAttribute("twoMenuAll", twoMenuAll);
    }
}
