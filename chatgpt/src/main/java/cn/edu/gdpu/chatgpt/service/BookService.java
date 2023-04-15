package cn.edu.gdpu.chatgpt.service;

import cn.edu.gdpu.chatgpt.domain.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface BookService {

    /**
     * 保存
     * @param book
     * @return
     */
    public boolean save(Book book);

    /**
     * 修改
     * @param book
     * @return
     */
    public boolean update(Book book);

    /**
     * 按id删除
     * @param id
     * @return
     */
    public boolean delete(Integer id);

    /**
     * 按id查询
     * @param id
     * @return
     */
    public Book getById(Integer id);

    /**
     * 查询全部
     * @return
     */
    public List<Book> getAll();


    /**
     *
     */
    public void sout();

    /**
     *
     * @param id1
     * @param id2
     */
    public void inAndOut(int id1, int id2);
}
