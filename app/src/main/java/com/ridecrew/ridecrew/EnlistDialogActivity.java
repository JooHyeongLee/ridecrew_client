package com.ridecrew.ridecrew;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * 회원가입 팝업
 */

public class EnlistDialogActivity extends Activity implements View.OnClickListener{

    @Override
    public void onCreate(Bundle savedInstancedState) {
        super.onCreate(savedInstancedState);
        setContentView(R.layout.enlist_dialog);
    }

    @Override
    public void onClick(View view) {

    }
}
