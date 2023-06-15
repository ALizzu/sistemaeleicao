package Models;

public class Aluno extends Eleitor {
    private  String matricula;

    public Aluno(Integer id,String nome, Integer idade,String CPF, String senha,Integer campusid, String matricula) {
        super(id,nome, idade,CPF, senha,campusid);
        this.matricula = matricula;
    }

    @Override
    public String getLogin() {
        return this.matricula;
    }

    @Override
    public String getClasse() {
        return "Aluno";
    }

    @Override
    public Boolean equals(Usuario outroUsuario) {
        return this.getLogin().equals(outroUsuario.getLogin());
    }


}
