package unsa.edu.pe.manualmoodle;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class HeaderAdapter extends RecyclerView.Adapter<HeaderAdapter.ViewHolder> {
    private ArrayList<Header> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
   static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView headerCod;
        TextView responsable;
        TextView fecha;


        ViewHolder(View v) {
            super(v);
            headerCod = (TextView) v.findViewById(R.id.headercode);
            responsable = (TextView) v.findViewById(R.id.UserName);
            fecha = (TextView) v.findViewById(R.id.FromDate);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public HeaderAdapter(ArrayList<Header> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public HeaderAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_manual_docente, parent, false);

        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.headerCod.setText(mDataset.get(position).getHeadercode());
        holder.responsable.setText(mDataset.get(position).getUserName());
        holder.fecha.setText(mDataset.get(position).getCreatedAt());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}