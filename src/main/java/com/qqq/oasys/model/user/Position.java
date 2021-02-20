package com.qqq.oasys.model.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Johnson
 * 2021/2/20
 */
@Entity
@Table(name = "aoa_position")
@Data
@NoArgsConstructor
public class Position {

    @Id
    @Column(name = "position_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;	//职位id

    @Column(unique = true)
    private String name;	//职位名称。

    private Integer level;	//职位层级

    private String describtion;//职位描述

    private Long deptid;

}
