package com.sunkang.service;

import com.sunkang.dao.PersonRepository;
import com.sunkang.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by changxiang on 2017-03-13.
 */
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    /**
     * 测试mybatis
     * REQUIRED有事务则用原来的事务，没有的重新创建事务
     * @return
     */
    @Transactional(propagation= Propagation.REQUIRED)
    public List<Person> testMybatis(){
        personRepository.selectPersonById("1");

        personRepository.selectPersonByNameAndAddress(new Person(null,"孙康",null,"深圳"));

        personRepository.insertPerson(new Person(null,"马云",50,"杭州"));

//        测试事务
//        String str=null;
//        str.split(",");

        personRepository.deletePersonById("ff8080815a97d315015a97d3316f0008");

        personRepository.updatePersonById(new Person("ff8080815a97d315015a97d3316f0009","新名字",1,"新地址"));

        Map<String,String> map=new HashMap<String,String>();
        map.put("oldId" ,"ff8080815a97d315015a97d3316f0009");
        map.put("newId","new");
        personRepository.updatePersonId(map);
        return personRepository.selectPersonAll();
    }
}
