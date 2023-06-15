package Models;

public abstract class Usuario {
    private Integer id;
    private String nome;
    private Integer idade;
    private String senha;
    private Integer campusid;
    private String CPF;

    public Usuario(Integer id ,String nome, Integer idade, String CPF, String senha, Integer campusid) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.senha = senha;
        this.campusid = campusid;
        this.CPF = CPF;
    }
    
    public Integer getId(){
        return this.id;
    }

    public String getNome(){
        return this.nome;
    }
    
    public Integer getIdade(){
        return this.idade;
    };
    
    public String getSenha(){
        return this.senha;
    }; 
    
    public Integer getCampusId(){
        return this.campusid;
        
    }
    
    public abstract String getLogin();
    
    public abstract String getClasse();
  
    public abstract Boolean equals(Usuario outroUsuario);

    /**
     * @return the CPF
     */
    public String getCPF() {
        return CPF;
    }
    
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setIdade(int idade) {
        this.idade = idade;
    }
    

    /**
     * @param CPF the CPF to set
     */
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    
}
