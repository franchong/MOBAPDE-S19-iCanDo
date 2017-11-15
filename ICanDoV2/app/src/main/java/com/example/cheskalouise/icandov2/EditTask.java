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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EditTask.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EditTask#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditTask extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    ImageView buttonMenu;
    TextView tvTitle;
    EditText etTitle;
    TextView tvDescription;
    EditText etDescription;
    TextView tvDueDate;
    ImageView buttonDate;
    TextView tvDate;
    CheckBox cbRecurring;
    RadioGroup rbGroup;
    RadioButton rbDaily;
    RadioButton rbWeekly;
    RadioButton rbMonthly;
    RadioButton rbSpecificDate;
    Button buttonCancel;
    Button buttonSave;


    private OnFragmentInteractionListener mListener;

    public EditTask() {
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
    public static EditTask newInstance(String param1, String param2) {
        EditTask fragment = new EditTask();
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

        final View view =  inflater.inflate(R.layout.fragment_edit_task, container, false);

        //buttonMenu = (ImageView) view.findViewById(R.id.button_menu_edit);
        tvTitle = (TextView) view.findViewById(R.id.tv_title_edit);
        etTitle = (EditText) view.findViewById(R.id.et_title_edit);
        tvDescription = (TextView) view.findViewById(R.id.tv_description_edit);
        etDescription = (EditText) view.findViewById(R.id.et_description_edit);
        tvDueDate = (TextView) view.findViewById(R.id.tv_dueDate_edit);
        buttonDate = (ImageView) view.findViewById(R.id.button_date_edit);
        tvDate = (TextView) view.findViewById(R.id.tv_date_edit);
        cbRecurring = (CheckBox) view.findViewById(R.id.cb_recurring_edit);
        rbGroup = (RadioGroup) view.findViewById(R.id.rb_group_edit);
        rbDaily = (RadioButton) view.findViewById(R.id.rb_daily_edit);
        rbWeekly = (RadioButton) view.findViewById(R.id.rb_weekly_edit);
        rbMonthly = (RadioButton) view.findViewById(R.id.rb_monthly_edit);
        rbSpecificDate = (RadioButton) view.findViewById(R.id.rb_specificDate_edit);
        buttonCancel = (Button) view.findViewById(R.id.button_cancel_edit);
        buttonSave = (Button) view.findViewById(R.id.button_save_edit);

/**
 String title
 = getIntent().getExtras().getString("taskTitle_edit");
 String description
 = getIntent().getExtras().getString("taskDesc_edit");
 String due
 = getIntent().getExtras().getString("taskDue_edit");
 String day
 = getIntent().getExtras().getString("taskDay_edit");
 String recurring
 = getIntent().getExtras().getString("taskRecur_edit");

 etTitle.setText(title);
 etDescription.setText(description);
 tvDueDate.setText(due);

 if (recurring == null) {
 cbRecurring.setChecked(false);
 rbDaily.setEnabled(false);
 rbWeekly.setEnabled(false);
 rbMonthly.setEnabled(false);
 rbSpecificDate.setEnabled(false);
 } else {
 if (recurring.contains("Daily")) {
 cbRecurring.setChecked(true);
 rbDaily.setChecked(true);
 } else if (recurring.contains("Weekly")) {
 cbRecurring.setChecked(true);
 rbWeekly.setChecked(true);
 } else if (recurring.contains("Monthly")) {
 cbRecurring.setChecked(true);
 rbMonthly.setChecked(true);
 } else {
 cbRecurring.setChecked(true);
 tvDate.setText(recurring);
 }
 }
 **/
        Calendar c = Calendar.getInstance();
        final int y = c.get(Calendar.YEAR);
        final int m = c.get(Calendar.MONTH);
        final int d = c.get(Calendar.DAY_OF_MONTH);
        /**
        buttonDate.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
            public void onClick(View view) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(EditTask.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        String mm_;
                        String dd_;
                        String yy_;

                        if (month+1 < 10)
                            mm_ = 0 + Integer.toString(month+1);
                        else
                            mm_ = Integer.toString(month+1);

                        if (day < 10)
                            dd_ = 0 + Integer.toString(day);
                        else
                            dd_ = Integer.toString(day);

                        year = year % 100;
                        yy_ = Integer.toString(year);

                        tvDate.setText(mm_ + "-" + dd_ + "-" + yy_);
                    }
                }, y, m, d);
                datePickerDialog.show();

            }

        });
            **/
        /**

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (!b) {
                    rbDaily.setEnabled(false);
                    rbWeekly.setEnabled(false);
                    rbMonthly.setEnabled(false);
                    rbSpecificDate.setEnabled(false);
                } else {
                    rbDaily.setEnabled(true);
                    rbWeekly.setEnabled(true);
                    rbMonthly.setEnabled(true);
                    rbSpecificDate.setEnabled(true);
                }
            }

        });

        rbSpecificDate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {

                    DatePickerDialog datePickerDialog = new DatePickerDialog(EditTask.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                            String mm_;
                            String dd_;
                            String yy_;

                            if (month+1 < 10)
                                mm_ = 0 + Integer.toString(month+1);
                            else
                                mm_ = Integer.toString(month+1);

                            if (day < 10)
                                dd_ = 0 + Integer.toString(day);
                            else
                                dd_ = Integer.toString(day);

                            year = year % 100;
                            yy_ = Integer.toString(year);

                            rbSpecificDate.setText("Specific Date" + " " + mm_ + "-" + dd_ + "-" + yy_);
                        }
                    }, y, m, d);
                    datePickerDialog.show();

                } else {
                    rbSpecificDate.setText("Specific Date");
                }
            }

        });
             **/


         buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //finish();
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

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //finish();
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
