package fragments;

/**
 * Created by INDP on 27-Jun-16.
 */
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
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import Constants.WebserviceLinks;
import abish.rulebooksportsgame.AppController;
import abish.rulebooksportsgame.R;
import abish.rulebooksportsgame.adapter.CricketTestAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CricketHistory.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CricketHistory#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CricketRecordsTest extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    View view;
    RecyclerView test_record_recycler;
//    TextView title1,title2,title3,title4,title5;
//    TextView text1, text2, text3, text4, text5, text6,text7, text8, text9, text10, text11, text12, text13, text14, text15, text16,text17, text18,
//            text19, text20, text21, text22, text23, text24,text25, text26, text27, text28, text29, text30, text31, text32, text33,
//            text34,text35, text36,text37, text38, text39, text40, text41, text42,text43, text44, text45, text46, text47,text48,text49,text50,text51,
//            text52, text53, text54, text55, text56,text57, text58,text59,text60,text61,text62,text63,text64,text65,text66,text67,text68,text69,text70,
//            text71;
//    TextView subtitletext1, subtitletext2, subtitletext3, subtitletext4, subtitletext5, subtitletext6,subtitletext7, subtitletext8,
//            subtitletext9,subtitletext10, subtitletext11, subtitletext12,subtitletext13, subtitletext14, subtitletext15, subtitletext16,
//            subtitletext17, subtitletext18,subtitletext19,subtitletext20,subtitletext21,subtitletext22,subtitletext23,subtitletext24,
//            subtitletext25,subtitletext26,subtitletext27,subtitletext28,subtitletext29;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public CricketRecordsTest() {
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
    public static CricketRecordsTest newInstance(String param1, String param2) {
        CricketRecordsTest fragment = new CricketRecordsTest();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.cricket_records_test, container, false);
        test_record_recycler = (RecyclerView) view.findViewById(R.id.test_record_recycler);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        test_record_recycler.setLayoutManager(mLayoutManager);
        test_record_recycler.setItemAnimator(new DefaultItemAnimator());
        GetResponseString("Test");

        setTextInAllViews();
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

    public void GetResponseString(String text){
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
                        List<String> list = new ArrayList<String>();
                        try {
                            JSONObject json = new JSONObject(response);
                        }catch (JSONException e){
                            Log.e("CricketRecordTest",e.toString());
                        }

                        CricketTestAdapter adapter = new CricketTestAdapter(getActivity(), list);
                        test_record_recycler.setAdapter(adapter);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // handle error response
                        pDialog.hide();
                        Snackbar snackbar = Snackbar
                                .make(view, "No internet connection!", Snackbar.LENGTH_LONG)
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

    private void initializeViews() {
//        title1 = (TextView) view.findViewById(R.id.title1);        title2 = (TextView) view.findViewById(R.id.title2);
//        title3 = (TextView) view.findViewById(R.id.title3);         title4 = (TextView) view.findViewById(R.id.title4);
//        title5 = (TextView) view.findViewById(R.id.title5);
//
//        text1 = (TextView) view.findViewById(R.id.text1);        text2 = (TextView) view.findViewById(R.id.text2);
//        text3 = (TextView) view.findViewById(R.id.text3);        text4 = (TextView) view.findViewById(R.id.text4);
//        text5 = (TextView) view.findViewById(R.id.text5);        text6 = (TextView) view.findViewById(R.id.text6);
//        text7 = (TextView) view.findViewById(R.id.text7);        text8 = (TextView) view.findViewById(R.id.text8);
//        text9 = (TextView) view.findViewById(R.id.text9);        text10 = (TextView) view.findViewById(R.id.text10);
//        text11 = (TextView) view.findViewById(R.id.text11);        text12 = (TextView) view.findViewById(R.id.text12);
//        text13 = (TextView) view.findViewById(R.id.text13);        text14 = (TextView) view.findViewById(R.id.text14);
//        text15 = (TextView) view.findViewById(R.id.text15);        text16 = (TextView) view.findViewById(R.id.text16);
//        text17 = (TextView) view.findViewById(R.id.text17);        text18 = (TextView) view.findViewById(R.id.text18);
//        text19 = (TextView) view.findViewById(R.id.text19);        text20 = (TextView) view.findViewById(R.id.text20);
//        text21 = (TextView) view.findViewById(R.id.text21);        text22 = (TextView) view.findViewById(R.id.text22);
//        text23 = (TextView) view.findViewById(R.id.text23);         text24 = (TextView) view.findViewById(R.id.text24);
//        text25 = (TextView) view.findViewById(R.id.text25);         text26 = (TextView) view.findViewById(R.id.text26);
//        text27 = (TextView) view.findViewById(R.id.text27);          text28 = (TextView) view.findViewById(R.id.text28);
//        text29 = (TextView) view.findViewById(R.id.text29);         text30 = (TextView) view.findViewById(R.id.text30);
//        text31 = (TextView) view.findViewById(R.id.text31);         text32 = (TextView) view.findViewById(R.id.text32);
//        text33 = (TextView) view.findViewById(R.id.text33);         text34 = (TextView) view.findViewById(R.id.text34);
//        text35 = (TextView) view.findViewById(R.id.text35);         text36 = (TextView) view.findViewById(R.id.text36);
//        text37 = (TextView) view.findViewById(R.id.text37);         text38 = (TextView) view.findViewById(R.id.text38);
//        text39 = (TextView) view.findViewById(R.id.text39);         text40 = (TextView) view.findViewById(R.id.text40);
//        text41 = (TextView) view.findViewById(R.id.text41);         text42 = (TextView) view.findViewById(R.id.text42);
//        text43 = (TextView) view.findViewById(R.id.text43);         text44 = (TextView) view.findViewById(R.id.text44);
//        text45 = (TextView) view.findViewById(R.id.text45);         text46 = (TextView) view.findViewById(R.id.text46);
//        text47 = (TextView) view.findViewById(R.id.text47);         text48 = (TextView) view.findViewById(R.id.text48);
//        text49 = (TextView) view.findViewById(R.id.text49);         text50 = (TextView) view.findViewById(R.id.text50);
//        text51 = (TextView) view.findViewById(R.id.text51);         text52 = (TextView) view.findViewById(R.id.text52);
//        text53 = (TextView) view.findViewById(R.id.text53);         text54 = (TextView) view.findViewById(R.id.text54);
//        text55 = (TextView) view.findViewById(R.id.text55);         text56 = (TextView) view.findViewById(R.id.text56);
//        text57 = (TextView) view.findViewById(R.id.text57);         text58 = (TextView) view.findViewById(R.id.text58);
//        text59 = (TextView) view.findViewById(R.id.text59);         text60 = (TextView) view.findViewById(R.id.text60);
//        text61 = (TextView) view.findViewById(R.id.text61);         text62 = (TextView) view.findViewById(R.id.text62);
//        text63 = (TextView) view.findViewById(R.id.text63);         text64 = (TextView) view.findViewById(R.id.text64);
//        text65 = (TextView) view.findViewById(R.id.text65);         text66 = (TextView) view.findViewById(R.id.text66);
//        text67 = (TextView) view.findViewById(R.id.text67);         text68 = (TextView) view.findViewById(R.id.text68);
//        text69 = (TextView) view.findViewById(R.id.text69);         text70 = (TextView) view.findViewById(R.id.text70);
//                text71 = (TextView) view.findViewById(R.id.text71);
//
//        subtitletext1 = (TextView) view.findViewById(R.id.subtitletext1);        subtitletext2 = (TextView) view.findViewById(R.id.subtitletext2);
//        subtitletext3 = (TextView) view.findViewById(R.id.subtitletext3);        subtitletext4 = (TextView) view.findViewById(R.id.subtitletext4);
//        subtitletext5 = (TextView) view.findViewById(R.id.subtitletext5);        subtitletext6 = (TextView) view.findViewById(R.id.subtitletext6);
//        subtitletext7 = (TextView) view.findViewById(R.id.subtitletext7);        subtitletext8 = (TextView) view.findViewById(R.id.subtitletext8);
//        subtitletext9 = (TextView) view.findViewById(R.id.subtitletext9);        subtitletext10 = (TextView) view.findViewById(R.id.subtitletext10);
//        subtitletext11 = (TextView) view.findViewById(R.id.subtitletext11);        subtitletext12 = (TextView) view.findViewById(R.id.subtitletext12);
//        subtitletext13 = (TextView) view.findViewById(R.id.subtitletext13);        subtitletext14 = (TextView) view.findViewById(R.id.subtitletext14);
//        subtitletext15 = (TextView) view.findViewById(R.id.subtitletext15);        subtitletext16 = (TextView) view.findViewById(R.id.subtitletext16);
//        subtitletext17 = (TextView) view.findViewById(R.id.subtitletext17);        subtitletext18 = (TextView) view.findViewById(R.id.subtitletext18);
//        subtitletext19 = (TextView) view.findViewById(R.id.subtitletext19);        subtitletext20 = (TextView) view.findViewById(R.id.subtitletext20);
//        subtitletext21 = (TextView) view.findViewById(R.id.subtitletext21);        subtitletext22 = (TextView) view.findViewById(R.id.subtitletext22);
//        subtitletext23 = (TextView) view.findViewById(R.id.subtitletext23);        subtitletext24 = (TextView) view.findViewById(R.id.subtitletext24);
//        subtitletext25 = (TextView) view.findViewById(R.id.subtitletext25);        subtitletext26 = (TextView) view.findViewById(R.id.subtitletext26);
//        subtitletext27 = (TextView) view.findViewById(R.id.subtitletext27);         subtitletext28 = (TextView) view.findViewById(R.id.subtitletext28);
//        subtitletext29 = (TextView) view.findViewById(R.id.subtitletext29);

    }

    public void setTextInAllViews() {
//        title1.setText(ConstantCricket.records_test_subtitle[0]);        title2.setText(ConstantCricket.records_test_subtitle[1]);
//        title3.setText(ConstantCricket.records_test_subtitle[2]);       title4.setText(ConstantCricket.records_test_subtitle[3]);
//        title5.setText(ConstantCricket.records_test_subtitle[4]);
//
//        subtitletext1.setText(ConstantCricket.records_test_title1[0]);        subtitletext2.setText(ConstantCricket.records_test_title1[1]);
//        subtitletext3.setText(ConstantCricket.records_test_title1[2]);        subtitletext4.setText(ConstantCricket.records_test_title1[3]);
//        subtitletext5.setText(ConstantCricket.records_test_title1[4]);        subtitletext6.setText(ConstantCricket.records_test_title2[0]);
//        subtitletext7.setText(ConstantCricket.records_test_title2[1]);        subtitletext8.setText(ConstantCricket.records_test_title2[2]);
//        subtitletext9.setText(ConstantCricket.records_test_title2[3]);        subtitletext10.setText(ConstantCricket.records_test_title3[0]);
//        subtitletext11.setText(ConstantCricket.records_test_title3[1]);        subtitletext12.setText(ConstantCricket.records_test_title3[2]);
//        subtitletext13.setText(ConstantCricket.records_test_title3[3]);        subtitletext14.setText(ConstantCricket.records_test_title4[0]);
//        subtitletext15.setText(ConstantCricket.records_test_title4[1]);        subtitletext16.setText(ConstantCricket.records_test_title4[2]);
//        subtitletext17.setText(ConstantCricket.records_test_title4[3]);        subtitletext18.setText(ConstantCricket.records_test_title4[4]);
//        subtitletext19.setText(ConstantCricket.records_test_title4[5]);        subtitletext20.setText(ConstantCricket.records_test_title4[6]);
//        subtitletext21.setText(ConstantCricket.records_test_title4[7]);        subtitletext22.setText(ConstantCricket.records_test_title5[0]);
//        subtitletext23.setText(ConstantCricket.records_test_title5[1]);        subtitletext24.setText(ConstantCricket.records_test_title5[2]);
//        subtitletext25.setText(ConstantCricket.records_test_title5[3]);        subtitletext26.setText(ConstantCricket.records_test_title5[4]);
//        subtitletext27.setText(ConstantCricket.records_test_title5[5]);        subtitletext28.setText(ConstantCricket.records_test_title5[6]);
//        subtitletext29.setText(ConstantCricket.records_test_title5[7]);
//
//        text1.setText(ConstantCricket.records_test_value1[0]);        text2.setText(ConstantCricket.records_test_value1[1]);
//        text3.setText(ConstantCricket.records_test_value1[2]);        text4.setText(ConstantCricket.records_test_value1[3]);
//        text5.setText(ConstantCricket.records_test_value1[4]);        text6.setText(ConstantCricket.records_test_value1[5]);
//        text7.setText(ConstantCricket.records_test_value1[6]);        text8.setText(ConstantCricket.records_test_value1[7]);
//        text9.setText(ConstantCricket.records_test_value1[8]);        text10.setText(ConstantCricket.records_test_value1[9]);
//        text11.setText(ConstantCricket.records_test_value1[10]);        text12.setText(ConstantCricket.records_test_value1[11]);
//        text13.setText(ConstantCricket.records_test_value1[12]);        text14.setText(ConstantCricket.records_test_value1[13]);
//        text15.setText(ConstantCricket.records_test_value1[14]);        text16.setText(ConstantCricket.records_test_value2[0]);
//        text17.setText(ConstantCricket.records_test_value2[1]);        text18.setText(ConstantCricket.records_test_value2[2]);
//        text19.setText(ConstantCricket.records_test_value2[3]);     text20.setText(ConstantCricket.records_test_value3[0]);
//        text21.setText(ConstantCricket.records_test_value3[1]);      text22.setText(ConstantCricket.records_test_value3[2]);
//        text23.setText(ConstantCricket.records_test_value3[3]);     text24.setText(ConstantCricket.records_test_value4[0]);
//        text25.setText(ConstantCricket.records_test_value4[1]);     text26.setText(ConstantCricket.records_test_value4[2]);
//        text27.setText(ConstantCricket.records_test_value4[3]);     text28.setText(ConstantCricket.records_test_value4[4]);
//        text29.setText(ConstantCricket.records_test_value4[5]);     text30.setText(ConstantCricket.records_test_value4[6]);
//        text31.setText(ConstantCricket.records_test_value4[7]);     text32.setText(ConstantCricket.records_test_value4[8]);
//        text33.setText(ConstantCricket.records_test_value4[9]);     text34.setText(ConstantCricket.records_test_value4[10]);
//        text35.setText(ConstantCricket.records_test_value4[11]);     text36.setText(ConstantCricket.records_test_value4[12]);
//        text37.setText(ConstantCricket.records_test_value4[13]);     text38.setText(ConstantCricket.records_test_value4[14]);
//        text39.setText(ConstantCricket.records_test_value4[15]);     text40.setText(ConstantCricket.records_test_value4[16]);
//        text41.setText(ConstantCricket.records_test_value4[17]);      text42.setText(ConstantCricket.records_test_value4[18]);
//        text43.setText(ConstantCricket.records_test_value4[19]);      text44.setText(ConstantCricket.records_test_value4[20]);
//        text45.setText(ConstantCricket.records_test_value4[21]);      text46.setText(ConstantCricket.records_test_value4[22]);
//        text47.setText(ConstantCricket.records_test_value4[23]);     text48.setText(ConstantCricket.records_test_value5[0]);
//        text49.setText(ConstantCricket.records_test_value5[1]);     text50.setText(ConstantCricket.records_test_value5[2]);
//        text51.setText(ConstantCricket.records_test_value5[3]);     text52.setText(ConstantCricket.records_test_value5[4]);
//        text53.setText(ConstantCricket.records_test_value5[5]);     text54.setText(ConstantCricket.records_test_value5[6]);
//        text55.setText(ConstantCricket.records_test_value5[7]);     text56.setText(ConstantCricket.records_test_value5[8]);
//        text57.setText(ConstantCricket.records_test_value5[9]);     text58.setText(ConstantCricket.records_test_value5[10]);
//        text59.setText(ConstantCricket.records_test_value5[11]);     text60.setText(ConstantCricket.records_test_value5[12]);
//        text61.setText(ConstantCricket.records_test_value5[13]);     text62.setText(ConstantCricket.records_test_value5[14]);
//        text63.setText(ConstantCricket.records_test_value5[15]);     text64.setText(ConstantCricket.records_test_value5[16]);
//        text65.setText(ConstantCricket.records_test_value5[17]);     text66.setText(ConstantCricket.records_test_value5[18]);
//        text67.setText(ConstantCricket.records_test_value5[19]);     text68.setText(ConstantCricket.records_test_value5[20]);
//        text69.setText(ConstantCricket.records_test_value5[21]);     text70.setText(ConstantCricket.records_test_value5[22]);
//                text71.setText(ConstantCricket.records_test_value5[23]);


    }
}
