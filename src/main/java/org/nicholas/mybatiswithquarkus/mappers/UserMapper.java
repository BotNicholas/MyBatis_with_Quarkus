package org.nicholas.mybatiswithquarkus.mappers;

import org.apache.ibatis.annotations.*;
import org.nicholas.mybatiswithquarkus.models.User;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user left join blog.blog b on user.blog_id = b.blog_id;")
    @Results({
            @Result(property = "userId", column = "user_id", id = true),
            @Result(property = "emailId", column = "email_id"),
            @Result(property = "password", column = "password"),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastname", column = "lastname"),
            @Result(property = "blog", column = "blog_id", one = @One(select = "org.nicholas.mybatiswithquarkus.mappers.BlogMapper.findById"))
    })
    public List<User> findAll();

    @Select("select * from user left join blog.blog b on user.blog_id = b.blog_id where user.user_id = #{userId};")
    @Results({
            @Result(property = "userId", column = "user_id", id = true),
            @Result(property = "emailId", column = "email_id"),
            @Result(property = "password", column = "password"),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastname", column = "lastname"),
            @Result(property = "blog", column = "blog_id", one = @One(select = "org.nicholas.mybatiswithquarkus.mappers.BlogMapper.findById"))
    })
    public User findById(int id);
}
