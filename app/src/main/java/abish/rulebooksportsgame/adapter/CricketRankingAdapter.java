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
import abish.rulebooksportsgame.R;

/**
 * Created by helixtech-android on 29/6/16.
 */
public class CricketRankingAdapter extends RecyclerView.Adapter{
    private List<CricketRankingModel> items;
    Context context;
    private Interpolator mInterpolator = new LinearInterpolator();

    public CricketRankingAdapter(Context con, List<CricketRankingModel> itemslist) {
        context=con;
        this.items = itemslist;
    }

    @Override
    public int getItemViewType(int position) {
            return items.get(position).getUnique();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==0)
            return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cricketrank_valuecard, parent, false));
        else
            return new MyViewHolder1(LayoutInflater.from(parent.getContext()).inflate(R.layout.cricketrank_titlecard, parent, false));

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder)
            try{
            ((MyViewHolder)holder).bindViewHolder(position);
            }catch (Exception e){
                Log.e(Constant.Tag,e.toString());
            }
        else if(holder instanceof MyViewHolder1)
            try{
                ((MyViewHolder1)holder).bindViewHolder(position);
            }catch (Exception e){
                Log.e(Constant.Tag,e.toString());
            }
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


    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView text,text1,text2,text3,text4,text5;
        //public RelativeLayout rl;
        //public ImageView img;
        public View mCardView;

        public MyViewHolder(View view) {
            super(view);
            //text = (TextView) view.findViewById(R.id.text);
            text1 = (TextView) view.findViewById(R.id.text1);
            text2 = (TextView) view.findViewById(R.id.text2);
            text3 = (TextView) view.findViewById(R.id.text3);
            text4 = (TextView) view.findViewById(R.id.text4);
            //rl = (RelativeLayout) view.findViewById(R.id.rl);
            //img=(ImageView) view.findViewById(R.id._img);
            //text5 = (TextView) view.findViewById(R.id.text5);
            mCardView = (CardView) view.findViewById(R.id.card);
            //mCardView.setOnClickListener(this);
        }

        public void bindViewHolder(int position) {
//            if(items.get(position).getUnique()==1) {
//                text.setText("Team Ranking");
//                rl.setVisibility(View.VISIBLE);
//                text5.setText(items.get(position).getLastUpdatedDate());
//            }else if(items.get(position).getUnique()==2) {
//                text.setText("Player Batting ranking");
//                rl.setVisibility(View.VISIBLE);
//                text5.setText(items.get(position).getLastUpdatedDate());
//            }else if(items.get(position).getUnique()==3) {
//                text.setText("Player Bowling Ranking");
//                rl.setVisibility(View.VISIBLE);
//                text5.setText(items.get(position).getLastUpdatedDate());
//            }
            text1.setText(items.get(position).getTeam());
            text2.setText(items.get(position).getRank());
            text3.setText(items.get(position).getMatches());
            text4.setText(items.get(position).getPoints());

            //holder.img.setImageResource(R.drawable.ic_menu_camera);
            setFadeAnimation(mCardView);
            animate(mCardView,position);
            mCardView.setTag(position);
//            for (Animator anim : getAnimators(mCardView)) {
//                anim.setDuration(1000).start();
//                anim.setInterpolator(mInterpolator);
//            }


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
        public TextView text,text1,text2,text3,text4,text5;
        public RelativeLayout rl;
        //public ImageView img;
        public View mCardView;

        public MyViewHolder1(View view) {
            super(view);
            text = (TextView) view.findViewById(R.id.text);
            text1 = (TextView) view.findViewById(R.id.text1);
            text2 = (TextView) view.findViewById(R.id.text2);
            text3 = (TextView) view.findViewById(R.id.text3);
            text4 = (TextView) view.findViewById(R.id.text4);
            rl = (RelativeLayout) view.findViewById(R.id.rl);
            //img=(ImageView) view.findViewById(R.id._img);
            text5 = (TextView) view.findViewById(R.id.text5);
            mCardView = (CardView) view.findViewById(R.id.card);
            //mCardView.setOnClickListener(this);
        }

        public void bindViewHolder(int position) {
            if(items.get(position).getUnique()==1 && position == 0) {
                text.setText("Team Ranking");
                rl.setVisibility(View.VISIBLE);
                text5.setText(items.get(position+1).getLastUpdatedDate());
            }else if(items.get(position).getUnique()==2 && position == 11) {
                text.setText("Batting Ranking");
                rl.setVisibility(View.VISIBLE);
                text5.setText(items.get(position+1).getLastUpdatedDate());
            }else if(items.get(position).getUnique()==3 && position == 22) {
                text.setText("Bowling Ranking");
                rl.setVisibility(View.VISIBLE);
                text5.setText(items.get(position+1).getLastUpdatedDate());
            }
            text1.setText(items.get(position).getTeam());
            text2.setText(items.get(position).getRank());
            text3.setText(items.get(position).getMatches());
            text4.setText(items.get(position).getPoints());

            //holder.img.setImageResource(R.drawable.ic_menu_camera);
            setFadeAnimation(mCardView);
            mCardView.setTag(position);

        }
        private void setFadeAnimation(View view) {
            AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
            anim.setDuration(2000);
            view.startAnimation(anim);
        }
    }
}