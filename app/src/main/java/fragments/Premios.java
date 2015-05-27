package fragments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
//import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import julianv.com.experience.PrizeDetail;
import julianv.com.experience.R;

/**
 * @author JulianV
 * @link https://github.com/julivillaquiran
 *
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Premios.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Premios#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Premios extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView t1;
    private TextView t2;
    private TextView t3;

    //private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Premios.
     */
    // TODO: Rename and change types and number of parameters
    public static Premios newInstance() {
        Premios fragment = new Premios();
        Bundle args = new Bundle();
        /*args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        */
        return fragment;
    }

    public Premios() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }*/


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_premios, container, false);
        t1 = (TextView) rootView.findViewById(R.id.prize1);
        t2 = (TextView) rootView.findViewById(R.id.prize2);
        t3 = (TextView) rootView.findViewById(R.id.prize3);

        // create a listener
        View.OnClickListener oclBtn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                // Create new fragment and transaction
                Fragment newFragment = new PrizeDetalle();
                // consider using Java coding conventions (upper first char class names!!!)
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack
                transaction.replace(R.id.pager, newFragment);
                transaction.addToBackStack(null);

                // Commit the transaction
                transaction.commit();
                */
                startActivity(new Intent(getActivity(), PrizeDetail.class));

            }
        };

        t1.setOnClickListener(oclBtn);
        t2.setOnClickListener(oclBtn);
        t3.setOnClickListener(oclBtn);

        return rootView;
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        /*if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }*/
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            //mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other julianv.com.julianv.com.fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    /*public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }*/



}
