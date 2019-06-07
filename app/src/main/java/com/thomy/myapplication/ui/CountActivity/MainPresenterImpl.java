package com.thomy.myapplication.ui.CountActivity;


import android.util.Log;
import android.widget.EditText;

public class MainPresenterImpl implements MainPresenter {
    private static String TAG_CLASS = MainPresenterImpl.class.getCanonicalName();

    private MainView view;

    private static int mCouter;

    public MainPresenterImpl(MainView view) {
        this.view = view;
    }


    @Override
    public void onResultCounter(boolean sub, boolean less, boolean reset, EditText numTex, boolean check) {


        if (sub) {
            mCouter = mCouter + 1;

            Log.v(TAG_CLASS, "onResultCounter " + mCouter);
        }

        if (less) {

            if (!check && mCouter > 0) {
                mCouter = mCouter - 1;
                Log.v(TAG_CLASS, "onResultCounter less " + mCouter);
            }
            if (check)
                mCouter = mCouter - 1;

        }

        if (reset) {
            mCouter = 0;
            Log.v(TAG_CLASS, "onResultCounter reset " + mCouter);
        }

        String mNumTex = numTex.getText().toString().trim();

        if (!mNumTex.isEmpty() && !sub && !less && !reset) {

            mCouter = Integer.parseInt(numTex.getText().toString());

            Log.v(TAG_CLASS, "onResultCounter tex " + mCouter);


        }



        view.goToDisplayCounter(mCouter);

    }


}
