package e.satyamsharma.women_safety;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Page_2 extends AppCompatActivity {
    Animation a11, a22, a33, a44, a55, a66, a77, a88;
    ImageView img;
    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    EditText e11;
    EditText e2;
    Button btn;
    String username;
    String password;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_2);
        db = openOrCreateDatabase("women", MODE_PRIVATE, null);
        db.execSQL("create table if not exists wom(sid INTEGER PRIMARY KEY AUTOINCREMENT ,Name varchar(100), Dob varchar(20),Address varchar(100),Phone varchar(100),Email varchar(100),Password varchar(100))");
        img = (ImageView) findViewById(R.id.img_logo1);
        t1 = (TextView) findViewById(R.id.txt_login);
        t2 = (TextView) findViewById(R.id.lblemail);
        t3 = (TextView) findViewById(R.id.lblpass);
        t4 = (TextView) findViewById(R.id.newsign);
        e11 = (EditText) findViewById(R.id.txtemail);
        e2 = (EditText) findViewById(R.id.txtpass);
        btn = (Button) findViewById(R.id.btn_login);
        a11 = AnimationUtils.loadAnimation(this, R.anim.image_anim);
        a22 = AnimationUtils.loadAnimation(this, R.anim.text_anim);
        a33 = AnimationUtils.loadAnimation(this, R.anim.text_anim);
        a44 = AnimationUtils.loadAnimation(this, R.anim.text_anim);
        a55 = AnimationUtils.loadAnimation(this, R.anim.text_anim);
        a66 = AnimationUtils.loadAnimation(this, R.anim.text_anim);
        a77 = AnimationUtils.loadAnimation(this, R.anim.text_anim);
        a88 = AnimationUtils.loadAnimation(this, R.anim.btn_anim);
        img.setAnimation(a11);
        t1.setAnimation(a11);
        t2.setAnimation(a22);
        t3.setAnimation(a33);
        t4.setAnimation(a44);
        e11.setAnimation(a55);
        e2.setAnimation(a66);
        btn.setAnimation(a77);

    }

    public void login_next(View view) {
        username = e11.getText().toString();
        password = e2.getText().toString();
        if (username.isEmpty()) {
            Toast.makeText(this, "Enter Your Username", Toast.LENGTH_SHORT).show();
        } else if (password.isEmpty()) {
            Toast.makeText(this, "Enter Your Password", Toast.LENGTH_SHORT).show();
        } else {
            fillvalue();
        }


    }

    private void fillvalue() {

        String s = "select * from wom where Email = '" + username + "' and Password = '" + password + "'";
        Cursor c = db.rawQuery(s, null);
        if (c.moveToNext()) {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, After_login.class));
        } else {
            Toast.makeText(this, "Invalid Password", Toast.LENGTH_SHORT).show();
        }
    }


    public void register(View view) {
        startActivity(new Intent(this, Register_page.class));
    }
}
