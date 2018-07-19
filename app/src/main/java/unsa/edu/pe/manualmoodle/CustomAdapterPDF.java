package unsa.edu.pe.manualmoodle;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapterPDF extends RecyclerView.Adapter<CustomAdapterPDF.MyViewHolder> {

    Context mContext;
    ArrayList<PdfDoc> mData;
    //Dialog mDialog;

    public CustomAdapterPDF(Context mContext, ArrayList<PdfDoc> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pdf,parent,false);


        /*vHolder.item_pdf.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Toast.makeText(mContext,"PDF"+ String.valueOf(vHolder.getAdapterPosition()),Toast.LENGTH_SHORT).show();

                //mDialog = new Dialog(mContext);
                //mDialog.setContentView(R.layout.activity_pdf);
                //mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                //mDialog.show();
            }
        });*/

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final PdfDoc pdfDoc = mData.get(position);
        //holder.img.setImageResource(mData.get(position).getImagen());
        holder.name_doc.setText(mData.get(position).getName_doc());
        //holder.ver.setText(mData.get(position).getName_doc());
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                openViewPDF(pdfDoc.getPath_pdf());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    private void openViewPDF(String path){
        Intent i = new Intent(mContext,ActivityPDF.class);
        i.putExtra("PATH",path);
        mContext.startActivity(i);
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private CardView item_pdf;
        private ImageView img;
        private TextView name_doc;
        private TextView ver;
        private ItemClickListener itemClickListener;

        public MyViewHolder(View itemView) {
            super(itemView);

            item_pdf = itemView.findViewById(R.id.pdf_ver_item_id);
            img = itemView.findViewById(R.id.pdfImage);
            name_doc = itemView.findViewById(R.id.nameTxt);
            ver = itemView.findViewById(R.id.ver_pdf);
        }

        public void setItemClickListener(ItemClickListener itemClickListener){
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onItemClick(getLayoutPosition());
        }
    }

    interface ItemClickListener{
        void onItemClick(int pos);
    }
}
