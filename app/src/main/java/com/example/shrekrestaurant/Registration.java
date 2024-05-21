package com.example.shrekrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shrekrestaurant.db.AppDatabase;
import com.example.shrekrestaurant.db.UserDao;
import com.example.shrekrestaurant.db.UserEntity;

import java.util.regex.Pattern;

public class Registration extends AppCompatActivity {

    EditText Fullname,password,name,repassword, email, phone;
    Button register;
    TextView Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Fullname = (EditText) findViewById(R.id.edttxt_fullname);
        password = (EditText) findViewById(R.id.edttxt_password);
        repassword = (EditText) findViewById(R.id.edttxt_confirmpass);
        name = (EditText) findViewById(R.id.edttxt_username);
        register = (Button) findViewById(R.id.btn_register);
        Login =(TextView) findViewById(R.id.tv_gotologin);
        email = (EditText) findViewById(R.id.edttxt_email);
        phone = (EditText) findViewById(R.id.edttxt_phone);
        String pass= password.getText().toString();
        String repass= repassword.getText().toString();

        // go to login page
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Registration.this,Login.class);
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creating user entity;

                UserEntity userEntity = new UserEntity();
                userEntity.setFullname(Fullname.getText().toString());
                userEntity.setPassword(password.getText().toString());
                userEntity.setName(name.getText().toString());
                userEntity.email = email.getText().toString();
                userEntity.phone = phone.getText().toString();

                Pattern specailCharPatten = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
                Pattern UpperCasePatten = Pattern.compile("[A-Z ]");
                Pattern lowerCasePatten = Pattern.compile("[a-z ]");
                Pattern digitCasePatten = Pattern.compile("[0-9 ]");

               // UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
              //  UserDao userDao = userDatabase.userDao();

             //   String username = name.getText().toString();

            //    UserEntity userEntity1 = userDao.CheckUsernamePassword(username);

                if (userEntity.getUsername().isEmpty() || userEntity.getPassword().isEmpty() || userEntity.getFullname().isEmpty()
                        || userEntity.email.isEmpty() || userEntity.phone.isEmpty() ){
                    Toast.makeText(getApplicationContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
                else if(userEntity.getPassword().length()<8){
                    Toast.makeText(getApplicationContext(), "Password should be more than 8 characters", Toast.LENGTH_SHORT).show();
                }else if(!specailCharPatten.matcher(userEntity.getPassword()).find()){
                    Toast.makeText(getApplicationContext(), "Password must have at least one special character!", Toast.LENGTH_SHORT).show();
                }else if(!UpperCasePatten.matcher(userEntity.getPassword()).find()){
                    Toast.makeText(getApplicationContext(), "Password must have at least one uppercase character!", Toast.LENGTH_SHORT).show();
                }else if(!lowerCasePatten.matcher(userEntity.getPassword()).find()){
                    Toast.makeText(getApplicationContext(), "Password must have at least one lowercase character!", Toast.LENGTH_SHORT).show();
                }else if(!digitCasePatten.matcher(userEntity.getPassword()).find()) {
                    Toast.makeText(getApplicationContext(), "Password must have atleast one digit character!", Toast.LENGTH_SHORT).show();
                }else if (!pass.equals(repass) ){
                    Toast.makeText(getApplicationContext(), "Passwords does not match!", Toast.LENGTH_SHORT).show();
          //      }else if(userEntity1 != null){
          //          Toast.makeText(getApplicationContext(), "the username is already in use!!! try another username", Toast.LENGTH_SHORT).show();
            //    }else if(userEntity.getPassword().length()<8){
              //      Toast.makeText(getApplicationContext(), "the password should be more than 8 characters", Toast.LENGTH_SHORT).show();
                } else{
                  //  do insert operation
                    AppDatabase userDatabase = AppDatabase.getDbInstance(getApplicationContext());
                    UserDao userDao = userDatabase.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            //user register
                            userDao.registerUser(userEntity);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "Your account has been registered successfully", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), Login.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    }).start();

                }

            }
        });
    }



}