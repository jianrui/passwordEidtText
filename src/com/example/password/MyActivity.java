package com.example.password;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MyActivity extends Activity implements View.OnClickListener{

    private PasswordEditText mPwdEdit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mPwdEdit = (PasswordEditText) findViewById(R.id.id_pwd);
        findViewById(R.id.button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                Toast.makeText(this,mPwdEdit.getText(),Toast.LENGTH_LONG).show();
                break;
        }
    }
}
