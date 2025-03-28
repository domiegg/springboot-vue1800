package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 会员中心：(MemberCenter)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "MemberCenter")
public class MemberCenter implements Serializable {

    // MemberCenter编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_center_id")
    private Integer member_center_id;

    // 用户账号
    @Basic
    private Integer user_account;
    // 用户姓名
    @Basic
    private String user_name;
    // 性别
    @Basic
    private String gender;
    // 年龄
    @Basic
    private String age;
    // 会员号
    @Basic
    private String member_id;
    // 客户星级
    @Basic
    private String customer_star_rating;
    // 备注
    @Basic
    private String remarks;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
