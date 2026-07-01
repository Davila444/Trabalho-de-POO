package model;

import excessoes.LoginInvalidoException;
import interfaces.IUsuario;
/**
 * A classe abstrata que representa o usuario em geral, pode ser cliente ou administrador.
 */
public abstract class Usuario implements IUsuario {
    private String nome;
    private String email;
    private String endereco;
    private String senha;

    public Usuario(String nome, String email, String senha, String endereco) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
    }
    

    /**
     * O método de autenticação de email e senha para verificação da identidade do usuário.
     * 
     * @param email email verifica se é compatível com o cadastrado.
     * @param senha senha verifica se é compatível com a cadastrada.
     * 
     * @throws LoginInvalidoException diz ao usuario que o acesso foi negado devido a imcompatibilidade.
     */
    public boolean Autenticar(String emailDigitado, String senhaDigitada) {
        if (this.email.equals(emailDigitado) && this.senha.equals(senhaDigitada)) {
            return true;
        }
        throw new LoginInvalidoException("Credenciais inválidas ou usuário não encontrado.");
    }
    
    @Override
    public void cadastrar() {
        System.out.println("Cadastro realizado com sucesso para: " + this.nome);
    }
    
    @Override
    public void login() {
        System.out.println("Iniciando processo de login no sistema...");
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
