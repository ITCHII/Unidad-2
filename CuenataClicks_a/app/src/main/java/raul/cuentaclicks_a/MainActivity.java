package raul.cuentaclicks_a;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    private int Click = 0, Long = 0, Touch = 0, Focus = 0, Key = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button onClick =(Button)findViewById(R.id.btn_onClick);
        final TextView c_onclick = (TextView)findViewById(R.id.lbl_onClick);
        onClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Click++;
                c_onclick.setText(" " + Click);
            }
        });
        Button onLong=(Button)findViewById(R.id.btn_onLong);
        final TextView c_onlong=(TextView)findViewById(R.id.lbl_onLong);
        onLong.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Long++;
                c_onlong.setText(" " + Long);
                return true;
            }
        });
        Button onTouch=(Button)findViewById(R.id.btn_onTouch);
        final TextView c_onTouch=(TextView)findViewById(R.id.lbl_onTouch);
        onTouch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP){
                    Touch++;
                    c_onTouch.setText(" " + Touch);
                    return true;
                }
                return false;
            }
        });
        EditText onKey= (EditText)findViewById(R.id.txt_onKey);
        final TextView c_onKey=(TextView)findViewById(R.id.lbl_onKey);
        onKey.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if((event.getAction()==KeyEvent.ACTION_DOWN)&&(keyCode == KeyEvent.KEYCODE_1)){
                    Key++;
                    c_onKey.setText(" " + Key);
                    return true;
                }
                return true;
            }
        });
        EditText onFocus=(EditText)findViewById(R.id.txt_onFocus);
        //Button onFocus=(Button)findViewById(R.id.btn_onfocus);
        final TextView c_onFocus=(TextView)findViewById(R.id.lbl_onFocus);
        onFocus.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    Focus++;
                    c_onFocus.setText(" " + Focus);
                }
            }
        });
    }
}