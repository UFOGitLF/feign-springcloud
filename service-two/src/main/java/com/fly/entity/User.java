package com.fly.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

/**
 * @author liufei
 */
@Data
@Entity
@Table(name = "tb_user")
public class User extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    @OneToMany(targetEntity = Mobile.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @NotEmpty(message = "手机信息不能为空")
    @Valid
    private List<Mobile> mobile;

    @Email
    private String email;

}