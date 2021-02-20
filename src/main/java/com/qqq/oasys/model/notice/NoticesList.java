package com.qqq.oasys.model.notice;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Johnson
 * 2021/2/20
 */
@Entity
@Table(name = "aoa_notice_list")
@Data
@NoArgsConstructor
public class NoticesList {

    @Id
    @Column(name = "notice_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noticeId; // 通知id

    @Column(name = "user_id")
    private Long userId; // 用户id

    @Column(name = "type_id")
    private Long typeId; // 类型id

    @Column(name = "status_id")
    private Long statusId; // 状态id

    private String title; // 通知标题

    private String content; // 通知内容

    private String url; // 通知内的链接

    @Column(name = "is_top")
    private Boolean top = false; //该调通知是否置顶

    @Column(name = "notice_time")
    private Date noticeTime; // 发布通知的时间

    @Column(name = "modify_time")
    private Date modifyTime = new Date(); // 修改时间
}
