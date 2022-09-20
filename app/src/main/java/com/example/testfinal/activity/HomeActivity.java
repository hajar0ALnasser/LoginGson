package com.example.testfinal.activity;


        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.util.Log;
        import android.widget.ListView;
        import android.widget.Toast;

        import com.example.testfinal.R;
        import com.example.testfinal.models.APIResponseSec;
        import com.example.testfinal.models.EmptyBody;
        import com.example.testfinal.retrofitutil.APIClint;
        import com.example.testfinal.retrofitutil.SecondAPInterface;

        import java.util.ArrayList;

        import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;

public class HomeActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final ArrayList<NumbersView> arrayList = new ArrayList<NumbersView>();

        // add all the values from 1 to 15 to the arrayList
        // the items are of the type NumbersView
        arrayList.add(new NumbersView(R.drawable.ic_launcher_foreground, "1", "One"));
        arrayList.add(new NumbersView(R.drawable.ic_launcher_foreground, "2", "Two"));
        arrayList.add(new NumbersView(R.drawable.ic_launcher_foreground, "3", "Three"));
        arrayList.add(new NumbersView(R.drawable.ic_launcher_foreground, "4", "Four"));
        arrayList.add(new NumbersView(R.drawable.ic_launcher_foreground, "5", "Five"));
        arrayList.add(new NumbersView(R.drawable.ic_launcher_foreground, "6", "Six"));
        arrayList.add(new NumbersView(R.drawable.ic_launcher_foreground, "7", "Seven"));
        arrayList.add(new NumbersView(R.drawable.ic_launcher_foreground, "8", "Eight"));
        arrayList.add(new NumbersView(R.drawable.ic_launcher_foreground, "9", "Nine"));
        arrayList.add(new NumbersView(R.drawable.ic_launcher_foreground, "10", "Ten"));
        arrayList.add(new NumbersView(R.drawable.ic_launcher_foreground, "11", "Eleven"));
        arrayList.add(new NumbersView(R.drawable.ic_launcher_foreground, "12", "Twelve"));
        arrayList.add(new NumbersView(R.drawable.ic_launcher_foreground, "13", "Thirteen"));
        arrayList.add(new NumbersView(R.drawable.ic_launcher_foreground, "14", "Fourteen"));
        arrayList.add(new NumbersView(R.drawable.ic_launcher_foreground, "15", "Fifteen"));

        // Now create the instance of the NumebrsViewAdapter and pass
        // the context and arrayList created above
        NumbersViewAdapter numbersArrayAdapter = new NumbersViewAdapter(this, arrayList);

        // create the instance of the ListView to set the numbersViewAdapter
        ListView numbersListView = findViewById(R.id.listView);

        // set the numbersViewAdapter for ListView
        numbersListView.setAdapter(numbersArrayAdapter);
        CallSession();
    }

    public void CallSession() {
        final EmptyBody emptyBody = new EmptyBody();
        Call<APIResponseSec> call = APIClint.secGETAPIClin().create(SecondAPInterface.class).getSission(emptyBody);
        call.enqueue(new Callback<APIResponseSec>() {
            @Override
            public void onResponse(Call<APIResponseSec> call, Response<APIResponseSec> response) {

                if(response.isSuccessful()==true){
                    Log.d("Home",response.headers().toString());
                    if(response.body().isIs_admin()==true){

                        DesplayUsersInformation("yes");



                    }else if(response.body().isIs_admin()==false){
                        DesplayUsersInformation("som thing wrong accure");
                  Log.d("home",response.headers().toString());
                    }
                }
                else if(response.isSuccessful()==false){
                    DesplayUsersInformation("unsuccessful");
                }

            }

            @Override
            public void onFailure(Call<APIResponseSec> call, Throwable t) {
                Toast.makeText(HomeActivity.this, "no", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void DesplayUsersInformation(String Massage) {
        Toast.makeText(HomeActivity.this, Massage, Toast.LENGTH_SHORT).show();

    }
}