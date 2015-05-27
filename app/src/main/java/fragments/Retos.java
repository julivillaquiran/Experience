package fragments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import adapters.ImageAdapter;
import julianv.com.experience.ChallengeDescription;
import julianv.com.experience.R;
import julianv.com.experience.UserSelection;

/*
 * @author JulianV
 * @link https://github.com/julivillaquiran
 *
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Retos.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Retos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Retos extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Button newChallenge;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<?> retos;

   // private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Retos.
     */
    // TODO: Rename and change types and number of parameters
    public static Retos newInstance() {
        Retos fragment = new Retos();
        Bundle args = new Bundle();
        //retos = retosArg;
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        //fragment.setArguments(args);
        return fragment;
    }

    public Retos() {
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
        final View rootView = inflater.inflate(R.layout.fragment_retos, container, false);

        newChallenge = (Button) rootView.findViewById(R.id.newChallengeBtn);
        View.OnClickListener oclBtn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), UserSelection.class));
            }
        };
        newChallenge.setOnClickListener(oclBtn);

        GridView gridview = (GridView) rootView.findViewById(R.id.activeChallengeSelectorGrid);// crear el
        // gridview a partir del elemento del xml gridview
        gridview.setAdapter(new ImageAdapter(getActivity()));// con setAdapter se llena
        // el gridview con datos. en
        // este caso un nuevo objeto de la clase ImageAdapter,
        // que está definida en otro archivo
        // para que detecte la pulsación se le añade un listener de itemClick
        // que recibe un OniTemClickListener creado con new

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // dentro de este listener difinimos la función que se ejecuta al
            // hacer click en un item
            // el metodo pertenece a AdapterView, es decir, es
            // AdapterView.OnItemClickListener
            // dentro de este, tenemos el método onItemClick, que es el que se
            // invoca al pulsar un item del AdapterView
            // esa función recibe el objeto padre, que es un adapterview en el
            // que se ha pulasdo, una vista, que es el elemento sobre el que se
            // ha pulsado,
            // una posicion, que es la posicion del elemento dentro del adapter,
            // y un id, que es el id de fila del item que se ha pulsado
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                // Toast para mostrar un mensaje. Escribe el nombre de tu clase
                // si no la llamaste MainActivity.
                // Al hacer click, esta mensaje muestra la posición

                /*
                Intent intent = new Intent(getActivity(), ActiveChallenge.class);

                Bundle b = new Bundle();
                b.putInt("ChallengeSelected", position); //Your id
                intent.putExtra("ChallengeSelected", position); //Put your id to your next Intent

                startActivity(intent);

                */
                //finish();

                Toast.makeText(getActivity(), "Has elegido el reto en " + position, Toast.LENGTH_SHORT)
                        .show();

            }
        });
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
           // mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
       // mListener = null;
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
