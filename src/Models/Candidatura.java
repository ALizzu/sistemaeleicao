package Models;

public class Candidatura {
    private Integer id;
    private final String slogan;
    private final Integer codigoCandidato;
    private final Eleicao eleicao;
    
    
    public Candidatura(String slogan, Integer codigoCandidato, Eleicao eleicao) {
        this.slogan = slogan;
        this.codigoCandidato = codigoCandidato;
        this.eleicao  = eleicao;
      
    }

    
    public String getSlogan() {
        return slogan;
    }

    
    public Integer getCodigoCandidato() {
        return codigoCandidato;
    }

    
    public Eleicao getEleicao() {
        return eleicao;
    }

   
    public Integer getId() {
        return id;
    }

   
    public void setId(Integer id) {
        this.id = id;
    }
  
}
