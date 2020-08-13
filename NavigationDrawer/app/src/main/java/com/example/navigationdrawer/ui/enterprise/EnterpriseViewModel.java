package com.example.navigationdrawer.ui.enterprise;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EnterpriseViewModel extends ViewModel
{
    private MutableLiveData<String> mText;

    public EnterpriseViewModel()
    {
        mText = new MutableLiveData<>();
        mText.setValue("This is enterprise fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
