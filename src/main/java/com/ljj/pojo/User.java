package com.ljj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private int user_id;
    private long phone;
    private int table;
    private int people;

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public void setPhone(long phone) {
        this.phone = phone;
    }
    public void setTable(int table) {
        this.table = table;
    }
    public void setPeople(int people) {
        this.people = people;
    }

    public int getUser_id() {
        return user_id;
    }
    public long getPhone() {
        return phone;
    }
    public int getTable() {
        return table;
    }
    public int getPeople() {
        return people;
    }
}
