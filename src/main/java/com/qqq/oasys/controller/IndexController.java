package com.qqq.oasys.controller;

import com.qqq.oasys.mapper.ScheduleListMapper;
import com.qqq.oasys.mapper.UserLogMapper;
import com.qqq.oasys.mapper.UserMapper;
import com.qqq.oasys.model.notice.NoticeUserRelation;
import com.qqq.oasys.model.notice.NoticesList;
import com.qqq.oasys.model.schedule.ScheduleList;
import com.qqq.oasys.model.user.User;
import com.qqq.oasys.model.user.UserLog;
import com.qqq.oasys.service.DaymanageService;
import com.qqq.oasys.service.InformRelationService;
import com.qqq.oasys.service.InformService;
import com.qqq.oasys.service.SystemMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserLogMapper userLogMapper;
    @Autowired
    private ScheduleListMapper scheduleListMapper;

    @Autowired
    private SystemMenuService systemMenuService;
    @Autowired
    private DaymanageService daymanageService;
    @Autowired
    private InformService informService;
    @Autowired
    private InformRelationService informRelationService;

    @RequestMapping("index")
    public String index(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        if (StringUtils.isEmpty(session.getAttribute("userId"))) {
            return "login/login";
        }
        Long userId = Long.parseLong(session.getAttribute("userId") + "");
        User user = userMapper.getOne(userId);
        systemMenuService.findMenuSys(request, user);
        logger.info("{}用户登录", user.getUserName());

        List<ScheduleList> aboutMyNotice = daymanageService.aboutmeschedule(userId);
        for (ScheduleList scheduleList : aboutMyNotice) {
            if (scheduleList.getIsreminded() != null && !scheduleList.getIsreminded()) {
                logger.info("{}", scheduleList.getStartTime());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");//24小时制
                String start = simpleDateFormat.format(scheduleList.getStartTime());
                String now = simpleDateFormat.format(new Date());
                try {
                    long now2 = simpleDateFormat.parse(now).getTime();
                    long start2 = simpleDateFormat.parse(start).getTime();
                    long cha = start2 - now2;
                    if (0 < cha && cha < 86400000) {
                        NoticesList remindNotices = new NoticesList();
                        remindNotices.setTypeId(11l);
                        remindNotices.setStatusId(15l);
                        remindNotices.setTitle("您有一个日程即将开始");
                        remindNotices.setUrl("/daycalendar");
                        remindNotices.setUserId(userId);
                        remindNotices.setNoticeTime(new Date());

                        NoticesList remindNoticeOk = informService.save(remindNotices);

                        informRelationService.save(new NoticeUserRelation(remindNoticeOk, user, false));

                        scheduleList.setIsreminded(true);
                        scheduleListMapper.save(scheduleList);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }

        model.addAttribute("notice", 6);
        model.addAttribute("mail", 6);
        model.addAttribute("task", 6);
        model.addAttribute("user", user);
        List<UserLog> userLogs = userLogMapper.findByUser(userId);
        request.setAttribute("userLogList", userLogs);
        return "index/index";
    }
}
