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

        listPdfDocent.add(new PdfDoc("tutorial9.pdf","1. Manual: Ingresando al Aula Virtual", "El docente podra ingresar al Aula Virtual."));
        listPdfDocent.add(new PdfDoc("tutorial0.pdf","2. Manual: Agregando Temas", "El docente podra realizar la configuracion de los temas, configurando los temas del curso virtual."));
        listPdfDocent.add(new PdfDoc("tutorial1.pdf","3. Manual: Agregando Videos", "El docente podra utilizar los recursos por internet, en especial compartiendo videos."));
        listPdfDocent.add(new PdfDoc("tutorial2.pdf","4. Manual: Agregando URL", "El docente podra utilizar los recursos por internet, en especial direcciones web de otras paginas."));
        listPdfDocent.add(new PdfDoc("tutorial3.pdf","5. Manual: Subiendo Archivos", "El docente podra realizar la suba de archivos, para el manejo de su aula virtual."));
        listPdfDocent.add(new PdfDoc("tutorial4.pdf","6. Manual: Creando Foros", "El docente podra crear y configurar un foro, para el uso en su aula virtual."));
        listPdfDocent.add(new PdfDoc("tutorial5.pdf","7. Manual: Creando Grupos", "El docente podra crear y configurar Grupos con los estudiantes matriculados en su curso."));
        listPdfDocent.add(new PdfDoc("tutorial6.pdf","8. Manual: Reporte de Calificador", "El docente podra obtener las calificaciones de todos los trabajos."));
        listPdfDocent.add(new PdfDoc("tutorial7.pdf","9. Manual: Copia de Seguridad del Curso", "El docente podra sacar una copia de seguridad de su curso."));
        listPdfDocent.add(new PdfDoc("tutorial8.pdf","10. Manual: Restauración del Curso", "El docente podra reestablecer su curso, en cualquier otro curso que se le asigne,  previamente haya realizado una copia de seguriadad."));
        listPdfDocent.add(new PdfDoc("tutorial10.pdf","11. Manual: Cambio de Contraseña","El docente podra cambiar la contraseña de su Aula Virtual."));
        listPdfDocent.add(new PdfDoc("tutorial11.pdf","12. Manual: Matriculando Estudiantes", "El docente podra agregar o matricular a estudiantes a su aula virtual"));
        listPdfDocent.add(new PdfDoc("tutorial12.pdf","13. Manual: Catedra Compartida: Registrando Profesores al Curso", "El docente podra agregar Profesores a su aula virtual, para una Catedra Compartida"));
        listPdfDocent.add(new PdfDoc("tutorial13.pdf","14. Manual: Creando Cuestionario y Banco de Preguntas", "El docente podra evaluar atravez de cuestionarios."));
        listPdfDocent.add(new PdfDoc("tutorial15.pdf","15. Manual: Reestableciendo Contraseña", "El docente podra recuperar su contraseña del aula virtual."));
    }
}
