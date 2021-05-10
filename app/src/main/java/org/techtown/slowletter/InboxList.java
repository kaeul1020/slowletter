package org.techtown.slowletter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InboxList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inboxlist);

        //뒤로가기 버튼
        ImageButton inbox = (ImageButton) findViewById(R.id.BackButton1);
        inbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        final GridView inboxlist = findViewById(R.id.inbox_gridview);
        InboxAdapter inboxlist_adpater = new InboxAdapter(this);

        //DB에서 불러와야 할 내용
        inboxlist_adpater.addItem(new Inbox_Item(2015,10,20,2018,10,20));
        inboxlist_adpater.addItem(new Inbox_Item(2016,10,21,2017,10,20));
        inboxlist_adpater.addItem(new Inbox_Item(2017,5,7,2021,10,20));
        inboxlist_adpater.addItem(new Inbox_Item(2019,10,11,2022,10,20));
        inboxlist_adpater.addItem(new Inbox_Item(2020,1,1,2022,5,20));
        inboxlist_adpater.addItem(new Inbox_Item(2020,5,5,2023,10,20));
        inboxlist_adpater.addItem(new Inbox_Item(2020,7,21,2023,11,20));
        inboxlist_adpater.addItem(new Inbox_Item(2020,8,19,2023,11,20));
        inboxlist_adpater.addItem(new Inbox_Item(2021,4,4,2023,11,20));


        inboxlist.setAdapter(inboxlist_adpater);
    }

}