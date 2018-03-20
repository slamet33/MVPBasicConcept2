package id.idn.mvpbasicconcept2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.idn.mvpbasicconcept2.presenter.LoginPresenter;
import id.idn.mvpbasicconcept2.presenter.LoginPresenterImp;
import id.idn.mvpbasicconcept2.presenter.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView {

    private LoginPresenter presenter;
    private EditText etUsername;
    private EditText etPassword;
    private Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialitation Variable & View
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btLogin = findViewById(R.id.btLogin);

        /*
            This statement is important because this statment meaning
            that their variable is equals LoginPresenterImp (Which means that ok
            this class using the presenter inteface and use LoginPresenterImp class Logic)
        */
        presenter = new LoginPresenterImp(this);

        // when btLoginClicked
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // presenter variable by LoginPresenter interface, there is only two editext who get the text
                presenter.login(etUsername.getText().toString(), etPassword.getText().toString());
            }
        });
    }

    // This function would call when the validation error
    @Override
    public void showValidationError(){
        Toast.makeText(this, "Please enter valid username or password", Toast.LENGTH_SHORT).show();
    }

    // This function would call when the login was success
    @Override
    public void loginSuccess(){
        Toast.makeText(this, "You are Successfully Login", Toast.LENGTH_SHORT).show();
    }

    // This function would call when the login is invalid by username or password
    @Override
    public void loginError() {
        Toast.makeText(this, "Invalid login credentials!", Toast.LENGTH_SHORT).show();
    }
}
