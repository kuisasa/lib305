package zzu.lab305.lib305;

import com.google.zxing.WriterException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.oriboy.qrcode.common.QRCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zzu.lab305.lib305.entity.Book;
import zzu.lab305.lib305.serviceImpl.bookServiceImpl;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Lib305ApplicationTests {
@Autowired
    bookServiceImpl bookService;
    @Test
    public void contextLoads() throws IOException, WriterException {


    }

}
