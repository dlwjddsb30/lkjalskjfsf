package kr.co.moneybnb2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class MainActivity extends AppCompatActivity {

    ImageView iv,iv_bt1,iv_bt2,iv_bt3,iv_bt4;
    int screen_width;
    Button bt_login,bt_menu;
    DrawerLayout dl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView)findViewById(R.id.iv_banner);
        iv_bt1 = (ImageView)findViewById(R.id.iv_bt1);
        iv_bt2 = (ImageView)findViewById(R.id.iv_bt2);
        iv_bt3 = (ImageView)findViewById(R.id.iv_bt3);
        iv_bt4 = (ImageView)findViewById(R.id.iv_bt4);
        bt_login = (Button)findViewById(R.id.bt_login);
        bt_menu = (Button)findViewById(R.id.bt_menu);
        dl = (DrawerLayout)findViewById(R.id.drawer2);
        bt_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dl.isDrawerOpen(Gravity.LEFT)){
                    dl.closeDrawer(Gravity.LEFT);
                }else{
                    dl.openDrawer(Gravity.LEFT);
                }
            }
        });

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        screen_width = displayMetrics.widthPixels;
        Glide.with(this).load("http://moneybnb.co.kr/moneybnb/layouts/home/moneybnb/img/tip_title_img.png").fitCenter().into(iv);
        Glide.with(this).load(R.drawable.bt1).fitCenter().into(iv_bt1);
        Glide.with(this).load(R.drawable.bt2).fitCenter().into(iv_bt2);
        Glide.with(this).load(R.drawable.bt3).fitCenter().into(iv_bt3);
        Glide.with(this).load(R.drawable.bt_4).fitCenter().into(iv_bt4);
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this,LoginActivity.class);
                startActivityForResult(in,1);
                overridePendingTransition(0, 0);
            }
        });


        iv_bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=kr.co.moneybnb&hl=ko")));
            }
        });
        iv_bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=kr.co.moneybnb&hl=ko")));
            }
        });
        iv_bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=kr.co.moneybnb&hl=ko")));
            }
        });
        initdl();
    }
    public void initdl(){
        RelativeLayout rly_myinfo1 = (RelativeLayout)findViewById(R.id.rly_myinfo1);
        LinearLayout rly_myinfo2 = (LinearLayout)findViewById(R.id.rly_myinfo2);
        RelativeLayout rly_item1 = (RelativeLayout)findViewById(R.id.rly_item1);
        RelativeLayout rly_item2 = (RelativeLayout)findViewById(R.id.rly_item2);
        RelativeLayout rly_item3 = (RelativeLayout)findViewById(R.id.rly_item3);
        RelativeLayout rly_item4 = (RelativeLayout)findViewById(R.id.rly_item4);
        RelativeLayout rly_item5 = (RelativeLayout)findViewById(R.id.rly_item5);
        RelativeLayout rly_item6 = (RelativeLayout)findViewById(R.id.rly_item6);
        RelativeLayout rly_item7 = (RelativeLayout)findViewById(R.id.rly_item7);
        Button bt_send = (Button)findViewById(R.id.bt_send);
        Button bt_change = (Button)findViewById(R.id.bt_change);


        rly_myinfo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this,LoginActivity.class);
                startActivityForResult(in,1);
                overridePendingTransition(0, 0);
                dl.closeDrawer(Gravity.LEFT);
            }
        });
    }
}
