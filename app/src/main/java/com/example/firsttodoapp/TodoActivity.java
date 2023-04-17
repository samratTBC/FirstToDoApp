package com.example.firsttodoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TodoActivity extends AppCompatActivity {


    private TextView todoTextView;

    private String [] mTodos;

    private Button buttonNext;
    private Button buttonPrev;

    private int mTodoIndex=0;

    private final String TODO_INDEX= "TODO_INDEX";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        getSupportActionBar().hide();

        if(savedInstanceState!=null)
            mTodoIndex = savedInstanceState.getInt(TODO_INDEX,0);

        todoTextView =(TextView) findViewById(R.id.textViewTodo);
        buttonNext = (Button) findViewById(R.id.buttonNext);
        buttonPrev = (Button) findViewById(R.id.buttonPrev);

        mTodos = getResources().getStringArray(R.array.todos);


        todoTextView.setText(mTodos[mTodoIndex]);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTodoIndex = (mTodoIndex + 1) % mTodos.length;
                todoTextView.setText(mTodos[mTodoIndex]);
            }
        });


        buttonPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTodoIndex = (mTodoIndex - 1) % mTodos.length;
                if (mTodoIndex < 0) {
                    mTodoIndex = mTodos.length - 1;
                }
                todoTextView.setText(mTodos[mTodoIndex]);
            }
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(TODO_INDEX, mTodoIndex);
    }

}