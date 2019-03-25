package com.xyb.schoolhox;

import android.app.Activity;
import android.os.Bundle;

import com.xyb.schoolhox.bean.Question;
import com.xyb.schoolhox.myview.MyQuestionView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private MyQuestionView myQuestionView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_manager);
        myQuestionView = (MyQuestionView) findViewById(R.id.myquestionview);
        ArrayList<Question> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Question question = new Question();
            question.setQues("问题" + i);
            question.setAns("答案" + i);
            list.add(question);
        }
        myQuestionView.setQuestions(list);

    }
}
