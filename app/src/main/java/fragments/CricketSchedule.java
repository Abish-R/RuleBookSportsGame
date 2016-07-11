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

import Constants.WebserviceLinks;
import abish.rulebooksportsgame.AppController;
import abish.rulebooksportsgame.Models.CricketScheduleModel;
import abish.rulebooksportsgame.R;
import abish.rulebooksportsgame.adapter.CricketScheduleAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CricketSchedule.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CricketSchedule#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CricketSchedule extends Fragment {
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
    RecyclerView record_recycler;
    String calledfrom;
    List<CricketScheduleModel> list;
    CricketScheduleAdapter adapter;

    private OnFragmentInteractionListener mListener;

    public CricketSchedule() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CricketHistory.
     */
    // TODO: Rename and change types and number of parameters
    public static CricketSchedule newInstance(String param1, String param2) {
        CricketSchedule fragment = new CricketSchedule();
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
        record_recycler = (RecyclerView) view.findViewById(R.id.record_recycler);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        record_recycler.setLayoutManager(mLayoutManager);
        record_recycler.setItemAnimator(new DefaultItemAnimator());
        GetResponseString();

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

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void GetResponseString(){
        // Tag used to cancel the request
        final String tag_json_obj = "string_req_schedule";

        String url = WebserviceLinks.cricketSchedule;

        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.show();

        StringRequest req = new StringRequest(Request.Method.GET,
                url,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        pDialog.hide();
                        setValuesInList(response);
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
                                        GetResponseString();
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

    private void setValuesInList(String response){
        try {
            list = new ArrayList<CricketScheduleModel>();
            adapter = new CricketScheduleAdapter(getActivity(), list);
            record_recycler.setAdapter(adapter);

            JSONObject json = new JSONObject(response);
            JSONArray arrayTestTeam = json.getJSONArray("Match-Fixtures");
            for (int i=0; i<arrayTestTeam.length();i++){
                String series_name,home_team,opposition_team,match_description,match_date,venue,latitude,
                        longitude,broadcasting_channel,local_time,gmt_time,ist_time,game_format,gender,last_updated_date;
                series_name = arrayTestTeam.getJSONObject(i).getString("series_name");
                home_team = arrayTestTeam.getJSONObject(i).getString("home_team");
                opposition_team = arrayTestTeam.getJSONObject(i).getString("opposition_team");
                match_description = arrayTestTeam.getJSONObject(i).getString("match_description");
                match_date = arrayTestTeam.getJSONObject(i).getString("match_date");
                venue = arrayTestTeam.getJSONObject(i).getString("venue");
                latitude = arrayTestTeam.getJSONObject(i).getString("latitude");
                longitude = arrayTestTeam.getJSONObject(i).getString("longitude");
                broadcasting_channel = arrayTestTeam.getJSONObject(i).getString("broadcasting_channel");
                local_time = arrayTestTeam.getJSONObject(i).getString("local_time");
                gmt_time = arrayTestTeam.getJSONObject(i).getString("gmt_time");
                ist_time = arrayTestTeam.getJSONObject(i).getString("ist_time");
                game_format = arrayTestTeam.getJSONObject(i).getString("game_format");
                gender = arrayTestTeam.getJSONObject(i).getString("gender");
                last_updated_date = arrayTestTeam.getJSONObject(i).getString("last_updated_date");

                setValueInModelCallAdapter(series_name,home_team,opposition_team,match_description,match_date,venue,latitude,
                        longitude,broadcasting_channel,local_time,gmt_time,ist_time,game_format,gender,last_updated_date);
            }
        }catch (JSONException e){
            Log.e("CricketSchedule",e.toString());
        }

//        if(text.equals("Test")) {
////            CricketTestAdapter adapter = new CricketTestAdapter(getActivity(), list);
////            record_recycler.setAdapter(adapter);
//        }else if(text.equals("ODI")){
//
//        }else if(text.equals("T20")){
//
//        }else if(text.equals("Players")){
//
//        }
    }

    private void setValueInModelCallAdapter(String series_name,String home_team,String opposition_team,String match_description,String match_date,
                                            String venue,String latitude,String longitude,String broadcasting_channel,String local_time,
                                            String gmt_time,String ist_time,String game_format,String gender,String last_updated_date){

        CricketScheduleModel cm = new CricketScheduleModel();
        cm.setSeriesName(series_name);
        cm.setHomeTeam(home_team);
        cm.setOppositionTeam(opposition_team);
        cm.setMatchDescription(match_description);
        cm.setMatchDate(match_date);
        cm.setVenue(venue);
        cm.setLatitude(latitude);
        cm.setLongitude(longitude);
        cm.setBroadcastingChannel(broadcasting_channel);
        //cm.setLocalTime(local_time);
        cm.setGmtTime(gmt_time);
        cm.setIstTime(ist_time);
        cm.setGameFormat(game_format);
        //cm.setGender(gender);
        //cm.setLastUpdatedDate(last_updated_date);
        list.add(cm);

        adapter.notifyDataSetChanged();
    }
}
