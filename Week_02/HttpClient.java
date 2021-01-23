package nio;

import okhttp3.*;

import java.io.IOException;

/**
 * @author dzz
 */

public class HttpClient {

    public static void main(String[] args){
        //创建okHttpClient对象
        OkHttpClient mOkHttpClient = new OkHttpClient();
        //创建一个Request
        final Request request = new Request.Builder()
                .url("http://localhost:8801")
                .build();
        //新建一个call对象
        Call call = mOkHttpClient.newCall(request);
        try {
            //同步请求
            Response response = call.execute();
            if(response.isSuccessful()){
                //响应成功
                System.out.println("响应成功");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}