package com.thomy.myapplication.ui.CountActivity;


import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.thomy.myapplication.ui.base.BaseActivity;

import com.thomy.myapplication.R;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainView {
    private static String TAG_CLASS=MainActivity.class.getCanonicalName();

    MainPresenter presenter;

    @BindView(R.id.num_counter)
    TextView numCounter;

    @BindView(R.id.btn_sub)
    Button btnSub;

    @BindView(R.id.btn_less)
    Button btnLess;

    @BindView(R.id.btn_reset)
    Button btnReset;


    @BindView(R.id.num_tex)
    EditText numTex;

    @BindView(R.id.checkBox)
    CheckBox chekBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutResourceId();

        presenter = new MainPresenterImpl(this);


    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main;
    }


    @OnClick(R.id.btn_sub)
    public void onBtnSubClick() {

        presenter.onResultCounter(true, false, false,numTex,false);

    }

    @OnClick(R.id.btn_less)
    public void onBtnLessClick() {
        presenter.onResultCounter(false, true, false,numTex,false);
    }

    @OnClick(R.id.btn_reset)
    public void onBtnResetClick() {
        presenter.onResultCounter(false, false, true,numTex,false);
    }

    @OnClick(R.id.num_tex)
    public void onEditNum(){

        presenter.onResultCounter(false,false,false,numTex,false);
    }


    @OnClick(R.id.checkBox)
    public void onCheckBox(){

        presenter.onResultCounter(false,false,true,numTex,true);
    }

    @Override
    public void goToDisplayCounter(int resulCounter) {


        String counter = String.valueOf(resulCounter);


        numCounter.setText(counter);
    }



    @Override
    public void showMessage(String message) {

    }
}
