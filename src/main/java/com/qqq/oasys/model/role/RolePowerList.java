package com.qqq.oasys.model.role;

import com.qqq.oasys.model.system.SystemMenu;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

/**
 * @author Johnson
 * 2021/2/20
 */

@Entity
@Table(name="aoa_role_power_list")
@Data
@AllArgsConstructor
public class RolePowerList {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="pk_id")
    private Long pkId;


    @ManyToOne()
    @JoinColumn(name = "role_id")
    private Role roleId;

    @ManyToOne()
    @JoinColumn(name = "menu_id")
    private SystemMenu menuId;


    @Column(name="is_show")
    private Boolean check=false;
}
