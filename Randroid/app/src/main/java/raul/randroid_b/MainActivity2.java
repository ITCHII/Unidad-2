package raul.randroid_b;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

/**
 * Created by Raúl Terrazas on 17/04/2016.
 */
public class MainActivity2 extends AppCompatActivity {
    private GridView gridView;
    private AdpImgs adtr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        gridView = (GridView) findViewById(R.id.GridView);
        adtr = new AdpImgs(this);
        gridView.setAdapter(adtr);
    }

}
