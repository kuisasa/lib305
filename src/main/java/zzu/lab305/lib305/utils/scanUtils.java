package zzu.lab305.lib305.utils;

import org.apache.http.HttpHost;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class scanUtils {

    public static Map<String,String> pachong(String xx) throws IOException {
        String outerHtml = gethtml("https://search.jd.com/Search?keyword="+xx+"&enc=utf-8&wq="+xx+"&pvid=b4887f85df384ea6bad0370eda500954");


        System.out.println(outerHtml);

        Pattern pattern = Pattern.compile(".*?J_goodsList.*?target=\"_blank\".*?title.*?href=\"(.*?)\".*?",Pattern.DOTALL | Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(outerHtml);
        String group = null;
        if(matcher.find()){
            group = matcher.group(1);
        }

       List<String> list=new ArrayList<String>();
        String skuhtml=gethtml("https:" + group);
        Pattern pattern1 = Pattern.compile(".*?spec-n1.*?src=\"//(.*?)\".*?id=\"name\".*?class=\"sku-name\">(.*?)</div>.*?id=\"p-author\".*?<a data-name.*?>(.*?)</a>", Pattern.DOTALL | Pattern.MULTILINE);
        Matcher matcher1 = pattern1.matcher(skuhtml);
        if (matcher1.find()){
            for (int i=0;i<matcher1.groupCount();i++){
             list.add(matcher1.group(i+1).trim());
            }
        }
        String replace = list.get(1).replace(xx, "").trim();
        list.remove(1);
        list.add(1,replace);
        Map<String,String> map=new HashMap<>();
        map.put("img",list.get(0));
        map.put("name",list.get(1));
        map.put("author",list.get(2));

        return map;
    }

    public static String gethtml(String url){

        String html=null;
        HttpGet httpget = new HttpGet(url);     //创建Http请求实例，URL 如：https://cd.lianjia.com/
        // 模拟浏览器，避免被服务器拒绝，返回返回403 forbidden的错误信息
         HttpHost proxy=new HttpHost("103.61.153.100",53281);
        RequestConfig requestConfig=RequestConfig.custom().setProxy(proxy).build();
        httpget.setConfig(requestConfig);
        httpget.setHeader("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36");

        CloseableHttpResponse response = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();   // 使用默认的HttpClient
        try {
            response = httpclient.execute(httpget);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {     // 返回 200 表示成功
                html = EntityUtils.toString(response.getEntity(), "utf-8");     // 获取服务器响应实体的内容
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return html;

    }

    public static String decodeUnicode(String theString) {
        char aChar;
        int len = theString.length();
        StringBuffer outBuffer = new StringBuffer(len);
        for (int x = 0; x < len; ) {
            aChar = theString.charAt(x++);
            if (aChar == '\\') {
                aChar = theString.charAt(x++);
                if (aChar == 'u') {
                    // Read the xxxx
                    int value = 0;
                    for (int i = 0; i < 4; i++) {
                        aChar = theString.charAt(x++);
                        switch (aChar) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                value = (value << 4) + aChar - '0';
                                break;
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                                value = (value << 4) + 10 + aChar - 'a';
                                break;
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                                value = (value << 4) + 10 + aChar - 'A';
                                break;
                            default:
                                throw new IllegalArgumentException(
                                        "Malformed   \\uxxxx   encoding.");
                        }

                    }
                    outBuffer.append((char) value);
                } else {
                    if (aChar == 't')
                        aChar = '\t';
                    else if (aChar == 'r')
                        aChar = '\r';
                    else if (aChar == 'n')
                        aChar = '\n';
                    else if (aChar == 'f')
                        aChar = '\f';
                    outBuffer.append(aChar);
                }
            } else
                outBuffer.append(aChar);
        }
        return outBuffer.toString();
    }
}
