package abish.rulebooksportsgame.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import java.util.List;

import Constants.Constant;
import abish.rulebooksportsgame.Models.CricketScheduleModel;
import abish.rulebooksportsgame.R;

/**
 * Created by helixtech-android on 29/6/16.
 */
public class CricketScheduleAdapter extends RecyclerView.Adapter{
    private List<CricketScheduleModel> items;
    Context context;
    private Interpolator mInterpolator = new LinearInterpolator();

    public CricketScheduleAdapter(Context con, List<CricketScheduleModel> itemslist) {
        context=con;
        this.items = itemslist;
    }

//    @Override
//    public int getItemViewType(int position) {
//            return items.get(position).getUnique();
//    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //if(viewType==0)
            return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cricket_schedule_card, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        if (holder instanceof MyViewHolder)
            try{
            ((MyViewHolder)holder).bindViewHolder(position);
            }catch (Exception e){
                Log.e(Constant.Tag,e.toString());
            }
//        else if(holder instanceof MyViewHolder1)
//            try{
//                ((MyViewHolder1)holder).bindViewHolder(position);
//            }catch (Exception e){
//                Log.e(Constant.Tag,e.toString());
//            }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView date,teams,format,series,descrip,time_gmt,time_ist,venue;
        //public RelativeLayout rl;
        //public ImageView img;
        public View mCardView;

        public MyViewHolder(View view) {
            super(view);
            date = (TextView) view.findViewById(R.id.date);
            teams = (TextView) view.findViewById(R.id.teams);
            format = (TextView) view.findViewById(R.id.format);
            series = (TextView) view.findViewById(R.id.series);
            descrip = (TextView) view.findViewById(R.id.descrip);
            time_gmt = (TextView) view.findViewById(R.id.time_gmt);
            time_ist = (TextView) view.findViewById(R.id.time_ist);
            venue = (TextView) view.findViewById(R.id.venue);
            mCardView = (CardView) view.findViewById(R.id.card);
            //mCardView.setOnClickListener(this);
        }

        public void bindViewHolder(int position) {
            if(position>0 && items.get(position).getMatchDate().equals(items.get(position-1).getMatchDate())) {
                date.setVisibility(View.GONE);
            }else
                date.setText(items.get(position).getMatchDate());
            teams.setText(items.get(position).getHomeTeam()+" Vs "+items.get(position).getOppositionTeam());
            format.setText(items.get(position).getGameFormat());
            series.setText(items.get(position).getSeriesName());
            descrip.setText(items.get(position).getMatchDescription());
            time_gmt.setText("GMT  : "+items.get(position).getGmtTime());
            time_ist.setText("IST  : "+items.get(position).getIstTime());
            venue.setText(items.get(position).getVenue());

            //holder.img.setImageResource(R.drawable.ic_menu_camera);
            setFadeAnimation(mCardView);
            animate(mCardView,position);
            mCardView.setTag(position);
        }

        //protected abstract Animator[] getAnimators(View view);

        private void animate(View view, final int pos) {
            view.animate().cancel();
            view.setTranslationY(300);
            view.setAlpha(0);
            view.animate().alpha(1.0f).translationY(0).setDuration(300).setStartDelay(100);//pos * 100
        }

        private void setFadeAnimation(View view) {
            AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
            anim.setDuration(100);
            anim.setInterpolator(mInterpolator);
            view.startAnimation(anim);
        }

        @Override
        public void onClick(View v) {

        }
    }
}