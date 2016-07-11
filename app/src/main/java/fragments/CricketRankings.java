package fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import Constants.WebserviceLinks;
import abish.rulebooksportsgame.AppController;
import abish.rulebooksportsgame.Models.CricketRankingModel;
import abish.rulebooksportsgame.R;
import abish.rulebooksportsgame.adapter.CricketRankingAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CricketRankings.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CricketRankings#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CricketRankings extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //FragmentTabHost mTabHost;
    View view;
    Context context;
    RecyclerView record_recycler;
    String calledfrom;
    List<CricketRankingModel> list;
    Button test,odi,t20,women;
    int lastPressed=1,nowPressed=0;


    private OnFragmentInteractionListener mListener;

    public CricketRankings() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static CricketRankings newInstance(String param1, String param2) {
        CricketRankings fragment = new CricketRankings();
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
        view = inflater.inflate(R.layout.cricket_tabranking, container, false);
        initializeViews();

//        LinearLayoutManager layoutManager
//                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());//,LinearLayoutManager.HORIZONTAL, false
        record_recycler.setLayoutManager(mLayoutManager);
        record_recycler.setItemAnimator(new DefaultItemAnimator());
        test.setBackgroundColor(getResources().getColor(R.color.white));
        GetResponseString("Test");
        //mTabHost = (FragmentTabHost) view.findViewById(android.R.id.tabhost);
        //mTabHost.setup(getActivity(), getChildFragmentManager(), android.R.id.tabcontent);

//        Bundle b = new Bundle();
//        b.putString("invoked","Test");
//        Bundle b1 = new Bundle();
//        b1.putString("invoked","ODI");
//        Bundle b2 = new Bundle();
//        b2.putString("invoked","T20");
//        Bundle b3 = new Bundle();
//        b3.putString("invoked","Players");
//
//        mTabHost.addTab(mTabHost.newTabSpec("tab1").setIndicator("Test", null), CricketRecordsAdapterDecider.class, b);
//        mTabHost.addTab(mTabHost.newTabSpec("tab2").setIndicator("ODI", null),CricketRecordsAdapterDecider.class, b1);
//        mTabHost.addTab(mTabHost.newTabSpec("tab3").setIndicator("T20", null), CricketRecordsAdapterDecider.class, b2);
//        mTabHost.addTab(mTabHost.newTabSpec("tab4").setIndicator("Players", null), CricketRecordsAdapterDecider.class, b3);
//        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
//            @Override
//            public void onTabChanged(String tabId) {
//                if(tabId.equals("tab1"))
//                    Toast.makeText(context,"Tab 1",Toast.LENGTH_LONG).show();
//                else if(tabId.equals("tab2"))
//                    Toast.makeText(context,"Tab 2",Toast.LENGTH_LONG).show();
//            }
//        });
        return view;
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void initializeViews(){
        test=(Button)view.findViewById(R.id.test);
        odi=(Button)view.findViewById(R.id.odi);
        t20=(Button)view.findViewById(R.id.t20);
        women=(Button)view.findViewById(R.id.women);
        record_recycler = (RecyclerView) view.findViewById(R.id.record_recycler);
        test.setOnClickListener(this);
        odi.setOnClickListener(this);
        t20.setOnClickListener(this);
        women.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.test:
                changeButtonColor(1);
                break;
            case R.id.odi:
                changeButtonColor(2);
                break;
            case R.id.t20:
                changeButtonColor(3);
                break;
            case R.id.women:
                changeButtonColor(4);
                break;
        }
    }

    private void changeButtonColor(int code){
        if(lastPressed==code)
            Toast.makeText(context,"You are here",Toast.LENGTH_LONG).show();
        else{
            if(code==1) {
                changeNormalColor(code);
                test.setBackgroundColor(getResources().getColor(R.color.white));
                GetResponseString("Test");
            }
            else if(code==2) {
                changeNormalColor(code);
                odi.setBackgroundColor(getResources().getColor(R.color.white));
                GetResponseString("ODI");
            }
            else if(code==3) {
                changeNormalColor(code);
                t20.setBackgroundColor(getResources().getColor(R.color.white));
                GetResponseString("T20");
            }
            else if(code==4) {
                changeNormalColor(code);
                women.setBackgroundColor(getResources().getColor(R.color.white));
                GetResponseString("All");
            }
        }
    }

    private void changeNormalColor(int code){
        if(lastPressed==1)
            test.setBackgroundColor(getResources().getColor(R.color.grey_light1));
        else if(lastPressed==2)
            odi.setBackgroundColor(getResources().getColor(R.color.grey_light1));
        else if(lastPressed==3)
            t20.setBackgroundColor(getResources().getColor(R.color.grey_light1));
        else if(lastPressed==4)
            women.setBackgroundColor(getResources().getColor(R.color.grey_light1));
        lastPressed=code;
    }

    public void GetResponseString(final String text){
        // Tag used to cancel the request
        final String tag_json_obj = "string_req";

        String url = WebserviceLinks.cricketRanking+text;

        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.show();

        StringRequest req = new StringRequest(Request.Method.GET,
                url,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        pDialog.hide();
                        setValuesInList(response,text);
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
                                        GetResponseString("Test");
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

    private void setValuesInList(String response, String text){
        list = new ArrayList<CricketRankingModel>();
        try {
            JSONObject json = new JSONObject(response);
            JSONArray arrayTestTeam = json.getJSONArray("Team-Ranking");
            setValueInModelCallAdapter(1,"Team","Rank","Matches","Points","Date");
            for (int i=0; i<arrayTestTeam.length();i++){
                int unique = 0;
                String team = arrayTestTeam.getJSONObject(i).getString("team");
                String rank = arrayTestTeam.getJSONObject(i).getString("rank");
                String matches = arrayTestTeam.getJSONObject(i).getString("matches");
                String points = arrayTestTeam.getJSONObject(i).getString("points");
                String last_updated_date = arrayTestTeam.getJSONObject(i).getString("last_updated_date");
                //Toast.makeText(getActivity(),team+rank+matches+points,Toast.LENGTH_SHORT).show();
                setValueInModelCallAdapter(unique,team,rank,matches,points,last_updated_date);
            }

            JSONArray arrayTestBatting = json.getJSONArray("Batting-Ranking");
            setValueInModelCallAdapter(2,"Player","Rank","Nation","Rating","Date");
            for (int i=0; i<arrayTestBatting.length();i++){
                int unique = 0;
                String team = arrayTestBatting.getJSONObject(i).getString("player_name");
                String rank = arrayTestBatting.getJSONObject(i).getString("rank");
                String matches = arrayTestBatting.getJSONObject(i).getString("country");
                String points = arrayTestBatting.getJSONObject(i).getString("rating");
                String last_updated_date = arrayTestBatting.getJSONObject(i).getString("last_updated_date");
                //Toast.makeText(getActivity(),team+rank+matches+points,Toast.LENGTH_SHORT).show();
                setValueInModelCallAdapter(unique,team,rank,matches,points,last_updated_date);
            }
            JSONArray arrayTestBowling = json.getJSONArray("Bowling-Ranking");
            setValueInModelCallAdapter(3,"Player","Rank","Nation","Rating","Date");
            for (int i=0; i<arrayTestBowling.length();i++){
                int unique = 0;
                String team = arrayTestBowling.getJSONObject(i).getString("player_name");
                String rank = arrayTestBowling.getJSONObject(i).getString("rank");
                String matches = arrayTestBowling.getJSONObject(i).getString("country");
                String points = arrayTestBowling.getJSONObject(i).getString("rating");
                String last_updated_date = arrayTestBowling.getJSONObject(i).getString("last_updated_date");
                //Toast.makeText(getActivity(),team+rank+matches+points,Toast.LENGTH_SHORT).show();
                setValueInModelCallAdapter(unique,team,rank,matches,points,last_updated_date);

            }
        }catch (JSONException e){
            Log.e("CricketRecordTest",e.toString());
        }
        CricketRankingAdapter adapter = new CricketRankingAdapter(getActivity(), list);
        record_recycler.setAdapter(adapter);

        if(text.equals("Test")) {
//            CricketTestAdapter adapter = new CricketTestAdapter(getActivity(), list);
//            record_recycler.setAdapter(adapter);
        }else if(text.equals("ODI")){

        }else if(text.equals("T20")){

        }else if(text.equals("Players")){

        }
    }

    private void setValueInModelCallAdapter(int unique,String team, String rank, String matches, String points, String last_updated_date){
        CricketRankingModel cm = new CricketRankingModel();
        cm.setUnique(unique);
        cm.setTeam(team);
        cm.setRank(rank);
        cm.setMatches(matches);
        cm.setPoints(points);
        cm.setLastUpdatedDate(last_updated_date);
        list.add(cm);
    }
}
