package unsa.edu.pe.manualmoodle;

import android.os.Environment;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.File;
import java.util.ArrayList;

public class FragmentPdfDocent extends Fragment {

    View v;
    private RecyclerView myrecyclerview;
    //private List<PdfDoc> listPdfDocent;


    public FragmentPdfDocent() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.pdf_fragment_docente,container,false);

        myrecyclerview = v.findViewById(R.id.recyclerpdfview_docente);
       // CustomAdapterPDF recyclerAdapter = new CustomAdapterPDF(MainActivityDocente.class, getPDFs());
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
       // myrecyclerview.setAdapter(recyclerAdapter);


        return v;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    private ArrayList<PdfDoc> getPDFs(){
        ArrayList<PdfDoc> pdfDocs=new ArrayList<>();
        //TARGET FOLDER
        File downloadsFolder= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

        PdfDoc pdfDoc;

        if(downloadsFolder.exists())
        {
            //GET ALL FILES IN DOWNLOAD FOLDER
            File[] files=downloadsFolder.listFiles();

            //LOOP THRU THOSE FILES GETTING NAME AND URI
            for (int i=0;i<files.length;i++)
            {
                File file=files[i];

                if(file.getPath().endsWith("pdf"))
                {
                    pdfDoc=new PdfDoc();
                    pdfDoc.setName_doc(file.getName());
                    pdfDoc.setPath_pdf(file.getAbsolutePath());

                    pdfDocs.add(pdfDoc);
                }

            }
        }

        return pdfDocs;
    }
}
