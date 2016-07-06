package fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import Constants.ConstantCricket;
import abish.rulebooksportsgame.AppController;
import abish.rulebooksportsgame.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CricketHistory.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CricketHistory#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CricketHistory extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Tracker mTracker;
    View view;
    TextView text1, text2, text3, text4, text5, text6, text7, text8, text9;
    TextView subtitletext1, subtitletext2, subtitletext3, subtitletext4, subtitletext5, subtitletext6, subtitletext7, subtitletext8;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public CricketHistory() {
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
    public static CricketHistory newInstance(String param1, String param2) {
        CricketHistory fragment = new CricketHistory();
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

        AppController application = (AppController) getActivity().getApplication();
        mTracker = application.getDefaultTracker();

        Bundle arguments = getArguments();
        if (arguments!=null) {
            String i = arguments.getString("invoked");
            Toast.makeText(getActivity(), i, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("on cricket history", "Setting screen name: " + "cricket history");
        mTracker.setScreenName("cricket history");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.cricket_tabhistory, container, false);
        initializeViews();
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

    private void initializeViews() {
        text1 = (TextView) view.findViewById(R.id.text1);
        text2 = (TextView) view.findViewById(R.id.text2);
        text3 = (TextView) view.findViewById(R.id.text3);
        text4 = (TextView) view.findViewById(R.id.text4);
        text5 = (TextView) view.findViewById(R.id.text5);
        text6 = (TextView) view.findViewById(R.id.text6);
        text7 = (TextView) view.findViewById(R.id.text7);
        text8 = (TextView) view.findViewById(R.id.text8);
        text9 = (TextView) view.findViewById(R.id.text9);
        subtitletext1 = (TextView) view.findViewById(R.id.subtitletext1);
        subtitletext2 = (TextView) view.findViewById(R.id.subtitletext2);
        subtitletext3 = (TextView) view.findViewById(R.id.subtitletext3);
        subtitletext4 = (TextView) view.findViewById(R.id.subtitletext4);
        subtitletext5 = (TextView) view.findViewById(R.id.subtitletext5);
        subtitletext6 = (TextView) view.findViewById(R.id.subtitletext6);
        subtitletext7 = (TextView) view.findViewById(R.id.subtitletext7);
        subtitletext8 = (TextView) view.findViewById(R.id.subtitletext8);
    }

    public void setTextInAllViews() {
        text1.setText(ConstantCricket.text[0]);
        text2.setText(ConstantCricket.text[1]);
        text3.setText(ConstantCricket.text[2]);
        text4.setText(ConstantCricket.text[3]);
        text5.setText(ConstantCricket.text[4]);
        text6.setText(ConstantCricket.text[5]);
        text7.setText(ConstantCricket.text[6]);
        text8.setText(ConstantCricket.text[7]);
        text9.setText(ConstantCricket.text[8]);
        subtitletext1.setText(ConstantCricket.subtitle[0]);
        subtitletext2.setText(ConstantCricket.subtitle[1]);
        subtitletext3.setText(ConstantCricket.subtitle[2]);
        subtitletext4.setText(ConstantCricket.subtitle[3]);
        subtitletext5.setText(ConstantCricket.subtitle[4]);
        subtitletext6.setText(ConstantCricket.subtitle[5]);
        subtitletext7.setText(ConstantCricket.subtitle[6]);
        subtitletext8.setText(ConstantCricket.subtitle[7]);
    }
}
