package com.qqq.oasys.model.role;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;

/**
 * @author Johnson
 * 2021/2/20
 */
@Data
@AllArgsConstructor
public class RoleMenu {
    private Long menuId; // 菜单id

    private String menuName; // 菜单名字

    private String menuUrl; // 菜单链接

    @Column(name = "is_show")
    private Boolean show = false; // 菜单是否显示

    @Column(name = "is_show")
    private Boolean check = false; // 是否分配资源

    private Long parentId;

    private String menuIcon; // 菜单图标

    private Integer sortId; // 菜单排序id

    private Integer menuGrade; // 权限值分数
}
