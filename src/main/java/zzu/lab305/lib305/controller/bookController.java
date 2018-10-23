package zzu.lab305.lib305.controller;


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
import zzu.lab305.lib305.entity.PageResult;
import zzu.lab305.lib305.entity.Result;
import zzu.lab305.lib305.entity.User;
import zzu.lab305.lib305.service.bookService;
import zzu.lab305.lib305.service.userService;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/book")
public class bookController {
    private final
    bookService bookService;

    private final
    userService userService;

    @Autowired
    public bookController(bookService bookService, userService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    @RequestMapping("/add")
    public ResponseEntity<byte[]> addbook(@Validated @RequestBody Book book) throws IOException {
        String bookid;
        try {
            bookid = bookService.add(book);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        HttpHeaders headers = new HttpHeaders();
        Properties properties = System.getProperties();
        String osname = properties.getProperty("os.name");
        String filePath;
        if (osname.toUpperCase().matches("WINDOWS \\w*")) {
            filePath = "C:\\image\\" + bookid + ".png";
        }else {
            filePath = "/home/image/" + bookid + ".png";
        }

        File file = new File(filePath);
        headers.setContentType(MediaType.IMAGE_JPEG);

        return new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), headers, HttpStatus.OK);

    }

    @RequestMapping("/findPage")
    public PageResult findPage(@RequestParam("pageSize")Integer pagesize, @RequestParam("pageNum")Integer pagenum){
        return bookService.findPage(pagenum, pagesize);


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

    @RequestMapping("/scanbook")
    public Book scanbook(@RequestParam("scanId") String scanId) throws IOException {

        return bookService.scanbook(scanId);
    }
    @RequestMapping("/findUserBook")
    public List<Book> findByuser(){
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = principal.getUsername();
        User user = userService.findUserByName(username);

        String userBooks = user.getUserBooks();
        if (userBooks!=null)
        {
            String[] strings = userBooks.split(",");
            List<Book> bookList=new ArrayList<>();
            for (String s:strings) {
                Book byId = null;
                if (!"".equals(s)) {
                    byId = bookService.findById(Integer.valueOf(s));
                }

                bookList.add(byId);
            }

            return bookList;
        }
      return null;

    }
    @RequestMapping("/find/{bookId}")
    public Book findone(@PathVariable Integer bookId) {

        return bookService.findById(bookId);
    }

    @RequestMapping("/findbook")
    public PageResult findbook(@RequestBody Book book,@RequestParam("pageNum")Integer num,@RequestParam("pageSize")Integer size) {

        PageResult book1;
        try {
            book1 = bookService.findBook(book, num, size);
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
        userByName.setUserBooks(s+book.getBookId()+",");
        userService.update(userByName);

        int i;
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
        String s = userByName.getUserBooks() .replaceFirst(book.getBookId()+"?,","");
        userByName.setUserBooks(s);
        userService.update(userByName);
        int i;
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
                sb.append(err.getDefaultMessage()).append(";  ");
            }
          return new Result(false,new String(sb));
        }
        int i;

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
            int i;
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
