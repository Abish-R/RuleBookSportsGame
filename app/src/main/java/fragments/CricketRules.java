package fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import Constants.ConstantCricket;
import abish.rulebooksportsgame.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CricketRules.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CricketRules#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CricketRules extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    View view;
    TextView subtitletext1,subtitletext2,subtitletext3,subtitletext4,subtitletext5,subtitletext6,subtitletext7,subtitletext8,subtitletext9,
            subtitletext10,subtitletext11,subtitletext12,subtitletext13,subtitletext14,subtitletext15,subtitletext16,subtitletext17,subtitletext18,
            subtitletext20,subtitletext21,subtitletext22,subtitletext23,subtitletext24,subtitletext25,subtitletext26,subtitletext27,subtitletext28,
            subtitletext29,subtitletext30,subtitletext31,subtitletext32,subtitletext33,subtitletext34,subtitletext35,subtitletext36,subtitletext37,
            subtitletext38,subtitletext39,subtitletext40,subtitletext41,subtitletext19;
    TextView text2,text3,text4,text5,text6,text7,text8,text9,text10,text11,text12,text13,text14,text15,text16,text17,text18,text19,text20,
            text21,text22,text23,text24,text25,text26,text27,text28,text29,text30,text31,text32,text33,text34,text35,text36,text37,text38,
            text39,text40,text41,text42;

    private OnFragmentInteractionListener mListener;

    public CricketRules() {
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
    public static CricketRules newInstance(String param1, String param2) {
        CricketRules fragment = new CricketRules();
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
        view = inflater.inflate(R.layout.cricket_tabrules, container, false);
        initializeViews();
        settextInAllViews();
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
        subtitletext1=(TextView) view.findViewById(R.id.subtitletext1);subtitletext2=(TextView) view.findViewById(R.id.subtitletext2);
        subtitletext3=(TextView) view.findViewById(R.id.subtitletext3);subtitletext4=(TextView) view.findViewById(R.id.subtitletext4);
        subtitletext5=(TextView) view.findViewById(R.id.subtitletext5);subtitletext6=(TextView) view.findViewById(R.id.subtitletext6);
        subtitletext7=(TextView) view.findViewById(R.id.subtitletext7);subtitletext8=(TextView) view.findViewById(R.id.subtitletext8);
        subtitletext9=(TextView) view.findViewById(R.id.subtitletext9);subtitletext10=(TextView) view.findViewById(R.id.subtitletext10);
        subtitletext11=(TextView) view.findViewById(R.id.subtitletext11);subtitletext12=(TextView) view.findViewById(R.id.subtitletext12);
        subtitletext13=(TextView) view.findViewById(R.id.subtitletext13);subtitletext14=(TextView) view.findViewById(R.id.subtitletext14);
        subtitletext15=(TextView) view.findViewById(R.id.subtitletext15);subtitletext16=(TextView) view.findViewById(R.id.subtitletext16);
        subtitletext17=(TextView) view.findViewById(R.id.subtitletext17);subtitletext18=(TextView) view.findViewById(R.id.subtitletext18);
        subtitletext20=(TextView) view.findViewById(R.id.subtitletext20);subtitletext21=(TextView) view.findViewById(R.id.subtitletext21);
        subtitletext22=(TextView) view.findViewById(R.id.subtitletext22);subtitletext23=(TextView) view.findViewById(R.id.subtitletext23);
        subtitletext24=(TextView) view.findViewById(R.id.subtitletext24);subtitletext25=(TextView) view.findViewById(R.id.subtitletext25);
        subtitletext26=(TextView) view.findViewById(R.id.subtitletext26);subtitletext27=(TextView) view.findViewById(R.id.subtitletext27);
        subtitletext28=(TextView) view.findViewById(R.id.subtitletext28);subtitletext29=(TextView) view.findViewById(R.id.subtitletext29);
        subtitletext30=(TextView) view.findViewById(R.id.subtitletext30);subtitletext31=(TextView) view.findViewById(R.id.subtitletext31);
        subtitletext32=(TextView) view.findViewById(R.id.subtitletext32);subtitletext33=(TextView) view.findViewById(R.id.subtitletext33);
        subtitletext34=(TextView) view.findViewById(R.id.subtitletext34);subtitletext35=(TextView) view.findViewById(R.id.subtitletext35);
        subtitletext36=(TextView) view.findViewById(R.id.subtitletext36);subtitletext37=(TextView) view.findViewById(R.id.subtitletext37);
        subtitletext38=(TextView) view.findViewById(R.id.subtitletext38);subtitletext39=(TextView) view.findViewById(R.id.subtitletext39);
        subtitletext40=(TextView) view.findViewById(R.id.subtitletext40);subtitletext41=(TextView) view.findViewById(R.id.subtitletext41);
        subtitletext19=(TextView) view.findViewById(R.id.subtitletext19);
        text2=(TextView) view.findViewById(R.id.text2);text3=(TextView) view.findViewById(R.id.text3);
        text4=(TextView) view.findViewById(R.id.text4);text5=(TextView) view.findViewById(R.id.text5);
        text6=(TextView) view.findViewById(R.id.text6);text7=(TextView) view.findViewById(R.id.text7);
        text8=(TextView) view.findViewById(R.id.text8);text9=(TextView) view.findViewById(R.id.text9);
        text10=(TextView) view.findViewById(R.id.text10);text11=(TextView) view.findViewById(R.id.text11);
        text12=(TextView) view.findViewById(R.id.text12);text13=(TextView) view.findViewById(R.id.text13);
        text14=(TextView) view.findViewById(R.id.text14);text15=(TextView) view.findViewById(R.id.text15);
        text16=(TextView) view.findViewById(R.id.text16);text17=(TextView) view.findViewById(R.id.text17);
        text18=(TextView) view.findViewById(R.id.text18);text19=(TextView) view.findViewById(R.id.text19);
        text20=(TextView) view.findViewById(R.id.text20);text21=(TextView) view.findViewById(R.id.text21);
        text22=(TextView) view.findViewById(R.id.text22);text23=(TextView) view.findViewById(R.id.text23);
        text24=(TextView) view.findViewById(R.id.text24);text25=(TextView) view.findViewById(R.id.text25);
        text26=(TextView) view.findViewById(R.id.text26);text27=(TextView) view.findViewById(R.id.text27);
        text28=(TextView) view.findViewById(R.id.text28);text29=(TextView) view.findViewById(R.id.text29);
        text30=(TextView) view.findViewById(R.id.text30);text31=(TextView) view.findViewById(R.id.text31);
        text32=(TextView) view.findViewById(R.id.text32);text33=(TextView) view.findViewById(R.id.text33);
        text34=(TextView) view.findViewById(R.id.text34);text35=(TextView) view.findViewById(R.id.text35);
        text36=(TextView) view.findViewById(R.id.text36);text37=(TextView) view.findViewById(R.id.text37);
        text38=(TextView) view.findViewById(R.id.text38);text39=(TextView) view.findViewById(R.id.text39);
        text40=(TextView) view.findViewById(R.id.text40);text41=(TextView) view.findViewById(R.id.text41);
        text42=(TextView) view.findViewById(R.id.text42);
    }
    private void settextInAllViews(){
        subtitletext1.setText(ConstantCricket.rule_subtitle[0]);subtitletext2.setText(ConstantCricket.rule_subtitle[1]);
        subtitletext3.setText(ConstantCricket.rule_subtitle[2]);subtitletext4.setText(ConstantCricket.rule_subtitle[3]);
        subtitletext5.setText(ConstantCricket.rule_subtitle[4]);subtitletext6.setText(ConstantCricket.rule_subtitle[5]);
        subtitletext7.setText(ConstantCricket.rule_subtitle[6]);subtitletext8.setText(ConstantCricket.rule_subtitle[7]);
        subtitletext9.setText(ConstantCricket.rule_subtitle[8]);subtitletext10.setText(ConstantCricket.rule_subtitle[9]);
        subtitletext11.setText(ConstantCricket.rule_subtitle[10]);subtitletext12.setText(ConstantCricket.rule_subtitle[11]);
        subtitletext13.setText(ConstantCricket.rule_subtitle[12]);subtitletext14.setText(ConstantCricket.rule_subtitle[13]);
        subtitletext15.setText(ConstantCricket.rule_subtitle[14]);subtitletext16.setText(ConstantCricket.rule_subtitle[15]);
        subtitletext17.setText(ConstantCricket.rule_subtitle[16]);subtitletext18.setText(ConstantCricket.rule_subtitle[17]);
        subtitletext19.setText(ConstantCricket.rule_subtitle[18]);subtitletext20.setText(ConstantCricket.rule_subtitle[19]);
        subtitletext21.setText(ConstantCricket.rule_subtitle[20]);subtitletext22.setText(ConstantCricket.rule_subtitle[21]);
        subtitletext23.setText(ConstantCricket.rule_subtitle[22]);subtitletext24.setText(ConstantCricket.rule_subtitle[23]);
        subtitletext25.setText(ConstantCricket.rule_subtitle[24]);subtitletext26.setText(ConstantCricket.rule_subtitle[25]);
        subtitletext27.setText(ConstantCricket.rule_subtitle[26]);subtitletext28.setText(ConstantCricket.rule_subtitle[27]);
        subtitletext29.setText(ConstantCricket.rule_subtitle[28]);subtitletext30.setText(ConstantCricket.rule_subtitle[29]);
        subtitletext31.setText(ConstantCricket.rule_subtitle[30]);subtitletext32.setText(ConstantCricket.rule_subtitle[31]);
        subtitletext33.setText(ConstantCricket.rule_subtitle[32]);subtitletext34.setText(ConstantCricket.rule_subtitle[33]);
        subtitletext35.setText(ConstantCricket.rule_subtitle[34]);subtitletext36.setText(ConstantCricket.rule_subtitle[35]);
        subtitletext37.setText(ConstantCricket.rule_subtitle[36]);subtitletext38.setText(ConstantCricket.rule_subtitle[37]);
        subtitletext39.setText(ConstantCricket.rule_subtitle[38]);subtitletext40.setText(ConstantCricket.rule_subtitle[39]);
        subtitletext41.setText(ConstantCricket.rule_subtitle[40]);
        text2.setText(ConstantCricket.rule_text[0]);text3.setText(ConstantCricket.rule_text[1]);
        text4.setText(ConstantCricket.rule_text[2]);text5.setText(ConstantCricket.rule_text[3]);
        text6.setText(ConstantCricket.rule_text[4]);text7.setText(ConstantCricket.rule_text[5]);
        text8.setText(ConstantCricket.rule_text[6]);text9.setText(ConstantCricket.rule_text[7]);
        text10.setText(ConstantCricket.rule_text[8]);text11.setText(ConstantCricket.rule_text[9]);
        text12.setText(ConstantCricket.rule_text[10]);text13.setText(ConstantCricket.rule_text[11]);
        text14.setText(ConstantCricket.rule_text[12]);text15.setText(ConstantCricket.rule_text[13]);
        text16.setText(ConstantCricket.rule_text[14]);text17.setText(ConstantCricket.rule_text[15]);
        text18.setText(ConstantCricket.rule_text[16]);text19.setText(ConstantCricket.rule_text[17]);
        text20.setText(ConstantCricket.rule_text[18]);text21.setText(ConstantCricket.rule_text[19]);
        text22.setText(ConstantCricket.rule_text[20]);text23.setText(ConstantCricket.rule_text[21]);
        text24.setText(ConstantCricket.rule_text[22]);text25.setText(ConstantCricket.rule_text[23]);
        text26.setText(ConstantCricket.rule_text[24]);text27.setText(ConstantCricket.rule_text[25]);
        text28.setText(ConstantCricket.rule_text[26]);text29.setText(ConstantCricket.rule_text[27]);
        text30.setText(ConstantCricket.rule_text[28]);text31.setText(ConstantCricket.rule_text[29]);
        text32.setText(ConstantCricket.rule_text[30]);text33.setText(ConstantCricket.rule_text[31]);
        text34.setText(ConstantCricket.rule_text[32]);text35.setText(ConstantCricket.rule_text[33]);
        text36.setText(ConstantCricket.rule_text[34]);text37.setText(ConstantCricket.rule_text[35]);
        text38.setText(ConstantCricket.rule_text[36]);text39.setText(ConstantCricket.rule_text[37]);
        text40.setText(ConstantCricket.rule_text[38]);text41.setText(ConstantCricket.rule_text[39]);
        text42.setText(ConstantCricket.rule_text[40]);
    }
}
