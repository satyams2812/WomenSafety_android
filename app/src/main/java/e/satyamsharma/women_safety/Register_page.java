package e.satyamsharma.women_safety;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register_page extends AppCompatActivity {
    Animation name1, dob1, add1, pho, emai, ps, bn;
    EditText nam;
    EditText dob;
    EditText address;
    EditText phone1;
    EditText email;
    EditText pass;
    Button bt1;
    String Name;
    String Date;
    String Addreass;
    String Phone;
    String Email;
    String Password;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        nam = (EditText) findViewById(R.id.txt_name);
        dob = (EditText) findViewById(R.id.txtdob);
        address = (EditText) findViewById(R.id.txt_add);
        phone1 = (EditText) findViewById(R.id.txt_phone);
        email = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.pss);
        bt1 = (Button) findViewById(R.id.register);
        name1 = AnimationUtils.loadAnimation(this, R.anim.text_anim);
        dob1 = AnimationUtils.loadAnimation(this, R.anim.text_anim);
        add1 = AnimationUtils.loadAnimation(this, R.anim.text_anim);
        pho = AnimationUtils.loadAnimation(this, R.anim.text_anim);
        emai = AnimationUtils.loadAnimation(this, R.anim.text_anim);
        ps = AnimationUtils.loadAnimation(this, R.anim.text_anim);
        bn = AnimationUtils.loadAnimation(this, R.anim.btn_anim);
        nam.setAnimation(name1);
        dob.setAnimation(dob1);
        address.setAnimation(add1);
        phone1.setAnimation(pho);
        email.setAnimation(emai);
        pass.setAnimation(ps);
        bt1.setAnimation(bn);
        db = openOrCreateDatabase("women", MODE_PRIVATE, null);
        db.execSQL("create table if not exists wom(sid INTEGER PRIMARY KEY AUTOINCREMENT ,Name varchar(100), Dob varchar(20),Address varchar(100),Phone varchar(100),Email varchar(100),Password varchar(100))");
    }

    public void register_sc(View view) {
        Name = nam.getText().toString();
        Date = dob.getText().toString();
        Addreass = address.getText().toString();
        Phone = phone1.getText().toString();
        Email = email.getText().toString();
        Password = pass.getText().toString();
        if (Name.isEmpty()) {
            Toast.makeText(this, "Enter Your Name", Toast.LENGTH_SHORT).show();
        } else if (Date.isEmpty()) {
            Toast.makeText(this, "Enter Your DOB", Toast.LENGTH_SHORT).show();

        } else if (Addreass.isEmpty()) {
            Toast.makeText(this, "Enter Your Addreass", Toast.LENGTH_SHORT).show();

        } else if (Phone.isEmpty()) {
            Toast.makeText(this, "Enter Phone Number", Toast.LENGTH_SHORT).show();

        } else if (Email.isEmpty()) {
            Toast.makeText(this, "Enter Your Email", Toast.LENGTH_SHORT).show();

        } else if (Password.isEmpty()) {
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();

        } else {

            insert();

        }

    }

    private void insert() {
        String s = "insert into wom (Name,Dob,Address,Phone,Email,Password) values ('" + Name + "','" + Date + "','" + Addreass + "','" + Phone + "','" + Email + "','" + Password + "')";
        db.execSQL(s);
        Toast.makeText(this, "Register Successfully", Toast.LENGTH_SHORT).show();
        nam.setText("");
        dob.setText("");
        address.setText("");
        phone1.setText("");
        email.setText("");
        pass.setText("");
      startActivity(new Intent(this,Page_2.class));
    }
}
