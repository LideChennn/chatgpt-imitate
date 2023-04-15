package cn.edu.gdpu.chatgpt.dao;

import cn.edu.gdpu.chatgpt.domain.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface BookDao {

//    @Insert("insert into tbl_book values(null,#{type},#{name},#{description})")
    @Insert("insert into tbl_book (type,name,description) values(#{type},#{name},#{description})")
    public int save(Book book);

    @Update("update tbl_book set type = #{type}, name = #{name}, description = #{description} where id = #{id}")
    public int update(Book book);

    @Delete("delete from tbl_book where id = #{id}")
    public int delete(Integer id);

    @Select("select * from tbl_book where id = #{id}")
    public Book getById(Integer id);

    @Select("select * from tbl_book")
    public List<Book> getAll();

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Update("update tbl_account set money = money + 100 where id = #{id};")
    public void in(int id);
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Update("update tbl_account set money = money - 100 where id = #{id};")
    public void out(int id);


    public List<Book> selectAll();
}
