package fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import Constants.Constant;
import Constants.ConstantCountryShorts;
import Constants.WebserviceLinks;
import abish.rulebooksportsgame.AppController;
import abish.rulebooksportsgame.CallRecordsGetMethod;
import abish.rulebooksportsgame.Models.CricketRankingModel;
import abish.rulebooksportsgame.Models.CricketRecordsModel;
import abish.rulebooksportsgame.R;
import abish.rulebooksportsgame.adapter.CricketRankingAdapter;
import abish.rulebooksportsgame.adapter.CricketRecordsAdapter;
import abish.rulebooksportsgame.adapter.CricketRecordsControlAdapter;

public class CricketRecords extends Fragment implements CallRecordsGetMethod {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    FragmentTabHost mTabHost;
    View view;
    Context context;
    RecyclerView record_recycler_controller,record_recycler;
    String calledfrom;
    List<CricketRecordsModel> list;

    private OnFragmentInteractionListener mListener;

    public CricketRecords() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of this fragment using the provided parameters.
     */
    public static CricketRecords newInstance(String param1, String param2) {
        CricketRecords fragment = new CricketRecords();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        context = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.cricket_tabrecords, container, false);
        record_recycler_controller = (RecyclerView) view.findViewById(R.id.record_recycler_controller);
        record_recycler = (RecyclerView) view.findViewById(R.id.record_recycler);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        record_recycler_controller.setLayoutManager(layoutManager);
        record_recycler_controller.setItemAnimator(new DefaultItemAnimator());
        setRecordsController();


        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void callUrlCallMethod(String param) {
        String url;
        if(param.equals("best_bowlig_figures_in_match") || param.equals("best_career_bowlig_average") || param.equals("most_wickets_in_career"))
            url=WebserviceLinks.cricketBowlingRecords+param;
        else if(param.equals("highest_innings_totals") || param.equals("lowest_innings_totals"))
            url=WebserviceLinks.cricketTeamRecords+param;
        else
            url=WebserviceLinks.cricketBattingRecords+param;
        CricketRecordsModel crm =new CricketRecordsModel();
        crm=null;
        GetResponseString(url,param);
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void setRecordsController(){
        CricketRecordsControlAdapter adapter = new CricketRecordsControlAdapter(getActivity(),this,Constant.recordsName.length);
        record_recycler_controller.setAdapter(adapter);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        record_recycler.setLayoutManager(mLayoutManager);
        record_recycler.setItemAnimator(new DefaultItemAnimator());
        //callUrlCallMethod("best_bowlig_figures_in_match");
    }

    public void GetResponseString(final String url,final String text){
        final String tag_json_obj = Constant.Tag;

        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading Record...");
        pDialog.show();

        StringRequest req = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        pDialog.hide();
                        JSONObject json;
                        int validation=0;
                        try {
                            json = new JSONObject(response);
                            validation=json.getInt("response");
                        }catch (JSONException e){
                            Log.e(Constant.JSONEXCEPTION,e.toString());
                        }

                        if(text.equals("highest_innings_totals") && validation==1)
                            setValuesHighInngTotal(response);
                        else if(text.equals("lowest_innings_totals") && validation==1)
                            setValuesHighInngTotal(response);
                            //setValuesLowInngTotal(response);
                        else if(text.equals("most_runs_in_match") && validation==1)
                            setValuesMostRunInMatch(response);
                        else if(text.equals("most_runs_in_career") && validation==1)
                            setValuesMostRunInCareer(response);
                        else if(text.equals("highest_average_in_career") && validation==1)
                            setValuesHighAvgInCareer(response);
                        else if(text.equals("most_hundreds_in_career") && validation==1)
                            setValuesMostTon(response);
                        else if(text.equals("Most_Fifty") && validation==1)
                            setValuesMostHalfTon(response);
                        else if(text.equals("best_bowlig_figures_in_match") && validation==1)
                            setValuesBestBowlingInMatch(response);
                        else if(text.equals("most_wickets_in_career") && validation==1)
                            setValuesMostWckts(response);
                        else if(text.equals("best_career_bowlig_average") && validation==1)
                            setValuesBestBowlAvg(response);
                        else if(text.equals("WK_Dismissals") && validation==1)
                            setValuesWkDismissal(response);
                        else if(text.equals("highest_partnership") && validation==1)
                            setValuesHighPartnershp(response);
                        else if(text.equals("Match_Captain") && validation==1)
                            setValuesMostMatchCaptian(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // handle error response
                        pDialog.hide();
                        Snackbar snackbar = Snackbar
                                .make(view, "No internet connection!", Snackbar.LENGTH_INDEFINITE)
                                .setAction("RETRY", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        GetResponseString(url,text);
                                    }
                                });
                        snackbar.setActionTextColor(Color.RED);
                        View sbView = snackbar.getView();
                        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                        textView.setTextColor(Color.YELLOW);
                        snackbar.show();

                    }
                });

// Adding request to request queue
        AppController.getInstance().addToRequestQueue(req, tag_json_obj);
        //return valiue;
    }

    private void setValuesBestBowlingInMatch(String response){
        list = new ArrayList<CricketRecordsModel>();
        try {
            JSONObject json = new JSONObject(response);

            String[] jsonArray={"TestMatch","TestInnings","ODI","T20"};
            for(int j=0;j<4;j++) {
                JSONArray arrayTestTeam = json.getJSONArray(jsonArray[j]);
                //setValueInModelCallAdapter(j+1, jsonArray[j], "", "", "", "","","","","","","");
                for (int i = 0; i < arrayTestTeam.length(); i++) {
                    int unique=0;String title="";
                    if(i==0) {
                        unique = j + 1;
                        title=jsonArray[j];
                    }else
                        unique = 16;
                    String titleSet = title;
                    String player = arrayTestTeam.getJSONObject(i).getString("player_name");
                    String country = arrayTestTeam.getJSONObject(i).getString("country");
                    String oppostition = arrayTestTeam.getJSONObject(i).getString("oppostition");
                    String overs = arrayTestTeam.getJSONObject(i).getString("overs");
                    String maidens = arrayTestTeam.getJSONObject(i).getString("maidens");
                    String runs = arrayTestTeam.getJSONObject(i).getString("runs");
                    String wickets = arrayTestTeam.getJSONObject(i).getString("wickets");
                    String economy = arrayTestTeam.getJSONObject(i).getString("economy");
                    String ground = "@" + arrayTestTeam.getJSONObject(i).getString("ground") + ", ";
                    String match_date = arrayTestTeam.getJSONObject(i).getString("match_date");
                    String last_updated_date = arrayTestTeam.getJSONObject(i).getString("updated_date");
                    //Toast.makeText(getActivity(),team+rank+matches+points,Toast.LENGTH_SHORT).show();
                    setValueInModelCallAdapterBestBowlingInMatch(unique,title, player, country, oppostition, overs,maidens,runs,
                            wickets,economy,ground,match_date, last_updated_date);
                }
            }

        }catch (JSONException e){
            Log.e("CricketRecordTest",e.toString());
        }
        CricketRecordsAdapter adapter = new CricketRecordsAdapter(getActivity(), list);
        record_recycler.setAdapter(adapter);
    }

    private void setValueInModelCallAdapterBestBowlingInMatch(int unique,String tit,String player,String country,String oppostition,String overs,
                 String maidens,String runs,String wickets,String economy,String ground,String match_date,String last_updated_date){

        CricketRecordsModel cm = new CricketRecordsModel();

        cm.setUnique(unique);                  cm.setTitle(tit);
        cm.setPlayer(player);                   cm.setHomeTeam(country);
        cm.setOppositionTeam(oppostition);      cm.setOvers(overs);
        cm.setMaidens(maidens);                 cm.setRuns(runs);
        cm.setWickets(wickets);                 cm.setEconomy(economy);
        cm.setVenue(ground);                    cm.setMatchDate(match_date);
        cm.setLastUpdatedDate(last_updated_date);
        list.add(cm);
    }

    private void setValuesHighInngTotal(String response){
        list = new ArrayList<CricketRecordsModel>();
        try {
            JSONObject json = new JSONObject(response);

            String[] jsonArray={"Test","ODI","T20"};
            for(int j=0;j<3;j++) {
                JSONArray arrayTestTeam = json.getJSONArray(jsonArray[j]);
                for (int i = 0; i < arrayTestTeam.length(); i++) {
                    int unique=0;String title="";
                    if(i==0) {
                        unique = j + 1;
                        title=jsonArray[j];
                    }else
                        unique = 4;
                    String titleSet = title;
                    String  rank="",overs="",run_rate="",innings="",match_date="";
                    String team = arrayTestTeam.getJSONObject(i).getString("team");
                    String opposition = arrayTestTeam.getJSONObject(i).getString("opposition");
                    String score = arrayTestTeam.getJSONObject(i).getString("score");
                    String ground = arrayTestTeam.getJSONObject(i).getString("ground");
                    String game_format = arrayTestTeam.getJSONObject(i).getString("game_format");
                    String last_updated_date = arrayTestTeam.getJSONObject(i).getString("updated_date");
                    // String rank = arrayTestTeam.getJSONObject(i).getString("rank");
                    // String overs = arrayTestTeam.getJSONObject(i).getString("overs");
                    // String run_rate = arrayTestTeam.getJSONObject(i).getString("run_rate");
                    //String innings = arrayTestTeam.getJSONObject(i).getString("innings");
                    //String match_date = arrayTestTeam.getJSONObject(i).getString("match_date");


                    String teamTemp= ConstantCountryShorts.getCountryPostion(team);
                    if(teamTemp != null)
                        team = teamTemp;
                    teamTemp= ConstantCountryShorts.getCountryPostion(opposition);
                    if(teamTemp != null)
                        opposition = teamTemp;
                    setValueInModelCallAdapterHighInngTotal(unique,title, rank, team, opposition, score,overs,run_rate,
                            innings,ground,game_format,match_date, last_updated_date);
                }
            }

        }catch (JSONException e){
            Log.e(Constant.JSONEXCEPTION,e.toString());
        }
        CricketRecordsAdapter adapter = new CricketRecordsAdapter(getActivity(), list);
        record_recycler.setAdapter(adapter);
    }

    private void setValueInModelCallAdapterHighInngTotal(int unique,String tit,String rank,String country,String oppostition,String score,
                                            String overs,String run_rate,String innings,String ground,String game_format,String match_date,String last_updated_date){

        CricketRecordsModel cm = new CricketRecordsModel();
        cm.setUnique(unique);                   cm.setTitle(tit);
        //cm.setRank(rank); cm.setOvers(overs); cm.setRunRate(run_rate); cm.setInnings(innings); cm.setMatchDate(match_date);
        cm.setHomeTeam(country);        cm.setOppositionTeam(oppostition);
        cm.setScore(score);              cm.setGameFormat(game_format);
        cm.setVenue(ground);            cm.setLastUpdatedDate(last_updated_date);
        list.add(cm);
    }

    private void setValuesMostRunInMatch(String response){
        list = new ArrayList<CricketRecordsModel>();
        try {
            JSONObject json = new JSONObject(response);

            String[] jsonArray={"TestMatch","TestInnings","ODI","T20"};
            for(int j=0;j<4;j++) {
                JSONArray arrayTestTeam = json.getJSONArray(jsonArray[j]);
                //setValueInModelCallAdapter(j+1, jsonArray[j], "", "", "", "","","","","","","");
                for (int i = 0; i < arrayTestTeam.length(); i++) {
                    int unique=0;String title="";
                    if(i==0) {
                        unique = j + 1;
                        title=jsonArray[j];
                    }
                    String titleSet = title;
                    String player = arrayTestTeam.getJSONObject(i).getString("player_name");
                    String country = arrayTestTeam.getJSONObject(i).getString("country");
                    String oppostition = arrayTestTeam.getJSONObject(i).getString("oppostition");
                    String overs = arrayTestTeam.getJSONObject(i).getString("overs");
                    String maidens = arrayTestTeam.getJSONObject(i).getString("maidens");
                    String runs = arrayTestTeam.getJSONObject(i).getString("runs");
                    String wickets = arrayTestTeam.getJSONObject(i).getString("wickets");
                    String economy = arrayTestTeam.getJSONObject(i).getString("economy");
                    String ground = "@" + arrayTestTeam.getJSONObject(i).getString("ground") + ", ";
                    String match_date = arrayTestTeam.getJSONObject(i).getString("match_date");
                    String last_updated_date = arrayTestTeam.getJSONObject(i).getString("updated_date");
                    //Toast.makeText(getActivity(),team+rank+matches+points,Toast.LENGTH_SHORT).show();
                    setValueInModelCallAdapterMostRunInMatch(unique,title, player, country, oppostition, overs,maidens,runs,
                            wickets,economy,ground,match_date, last_updated_date);
                }
            }

        }catch (JSONException e){
            Log.e("CricketRecordTest",e.toString());
        }
        CricketRecordsAdapter adapter = new CricketRecordsAdapter(getActivity(), list);
        record_recycler.setAdapter(adapter);
    }

    private void setValueInModelCallAdapterMostRunInMatch(int unique,String tit,String player,String country,String oppostition,String overs,
                                                         String maidens,String runs,String wickets,String economy,String ground,String match_date,String last_updated_date){

        CricketRecordsModel cm = new CricketRecordsModel();

        cm.setUnique(unique);                  cm.setTitle(tit);
        cm.setPlayer(player);                   cm.setHomeTeam(country);
        cm.setOppositionTeam(oppostition);      cm.setOvers(overs);
        cm.setMaidens(maidens);                 cm.setRuns(runs);
        cm.setWickets(wickets);                 cm.setEconomy(economy);
        cm.setVenue(ground);                    cm.setMatchDate(match_date);
        cm.setLastUpdatedDate(last_updated_date);
        list.add(cm);
    }

    private void setValuesLowInngTotal(String response){
        list = new ArrayList<CricketRecordsModel>();
        try {
            JSONObject json = new JSONObject(response);

            String[] jsonArray={"TestMatch","TestInnings","ODI","T20"};
            for(int j=0;j<4;j++) {
                JSONArray arrayTestTeam = json.getJSONArray(jsonArray[j]);
                //setValueInModelCallAdapter(j+1, jsonArray[j], "", "", "", "","","","","","","");
                for (int i = 0; i < arrayTestTeam.length(); i++) {
                    int unique=0;String title="";
                    if(i==0) {
                        unique = j + 1;
                        title=jsonArray[j];
                    }
                    String titleSet = title;
                    String player = arrayTestTeam.getJSONObject(i).getString("player_name");
                    String country = arrayTestTeam.getJSONObject(i).getString("country");
                    String oppostition = arrayTestTeam.getJSONObject(i).getString("oppostition");
                    String overs = arrayTestTeam.getJSONObject(i).getString("overs");
                    String maidens = arrayTestTeam.getJSONObject(i).getString("maidens");
                    String runs = arrayTestTeam.getJSONObject(i).getString("runs");
                    String wickets = arrayTestTeam.getJSONObject(i).getString("wickets");
                    String economy = arrayTestTeam.getJSONObject(i).getString("economy");
                    String ground = "@" + arrayTestTeam.getJSONObject(i).getString("ground") + ", ";
                    String match_date = arrayTestTeam.getJSONObject(i).getString("match_date");
                    String last_updated_date = arrayTestTeam.getJSONObject(i).getString("updated_date");
                    //Toast.makeText(getActivity(),team+rank+matches+points,Toast.LENGTH_SHORT).show();
                    setValueInModelCallAdapterLowInngTotal(unique,title, player, country, oppostition, overs,maidens,runs,
                            wickets,economy,ground,match_date, last_updated_date);
                }
            }

        }catch (JSONException e){
            Log.e("CricketRecordTest",e.toString());
        }
        CricketRecordsAdapter adapter = new CricketRecordsAdapter(getActivity(), list);
        record_recycler.setAdapter(adapter);
    }

    private void setValueInModelCallAdapterLowInngTotal(int unique,String tit,String player,String country,String oppostition,String overs,
                                                         String maidens,String runs,String wickets,String economy,String ground,String match_date,String last_updated_date){

        CricketRecordsModel cm = new CricketRecordsModel();

        cm.setUnique(unique);                  cm.setTitle(tit);
        cm.setPlayer(player);                   cm.setHomeTeam(country);
        cm.setOppositionTeam(oppostition);      cm.setOvers(overs);
        cm.setMaidens(maidens);                 cm.setRuns(runs);
        cm.setWickets(wickets);                 cm.setEconomy(economy);
        cm.setVenue(ground);                    cm.setMatchDate(match_date);
        cm.setLastUpdatedDate(last_updated_date);
        list.add(cm);
    }

    private void setValuesMostRunInCareer(String response){
        list = new ArrayList<CricketRecordsModel>();
        try {
            JSONObject json = new JSONObject(response);

            String[] jsonArray={"TestMatch","TestInnings","ODI","T20"};
            for(int j=0;j<4;j++) {
                JSONArray arrayTestTeam = json.getJSONArray(jsonArray[j]);
                //setValueInModelCallAdapter(j+1, jsonArray[j], "", "", "", "","","","","","","");
                for (int i = 0; i < arrayTestTeam.length(); i++) {
                    int unique=0;String title="";
                    if(i==0) {
                        unique = j + 1;
                        title=jsonArray[j];
                    }
                    String titleSet = title;
                    String player = arrayTestTeam.getJSONObject(i).getString("player_name");
                    String country = arrayTestTeam.getJSONObject(i).getString("country");
                    String oppostition = arrayTestTeam.getJSONObject(i).getString("oppostition");
                    String overs = arrayTestTeam.getJSONObject(i).getString("overs");
                    String maidens = arrayTestTeam.getJSONObject(i).getString("maidens");
                    String runs = arrayTestTeam.getJSONObject(i).getString("runs");
                    String wickets = arrayTestTeam.getJSONObject(i).getString("wickets");
                    String economy = arrayTestTeam.getJSONObject(i).getString("economy");
                    String ground = "@" + arrayTestTeam.getJSONObject(i).getString("ground") + ", ";
                    String match_date = arrayTestTeam.getJSONObject(i).getString("match_date");
                    String last_updated_date = arrayTestTeam.getJSONObject(i).getString("updated_date");
                    //Toast.makeText(getActivity(),team+rank+matches+points,Toast.LENGTH_SHORT).show();
                    setValueInModelCallAdapterMostRunInCareer(unique,title, player, country, oppostition, overs,maidens,runs,
                            wickets,economy,ground,match_date, last_updated_date);
                }
            }

        }catch (JSONException e){
            Log.e("CricketRecordTest",e.toString());
        }
        CricketRecordsAdapter adapter = new CricketRecordsAdapter(getActivity(), list);
        record_recycler.setAdapter(adapter);
    }

    private void setValueInModelCallAdapterMostRunInCareer(int unique,String tit,String player,String country,String oppostition,String overs,
                                                         String maidens,String runs,String wickets,String economy,String ground,String match_date,String last_updated_date){

        CricketRecordsModel cm = new CricketRecordsModel();

        cm.setUnique(unique);                  cm.setTitle(tit);
        cm.setPlayer(player);                   cm.setHomeTeam(country);
        cm.setOppositionTeam(oppostition);      cm.setOvers(overs);
        cm.setMaidens(maidens);                 cm.setRuns(runs);
        cm.setWickets(wickets);                 cm.setEconomy(economy);
        cm.setVenue(ground);                    cm.setMatchDate(match_date);
        cm.setLastUpdatedDate(last_updated_date);
        list.add(cm);
    }

    private void setValuesHighAvgInCareer(String response){
        list = new ArrayList<CricketRecordsModel>();
        try {
            JSONObject json = new JSONObject(response);

            String[] jsonArray={"TestMatch","TestInnings","ODI","T20"};
            for(int j=0;j<4;j++) {
                JSONArray arrayTestTeam = json.getJSONArray(jsonArray[j]);
                //setValueInModelCallAdapter(j+1, jsonArray[j], "", "", "", "","","","","","","");
                for (int i = 0; i < arrayTestTeam.length(); i++) {
                    int unique=0;String title="";
                    if(i==0) {
                        unique = j + 1;
                        title=jsonArray[j];
                    }
                    String titleSet = title;
                    String player = arrayTestTeam.getJSONObject(i).getString("player_name");
                    String country = arrayTestTeam.getJSONObject(i).getString("country");
                    String oppostition = arrayTestTeam.getJSONObject(i).getString("oppostition");
                    String overs = arrayTestTeam.getJSONObject(i).getString("overs");
                    String maidens = arrayTestTeam.getJSONObject(i).getString("maidens");
                    String runs = arrayTestTeam.getJSONObject(i).getString("runs");
                    String wickets = arrayTestTeam.getJSONObject(i).getString("wickets");
                    String economy = arrayTestTeam.getJSONObject(i).getString("economy");
                    String ground = "@" + arrayTestTeam.getJSONObject(i).getString("ground") + ", ";
                    String match_date = arrayTestTeam.getJSONObject(i).getString("match_date");
                    String last_updated_date = arrayTestTeam.getJSONObject(i).getString("updated_date");
                    //Toast.makeText(getActivity(),team+rank+matches+points,Toast.LENGTH_SHORT).show();
                    setValueInModelCallAdapterHighAvgInCareer(unique,title, player, country, oppostition, overs,maidens,runs,
                            wickets,economy,ground,match_date, last_updated_date);
                }
            }

        }catch (JSONException e){
            Log.e("CricketRecordTest",e.toString());
        }
        CricketRecordsAdapter adapter = new CricketRecordsAdapter(getActivity(), list);
        record_recycler.setAdapter(adapter);
    }

    private void setValueInModelCallAdapterHighAvgInCareer(int unique,String tit,String player,String country,String oppostition,String overs,
                                                         String maidens,String runs,String wickets,String economy,String ground,String match_date,String last_updated_date){

        CricketRecordsModel cm = new CricketRecordsModel();

        cm.setUnique(unique);                  cm.setTitle(tit);
        cm.setPlayer(player);                   cm.setHomeTeam(country);
        cm.setOppositionTeam(oppostition);      cm.setOvers(overs);
        cm.setMaidens(maidens);                 cm.setRuns(runs);
        cm.setWickets(wickets);                 cm.setEconomy(economy);
        cm.setVenue(ground);                    cm.setMatchDate(match_date);
        cm.setLastUpdatedDate(last_updated_date);
        list.add(cm);
    }

    private void setValuesMostTon(String response){
        list = new ArrayList<CricketRecordsModel>();
        try {
            JSONObject json = new JSONObject(response);

            String[] jsonArray={"TestMatch","TestInnings","ODI","T20"};
            for(int j=0;j<4;j++) {
                JSONArray arrayTestTeam = json.getJSONArray(jsonArray[j]);
                //setValueInModelCallAdapter(j+1, jsonArray[j], "", "", "", "","","","","","","");
                for (int i = 0; i < arrayTestTeam.length(); i++) {
                    int unique=0;String title="";
                    if(i==0) {
                        unique = j + 1;
                        title=jsonArray[j];
                    }
                    String titleSet = title;
                    String player = arrayTestTeam.getJSONObject(i).getString("player_name");
                    String country = arrayTestTeam.getJSONObject(i).getString("country");
                    String oppostition = arrayTestTeam.getJSONObject(i).getString("oppostition");
                    String overs = arrayTestTeam.getJSONObject(i).getString("overs");
                    String maidens = arrayTestTeam.getJSONObject(i).getString("maidens");
                    String runs = arrayTestTeam.getJSONObject(i).getString("runs");
                    String wickets = arrayTestTeam.getJSONObject(i).getString("wickets");
                    String economy = arrayTestTeam.getJSONObject(i).getString("economy");
                    String ground = "@" + arrayTestTeam.getJSONObject(i).getString("ground") + ", ";
                    String match_date = arrayTestTeam.getJSONObject(i).getString("match_date");
                    String last_updated_date = arrayTestTeam.getJSONObject(i).getString("updated_date");
                    //Toast.makeText(getActivity(),team+rank+matches+points,Toast.LENGTH_SHORT).show();
                    setValueInModelCallAdapterMostTon(unique,title, player, country, oppostition, overs,maidens,runs,
                            wickets,economy,ground,match_date, last_updated_date);
                }
            }

        }catch (JSONException e){
            Log.e("CricketRecordTest",e.toString());
        }
        CricketRecordsAdapter adapter = new CricketRecordsAdapter(getActivity(), list);
        record_recycler.setAdapter(adapter);
    }

    private void setValueInModelCallAdapterMostTon(int unique,String tit,String player,String country,String oppostition,String overs,
                                                         String maidens,String runs,String wickets,String economy,String ground,String match_date,String last_updated_date){

        CricketRecordsModel cm = new CricketRecordsModel();

        cm.setUnique(unique);                  cm.setTitle(tit);
        cm.setPlayer(player);                   cm.setHomeTeam(country);
        cm.setOppositionTeam(oppostition);      cm.setOvers(overs);
        cm.setMaidens(maidens);                 cm.setRuns(runs);
        cm.setWickets(wickets);                 cm.setEconomy(economy);
        cm.setVenue(ground);                    cm.setMatchDate(match_date);
        cm.setLastUpdatedDate(last_updated_date);
        list.add(cm);
    }

    private void setValuesMostHalfTon(String response){
        list = new ArrayList<CricketRecordsModel>();
        try {
            JSONObject json = new JSONObject(response);

            String[] jsonArray={"TestMatch","TestInnings","ODI","T20"};
            for(int j=0;j<4;j++) {
                JSONArray arrayTestTeam = json.getJSONArray(jsonArray[j]);
                //setValueInModelCallAdapter(j+1, jsonArray[j], "", "", "", "","","","","","","");
                for (int i = 0; i < arrayTestTeam.length(); i++) {
                    int unique=0;String title="";
                    if(i==0) {
                        unique = j + 1;
                        title=jsonArray[j];
                    }
                    String titleSet = title;
                    String player = arrayTestTeam.getJSONObject(i).getString("player_name");
                    String country = arrayTestTeam.getJSONObject(i).getString("country");
                    String oppostition = arrayTestTeam.getJSONObject(i).getString("oppostition");
                    String overs = arrayTestTeam.getJSONObject(i).getString("overs");
                    String maidens = arrayTestTeam.getJSONObject(i).getString("maidens");
                    String runs = arrayTestTeam.getJSONObject(i).getString("runs");
                    String wickets = arrayTestTeam.getJSONObject(i).getString("wickets");
                    String economy = arrayTestTeam.getJSONObject(i).getString("economy");
                    String ground = "@" + arrayTestTeam.getJSONObject(i).getString("ground") + ", ";
                    String match_date = arrayTestTeam.getJSONObject(i).getString("match_date");
                    String last_updated_date = arrayTestTeam.getJSONObject(i).getString("updated_date");
                    //Toast.makeText(getActivity(),team+rank+matches+points,Toast.LENGTH_SHORT).show();
                    setValueInModelCallAdapterMostHalfTon(unique,title, player, country, oppostition, overs,maidens,runs,
                            wickets,economy,ground,match_date, last_updated_date);
                }
            }

        }catch (JSONException e){
            Log.e("CricketRecordTest",e.toString());
        }
        CricketRecordsAdapter adapter = new CricketRecordsAdapter(getActivity(), list);
        record_recycler.setAdapter(adapter);
    }

    private void setValueInModelCallAdapterMostHalfTon(int unique,String tit,String player,String country,String oppostition,String overs,
                                                         String maidens,String runs,String wickets,String economy,String ground,String match_date,String last_updated_date){

        CricketRecordsModel cm = new CricketRecordsModel();

        cm.setUnique(unique);                  cm.setTitle(tit);
        cm.setPlayer(player);                   cm.setHomeTeam(country);
        cm.setOppositionTeam(oppostition);      cm.setOvers(overs);
        cm.setMaidens(maidens);                 cm.setRuns(runs);
        cm.setWickets(wickets);                 cm.setEconomy(economy);
        cm.setVenue(ground);                    cm.setMatchDate(match_date);
        cm.setLastUpdatedDate(last_updated_date);
        list.add(cm);
    }

    private void setValuesMostWckts(String response){
        list = new ArrayList<CricketRecordsModel>();
        try {
            JSONObject json = new JSONObject(response);

            String[] jsonArray={"TestMatch","TestInnings","ODI","T20"};
            for(int j=0;j<4;j++) {
                JSONArray arrayTestTeam = json.getJSONArray(jsonArray[j]);
                //setValueInModelCallAdapter(j+1, jsonArray[j], "", "", "", "","","","","","","");
                for (int i = 0; i < arrayTestTeam.length(); i++) {
                    int unique=0;String title="";
                    if(i==0) {
                        unique = j + 1;
                        title=jsonArray[j];
                    }
                    String titleSet = title;
                    String player = arrayTestTeam.getJSONObject(i).getString("player_name");
                    String country = arrayTestTeam.getJSONObject(i).getString("country");
                    String oppostition = arrayTestTeam.getJSONObject(i).getString("oppostition");
                    String overs = arrayTestTeam.getJSONObject(i).getString("overs");
                    String maidens = arrayTestTeam.getJSONObject(i).getString("maidens");
                    String runs = arrayTestTeam.getJSONObject(i).getString("runs");
                    String wickets = arrayTestTeam.getJSONObject(i).getString("wickets");
                    String economy = arrayTestTeam.getJSONObject(i).getString("economy");
                    String ground = "@" + arrayTestTeam.getJSONObject(i).getString("ground") + ", ";
                    String match_date = arrayTestTeam.getJSONObject(i).getString("match_date");
                    String last_updated_date = arrayTestTeam.getJSONObject(i).getString("updated_date");
                    //Toast.makeText(getActivity(),team+rank+matches+points,Toast.LENGTH_SHORT).show();
                    setValueInModelCallAdapterMostWckts(unique,title, player, country, oppostition, overs,maidens,runs,
                            wickets,economy,ground,match_date, last_updated_date);
                }
            }

        }catch (JSONException e){
            Log.e("CricketRecordTest",e.toString());
        }
        CricketRecordsAdapter adapter = new CricketRecordsAdapter(getActivity(), list);
        record_recycler.setAdapter(adapter);
    }

    private void setValueInModelCallAdapterMostWckts(int unique,String tit,String player,String country,String oppostition,String overs,
                                                         String maidens,String runs,String wickets,String economy,String ground,String match_date,String last_updated_date){

        CricketRecordsModel cm = new CricketRecordsModel();

        cm.setUnique(unique);                  cm.setTitle(tit);
        cm.setPlayer(player);                   cm.setHomeTeam(country);
        cm.setOppositionTeam(oppostition);      cm.setOvers(overs);
        cm.setMaidens(maidens);                 cm.setRuns(runs);
        cm.setWickets(wickets);                 cm.setEconomy(economy);
        cm.setVenue(ground);                    cm.setMatchDate(match_date);
        cm.setLastUpdatedDate(last_updated_date);
        list.add(cm);
    }
    private void setValuesBestBowlAvg(String response){
        list = new ArrayList<CricketRecordsModel>();
        try {
            JSONObject json = new JSONObject(response);

            String[] jsonArray={"TestMatch","TestInnings","ODI","T20"};
            for(int j=0;j<4;j++) {
                JSONArray arrayTestTeam = json.getJSONArray(jsonArray[j]);
                //setValueInModelCallAdapter(j+1, jsonArray[j], "", "", "", "","","","","","","");
                for (int i = 0; i < arrayTestTeam.length(); i++) {
                    int unique=0;String title="";
                    if(i==0) {
                        unique = j + 1;
                        title=jsonArray[j];
                    }
                    String titleSet = title;
                    String player = arrayTestTeam.getJSONObject(i).getString("player_name");
                    String country = arrayTestTeam.getJSONObject(i).getString("country");
                    String oppostition = arrayTestTeam.getJSONObject(i).getString("oppostition");
                    String overs = arrayTestTeam.getJSONObject(i).getString("overs");
                    String maidens = arrayTestTeam.getJSONObject(i).getString("maidens");
                    String runs = arrayTestTeam.getJSONObject(i).getString("runs");
                    String wickets = arrayTestTeam.getJSONObject(i).getString("wickets");
                    String economy = arrayTestTeam.getJSONObject(i).getString("economy");
                    String ground = "@" + arrayTestTeam.getJSONObject(i).getString("ground") + ", ";
                    String match_date = arrayTestTeam.getJSONObject(i).getString("match_date");
                    String last_updated_date = arrayTestTeam.getJSONObject(i).getString("updated_date");
                    //Toast.makeText(getActivity(),team+rank+matches+points,Toast.LENGTH_SHORT).show();
                    setValueInModelCallAdapterBestBowlAvg(unique,title, player, country, oppostition, overs,maidens,runs,
                            wickets,economy,ground,match_date, last_updated_date);
                }
            }

        }catch (JSONException e){
            Log.e("CricketRecordTest",e.toString());
        }
        CricketRecordsAdapter adapter = new CricketRecordsAdapter(getActivity(), list);
        record_recycler.setAdapter(adapter);
    }

    private void setValueInModelCallAdapterBestBowlAvg(int unique,String tit,String player,String country,String oppostition,String overs,
                                                         String maidens,String runs,String wickets,String economy,String ground,String match_date,String last_updated_date){

        CricketRecordsModel cm = new CricketRecordsModel();

        cm.setUnique(unique);                  cm.setTitle(tit);
        cm.setPlayer(player);                   cm.setHomeTeam(country);
        cm.setOppositionTeam(oppostition);      cm.setOvers(overs);
        cm.setMaidens(maidens);                 cm.setRuns(runs);
        cm.setWickets(wickets);                 cm.setEconomy(economy);
        cm.setVenue(ground);                    cm.setMatchDate(match_date);
        cm.setLastUpdatedDate(last_updated_date);
        list.add(cm);
    }

    private void setValuesWkDismissal(String response){
        list = new ArrayList<CricketRecordsModel>();
        try {
            JSONObject json = new JSONObject(response);

            String[] jsonArray={"TestMatch","TestInnings","ODI","T20"};
            for(int j=0;j<4;j++) {
                JSONArray arrayTestTeam = json.getJSONArray(jsonArray[j]);
                //setValueInModelCallAdapter(j+1, jsonArray[j], "", "", "", "","","","","","","");
                for (int i = 0; i < arrayTestTeam.length(); i++) {
                    int unique=0;String title="";
                    if(i==0) {
                        unique = j + 1;
                        title=jsonArray[j];
                    }
                    String titleSet = title;
                    String player = arrayTestTeam.getJSONObject(i).getString("player_name");
                    String country = arrayTestTeam.getJSONObject(i).getString("country");
                    String oppostition = arrayTestTeam.getJSONObject(i).getString("oppostition");
                    String overs = arrayTestTeam.getJSONObject(i).getString("overs");
                    String maidens = arrayTestTeam.getJSONObject(i).getString("maidens");
                    String runs = arrayTestTeam.getJSONObject(i).getString("runs");
                    String wickets = arrayTestTeam.getJSONObject(i).getString("wickets");
                    String economy = arrayTestTeam.getJSONObject(i).getString("economy");
                    String ground = "@" + arrayTestTeam.getJSONObject(i).getString("ground") + ", ";
                    String match_date = arrayTestTeam.getJSONObject(i).getString("match_date");
                    String last_updated_date = arrayTestTeam.getJSONObject(i).getString("updated_date");
                    //Toast.makeText(getActivity(),team+rank+matches+points,Toast.LENGTH_SHORT).show();
                    setValueInModelCallAdapterWkDismissal(unique,title, player, country, oppostition, overs,maidens,runs,
                            wickets,economy,ground,match_date, last_updated_date);
                }
            }

        }catch (JSONException e){
            Log.e("CricketRecordTest",e.toString());
        }
        CricketRecordsAdapter adapter = new CricketRecordsAdapter(getActivity(), list);
        record_recycler.setAdapter(adapter);
    }

    private void setValueInModelCallAdapterWkDismissal(int unique,String tit,String player,String country,String oppostition,String overs,
                                                         String maidens,String runs,String wickets,String economy,String ground,String match_date,String last_updated_date){

        CricketRecordsModel cm = new CricketRecordsModel();

        cm.setUnique(unique);                  cm.setTitle(tit);
        cm.setPlayer(player);                   cm.setHomeTeam(country);
        cm.setOppositionTeam(oppostition);      cm.setOvers(overs);
        cm.setMaidens(maidens);                 cm.setRuns(runs);
        cm.setWickets(wickets);                 cm.setEconomy(economy);
        cm.setVenue(ground);                    cm.setMatchDate(match_date);
        cm.setLastUpdatedDate(last_updated_date);
        list.add(cm);
    }

    private void setValuesHighPartnershp(String response){
        list = new ArrayList<CricketRecordsModel>();
        try {
            JSONObject json = new JSONObject(response);

            String[] jsonArray={"TestMatch","TestInnings","ODI","T20"};
            for(int j=0;j<4;j++) {
                JSONArray arrayTestTeam = json.getJSONArray(jsonArray[j]);
                //setValueInModelCallAdapter(j+1, jsonArray[j], "", "", "", "","","","","","","");
                for (int i = 0; i < arrayTestTeam.length(); i++) {
                    int unique=0;String title="";
                    if(i==0) {
                        unique = j + 1;
                        title=jsonArray[j];
                    }
                    String titleSet = title;
                    String player = arrayTestTeam.getJSONObject(i).getString("player_name");
                    String country = arrayTestTeam.getJSONObject(i).getString("country");
                    String oppostition = arrayTestTeam.getJSONObject(i).getString("oppostition");
                    String overs = arrayTestTeam.getJSONObject(i).getString("overs");
                    String maidens = arrayTestTeam.getJSONObject(i).getString("maidens");
                    String runs = arrayTestTeam.getJSONObject(i).getString("runs");
                    String wickets = arrayTestTeam.getJSONObject(i).getString("wickets");
                    String economy = arrayTestTeam.getJSONObject(i).getString("economy");
                    String ground = "@" + arrayTestTeam.getJSONObject(i).getString("ground") + ", ";
                    String match_date = arrayTestTeam.getJSONObject(i).getString("match_date");
                    String last_updated_date = arrayTestTeam.getJSONObject(i).getString("updated_date");
                    //Toast.makeText(getActivity(),team+rank+matches+points,Toast.LENGTH_SHORT).show();
                    setValueInModelCallAdapterHighPartnershp(unique,title, player, country, oppostition, overs,maidens,runs,
                            wickets,economy,ground,match_date, last_updated_date);
                }
            }

        }catch (JSONException e){
            Log.e("CricketRecordTest",e.toString());
        }
        CricketRecordsAdapter adapter = new CricketRecordsAdapter(getActivity(), list);
        record_recycler.setAdapter(adapter);
    }

    private void setValueInModelCallAdapterHighPartnershp(int unique,String tit,String player,String country,String oppostition,String overs,
                                                         String maidens,String runs,String wickets,String economy,String ground,String match_date,String last_updated_date){

        CricketRecordsModel cm = new CricketRecordsModel();

        cm.setUnique(unique);                  cm.setTitle(tit);
        cm.setPlayer(player);                   cm.setHomeTeam(country);
        cm.setOppositionTeam(oppostition);      cm.setOvers(overs);
        cm.setMaidens(maidens);                 cm.setRuns(runs);
        cm.setWickets(wickets);                 cm.setEconomy(economy);
        cm.setVenue(ground);                    cm.setMatchDate(match_date);
        cm.setLastUpdatedDate(last_updated_date);
        list.add(cm);
    }

    private void setValuesMostMatchCaptian(String response){
        list = new ArrayList<CricketRecordsModel>();
        try {
            JSONObject json = new JSONObject(response);

            String[] jsonArray={"TestMatch","TestInnings","ODI","T20"};
            for(int j=0;j<4;j++) {
                JSONArray arrayTestTeam = json.getJSONArray(jsonArray[j]);
                //setValueInModelCallAdapter(j+1, jsonArray[j], "", "", "", "","","","","","","");
                for (int i = 0; i < arrayTestTeam.length(); i++) {
                    int unique=0;String title="";
                    if(i==0) {
                        unique = j + 1;
                        title=jsonArray[j];
                    }
                    String titleSet = title;
                    String player = arrayTestTeam.getJSONObject(i).getString("player_name");
                    String country = arrayTestTeam.getJSONObject(i).getString("country");
                    String oppostition = arrayTestTeam.getJSONObject(i).getString("oppostition");
                    String overs = arrayTestTeam.getJSONObject(i).getString("overs");
                    String maidens = arrayTestTeam.getJSONObject(i).getString("maidens");
                    String runs = arrayTestTeam.getJSONObject(i).getString("runs");
                    String wickets = arrayTestTeam.getJSONObject(i).getString("wickets");
                    String economy = arrayTestTeam.getJSONObject(i).getString("economy");
                    String ground = "@" + arrayTestTeam.getJSONObject(i).getString("ground") + ", ";
                    String match_date = arrayTestTeam.getJSONObject(i).getString("match_date");
                    String last_updated_date = arrayTestTeam.getJSONObject(i).getString("updated_date");
                    //Toast.makeText(getActivity(),team+rank+matches+points,Toast.LENGTH_SHORT).show();
                    setValueInModelCallAdapterMostMatchCaptian(unique,title, player, country, oppostition, overs,maidens,runs,
                            wickets,economy,ground,match_date, last_updated_date);
                }
            }

        }catch (JSONException e){
            Log.e("CricketRecordTest",e.toString());
        }
        CricketRecordsAdapter adapter = new CricketRecordsAdapter(getActivity(), list);
        record_recycler.setAdapter(adapter);
    }

    private void setValueInModelCallAdapterMostMatchCaptian(int unique,String tit,String player,String country,String oppostition,String overs,
                                                         String maidens,String runs,String wickets,String economy,String ground,String match_date,String last_updated_date){

        CricketRecordsModel cm = new CricketRecordsModel();

        cm.setUnique(unique);                  cm.setTitle(tit);
        cm.setPlayer(player);                   cm.setHomeTeam(country);
        cm.setOppositionTeam(oppostition);      cm.setOvers(overs);
        cm.setMaidens(maidens);                 cm.setRuns(runs);
        cm.setWickets(wickets);                 cm.setEconomy(economy);
        cm.setVenue(ground);                    cm.setMatchDate(match_date);
        cm.setLastUpdatedDate(last_updated_date);
        list.add(cm);
    }




}
