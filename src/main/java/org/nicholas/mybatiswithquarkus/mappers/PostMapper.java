package org.nicholas.mybatiswithquarkus.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.nicholas.mybatiswithquarkus.models.Post;

import java.util.List;

@Mapper
public interface PostMapper {
    @Select("select * from post")
    @Results({
            @Result(property = "postId", column = "post_id", id = true),
            @Result(property = "title", column = "title"),
            @Result(property = "content", column = "content"),
            @Result(property = "createdOn", column = "created_on")
    })
    List<Post> findAll();

    @Select("select * from post where post_id = #{postId}")
    @Results({
            @Result(property = "postId", column = "post_id", id = true),
            @Result(property = "title", column = "title"),
            @Result(property = "content", column = "content"),
            @Result(property = "createdOn", column = "created_on")
    })
    Post findById(Integer id);

}
