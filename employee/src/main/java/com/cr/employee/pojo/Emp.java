package com.cr.employee.pojo;

public class Emp {
    private Integer id;
    private  Integer did;
    private String name;
    private String  pw;

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", did=" + did +
                ", name='" + name + '\'' +
                ", pw='" + pw + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
