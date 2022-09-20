package com.example.testfinal.activity;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.testfinal.R;
import com.example.testfinal.models.APIResponse;
import com.example.testfinal.models.UserInfo;
import com.example.testfinal.retrofitutil.APIClint;
import com.example.testfinal.retrofitutil.APIInterface;

import java.io.IOException;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;

public class MainActivity extends AppCompatActivity {
   public EditText name;
   public EditText password;
   public Button Submit;
   public TextView login;
public String sessionid;

    public String getSessionid() {
        return sessionid;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
name=(EditText)findViewById(R.id.name);
password=(EditText)findViewById(R.id.password);
Submit=(Button)findViewById(R.id.button);
login=(TextView)findViewById(R.id.login);


      Submit.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            //  Intent intent= new Intent(MainActivity.this,HomeActivity.class);
           //   startActivity(intent);
              PerformLogin();
          }
      });
    }

    public void PerformLogin(){


 final UserInfo userInfo=new UserInfo(name.getText().toString(), password.getText().toString());
 //userInfo.setLogin(name.getText().toString());
 //userInfo.setPassword(password.getText().toString());

        Call<APIResponse> call= APIClint.GETAPIClint().create(APIInterface.class).performUserSignIn(userInfo);
        call.enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {

if(response.isSuccessful()==true){
if(response.body().isIs_admin()==true){


Log.d("a",response.headers().toString());
sessionid= response.body().getSession_id();
    DesplayUsersInformation(sessionid);
   Intent intent= new Intent(MainActivity.this,HomeActivity.class);
   startActivity(intent);

}else if(response.body().isIs_admin()==false){
    DesplayUsersInformation("wrong login info");
}
}
else if(response.isSuccessful()==false){
    DesplayUsersInformation("unsuccessful");
}





            }

            @Override
            public void onFailure(Call<APIResponse> call, Throwable t) {
DesplayUsersInformation("not working");

            }
        });
    }
    public void DesplayUsersInformation(String Massage){
        Toast.makeText(MainActivity.this, Massage, Toast.LENGTH_SHORT).show();

    }
}