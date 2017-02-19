package com.ethan.domain;

import javax.persistence.*;

/**
 * Created by lingxingu on 2017/2/18.
 */
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "staffid")
    private Long staffId;

    @Column(name = "username")
    private String userName;

    @Column(name = "table")
    private String table;

    @Column(name = "seat")
    private Long seat;

    public Customer() {
        super();
    }

    public Customer(Long staffId, String userName, String table, Long seat) {
        this.staffId = staffId;
        this.userName = userName;
        this.table = table;
        this.seat = seat;
    }

    public Customer(String userName, Long staffId) {
        this.staffId = staffId;
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public Long getSeat() {
        return seat;
    }

    public void setSeat(Long seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%d, username=%s, staffid=%d]", id, userName, staffId);
    }

}
