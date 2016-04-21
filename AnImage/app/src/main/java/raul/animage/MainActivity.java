package raul.animage;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView ImV;
    Button btnG, btnT, btnA, btnTransp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImV = (ImageView)findViewById(R.id.IeVw);
        btnG = (Button)findViewById(R.id.btnGirar);
        btnT = (Button)findViewById(R.id.btnTrasladar);
        btnA = (Button)findViewById(R.id.btnAmpliar);
        btnTransp = (Button)findViewById(R.id.btnTransparencia);
        btnG.setOnClickListener(this);
        btnT.setOnClickListener(this);
        btnA.setOnClickListener(this);
        btnTransp.setOnClickListener(this);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnGirar:
                Animation giro;
                giro = AnimationUtils.loadAnimation(this, R.anim.girar);
                giro.reset();
                ImV.startAnimation(giro);
                break;
            case R.id.btnTrasladar:
                Animation trasladar;
                trasladar = AnimationUtils.loadAnimation(this, R.anim.tras);
                trasladar.reset();
                ImV.startAnimation(trasladar);
                break;
            case R.id.btnAmpliar:
                Animation ampliar;
                ampliar=AnimationUtils.loadAnimation(this, R.anim.ampliar);
                ampliar.reset();
                ImV.startAnimation(ampliar);
                break;
            case R.id.btnTransparencia:
                Animation trans;
                trans = AnimationUtils.loadAnimation(this, R.anim.trans);
                trans.reset();
                ImV.startAnimation(trans);
                break;
            default:
                break;
        }
    }
 }
