package com.sunkang.service;

import com.sunkang.dao.PersonRedisRepository;
import com.sunkang.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by changxiang on 2017-03-11.
 */
public class PersonRedisService {

    @Autowired
    private PersonRedisRepository personRedisRepository;

    /**
     * 根据id查询person
     * @param id
     * @return
     */
    public Person getPersonRides(String id){
        return personRedisRepository.getPersonById(id);
    }

    /**
     * 保存person
     * @param person
     */
    public void savePerson(Person person){
        personRedisRepository.savePerson(person);
    }

    /**
     * 根据kry获取value
     * @param key
     * @return
     */
    public String getStrValue(String key){
        return personRedisRepository.getStr(key);
    }

    /**
     * 保存字符串类型数据
     * @param key
     * @param value
     */
    public void saveStrValue(String key,String value){
        personRedisRepository.saveStr(key,value);
    }
}
