package zzu.lab305.lib305.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.zxing.WriterException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.oriboy.qrcode.common.QRCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zzu.lab305.lib305.Exception.NoBookException;
import zzu.lab305.lib305.entity.Book;
import zzu.lab305.lib305.entity.BookExample;
import zzu.lab305.lib305.entity.PageResult;
import zzu.lab305.lib305.impl.BookMapper;
import zzu.lab305.lib305.service.bookService;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

@Service
public class bookServiceImpl implements bookService {

    @Autowired
    BookMapper bookMapper;

    @Override
    public PageResult findPage(Integer num, Integer size) {
        PageHelper.startPage(num,size);
        Page<Book> page= (Page<Book>)bookMapper.selectByExample(null);



        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public List<Book> findAllBooks() {
        return bookMapper.selectByExample(null);
    }

    @Override
    public PageResult findBook(Book book, Integer num, Integer size) {


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


        PageHelper.startPage(num, size);

        Page<Book>page= (Page<Book>) bookMapper.selectByExample(bookExample);

        return new PageResult(page.getTotal(),page.getResult());


    }

    @Override
    public String add(Book book) throws IOException, WriterException {

        book.setBookStatus(true);
        bookMapper.insert(book);
        Integer bookId = book.getBookId();
        Properties properties = System.getProperties();
        String osname = properties.getProperty("os.name");
        String filePath = null;
        String url = null;
        String toUpperCase = osname.toUpperCase();
        if (toUpperCase.matches("WINDOWS \\w*")) {
            filePath = "C:\\image\\" + bookId + ".png";
            url = "http://192.168.101.177:8080/book/find/" + bookId;
        }
        else {
            filePath = "/home/image/"+bookId+".png";
             url = "https://book.gdatacloud.com:443/book/find/"+bookId;

        }
        QRCodeUtils.create(url, filePath);
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

    @Override
    public Book scanbook(String id) throws IOException {
       Book book=new Book();
        HttpGet httpGet = new HttpGet("https://isbn.market.alicloudapi.com/ISBN?isbn="+id);
        httpGet.setHeader("Authorization", "APPCODE 6e2a110b460144c2931417f787c67129");
        CloseableHttpClient aDefault = HttpClients.createDefault();
        CloseableHttpResponse response = aDefault.execute(httpGet);
        HttpEntity entity = response.getEntity();
        String string = EntityUtils.toString(entity, "UTF-8");
        JSONObject jsonObject = JSON.parseObject(string);
        JSONObject result = (JSONObject) jsonObject.get("result");
        for (Object key:result.keySet()){
            if ("author".equals(key))
                book.setBookAuthor((String) result.get(key));
            if ("title".equals(key))
                book.setBookName((String) result.get(key));
            if ("subtitle".equals(key)&&result.get(key)!=null)
                book.setBookName(book.getBookName()+(String) result.get(key));
            if ("images_medium".equals(key))
                book.setBookImg((String) result.get(key));


        }

        return book;
    }


}
