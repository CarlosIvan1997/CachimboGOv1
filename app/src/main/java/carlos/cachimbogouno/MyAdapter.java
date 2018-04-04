package carlos.cachimbogouno;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private List<String> asignaturas;
    private int layout;
    private OnItemClickListener itemClickListener;

    public MyAdapter(List<String> asignaturas, int layout, OnItemClickListener listener){
        this.asignaturas = asignaturas;
        this.layout = layout;
        this.itemClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        holder.bind(asignaturas.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return asignaturas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tv_asignatura;


        public ViewHolder(View itemView) {
            super(itemView);
            this.tv_asignatura = (TextView) itemView.findViewById(R.id.tv_asignatura);
        }

        public void bind(final String asignatura, final OnItemClickListener listener){

            this.tv_asignatura.setText(asignatura);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(asignatura, getAdapterPosition());
                }
            });
        }
    }

    public interface OnItemClickListener{
        void onItemClick(String asignatura, int position);
    }

}
