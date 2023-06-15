/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.List;

/**
 *
 * @author Altimar
 */
public abstract class Eleitor extends Usuario{
    private String campus;
    private List<Voto> votos;
    private Integer campusid;

    public Eleitor(Integer id,String nome, Integer idade,String CPF, String senha, Integer campusid) {
        super(id,nome, idade,CPF, senha,campusid);
    }
    
    String getDescricaoCampus(){
        return this.campus;
    }
    
    
    List<Voto> getVotos(){
        return this.votos;
    }
    
    Integer getCampusid(){
        return this.campusid;
    }
    
    
    
    
}
