package cn.edu.gdpu.chatgpt.service;

import cn.edu.gdpu.chatgpt.dao.BookDao;
import cn.edu.gdpu.chatgpt.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookDao bookDao;
    @Test
    public void testGetById(){
        Book book = bookService.getById(15);
        System.out.println(book);
    }

    @Test
    public void testGetAll(){
        List<Book> all = bookService.getAll();
        all.forEach(System.out::println);
    }

//    @Test
//    public void testSout(){
//        bookService.inAndOut(1, 2);
//    }
//
//    @Test
//    public void testBookMapper(){
//        System.out.println(bookDao.selectAll());
//    }
}
