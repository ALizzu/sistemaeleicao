package Models;

import java.util.Collection;
import java.util.HashSet;

public class Campus {
    public Collection<Usuario> pessoasInstituicao;
    public String descricao;
    Integer id;
    public Eleicao eleicaoCampus;

    public Campus(String descricao) {
        this.descricao = descricao;
        this.pessoasInstituicao = new HashSet<>();
    }


    Boolean addUsuario(Usuario pessoaNova){

        if (!pessoasInstituicao.contains(pessoaNova))
        {
            pessoasInstituicao.add(pessoaNova);
            return true;
        }

        return false;

    }

    void addCandidatura (String CPF, Candidatura candidatura) {

        for (Usuario usuario : this.pessoasInstituicao) {
            
//            if (usuario.getCPF().equals(CPF)) {
//
//                usuario.setCandidato(candidatura);
//                break;
//                
//            }
        }
    }
}
