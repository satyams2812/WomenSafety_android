package e.satyamsharma.women_safety;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class HomePage extends AppCompatActivity {
    RatingBar ratingBar;
    Switch s;
    TextView t;
    EditText dynmic;
    EditText send;
    SQLiteDatabase db;
    Button btn;
EditText iphone;
EditText imess;
    Random ran = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        t = (TextView) findViewById(R.id.txtheart);
        s = (Switch) findViewById(R.id.switchtaser);
        iphone = (EditText)findViewById(R.id.txtph);
        imess = (EditText)findViewById(R.id.txtmess);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        db = openOrCreateDatabase("ph", MODE_PRIVATE, null);
        db.execSQL("create table if not exists phone(sid INTEGER PRIMARY KEY AUTOINCREMENT,phone1 varchar(100),phone2 varchar(100),phone3 varchar(100))");
        btn = (Button) findViewById(R.id.smssend);
        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true) {
                    Toast.makeText(HomePage.this, "Connected", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(HomePage.this, "Disconnect", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(HomePage.this, String.valueOf(v), Toast.LENGTH_SHORT).show();
            }
        });



        final Handler handler = new Handler();
        Runnable run = new Runnable() {
            @Override
            public void run() {
                int z = ran.nextInt((95 - 80) + 1) + 80;
                t.setText(Integer.toString(z));
                handler.postDelayed(this, 1000);
            }
        };
        handler.post(run);

    }

    public void feedback(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Thanks");
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    public void update(View view) {
        startActivity(new Intent(this, Update_data.class));
    }

    public void exit(View view) {

        finishAffinity();

        System.exit(0);
    }

    public void sendmsg(View view) {
     btn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             try {
                 // Construct data
                 String apiKey = "apikey=" + "7BNgtFRHG6Q-YvzzhiPNfxsPgPeqzN87O9fEbrhcpJ";
                 String message = "&message=" + imess.getText().toString();
                 String sender = "&sender=" + "TXTLCL";
                 String numbers = "&numbers=" + iphone.getText().toString();

                 // Send data
                 HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
                 String data = apiKey + numbers + message + sender;
                 conn.setDoOutput(true);
                 conn.setRequestMethod("POST");
                 conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
                 conn.getOutputStream().write(data.getBytes(StandardCharsets.UTF_8));
                 final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                 //final StringBuffer stringBuffer = new StringBuffer();
                 String line;
                 while ((line = rd.readLine()) != null) {
                     // stringBuffer.append(line);
                     Toast.makeText(getApplicationContext(),"the message is"+line,Toast.LENGTH_SHORT).show();
                 }
                 rd.close();

                 // return stringBuffer.toString();
             } catch (Exception e) {
                 // System.out.println("Error SMS " + e);
                 Toast.makeText(getApplicationContext(),"Message Not Sent"+e,Toast.LENGTH_SHORT).show();
                 // return "Error "+e;
             }
         }
     });
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

    }
}
