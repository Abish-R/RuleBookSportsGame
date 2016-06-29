package fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import abish.rulebooksportsgame.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CricketRecords.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CricketRecords#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CricketRecords extends Fragment {
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

    private OnFragmentInteractionListener mListener;

    public CricketRecords() {
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
        mTabHost = (FragmentTabHost) view.findViewById(android.R.id.tabhost);
        mTabHost.setup(getActivity(), getChildFragmentManager(), android.R.id.tabcontent);

        Bundle b = new Bundle();
        b.putString("invoked","Test");
        Bundle b1 = new Bundle();
        b1.putString("invoked","ODI");
        Bundle b2 = new Bundle();
        b2.putString("invoked","T20");
        Bundle b3 = new Bundle();
        b3.putString("invoked","Players");

        mTabHost.addTab(mTabHost.newTabSpec("tab1").setIndicator("Test", null), CricketRecordsAdapterDecider.class, b);
        mTabHost.addTab(mTabHost.newTabSpec("tab2").setIndicator("ODI", null),CricketHistory.class, b1);
        mTabHost.addTab(mTabHost.newTabSpec("tab3").setIndicator("T20", null), CricketHistory.class, b2);
        mTabHost.addTab(mTabHost.newTabSpec("tab4").setIndicator("Players", null), CricketHistory.class, b3);
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
}
