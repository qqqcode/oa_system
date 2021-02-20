package com.qqq.oasys.service.impl;

import com.qqq.oasys.mapper.ScheduleListMapper;
import com.qqq.oasys.mapper.UserMapper;
import com.qqq.oasys.model.schedule.ScheduleList;
import com.qqq.oasys.model.user.User;
import com.qqq.oasys.service.DaymanageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnson
 * 2021/2/20
 */
@Service
public class DaymanageServiceImpl implements DaymanageService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ScheduleListMapper scheduleListMapper;


    @Override
    public List<ScheduleList> aboutmeschedule(Long userId){

        User user = userMapper.getOne(userId);
        List<User> users = new ArrayList<>();
        users.add(user);
        List<ScheduleList> aboutmerc = new ArrayList<>();

        List<ScheduleList> myschedule = scheduleListMapper.findByUser(user);
        List<ScheduleList> otherschedule = scheduleListMapper.findByUsersIn(users);

        for (ScheduleList scheduleList : myschedule) {
            aboutmerc.add(scheduleList);
        }

        for (ScheduleList scheduleList : otherschedule) {
            aboutmerc.add(scheduleList);
        }

        for (ScheduleList scheduleList : aboutmerc) {
            User user1 = scheduleList.getUser();
            scheduleList.setUsername(user1.getRealName());

        }

        return aboutmerc;
    }

}
