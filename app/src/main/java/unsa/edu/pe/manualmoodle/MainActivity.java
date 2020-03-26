package unsa.edu.pe.manualmoodle;

import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ImageView img;
    private TextView texto;
    private Button btnEstudiante, btnDocente, btnAulavirtual;
    private int version;
    private FirebaseRemoteConfig remoteConfig = FirebaseRemoteConfig.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    @Override
    protected void onPostResume() {
        super.onPostResume();

        PackageInfo packageInfo;

        try {
            packageInfo = this.getPackageManager().getPackageInfo(getPackageName(),0);
            version = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        remoteConfig.setConfigSettings(new FirebaseRemoteConfigSettings.Builder().setDeveloperModeEnabled(true).build());
        HashMap<String,Object> actualizacion = new HashMap<>();
        actualizacion.put("versioncode",version);

        Task<Void> fetch= remoteConfig.fetch(0);
        fetch.addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                remoteConfig.activateFetched();
                version(version);
            }
        });
    }

    private void version(int version){
        int nueva = (int) remoteConfig.getLong("versioncode");
        String web=  remoteConfig.getString("web");
        String versionname = remoteConfig.getString("versionname");

        //version = la version del celular q tiene
        if (nueva > version){
            dialogActualizacionVersion(web,versionname);
            //Toast.makeText(MainActivity.this, "Existe una nueva Version!", Toast.LENGTH_SHORT).show();
        }
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
    }//fin de ClickMe

    public void dialogActualizacionVersion(final String url, String versionName){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
        View vista = getLayoutInflater().inflate(R.layout.dialog_actualizacion,null);

        TextView versiontxt = vista.findViewById(R.id.tv_version_name);
        Button cancelar, actualizar;
        cancelar = vista.findViewById(R.id.buttonCancel);
        actualizar = vista.findViewById(R.id.buttonActualizar);

        versiontxt.setText(versionName);

        dialogBuilder.setCancelable(false);
        dialogBuilder.setView(vista);
        final AlertDialog dialog = dialogBuilder.create();
        dialog.show();


        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, "Te perderas Novedades de la APP!!", Toast.LENGTH_SHORT).show();
            }
        });

        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirUrl  = new Intent(Intent.ACTION_VIEW,Uri.parse(url));
                startActivity(abrirUrl);
            }
        });



    }

}
