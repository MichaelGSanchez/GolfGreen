package edu.cnm.deepdive.golfgreen.service;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import edu.cnm.deepdive.golfgreen.GolfApplication;

/**
 * <code>GoogleSignInService</code> is the class that implements Google Sign In on the
 * <code>MainActivity.java</code>
 */
public class GoogleSignInService {

  private GoogleSignInClient client;
  private GoogleSignInAccount account;

  /**
   * These lines of code, are what trigger the <code>MainActivity.java</code> to start the
   * googleSingIn process. It also sets the parameters of what items will be needed from the google
   * sign in client.
   */
  private GoogleSignInService() {
    GoogleSignInOptions options =
        new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .requestId()
            .build();
    client = GoogleSignIn.getClient(GolfApplication.getInstance(), options);
  }


  /**
   * The list of getters and setters that are being retrieved  by the google sign in client
   */
  public static GoogleSignInService getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public GoogleSignInClient getClient() {
    return client;
  }

  public void setClient(GoogleSignInClient client) {
    this.client = client;
  }

  public GoogleSignInAccount getAccount() {
    return account;
  }

  public void setAccount(GoogleSignInAccount account) {
    this.account = account;
  }

  private static class InstanceHolder {

    private static final GoogleSignInService INSTANCE = new GoogleSignInService();

  }

}
