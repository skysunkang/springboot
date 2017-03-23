package com.sunkang.dao;

import com.sunkang.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;


/**
 * Created by changxiang on 2017-03-11.
 *
 * redis的数据访问
 */
@Repository
public class PersonRedisRepository {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Resource(name = "stringRedisTemplate")
    ValueOperations<String,String> valOpsStr;

    @Autowired
    RedisTemplate<Object,Object > redisTemplate;

    @Resource(name="redisTemplate")
    ValueOperations<Object,Object> valOps;

    /**
     * 像redis里面保存字符串
     * @param key
     * @param value
     */
    public void saveStr(String key,String value){
        valOpsStr.set(key,value);
    }

    /**
     * 获得字符串类型
     * @param key
     * @return
     */
    public String getStr(String key){
        return valOpsStr.get(key);
    }

    /**
     * 保存person
     * @param person
     */
    public void savePerson(Person person){
        valOps.set(person.getId(),person);
    }

    /**
     * 通过id查询personRdes
     * @param id
     * @return
     */
    public Person getPersonById(String id){
        return (Person) valOps.get(id);
    }
}
