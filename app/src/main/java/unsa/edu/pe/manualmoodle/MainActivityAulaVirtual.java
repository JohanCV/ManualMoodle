package unsa.edu.pe.manualmoodle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivityAulaVirtual extends AppCompatActivity {

    private WebView aula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_aula_virtual);

        aula = findViewById(R.id.aula_web);
        aula.setWebViewClient(new WebViewClient());
        aula.loadUrl("http://dutic.unsa.edu.pe/aulavirtual/");
        aula.getSettings().setJavaScriptEnabled(true);
    }
}
