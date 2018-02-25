package kr.co.moneybnb2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class LoginActivity extends AppCompatActivity {

    TextView tv_register;
    Button bt_login,bt_menu;
    DrawerLayout dl;
    EditText et,et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et = (EditText)findViewById(R.id.editText);
        et2 = (EditText)findViewById(R.id.editText2);
        bt_login = (Button)findViewById(R.id.bt_login);
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(et.getText().toString(),et2.getText().toString());
            }
        });
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

        tv_register = (TextView)findViewById(R.id.tv_register);
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivityForResult(in,1);
                overridePendingTransition(0, 0);
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
        rly_myinfo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dl.closeDrawer(Gravity.LEFT);
            }
        });
    }

    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(0, 0);
    }

    public void login(String id, String pass){
        String result = "";
        try {
            result = new APIProc(LoginActivity.this).execute("login",id,pass).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        JSONObject res = null;
        try {
            res = new JSONObject(result);

            if(res.getString("result").equals("ok")){

                //save("nname",res.getString("id"));
                save("uid",res.getString("id"));
                setResult(2);
                finish();

            }else{
                Toast.makeText(LoginActivity.this,"회원정보를 확인해주세요",Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private void save(String where, String what){
        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(where,what);
        editor.commit();
    }
}
