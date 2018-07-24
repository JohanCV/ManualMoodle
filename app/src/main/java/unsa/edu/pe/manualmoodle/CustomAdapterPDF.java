package unsa.edu.pe.manualmoodle;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

public class CustomAdapterPDF extends RecyclerView.Adapter<CustomAdapterPDF.MyViewHolder>
        implements View.OnClickListener{

    ArrayList<PdfDoc> mData;
    private View.OnClickListener listener;

    public CustomAdapterPDF(ArrayList<PdfDoc> mData) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pdf,parent,false);
        v.setOnClickListener(this);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name_doc.setText(mData.get(position).getName_doc());
        holder.ver.setText(mData.get(position).getBtn_ver());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener != null){
            listener.onClick(v);
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView name_doc;
        private TextView ver;

        public MyViewHolder(View itemView) {
            super(itemView);

            name_doc = itemView.findViewById(R.id.nameTxt);
            ver = itemView.findViewById(R.id.ver_pdf);
        }
    }
}
