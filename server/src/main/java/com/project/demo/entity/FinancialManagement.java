package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 财务管理：(FinancialManagement)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "FinancialManagement")
public class FinancialManagement implements Serializable {

    // FinancialManagement编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "financial_management_id")
    private Integer financial_management_id;

    // 月份
    @Basic
    private String month;
    // 销售额
    @Basic
    private Integer sales_volume;
    // 产品成本
    @Basic
    private Integer product_cost;
    // 员工工资
    @Basic
    private Integer employee_salaries;
    // 其他支出
    @Basic
    private Integer other_expenses;
    // 利润
    @Basic
    private String profit;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
