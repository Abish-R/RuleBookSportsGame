package abish.rulebooksportsgame.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.Toast;

import Constants.Constant;
import abish.rulebooksportsgame.CallRecordsGetMethod;
import abish.rulebooksportsgame.R;
import fragments.CricketRecords;

/**
 * Created by helixtech-android on 29/6/16.
 */
public class CricketRecordsControlAdapter extends RecyclerView.Adapter{
    Context context;
    CallRecordsGetMethod obj;
    private Interpolator mInterpolator = new LinearInterpolator();
    int adapter_length;

    public CricketRecordsControlAdapter(Context con,CallRecordsGetMethod ob, int length) {
        context=con;
        adapter_length=length;
        obj=ob;
    }

//    @Override
//    public int getItemViewType(int position) {
//            return items.get(position).getUnique();
//    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cricket_records_control_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            try{
            ((MyViewHolder)holder).bindViewHolder(position);
            }catch (Exception e){
                Log.e(Constant.Tag,e.toString());
            }
    }



    @Override
    public int getItemCount() {
        return adapter_length;
    }

    View lastButton,currentButton;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public Button b1;
        boolean firstButton=true;
        public MyViewHolder(View view) {
            super(view);
            b1 = (Button) view.findViewById(R.id.b1);
            b1.setOnClickListener(this);
        }

        public void bindViewHolder(int position) {
            b1.setText(Constant.recordsName[position]);
            b1.setTag(Constant.recordsTagName[position]);
            if(b1.getTag().equals(Constant.recordsTagName[0]) && firstButton) {
                currentButton = b1;
                lastButton = b1;
                b1.setBackgroundColor(context.getResources().getColor(R.color.white));
                obj.callUrlCallMethod(b1.getTag().toString());
                firstButton=false;
            }
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context,v.getTag().toString(),Toast.LENGTH_LONG).show();
            currentButton= b1;
            changeButtonColor(lastButton,currentButton);
            obj.callUrlCallMethod(v.getTag().toString());
            lastButton= b1;
        }

        private void changeButtonColor(View oldbtn,View newbtn){
            if(oldbtn==newbtn)
                Toast.makeText(context,"You are here",Toast.LENGTH_LONG).show();
            else{
                oldbtn.setBackgroundColor(context.getResources().getColor(R.color.grey_light1));
                newbtn.setBackgroundColor(context.getResources().getColor(R.color.white));
//                if(code==1) {
//                    changeNormalColor(code);
//                    test.setBackgroundColor(getResources().getColor(R.color.white));
//                    GetResponseString("Test");
//                }
//                else if(code==2) {
//                    changeNormalColor(code);
//                    odi.setBackgroundColor(getResources().getColor(R.color.white));
//                    GetResponseString("ODI");
//                }
//                else if(code==3) {
//                    changeNormalColor(code);
//                    t20.setBackgroundColor(getResources().getColor(R.color.white));
//                    GetResponseString("T20");
//                }
//                else if(code==4) {
//                    changeNormalColor(code);
//                    women.setBackgroundColor(getResources().getColor(R.color.white));
//                    GetResponseString("All");
//                }
            }
        }

//        private void changeNormalColor(int code){
//            if(lastPressed==1)
//                test.setBackgroundColor(getResources().getColor(R.color.grey_light1));
//            else if(lastPressed==2)
//                odi.setBackgroundColor(getResources().getColor(R.color.grey_light1));
//            else if(lastPressed==3)
//                t20.setBackgroundColor(getResources().getColor(R.color.grey_light1));
//            else if(lastPressed==4)
//                women.setBackgroundColor(getResources().getColor(R.color.grey_light1));
//            lastPressed=code;
//        }

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

}