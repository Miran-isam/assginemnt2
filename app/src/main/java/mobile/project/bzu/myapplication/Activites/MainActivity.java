package mobile.project.bzu.myapplication.Activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import mobile.project.bzu.myapplication.Model.CV;
import mobile.project.bzu.myapplication.R;

public class MainActivity extends AppCompatActivity {
    EditText edt1 ;
    EditText edt2;
    EditText edt3 ;
    EditText edt4 ;
    EditText edt5 ;
    String name;
    Integer phone;
    private Spinner spiner;
    public static final String DATA ="DATA";
    public static final String FLAG ="FLAG";
    public static final String NAME="NAME";
    SharedPreferences prefs;
    private boolean flag=false;
    ArrayAdapter<String> arrayadapter;
    ArrayList<CV> ex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 =findViewById(R.id.name);
        edt2 =findViewById(R.id.email);
        edt3 =findViewById(R.id.phone);
        edt4 =findViewById(R.id.hobie);
        edt5 =findViewById(R.id.agee);
        spiner=findViewById(R.id.spinner);
        ex=new ArrayList();
        spineermothed();
        //vieww();
        Button b =findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View c){
                s();
            }

        });

    }

    public void s() {

      name = String.valueOf(edt1.getText());
        String emaill = String.valueOf(edt2.getText());
        String hobb= String.valueOf(edt4.getText());
        phone= Integer.valueOf(String.valueOf(edt3.getText()));
        Integer aggg = Integer.valueOf(String.valueOf(edt5.getText()));
        String s5 =spiner.getSelectedItem().toString().trim();
        CV cv = new CV();
        cv.setName(name);
        cv.setEmail(emaill);
        cv.setHobbies(hobb);
        cv.setPhone(phone);
        cv.setAge(aggg);
        cv.setGender(s5);


      prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
       // flag=prefs.getBoolean(FLAG,false);
        Gson gson = new Gson();
        String cvString = gson.toJson(cv);

    editor.putString("0", cvString);

    editor.commit();
    // editor.apply();
    Toast.makeText(this, "Data Saved:\n" + cvString,
            Toast.LENGTH_SHORT).show();
}



    public void activ2(View view) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        Gson gson = new Gson();


        String str = prefs.getString("0", "");
        CV cv1 = gson.fromJson(str, CV.class);
        //String name1=cv1.getName().toString();
        edt1.setText(cv1.getName());
    //    CV cvs = new CV();
      //  Integer m=cv1.getAge();
        edt2.setText(cv1.getEmail());
        edt4.setText(cv1.getHobbies());
       // if(key.eq)
     //
        edt5.setText("" +cv1.getAge());
        edt3.setText("" +cv1.getPhone());

        Toast.makeText(this, "text" + cv1
                , Toast.LENGTH_SHORT).show();

    }

    private void spineermothed() {
        ArrayList<String> aray =new ArrayList<>();
        aray.add("Male");
        aray.add("Female");
        ArrayAdapter<String> arrayadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,aray);
        spiner.setAdapter(arrayadapter);
    }
    public void go(View view) {
        CV m =new CV();
      // edi
        Intent intent;
        intent = new Intent(this, MainActivity2.class);
        String s1 = m.getName();
        intent.putExtra("Name",s1);
        startActivity(intent);
    }

}