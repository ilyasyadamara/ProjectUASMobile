package mobile.basket.pemain.com.pemainbasket;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.ViewHolder> {

    private Context context;
    private List<PlayerItem> list;
    //private pemaincallback mcallback;

    public ListViewAdapter(Context context, List<PlayerItem> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final PlayerItem player = list.get(position);

        holder.textName.setText(player.getName());
        holder.textTeam.setText(String.valueOf(player.getTeam()));
        holder.textPosition.setText(String.valueOf(player.getPosition()));
        // holder.textDeskripsi.setText(String.valueOf(player.getDeskripsi()));
        Glide.with(context).load(player.getPoster()).into(holder.imgview);

        //holder.itemView.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {

         //       mcallback.onrowpemaincallback(list.get(holder.getAdapterPosition()));
        //    }
        //});

         holder.listItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailPemain.class);
                intent.putExtra("Poster", player.getPoster());
               intent.putExtra("name", player.getName());
                intent.putExtra("Position", player.getPosition());
                intent.putExtra("Deskripsi", player.getDeskripsi());
               intent.putExtra("team", player.getTeam());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textName, textTeam, textPosition, textDeskripsi;
        public ImageView imgview;
        public LinearLayout listItem;
        public ViewHolder(View itemView) {
            super(itemView);

            textName = itemView.findViewById(R.id.textViewName);
            textTeam = itemView.findViewById(R.id.textViewTeam);
            textPosition = itemView.findViewById(R.id.textViewPosition);
            imgview = itemView.findViewById(R.id.Poster);
            textDeskripsi = itemView.findViewById(R.id.tv_item_detail);
            listItem = itemView.findViewById(R.id.listItem);
        }
    }
    //public interface pemaincallback{

    //    void onrowpemaincallback(PlayerItem playerItem);
    //}

}
