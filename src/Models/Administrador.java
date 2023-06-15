package Models;

public class Administrador extends Usuario {
    private final String codigoAdmin;

    public Administrador(Integer id,String nome,Integer idade,String CPF, String senha,  String codigoAdmin, Integer campusid) {
        super(id,nome, idade, CPF,senha,campusid);
        this.codigoAdmin = codigoAdmin;
    }
    
    @Override
    public String getLogin(){
        return this.codigoAdmin;
    };
   
    @Override
    public String getClasse(){
        return "Administrador";
    }

    @Override
    public Boolean equals(Usuario outroUsuario) {
        return this.getLogin().equals(outroUsuario.getLogin());
    }

}
