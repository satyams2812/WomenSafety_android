package e.satyamsharma.women_safety;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class After_login extends AppCompatActivity {
    EditText ph1;
    EditText ph2;
    EditText ph3;
    String num1;
    String num2;
    String num3;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);
        ph1 = (EditText) findViewById(R.id.ph1);
        ph2 = (EditText) findViewById(R.id.ph2);
        ph3 = (EditText) findViewById(R.id.ph3);
        db = openOrCreateDatabase("ph", MODE_PRIVATE, null);
        db.execSQL("create table if not exists phone(sid INTEGER PRIMARY KEY AUTOINCREMENT,phone1 varchar(100),phone2 varchar(100),phone3 varchar(100))");

    }

    public void Step_2(View view) {
        num1 = ph1.getText().toString();
        num2 = ph2.getText().toString();
        num3 = ph3.getText().toString();
        startActivity(new Intent(this, Step_2Women.class));
        String s = "insert into phone(Phone1,Phone2,Phone3)values('" + ph1 + "' , '" + ph2 + "' , '" + ph3 + "' )";
        db.execSQL(s);
    }
}
