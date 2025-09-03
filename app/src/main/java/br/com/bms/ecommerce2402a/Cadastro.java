package br.com.bms.ecommerce2402a;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

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

}