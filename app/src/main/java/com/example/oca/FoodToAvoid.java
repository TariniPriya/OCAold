package com.example.oca;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FoodToAvoid#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FoodToAvoid extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ProgressBar prog;
    TextView food_to_avoid_bmi, food_to_avoid_diabetes, section_bmi, section_diabetes, food_to_avoid_bp, section_bp;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FoodToAvoid() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FoodToAvoid.
     */
    // TODO: Rename and change types and number of parameters
    public static FoodToAvoid newInstance(String param1, String param2) {
        FoodToAvoid fragment = new FoodToAvoid();
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


    @SuppressLint("MissingInflatedId")
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_food_to_avoid, container, false);
        prog = view.findViewById(R.id.progbar);
        // Set the fragment title
        getActivity().setTitle("Foods to Avoid");

        food_to_avoid_bmi = view.findViewById(R.id.food_to_avoid_bmi);
        food_to_avoid_diabetes = view.findViewById(R.id.food_to_avoid_diabetes);
        food_to_avoid_bp = view.findViewById(R.id.food_to_avoid_bp);

        section_bmi = view.findViewById(R.id.section_bmi);
        section_diabetes = view.findViewById(R.id.section_diabetes);
        section_bp = view.findViewById(R.id.section_bp);

        //  Toast.makeText(getContext(), "commment: "+FoodToEat.bmicomment, Toast.LENGTH_LONG).show();
        if (FoodToEat.bmicomment.equals("high")) {
            Toast.makeText(getContext(), "bmi high", Toast.LENGTH_LONG).show();
            food_to_avoid_bmi.setVisibility(View.VISIBLE);
            section_bmi.setVisibility(View.VISIBLE);
            section_bmi.setText("For high BMI");
            //     String[] bulletPoints = {"First point", "Second point", "Third point"};
            DocumentReference documentReference = FirebaseFirestore.getInstance().collection("Food").document(
                    "l1tXxkP3vjDE3Ax29TJd").collection("BMI_High").document(
                    "TOzhskePro5juj69XyZH").collection("Description_Avoid").document(
                    "oIwDJEdxLmEIHMy8iLpg");

            documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (document.exists()) {
                            String description = document.getString("description");

// Load data into input fields
                            String[] bulletPoints = description.split("\\.");
                            String bulletPointText = "";

                            for (String point : bulletPoints) {
                                bulletPointText += "\u2022 " + point.trim() + "\n";
                            }

                            prog.setVisibility(View.GONE);
                            food_to_avoid_bmi.setText(bulletPointText);

                        }

                    }
                }
            });

        }  if (FoodToEat.diabetesComment.equals("High")) {
            food_to_avoid_diabetes.setVisibility(View.VISIBLE);
            section_diabetes.setVisibility(View.VISIBLE);
           section_diabetes.setText("For high Diabetes");

            Toast.makeText(getContext(), "diabetes high", Toast.LENGTH_LONG).show();
            DocumentReference documentReference = FirebaseFirestore.getInstance().collection("Food").document(
                    "l1tXxkP3vjDE3Ax29TJd").collection("Diabetes_High").document(
                    "BD7oRrXX4yDOksBrrGoq").collection("Description_Avoid").document(
                    "nR0bzv8yQbYwTSloqUbn");

            documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (document.exists()) {
                            String description = document.getString("description");

// Load data into input fields
                            String[] bulletPoints = description.split("\\.");
                            String bulletPointText = "";

                            for (String point : bulletPoints) {
                                bulletPointText += "\u2022 " + point.trim() + "\n";
                            }

                            prog.setVisibility(View.GONE);
                            food_to_avoid_diabetes.setText(bulletPointText);

                        }

                    }
                }
            });


        }

        if (FoodToEat.bpComment.equals("High")) {
            food_to_avoid_bp.setVisibility(View.VISIBLE);
            section_bp.setVisibility(View.VISIBLE);
            section_bp.setText("For high Blood Pressure");

            DocumentReference documentReference = FirebaseFirestore.getInstance().collection("Food").document(
                    "l1tXxkP3vjDE3Ax29TJd").collection("Hypertension").document(
                            "rfMc9JWJlGXEnNX0sec3").collection("Description_Avoid").document(
                    "bg1HA1tgFFQroJxaWfEx");

            documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (document.exists()) {
                            String description = document.getString("description");

// Load data into input fields
                            String[] bulletPoints = description.split("\\.");
                            String bulletPointText = "";

                            for (String point : bulletPoints) {
                                bulletPointText += "\u2022 " + point.trim() + "\n";
                            }

                            prog.setVisibility(View.GONE);
                            food_to_avoid_bp.setText(bulletPointText);

                        }

                    }
                }
            });


        }

        if (FoodToEat.bpComment.equals("Low")) {
            food_to_avoid_bp.setVisibility(View.VISIBLE);
            section_bp.setVisibility(View.VISIBLE);
            section_bp.setText("For Low Blood Pressure");

            DocumentReference documentReference = FirebaseFirestore.getInstance().collection("Food").document(
                    "l1tXxkP3vjDE3Ax29TJd").collection("Hypotension").document(
                    "836DvQP8bKeNBjsTzwsU").collection("Description_Avoid").document(
                    "UXExhNkmMGMBQtGYOcgv");

            documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (document.exists()) {
                            String description = document.getString("description");

// Load data into input fields
                            String[] bulletPoints = description.split("\\.");
                            String bulletPointText = "";

                            for (String point : bulletPoints) {
                                bulletPointText += "\u2022 " + point.trim() + "\n";
                            }

                            prog.setVisibility(View.GONE);
                            food_to_avoid_bp.setText(bulletPointText);

                        }

                    }
                }
            });


        }
        prog.setVisibility(View.GONE);
        return view;
    }
}