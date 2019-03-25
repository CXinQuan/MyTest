package com.xyb.schoolhox.myview;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.xyb.schoolhox.R;
import com.xyb.schoolhox.bean.Question;

/**
 * Created by 陈鑫权  on 2019/3/24.
 */

public class MyQuestionItemView extends FrameLayout {

    private ImageView ivCancle;
    private EditText etAns;
    private EditText etQue;
    private ImageView rbSelect;
    Question question;
    private boolean isSelect = false;

    public MyQuestionItemView(@NonNull Context context) {
        this(context, null);
    }

    public MyQuestionItemView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyQuestionItemView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = View.inflate(context, R.layout.item_quetion_layout, this);
        init(view);
    }

    private void init(View view) {

        ivCancle = (ImageView) view.findViewById(R.id.iv_cancle);
        etAns = (EditText) view.findViewById(R.id.et_ans);
        etQue = (EditText) view.findViewById(R.id.et_que);
        rbSelect = (ImageView) view.findViewById(R.id.rb_eslect);

//        rbSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                Log.d("0000","000");
//               System.out.println(isChecked);
//            }
//        });
//        rbSelect.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                rbSelect.setChecked(!rbSelect.isChecked());
//
//            }
//        });
        rbSelect.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
               isSelect= !isSelect;
                setSelect(isSelect);
            }
        });

        question = new Question();
        ivCancle.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                MyQuestionItemView.this.setVisibility(View.GONE);
            }
        });
    }

    public void setQuestion(Question question) {
        if (question != null) {
            this.question = question;
            setCanSee(true);
            setSelect(true);
            etQue.setText(question.getQues());
            etAns.setText(question.getAns());
        }
    }

    public Question getQuestion() {
        question.setQues(etQue.getText().toString());
        question.setAns(etAns.getText().toString());
        return question;
    }

    public void setSelect(boolean select) {
        //   rbSelect.setChecked(select);
        this.isSelect = select;
        if (isSelect) {
            rbSelect.setImageResource(R.drawable.select_check);
        } else {
            rbSelect.setImageResource(R.drawable.select);
        }
    }

    public boolean isSelect() {
        //   return rbSelect.isChecked();
        return isSelect;
    }

    public boolean isVisivity() {
        return this.getVisibility() == View.VISIBLE;
    }

    /**
     * 设置整体是否可见
     *
     * @param isSee
     */
    public void setCanSee(boolean isSee) {
        if (isSee) {
            this.setVisibility(View.VISIBLE);
        } else {
            this.setVisibility(View.GONE);
        }
    }

    /**
     * 设置 取消按钮是否可见
     *
     * @param isSee
     */
    public void setCancleVisivity(boolean isSee) {
        if (isSee) {
            ivCancle.setVisibility(View.VISIBLE);
        } else {
            ivCancle.setVisibility(View.GONE);
        }
    }

}
