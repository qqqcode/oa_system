package com.qqq.oasys.model.system;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Johnson
 * 2021/2/20
 */
@Data
@Entity
@Table(name = "aoa_sys_menu")
public class SystemMenu {
    @Id
    @Column(name = "menu_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuId; // 菜单id

    @Column(name = "parent_id")
    private Long parentId = 0L; // 父id

    @Column(name = "menu_name")
    private String menuName; // 菜单名字

    @Column(name = "menu_url")
    private String menuUrl; // 菜单链接

    @Column(name = "menu_icon")
    private String menuIcon; // 菜单图标

    @Column(name = "sort_id")
    private Integer sortId = 999; // 菜单排序id

    @Column(name = "is_show")
    private Boolean show = false; // 菜单是否显示

    @Column(name = "menu_grade")
    private Integer menuGrade; // 权限值分数

}
