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

public class FragmentVideoDocent extends Fragment {

    View v;
    private RecyclerView myrecyclerview;
    private List<Video> listVideoDocent;


    public FragmentVideoDocent() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.video_fragment_docente,container,false);

        myrecyclerview = v.findViewById(R.id.recyclerview_docente);
        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getContext(), listVideoDocent);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*listVideoDocent = new ArrayList<>();
        listVideoDocent.add(new Video( "<iframe width=\"330\" height=\"180\" src=\"https://www.youtube.com/embed/JaLzSK8Jbok?list=PLqtSFRmgPpYHJ8aEU1AXOlGNv5JcmIBvd\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>","1. Tutorial Docente:","Como acceder y personalizar tu aula virtual"));
        listVideoDocent.add(new Video( "<iframe width=\"330\" height=\"180\" src=\"https://www.youtube.com/embed/ZRDCSPyR9dk?list=PLqtSFRmgPpYHJ8aEU1AXOlGNv5JcmIBvd\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>","2. Tutorial Docente:","Como subir contenido al aula virtual"));
        listVideoDocent.add(new Video( "<iframe width=\"330\" height=\"180\" src=\"https://www.youtube.com/embed/h01aJVRYAUY?list=PLqtSFRmgPpYHJ8aEU1AXOlGNv5JcmIBvd\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>","3. Tutorial Docente:","Como subir archivos a tu aula virtual"));
        listVideoDocent.add(new Video( "<iframe width=\"330\" height=\"180\" src=\"https://www.youtube.com/embed/A5tK6BT_io8?list=PLqtSFRmgPpYHJ8aEU1AXOlGNv5JcmIBvd\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>","4. Tutorial Docente:","Como subir un video a tu aula virtual"));
        listVideoDocent.add(new Video( "<iframe width=\"330\" height=\"180\" src=\"https://www.youtube.com/embed/9gNNdOZ49eA?list=PLqtSFRmgPpYHJ8aEU1AXOlGNv5JcmIBvd\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>","5. Tutorial Docente:","SUBIENDO SILABO"));
        listVideoDocent.add(new Video( "<iframe width=\"330\" height=\"180\" src=\"https://www.youtube.com/embed/GcbO2k56uKw?list=PLqtSFRmgPpYHJ8aEU1AXOlGNv5JcmIBvd\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>","6. Tutorial Docente:","ENVIANDO MENSAJES"));
        listVideoDocent.add(new Video( "<iframe width=\"330\" height=\"180\" src=\"https://www.youtube.com/embed/e3FZooED08U?list=PLqtSFRmgPpYHJ8aEU1AXOlGNv5JcmIBvd\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>","7. Tutorial Docente:","DEJANDO TAREA"));
        listVideoDocent.add(new Video( "<iframe width=\"330\" height=\"180\" src=\"https://www.youtube.com/embed/UUCqBPr1KaE?list=PLqtSFRmgPpYHJ8aEU1AXOlGNv5JcmIBvd\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>","8. Tutorial Docente:","CORRIGIENDO TAREAS"));
        listVideoDocent.add(new Video( "<iframe width=\"330\" height=\"180\" src=\"https://www.youtube.com/embed/XfFcrY316Zc?list=PLqtSFRmgPpYHJ8aEU1AXOlGNv5JcmIBvd\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>","9. Tutorial Docente:","como subir material, diapostivias, words, pdf, etc a tu aula virtual"));
    */
    }
}
