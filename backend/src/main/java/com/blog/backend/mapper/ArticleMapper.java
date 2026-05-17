package com.blog.backend.mapper;

import com.blog.backend.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ArticleMapper {

    @Select("select * from article")
    List<Article> findAll();

    @Select("select * from article where id = #{id}")
    Article findById(Integer id);

    @Insert("""
                insert into article(title, content)
                values(#{title}, #{content})
            """)
    void insert(Article article);

    @Delete("delete from article where id = #{id}")
    void deleteById(Integer id);

    @Update("""
                update article
                set title = #{title},
                    content = #{content}
                where id = #{id}
            """)
    void update(Article article);
}