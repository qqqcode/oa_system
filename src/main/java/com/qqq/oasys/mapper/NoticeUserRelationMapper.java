package com.qqq.oasys.mapper;

import com.qqq.oasys.model.notice.NoticeUserRelation;
import com.qqq.oasys.model.notice.NoticesList;
import com.qqq.oasys.model.user.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Johnson
 * 2021/2/20
 */
@Repository
public interface NoticeUserRelationMapper extends PagingAndSortingRepository<NoticeUserRelation, Long> {

    //根据用户找到通知联系人中间的集合
    List<NoticeUserRelation> findByUserId(User userId);

    //找到该用户未读的消息
    List<NoticeUserRelation> findByReadAndUserId(Boolean read,User userid);

    //根据通知找到所有的通知联系表中的集合
    List<NoticeUserRelation> findByNoticeId(NoticesList notice);

    //根据用户id和通知id找到唯一的对象
    NoticeUserRelation findByUserIdAndNoticeId(User userId, NoticesList notice);
}
