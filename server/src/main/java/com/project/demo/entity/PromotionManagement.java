package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 促销管理：(PromotionManagement)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "PromotionManagement")
public class PromotionManagement implements Serializable {

    // PromotionManagement编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "promotion_management_id")
    private Integer promotion_management_id;

    // 促销名称
    @Basic
    private String promotion_name;
    // 促销目的
    @Basic
    private String promotion_purpose;
    // 促销商品
    @Basic
    private String promotional_products;
    // 原价
    @Basic
    private Integer original_price;
    // 促销价
    @Basic
    private Integer promotional_price;
    // 开始日期
    @Basic
    private Timestamp start_date;
    // 结束日期
    @Basic
    private Timestamp promotion_end_date;
    // 促销效果
    @Basic
    private String promotion_effect;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
