package e.satyamsharma.women_safety;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class Step_2Women extends AppCompatActivity {
    Switch s1;
    Switch s2;
    Context context;
    Intent intent1;
    LocationManager locationManager ;
    boolean GpsStatus ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_2_women);
        final Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        s1 = (Switch) findViewById(R.id.switchlive);
        s2 = (Switch) findViewById(R.id.switchheart);
        context = getApplicationContext();
        CheckGpsStatus();

        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true) {
                    Toast.makeText(Step_2Women.this, "Live Tracking On", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    startActivity(intent1);
                }
                else
                {
                    Toast.makeText(Step_2Women.this, "Live Beating Off", Toast.LENGTH_SHORT).show();
                }
            }
        });
        s2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true) {
                    Toast.makeText(Step_2Women.this, "Heart Beating On", Toast.LENGTH_SHORT).show();
                      v.vibrate(VibrationEffect.createOneShot(500,VibrationEffect.DEFAULT_AMPLITUDE));
                }
                else
                {
                    Toast.makeText(Step_2Women.this, "Heart Beating Off", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void step3(View view) {
        startActivity(new Intent(this, Step_3Women.class));

    }

    public void CheckGpsStatus(){
        locationManager = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
        assert locationManager != null;
        GpsStatus = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if(GpsStatus == true) {
           Toast.makeText(this,"Gps is On",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,"Gps is Off",Toast.LENGTH_SHORT).show();

        }
    }
}
