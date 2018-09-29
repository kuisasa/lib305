package zzu.lab305.lib305.serviceImpl;

import com.google.zxing.WriterException;
import org.oriboy.qrcode.common.QRCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zzu.lab305.lib305.Exception.NoBookException;
import zzu.lab305.lib305.entity.Book;
import zzu.lab305.lib305.entity.BookExample;
import zzu.lab305.lib305.impl.BookMapper;
import zzu.lab305.lib305.service.bookService;

import java.io.IOException;
import java.util.List;
@Service
public class bookServiceImpl implements bookService {

    @Autowired
  BookMapper bookMapper;
    @Override
    public List<Book> findAllBooks() {
        return bookMapper.selectByExample(null);
    }

    @Override
    public List<Book> findBook(Book book) {


        BookExample bookExample=new BookExample();
        BookExample.Criteria criteria = bookExample.createCriteria();
       if (book.getBookId()!=null)
           criteria.andBookIdEqualTo(book.getBookId());
        if (book.getBookCategory()!=null&&!"".equals(book.getBookCategory()))
           criteria.andBookCategoryEqualTo(book.getBookCategory());
        if(book.getBookName()!=null&&"".equals(book.getBookName()))
            criteria.andBookNameLike("%"+book.getBookName()+"%");
        if (book.getBookStatus()!=null)
            criteria.andBookStatusEqualTo(book.getBookStatus());

        List<Book> books = bookMapper.selectByExample(bookExample);

        return books;


    }

    @Override
    public String add(Book book) throws IOException, WriterException {

        book.setBookStatus(true);
        bookMapper.insert(book);
        Integer bookId = book.getBookId();
        String filePath = "C:\\image\\"+bookId+".png";
        String url = "http://192.168.101.155:8080/book/find/"+bookId;
        QRCodeUtils.create(url,filePath);
        book.setBookCodeimg(filePath);
        bookMapper.updateByPrimaryKey(book);

        return String.valueOf(bookId);
    }

    @Override
    public int update(Book book) throws NoBookException {
        Book book1 = bookMapper.selectByPrimaryKey(book.getBookId());
        if(book1==null)
            throw new NoBookException("书籍不在库中");
        if(book.getBookStatus()==null)
            book.setBookStatus(book1.getBookStatus());
        int i = bookMapper.updateByPrimaryKey(book);


        return i;
    }

    @Override
    public Book findById(Integer id) {
        return bookMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Integer id) throws NoBookException {
        int i = bookMapper.deleteByPrimaryKey(id);

        if (i==0)
            throw new NoBookException("书籍不在库中");
        return i;
    }


}
