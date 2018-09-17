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
        listPdfDocent.add(new PdfDoc("tutorial0.pdf","Manual Completo uso de Aulas", "Se muestra el manejo y configuracion del aula virtual."));
        listPdfDocent.add(new PdfDoc("tutorial2.pdf","1. Manual: Ingresando al Aula Virtual", "El docente podra ingresar al Aula Virtual para facilitar el acceso a la plataforma Moodle."));
        listPdfDocent.add(new PdfDoc("tutorial1.pdf","2. Manual: Cambiando la contraseña del Aula Virtual", "El docente podra cambiar la contraseña de su Aula Virtual para así facilitar el manejo de la plataforma Moodle."));
        listPdfDocent.add(new PdfDoc("tutorial3.pdf","3. Manual: Configurando Temas", "El docente podra realizar la configuracion de los temas, configurando los temas del curso virtual."));
        listPdfDocent.add(new PdfDoc("tutorial4.pdf","4. Manual: Subiendo archivos", "El docente podra realizar la suba de archivos, para elmanejo de su aula virtual."));
        listPdfDocent.add(new PdfDoc("tutorial5.pdf","5. Manual: Compartiendo Videos (recursos de Internet)", "El docente podra utilizar los recursos por internet, en especial copartiendo videos."));
        listPdfDocent.add(new PdfDoc("tutorial6.pdf","6. Manual: Creando un Foro", "El docente podra crear un foro y configurar para el uso de su aula virtual."));
        listPdfDocent.add(new PdfDoc("tutorial7.pdf","7. Manual: Matriculando Alumnos al Aula", "El docente podra agregar alumnos a su aula virtual"));
        listPdfDocent.add(new PdfDoc("tutorial8.pdf","8. Manual: Agregando profesores: Cátedra Compartida", "El docente podra agregar en el curso virtual una catedra compartida entre los docentes."));
        listPdfDocent.add(new PdfDoc("tutorial11.pdf","9. Manual: Dejando una tarea en Cátedra Compartida", "El docente podra dejar tareas en el curso virtual en una catedra compartida."));
        listPdfDocent.add(new PdfDoc("tutorial10.pdf","10. Manual: Reestableciendo Contraseña", "El usuario podra recuperar su contraseña del aula virtual."));

    }
}
