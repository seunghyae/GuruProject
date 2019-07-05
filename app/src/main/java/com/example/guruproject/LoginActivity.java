package com.example.guruproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.guruproject.database.Database;

public class LoginActivity extends AppCompatActivity {
    EditText editId;
    EditText editPassword;

    Database db;

    TextView txtvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db=Database.getInstance(getApplicationContext());

        editId = findViewById(R.id.editID);
        editPassword=findViewById(R.id.editPassword);

        txtvResult=findViewById(R.id.txtvResult);

        Button btn_reg=findViewById(R.id.Join);
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), JoinActivity.class);
                startActivity(intent);
            }
        });

        Button btn_login=findViewById(R.id.LogIn);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean check = db.checkMember(editId.getText().toString(), editPassword.getText().toString());
                if(check==true){
                    txtvResult.setText("체크결과=로그인성공");

                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }else{
                    txtvResult.setText("체크결과=로그인실패");
                }
            }
        });

    }

}
