package org.techtown.slowletter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.Telephony;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;

public class InboxAdapter extends BaseAdapter {
    ArrayList<Inbox_Item> items=new ArrayList<Inbox_Item>();
    Context context;

    public void addItem(Inbox_Item item){
        items.add(item);
    }

    public InboxAdapter(Context c){
        context=c;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        InboxItemViewHolder viewHolder;

        //DB에서 값을 가져올 때 바꿔야할 값 //지금 임의로 설정한 값임
        Inbox_Item inbox_item = items.get(position);

        //오늘 날짜
        Calendar today = Calendar.getInstance();
        //받을 날짜
        Calendar receive_day= Calendar.getInstance();
        receive_day.set(inbox_item.r_year,inbox_item.r_month,inbox_item.r_day);

        /// D-day 계산 시작
        //일단위로 값 가져오기
        long long_receive_day = receive_day.getTimeInMillis()/(24*60*60*1000);
        long long_today = today.getTimeInMillis()/(24*60*60*1000);

        //두 날짜 빼기
        long d_day = long_today-long_receive_day;
        //receive day가 현재보다 미래면 -
        //receive day가 현재보다 과거면 + 가 나온다.
        ///D-day 계산 끝

        //inbox_item.xml과 연결


        if(d_day>=0){
            //d-day가 지났으면 open
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.inbox_item_open,parent,false);
            viewHolder = new InboxItemViewHolder();
            viewHolder.d_day_Tv = (TextView)convertView.findViewById(R.id.receive_day_open_textview);
            viewHolder.d_day_Tv.setText(""+inbox_item.r_year+"."+inbox_item.r_month+"."+inbox_item.r_day);
            viewHolder.sent_Tv  = (TextView)convertView.findViewById(R.id.sent_day_open_textview);
            viewHolder.sent_Tv.setText(""+inbox_item.s_year+"."+inbox_item.s_month+"."+inbox_item.s_day);
        }else{
            //d-day가 안지났으면 close
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.inbox_item_close,parent,false);
            viewHolder = new InboxItemViewHolder();
            viewHolder.d_day_Tv = (TextView)convertView.findViewById(R.id.d_day_close_textview);
            viewHolder.d_day_Tv.setText("D - "+Math.abs(d_day));
            viewHolder.sent_Tv  = (TextView)convertView.findViewById(R.id.sent_day_close_textview);
            viewHolder.sent_Tv.setText(""+inbox_item.s_year+"."+inbox_item.s_month+"."+inbox_item.s_day);

            final int pos = position;
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View view =(View) View.inflate(context,R.layout.inboxview,null);

                }
            });


        }



        return convertView;
    }
}




