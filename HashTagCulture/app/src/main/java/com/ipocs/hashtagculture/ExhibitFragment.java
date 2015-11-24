package com.ipocs.hashtagculture;

import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ExhibitFragment extends Fragment {

    public static final String TAG = ExhibitFragment.class.getSimpleName();

    private OnFragmentInteractionListener mListener;

    public static ExhibitFragment newInstance() {
        ExhibitFragment fragment = new ExhibitFragment();

        return fragment;
    }

    public ExhibitFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exhibit, container, false);


        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }
}
