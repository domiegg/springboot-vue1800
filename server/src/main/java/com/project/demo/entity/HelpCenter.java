package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 帮助中心：(HelpCenter)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "HelpCenter")
public class HelpCenter implements Serializable {

    // HelpCenter编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "help_center_id")
    private Integer help_center_id;

    // 帮助封面
    @Basic
    private String help_cover;
    // 帮助主题
    @Basic
    private String help_topics;
    // 帮助详情
    @Basic
    private String help_details;

    // 点击数
    @Basic
    private Integer hits;

    // 点赞数
    @Basic
    private Integer praise_len;












    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
