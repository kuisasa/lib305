package zzu.lab305.lib305.service;

import com.google.zxing.WriterException;
import zzu.lab305.lib305.Exception.NoBookException;
import zzu.lab305.lib305.entity.Book;
import zzu.lab305.lib305.entity.PageResult;

import java.io.IOException;
import java.util.List;

public interface bookService {

    public PageResult findPage(Integer num,Integer size);

    public List<Book> findAllBooks();



    PageResult findBook(Book book, Integer num, Integer size);

    public String add(Book book) throws IOException, WriterException;

    public int update(Book book) throws NoBookException;

    public Book findById(Integer id);

    public int delete(Integer id) throws NoBookException;

   public Book scanbook(String id) throws IOException;
}
