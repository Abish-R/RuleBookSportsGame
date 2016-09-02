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
        else if(viewType==5 || viewType==6 || viewType==7 || viewType==8)
            return new MyViewHolderMostRunsInMatchTit(LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.cricket_records_most_run_match_titlecard, parent, false));
        else if(viewType==9)
            return new MyViewHolderMostRunsInMatchVal(LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.cricket_records_most_run_match_valcard, parent, false));
        else if(viewType==10 || viewType==11 || viewType==12)
            return new MyViewHolderMostRunsInCareerTit(LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.cricket_records_most_runs_in_career_titcard, parent, false));
        else if(viewType==13)
            return new MyViewHolderMostRunsInCareerVal(LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.cricket_records_most_runs_in_career_valcard, parent, false));
        else if(viewType==14 || viewType==15 || viewType==16 || viewType==17)
            return new MyViewHolderBestBowlInMatchTit(LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.cricket_records_bestbowling_titlecard, parent, false));
        else if(viewType==18)
            return new MyViewHolderBestBowlInMatchVal(LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.cricket_records_bestbowling_card, parent, false));
        else if(viewType==19 || viewType==20 || viewType==21)
            return new MyViewHolderMostWicketsTit(LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.cricket_records_most_wckt_in_career_titcard, parent, false));
        else if(viewType==22)
            return new MyViewHolderMostWicketsVal(LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.cricket_records_most_wckt_in_career_valcard, parent, false));
        else if(viewType==23 || viewType==24 || viewType==25)
            return new MyViewHolderMostDismissalWKTit(LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.cricket_records_wk_dismissal_titcard, parent, false));
        else if(viewType==26)
            return new MyViewHolderMostDismissalWKVal(LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.cricket_records_wk_dismissal_valcard, parent, false));
        else if(viewType==27 || viewType==28 || viewType==29)
            return new MyViewHolderPartnershipTit(LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.cricket_records_partnership_titcard, parent, false));
        else if(viewType==30)
            return new MyViewHolderPartnershipVal(LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.cricket_records_partnership_valcard, parent, false));
        else if(viewType==31 || viewType==32 || viewType==33)
            return new MyViewHolderCaptainRecordTit(LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.cricket_records_captain_titcard, parent, false));
        else if(viewType==34)
            return new MyViewHolderCaptainRecordVal(LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.cricket_records_captain_valcard, parent, false));
        else
            return null;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolderHighInngTotTit)
            try {
                ((MyViewHolderHighInngTotTit) holder).bindViewHolder(position);
            } catch (Exception e) {
                Log.e(Constant.TAG1, e.toString());
            }
        else if (holder instanceof MyViewHolderHighInngTotVal)
            try {
                ((MyViewHolderHighInngTotVal) holder).bindViewHolder(position);
            } catch (Exception e) {
                Log.e(Constant.TAG1, e.toString());
            }
        else if (holder instanceof MyViewHolderMostRunsInMatchTit)
            try {
                ((MyViewHolderMostRunsInMatchTit) holder).bindViewHolder(position);
            } catch (Exception e) {
                Log.e(Constant.TAG1, e.toString());
            }
        else if (holder instanceof MyViewHolderMostRunsInMatchVal)
            try {
                ((MyViewHolderMostRunsInMatchVal) holder).bindViewHolder(position);
            } catch (Exception e) {
                Log.e(Constant.TAG1, e.toString());
            }
        else if (holder instanceof MyViewHolderMostRunsInCareerTit)
            try {
                ((MyViewHolderMostRunsInCareerTit) holder).bindViewHolder(position);
            } catch (Exception e) {
                Log.e(Constant.TAG1, e.toString());
            }
        else if (holder instanceof MyViewHolderMostRunsInCareerVal)
            try {
                ((MyViewHolderMostRunsInCareerVal) holder).bindViewHolder(position);
            } catch (Exception e) {
                Log.e(Constant.TAG1, e.toString());
            }
        else if (holder instanceof MyViewHolderBestBowlInMatchTit)
            try {
                ((MyViewHolderBestBowlInMatchTit) holder).bindViewHolder(position);
            } catch (Exception e) {
                Log.e(Constant.TAG1, e.toString());
            }
        else if (holder instanceof MyViewHolderBestBowlInMatchVal)
            try {
                ((MyViewHolderBestBowlInMatchVal) holder).bindViewHolder(position);
            } catch (Exception e) {
                Log.e(Constant.TAG1, e.toString());
            }
        else if (holder instanceof MyViewHolderMostWicketsTit)
            try {
                ((MyViewHolderMostWicketsTit) holder).bindViewHolder(position);
            } catch (Exception e) {
                Log.e(Constant.TAG1, e.toString());
            }
        else if (holder instanceof MyViewHolderMostWicketsVal)
            try {
                ((MyViewHolderMostWicketsVal) holder).bindViewHolder(position);
            } catch (Exception e) {
                Log.e(Constant.TAG1, e.toString());
            }
        else if (holder instanceof MyViewHolderMostDismissalWKTit)
            try {
                ((MyViewHolderMostDismissalWKTit) holder).bindViewHolder(position);
            } catch (Exception e) {
                Log.e(Constant.TAG1, e.toString());
            }
        else if (holder instanceof MyViewHolderMostDismissalWKVal)
            try {
                ((MyViewHolderMostDismissalWKVal) holder).bindViewHolder(position);
            } catch (Exception e) {
                Log.e(Constant.TAG1, e.toString());
            }
        else if (holder instanceof MyViewHolderPartnershipTit)
            try {
                ((MyViewHolderPartnershipTit) holder).bindViewHolder(position);
            } catch (Exception e) {
                Log.e(Constant.TAG1, e.toString());
            }
        else if (holder instanceof MyViewHolderPartnershipVal)
            try {
                ((MyViewHolderPartnershipVal) holder).bindViewHolder(position);
            } catch (Exception e) {
                Log.e(Constant.TAG1, e.toString());
            }
        else if (holder instanceof MyViewHolderCaptainRecordTit)
            try {
                ((MyViewHolderCaptainRecordTit) holder).bindViewHolder(position);
            } catch (Exception e) {
                Log.e(Constant.TAG1, e.toString());
            }
        else if (holder instanceof MyViewHolderCaptainRecordVal)
            try {
                ((MyViewHolderCaptainRecordVal) holder).bindViewHolder(position);
            } catch (Exception e) {
                Log.e(Constant.TAG1, e.toString());
            }
    }


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

    public class MyViewHolderMostRunsInMatchTit extends RecyclerView.ViewHolder{
        public TextView subtitle,runs_balls,name,teams,ground,last_update_date;
        public RelativeLayout layout;
        public View mCardView;

        public MyViewHolderMostRunsInMatchTit(View view) {
            super(view);
            subtitle = (TextView) view.findViewById(R.id.subtitle);
            last_update_date =(TextView)view.findViewById(R.id.last_update_date);
            runs_balls = (TextView) view.findViewById(R.id.runs_balls);
            name = (TextView) view.findViewById(R.id.name);
            teams = (TextView) view.findViewById(R.id.teams);
            ground = (TextView) view.findViewById(R.id.ground);
            ground.setSelected(true);
            name.setSelected(true);
            last_update_date = (TextView) view.findViewById(R.id.last_update_date);
            mCardView = (CardView) view.findViewById(R.id.card);
            //mCardView.setOnClickListener(this);
        }

        public void bindViewHolder(int position) {
            subtitle.setText(items.get(position).getTitle());
            last_update_date.setText(items.get(position).getLastUpdatedDate());
            runs_balls.setText(items.get(position).getRuns()+"/"+items.get(position).getBalls()+"b");
            name.setText(items.get(position).getPlayer());
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

    public class MyViewHolderMostRunsInMatchVal extends RecyclerView.ViewHolder{
        public TextView runs_balls,name,teams,ground;
        public RelativeLayout layout;
        public View mCardView;

        public MyViewHolderMostRunsInMatchVal(View view) {
            super(view);
            runs_balls = (TextView) view.findViewById(R.id.runs_balls);
            teams = (TextView) view.findViewById(R.id.teams);
            name = (TextView) view.findViewById(R.id.name);
            ground = (TextView) view.findViewById(R.id.ground);
            ground.setSelected(true);
            name.setSelected(true);
            layout = (RelativeLayout) view.findViewById(R.id.layout);
            mCardView = (CardView) view.findViewById(R.id.card);
            //mCardView.setOnClickListener(this);
        }

        public void bindViewHolder(int position) {
            runs_balls.setText(items.get(position).getRuns()+"/"+items.get(position).getBalls());
            name.setText(items.get(position).getPlayer());
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

    public class MyViewHolderMostRunsInCareerTit extends RecyclerView.ViewHolder{
        public TextView subtitle,runs,name,team,span,matches,innings,high_score,average,tons,fifties,last_update_date;
        public RelativeLayout layout;
        public View mCardView;

        public MyViewHolderMostRunsInCareerTit(View view) {
            super(view);
            subtitle = (TextView) view.findViewById(R.id.subtitle);
            last_update_date =(TextView)view.findViewById(R.id.last_update_date);
            runs = (TextView) view.findViewById(R.id.runs);
            name = (TextView) view.findViewById(R.id.name);
            team = (TextView) view.findViewById(R.id.team);
            span = (TextView) view.findViewById(R.id.span);
            matches = (TextView) view.findViewById(R.id.matches);
            innings = (TextView) view.findViewById(R.id.innings);
            high_score = (TextView) view.findViewById(R.id.high_score);
            average = (TextView) view.findViewById(R.id.average);
            tons = (TextView) view.findViewById(R.id.tons);
            fifties = (TextView) view.findViewById(R.id.fifties);
            name.setSelected(true);
            last_update_date = (TextView) view.findViewById(R.id.last_update_date);
            mCardView = (CardView) view.findViewById(R.id.card);
            //mCardView.setOnClickListener(this);
        }

        public void bindViewHolder(int position) {
            subtitle.setText(items.get(position).getTitle());
            last_update_date.setText(items.get(position).getLastUpdatedDate());
            runs.setText(items.get(position).getRuns());
            name.setText(items.get(position).getPlayer());
            team.setText(items.get(position).getHomeTeam());
            span.setText(items.get(position).getSpan());
            matches.setText(items.get(position).getNoOfMatches());
            innings.setText(items.get(position).getNoOfInnings());
            high_score.setText(items.get(position).getHighScore());
            average.setText(items.get(position).getAverage());
            tons.setText(items.get(position).getNoOfTons());
            fifties.setText(items.get(position).getNoOfFifties());

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

    public class MyViewHolderMostRunsInCareerVal extends RecyclerView.ViewHolder{
        public TextView runs,name,team,span,matches,innings,high_score,average,tons,fifties;
        public RelativeLayout layout;
        public View mCardView;

        public MyViewHolderMostRunsInCareerVal(View view) {
            super(view);
            runs = (TextView) view.findViewById(R.id.runs);
            name = (TextView) view.findViewById(R.id.name);
            team = (TextView) view.findViewById(R.id.team);
            span = (TextView) view.findViewById(R.id.span);
            matches = (TextView) view.findViewById(R.id.matches);
            innings = (TextView) view.findViewById(R.id.innings);
            high_score = (TextView) view.findViewById(R.id.high_score);
            average = (TextView) view.findViewById(R.id.average);
            tons = (TextView) view.findViewById(R.id.tons);
            fifties = (TextView) view.findViewById(R.id.fifties);
            name.setSelected(true);
            mCardView = (CardView) view.findViewById(R.id.card);
            //mCardView.setOnClickListener(this);
        }

        public void bindViewHolder(int position) {
            runs.setText(items.get(position).getRuns());
            name.setText(items.get(position).getPlayer());
            team.setText(items.get(position).getHomeTeam());
            span.setText(items.get(position).getSpan());
            matches.setText(items.get(position).getNoOfMatches());
            innings.setText(items.get(position).getNoOfInnings());
            high_score.setText(items.get(position).getHighScore());
            average.setText(items.get(position).getAverage());
            tons.setText(items.get(position).getNoOfTons());
            fifties.setText(items.get(position).getNoOfFifties());

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

    public class MyViewHolderBestBowlInMatchTit extends RecyclerView.ViewHolder{
        public TextView subtitle,name,team1,team2,overs,maidens,runs,wickets,economy,ground_matchdate,last_update_date;
        public RelativeLayout layout;
        public View mCardView;

        public MyViewHolderBestBowlInMatchTit(View view) {
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

    public class MyViewHolderBestBowlInMatchVal extends RecyclerView.ViewHolder{
        public TextView subtitle,name,team1,team2,overs,maidens,runs,wickets,economy,ground_matchdate,last_update_date;
        public RelativeLayout layout;
        public View mCardView;

        public MyViewHolderBestBowlInMatchVal(View view) {
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

    public class MyViewHolderMostWicketsTit extends RecyclerView.ViewHolder{
        public TextView subtitle,wickets,name,team,span,matches,innings,best_bowled,average,//strike_rate,
                five_ten_wickets,balls_runs,last_update_date;
        public RelativeLayout layout;
        public View mCardView;

        public MyViewHolderMostWicketsTit(View view) {
            super(view);
            subtitle = (TextView) view.findViewById(R.id.subtitle);
            wickets = (TextView) view.findViewById(R.id.wickets);
            name = (TextView) view.findViewById(R.id.name);
            team = (TextView) view.findViewById(R.id.team);
            span = (TextView) view.findViewById(R.id.span);
            matches = (TextView) view.findViewById(R.id.matches);
            innings = (TextView) view.findViewById(R.id.innings);
            best_bowled = (TextView) view.findViewById(R.id.best_bowled);
            average = (TextView) view.findViewById(R.id.average);
            //strike_rate = (TextView) view.findViewById(R.id.strike_rate);
            five_ten_wickets = (TextView) view.findViewById(R.id.five_ten_wickets);
            balls_runs = (TextView) view.findViewById(R.id.balls_runs);
            last_update_date = (TextView) view.findViewById(R.id.last_update_date);
            layout = (RelativeLayout) view.findViewById(R.id.layout);
            mCardView = (CardView) view.findViewById(R.id.card);
            //mCardView.setOnClickListener(this);
        }

        public void bindViewHolder(int position) {
            subtitle.setText(items.get(position).getTitle());
            last_update_date.setText(items.get(position).getLastUpdatedDate());
            wickets.setText(items.get(position).getWickets());
            name.setText(items.get(position).getPlayer());
            team.setText(items.get(position).getHomeTeam());
            span.setText(items.get(position).getSpan());
            matches.setText(items.get(position).getNoOfMatches());
            innings.setText(items.get(position).getNoOfInnings());
            best_bowled.setText(items.get(position).getBestBowledInInngs()+","+items.get(position).getBestBowledInMatch());
            average.setText(items.get(position).getAverage());
            //strike_rate.setText(items.get(position).getStrikeRate());
            five_ten_wickets.setText(items.get(position).getFiveWickets()+"/"+items.get(position).getTenWickets());
            balls_runs.setText(items.get(position).getBalls()+"/"+items.get(position).getRuns());

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

    public class MyViewHolderMostWicketsVal extends RecyclerView.ViewHolder{
        public TextView subtitle,wickets,name,team,span,matches,innings,best_bowled,average,//strike_rate,
                five_ten_wickets,balls_runs;
        public RelativeLayout layout;
        public View mCardView;

        public MyViewHolderMostWicketsVal(View view) {
            super(view);
            //subtitle = (TextView) view.findViewById(R.id.subtitle);
            wickets = (TextView) view.findViewById(R.id.wickets);
            name = (TextView) view.findViewById(R.id.name);
            team = (TextView) view.findViewById(R.id.team);
            span = (TextView) view.findViewById(R.id.span);
            matches = (TextView) view.findViewById(R.id.matches);
            innings = (TextView) view.findViewById(R.id.innings);
            best_bowled = (TextView) view.findViewById(R.id.best_bowled);
            average = (TextView) view.findViewById(R.id.average);
            //strike_rate = (TextView) view.findViewById(R.id.strike_rate);
            five_ten_wickets = (TextView) view.findViewById(R.id.five_ten_wickets);

            balls_runs = (TextView) view.findViewById(R.id.balls_runs);
            //last_update_date = (TextView) view.findViewById(R.id.last_update_date);
            layout = (RelativeLayout) view.findViewById(R.id.layout);
            mCardView = (CardView) view.findViewById(R.id.card);
            //mCardView.setOnClickListener(this);
        }

        public void bindViewHolder(int position) {
            wickets.setText(items.get(position).getWickets());
            name.setText(items.get(position).getPlayer());
            team.setText(items.get(position).getHomeTeam());
            span.setText(items.get(position).getSpan());
            matches.setText(items.get(position).getNoOfMatches());
            innings.setText(items.get(position).getNoOfInnings());
            best_bowled.setText(items.get(position).getBestBowledInInngs()+","+items.get(position).getBestBowledInMatch());
            average.setText(items.get(position).getAverage());
            //strike_rate.setText(items.get(position).getStrikeRate());
            five_ten_wickets.setText(items.get(position).getFiveWickets()+"/"+items.get(position).getTenWickets());
            balls_runs.setText(items.get(position).getBalls()+"/"+items.get(position).getRuns());

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
    public class MyViewHolderMostDismissalWKTit extends RecyclerView.ViewHolder{
        public TextView subtitle,dismissal,name,team,span,matches,innings,cat_stumps,average,//strike_rate,
                max,last_update_date;
        public RelativeLayout layout;
        public View mCardView;

        public MyViewHolderMostDismissalWKTit(View view) {
            super(view);
            subtitle = (TextView) view.findViewById(R.id.subtitle);
            dismissal = (TextView) view.findViewById(R.id.dismissal);
            name = (TextView) view.findViewById(R.id.name);
            team = (TextView) view.findViewById(R.id.team);
            span = (TextView) view.findViewById(R.id.span);
            matches = (TextView) view.findViewById(R.id.matches);
            innings = (TextView) view.findViewById(R.id.innings);
            cat_stumps = (TextView) view.findViewById(R.id.cat_stumps);
            average = (TextView) view.findViewById(R.id.average);
            //strike_rate = (TextView) view.findViewById(R.id.strike_rate);
            max = (TextView) view.findViewById(R.id.max);
            last_update_date = (TextView) view.findViewById(R.id.last_update_date);
            layout = (RelativeLayout) view.findViewById(R.id.layout);
            mCardView = (CardView) view.findViewById(R.id.card);
            //mCardView.setOnClickListener(this);
        }

        public void bindViewHolder(int position) {
            subtitle.setText(items.get(position).getTitle());
            last_update_date.setText(items.get(position).getLastUpdatedDate());
            dismissal.setText(items.get(position).getWickets());
            name.setText(items.get(position).getPlayer());
            team.setText(items.get(position).getHomeTeam());
            span.setText(items.get(position).getSpan());
            matches.setText(items.get(position).getNoOfMatches());
            innings.setText(items.get(position).getNoOfInnings());
            cat_stumps.setText(items.get(position).getCatches()+","+items.get(position).getStumbings());
            average.setText(items.get(position).getAverage());
            //strike_rate.setText(items.get(position).getStrikeRate());
            max.setText(items.get(position).getMaxDismissalInMatch());

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

    public class MyViewHolderMostDismissalWKVal extends RecyclerView.ViewHolder{
        public TextView subtitle,dismissal,name,team,span,matches,innings,cat_stumps,average,max;
        public RelativeLayout layout;
        public View mCardView;

        public MyViewHolderMostDismissalWKVal(View view) {
            super(view);
            dismissal = (TextView) view.findViewById(R.id.dismissal);
            name = (TextView) view.findViewById(R.id.name);
            team = (TextView) view.findViewById(R.id.team);
            span = (TextView) view.findViewById(R.id.span);
            matches = (TextView) view.findViewById(R.id.matches);
            innings = (TextView) view.findViewById(R.id.innings);
            cat_stumps = (TextView) view.findViewById(R.id.cat_stumps);
            average = (TextView) view.findViewById(R.id.average);
            //strike_rate = (TextView) view.findViewById(R.id.strike_rate);
            max = (TextView) view.findViewById(R.id.max);
            //last_update_date = (TextView) view.findViewById(R.id.last_update_date);
            layout = (RelativeLayout) view.findViewById(R.id.layout);
            mCardView = (CardView) view.findViewById(R.id.card);
            //mCardView.setOnClickListener(this);
        }

        public void bindViewHolder(int position) {
            dismissal.setText(items.get(position).getWickets());
            name.setText(items.get(position).getPlayer());
            team.setText(items.get(position).getHomeTeam());
            span.setText(items.get(position).getSpan());
            matches.setText(items.get(position).getNoOfMatches());
            innings.setText(items.get(position).getNoOfInnings());
            cat_stumps.setText(items.get(position).getCatches()+","+items.get(position).getStumbings());
            average.setText(items.get(position).getAverage());
            //strike_rate.setText(items.get(position).getStrikeRate());
            max.setText(items.get(position).getMaxDismissalInMatch());

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

    public class MyViewHolderPartnershipTit extends RecyclerView.ViewHolder{
        public TextView subtitle,runs,name,team,opponent,in_wicket,ground,match_date,last_update_date;
        public RelativeLayout layout;
        public View mCardView;

        public MyViewHolderPartnershipTit(View view) {
            super(view);
            subtitle = (TextView) view.findViewById(R.id.subtitle);
            runs = (TextView) view.findViewById(R.id.runs);
            name = (TextView) view.findViewById(R.id.name);
            team = (TextView) view.findViewById(R.id.team);
            opponent = (TextView) view.findViewById(R.id.opponent);
            in_wicket = (TextView) view.findViewById(R.id.in_wicket);
            ground = (TextView) view.findViewById(R.id.ground);
            match_date = (TextView) view.findViewById(R.id.match_date);
            last_update_date = (TextView) view.findViewById(R.id.last_update_date);
            layout = (RelativeLayout) view.findViewById(R.id.layout);
            mCardView = (CardView) view.findViewById(R.id.card);
            //mCardView.setOnClickListener(this);
        }

        public void bindViewHolder(int position) {
            subtitle.setText(items.get(position).getTitle());
            last_update_date.setText(items.get(position).getLastUpdatedDate());
            runs.setText(items.get(position).getWickets());
            name.setText(items.get(position).getPlayer());
            team.setText(items.get(position).getHomeTeam());
            opponent.setText(items.get(position).getOppositionTeam());
            in_wicket.setText(items.get(position).getWickets()+"Wic");
            ground.setText(items.get(position).getVenue());
            match_date.setText(items.get(position).getMatchDate());

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

    public class MyViewHolderPartnershipVal extends RecyclerView.ViewHolder{
        public TextView runs,name,team,opponent,in_wicket,ground,match_date;
        public RelativeLayout layout;
        public View mCardView;

        public MyViewHolderPartnershipVal(View view) {
            super(view);
            runs = (TextView) view.findViewById(R.id.runs);
            name = (TextView) view.findViewById(R.id.name);
            team = (TextView) view.findViewById(R.id.team);
            opponent = (TextView) view.findViewById(R.id.opponent);
            in_wicket = (TextView) view.findViewById(R.id.in_wicket);
            ground = (TextView) view.findViewById(R.id.ground);
            match_date = (TextView) view.findViewById(R.id.match_date);
            layout = (RelativeLayout) view.findViewById(R.id.layout);
            mCardView = (CardView) view.findViewById(R.id.card);
            //mCardView.setOnClickListener(this);
        }

        public void bindViewHolder(int position) {
            runs.setText(items.get(position).getWickets());
            name.setText(items.get(position).getPlayer());
            team.setText(items.get(position).getHomeTeam());
            opponent.setText(items.get(position).getOppositionTeam());
            in_wicket.setText(items.get(position).getWickets()+"Wic");
            ground.setText(items.get(position).getVenue());
            match_date.setText(items.get(position).getMatchDate());

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

    public class MyViewHolderCaptainRecordTit extends RecyclerView.ViewHolder{
        public TextView subtitle,name,team,span,mat,win,loss,win_percent,last_update_date;
        public RelativeLayout layout;
        public View mCardView;

        public MyViewHolderCaptainRecordTit(View view) {
            super(view);
            subtitle = (TextView) view.findViewById(R.id.subtitle);
            name = (TextView) view.findViewById(R.id.name);
            team = (TextView) view.findViewById(R.id.team);
            span = (TextView) view.findViewById(R.id.span);
            mat = (TextView) view.findViewById(R.id.mat);
            win = (TextView) view.findViewById(R.id.win);
            loss = (TextView) view.findViewById(R.id.loss);
            win_percent = (TextView) view.findViewById(R.id.win_percent);
            last_update_date = (TextView) view.findViewById(R.id.last_update_date);
            layout = (RelativeLayout) view.findViewById(R.id.layout);
            mCardView = (CardView) view.findViewById(R.id.card);
            //mCardView.setOnClickListener(this);
        }

        public void bindViewHolder(int position) {
            subtitle.setText(items.get(position).getTitle());
            last_update_date.setText(items.get(position).getLastUpdatedDate());
            name.setText(items.get(position).getPlayer());
            team.setText(items.get(position).getHomeTeam());
            span.setText(items.get(position).getSpan());
            mat.setText(items.get(position).getNoOfMatches());
            win.setText(items.get(position).getNoOfMatchWon());
            loss.setText(items.get(position).getNoOfMatchLost());
            win_percent.setText(items.get(position).getWinPercent());

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

    public class MyViewHolderCaptainRecordVal extends RecyclerView.ViewHolder{
        public TextView name,team,span,mat,win,loss,win_percent;
        public RelativeLayout layout;
        public View mCardView;

        public MyViewHolderCaptainRecordVal(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            team = (TextView) view.findViewById(R.id.team);
            span = (TextView) view.findViewById(R.id.span);
            mat = (TextView) view.findViewById(R.id.mat);
            win = (TextView) view.findViewById(R.id.win);
            loss = (TextView) view.findViewById(R.id.loss);
            win_percent = (TextView) view.findViewById(R.id.win_percent);
            layout = (RelativeLayout) view.findViewById(R.id.layout);
            mCardView = (CardView) view.findViewById(R.id.card);
            //mCardView.setOnClickListener(this);
        }

        public void bindViewHolder(int position) {
            name.setText(items.get(position).getPlayer());
            team.setText(items.get(position).getHomeTeam());
            span.setText(items.get(position).getSpan());
            mat.setText(items.get(position).getNoOfMatches());
            win.setText(items.get(position).getNoOfMatchWon());
            loss.setText(items.get(position).getNoOfMatchLost());
            win_percent.setText(items.get(position).getWinPercent());

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