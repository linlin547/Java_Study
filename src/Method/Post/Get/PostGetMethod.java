package Method.Post.Get;
/**
 * Created by mac-li on 16/4/19.
 */

import org.apache.http.*;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class PostGetMethod {
    private RequestConfig requestConfig;
    private CloseableHttpClient httpclient;
    private CloseableHttpResponse response;
    private CookieStore cookies;

    public PostGetMethod() {
        //可关闭连接
        httpclient = HttpClients.createDefault();
        //time out
        requestConfig = RequestConfig.custom()
                .setConnectTimeout(5000).setConnectionRequestTimeout(1000)
                .setSocketTimeout(5000).build();
    }

    //get参数设置
    public URI reUri(String url, Map<Object, Object> mapx) throws URISyntaxException {
        URIBuilder uribuilder = new URIBuilder();
        uribuilder.setScheme("http");
        uribuilder.setHost(url);
        for (Object strs: mapx.keySet()) {
            //拼接key－Value
            uribuilder.setParameter(String.valueOf(strs), String.valueOf(mapx.get(strs)));
        }
        URI uri = uribuilder.build();

        return uri;
    }

    public BufferedReader getUrl(URI url) throws URISyntaxException, IOException {
        //URL需要重新做拼接，调用reUri(String url, Map<Object, Object> mapx)
        //Get
        HttpGet httpget = new HttpGet(url);
        httpget.setConfig(requestConfig);
        response = httpclient.execute(httpget);
        //创建实体对象
        HttpEntity entity = response.getEntity();
        return this.readCotent(entity);
    }

    public BufferedReader postUrl(String url, Map<Object, Object> map) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> nvps = new ArrayList<>();
        //添加参数
        for (Object str : map.keySet()) {
            nvps.add(new BasicNameValuePair(String.valueOf(str), String.valueOf(map.get(str))));
        }
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
        //执行
        response = httpclient.execute(httpPost);
        //返回数据
        HttpEntity postentity = response.getEntity();
        return this.readCotent(postentity);

    }

    public BufferedReader readCotent(HttpEntity httpEntity) throws IOException {
        BufferedReader bufferedReader = null;
        String data;
        try {
            if (httpEntity != null) {
                //读取实体数据
                bufferedReader = new BufferedReader(new InputStreamReader(httpEntity.getContent()));
                while ((data = bufferedReader.readLine()) != null) {
                    System.out.printf("返回数据:");
                    System.out.println(data);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpclient.close();
            response.close();

        }
        return bufferedReader;
    }

    public List<Cookie> getCookies() {
        //获取cookie
        cookies = new BasicCookieStore();
        List<Cookie> cookieList = cookies.getCookies();
        for (int i = 0; i < cookieList.size(); i++) {
            System.out.println(cookieList.get(i).toString());
        }
        return cookieList;
    }

    public Header[] getHeaders() {
        //获取header
        Header[] headers = response.getAllHeaders();
        for (int i = 0; i < headers.length; i++) {
            System.out.println(headers[i].getName() + "==" + headers[i].getValue());
        }
        return headers;
    }

    public int getCode() {
        //返回状态码
        int code = response.getStatusLine().getStatusCode();
        System.out.printf("code: %s%n", String.valueOf(code));
        return code;
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
//        PostGetMethod testclient = new PostGetMethod();
//        Map<Object, Object> mapp = new HashMap<>();
//        mapp.put("xx", "xx");

//        mapp.put("xx", "xxx");
//        mapp.put("xx", "xxx");
//        mapp.put("xx", "1");
//        mapp.put("xx", "xxx");
//        mapp.put("xx", "xxx");
////        testclient.postUrl("http://xxx.do", mapp);
//        URI ll = testclient.reUri("xxx.do",mapp);
//        System.out.println(testclient.getUrl(ll).toString());
    }
}
