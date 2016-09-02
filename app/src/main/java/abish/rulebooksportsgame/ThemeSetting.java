package abish.rulebooksportsgame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Constants.Constant;
import abish.rulebooksportsgame.Models.ThemeGetSet;
import abish.rulebooksportsgame.adapter.SettingsPageAdapter;
import util.SetCustomThemeToActivity;

/**
 * Created by kapil on 21/08/16.
 */
public class ThemeSetting extends AppCompatActivity implements CallThemeChanging {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCustomTheme(Constant.theme);
        setContentView(R.layout.settings);

        RecyclerView settings = (RecyclerView)findViewById(R.id.settings);
        List<ThemeGetSet> settingNames = new ArrayList<ThemeGetSet>();

        int theme = Constant.theme;
        for(int i=0;i<ThemeGetSet.images.length;i++) {
            ThemeGetSet tgs = new ThemeGetSet();
            tgs.setThemeImage(ThemeGetSet.images[i]);
            tgs.setThemeName(ThemeGetSet.themeNames[i]);
            if(Constant.theme == -1 && i == 0)
                tgs.setSelected(1);
            else if(Constant.theme == i)
                tgs.setSelected(1);
            else
                tgs.setSelected(0);
            settingNames.add(tgs);
        }

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        settings.setLayoutManager(mLayoutManager);
        settings.setItemAnimator(new DefaultItemAnimator());

        ThemeSettingsPageAdapter adapter = new ThemeSettingsPageAdapter(this,settingNames,ThemeSetting.this);
        settings.setAdapter(adapter);

    }

    @Override
    public void setCustomTheme(int pos) {
        SetCustomThemeToActivity obj = new SetCustomThemeToActivity();
        obj.setCustomTheme(this,pos);
//        switch (pos) {
//            case -1:
//                setTheme(R.style.AppTheme);
//                break;
//            case 0:
//                setTheme(R.style.myStyle);
//                break;
//            case 1:
//                setTheme(R.style.myStyle1);
//                break;
//            case 2:
//                setTheme(R.style.myStyle2);
//                break;
//            case 3:
//                setTheme(R.style.myStyle3);
//                break;
//            case 4:
//                setTheme(R.style.myStyle4);
//                break;
//        }
//        Constant.theme=pos;
//
//        SharedPreferences sp=getSharedPreferences(Constant.sharedPrefName, Context.MODE_PRIVATE);
//        SharedPreferences.Editor ed=sp.edit();
//        ed.putInt(Constant.sharedPrefThemeSaveKey, pos);
//        ed.commit();

        if(pos>=0 && Constant.reloaded == 0)
            reloadActivity();
        Constant.reloaded=1;

    }

    private void reloadActivity() {
        Intent intent = new Intent(this,SplashScreen.class);
        //finishAffinity();
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public class ThemeSettingsPageAdapter extends RecyclerView.Adapter<ThemeSettingsPageAdapter.MyViewHolder> {
        private List<ThemeGetSet> items;
        Context context;
        CallThemeChanging interfaceObj;
        int previous=-1;
        public CardView lastSelectedView=null;

        public ThemeSettingsPageAdapter(Context con, List<ThemeGetSet> itemslist,CallThemeChanging obj) {
            context=con;
            this.items = itemslist;
            interfaceObj = obj;
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
            public CardView mCardView;

            public MyViewHolder(View view) {
                super(view);
                text = (TextView) view.findViewById(R.id._text);
                img = (ImageView) view.findViewById(R.id._img);
                mCardView = (CardView) view.findViewById(R.id.card);
                lastSelectedView = new CardView(context);
               // mCardView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                int position = (int) v.getTag();
                //items.get(previous).setSelected(0);
                //mCardView.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                switch (position) {
                    case 0:
                        Toast.makeText(context, v.getTag() + "", Toast.LENGTH_SHORT).show();
                        interfaceObj.setCustomTheme(position);
                        break;
                    case 1:
                        //context.startActivity(new Intent(context, UrlHandlerActivity.class));
                        Toast.makeText(context, v.getTag() + "", Toast.LENGTH_SHORT).show();
                        break;
                }
                mCardView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            holder.text.setText(items.get(position).getThemeName());
            holder.img.setImageResource(items.get(position).getThemeImage());
            if(items.get(position).getSelected()==1) {
                holder.mCardView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                lastSelectedView = holder.mCardView;
                previous=position;
            }else
                holder.mCardView.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            holder.mCardView.setTag(position);
            animate(holder.mCardView,position);
            holder.mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    items.get(previous).setSelected(0);
                    if((int)view.getTag()==position) {
                        notifyItemChanged(previous);
                        holder.mCardView.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    }
                    holder.mCardView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    items.get(position).setSelected(1);
                    lastSelectedView = holder.mCardView;
                    Constant.reloaded = 0;
                    interfaceObj.setCustomTheme(position);

                    notifyItemChanged(position);
                    //notifyDataSetChanged();
                }
            });
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


}

interface CallThemeChanging{
    public void setCustomTheme(int value);
}