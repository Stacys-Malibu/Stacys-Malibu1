package com.example.stacy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static String LOG = MainActivity.class.getName();
    private EditText usuario, password;
    private Button buttonStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(LOG, "onCreate");
        initViews();
        addEvents();

    }


    private void addEvents(){
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  CI,Password;
                CI= String.valueOf(usuario.getText());
                Password= String.valueOf(password.getText());

                if(CI.equals("123")&&Password.equals("000")){
                    //Start ProgressBar first (Set visibility VISIBLE)
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String[] field = new String[2];
                            field[0] = "CI";
                            field[1] = "Password";
                            //Creating array for data
                            String[] data = new String[2];
                            data[0] = CI;
                            data[1] = Password;
                            PutData putData = new PutData("http://192.168.40.1/Login/login.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if(result.equals("Login Success")){
                                        Intent intent =new Intent(getApplicationContext(), MenuAdmiActivity.class);
                                        startActivity(intent);
                                        finish();

                                    }else{
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                            //End Write and Read data with URL
                        }
                    });
                }else{
                    Toast.makeText(getApplicationContext(),"All files required",Toast.LENGTH_SHORT).show();
                }


            }
        });


    }
    private void initViews(){
        buttonStart = (Button) findViewById(R.id.BotonIngresar);
        usuario=(EditText) findViewById(R.id.editTextTextPersonName);
        password=(EditText) findViewById(R.id.editTextTextPassword);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.e(LOG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(LOG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(LOG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(LOG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(LOG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(LOG, "onDestroy");
    }
}