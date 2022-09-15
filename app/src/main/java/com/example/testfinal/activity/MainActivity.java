package com.example.testfinal.activity;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.testfinal.R;
import com.example.testfinal.models.APIResponse;
import com.example.testfinal.retrofitutil.APIClint;
import com.example.testfinal.retrofitutil.APIInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
   public EditText name;
   public EditText password;
   public Button Submit;
   public TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
name=(EditText)findViewById(R.id.name);
password=(EditText)findViewById(R.id.password);
Submit=(Button)findViewById(R.id.button);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

DesplayUsersInformation("hi");
            }
        });

    }

    private void PerformLogin(){
String UserName = name.getText().toString();
String Password = password.getText().toString();
String Header = "content-type: application/json";
        Call<APIResponse> call= APIClint.GETAPIClint().create(APIInterface.class).performUserSignIn(UserName,Password);
        call.enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
                DesplayUsersInformation("Yes");

            }

            @Override
            public void onFailure(Call<APIResponse> call, Throwable t) {
DesplayUsersInformation("no");
            }
        });
    }
    public void DesplayUsersInformation(String Massage){
        Toast.makeText(MainActivity.this, Massage, Toast.LENGTH_SHORT).show();

    }
}