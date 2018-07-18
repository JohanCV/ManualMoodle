package unsa.edu.pe.manualmoodle;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class FragmentPdfDocent extends Fragment {

    View v;
    private RecyclerView myrecyclerview;
    private List<PdfDoc> listPdfDocent;


    public FragmentPdfDocent() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.pdf_fragment_docente,container,false);

        myrecyclerview = v.findViewById(R.id.recyclerpdfview_docente);
        CustomAdapterPDF recyclerAdapter = new CustomAdapterPDF(getContext(), listPdfDocent);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listPdfDocent = new ArrayList<>();
        listPdfDocent.add(new PdfDoc(R.drawable.pdf_icon,"Tutorial Docente 1:","Como acceder y personalizar tu aula virtual"));
        listPdfDocent.add(new PdfDoc(R.drawable.pdf_icon,"Tutorial Docente 2:","Como acceder y personalizar tu aula virtual"));
        listPdfDocent.add(new PdfDoc(R.drawable.pdf_icon,"Tutorial Docente 3:","Como acceder y personalizar tu aula virtual"));
        listPdfDocent.add(new PdfDoc(R.drawable.pdf_icon,"Tutorial Docente 4:","Como acceder y personalizar tu aula virtual"));
        listPdfDocent.add(new PdfDoc(R.drawable.pdf_icon,"Tutorial Docente 5:","Como acceder y personalizar tu aula virtual"));
        listPdfDocent.add(new PdfDoc(R.drawable.pdf_icon,"Tutorial Docente 6:","Como acceder y personalizar tu aula virtual"));
        listPdfDocent.add(new PdfDoc(R.drawable.pdf_icon,"Tutorial Docente 7:","Como acceder y personalizar tu aula virtual"));
        listPdfDocent.add(new PdfDoc(R.drawable.pdf_icon,"Tutorial Docente 8:","Como acceder y personalizar tu aula virtual"));
        listPdfDocent.add(new PdfDoc(R.drawable.pdf_icon,"Tutorial Docente 9:","Como acceder y personalizar tu aula virtual"));
        listPdfDocent.add(new PdfDoc(R.drawable.pdf_icon,"Tutorial Docente 10:","Como acceder y personalizar tu aula virtual"));
        listPdfDocent.add(new PdfDoc(R.drawable.pdf_icon,"Tutorial Docente 11:","Como acceder y personalizar tu aula virtual"));
        listPdfDocent.add(new PdfDoc(R.drawable.pdf_icon,"Tutorial Docente 12:","Como acceder y personalizar tu aula virtual"));




    }
}
