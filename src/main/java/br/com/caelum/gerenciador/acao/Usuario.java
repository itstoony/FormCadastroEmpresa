package br.com.caelum.gerenciador.acao;

public class Usuario {

    String login;
    String senha;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean ehIgual(String login, String senha){
        if (!login.equals(this.login)){
            return false;
        }

        if (!senha.equals(this.senha)){
            return false;
        }

        return true;

    }
}
