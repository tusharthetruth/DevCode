package in.devcode.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import in.devcode.R;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {

    ArrayList<MainModel> list;
    ICommonAdapterListener listener;

    public MainAdapter(ArrayList<MainModel> list, ICommonAdapterListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @NotNull
    @Override
    public MainHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_row_view, parent, false);
        return new MainHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MainHolder holder, int position) {
        MainModel model = list.get(position);
        holder.id.setText(model.id + ".");
        holder.name.setText(model.name);
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(holder.name.getText());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MainHolder extends RecyclerView.ViewHolder {
        TextView id, name;
        LinearLayout container;

        MainHolder(View viewBinding) {
            super(viewBinding);
            id = viewBinding.findViewById(R.id.sno);
            name = viewBinding.findViewById(R.id.name);
            container = viewBinding.findViewById(R.id.container);
        }
    }
}
