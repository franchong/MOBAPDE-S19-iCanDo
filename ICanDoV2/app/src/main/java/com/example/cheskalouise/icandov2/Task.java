package com.example.cheskalouise.icandov2;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManagerNonConfig;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Task.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Task#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Task extends Fragment implements ViewTask.OnFragmentInteractionListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    TextView tvLevel;
    ProgressBar pbLevel;
    TextView tvCategory;
    Spinner buttonCategory;
    Button buttonAddTask;
    PopupWindow popView;
    PopupWindow popAdd;
    RecyclerView rvTasks;

    private OnFragmentInteractionListener mListener;

    public Task() {
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
    public static Task newInstance(String param1, String param2) {
        Task fragment = new Task();
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
        final View view =  inflater.inflate(R.layout.fragment_task, container, false);

       // buttonMenu = (ImageView) view.findViewById(R.id.button_menu);
        tvLevel = (TextView) view.findViewById(R.id.tv_level);
        pbLevel = (ProgressBar) view.findViewById(R.id.pb_level);
        tvCategory = (TextView) view.findViewById(R.id.tv_category);
        buttonCategory = (Spinner) view.findViewById(R.id.sp_category);
        buttonAddTask = (Button) view.findViewById(R.id.button_addTask);
        rvTasks = (RecyclerView) view.findViewById(R.id.rv_tasks);

         final ArrayList<Tasks> tasks = new ArrayList<>();

        tasks.add(new Tasks("Laundry", "Lorem ipsum dolor sit amet, consectur adipsicing elit", "11-13-17", "(W)", "Weekly"));
        tasks.add(new Tasks("Sweep", "Lorem ipsum dolor sit amet, consectur adipsicing elit", "11-14-17", "(H)", "Weekly"));
        tasks.add(new Tasks("Mop", "Lorem ipsum dolor sit amet, consectur adipsicing elit", "11-14-17", "(H)", "Weekly"));
        tasks.add(new Tasks("Wipe", "Lorem ipsum dolor sit amet, consectur adipsicing elit", "11-15-17", "(F)", "Weekly"));

        final TaskAdapter ta = new TaskAdapter(tasks);
        ta.setOnItemClickListener(new TaskAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Tasks t) {

                 Toast.makeText(view.getContext(),
                 "user clicked on " + t.getTitle(),
                 Toast.LENGTH_SHORT).show();
                /**
                Intent i = new Intent();
                i.setAction(Intent.ACTION_CALL);
                i.setClass(view.getContext(), ViewTask.class);
                i.putExtra("taskTitle_", t.getTitle());
                i.putExtra("taskDesc_", t.getDescription());
                i.putExtra("taskDue_", t.getDueDate());
                i.putExtra("taskDay_", t.getDay());
                i.putExtra("taskRecur_", t.getRecurring());
                startActivityForResult(i, 1);
                 **/

                Fragment fragment = null;
                Class fragmentClass = ViewTask.class;
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
        rvTasks.setAdapter(ta);

        rvTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(final RecyclerView.ViewHolder viewHolder, int swipeDir) {
                AlertDialog.Builder alert = new AlertDialog.Builder(view.getContext());
                alert.setTitle("Complete");
                alert.setMessage("Done with the task?");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int position = viewHolder.getAdapterPosition();
                        tasks.remove(position);
                        ta.notifyDataSetChanged();
                        dialog.dismiss();

                        AlertDialog alertDialog = new AlertDialog.Builder(view.getContext()).create();
                        alertDialog.setTitle("Rewards");
                        alertDialog.setMessage("You earned 10 points!");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                    }
                });

                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int position = viewHolder.getAdapterPosition();
                        ta.notifyItemChanged(position);
                        dialog.dismiss();
                    }
                });

                alert.show();

            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(rvTasks);
        rvTasks.setLayoutManager(new LinearLayoutManager(
                view.getContext(), LinearLayoutManager.VERTICAL, false
        ));
/**
 buttonCategory.setOnClickListener(new OnClickListener() {
@Override
public void onClick(final View view) {
initiateCategoryMenu(view);
}

private void initiateCategoryMenu(View view) {
try {
LayoutInflater inflater = (LayoutInflater) TaskScreen.this
.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
View layout = inflater.inflate(R.layout.category_menu,
(ViewGroup) findViewById(R.id.ll_category));
popView = new PopupWindow(layout, 275, 275, true);
popView.showAtLocation(view, Gravity.CENTER, 0, -10);

TextView tvAllTasks = (TextView) findViewById(R.id.tv_allTasks);
TextView tvRecurring = (TextView) findViewById(R.id.tv_recurring);
Button buttonAddCategory = (Button) findViewById(R.id.button_addCategory);

buttonAddCategory.setOnClickListener(new OnClickListener() {
@Override
public void onClick(final View view) {
initializeAddCategoryScreen(view);
}

private void initializeAddCategoryScreen(View view) {
try {
Log.i("tag", "clicked");
LayoutInflater inflater = (LayoutInflater) TaskScreen.this
.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
View layout = inflater.inflate(R.layout.add_category_screen,
(ViewGroup) findViewById(R.id.ll_add_category_screen));
popAdd = new PopupWindow(layout, 350, 450, true);
popAdd.showAtLocation(view, Gravity.CENTER, 0, 0);
popAdd.setOutsideTouchable(true);
popAdd.setFocusable(true);

TextView tvCategoryTitle = (TextView) findViewById(R.id.tv_category_title);
EditText etCategoryTitle = (EditText) findViewById(R.id.et_category_title);
Button buttonCancel = (Button) findViewById(R.id.button_cancel);
Button buttonAdd = (Button) findViewById(R.id.button_add);

} catch (Exception e) {
e.printStackTrace();
}
}
});

} catch (Exception e) {
e.printStackTrace();
}
}
});

 **/

        buttonAddTask.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent i = new Intent();
                i.setAction(Intent.ACTION_CALL);
               // i.setClass(view.getContext(), AddTaskMenu.class);
                //startActivityForResult(i, 0);
                Fragment fragment = null;
                Class fragmentClass = AddTask.class;
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

    @Override
    public void onFragmentInteraction(Uri uri) {

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
