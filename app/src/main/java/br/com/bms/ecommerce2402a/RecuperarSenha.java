package br.com.bms.ecommerce2402a;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class RecuperarSenha extends AppCompatActivity {

    private EditText editEmailRS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.recuperarsenha);

        inicia_componente();
    }
    private void inicia_componente() {
        editEmailRS = findViewById(R.id.editemairecuperarsenha);
    }
    public void validar_dados_RS(View view){
        //Primeiro, uma variavel para pegar a informação inserida dentro da caixa de email
        String email = editEmailRS.getText().toString();
        //verifica se a caixa foi preenchida
        if(!email.isEmpty()){
            enviar_Email(email);
        }else{
            editEmailRS.requestFocus();
            editEmailRS.setError("Insira seu email");
        }
    }
    private void enviar_Email(String email){
        FirebaseHelper.getAuth().sendPasswordResetEmail(email)
                .addOnCompleteListener(task -> {
                    //Caso a tarefa seja um sucesso
                   if (task.isSuccessful()){
                       //Dizemos para o programa notificar através de um Toast, uma mensagem pedindo
                       // para o usuario veficar o email
                       Toast.makeText(this, "Verifique seu email", Toast.LENGTH_SHORT).show();
                       //em seguida, finaliza a tela de recuperar senha e volta para a tela de login
                       finish();
                   }else{
                       //Caso contrario, pegamos o erro gerado dentro do metodo validaErro, inserimos ele detro da variavel
                       String erro = FirebaseHelper.validar_Erros(task.getException().getMessage());
                       //Exibe para o usuario qual foi o erro
                       Toast.makeText(this, erro, Toast.LENGTH_SHORT).show();
                   }
                });
    }

}
