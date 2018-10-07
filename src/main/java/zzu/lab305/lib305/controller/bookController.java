package zzu.lab305.lib305.controller;

import com.google.zxing.WriterException;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import zzu.lab305.lib305.Exception.NoBookException;
import zzu.lab305.lib305.entity.Book;
import zzu.lab305.lib305.entity.Result;
import zzu.lab305.lib305.entity.User;
import zzu.lab305.lib305.service.bookService;
import zzu.lab305.lib305.service.userService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/book")
public class bookController {
    @Autowired
    bookService bookService;

    @Autowired
    userService userService;
    @RequestMapping("/add")
    public ResponseEntity<byte[]> addbook(@Validated @RequestBody Book book) throws IOException, WriterException {
        String bookid = null;
        try {
            bookid = bookService.add(book);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        HttpHeaders headers = new HttpHeaders();
        String filePath = "C:\\image\\" + bookid + ".png";
        File file = new File(filePath);
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), headers, HttpStatus.OK);

    }

    @RequestMapping("/findall")
    public List<Book> findall() {
        List<Book> allBooks;
        try {
            allBooks = bookService.findAllBooks();
        } catch (Exception e) {
            return null;
        }

        return allBooks;
    }

    @RequestMapping("/find/{bookId}")
    public Book findone(@PathVariable Integer bookId) {
        Book book = new Book();
        book.setBookId(bookId);
        List<Book> books = bookService.findBook(book);
        if (books.isEmpty())
            return null;
        return books.get(0);
    }

    @RequestMapping("/findbook")
    public List<Book> findbook(@RequestBody Book book) {
        List<Book> book1;
        try {
            book1 = bookService.findBook(book);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return book1;
    }

    @Transactional
    @RequestMapping("/out/{bookId}")
    public Result outBook(@PathVariable Integer bookId) {
        Book book = bookService.findById(bookId);

        if (!book.getBookStatus())
            return new Result(false, "这本书已经被借出");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 2);

        Date reTime = calendar.getTime();
        book.setBookOutTime(date);
        book.setBookReTime(reTime);
        book.setBookStatus(false);

         UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = principal.getUsername();

        book.setBookUser(username);
        User userByName = userService.findUserByName(username);
        String s = userByName.getUserBooks() == null ? "" : userByName.getUserBooks();
        userByName.setUserBooks(s+"<"+book.getBookName()+">");
        userService.update(userByName);

        int i = 0;
        try {
            i = bookService.update(book);
        } catch (NoBookException e) {
            return new Result(false, e.getMessage());
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        if (i != 0)
            return new Result(true, "借阅成功，借阅期限为" + format);

        return new Result(false, "借阅失败");
    }

    @RequestMapping("/rebook/{bookId}")
    public Result returnBook(@PathVariable Integer bookId) {
        Book book = bookService.findById(bookId);
        if (book.getBookStatus()) {
            return new Result(false, "这本书未被借出");
        }
        book.setBookStatus(true);
        book.setBookReTime(null);
        book.setBookOutTime(null);

        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = principal.getUsername();

        book.setBookUser(null);
        User userByName = userService.findUserByName(username);
        String s = userByName.getUserBooks() .replaceFirst("<"+book.getBookName()+">","");
        userByName.setUserBooks(s);
        userService.update(userByName);
        int i = 0;
        try {
            i = bookService.update(book);
        } catch (NoBookException e) {
            return new Result(false, e.getMessage());
        }
        if (i != 0)
            return new Result(true, "还书成功");

        return new Result(false, "还书失败");
    }

    @RequestMapping("/update")
    public Result update(@Validated @RequestBody Book book, BindingResult result) {

        StringBuilder sb = new StringBuilder();
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            for (ObjectError err : errors) {
                sb.append(err.getDefaultMessage() + ";  ");
            }
          return new Result(false,new String(sb));
        }
        int i = 0;

        try {
            i = bookService.update(book);
        } catch (NoBookException e) {
            return new Result(false, e.getMessage());
        }

        if (i != 0) {
            return new Result(true, "修改成功");

        }
        return new Result(false, "修改失败");
    }

    @RequestMapping("/delete/{bookId}")
    public Result delete(@PathVariable Integer bookId){
            int i =0;
        try {
            i=bookService.delete(bookId);
        } catch (NoBookException e) {
            return new Result(false,e.getMessage());
        }
        if (i!=0)
        return new Result(true,"删除成功");

        return new Result(false,"删除失败");
    }



}
