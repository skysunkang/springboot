package com.sunkang.controller;

import com.sunkang.dao.PersonRedisRepository;
import com.sunkang.entity.Person;
import com.sunkang.service.PersonJPAService;
import com.sunkang.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by changxiang on 2017-03-01.
 */
@Controller
public class TestContrller {
    @Autowired
    private PersonJPAService personJPAService;

    @Autowired
    private PersonRedisRepository personRedisRepository;

    @Autowired
    private PersonService personService;

    /**
     * 测试spring-jpa的操作
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/test")
    public ModelAndView toTest(Integer page,Integer pageSize){
        if(page==null||page==0){
            page=1;
        }
        if(pageSize==null||pageSize==0){
            pageSize=10;
        }

        ModelAndView modelAndView=new ModelAndView("test");
        modelAndView.addObject("name","孙康");

        Page<Person> personPage=personJPAService.findPersionList(page,pageSize);
        /*List<Person> list= personPage.getContent();
        for(Person person:list){
            System.out.println(person.toString());
        }
        Pageable pageable= personPage.previousPageable();*/
        modelAndView.addObject("persons",personPage);

        personJPAService.testTransactional();
        personJPAService.testNoRollback();
        return modelAndView;
    }

    /**
     * 测试spring的缓存
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "testCache")
    public String testCache(){
        personJPAService.findpPerson(new Person("ff8080815a97d315015a97d3316e0004",null,null,null));
        personJPAService.delete("ff8080815a97d315015a97d3316e0004");
        personJPAService.findpPerson(new Person("ff8080815a97d315015a97d3316e0004",null,null,null));
        Person person=new Person(null,"哈哈哈",12,"上海");
        personJPAService.save(person);
        personJPAService.findpPerson(person);
        return "哈哈";
    }


    /**
     * 测试redis
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "testRedis")
    public String testRedis(){
        personRedisRepository.saveStr("id","sunkang");
        String name=personRedisRepository.getStr("name");
        System.out.println(name);

        personRedisRepository.savePerson(new Person("1","sunkang",25,"深圳"));
        Person person=personRedisRepository.getPersonById("1");
        System.out.println(person.toString());

        return "哈哈";
    }

    /**
     * 测试mybatis
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "testMybatis")
    public List<Person> testMybatis(){
        List<Person> persons= personService.testMybatis();
        return persons;
    }

    /**
     * 测试spring-jpa的操作
     * @return
     */
    @RequestMapping("/testjsp")
    public ModelAndView testjsp(){
        ModelAndView modelAndView=new ModelAndView("test");
        return modelAndView;
    }

}
