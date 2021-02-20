package com.qqq.oasys.model.role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Johnson
 * 2021/2/20
 */

@Entity
@Table(name="aoa_role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="role_id")
    private Long roleId;//角色id

    @Column(name="role_name")
    private String roleName;//角色名

    @Column(name="role_value")
    private Integer  roleValue;//角色权限值

    public Role(String roleName, Integer roleValue) {
        this.roleName = roleName;
        this.roleValue = roleValue;
    }
}
