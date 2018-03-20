package id.idn.mvpbasicconcept2.presenter;

/**
 * Created by hp on 3/20/2018.
 */

public interface LoginView {
    //Show toast validation
    void showValidationError();

    //Show toast Successs Login
    void loginSuccess();

    //Show toast Login Error
    void loginError();
}
