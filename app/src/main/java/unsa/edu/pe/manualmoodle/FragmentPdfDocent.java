package unsa.edu.pe.manualmoodle;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public class FragmentPdfDocent extends Fragment {

    View v;
    private RecyclerView myrecyclerview;
    private ArrayList<PdfDoc> listPdfDocent;

    public FragmentPdfDocent() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.pdf_fragment_docente,container,false);

        myrecyclerview = v.findViewById(R.id.recyclerpdfview_docente);
        final CustomAdapterPDF recyclerAdapter = new CustomAdapterPDF(listPdfDocent);
        recyclerAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),ActivityPDF.class);
                i.putExtra("PATH",listPdfDocent.get(myrecyclerview.getChildAdapterPosition(v)).getPath_pdf());
                startActivity(i);
            }
        });
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerAdapter);

        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listPdfDocent = new ArrayList<>();
        listPdfDocent.add(new PdfDoc("constancia.pdf","Constancia", "LEER"));
        listPdfDocent.add(new PdfDoc("Thesis_REACT.pdf","REACT", "LEER"));
        listPdfDocent.add(new PdfDoc("HangoutsSilabo.pdf","Hangouts", "LEER"));
    }
}
