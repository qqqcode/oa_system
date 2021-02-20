package com.qqq.oasys.model.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Johnson
 * 2021/2/20
 */
@Entity
@Table(name = "aoa_dept")
@Data
@NoArgsConstructor
public class Dept {
    @Id
    @Column(name = "dept_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deptId;    //部门id

    @Column(name = "dept_name")
    private String deptName;    //部门名字  非空 唯一

    @Column(name = "dept_tel")
    private String deptTel;        //部门电话

    @Column(name = "dept_fax")
    private String deptFax;        //部门传真

    private String email;        //部门email

    @Column(name = "dept_addr")
    private String deptAddr;    //部门地址

    private Long deptmanager;

}
