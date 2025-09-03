package br.com.bms.ecommerce2402a;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private EditText editEmail, EditSenha;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login);

        inicia_componente();
    }
    //01/09
    private void inicia_componente(){
        btnLogin = findViewById(R.id.btnLogin);
        editEmail = findViewById(R.id.editEmailLogin);
        EditSenha = findViewById(R.id.editSenhaLogin);
    }
    public  void validaDadosLogin(View view){
        String email = editEmail.getText().toString();
        String senha = EditSenha.getText().toString();

        if(!email.isEmpty()){
            if (!senha.isEmpty()){
                login(email, senha);
            }else{
                EditSenha.requestFocus();
                EditSenha.setError("Preencha sua senha!");
            }
        }else{
            editEmail.requestFocus();
            editEmail.setError("Preencha seu email!");
        }
    }
    private void login(String email, String senha){
        //Fazer uma autentificador com o firebase para tentar fazer login com o email e senha
        //Verifica se as informações existem no banco de dados através de uma tarefa (task)
        FirebaseHelper.getAuth().signInWithEmailAndPassword(email, senha)
                .addOnCompleteListener(task -> {
                    //03/09
                    if(task.isSucessful()){
                        //inicia a tarefa principal
                        startActivity(new Intent(this, MainActivity.class));
                        //finaliza a tarefa principal
                        finish();
                    }else{
                        //Pega a mensagem de erro gerada no valida dados e inseri
                        // dentro da variavel erro
                        String erro = FirebaseHelper.validaErros(task.getException().getMessage());
                        Toast.makeText(this, erro, Toast.LENGTH_SHORT).show();
                    }
                });
    }
    public void criarConta(View view){
        startActivity(new Intent(this, Cadastro.class));
    }
    public void recuperarSenha(View view){
        startActivity(new Intent(this, RecuperarSenha.class));
    }
}
