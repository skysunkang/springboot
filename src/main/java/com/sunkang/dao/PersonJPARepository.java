package com.sunkang.dao;

import com.sunkang.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by changxiang on 2017-03-02.
 * spring jpa的数据访问
 */
@Repository
public interface PersonJPARepository extends JpaRepository<Person,String>{
    List<Person> findPersonByName(String name);

    @Query("select p from Person p where p.address = :address")
    List<Person> selectByAddress1(@Param("address") String address);
}
