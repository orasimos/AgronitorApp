package gr.aueb.cf.agronitor.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.cf.agronitor.MainActivity;
import gr.aueb.cf.agronitor.ManagementActivity;
import gr.aueb.cf.agronitor.R;
import gr.aueb.cf.agronitor.models.Greenhouse;

public class GreenhouseAdapter extends RecyclerView.Adapter<GreenhouseAdapter.MyViewHolder> {

    private final Context context;
    private ArrayList<Greenhouse> greenhouseArrayList;

    public GreenhouseAdapter(Context context, ArrayList<Greenhouse> greenhouseArrayList) {
        this.context = context;
        this.greenhouseArrayList = greenhouseArrayList;
    }

    public void setGreenhouseArrayList(ArrayList<Greenhouse> greenhouseArrayList) {
        this.greenhouseArrayList = greenhouseArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.greenhouse_card_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Greenhouse greenhouse = greenhouseArrayList.get(position);
        holder.greenhouseNameTV.setText(greenhouse.getGreenhouseName());
        holder.greenhouseCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),
                        holder.greenhouseNameTV.getText().toString(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, ManagementActivity.class);
                intent.putExtra("greenhouseId", greenhouse.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return greenhouseArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,
        PopupMenu.OnMenuItemClickListener{

        public final TextView greenhouseNameTV;
        public final MaterialCardView greenhouseCardView;
        public final AppCompatImageButton popupCardBtn;

        public MyViewHolder(@NotNull View itemView) {
            super(itemView);
            this.greenhouseNameTV = itemView.findViewById(R.id.greenhouseNameTV);
            this.greenhouseCardView = itemView.findViewById(R.id.greenhouseCardView);

            this.popupCardBtn = itemView.findViewById(R.id.popupCardBtn);
            this.popupCardBtn.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            showPopup(v);
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            if (item.getItemId() == R.id.action_popup_remove) {
                new AlertDialog.Builder(greenhouseCardView.getContext())
                        .setTitle("Remove Greenhouse")
                        .setMessage("Are you sure you want to remove this greenhouse?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
//                                TODO: api call to remove greenhouse
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
                return true;
            } else {
                return false;
            }
        }

        private void showPopup(View view) {
            PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
            popupMenu.inflate(R.menu.popup_cardview_menu);
            popupMenu.setOnMenuItemClickListener(this);
            popupMenu.show();
        }
    }
}
