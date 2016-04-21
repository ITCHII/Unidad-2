package raul.mp3;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    MediaPlayer mp3;
    Button btnNS;
    int position = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btnNS = (Button)findViewById(R.id.btnNS);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void destruir(){
        if (mp3 !=null)
            mp3.release();
    }
    public void iniciar(View v){
        destruir();
        mp3 = MediaPlayer.create(this, R.raw.Hello);
        mp3.start();
        String op = btnNS.getText().toString();
        if (op.equals("no reproducir en forma circular"))
            mp3.setLooping(false);
        else
            mp3.setLooping(true);
    }
    public void pausar(View v) {
        if (mp3 != null && mp3.isPlaying()) {
            position = mp3.getCurrentPosition();
            mp3.pause();
        }
    }
    public void continuar(View v) {
        if (mp3 != null && mp3.isPlaying() == false) {
            mp3.seekTo(position);
            mp3.start();
        }
    }
    public void detener(View v) {
        if (mp3 != null) {
            mp3.stop();
            position = 0;
        }
    }
    public void circular(View v) {
        detener(null);
        String op = btnNS.getText().toString();
        if (op.equals("no reproducir en forma circular"))
            btnNS.setText("reproducir en forma circular");
        else
            btnNS.setText("no reproducir en forma circular");
    }
}
