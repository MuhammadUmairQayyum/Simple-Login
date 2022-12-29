package com.androidapp.mvvmdatabinding.viewModel;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.androidapp.mvvmdatabinding.BR;
import com.androidapp.mvvmdatabinding.model.User;

public class LoginViewModel extends BaseObservable {
    private User user;
    private  String successMessage ="Login is successfull";
    private  String errorMessage="Email or Password is incorrect";

    @Bindable
    private  String toastMessage =null;
    public String getToastMessage() {
        return toastMessage;
    }


    private void setToastMessage(String toastMessage) {

        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }


    @Bindable
    public String getUserEmail() {
        return user.getEmail();
    }

    @Bindable
    public String getUserPassword() {
        return user.getPassword();
    }
    public void setUserPassword(String password) {
        user.setPassword(password);
        notifyPropertyChanged(BR.userPassword);
    }
    public void setUserEmail(String Email) {
        user.setEmail(Email);
        notifyPropertyChanged(BR.userEmail);
    }
    public LoginViewModel() {
        user = new User("","");
    }

    public void onLoginClicked() {
        if (isInputDataValid())
            setToastMessage(successMessage);
        else
            setToastMessage(errorMessage);
    }

    public boolean isInputDataValid() {
        return !TextUtils.isEmpty(getUserEmail()) && Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches() && getUserPassword().length() > 5;
    }
}
