package unsa.edu.pe.manualmoodle;

import android.app.PendingIntent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private View view;
    private ImageView img;
    private TextView texto;
    private Button btnEstudiante, btnDocente, btnAulavirtual;

    NotificationCompat.Builder mNotificaBuider;
    int notificationid = 3415;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PackageInfo pinfo = null;
        try {
            pinfo = getPackageManager().getPackageInfo(getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        int versionCode = pinfo.versionCode;
        String versionName = pinfo.versionName;
        if (versionCode != versionCode && versionName != versionName){

            Uri webpage = Uri.parse("https://play.google.com/store/apps/details?id=unsa.edu.pe.manualmoodle");
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

            mNotificaBuider = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.logodutic)
                    .setContentTitle("Manual Moodle")
                    .setContentText("Hay una actualizacion del Manual")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    // Set the intent that will fire when the user taps the notification
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);

            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
            notificationManager.notify(notificationid,mNotificaBuider.build());
        }


        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_round);

        img = findViewById(R.id.img_dutic);
        texto = findViewById(R.id.text_bienvenida);
        btnEstudiante = findViewById(R.id.btn_estudiante);
        btnDocente = findViewById(R.id.btn_docente);
        btnAulavirtual = findViewById(R.id.btn_pag_dutic);

        Animation myanimacion = AnimationUtils.loadAnimation(this, R.anim.transition_start);
        img.startAnimation(myanimacion);
        texto.startAnimation(myanimacion);
        btnEstudiante.startAnimation(myanimacion);
        btnDocente.startAnimation(myanimacion);
        btnAulavirtual.startAnimation(myanimacion);
    }

    /** llamando al btn sendMEstudiante */
    public void clickME(View view) {
        Intent i = null;

        switch (view.getId()){
            case R.id.btn_estudiante:
                i = new Intent(this, MainActivityEstudiante.class);
                break;
            case R.id.btn_docente:
                i = new Intent(this, MainActivityDocente.class);
                break;
            case R.id.btn_pag_dutic:

                i = new Intent(this, MainActivityAulaVirtual.class);
        }
        startActivity(i);
    }

}
