package com.xyb.schoolhox;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class GroupTransferActivity extends Activity {

    private View btnShowDialog;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_transfer);

        btnShowDialog = findViewById(R.id.btn_show_dialog);
        btnShowDialog.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String name = "说不来的忧伤";
                dialog = new Dialog(GroupTransferActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_group_transfer);
                Window window = dialog.getWindow();
//                WindowManager.LayoutParams attributes = window.getAttributes();
//                attributes.width = WindowManager.LayoutParams.WRAP_CONTENT;
//                attributes.height = WindowManager.LayoutParams.WRAP_CONTENT;
//                window.setAttributes(attributes);
                window.getDecorView().setPadding(0, 0, 0, 0);
                TextView tvTransfer = (TextView) dialog.findViewById(R.id.tv_transfer);
                TextView tvTCancle = (TextView) dialog.findViewById(R.id.tv_cancle);
                TextView tvSure = (TextView) dialog.findViewById(R.id.tv_sure);

                tvTransfer.setText("确认将群转让给“" + name + "”");
                TransferClickListener listener = new TransferClickListener();
                tvTCancle.setOnClickListener(listener);
                tvSure.setOnClickListener(listener);
                dialog.show();
            }
        });
    }

    class TransferClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tv_cancle:
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                    break;
                case R.id.tv_sure:
                    // TODO: 2019/3/31   联网向服务器请求 转让群主

                    if (dialog != null) {
                        dialog.dismiss();
                    }

                    break;
            }
        }
    }


}
