package edu.cnm.deepdive.golfgreen.controller;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import edu.cnm.deepdive.golfgreen.R;
import edu.cnm.deepdive.golfgreen.service.GoogleSignInService;


/**
 * <code>LoginActivity</code> is a method that is used to implement google sign-in service.
 */
public class LoginActivity extends AppCompatActivity {

  /**
   * <code>onCreate</code> creates the login activity and sets the layout from
   * <code>R.layout.activity_login</code>
   */
  private static final int LOGIN_REQUEST_CODE = 1000;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    SignInButton signIn = findViewById(R.id.sign_in);
    signIn.setOnClickListener(view -> LoginActivity.this.signIn());
  }

  /**
   * <code>onStart</code> is used to search if an google account is already logged in.  If the
   * account is signed in it will
   * bypass the other methods below.
   */
  @Override
  protected void onStart() {
    super.onStart();
    GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
    if (account != null) {
      GoogleSignInService.getInstance().setAccount(account);
      switchToMain();
    }
  }

  /**
   * If a google account has not been previously signed it, then a request is made to sign in with a
   * google account.   If the user is unable to sign in or has the incorrect credentials then the
   * user will be unable to sign in with an error message indicating such.
   *
   * @param requestCode the request sent to google.
   * @param resultCode the result of the request code from google.
   * @param data the data from the users google sign in account.
   */
  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    if (requestCode == LOGIN_REQUEST_CODE) {
      try {
        Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
        GoogleSignInAccount account = task.getResult(ApiException.class);
        GoogleSignInService.getInstance().setAccount(account);
        switchToMain();
      } catch (ApiException e) {
        Toast.makeText(this, R.string.login_failure_message, Toast.LENGTH_LONG)
            .show();
      }

    }
  }

  /**
   * If the credentials are correct, the user will be signed in and advance forward.
   */
  private void signIn() {
    Intent intent = GoogleSignInService.getInstance().getClient().getSignInIntent();
    startActivityForResult(intent, LOGIN_REQUEST_CODE);
  }

  /**
   * After the user has been signed in the <code>MainActivity.java</code>
   */
  private void switchToMain() {
    Intent intent = new Intent(this, MainActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
    startActivity(intent);
  }

}
