package unsa.edu.pe.manualmoodle;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

public class ProgressDialog {
    private Activity activity;
    private AlertDialog alertDialog;

    ProgressDialog(Activity myactivity){
        activity = myactivity;
    }

    void startLoadingPD(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.progressbar,null));
        builder.setCancelable(false);

        alertDialog = builder.create();
        alertDialog.show();
    }

    void dismmissPD(){
        alertDialog.dismiss();
    }
}
