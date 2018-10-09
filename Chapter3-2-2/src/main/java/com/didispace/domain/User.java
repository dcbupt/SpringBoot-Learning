package com.didispace.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import java.util.Date;

/**
 * @author 程序猿DD
 * @version 1.0.0
 * @date 16/3/21 下午3:35.
 * @blog http://blog.didispace.com
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="pk_gen")
    @TableGenerator(name = "pk_gen",    // 该表主键生成策略的名称，它被引用在@GeneratedValue中设置的“generator”值中
        table="tb_generator",   // 表生成策略所持久化的表名
        pkColumnName="gen_name",    // 在持久化表中，该主键生成策略所对应键值的名称
        valueColumnName="gen_value",    // 在持久化表中，该主键当前所生成的值，它的值将会随着每次创建累加
        pkColumnValue="USER",    // 在持久化表中，该生成策略所对应的主键
        allocationSize=1    // 每次主键值增加的大小
    )
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private Date date;

    public User(){}

    public User(String name, Integer age, Date date) {
        this.name = name;
        this.age = age;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name + " " + this.date;
    }
}
