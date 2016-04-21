package raul.recorder;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
public class MainActivity extends ActionBarActivity implements MediaPlayer.OnCompletionListener {
    TextView txtProg;
    MediaRecorder mr;
    MediaPlayer mp;
    File fl;
    Button btnG, btnD, btnR;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
            txtProg=(TextView)findViewById(R.id.txtProg);
            btnG = (Button)findViewById(R.id.btnGrab);
            btnD = (Button)findViewById(R.id.btnDet);
            btnR = (Button)findViewById(R.id.btnRep);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void onCompletion(MediaPlayer mp) {
        btnG.setEnabled(true);
        btnD.setEnabled(true);
        btnR.setEnabled(true);
        txtProg.setText("Listo");
    }
    public void Grabar(View v) {
        mr = new MediaRecorder();
        mr.setAudioSource(MediaRecorder.AudioSource.MIC);
        mr.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mr.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        File path = new File(Environment.getExternalStorageDirectory()
                .getPath());
        try {
            fl = File.createTempFile("Temporal", ".3gp", path);
        } catch (IOException e) {
        }
        mr.setOutputFile(fl.getAbsolutePath());
        try {
            mr.prepare();
        } catch (IOException e) {
        }
        mr.start();
        txtProg.setText("Grabando");
        btnG.setEnabled(false);
        btnD.setEnabled(true);
    }
    public void Detener(View v) {
        mr.stop();
        mr.release();
        mp = new MediaPlayer();
        mp.setOnCompletionListener(this);
        try {
           mp.setDataSource(fl.getAbsolutePath());
        } catch (IOException e) {
        }
        try {
            mp.prepare();
        } catch (IOException e) {
        }
        btnG.setEnabled(true);
        btnD.setEnabled(false);
        btnR.setEnabled(true);
        txtProg.setText("Listo para reproducir");
    }
    public void Reproducir(View v) {
        mp.start();
        btnG.setEnabled(false);
        btnD.setEnabled(false);
        btnR.setEnabled(false);
        txtProg.setText("Reproduciendo");
    }
}