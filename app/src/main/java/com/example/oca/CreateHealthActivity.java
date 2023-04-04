package com.example.oca;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CreateHealthActivity extends AppCompatActivity {
    public static final String TAG = "TAG";
    private final FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseFirestore fStore = FirebaseFirestore.getInstance();
    private final FirebaseUser currentUser = mAuth.getCurrentUser();

    Button create;
    TextInputLayout cblood, cdiabeteshist, cstagediabetes, chbphist, cstagehbp, cdia, cmed, callerg, csleep, Rbmi;
    //ProgressBar cprogress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_health);
        create = (Button) findViewById(R.id.createhealth);
        cblood = (TextInputLayout) findViewById(R.id.cblood);
        cdiabeteshist = (TextInputLayout) findViewById(R.id.cdiabeteshist);
        cstagediabetes = (TextInputLayout) findViewById(R.id.cstagediabetes);
        chbphist = (TextInputLayout) findViewById(R.id.chbphist);
        cstagehbp = (TextInputLayout) findViewById(R.id.cstagehbp);
        cdia = (TextInputLayout) findViewById(R.id.cdiagnosis);
        cmed = (TextInputLayout) findViewById(R.id.cmed);
        callerg = (TextInputLayout) findViewById(R.id.callergies);
        csleep = (TextInputLayout) findViewById(R.id.csleep);
        //cprogress = findViewById(R.id.cprogress);

            create.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String userBlood = cblood.getEditText().getText().toString().toUpperCase();
                    final String userhistdiabetes = cdiabeteshist.getEditText().getText().toString();
                    final String userstagediabetes = cstagediabetes.getEditText().getText().toString();
                    final String userhisthbp = chbphist.getEditText().getText().toString();
                    final String userstagehbp = cstagehbp.getEditText().getText().toString();
                    final String userDia = cdia.getEditText().getText().toString();
                    final String userMed = cmed.getEditText().getText().toString();
                    final String userAllerg = callerg.getEditText().getText().toString();
                    final String userSleep = csleep.getEditText().getText().toString();
                    //Validation
                    if(userBlood.isEmpty()){
                        cblood.setError("Required!");
                        return;
                    }
                    if(userhistdiabetes.isEmpty()){
                        chbphist.setError("Required!");
                        return;
                    }

                    // cprogress.setVisibility(View.VISIBLE);
                    //firebase

                    final String userID = currentUser.getUid();
                    DocumentReference documentReference = fStore.collection("Health").document(userID);
                    Map<String,Object> health = new HashMap<>();
                    health.put("Blood", userBlood + "ve" );

                    health.put("Diabetes History", userhistdiabetes );
                    health.put("Diabetes Stage", userstagediabetes);
                    health.put("High Blood Pressure History", userhisthbp );
                    health.put("High Blood Pressure Stage", userstagehbp );

                    health.put("Diagnosis", userDia );
                    health.put("Medication", userMed);
                    health.put("Allergies", userAllerg);
                    health.put("Sleep Hours", userSleep + " hours" );
                    health.put("Created Date", new Date());

                    /*
                    documentReference.set(health).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(getApplicationContext(), "Created My health! ",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(CreateHealthActivity.this, DashboardFragment.class));
                            finish();

                        }
                    })
                   .addOnFailureListener(new OnFailureListener() {
                       @Override
                       public void onFailure(@NonNull Exception e) {
                           Toast.makeText(getApplicationContext(), "Error !" +e.getMessage(), Toast.LENGTH_SHORT).show();
                          cprogress.setVisibility(View.GONE);
                       }
                     });
                    */

                }
            });

    }
}