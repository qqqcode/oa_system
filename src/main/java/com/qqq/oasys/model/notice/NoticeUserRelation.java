package com.qqq.oasys.model.notice;

import com.qqq.oasys.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Johnson
 * 2021/2/20
 */
@Entity
@Table(name = "aoa_notice_user_relation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticeUserRelation {

    @Id
    @Column(name = "relatin_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noticeUserRelatinId;	//用户与通知中间关联表主键id


    @ManyToOne
    @JoinColumn(name = "relatin_notice_id")
    private NoticesList noticeId;				//通知id

    @ManyToOne
    @JoinColumn(name = "relatin_user_id")
    private User userId;				//用户id

    @Column(name = "is_read")
    private Boolean read=false;				//此条通知该用户是否一已读

    public NoticeUserRelation(NoticesList noticeId, User userId, Boolean read) {
        this.noticeId = noticeId;
        this.userId = userId;
        this.read = read;
    }
}
