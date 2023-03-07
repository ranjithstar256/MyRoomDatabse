package com.example.mydatabse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import kotlinx.coroutines.GlobalScope;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4,ed5;
    String s1,s2,s3,s4;
    DatabHelpr db;
    TextView tv;
    SuperStars ss;
    String pw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=findViewById(R.id.editTextTextPersonName);
        ed2=findViewById(R.id.editTextTextPersonName2);
        ed3=findViewById(R.id.editTextTextPersonName3);
        ed4=findViewById(R.id.editTextTextPersonName4);
        ed5=findViewById(R.id.editTextTextPersonName5);
        tv=findViewById(R.id.textView);
        db=new DatabHelpr(this);
    }

    public void savedat(View view) {
        s1=ed1.getText().toString();
        s2=ed2.getText().toString();
        Toast.makeText(this,
                s1+"\n"+s2, Toast.LENGTH_SHORT).show();

        ss = new SuperStars(s1,s2);


        Some c = new Some();
        c.execute();



      //  ContentValues cv = new ContentValues();
        //cv.put("Name",s1);
        //cv.put("Password",s2);
        //db.svdata(cv);



    }

    public void ret(View view) {
         pw = ed3.getText().toString();
        //String pw = db.retrpw(ed3.getText().toString());
       // Log.i("gfdgfgd", "ret: "+ed3.getText().toString());
        Ret c = new Ret();
        c.execute();

    }

    public void upd(View view) {
        s3=ed4.getText().toString();
        s4=ed5.getText().toString();
        Toast.makeText(this, s3+"\n"+s4, Toast.LENGTH_SHORT).show();


        ContentValues cv = new ContentValues();
        cv.put("Password",s4);

        db.updpw(s3,cv);

    }
    class Some extends AsyncTask{

        @Override
        protected Object doInBackground(Object[] objects) {
            DatabaseClientt.getInstance(getApplicationContext())
                    .getAppDatabase().taskDao().insert(ss);

            return null;
        }

    }
    class Ret extends AsyncTask{

        @Override
        protected Object doInBackground(Object[] objects) {
           ss= DatabaseClientt.getInstance(getApplicationContext())
                    .getAppDatabase().taskDao().getdesktn(pw);

            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            tv.setText(ss.getPassword().toString());

        }
    }
}