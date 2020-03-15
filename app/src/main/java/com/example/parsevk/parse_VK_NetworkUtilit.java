package com.example.parsevk;

import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;

public class parse_VK_NetworkUtilit {
    //Создаем статические объекты класса String
    private static final String VK_API = "https://api.vk.com/";
    private static final String VK_USER_GET = "method/users.get";
    private static final String PARAM_USER_ID = "user_ids";
    private static final String PARAM_VERSION = "v";
    private static final String ACCES_TOKEN = "access_token";

    public parse_VK_NetworkUtilit() {
    }
    //генерируем URL из текстового поля в которое вводим id
    public static URL generateURL(String userId) {
        //генерируем Uri из текстового поля в которое вводим id и текстовых статических String
        Uri builtUri = Uri.parse("https://api.vk.com/method/users.get").buildUpon().appendQueryParameter("user_ids", userId).appendQueryParameter("v", "5.103").appendQueryParameter("access_token", "09ed17d109ed17d109ed17d1040983d988009ed09ed17d157e8244cb4665cc17a5d0854").build();
        URL url = null;

        try {
            //задаем url из uri
            url = new URL(builtUri.toString());
        } catch (MalformedURLException var4) {
            var4.printStackTrace();
        }
        return url;
    }
//получаем ответ от URL
    public static String getresponsefromURL(URL url) throws IOException {
        //открываем соединение
        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
        String var5;
        try {
            //открываем входной поток данных
            InputStream in = urlConnection.getInputStream();
            //с помощью scannera считываем данные с входного потока
            Scanner scanner = new Scanner(in);
            //выставляем разделитель
            scanner.useDelimiter("\\A");
            //проверяем пустой ли объект scanner или нет
            boolean hasInput = scanner.hasNext();
            if (!hasInput) {
                var5 = null;
                return var5;
            }
            var5 = scanner.next();
        }
        catch (UnknownHostException e){
            return null;
        }
            finally {
            urlConnection.disconnect();
        }
        return var5;
    }
}
