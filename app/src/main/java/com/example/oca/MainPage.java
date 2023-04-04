package com.example.oca;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import com.google.firebase.auth.FirebaseAuth;

public class MainPage extends AppCompatActivity {
    CardView journalCard, exerciseCard, testResultCard, appointmentCard, chatbotCard, profileCard, newsCard, healthCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        journalCard = (CardView) findViewById(R.id.JournalCard);
        exerciseCard = (CardView) findViewById(R.id.ExerciseCard);
        testResultCard = (CardView) findViewById(R.id.TestResultCard);
        appointmentCard = (CardView) findViewById(R.id.AppointmentCard);
        chatbotCard = (CardView) findViewById(R.id.ChatbotCard);
        profileCard = (CardView) findViewById(R.id.ProfileCard);
        newsCard = (CardView) findViewById(R.id.NewsCard);
        healthCard = (CardView) findViewById(R.id.HealthCard);

        journalCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPage.this, Journal.class);
                startActivity(intent);
            }
        });

        exerciseCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPage.this,Food.class);
                startActivity(intent);
            }
        });

        /*     testResultCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPage.this, TestResult.class);
                startActivity(intent);
            }
        });

         */
        appointmentCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPage.this, BookAppointmentActivity.class);
                startActivity(intent);
            }
        });
        newsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPage.this, ActivityNews.class);
                startActivity(intent);

            }
        });

        chatbotCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPage.this, Chatbot.class);
                startActivity(intent);
            }
        });

        profileCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPage.this, EditProfileActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.logout) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainPage.this);
            builder.setMessage("Do you want to exit?");
            builder.setCancelable(true);

            builder.setNegativeButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    FirebaseAuth.getInstance().signOut();
                    Intent intent = new Intent(MainPage.this, Login.class);
                    startActivity(intent);
                    finish();
                }
            });

            builder.setPositiveButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
        return true;
    }
}
