package unsa.edu.pe.manualmoodle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivityDocente extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_docente);

        tabLayout = findViewById(R.id.tablayout_id_docente);
        viewPager = findViewById(R.id.viewpager_id_docente);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        //Agregamos los fragment
        adapter.AddFragment(new FragmentVideoDocent(),"");
        adapter.AddFragment(new FragmentPdfDocent(), "");

        //lea la vista
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        //agregar dibujo al tab
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_video_library);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_picture_as_pdf);

    }
}
