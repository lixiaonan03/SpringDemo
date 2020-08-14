package com.lxn;

/**
 * Created by lixiaonan on 2019/2/20.
 */
public class User implements Comparable<User>{
    private String name;
    private String order;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getOrder() {
        return order;
    }
    public void setOrder(String order) {
        this.order = order;
    }
    @Override
    public int compareTo(User arg0) {
        return this.getOrder().compareTo(arg0.getOrder());
    }
}
