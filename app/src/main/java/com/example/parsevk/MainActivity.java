package com.example.parsevk;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import static com.example.parsevk.parse_VK_NetworkUtilit.generateURL;
import static com.example.parsevk.parse_VK_NetworkUtilit.getresponsefromURL;

public class MainActivity extends AppCompatActivity {
    Button B_Search;
    TextView TW_inrotmation_about_user;
    EditText ET_Id_for_find;
    TextView Error_message;
    private ProgressBar Loading_indicator;
    private void showResultsTextView(){
        TW_inrotmation_about_user.setVisibility(View.VISIBLE);
        Error_message.setVisibility(View.INVISIBLE);
    }

    private void showErrorTextView(){
        TW_inrotmation_about_user.setVisibility(View.INVISIBLE);
        Error_message.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        B_Search=findViewById(R.id.Search);
        Error_message = findViewById(R.id.tv_error_message);
        Loading_indicator = findViewById(R.id.pb_indicar_loading);
        TW_inrotmation_about_user=findViewById(R.id.Information_about_user);
        ET_Id_for_find=findViewById(R.id.Id_for_find);
        B_Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                URL getgenereteURL = generateURL(ET_Id_for_find.getText().toString()); // создаем объект URL и присваем ему значение URL, который создаем из id в текстовом поле, который отправляется в соответcтвующую функцию в классе parse_VK_NetworkUtiliti
                new Vkquery().execute(getgenereteURL);

            }
        });
    }

    //создаем вложенный класс для парралельного потока
    class Vkquery extends AsyncTask<URL, Void, String>{
        @Override
                protected void onPreExecute(){
                Loading_indicator.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(URL... urls) {
            String responseURL; // создаем объект String
            responseURL = null;
            try {
                responseURL = getresponsefromURL(urls[0]);//присваиваем URL
            } catch (IOException e) {
                e.printStackTrace();
            }
            return responseURL;
        }

        @Override
        protected void onPostExecute(String responseURL) {
            String firstName = null;
            String lastName = null;
            if(responseURL!=null&&!responseURL.equals("")) {
                try {
                    JSONObject jsoResponse = new JSONObject(responseURL);
                    JSONArray jsonArray = jsoResponse.getJSONArray("response");
                    JSONObject userInfo = jsonArray.getJSONObject(0);
                    firstName = userInfo.getString("first_name");
                    lastName = userInfo.getString("last_name");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                showResultsTextView();
                String resultString = "Имя: "+ firstName + "\n" +"Фамилия: "+ lastName;
                TW_inrotmation_about_user.setText(resultString);

            }
            else{
                 showErrorTextView();
            }
            Loading_indicator.setVisibility(View.INVISIBLE);

        }
    }
}

