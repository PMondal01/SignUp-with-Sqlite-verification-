package com.example.signupwithsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText editText_name_sign, editText_password_sign, editText_email_sign,editText_username_sign;
    private Button button_signUp;
    UserDetails userDetails;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editText_name_sign=findViewById(R.id.et_name_signup);
        editText_email_sign=findViewById(R.id.et_email_signup);
        editText_username_sign=findViewById(R.id.et_username_signup);
        editText_password_sign=findViewById(R.id.et_password_signup);

        button_signUp=findViewById(R.id.btn_login_signup);

        userDetails=new UserDetails();
        databaseHelper=new DatabaseHelper(this);

        button_signUp.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {

        String name = editText_name_sign.getText().toString();
        String email= editText_email_sign.getText().toString();
        String username=editText_username_sign.getText().toString();
        String password=editText_password_sign.getText().toString();

        userDetails.setName(name);
        userDetails.setEmail(email);
        userDetails.setUsername(username);
        userDetails.setPassword(password);



        long rowid=databaseHelper.insertData(userDetails);

        if(rowid>0)
        {
            Toast.makeText(getApplicationContext(),"Row "+rowid+" inserted" ,Toast.LENGTH_LONG).show();

        }else
        {
            Toast.makeText(getApplicationContext(),"Row "+rowid+"not inserted" ,Toast.LENGTH_LONG).show();
        }



    }
}
