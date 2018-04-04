package carlos.cachimbogouno;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_asignaturas)
    RecyclerView rvAsignaturas;

    private List<String> asignaturas;

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        asignaturas = this.getAllAsignaturas();

        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new MyAdapter(asignaturas, R.layout.asignatura, new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String asignatura, int position) {
                Toast.makeText(MainActivity.this, asignatura + " - " + position, Toast.LENGTH_SHORT).show();
            }
        });

        rvAsignaturas.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        rvAsignaturas.setAdapter(mAdapter);
        rvAsignaturas.setLayoutManager(mLayoutManager);
    }

    private List<String> getAllAsignaturas(){
        return new ArrayList<String>(){{
            add("HABILIDAD VERBAL");
            add("LITERATURA");
            add("FOLOSOFIA");
            add("ECONOMIA");
        }};
    }
}
