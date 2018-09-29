package zzu.lab305.lib305.service;

import com.google.zxing.WriterException;
import zzu.lab305.lib305.Exception.NoBookException;
import zzu.lab305.lib305.entity.Book;

import java.io.IOException;
import java.util.List;

public interface bookService {

    public List<Book> findAllBooks();

    public List<Book> findBook(Book book);

    public String add(Book book) throws IOException, WriterException;

    public int update(Book book) throws NoBookException;

    public Book findById(Integer id);

    public int delete(Integer id) throws NoBookException;


}
