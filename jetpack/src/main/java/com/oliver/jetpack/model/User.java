package com.oliver.jetpack.model;

/**
 * author : Oliver
 * date   : 2019/4/16
 * desc   :
 */

public class User {

    private String name;
    private int age;
    private String love;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? "" : name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love == null ? "" : love;
    }
}
