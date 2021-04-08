package sv.edu.udb.desafio2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;

public class login extends Activity {
    private LoginButton loginButton;
    private CallbackManager callbackManager;
    private FirebaseAuth mAut;

    protected void onStart() {
        super.onStart();
        FirebaseUser user=mAut.getCurrentUser();
        if(user!=null){
            ingresado();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAut= FirebaseAuth.getInstance();
        callbackManager= CallbackManager.Factory.create();
        loginButton=findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logInWithReadPermissions(login.this, Arrays.asList("email","public_profile"));
                LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        handleFacebookAccessToken(loginResult.getAccessToken());
                    }

                    @Override
                    public void onCancel() {

                    }

                    @Override
                    public void onError(FacebookException error) {

                    }
                });
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }

    private void handleFacebookAccessToken(AccessToken token) {
        AuthCredential credential= FacebookAuthProvider.getCredential(token.getToken());
        mAut.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            ingresado();
                            Toast.makeText(login.this, "Iniciaste Sesion", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(login.this, "Fallo al iniciar", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public  void ingresado (){
        Intent intent = new Intent(getApplicationContext(), principal.class);
        startActivity(intent);
        finish();
    }
    }
