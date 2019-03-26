package com.xyb.schoolhox;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import com.xyb.schoolhox.view.MDatePickerDialog;



public class TestActivity extends Activity {

//    private ActivityTestBinding binding;
    private Button btnShowDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
//         binding = DataBindingUtil.setContentView(this, R.layout.activity_test);
        //binding.setUrl("https://f10.baidu.com/it/u=1265600190,1006947856&fm=173&app=49&f=JPEG?w=550&h=391&s=B6981CC74637259A168FA5300300C018&access=215967316");
        btnShowDialog = (Button) findViewById(R.id.btn_show_dialog);
        btnShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MDatePickerDialog dialog = new MDatePickerDialog.Builder(TestActivity.this)
                        .setGravity(Gravity.BOTTOM)
                        // .setSupportTime(false)
                        .setOnDateResultListener(new MDatePickerDialog.OnDateResultListener() {
                            @Override
                            public void onDateResult(long date) {
                                Log.d("时间：", "时间：" + date);
                            }
                        })
                        .build();
                dialog.show();
            }
        });
    }
}
