package com.xyb.schoolhox.view;

import android.app.Activity;
import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.xyb.schoolhox.R;
import com.xyb.schoolhox.databinding.ActivityCreateFormBinding;

public class CreateFormActivity extends Activity implements View.OnClickListener {

    private ActivityCreateFormBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_form);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_form);
        binding.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_add_function:
                showAddFunctionPopupWindow(binding.tvAddFunction);
                break;
            case R.id.tv_setting_function:
                showSettingFunctionPopupWindow(binding.tvSettingFunction);
                break;
            case R.id.tv_create_submit:
                showFormNameDialog();
                break;

        }
    }

    Dialog dialog;

    private void showFormNameDialog() {
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_create_form);
        Window window = dialog.getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        FormNameDialogListener listener = new FormNameDialogListener();
        dialog.findViewById(R.id.tv_cancle).setOnClickListener(listener);
        dialog.findViewById(R.id.tv_sure).setOnClickListener(listener);
        dialog.show();
    }

    private void showSettingFunctionPopupWindow(final View view) {
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        View settingView = View.inflate(this, R.layout.create_form_setting_popup_window, null);
        SettingFunctionClickListener listener = new SettingFunctionClickListener();
        settingView.findViewById(R.id.cb_only_one).setOnClickListener(listener);
        settingView.findViewById(R.id.cb_notify_me).setOnClickListener(listener);
        PopupWindow popupWindow = new PopupWindow(settingView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        // 设置背景颜色  只有0.6 的透明度
        setBgColor(0.6f);
        settingView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        int height = settingView.getMeasuredHeight(); //  获取测量后的宽度
        int width = settingView.getMeasuredWidth(); //  获取测量后的宽度
        popupWindow.showAtLocation(view, Gravity.NO_GRAVITY, location[0] - width / 2 + view.getWidth() / 2, location[1] - height);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                setBgColor(1.0f);
            }
        });
    }

    private void showAddFunctionPopupWindow(final View view) {
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        View addView = View.inflate(this, R.layout.create_form_add_popup_window, null);
        AddFunctionClickListener listener = new AddFunctionClickListener();
        addView.findViewById(R.id.tv_text_box).setOnClickListener(listener);
        addView.findViewById(R.id.tv_picture_upload).setOnClickListener(listener);
        addView.findViewById(R.id.tv_text_description).setOnClickListener(listener);
        addView.findViewById(R.id.tv_position).setOnClickListener(listener);
        PopupWindow popupWindow = new PopupWindow(addView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        // 设置背景颜色  只有0.6 的透明度
        setBgColor(0.6f);
        addView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        int addHeight = addView.getMeasuredHeight(); //  获取测量后的宽度
        popupWindow.showAtLocation(view, Gravity.NO_GRAVITY, 0, location[1] - addHeight);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                setBgColor(1.0f);
            }
        });
    }

    private void setBgColor(float alph) {
        WindowManager.LayoutParams lp = this.getWindow().getAttributes();
        lp.alpha = alph;
        getWindow().setAttributes(lp);

    }

    class AddFunctionClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tv_text_box:
                    break;
                case R.id.tv_picture_upload:
                    break;
                case R.id.tv_text_description:
                    break;
                case R.id.tv_position:
                    break;
            }
        }
    }

    class SettingFunctionClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.cb_only_one:
                    break;
                case R.id.cb_notify_me:
                    break;

            }
        }
    }

    class FormNameDialogListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tv_cancle:
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                    break;
                case R.id.tv_sure:


                    break;

            }
        }
    }
}
