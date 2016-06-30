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
import abish.rulebooksportsgame.CricketModel;
import abish.rulebooksportsgame.R;

/**
 * Created by helixtech-android on 29/6/16.
 */
public class CricketTestAdapter extends RecyclerView.Adapter<CricketTestAdapter.MyViewHolder> {
    private List<CricketModel> items;
    Context context;
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView text1,text2,text3,text4,text5;
        //public ImageView img;
        public View mCardView;

        public MyViewHolder(View view) {
            super(view);
            text1 = (TextView) view.findViewById(R.id.text1);
            text2 = (TextView) view.findViewById(R.id.text2);
            text3 = (TextView) view.findViewById(R.id.text3);
            text4 = (TextView) view.findViewById(R.id.text4);
            text5 = (TextView) view.findViewById(R.id.text5);
            //img=(ImageView) view.findViewById(R.id._img);
            mCardView = (CardView) view.findViewById(R.id.card);
            mCardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = (int) v.getTag();
            switch (position){
                case 0:
                    Toast.makeText(context, v.getTag() + "", Toast.LENGTH_SHORT).show();
                    //context.startActivity( new Intent(context, CricketActivity.class));
                    break;
                case 1:
                    Toast.makeText(context, v.getTag() + "", Toast.LENGTH_SHORT).show();
                    break;
            }

        }
    }


    public CricketTestAdapter(Context con, List<CricketModel> itemslist) {
        context=con;
        this.items = itemslist;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cricketrecordtestcard, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.text1.setText(items.get(position).getTeam());
        holder.text2.setText(items.get(position).getRank());
        holder.text3.setText(items.get(position).getMatches());
        holder.text4.setText(items.get(position).getPoints());
        holder.text5.setText(items.get(position).getLastUpdatedDate());
        //holder.img.setImageResource(R.drawable.ic_menu_camera);
        holder.mCardView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}