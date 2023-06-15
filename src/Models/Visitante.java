package Models;

public class Visitante extends Eleitor {

    public Visitante(Integer id,String nome, Integer idade,String CPF, String senha,Integer campusid ) {
        super(id,nome, idade, CPF, senha,campusid);
    }
    
    @Override
    public String getLogin() {
        return "";
    }

    @Override
    public String getClasse() {
        return "Visitante";
    }  
    
    @Override
    public Boolean equals(Usuario outroUsuario) {
        return this.getLogin().equals(outroUsuario.getLogin());
    }

  
  

    
    
}
