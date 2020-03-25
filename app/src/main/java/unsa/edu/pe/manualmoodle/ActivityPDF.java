package unsa.edu.pe.manualmoodle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.github.barteksc.pdfviewer.PDFView;

public class ActivityPDF extends AppCompatActivity {

    PDFView pdfView;
    public float zoomValue = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        pdfView=  findViewById(R.id.pdfView);

        Intent i=this.getIntent();
        String path=i.getExtras().getString("PATH");

        pdfView.fromAsset(path) // all pages are displayed by default
                .enableSwipe(true) // allows to block changing pages using swipe
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)
                .enableAnnotationRendering(false) // render annotations (such as comments, colors or forms)
                .password(null)
                .scrollHandle(null)
                .load();

    }

    public void zoomIn(View view) {
        ++zoomValue;
        pdfView.zoomTo(zoomValue);
        pdfView.loadPages();

    }

    public void zoomOut(View view) {

        if (zoomValue != 1) {
            --zoomValue;
            pdfView.zoomTo(zoomValue);
            pdfView.loadPages();
        }

    }

}


