package com.sunkang.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.GeneratedValue;
import java.io.Serializable;

/**
 * Created by changxiang on 2017-03-02.
 * 人员实体类
 * redis数据存储需要序列化
 */
@Entity
@NamedQuery(name="Person.findPersonByName",query = "select  p from Person p where p.name=?1")
public class Person implements  Serializable{
    @Id
    @GeneratedValue(generator="person_uuid")
    @GenericGenerator(name="person_uuid",strategy = "uuid")
    private String id;
    private String name;
    private Integer age;
    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public Person(String id,String name, Integer age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Person() {
        super();
    }
}
