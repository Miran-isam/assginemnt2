package mobile.project.bzu.myapplication.Activites;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import mobile.project.bzu.myapplication.Model.CV;
import mobile.project.bzu.myapplication.R;

public class MainActivity2 extends AppCompatActivity {
    EditText edt5;
    EditText edt6;
    EditText edt7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        Intent intent =getIntent();
        edt5 =findViewById(R.id.EDIUCATION);
        edt6 =findViewById(R.id.work);
        Button b2 =findViewById(R.id.acti2);
        edt7 =findViewById(R.id.languge);
        String s1 = intent.getStringExtra("Name");
        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View c){
                s();
            }

        });
    }

    public void s() {
        String EDU = String.valueOf(edt5.getText());
        String WORK = String.valueOf(edt6.getText());
        String LANG= String.valueOf(edt7.getText());


        CV cv = new CV();
        cv.setEducation(EDU);
        cv.setWork(WORK);
        cv.setLanguge(LANG);
        cv.getName();
        cv.getAge();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();

        Gson gson = new Gson();
        String cvString = gson.toJson(cv);

        editor.putString("0", cvString);
        editor.commit();
        editor.apply();
        Toast.makeText(this, "Data Saved:\n" + cvString,
                Toast.LENGTH_SHORT).show();


    }

    public void add(View view) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        Gson gson = new Gson();
        String str = prefs.getString("0", "");
        CV cv1 = gson.fromJson(str, CV.class);
        edt5.setText(cv1.getEducation());
        edt6.setText(cv1.getWork());
        edt7.setText(cv1.getLanguge());

        Toast.makeText(this, "text" + cv1
                , Toast.LENGTH_SHORT).show();
    }

}
