package com.qqq.oasys.mapper;

import com.qqq.oasys.model.schedule.ScheduleList;
import com.qqq.oasys.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Johnson
 * 2021/2/20
 */
@Repository
public interface ScheduleListMapper extends JpaRepository<ScheduleList,Long> {

    List<ScheduleList> findByUser(User user);

    List<ScheduleList> findByUsersIn(List<User> users);

}
