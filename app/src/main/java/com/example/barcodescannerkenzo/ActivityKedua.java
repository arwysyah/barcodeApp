package com.example.barcodescannerkenzo;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityKedua extends AppCompatActivity {
    public EditText nhasil;
    Button button3,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kedua);
        //TextView hasilnya = (TextView) findViewById(R.id.textHasil);
        final EditText nhasil = (EditText) findViewById(R.id.edurl);
        Bundle bundle = getIntent().getExtras();
        String bhasil = bundle.getString("name");
        nhasil.setText(String.valueOf(bhasil));
        //hasilnya.setText(bhasil);
        Button button = (Button) findViewById(R.id.buttonUtama);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityKedua.this, MainActivity.class);
                startActivity(i);   }
        });
        Button button2 = (Button) findViewById(R.id.btn_lihat);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityKedua.this, ActivityWeb.class);
                intent.putExtra("data1", nhasil.getText().toString());
                startActivity(intent);

            }
        });
        Button button3 = (Button) findViewById(R.id.btn_cek);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityKedua.this, ActivityWeb.class);
                intent.putExtra("data1", nhasil.getText().toString());
                startActivity(intent);
            }
        });
    }

}