package unsa.edu.pe.manualmoodle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FragmentPdfStudent extends Fragment {

    View v;
    private RecyclerView myrecyclerview;
    private ArrayList<PdfDoc> listPdfStudent;

    public FragmentPdfStudent() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.pdf_fragment_estudiante,container,false);

        myrecyclerview = v.findViewById(R.id.recyclerpdfview_estudiante);
        final CustomAdapterPDF recyclerAdapter = new CustomAdapterPDF(listPdfStudent);
        recyclerAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),ActivityPDF.class);
                i.putExtra("PATH",listPdfStudent.get(myrecyclerview.getChildAdapterPosition(v)).getPath_pdf());
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

        listPdfStudent = new ArrayList<>();
        listPdfStudent.add(new PdfDoc("tutorial14.pdf","1. Manual: Ingresando al Aula Virtual", "El estudiante podra ingresar al Aula Virtual."));
        listPdfStudent.add(new PdfDoc("tutorial17.pdf","2. Manual: Cambiando Contraseña", "El estudiante podra cambiar la contraseña de su Aula Virtual."));
        listPdfStudent.add(new PdfDoc("tutorial16.pdf","3. Manual: Cómo enviar una Tarea", "El estudiante podra enviar tareasa de sus cursos asignados en el aula virtual."));
        listPdfStudent.add(new PdfDoc("tutorial15.pdf","4. Manual: Recuperar Contraseña", "El estudiante podra recuperar su contraseña del aula virtual."));

    }
}
