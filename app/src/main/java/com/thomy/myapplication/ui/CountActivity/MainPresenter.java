package com.thomy.myapplication.ui.CountActivity;

import android.widget.EditText;

public interface MainPresenter {



    void onResultCounter(boolean sub, boolean less, boolean reset, EditText num,boolean check);
}
