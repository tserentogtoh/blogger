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
public class User {
    @Id
    private Long userId;
    
    private int roleId;
    private String phoneNo;
    private Integer salary;
    private String fName; 
    private String lName; 
    private String email; 
    private String password;
    
    public User() {
    }

    public User(Long userId, int roleId, String phoneNo, Integer salary, String fName, String lName, String email, String password) {
        
        this.userId = userId;
        this.roleId = roleId;
        this.phoneNo = phoneNo;
        this.salary = salary;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.password = password;
    }

    
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getRole() {
        return roleId;
    }

    public void setRole(int roleId) {
        this.roleId = roleId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
