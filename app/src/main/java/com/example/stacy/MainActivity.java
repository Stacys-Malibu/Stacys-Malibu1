package com.example.stacy;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static String LOG = MainActivity.class.getName();
    private EditText usuario, password;
    private Button buttonStart;
    private int counter=3;



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
                if (usuario.getText().toString().equals("maestro") &&
                        password.getText().toString().equals("123")) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MenuMaestroActivity.class);
                    startActivity(intent);
                }else if (usuario.getText().toString().equals("admi") &&
                        password.getText().toString().equals("456")) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MenuAdmiActivity.class);
                    startActivity(intent);
                }else if (usuario.getText().toString().equals("123456") &&
                        password.getText().toString().equals("789")) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                    startActivity(intent);
                } else if (usuario.getText().toString().equals("654321") &&
                        password.getText().toString().equals("789")) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), Menu2Activity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), "incorrecto ", Toast.LENGTH_SHORT).show();

                    counter--;

                    if (counter == 0) {
                        buttonStart.setEnabled(false);
                    }
                }


                /*String  CI,Password;
                CI= String.valueOf(usuario.getText().toString());
                Password= String.valueOf(password.getText().toString());

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
                            PutData putData = new PutData("http://192.168.0.5/Login/login.php", "POST", field, data);
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

            }*/
            }
        });
    }

            private void initViews() {
                buttonStart = (Button) findViewById(R.id.BotonIngresar);
                usuario = (EditText) findViewById(R.id.editTextTextPersonName);
                password = (EditText) findViewById(R.id.editTextTextPassword);
            }
        }