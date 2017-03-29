package com.sunkang.service;

import com.sunkang.dao.PersonJPARepository;
import com.sunkang.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by changxiang on 2017-03-02.
 *
 * enableCaching开启缓存
 */
@EnableCaching
@Service
public class PersonJPAService {
    @Autowired
    private PersonJPARepository personRepository;

    public void selectByAddress1(){
       List<Person> persons= personRepository.selectByAddress1("武汉");
       for(Person person:persons){
           System.out.println(person.toString());
       }
    }


    public Page<Person> findPersionList(Integer page,Integer pageSize)  {
        try {
            /*List<Person> persons=personRepository.findPersonByName("名字4");
            for(Person person:persons){
                System.out.println(person.toString());
            }
            personRepository.save(new Person(null,"傻逼",24,"深圳"));

            List<Person> insertPersons=new ArrayList<Person>();
            for(int i=0;i<=9;i++){
                Person person=new Person(null,"名字"+i,i,"地址"+i);
                insertPersons.add(person);
            }
            personRepository.save(insertPersons);*/

//            personRepository.delete("2");
//            return personRepository.findAll(new Sort(Sort.Direction.ASC,"age"),new Pageable());
            return personRepository.findAll(new PageRequest(page,pageSize,Sort.Direction.ASC,"name"));
        }catch (Exception e){
            e.printStackTrace();
        }
      return null;
    }

    /**
    value() default "";
     transactionManager() default "";
     Propagation propagation() default Propagation.REQUIRED; 事务级别
     Isolation isolation() default Isolation.DEFAULT;隔离级别
     int timeout() default -1;
     boolean readOnly() default false;
     Class<? extends Throwable>[] rollbackFor() default {};何种错误rollback
     String[] rollbackForClassName() default {};
     Class<? extends Throwable>[] noRollbackFor() default {};何种错误不rollback
     String[] noRollbackForClassName() default {};
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void testTransactional(){
        Person person=new Person(null,"会滚吧",10,"地址");
        personRepository.save(person);
        throw new IllegalArgumentException("回滚吧");
    }



    @Transactional(propagation = Propagation.REQUIRED,noRollbackForClassName = "IllegalArgumentException")
    public void testNoRollback(){
        Person person=new Person(null,"不要回滚",10,"地址");
        personRepository.save(person);
        throw new IllegalArgumentException("回滚吧");
    }

    /**
     * 测试缓存
     * @param person
     */
    @CachePut(value = "person",key = "#person.id")
    public void save(Person person){
        personRepository.save(person);
    }

    @CacheEvict(value = "person")
    public void delete(String id){
        personRepository.delete(id);
    }

    @Cacheable(value = "person",key = "#person.id")
    public Person findpPerson(Person person){
        return personRepository.findOne(person.getId());
    }
}
