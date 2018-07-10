package unsa.edu.pe.manualmoodle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** llamando al btn sendMEstudiante */
    public void sendMEstudiante(View view) {
        Intent intent = new Intent(this, ManualEstudiante.class);

        startActivity(intent);
    }

    /** llamando al btn sendMDocente */
    public void sendMDocente(View view) {
        Intent intent = new Intent(this, ManualDocente.class);

        startActivity(intent);
    }

}
