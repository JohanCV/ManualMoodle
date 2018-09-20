package unsa.edu.pe.manualmoodle;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivityAulaVirtual extends AppCompatActivity {

    private WebView aula;
    private ProgressBar pbar;
    private Handler handler;
    private Runnable runnable;
    private Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_aula_virtual);

        aula = findViewById(R.id.aula_web);
        aula.setWebViewClient(new WebViewClient());
        aula.loadUrl("http://dutic.unsa.edu.pe/aulavirtual/");
        aula.getSettings().setJavaScriptEnabled(true);

        pbar = findViewById(R.id.progresbar);
        pbar.setVisibility(View.VISIBLE);

        handler = new Handler();
        runnable = new Runnable(){

            @Override
            public void run() {
                pbar.setVisibility(View.GONE);
                timer.cancel();
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        },3000,3000);
    }
}
