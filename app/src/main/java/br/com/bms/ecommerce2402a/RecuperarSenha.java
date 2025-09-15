package br.com.bms.ecommerce2402a;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class RecuperarSenhaextends extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.recuperarsenha);

        inicia_componente();
    }

    private void inicia_componente() {
    }

}
