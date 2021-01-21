package com.qqq.oasys.model.dao;

import com.qqq.oasys.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserDao extends JpaRepository<User, Long> {

    //名字模糊查找
    @Query("select u from User u where  (u.userName like %?1% or u.realName like %?1%) and u.fatherId=?2 ")
    Page<User> findbyFatherId(String name,Long parentid,Pageable pa);
}
