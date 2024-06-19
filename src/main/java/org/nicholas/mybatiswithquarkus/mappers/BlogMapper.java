package org.nicholas.mybatiswithquarkus.mappers;

import org.apache.ibatis.annotations.*;
import org.nicholas.mybatiswithquarkus.models.Blog;

import java.util.List;

@Mapper
public interface BlogMapper {
//    @Select("SELECT b.blog_id as ID, b.blog_name, b.created_on as blog_created_on, p.post_id as post_post_id, p.title as post_title, p.content as post_content, p.created_on as post_created_on FROM blog b left outer join post p on b.blog_id=p.blog_id")
//    ...
//    @Result(property = "blogId", column = "ID", id = true), //column are got from the select result!!! So if alias is used in select here (in column property) alias should be used to
//    Thus @Result Represents the JDBC ResultSet Results
    @Select("select * from blog b left join post p on b.blog_id = p.blog_id;")
    @Results({
            @Result(property = "blogId", column = "blog_id", id = true),
            @Result(property = "blogName", column = "blog_name"),
            @Result(property = "createdOn", column = "created_on"),
            @Result(property = "posts", column = "post_id", many = @Many(select = "org.nicholas.mybatiswithquarkus.mappers.PostMapper.findById"))
    })
    List<Blog> findAll();

    @Select("select * from blog b left join post p on b.blog_id = p.blog_id where b.blog_id = #{blogId}")
    @Results({
            @Result(property = "blogId", column = "blog_id", id = true),
            @Result(property = "blogName", column = "blog_name"),
            @Result(property = "createdOn", column = "created_on"),
            @Result(property = "posts", column = "post_id", many = @Many(select = "org.nicholas.mybatiswithquarkus.mappers.PostMapper.findById"))
    })
    Blog findById(int id);
}
