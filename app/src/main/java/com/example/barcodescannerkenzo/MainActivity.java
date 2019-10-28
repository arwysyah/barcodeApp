package com.example.barcodescannerkenzo;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextCode;
    private Button buttonBarcode, buttonQRCode, buttonSearch;
    TextView hasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextCode = (EditText) findViewById(R.id.editTextCode);
        buttonBarcode = (Button) findViewById(R.id.buttonBarcode);
        buttonBarcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scanBarcode("PRODUCT_MODE");
            }
        });

        buttonQRCode = (Button) findViewById(R.id.buttonQRCode);
        buttonQRCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scanBarcode("QR_CODE_MODE");
            }
        });

        final EditText name = (EditText) findViewById(R.id.editTextCode);
        Button button = (Button) findViewById(R.id.buttonSrc);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,ActivityKedua.class);
                i.putExtra("name", name.getText().toString());
                startActivity(i);
            }
        });

    }

    //method scanBarcode
    private void scanBarcode(String mode) {
        try {
            Intent intent = new Intent("com.google.zxing.client.android.SCAN");
            intent.putExtra("SCAN_MODE", mode); // "PRODUCT_MODE for bar codes
            startActivityForResult(intent, 1);

        } catch (Exception e) {

            Uri marketUri = Uri.parse("market://details?id=com.google.zxing.client.android");
            Intent marketIntent = new Intent(Intent.ACTION_VIEW,marketUri);
            startActivity(marketIntent);

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {

            if (resultCode == RESULT_OK) {
                editTextCode.setText("");
                String contents = data.getStringExtra("SCAN_RESULT");
                Toast.makeText(getBaseContext(), "Hasil :"+contents, Toast.LENGTH_SHORT).show();
                editTextCode.setText(contents);
            }

        }
    }

    public void keActivitiKedua(View view) {
        Intent i = new Intent(MainActivity.this,ActivityKedua.class);
        startActivity(i);
    }
}