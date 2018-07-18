package unsa.edu.pe.manualmoodle;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;

import java.util.List;

public class CustomAdapterPDF extends RecyclerView.Adapter<CustomAdapterPDF.MyViewHolder> {

    Context mContext;
    List<PdfDoc> mData;
    Dialog mDialog;
    PDFView pdf;
    public CustomAdapterPDF(Context mContext, List<PdfDoc> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_pdf,parent,false);
        final MyViewHolder vHolder = new MyViewHolder(v);

        vHolder.item_pdf.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"PDF"+ String.valueOf(vHolder.getAdapterPosition()),Toast.LENGTH_SHORT).show();

                mDialog = new Dialog(mContext);
                mDialog.setContentView(R.layout.activity_pdf);
                mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                pdf = mDialog.findViewById(R.id.pdfView);
                pdf.fromAsset("HangoutsSilabo.pdf");

                mDialog.show();
            }
        });

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.img.setImageResource(mData.get(position).getImagen());
        holder.name_doc.setText(mData.get(position).getName_doc());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private CardView item_pdf;
        private ImageView img;
        private TextView name_doc;

        public MyViewHolder(View itemView) {
            super(itemView);

            item_pdf = itemView.findViewById(R.id.pdf_item_id);
            img = itemView.findViewById(R.id.pdfImage);
            name_doc = itemView.findViewById(R.id.nameTxt);
        }
    }
}
