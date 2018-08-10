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
        listPdfStudent.add(new PdfDoc("tutorial2.pdf","1. Manual: Ingresando al Aula Virtual", "El alumno podra ingresar al Aula Virtual para facilitar el acceso a la plataforma Moodle."));
        listPdfStudent.add(new PdfDoc("tutorial1.pdf","2. Manual: Cambiando la contraseña del Aula Virtual", "El alumno podra cambiar la contraseña de su Aula Virtual para así facilitar el manejo de la plataforma Moodle."));
        listPdfStudent.add(new PdfDoc("tutorial9.pdf","3. Manual: Cómo enviar una Tarea a través del Aula", "Se muestra el manejo y configuracón del aula virtual."));

    }
}
