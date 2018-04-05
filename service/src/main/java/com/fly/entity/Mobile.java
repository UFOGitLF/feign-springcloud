package com.fly.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author : liufei on 2018/3/29
 */
@Entity
@Table(name = "tb_mobile")
@Data
public class Mobile extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 手机型号
     */
    @Column(name = "mobile_type")
    private String mobileName;
    /**
     * 手机价格
     */
    @Column(name = "mobile_price")
    private Double mobilePrice;
    /**
     * 手机号码
     */
    @Column(name = "phone_number")
    @NotNull(message = "手机号码不能为空")
    private Long phoneNumber;

}
