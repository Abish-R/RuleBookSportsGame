package abish.rulebooksportsgame.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import abish.rulebooksportsgame.CricketActivity;
import abish.rulebooksportsgame.R;
import abish.rulebooksportsgame.ThemeSetting;
import abish.rulebooksportsgame.UrlHandlerActivity;

/**
 * Created by INDP on 16-Jun-16.
 */
public class SettingsPageAdapter extends RecyclerView.Adapter<SettingsPageAdapter.MyViewHolder> {
    private List<String> items;
    Context context;
    int pageInvokerDeciderValue=-1;

    public SettingsPageAdapter(Context con, List<String> itemslist,int pageInvokerDecider) {
        context=con;
        this.items = itemslist;
        pageInvokerDeciderValue=pageInvokerDecider;
        // 0 for Settings Page
        // 10 for ThemeSetting Page
        // 20 for Notification Edit Page
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sports_mainpage_rowitem, parent, false);

        return new MyViewHolder(itemView);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView text;
        public ImageView img;
        public View mCardView;

        public MyViewHolder(View view) {
            super(view);
            text = (TextView) view.findViewById(R.id._text);
            img = (ImageView) view.findViewById(R.id._img);
            mCardView = (CardView) view.findViewById(R.id.card);
            mCardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = (int) v.getTag();
            switch (position) {
                case 0:
                    Toast.makeText(context, v.getTag() + "", Toast.LENGTH_SHORT).show();
                    context.startActivity(new Intent(context, ThemeSetting.class));
                    break;
                case 1:
                    context.startActivity(new Intent(context, UrlHandlerActivity.class));
                    Toast.makeText(context, v.getTag() + "", Toast.LENGTH_SHORT).show();
                    break;
            }

        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.text.setText(items.get(position));
        holder.img.setImageResource(R.drawable.ic_menu_camera);
        holder.mCardView.setTag(position);
        animate(holder.mCardView,position);
    }

    private void animate(View view, final int pos) {
        view.animate().cancel();
        view.setTranslationX(-200);
        view.setTranslationY(300);
        view.setAlpha(0);
        view.animate().alpha(1.0f).translationX(0).translationY(0).setDuration(500).setStartDelay(100);//pos * 100
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
