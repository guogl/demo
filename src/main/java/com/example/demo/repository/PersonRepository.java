package com.example.demo.repository;

import com.example.demo.model.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface PersonRepository {
    @Select("select * from tb_person")
    @Results({
            @Result(property = "birthDay", column = "birth_day"),
            @Result(property = "createdAt", column = "created_at"),
            @Result(property = "updatedAt", column = "updated_at")
    })
    List<Person> findAll();

    @Select("select * from tb_person where id = #{id}")
    @Results({
            @Result(property = "birthDay", column = "birth_day"),
            @Result(property = "createdAt", column = "created_at"),
            @Result(property = "updatedAt", column = "updated_at")
    })
    Person findById(@Param("id") String id);

    @Select("select * from tb_person where name = #{name}")
    @Results({
            @Result(property = "birthDay", column = "birth_day"),
            @Result(property = "createdAt", column = "created_at"),
            @Result(property = "updatedAt", column = "updated_at")
    })
    List<Person> findByName(@Param("name") String name);

    @Insert("insert into tb_person (id, name, sex, birth_day, created_at, updated_at) values (#{id}, #{name}, #{sex}, #{birthDay}, #{createdAt}, #{updatedAt})")
    @SelectKey(statement = "SELECT UUID()", keyProperty = "id",
            before = true, resultType = String.class)
    void insert(Person person);

    @Update({
            "update tb_person set name = #{name}, sex = #{sex}, birth_day = #{birthDay}, created_at = #{createdAt}, updated_at = #{updatedAt} where id = "
                    + "#{id}"})
    void update(Person person);
}
