package raul.gatoleonsound;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
public class MainActivity extends AppCompatActivity {
    public void Cat(View v){
        MediaPlayer mp = MediaPlayer.create(this,R.raw.Cat);
        mp.start();
    }
    public void Lion (View v){
        MediaPlayer mp = MediaPlayer.create(this,R.raw.Lion);
        mp.start();
    }
}