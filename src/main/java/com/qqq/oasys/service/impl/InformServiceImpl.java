package com.qqq.oasys.service.impl;

import com.qqq.oasys.mapper.NoticesListMapper;
import com.qqq.oasys.model.notice.NoticesList;
import com.qqq.oasys.service.InformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Johnson
 * 2021/2/20
 */
@Service
public class InformServiceImpl implements InformService {

    @Autowired
    private NoticesListMapper noticesListMapper;

    @Override
    public NoticesList save(NoticesList noticelist) {
        return noticesListMapper.save(noticelist);
    }

}
