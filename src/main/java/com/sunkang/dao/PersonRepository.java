package com.sunkang.dao;

import com.sunkang.entity.Person;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by changxiang on 2017-03-13.
 * mybatis的数据库操作类
 */
@Mapper
public interface PersonRepository {

    List<Person> selectPersonAll();

    Person selectPersonById(String id);

    List<Person> selectPersonByNameAndAddress(Person person);

    void insertPerson(Person person);

    void deletePersonById(String id);

    void updatePersonById(Person person);

    void updatePersonId(Map<String,String> map);
}
