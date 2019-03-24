package com.xyb.schoolhox.myview;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xyb.schoolhox.R;
import com.xyb.schoolhox.bean.Question;

import java.util.ArrayList;

/**
 * Created by 陈鑫权  on 2019/3/24.
 */

public class MyQuestionView extends FrameLayout {

    private final Context context;
    private MyQuestionItemView itemOne;
    private MyQuestionItemView itemTwo;
    private MyQuestionItemView itemThree;
    private TextView tvAddQue;
    private ArrayList<Question> questions;

    public MyQuestionView(@NonNull Context context) {
        this(context, null);
    }

    public MyQuestionView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyQuestionView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        View view = View.inflate(context, R.layout.question_layout, this);
        init(view);
    }

    private void init(View view) {
        questions = new ArrayList<>();
        itemOne = (MyQuestionItemView) view.findViewById(R.id.item_one);
        itemTwo = (MyQuestionItemView) view.findViewById(R.id.item_two);
        itemThree = (MyQuestionItemView) view.findViewById(R.id.item_three);
        tvAddQue = (TextView) view.findViewById(R.id.tv_add_que);
        tvAddQue.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemThree.isVisivity()) {
                    Toast.makeText(context, "最多只能添加三个问题", Toast.LENGTH_LONG).show();
                } else if (itemTwo.isVisivity() && !itemThree.isVisivity()) {
                    itemThree.setCanSee(true);
                } else if (itemOne.isVisivity() && !itemTwo.isVisivity()) {
                    itemTwo.setCanSee(true);
                } else {
                    return;
                }
            }
        });

    }

    public void setQuestions(ArrayList<Question> questions) {
        if (questions == null) {
            return;
        }
        this.questions = questions;
        int size = questions.size();
        if (size >= 1 && questions.get(0) != null) {
            itemOne.setQuestion(questions.get(0));
        }
        if (size >= 2 && questions.get(1) != null) {
            itemTwo.setQuestion(questions.get(1));
        }
        if (size >= 3 && questions.get(2) != null) {
            itemThree.setQuestion(questions.get(2));
        }
    }

    public ArrayList<Question> getQuestion() {
        ArrayList<Question> questionList = new ArrayList<>();
        if (itemOne.isVisivity() && itemOne.getQuestion() != null) {
            Question questionOne = itemOne.getQuestion();
            questionList.add(questionOne);
        }
        if (itemTwo.isVisivity() && itemTwo.getQuestion() != null) {
            Question questionTwo = itemTwo.getQuestion();
            questionList.add(questionTwo);
        }
        if (itemThree.isVisivity() && itemThree.getQuestion() != null) {
            Question questionThree = itemThree.getQuestion();
            questionList.add(questionThree);
        }
        return questionList;
    }

    /**
     * 检查内容是否 填满
     * @return
     */
    public boolean checkContent() {
        boolean isOk = true;
        if (itemOne.isVisivity()) {
            Question questionOne = itemOne.getQuestion();
            if (questionOne == null || "".equals(questionOne.getQues()) || "".equals(questionOne.getAns())) {
                isOk = false;
            }
        }
        if (itemTwo.isVisivity()) {
            Question questionTwo = itemTwo.getQuestion();
            if (questionTwo == null || "".equals(questionTwo.getQues()) || "".equals(questionTwo.getAns())) {
                isOk = false;
            }
        }
        if (itemThree.isVisivity()) {
            Question questionThree = itemThree.getQuestion();
            if (questionThree == null || "".equals(questionThree.getQues()) || "".equals(questionThree.getAns())) {
                isOk = false;
            }
        }
        return isOk;
    }

}
