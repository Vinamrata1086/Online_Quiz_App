package com.example.ouiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    Button opt1,opt2,opt3,opt4;
    TextView ques,timer;
    int total=0;
    int correct=0;
    int wrong=0;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        opt1=findViewById(R.id.opt1);
        opt2=findViewById(R.id.opt2);
        opt3=findViewById(R.id.opt3);
        opt4=findViewById(R.id.opt4);
        ques=findViewById(R.id.quesn);
        timer=findViewById(R.id.timer);
        updateQuestion();
        reverseTimer(30,timer);
    }

    private void updateQuestion() {
        total++;
        if(total>4){
            Intent i =new Intent(MainActivity.this,ResultActivity.class);
            i.putExtra("total",String.valueOf(total));
            i.putExtra("correct",String.valueOf(correct));
            i.putExtra("wrong",String.valueOf(wrong));
            startActivity(i);


        }
        else{
            reference=FirebaseDatabase.getInstance().getReference().child("Question");
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    final Question question=snapshot.getValue(Question.class);
                    ques.setText(question.getQuestion());
                    opt1.setText(question.getOption1());
                    opt2.setText(question.getOption2());
                    opt3.setText(question.getOption3());
                    opt4.setText(question.getOption4());

                    opt1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(opt1.getText().toString().equals(question.getAnswer())){
                                Toast.makeText(MainActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                                opt1.setBackgroundColor(Color.GREEN);
                                correct++;
                                Handler handler=new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        opt1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();

                                    }
                                },1500);
                            }
                            else{
                                Toast.makeText(MainActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                                wrong++;
                                opt1.setBackgroundColor(Color.RED);
                                if(opt2.getText().toString().equals(question.getAnswer())){
                                    opt2.setBackgroundColor(Color.GREEN);
                                }
                                else if(opt3.getText().toString().equals(question.getAnswer())){
                                    opt3.setBackgroundColor(Color.GREEN);
                                }
                                else if(opt4.getText().toString().equals(question.getAnswer())){
                                    opt4.setBackgroundColor(Color.GREEN);
                                }
                                Handler handler=new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        opt1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        opt2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        opt3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        opt4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();

                                    }
                                },1500);
                            }

                        }
                    });
                    opt2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(opt2.getText().toString().equals(question.getAnswer())){
                                Toast.makeText(MainActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                                opt2.setBackgroundColor(Color.GREEN);
                                correct++;
                                Handler handler=new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        opt2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();

                                    }
                                },1500);
                            }
                            else{
                                Toast.makeText(MainActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                                wrong++;
                                opt2.setBackgroundColor(Color.RED);
                                if(opt1.getText().toString().equals(question.getAnswer())){
                                    opt1.setBackgroundColor(Color.GREEN);
                                }
                                else if(opt3.getText().toString().equals(question.getAnswer())){
                                    opt3.setBackgroundColor(Color.GREEN);
                                }
                                else if(opt4.getText().toString().equals(question.getAnswer())){
                                    opt4.setBackgroundColor(Color.GREEN);
                                }
                                Handler handler=new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        opt1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        opt2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        opt3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        opt4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();

                                    }
                                },1500);
                            }


                        }
                    });
                    opt3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(opt3.getText().toString().equals(question.getAnswer())){
                                Toast.makeText(MainActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                                opt3.setBackgroundColor(Color.GREEN);
                                correct++;
                                Handler handler=new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        opt3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();

                                    }
                                },1500);
                            }
                            else{
                                Toast.makeText(MainActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                                wrong++;
                                opt3.setBackgroundColor(Color.RED);
                                if(opt1.getText().toString().equals(question.getAnswer())){
                                    opt1.setBackgroundColor(Color.GREEN);
                                }
                                else if(opt2.getText().toString().equals(question.getAnswer())){
                                    opt2.setBackgroundColor(Color.GREEN);
                                }
                                else if(opt4.getText().toString().equals(question.getAnswer())){
                                    opt4.setBackgroundColor(Color.GREEN);
                                }
                                Handler handler=new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        opt1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        opt2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        opt3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        opt4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();

                                    }
                                },1500);
                            }


                        }
                    });
                    opt4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(opt4.getText().toString().equals(question.getAnswer())){
                                Toast.makeText(MainActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                                opt4.setBackgroundColor(Color.GREEN);
                                correct++;
                                Handler handler=new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        opt4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();

                                    }
                                },1500);
                            }
                            else{
                                Toast.makeText(MainActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                                wrong++;
                                opt4.setBackgroundColor(Color.RED);
                                if(opt1.getText().toString().equals(question.getAnswer())){
                                    opt1.setBackgroundColor(Color.GREEN);
                                }
                                else if(opt3.getText().toString().equals(question.getAnswer())){
                                    opt3.setBackgroundColor(Color.GREEN);
                                }
                                else if(opt2.getText().toString().equals(question.getAnswer())){
                                    opt2.setBackgroundColor(Color.GREEN);
                                }
                                Handler handler=new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        opt1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        opt2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        opt3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        opt4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();

                                    }
                                },1500);
                            }


                        }
                    });


                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }
    public void reverseTimer(int seconds, final TextView tv){
        new CountDownTimer(seconds * 1000 + 1000,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);
                int minutes = seconds / 60;
                tv.setText(String.format("%02d",minutes) + ":" + String.format("%02d",seconds));
            }

            @Override
            public void onFinish() {
                tv.setText("Completed");
                Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                intent.putExtra("total",String.valueOf(total));
                intent.putExtra("correct",String.valueOf(correct));
                intent.putExtra("wrong",String.valueOf(wrong));
                startActivity(intent);
            }
        }.start();
    }
}