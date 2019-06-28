package com.example.signupwithsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText_username_login, editText_password_login;
    private Button button_login;
    private Button button_signin;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_username_login=findViewById(R.id.et_username);
        editText_password_login=findViewById(R.id.et_pass);
        button_login=findViewById(R.id.btn_login);
        button_signin=findViewById(R.id.btn_sign_login);


        button_login.setOnClickListener(this);
        button_signin.setOnClickListener(this);

        databaseHelper=new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase=databaseHelper.getWritableDatabase();
    }

    @Override
    public void onClick(View view) {

       String username= editText_username_login.getText().toString();
       String password=editText_password_login.getText().toString();

        if(view.getId()==R.id.btn_login)
        {

            Boolean result = databaseHelper.findPassword(username,password);

            if(result==true)
            {

                Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);

            }else {

                Toast.makeText(getApplicationContext(),"Login Failed" ,Toast.LENGTH_LONG).show();

            }

        }else if(view.getId()==R.id.btn_sign_login)
        {
            Intent intent=new Intent(MainActivity.this,SignUpActivity.class);
            startActivity(intent);
        }

    }
}
