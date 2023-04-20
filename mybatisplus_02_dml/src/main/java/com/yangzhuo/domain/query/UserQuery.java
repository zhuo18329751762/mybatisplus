package com.yangzhuo.domain.query;

import com.yangzhuo.domain.User;

public class UserQuery extends User {
    private Integer age2;

    public UserQuery() {
    }

    public UserQuery(Integer age2) {
        this.age2 = age2;
    }

    /**
     * 获取
     * @return age2
     */
    public Integer getAge2() {
        return age2;
    }

    /**
     * 设置
     * @param age2
     */
    public void setAge2(Integer age2) {
        this.age2 = age2;
    }

    public String toString() {
        return "UserQuery{age2 = " + age2 + "}";
    }
}
