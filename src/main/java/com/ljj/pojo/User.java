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
