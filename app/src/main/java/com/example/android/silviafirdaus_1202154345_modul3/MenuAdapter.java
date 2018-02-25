package com.example.android.silviafirdaus_1202154345_modul3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by Asus on 2/24/2018.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder>  {

    // Untuk deklarasi objek
    private final LinkedList<String> title; //menampung data
    private final LinkedList<String> subtitle;
    private final LinkedList<Integer> image;
    private LayoutInflater mInflater; //layout untuk mengambil data dari Recycleview
    private Context context;

    public MenuAdapter(Context context, LinkedList<String> title,
                              LinkedList<String> subtitle, LinkedList<Integer> image) {
        mInflater = LayoutInflater.from(context);
        this.title = title;
        this.subtitle = subtitle;
        this.image = image;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflate layout item menu list ketika membuka activity list menu
        View mItemView = mInflater.inflate(R.layout.activity_list, parent, false);
        return new MenuViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        // mengambil data berdasarkan posisi item di array list
        String itemTitle = title.get(position);
        String itemSub = subtitle.get(position);
        int itemImage = image.get(position);

        // set text dan image dari proses diatas
        holder.menuTitle.setText(itemTitle);
        holder.menuSub.setText(itemSub);
        holder.menuImage.setImageResource(itemImage);
    }

    @Override
    public int getItemCount() {
        return title.size();
    }

    class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public final TextView menuTitle;
        public final TextView menuSub;
        public final ImageView menuImage;
        final MenuAdapter mAdapter;

        public MenuViewHolder(View itemView, MenuAdapter adapter) {
            super(itemView);
            menuTitle = itemView.findViewById(R.id.textTitle);
            menuSub = itemView.findViewById(R.id.textSub);
            menuImage = itemView.findViewById(R.id.imageLogo);
            this.mAdapter = adapter;
            context = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            // mengambil posisi item yang di klik
            int mPosition = getLayoutPosition();

            // mengambil data dari linkedlist
            String itemTitle = title.get(mPosition);
            String itemSub = subtitle.get(mPosition);
            int itemImage = image.get(mPosition);

            // mengirim data ke activity selanjutnya
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("title", itemTitle);
            intent.putExtra("subtitle", itemSub);
            intent.putExtra("image", itemImage);
            context.startActivity(intent);

            // notifiy adapter ketika ada perubahan data sehingga
            // dapat tertampilkan yang terupdate pada recycler view
            mAdapter.notifyDataSetChanged();
        }
    }
}

