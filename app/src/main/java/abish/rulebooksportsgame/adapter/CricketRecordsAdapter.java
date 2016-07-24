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
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import Constants.Constant;
import abish.rulebooksportsgame.Models.CricketRankingModel;
import abish.rulebooksportsgame.Models.CricketRecordsModel;
import abish.rulebooksportsgame.R;

/**
 * Created by helixtech-android on 29/6/16.
 */
public class CricketRecordsAdapter extends RecyclerView.Adapter{
    private List<CricketRecordsModel> items;
    Context context;
    private Interpolator mInterpolator = new LinearInterpolator();
    //int viewType=0;

    public CricketRecordsAdapter(Context con, List<CricketRecordsModel> itemslist) {
        context=con;
        this.items = itemslist;
    }

    @Override
    public int getItemViewType(int position) {
            return items.get(position).getUnique();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==1 || viewType==2 || viewType==3)//MyViewHolderHighInngTotTit
            return new MyViewHolderHighInngTotTit(LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.cricket_records_high_inng_tot_titlecard, parent, false));
        else if(viewType==4)
            return new MyViewHolderHighInngTotVal(LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.cricket_records_high_inng_tot_valuecard, parent, false));
//            return new MyViewHolder1(LayoutInflater.from(parent.getContext()).inflate(R.layout.cricket_records_bestbowling_card, parent, false));
//        else if(viewType==4)
//            return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cricket_records_bestbowling_titlecard, parent, false));
        else
            return null;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolderHighInngTotTit)
            try{
                ((MyViewHolderHighInngTotTit)holder).bindViewHolder(position);
            }catch (Exception e){
                Log.e(Constant.TAG1,e.toString());
            }
        else if(holder instanceof MyViewHolderHighInngTotVal)
            try{
                ((MyViewHolderHighInngTotVal)holder).bindViewHolder(position);
            }catch (Exception e){
                Log.e(Constant.TAG1,e.toString());
            }
//        if (holder instanceof MyViewHolder)
//            try{
//            ((MyViewHolder)holder).bindViewHolder(position);
//            }catch (Exception e){
//                Log.e(Constant.Tag,e.toString());
//            }
//        else if(holder instanceof MyViewHolder1)
//            try{
//                ((MyViewHolder1)holder).bindViewHolder(position);
//            }catch (Exception e){
//                Log.e(Constant.Tag,e.toString());
//            }
    }

    //@Override
//    public void bindViewHolder() {
//        if(items.get(position).getUnique()==1) {
//            holder.text.setText("Team Ranking");
//            setTitleLayout(holder, position);
//        }else if(items.get(position).getUnique()==2) {
//            holder.text.setText("Player Batting ranking");
//            setTitleLayout(holder, position);
//        }else if(items.get(position).getUnique()==3) {
//            holder.text.setText("Player Bowling Ranking");
//            setTitleLayout(holder, position);
//        }
//        holder.text1.setText(items.get(position).getTeam());
//        holder.text2.setText(items.get(position).getRank());
//        holder.text3.setText(items.get(position).getMatches());
//        holder.text4.setText(items.get(position).getPoints());
//
//        //holder.img.setImageResource(R.drawable.ic_menu_camera);
//        holder.mCardView.setTag(position);
//
//    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolderHighInngTotTit extends RecyclerView.ViewHolder{
        public TextView subtitle,score,teams,ground,last_update_date;
        public RelativeLayout layout;
        public View mCardView;

        public MyViewHolderHighInngTotTit(View view) {
            super(view);
            subtitle = (TextView) view.findViewById(R.id.subtitle);
            last_update_date =(TextView)view.findViewById(R.id.last_update_date);
            score = (TextView) view.findViewById(R.id.score);
            teams = (TextView) view.findViewById(R.id.teams);
            ground = (TextView) view.findViewById(R.id.ground);
            last_update_date = (TextView) view.findViewById(R.id.last_update_date);
            mCardView = (CardView) view.findViewById(R.id.card);
            //mCardView.setOnClickListener(this);
        }

        public void bindViewHolder(int position) {
            subtitle.setText(items.get(position).getTitle());
            last_update_date.setText(items.get(position).getLastUpdatedDate());
            score.setText(items.get(position).getScore());
            teams.setText(items.get(position).getHomeTeam()+" Vs "+items.get(position).getOppositionTeam());
            ground.setText("@"+items.get(position).getVenue());

//            setFadeAnimation(mCardView);
//            animate(mCardView,position);
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
    }

    public class MyViewHolderHighInngTotVal extends RecyclerView.ViewHolder{
        public TextView score,teams,ground;
        public RelativeLayout layout;
        public View mCardView;

        public MyViewHolderHighInngTotVal(View view) {
            super(view);
            score = (TextView) view.findViewById(R.id.score);
            teams = (TextView) view.findViewById(R.id.teams);
            ground = (TextView) view.findViewById(R.id.ground);
            //last_update_date = (TextView) view.findViewById(R.id.last_update_date);
            layout = (RelativeLayout) view.findViewById(R.id.layout);
            mCardView = (CardView) view.findViewById(R.id.card);
            //mCardView.setOnClickListener(this);
        }

        public void bindViewHolder(int position) {
            score.setText(items.get(position).getScore());
            teams.setText(items.get(position).getHomeTeam()+" Vs "+items.get(position).getOppositionTeam());
            ground.setText("@"+items.get(position).getVenue());

            setFadeAnimation(mCardView);
            animate(mCardView,position);
            mCardView.setTag(position);

        }
        private void setFadeAnimation(View view) {
            AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
            anim.setDuration(2000);
            view.startAnimation(anim);
        }
        private void animate(View view, final int pos) {
            view.animate().cancel();
            view.setTranslationY(300);
            view.setAlpha(0);
            view.animate().alpha(1.0f).translationY(0).setDuration(300).setStartDelay(100);//pos * 100
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView subtitle,name,team1,team2,overs,maidens,runs,wickets,economy,ground_matchdate,last_update_date;
        public RelativeLayout layout;
        public View mCardView;

        public MyViewHolder(View view) {
            super(view);
            subtitle = (TextView) view.findViewById(R.id.subtitle);
            last_update_date =(TextView)view.findViewById(R.id.last_update_date);
            name = (TextView) view.findViewById(R.id.name);
            team1 = (TextView) view.findViewById(R.id.team1);
            team2 = (TextView) view.findViewById(R.id.team2);
            overs = (TextView) view.findViewById(R.id.overs);
            maidens = (TextView) view.findViewById(R.id.maidens);
            runs = (TextView) view.findViewById(R.id.runs);
            wickets = (TextView) view.findViewById(R.id.wickets);
            economy = (TextView) view.findViewById(R.id.economy);
            ground_matchdate = (TextView) view.findViewById(R.id.ground_matchdate);
            last_update_date = (TextView) view.findViewById(R.id.last_update_date);
            layout = (RelativeLayout) view.findViewById(R.id.layout);
            mCardView = (CardView) view.findViewById(R.id.card);
            //mCardView.setOnClickListener(this);
        }

        public void bindViewHolder(int position) {
            subtitle.setText(items.get(position).getTitle());
            last_update_date.setText(items.get(position).getLastUpdatedDate());
            name.setText(items.get(position).getPlayer());
            team1.setText(items.get(position).getHomeTeam());
            team2.setText(items.get(position).getOppositionTeam());
            overs.setText(items.get(position).getOvers());
            maidens.setText(items.get(position).getMaidens());
            runs.setText(items.get(position).getRuns());
            wickets.setText(items.get(position).getWickets());
            economy.setText(items.get(position).getEconomy());
            ground_matchdate.setText(items.get(position).getVenue()+items.get(position).getMatchDate());

//            setFadeAnimation(mCardView);
//            animate(mCardView,position);
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
    }

    public class MyViewHolder1 extends RecyclerView.ViewHolder{
        public TextView subtitle,name,team1,team2,overs,maidens,runs,wickets,economy,ground_matchdate,last_update_date;
        public RelativeLayout layout;
        public View mCardView;

        public MyViewHolder1(View view) {
            super(view);
            //subtitle = (TextView) view.findViewById(R.id.subtitle);
            name = (TextView) view.findViewById(R.id.name);
            team1 = (TextView) view.findViewById(R.id.team1);
            team2 = (TextView) view.findViewById(R.id.team2);
            overs = (TextView) view.findViewById(R.id.overs);
            maidens = (TextView) view.findViewById(R.id.maidens);
            runs = (TextView) view.findViewById(R.id.runs);
            wickets = (TextView) view.findViewById(R.id.wickets);
            economy = (TextView) view.findViewById(R.id.economy);
            ground_matchdate = (TextView) view.findViewById(R.id.ground_matchdate);
            //last_update_date = (TextView) view.findViewById(R.id.last_update_date);
            layout = (RelativeLayout) view.findViewById(R.id.layout);
            mCardView = (CardView) view.findViewById(R.id.card);
            //mCardView.setOnClickListener(this);
        }

        public void bindViewHolder(int position) {
            name.setText(items.get(position).getPlayer());
            team1.setText(items.get(position).getHomeTeam());
            team2.setText(items.get(position).getOppositionTeam());
            overs.setText(items.get(position).getOvers());
            maidens.setText(items.get(position).getMaidens());
            runs.setText(items.get(position).getRuns());
            wickets.setText(items.get(position).getWickets());
            economy.setText(items.get(position).getEconomy());
            ground_matchdate.setText(items.get(position).getVenue()+items.get(position).getMatchDate());

            setFadeAnimation(mCardView);
            animate(mCardView,position);
            mCardView.setTag(position);

        }
        private void setFadeAnimation(View view) {
            AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
            anim.setDuration(2000);
            view.startAnimation(anim);
        }
        private void animate(View view, final int pos) {
            view.animate().cancel();
            view.setTranslationY(300);
            view.setAlpha(0);
            view.animate().alpha(1.0f).translationY(0).setDuration(300).setStartDelay(100);//pos * 100
        }
    }
}