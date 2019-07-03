package in.devcode.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import in.devcode.R;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {

    ArrayList<MainModel> list;

    public MainAdapter(ArrayList<MainModel> list) {
        this.list = list;
    }

    @NotNull
    @Override
    public MainHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_row_view, parent, false);
        return new MainHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainHolder holder, int position) {
        MainModel model = list.get(position);
        holder.id.setText(model.id + ".");
        holder.name.setText(model.name);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MainHolder extends RecyclerView.ViewHolder {
        TextView id, name;

        MainHolder(View viewBinding) {
            super(viewBinding);
            id = viewBinding.findViewById(R.id.sno);
            name = viewBinding.findViewById(R.id.name);
        }
    }
}
