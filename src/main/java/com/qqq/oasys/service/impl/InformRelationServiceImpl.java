package com.qqq.oasys.service.impl;

import com.qqq.oasys.mapper.NoticeUserRelationMapper;
import com.qqq.oasys.model.notice.NoticeUserRelation;
import com.qqq.oasys.service.InformRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Johnson
 * 2021/2/20
 */
@Service
public class InformRelationServiceImpl implements InformRelationService {

    @Autowired
    private NoticeUserRelationMapper noticeUserRelationMapper;

    public NoticeUserRelation save(NoticeUserRelation noticeRelation) {
        return noticeUserRelationMapper.save(noticeRelation);
    }

}
