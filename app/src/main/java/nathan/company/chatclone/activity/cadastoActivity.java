package nathan.company.chatclone.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

import nathan.company.chatclone.R;
import nathan.company.chatclone.config.ConfiguracaoFirebase;
import nathan.company.chatclone.model.Usuario;

public class cadastoActivity extends AppCompatActivity {
private EditText editNome;
private EditText editEmail;
private  EditText editSenha;
private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadasto);

        editNome=findViewById(R.id.idNome);
        editEmail=findViewById(R.id.idEmail);
        editSenha=findViewById(R.id.idSenha);
    }
public void cadastrarUsuario(Usuario usuario){
        auth= ConfiguracaoFirebase.getAuth();
        auth.createUserWithEmailAndPassword(
usuario.getEmail(),usuario.getSenha()



        ).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
if (task.isSuccessful()){
Toast.makeText(cadastoActivity.this,
        "cadastrado com suceço",Toast.LENGTH_SHORT
).show();
}else {
    String excecao="";
    try {
        throw task.getException();
    }catch (FirebaseAuthWeakPasswordException e){
        excecao=" senha fraca da miseria";
    }catch (FirebaseAuthInvalidCredentialsException e){
        excecao="qualé esse email ta brocado";
    }catch (FirebaseAuthUserCollisionException e ){
        excecao= "esse email já foi usado vei";
    }catch (Exception e ){
        excecao= "deu ruim" + e.getMessage();
        e.printStackTrace();
    }
    Toast.makeText(cadastoActivity.this,

            excecao,Toast.LENGTH_SHORT
            ).show();
}

            }
        });


}

    public void validarCadastroUsuario(View view){

     String textoNome=editNome.getText().toString();
     String textoEmail=editEmail.getText().toString();
     String textoSenha=editSenha.getText().toString();


     if (!textoNome.isEmpty()){
         if (!textoEmail.isEmpty()){

             if (!textoSenha.isEmpty()){
                 Usuario usuario=new Usuario();
                 usuario.setNome(textoNome);
                 usuario.setEmail(textoEmail);
                 usuario.setSenha(textoSenha);

                 cadastrarUsuario(usuario);

             }else { Toast.makeText(cadastoActivity.this,
                     "e a senha zé ",
                     Toast.LENGTH_SHORT).show();}
         }else{ Toast.makeText(cadastoActivity.this,
                 "qualé de mermo,esqueceu o email",
                 Toast.LENGTH_SHORT).show();}
     }else {
         Toast.makeText(cadastoActivity.this,
                 "diga teu nome pivete",
                 Toast.LENGTH_SHORT).show();
     }

    }

}