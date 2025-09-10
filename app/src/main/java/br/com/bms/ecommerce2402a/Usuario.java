package br.com.bms.ecommerce2402a;

import com.google.firebase.database.DatabaseReference;

public class Usuario {
    private String id, nome, email, telefone, senha;

    public void Usuario() {
    }

    public void salvar_dados() {
        DatabaseReference usuarioRef = FirebaseHelper.getDatabaseReference();
        usuarioRef.child("usuarios").child(this.getId()).setValue(id);
    }

}
