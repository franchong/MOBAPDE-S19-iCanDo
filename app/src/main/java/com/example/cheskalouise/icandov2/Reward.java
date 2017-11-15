package com.example.cheskalouise.icandov2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Reward.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Reward#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Reward extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ImageView buttonMenu;
    TextView tvLevel;
    ProgressBar pbLevel;
    TextView tvTotalPoints;
    TextView tvEarned;
    Button buttonAddReward;
    RecyclerView rvRewards;

    private OnFragmentInteractionListener mListener;

    public Reward() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Search.
     */
    // TODO: Rename and change types and number of parameters
    public static Search newInstance(String param1, String param2) {
        Search fragment = new Search();
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
        final View view = inflater.inflate(R.layout.fragment_reward, container, false);

        buttonMenu = (ImageView) view.findViewById(R.id.button_menu);
        tvLevel = (TextView) view.findViewById(R.id.tv_level);
        pbLevel = (ProgressBar) view.findViewById(R.id.pb_level);
        tvTotalPoints = (TextView) view.findViewById(R.id.tv_total_points);
        tvEarned = (TextView) view.findViewById(R.id.tv_earned);
        buttonAddReward = (Button) view.findViewById(R.id.button_addReward);
        rvRewards = (RecyclerView) view.findViewById(R.id.rv_rewards);

        ArrayList<Rewards> rewards = new ArrayList<>();

        rewards.add(new Rewards("Sleep", " ", "Weekly", 30));
        rewards.add(new Rewards("Eat", " ", "Instantly", 15));
        rewards.add(new Rewards("Read", " ", "Daily", 5));
        rewards.add(new Rewards("Watch", " ", "Monthly", 20));

        RewardAdapter ra = new RewardAdapter(rewards);
        ra.setOnItemClickListener(new RewardAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Rewards r) {
                Toast.makeText(view.getContext(),
                        "user clicked on " + r.getTitle(),
                        Toast.LENGTH_SHORT).show();

                Fragment fragment = null;
                Class fragmentClass = ViewReward.class;
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
        rvRewards.setAdapter(ra);

        rvRewards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        rvRewards.setLayoutManager(new LinearLayoutManager(
                view.getContext(), LinearLayoutManager.VERTICAL, false
        ));

        buttonAddReward.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                /**
                 Intent i = new Intent();
                 i.setAction(Intent.ACTION_CALL);
                 i.setClass(getBaseContext(), AddRewardMenu.class);
                 startActivityForResult(i, 3);
                 **/
                Fragment fragment = null;
                Class fragmentClass = AddReward.class;
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
