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

        listVideoDocent = new ArrayList<>();
        listVideoDocent.add(new Video("<iframe width=\"330\" height=\"180\"  src=\"https://www.youtube.com/embed/JaLzSK8Jbok\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen='true'></iframe>","Tutorial Docente 1:","Como acceder y personalizar tu aula virtual"));
        listVideoDocent.add(new Video("<iframe width=\"330\" height=\"180\" src=\"https://www.youtube.com/embed/JaLzSK8Jbok\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen='true'></iframe>","Tutorial Docente 2:","Como acceder y personalizar tu aula virtual"));
        listVideoDocent.add(new Video("<iframe width=\"330\" height=\"180\" src=\"https://www.youtube.com/embed/JaLzSK8Jbok\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>","Tutorial Docente 3:","Como acceder y personalizar tu aula virtual"));
        listVideoDocent.add(new Video("<iframe width=\"330\" height=\"180\" src=\"https://www.youtube.com/embed/JaLzSK8Jbok\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>","Tutorial Docente 4:","Como acceder y personalizar tu aula virtual"));
        listVideoDocent.add(new Video("<iframe width=\"330\" height=\"180\" src=\"https://www.youtube.com/embed/JaLzSK8Jbok\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>","Tutorial Docente 5:","Como acceder y personalizar tu aula virtual"));
        listVideoDocent.add(new Video("<iframe width=\"330\" height=\"180\" src=\"https://www.youtube.com/embed/JaLzSK8Jbok\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>","Tutorial Docente 6:","Como acceder y personalizar tu aula virtual"));
        listVideoDocent.add(new Video("<iframe width=\"330\" height=\"180\" src=\"https://www.youtube.com/embed/JaLzSK8Jbok\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>","Tutorial Docente 7:","Como acceder y personalizar tu aula virtual"));
        listVideoDocent.add(new Video("<iframe width=\"330\" height=\"180\" src=\"https://www.youtube.com/embed/JaLzSK8Jbok\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>","Tutorial Docente 8:","Como acceder y personalizar tu aula virtual"));
        listVideoDocent.add(new Video("<iframe width=\"330\" height=\"180\" src=\"https://www.youtube.com/embed/JaLzSK8Jbok\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>","Tutorial Docente 9:","Como acceder y personalizar tu aula virtual"));
        listVideoDocent.add(new Video("<iframe width=\"330\" height=\"180\" src=\"https://www.youtube.com/embed/JaLzSK8Jbok\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>","Tutorial Docente 10:","Como acceder y personalizar tu aula virtual"));
        listVideoDocent.add(new Video("<iframe width=\"330\" height=\"180\" src=\"https://www.youtube.com/embed/JaLzSK8Jbok\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>","Tutorial Docente 11:","Como acceder y personalizar tu aula virtual"));
        listVideoDocent.add(new Video("<iframe width=\"330\" height=\"180\" src=\"https://www.youtube.com/embed/JaLzSK8Jbok\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>","Tutorial Docente 12:","Como acceder y personalizar tu aula virtual"));




    }
}
