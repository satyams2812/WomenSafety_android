package e.satyamsharma.women_safety;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update_data extends AppCompatActivity {
    EditText pedit;
    EditText first;
    EditText second;
    EditText third;
    Button ver;
    Button update;
    SQLiteDatabase db;
    String ph;
    String eph1;
    String eph2;
    String eph3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);
        db = openOrCreateDatabase("ph", MODE_PRIVATE, null);
        db.execSQL("create table if not exists phone(sid INTEGER PRIMARY KEY AUTOINCREMENT,phone1 varchar(100),phone2 varchar(100),phone3 varchar(100))");

        first = (EditText) findViewById(R.id.editph1);
        second = (EditText) findViewById(R.id.editph2);
        third = (EditText) findViewById(R.id.editph3);

        update = (Button) findViewById(R.id.edit_update);

    }

//    public void verify(View view) {
//        ph = pedit.getText().toString();
//       String s = "select * from wom where Phone = '"  + ph + "' ";
//        Cursor c = db.rawQuery(s, null);
//        if (c.moveToNext()) {
//            Toast.makeText(this, "Verified ", Toast.LENGTH_SHORT).show();
//            startActivity(new Intent(this, After_login.class));
//        } else {
//            Toast.makeText(this, "Not Verified", Toast.LENGTH_SHORT).show();
//        }
//    }

    public void update_set(View view) {
        String s = "update phone set phone1 = '"  + eph1+"' || phone2 ='" + eph2+ " ' || phone3 = '"  + eph3 +  "' ";
       Cursor c = db.rawQuery(s,null);
        Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show();
    }
}
