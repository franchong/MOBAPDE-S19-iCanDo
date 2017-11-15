package com.example.cheskalouise.icandov2;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ViewTask.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ViewTask#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewTask extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ImageView buttonMenu;
    TextView tvTaskTitle;
    TextView tvTaskDescription;
    TextView tvTaskDue;
    TextView tvTaskRecurring;
    Button buttonViewEdit;
    Button buttonViewComplete;

    private OnFragmentInteractionListener mListener;

    public ViewTask() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Task.
     */
    // TODO: Rename and change types and number of parameters
    public static ViewTask newInstance(String param1, String param2) {
        ViewTask fragment = new ViewTask();
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

        View view =  inflater.inflate(R.layout.fragment_view_task, container, false);


        buttonMenu = (ImageView) view.findViewById(R.id.button_menu);
        tvTaskTitle = (TextView) view.findViewById(R.id.tv_task_title);
        tvTaskDescription = (TextView) view.findViewById(R.id.tv_task_description);
        tvTaskDue = (TextView) view.findViewById(R.id.tv_task_due);
        tvTaskRecurring = (TextView) view.findViewById(R.id.tv_task_recurring);
        buttonViewEdit = (Button) view.findViewById(R.id.button_view_edit);
        buttonViewComplete = (Button) view.findViewById(R.id.button_view_complete);

        /**
        final String title
                = getActivity().getIntent().getExtras().getString("taskTitle_");
        final String description
                = getActivity().getIntent().getExtras().getString("taskDesc_");
        final String due
                = getActivity().getIntent().getExtras().getString("taskDue_");
        final String day
                = getActivity().getIntent().getExtras().getString("taskDay_");
        final String recurring
                = getActivity().getIntent().getExtras().getString("taskRecur_");

        tvTaskTitle.setText(title);
        tvTaskDescription.setText(description);
        tvTaskDue.setText(due + " " + day);
        tvTaskRecurring.setText("Recurring " + recurring);
         **/
        buttonViewEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            /**
                Intent i = new Intent();
                i.setAction(Intent.ACTION_CALL);
                i.setClass(view.getContext(), EditTask.class);
                i.putExtra("taskTitle_edit", title);
                i.putExtra("taskDesc_edit", description);
                i.putExtra("taskDue_edit", due);
                i.putExtra("taskDay_edit", day);
                i.putExtra("taskRecur_edit", recurring);
            **/

                Fragment fragment = null;
                Class fragmentClass = EditTask.class;
                try {
                    fragment = (Fragment) fragmentClass.newInstance();
                } catch (java.lang.InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
            }
        });

        buttonViewComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = null;
                Class fragmentClass = Task.class;
                try {
                    fragment = (Fragment) fragmentClass.newInstance();
                } catch (java.lang.InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
            }
        });
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
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
