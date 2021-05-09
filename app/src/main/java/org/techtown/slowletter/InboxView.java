package org.techtown.slowletter;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class InboxView extends AppCompatActivity {

    private int i;   //몇번째 편지인지 표시할 정수

    public InboxView(int i){
        this.i = i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inboxview);
    }
}