package com.example.m.meba_v2;

import android.content.Context;
import android.content.Intent;
import android.hardware.camera2.TotalCaptureResult;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity {

    private String usu;
    private String pass;
    private EditText Usuari;
    private EditText Pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void Click(View view)
    {

        usu = "Seba";
        pass ="123";
        Usuari= (EditText)findViewById(R.id.nameusu);
        String U = Usuari.getText().toString();
        Pass =(EditText)findViewById(R.id.passusu);
        String P = Pass.getText().toString();

        if (U.equals(usu)&& P.equals(pass))
        {
            Intent intent = new Intent(Login.this,MainActivity.class);
            startActivity(intent);
        }else
            {
                Context context = getApplicationContext();
                CharSequence text = "Errorde autenticacion";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
    }

    public void ClickCancel(View vew)
    {
        try {
            onDestroy();
        }catch (Exception e)
          {
              Context context = getApplicationContext();
              CharSequence text = "Goodbye";
              int duration = Toast.LENGTH_SHORT;

              Toast toast = Toast.makeText(context, text, duration);
              toast.show();
          }

    }

}


