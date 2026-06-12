abstract class Usuario {
    private string id;
    private String nome;
    private String email;
    private String senha;

    public Usuario(string id, string nome, string email, string senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public boolean Autenticar(String email, String senha) {
            return this.email.equals(email) && this.senha.equals(senha);
    }

    public String getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
