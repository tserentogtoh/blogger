/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ict.blogger.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author tseke
 */
@Entity
public class Role {
    @Id
    private int roleId;

    private String rName;

    public Role() {
    }

    public Role(int roleId, String rName) {
        this.roleId = roleId;
        this.rName = rName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    } 
}
