package com.qqq.oasys.mapper;

import com.qqq.oasys.model.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends JpaRepository<User, Long> {
    //名字模糊查找
    @Query("select u from User u where  (u.userName like %?1% or u.realName like %?1%) and u.fatherId=?2 ")
    Page<User> findbyFatherId(String name, Long parentid, Pageable pa);

    /*通过（用户名或者电话号码）+密码查找用户*/
    @Query("select u from User u where (u.userName = ?1 or u.userTel = ?1) and u.password =?2")
    User findOneUser(String userName,String password);
}
