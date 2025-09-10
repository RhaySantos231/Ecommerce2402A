package br.com.bms.ecommerce2402a;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;

public class Cadastro extends AppCompatActivity {

    private EditText editNomeCadastro, editEmailCadastro,
            editTelefoneCadastro,editSenhaCadastro;

    private Button btnCadastro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.cadastro);

        inicia_componente();
    }
    private  void inicia_componente(){
        editNomeCadastro = findViewById(R.id.editNomeCadastro);
        editEmailCadastro = findViewById(R.id.editEmailCadastro);
        editTelefoneCadastro = findViewById(R.id.editTelefoneCadastro);
        editSenhaCadastro = findViewById(R.id.editSenhaCadastro);

    }
    
    //08/09
    private  void gerar_Cadastro(Usuario usuario){
        FirebaseHelper.getAuth().createUserWithEmailAndPassword(usuario.getEmail(), usuario.getSenha())
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        //Se a criação for bem-sucedida, abre a tela de login e finaliza a atual
                        startActivity(new Intent(this, Login.class));
                        finish();
                        //recupera o id
                        String id = task.getResult().getUser().getUid();
                        usuario.setId(id);
                        //Chama a função salvar dados
                        usuario.salvar_dados();
                        //Mostra mensagem de sucesso
                        Toast.makeText(this, "Conta criada, tente fazer login", Toast.LENGTH_SHORT).show();
                    }else{
                        //se der erro, trata e exibe a mensagem para o usuario
                        String erro = FirebaseHelper.validar_Erros(task.getException().getMessage());
                        Toast.makeText(this, erro, Toast.LENGTH_SHORT).show();
                    }
                });
    }
    //10/09
    //Método para chamar ao clicar o botão de cadastro
    public void validar_dados_cadastro(View view){
        String nome = editNomeCadastro.getText().toString();
        String email = editEmailCadastro.getText().toString();
        String telefone = editTelefoneCadastro.getText().toString();
        String senha = editSenhaCadastro.getText().toString();

        //Validar os todos os campos de forma individual
        if(!nome.isEmpty()){
            if(!email.isEmpty()){
                if (!telefone.isEmpty()){
                    if(!senha.isEmpty()){
                        //Se todos os campos estiverem preenchidos
                        Usuario usuario = new Usuario();
                        usuario.setNome(nome);
                        usuario.setEmail(email);
                        usuario.setTelefone(telefone);
                        usuario.setSenha(senha);
                        //Chama o método para cadastrar no Firebase
                        gerar_Cadastro(usuario);
                    }else {
                        editSenhaCadastro.requestFocus();
                        editSenhaCadastro.setError("Preencha sua senha");
                    }
                }else {
                    editTelefoneCadastro.requestFocus();
                    editTelefoneCadastro.setError("Preencha seu telefone");
                }
            }else {
                editEmailCadastro.requestFocus();
                editEmailCadastro.setError("Preencha seu email");
            }
        }else{
            editNomeCadastro.requestFocus();
            editNomeCadastro.setError("Preencha seu nome");
        }
    }
}