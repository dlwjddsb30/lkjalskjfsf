package kr.co.moneybnb2;

import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    ImageView iv,iv_bt1,iv_bt2,iv_bt3,iv_bt4;
    int screen_width;
    Button bt_login,bt_menu;
    DrawerLayout dl;
    RelativeLayout rly_myinfo1;
    LinearLayout rly_myinfo2;
    TextView tv1,tv2,tv3,tv4,tv5;
    static int u_id = -1;


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
                    loadinfo();
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
         rly_myinfo1 = (RelativeLayout)findViewById(R.id.rly_myinfo1);
         rly_myinfo2 = (LinearLayout)findViewById(R.id.rly_myinfo2);
         tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        tv3 = (TextView)findViewById(R.id.tv3);
        tv4 = (TextView)findViewById(R.id.tv4);
        tv5 = (TextView)findViewById(R.id.tv5);

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

        rly_item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://moneybnb.co.kr/moneybnb/?mode=invest")));
            }
        });
        rly_item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://moneybnb.co.kr/moneybnb/?mode=loan_step1")));
            }
        });
        rly_item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dl.closeDrawer(Gravity.LEFT);
            }
        });
        rly_item4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://moneybnb.co.kr/moneybnb/?mode=introduce")));
            }
        });
        rly_item5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://moneybnb.co.kr/moneybnb/?mode=bbs_list&table=notice&subject=%EA%B3%B5%EC%A7%80%EC%82%AC%ED%95%AD")));
            }
        });
        rly_item6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://pf.kakao.com/_JSbxmd")));
            }
        });
        rly_item7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=kr.co.moneybnb&hl=ko")));
            }
        });

        bt_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendDialog();
            }
        });
        bt_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeDialog();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == 2) {//ㄹㅗ그인 성공
                bt_login.setText("로그아웃");
                bt_login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        u_id = -1;
                        rly_myinfo1.setVisibility(View.VISIBLE);
                        rly_myinfo2.setVisibility(View.GONE);
                        bt_login.setText("로그인");
                        bt_login.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent in = new Intent(MainActivity.this,LoginActivity.class);
                                startActivityForResult(in,1);
                                overridePendingTransition(0, 0);
                            }
                        });

                    }
                });
                rly_myinfo1.setVisibility(View.GONE);
                rly_myinfo2.setVisibility(View.VISIBLE);
                loadinfo();
            }else{

            }
        }
    }

    public void loadinfo(){
        if(u_id!=-1) {
            String result = "";
            try {
                result = new APIProc(MainActivity.this).execute("myinfo1", Integer.toString(u_id)).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            JSONObject res = null;
            try {
                res = new JSONObject(result);

                if (res.getString("result").equals("ok")) {

                    String name = res.getJSONObject("data").getString("name");
                    String email = res.getJSONObject("data").getString("id");
                    String money = res.getJSONObject("data").getString("money");
                    String point = res.getJSONObject("data").getString("point");
                    String mpoint = res.getJSONObject("data").getString("mpoint");
                    save("name", name);
                    save("email", email);
                    save("money1", money);
                    save("money2", point);
                    save("money3", mpoint);
                    tv1.setText(name + "님 환영합니다.");
                    tv2.setText(email);
                    tv3.setText("예치금 : " + money + "원");
                    tv4.setText("보유 포인트 : " + point + "P");
                    tv5.setText("머니비앤비 점수 : " + mpoint + "점");


                } else {
                    //Toast.makeText(LoginActivity.this,"회원정보를 확인해주세요",Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
    private void save(String where, String what){
        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(where,what);
        editor.commit();
    }
    private String get(String where){
        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        return pref.getString(where, " ");

    }

    public void changeDialog(){
        ChangeDialog Dlg = new ChangeDialog(MainActivity.this,  new ChangeDialog.ChangeDialogListener() {

            @Override
            public void onAccept(String point,String pass) {
                String uid = u_id+"";
                String result = "";
                try {
                    result = new APIProc(MainActivity.this).execute("change",uid,point,pass).get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                JSONObject res = null;
                try {
                    res = new JSONObject(result);

                    if(res.getString("result").equals("ok")){
                        Toast.makeText(MainActivity.this,"성공적으로 신청했습니다.",Toast.LENGTH_SHORT).show();
                    }else{
                        //Toast.makeText(LoginActivity.this,"회원정보를 확인해주세요",Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onRefuse() {

            }
        });
        Dlg.show();
    }

    public void sendDialog(){
        GiftDialog Dlg = new GiftDialog(MainActivity.this,  new GiftDialog.GiftDialogListener() {

            @Override
            public void onAccept(String uid2, String point,String pass) {
                String uid = u_id+"";
                String result = "";
                try {
                    result = new APIProc(MainActivity.this).execute("gift",uid,uid2,point,pass).get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                JSONObject res = null;
                try {
                    res = new JSONObject(result);

                    if(res.getString("result").equals("ok")){
                        Toast.makeText(MainActivity.this,"성공적으로 보냈습니다.",Toast.LENGTH_SHORT).show();
                    }else{
                        //Toast.makeText(LoginActivity.this,"회원정보를 확인해주세요",Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onRefuse() {

            }
        });
        Dlg.show();
    }

}
