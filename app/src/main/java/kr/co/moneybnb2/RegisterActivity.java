package kr.co.moneybnb2;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;

public class RegisterActivity extends AppCompatActivity {

    ImageView iv;
    Button bt_login,bt_menu;
    DrawerLayout dl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        iv = (ImageView)findViewById(R.id.img1);
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

        Glide.with(this).load(R.drawable.img1).fitCenter().into(iv);
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
        rly_myinfo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(0, 0);
    }
}
