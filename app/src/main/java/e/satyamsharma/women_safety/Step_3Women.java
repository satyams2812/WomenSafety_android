package e.satyamsharma.women_safety;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Step_3Women extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_3_women);
    }

    public void homepage_next(View view) {
        startActivity(new Intent(this,HomePage.class));
    }

    public void bluetoth(View view) {
        Intent intent1 = new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
        startActivity(intent1);

    }
}
