package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 运营管理：(OperationManagement)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "OperationManagement")
public class OperationManagement implements Serializable {

    // OperationManagement编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "operation_management_id")
    private Integer operation_management_id;

    // 运营项目
    @Basic
    private String operational_projects;
    // 运营目标
    @Basic
    private String operational_objectives;
    // 人员配置
    @Basic
    private String staffing;
    // 启动日期
    @Basic
    private Timestamp start_date;
    // 结束日期
    @Basic
    private Timestamp end_date;
    // 负责人
    @Basic
    private String person_in_charge;
    // 运营计划
    @Basic
    private String operation_plan;
    // 运营效果
    @Basic
    private String operational_effectiveness;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
