/**
 * 입금확인
 */
package kr.co.moneybnb2;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;


public class ChangeDialog extends Dialog implements View.OnClickListener {

    private EditText et1;
    private EditText et2;

    public interface ChangeDialogListener {
        void onAccept(String point,String pass);
        void onRefuse();
    }

    private ChangeDialogListener m_listener;

    public ChangeDialog(Context context, ChangeDialogListener listener) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_change_confirm);

        m_listener = listener;

        init();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void init() {
        findViewById(R.id.bt_confirm).setOnClickListener(this);

        et1 = (EditText)findViewById(R.id.et2);
        et2 = (EditText)findViewById(R.id.et3);

    }


    @Override
    public void onBackPressed() {
        dismiss();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.bt_confirm://확인버튼
                m_listener.onAccept(et1.getText().toString(),et2.getText().toString());

                break;

        }
        dismiss();
    }

}
