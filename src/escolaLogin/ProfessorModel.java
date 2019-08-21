/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escolaLogin;

/**
 *
 * @author dougl
 */
public class ProfessorModel {
    
    String nomeCompleto,
            nomeUsuario,
            senha,
            Confirmasenha,
            email,
            numeroTelefone,
            disciplina;

    public ProfessorModel() {
    }

    public ProfessorModel(String nomeCompleto, 
            String nomeUsuario, 
            String senha, 
            String Confirmasenha, 
            String email, 
            String numeroTelefone, 
            String disciplina) {
        this.nomeCompleto = nomeCompleto;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.Confirmasenha = Confirmasenha;
        this.email = email;
        this.numeroTelefone = numeroTelefone;
        this.disciplina = disciplina;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmasenha() {
        return Confirmasenha;
    }

    public void setConfirmasenha(String Confirmasenha) {
        this.Confirmasenha = Confirmasenha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
    
    
    
}



