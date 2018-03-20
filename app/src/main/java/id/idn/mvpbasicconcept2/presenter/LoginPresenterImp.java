package id.idn.mvpbasicconcept2.presenter;

import android.text.TextUtils;

/**
 * Created by hp on 3/20/2018.
 */

/**
 * This class is for logic of presenter class
 */
public class LoginPresenterImp implements LoginPresenter {

    private LoginView loginView;

    public LoginPresenterImp(LoginView loginView){
        // tell that loginView varible from LoginView is same of their loginView parameters
        this.loginView = loginView;
    }

    // When this class call, which is there have to have 2 Parameters to declare. It's for Username and Password
    @Override
    public void login(String username, String password) {
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            loginView.showValidationError();
        }else {
            if (username.equals("admin") && password.equals("admin")){
                loginView.loginSuccess();
            } else {
                loginView.loginError();
            }
        }
    }
}
