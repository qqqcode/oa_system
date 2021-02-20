package com.qqq.oasys.mapper;


import com.qqq.oasys.model.role.RoleMenu;
import com.qqq.oasys.model.role.RolePowerList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Johnson
 * 2021/2/20
 */
@Repository
public interface RolePowerListMapper extends JpaRepository<RolePowerList, Long> {

    //找所有可显示的父菜单
    @Query("select new com.qqq.oasys.model.role.RoleMenu(menu.menuId,menu.menuName,menu.menuUrl,menu.show,role.check,menu.parentId,menu.menuIcon,menu.sortId,menu.menuGrade) "
            + "from RolePowerList as role,SystemMenu as menu where role.menuId.menuId=menu.menuId "
            + "and menu.parentId=?1 and role.roleId.roleId=?2 and menu.show=?3 and role.check=?4 order by menu.sortId")
    List<RoleMenu> findbyparentxianall(Long id, Long roleid, Boolean bo, Boolean le);

    //找所有可显示的子菜单
    @Query("select new com.qqq.oasys.model.role.RoleMenu(menu.menuId,menu.menuName,menu.menuUrl,menu.show,role.check,menu.parentId,menu.menuIcon,menu.sortId,menu.menuGrade) "
            + "from RolePowerList as role,SystemMenu as menu where role.menuId.menuId=menu.menuId "
            + "and menu.parentId!=?1 and role.roleId.roleId=?2 and menu.show=?3 and role.check=?4 order by menu.sortId")
    List<RoleMenu> findbyparentsxian(Long id,Long roleid,Boolean bo,Boolean le);

    //条件查找父菜单
    @Query("select new com.qqq.oasys.model.role.RoleMenu(menu.menuId,menu.menuName,menu.menuUrl,menu.show,role.check,menu.parentId,menu.menuIcon,menu.sortId,menu.menuGrade) "
            + "from RolePowerList as role,SystemMenu as menu where role.menuId.menuId=menu.menuId "
            + "and menu.parentId=?1 and role.roleId.roleId=?2 and menu.show=?3 and role.check=?4 and menu.menuName like %?5% order by menu.sortId")
    List<RoleMenu> findname(Long id,Long roleid,Boolean bo,Boolean le,String name);

}
