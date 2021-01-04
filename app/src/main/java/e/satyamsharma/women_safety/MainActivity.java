package e.satyamsharma.women_safety;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Animation a11, a22, a33, a44, a55;
    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = (TextView) findViewById(R.id.txtwelcome);
        t2 = (TextView) findViewById(R.id.txtto);
        t3 = (TextView) findViewById(R.id.txtalone);
        t4 = (TextView) findViewById(R.id.txtwe);
        img = (ImageView) findViewById(R.id.img_logo);
        a11 = AnimationUtils.loadAnimation(this, R.anim.text_anim);
        a22 = AnimationUtils.loadAnimation(this, R.anim.text_anim);
        a33 = AnimationUtils.loadAnimation(this, R.anim.text_anim);
        a44 = AnimationUtils.loadAnimation(this, R.anim.text_anim);
        a55 = AnimationUtils.loadAnimation(this, R.anim.image_anim);
        t1.setAnimation(a11);
        t2.setAnimation(a11);
        t3.setAnimation(a11);
        t4.setAnimation(a11);
        img.setAnimation(a55);
    }

    public void nextpage(View view) {
        startActivity(new Intent(this, Page_2.class));


    }
}
