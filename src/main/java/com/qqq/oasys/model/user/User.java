package com.qqq.oasys.model.user;

import com.qqq.oasys.model.role.Role;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="aoa_user")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long userId;		//用户id

    @Column(name="user_name")
    private String userName;	//登录用户名

    @Column(name="user_tel")
    private String userTel;		//用户电话

    @Column(name="real_name")
    private String realName;    //真实姓名

    private String pinyin;

    private String eamil;		//邮件

    private String address;		//地址

    @Column(name="user_edu")
    private String userEdu;		//用户学历

    private Boolean superman=false;

    @Column(name="user_school")
    private String school;		//学校

    @Column(name="user_idcard")
    private String idCard;		//用户身份证

    private String bank;		//银行

    private String sex;			//性别

    @Column(name="theme_skin")
    private String themeSkin;	//主题皮肤

    private Date birth;			//生日

    @Column(name="user_sign")
    private String userSign;	//用户签名

    private String password;	//用户密码

    private String salary;		//用户薪水

    @Column(name="img_path")
    private String imgPath;		//用户头像路径

    @Column(name="hire_time")
    private Date hireTime;		//入职时间

    @Column(name="is_lock")
    private Integer isLock=0;		//该用户是否被禁用

    @Column(name="last_login_ip")
    private String lastLoginIp;	//用户最后登录ip；

    @Column(name="last_login_time")
    private Date lastLoginTime;	//最后登录时间

    @Column(name="modify_time")
    private Date modifyTime;		//最后修改时间

    @Column(name="modify_user_id")
    private Long modifyUserId;	//最后修改此用户的用户id

    @Column(name="father_id")
    private Long fatherId;		//上司id

    private Integer holiday;   //请假天数

    @ManyToOne()
    @JoinColumn(name = "position_id")
    private Position position;	//外键关联 职位表


	@ManyToOne()
	@JoinColumn(name = "dept_id")
    private Dept dept;			//外键关联 部门表
//
    @ManyToOne()
    @JoinColumn(name = "role_id")
    private Role role;			//外键关联 角色表
//
//    private List<ScheduleList> scheduleLists;
//
//    private List<Reply> replys;
//
//    private List<Discuss> discuss;
//
//    private List<Note> note;
//
//    private Set<Attends> aSet;

}
