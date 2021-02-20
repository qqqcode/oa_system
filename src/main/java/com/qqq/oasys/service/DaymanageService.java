package com.qqq.oasys.service;

import com.qqq.oasys.model.schedule.ScheduleList;

import java.util.List;

/**
 * @author Johnson
 * 2021/2/20
 */
public interface DaymanageService {

    List<ScheduleList> aboutmeschedule(Long userId);

}
