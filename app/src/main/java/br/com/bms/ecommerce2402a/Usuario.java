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
    public String getId(){return  id;}
    public  void setId(String id){this.id = id;}
    public String getNome(){return nome;}
    public void setNome(String nome){this.nome = nome;}
    public String getEmail(){return email;}
    public  void setEmail(String email){this.email = email;}
    public  String getTelefone(){return telefone;}
    public  void setTelefone(String telefone){this.telefone = telefone;}
    public String getSenha(){return  senha;}
    public void setSenha(String senha){this.senha = senha;}
}
