/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Models.Eleicao;
import Models.Administrador;
import Models.Aluno;
import Models.Candidatura;
import Models.Usuario;
import Models.Visitante;
import Models.Voto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Altimar
 */
public class Conexao  {  
    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String JDBC_URL = "jdbc:sqlite:C:/Users/Administrator/Documents/teste.db";
    private static Connection connection = null;
    
    public Conexao ()
    { 
        try {
        getConnection();
        String sqlCheck = "select * from usuarios where tipousuario = 0";
        PreparedStatement psCheck = connection.prepareStatement(sqlCheck);  
        ResultSet rs = psCheck.executeQuery();
        rs.next();
        
        } catch (SQLException | ClassNotFoundException ex) {
              
           if (ex.toString().contains("SQLNonTransientConnectionException")){
               JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados, tente novamente", "Erro", JOptionPane.ERROR_MESSAGE);
               System.exit(0);
           
           }
            criarBanco();
            //Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
  
        System.out.println("Banco de dados conectado!!");
        
        
    }
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if(connection == null){
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(JDBC_URL);
        }
        return connection;
    }

    
   static void criarBanco() {
        try {
            Class.forName(DRIVER);
        
        String sqlCreate = 
                "create table usuarios"
                + " (id integer NOT NULL PRIMARY KEY AUTOINCREMENT,"
                + " nome varchar(30), "
                + " cpf varchar(11),"
                + " idade integer,"
                + " senha varchar(20),"
                + " tipousuario integer,"
                + " codigoadmin varchar(4),"
                + " matricula varchar(16),"
                + " campusid integer)";
        
        PreparedStatement psCreate = connection.prepareStatement(sqlCreate);
        psCreate.execute();
        
        sqlCreate = 
                "create table candidatura"
                + " (id integer NOT NULL PRIMARY KEY AUTOINCREMENT,"
                + " slogan varchar(250), "
                + " eleicaoid integer,"
                + " candidatoid integer,"
                + " codigocandidato integer)";
               
        
        psCreate = connection.prepareStatement(sqlCreate);
        psCreate.execute();
        
        sqlCreate = 
                "create table campus"
                + " (id integer PRIMARY KEY AUTOINCREMENT,"
                + " descricao varchar(250) "
                + " )";
        
        psCreate = connection.prepareStatement(sqlCreate);
        psCreate.execute();
        
        sqlCreate = 
                "create table eleicao"
                + " (id integer NOT NULL PRIMARY KEY AUTOINCREMENT,"
                + " descricao varchar(250), "
                + " datainicio varchar,"
                + " datafim varchar,"
                + " campusid integer)";
        
        psCreate = connection.prepareStatement(sqlCreate);
        psCreate.execute();
        
        sqlCreate = 
                "create table voto"
                + " (id integer NOT NULL PRIMARY KEY AUTOINCREMENT,"
                + " codigovotado integer, "
                + " eleitorid integer,"
                + " datavoto date,"
                + " candidaturaid integer)";
        
        psCreate = connection.prepareStatement(sqlCreate);
        psCreate.execute();
        

        //PRIMEIROS DADOS;
        String sqlInsert = "insert into campus (descricao) values (?)"; 
        PreparedStatement psInsert = connection.prepareStatement(sqlInsert);
        
        
        psInsert.clearParameters();
        psInsert.setString(1, "SANTO ANTÔNIO DE JESUS");
        psInsert.execute();
         
        //PRIMEIROS DADOS;
        sqlInsert = "insert into usuarios (nome, codigoadmin, senha, campusid, tipousuario) values (?, ?, ?, ?, ?)";
        
        psInsert = connection.prepareStatement(sqlInsert);
        
        psInsert.clearParameters();
        psInsert.setString(1, "ADMIN");
        psInsert.setString(2,"admin");
        psInsert.setString(3,"admin");
        psInsert.setInt(4, 1);
        psInsert.setInt(5, 0);
        
        psInsert.execute();
        
        System.out.println("Banco de dados conectado");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         
    }
   
  
    
   public Usuario fazerLogin(String login, String senha) {  
      
        try {  
        String sqlCheck = "select * from usuarios where cpf = ? or codigoadmin = ? or matricula =? ";
        
        PreparedStatement psLogin = connection.prepareStatement(sqlCheck);
        
        psLogin.clearParameters();
        psLogin.setString(1,login.trim());
        psLogin.setString(2,login.trim());
        psLogin.setString(3,login.trim());
        
        ResultSet rs = psLogin.executeQuery();
        
        if( rs.next()){
            
            if(rs.getString("senha").equals(senha))

            switch (rs.getInt("tipousuario")){
            case 0:
                return new Administrador(rs.getInt("id"),rs.getString("nome"), rs.getInt("idade"),rs.getString("cpf"), rs.getString("senha"), rs.getString("codigoadmin"),rs.getInt("campusid")); 
            case 1:
                return new Aluno(rs.getInt("id"),rs.getString("nome"), rs.getInt("idade"),rs.getString("cpf"), rs.getString("senha"),rs.getInt("campusid"), rs.getString("matricula"));
                            
            case 3:
                 return new Visitante(rs.getInt("id"),rs.getString("nome"), rs.getInt("idade"),rs.getString("cpf"), rs.getString("senha"),rs.getInt("campusid"));
            default:
                return null;
            }   
        }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
   
   public String getDescricaoCampus(Integer campusid){
   
        try {
             String sqlCheck = "select descricao from campus where campus.id =? ";
        
            PreparedStatement psCheck = connection.prepareStatement(sqlCheck);
            psCheck.setInt(1, campusid);
            ResultSet rs = psCheck.executeQuery();
            rs.next();
          
            return rs.getString("descricao");

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            return ""; 
        }

   }
   
   public boolean existeCodigoCandidato(Integer codigoCandidato){
       
        try {
            
             String sqlCheck = "select * from candidatura where codigocandidato =? ";
        
            PreparedStatement psCheck = connection.prepareStatement(sqlCheck);
            psCheck.setInt(1, codigoCandidato);
            ResultSet rs = psCheck.executeQuery();
          
            return rs.next();

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
        
   }
  

   public void criarCandidatura(Candidatura cUsuario, Integer candidatoid){
       
       
        try {
  
            String sqlCheck = "insert into candidatura (slogan, candidatoid, codigocandidato, eleicaoid) values(?,?,?,?) ";
        
            PreparedStatement psCheck = connection.prepareStatement(sqlCheck);
            psCheck.setString(1, cUsuario.getSlogan());
            psCheck.setInt(2, candidatoid);
            psCheck.setInt(3, cUsuario.getCodigoCandidato());
            psCheck.setInt(4, cUsuario.getEleicao().getId());
            psCheck.execute();
          

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
      
   public void criarEleicao(Eleicao eleicaoNova){
       
        try {
            
            String sqlInsert = "insert into eleicao (descricao, datainicio, datafim,campusid) values (?,?,?,?)";
        
            PreparedStatement psInsertEleicao = connection.prepareStatement(sqlInsert);
         
            
            psInsertEleicao.setString(1, eleicaoNova.getDescricao());
            psInsertEleicao.setString(2,eleicaoNova.getDataInicio());
            psInsertEleicao.setString(3,eleicaoNova.getDataFim());
            psInsertEleicao.setInt(4, eleicaoNova.getCampusid());
            psInsertEleicao.execute();
            
            
        } catch (SQLException ex) {
           /// Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

   }
   
   public Boolean criarUsuario(Usuario usuarioNovo, Integer tipoUsuario){
       
        try {
            String sqlCampoUsuario = "";
            
            switch (tipoUsuario){
                case 0: sqlCampoUsuario ="codigoadmin";break;
                
                case 1: sqlCampoUsuario ="matricula";break;
                
                case 3: sqlCampoUsuario ="matricula";break;
            }
            
            String sqlInsert = "insert into usuarios (nome, idade, senha, cpf ,campusid, tipousuario , "+sqlCampoUsuario+" ) values (?,?,?,?,?,?,?)";
        
            PreparedStatement psInsertEleicao = connection.prepareStatement(sqlInsert);
            
            psInsertEleicao.setString(1, usuarioNovo.getNome());
            psInsertEleicao.setInt(2,usuarioNovo.getIdade());
            psInsertEleicao.setString(3,usuarioNovo.getSenha());
            psInsertEleicao.setString(4,usuarioNovo.getCPF());
            psInsertEleicao.setInt(5,usuarioNovo.getCampusId());
            psInsertEleicao.setInt(6,tipoUsuario); 
            psInsertEleicao.setString(7,usuarioNovo.getLogin());
            
            psInsertEleicao.execute();
            
            return true;
            
            
        } catch (SQLException ex) {
            return false;
        }

   }
   
   public Boolean editarUsuario(Usuario usuarioEdicao){
             try {
            String sql = "UPDATE usuarios SET nome = ?, idade = ?, cpf = ? WHERE id = ? ;";
        
            PreparedStatement psUpdateUsuario = connection.prepareStatement(sql);
            
            psUpdateUsuario.setString(1, usuarioEdicao.getNome());
            psUpdateUsuario.setInt(2,usuarioEdicao.getIdade());
            psUpdateUsuario.setString(3,usuarioEdicao.getCPF());
            psUpdateUsuario.setInt(4,usuarioEdicao.getId());

            psUpdateUsuario.execute();
            
            return true;
            
        } catch (SQLException ex) {
            return false;
        }

   }
   
   public void excluirUsuario(Integer usuarioid){
       
        try {
            
             String sqldelete = "delete from usuarios where id = ? ";
            PreparedStatement psDelete = connection.prepareStatement(sqldelete);
            
            psDelete.setInt(1, usuarioid);
            psDelete.execute();
            
            sqldelete = "delete from candidatura where candidatoid = ? ";
            psDelete = connection.prepareStatement(sqldelete);
            
            psDelete.setInt(1, usuarioid);
            psDelete.execute();
           
            
            sqldelete = "delete from voto where eleitorid = ? ";
            psDelete = connection.prepareStatement(sqldelete);
            psDelete.setInt(1, usuarioid);
            psDelete.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

   }
   
   public void excluirEleicao(Integer eleicaoid){
       
        try {
            
             String sqldelete = "delete from eleicao where id = ? ";
            PreparedStatement psDelete = connection.prepareStatement(sqldelete);
            
            psDelete.setInt(1, eleicaoid);
            psDelete.execute();
            
            
            sqldelete = "delete from voto where candidaturaid =(select id from candidatura where eleicaoid = ?); ";
            psDelete = connection.prepareStatement(sqldelete);
            psDelete.setInt(1, eleicaoid);
            psDelete.execute();
            
            sqldelete = "delete from candidatura where eleicaoid = ? ";
            psDelete = connection.prepareStatement(sqldelete);
            
            psDelete.setInt(1, eleicaoid);
            psDelete.execute();
           
            
           
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
   
   
   
   }
   
   
   
   
   public Integer getCandidaturaid(Integer codigoCandidato){
       
        try {
            
             String sqlCheck = "select id from candidatura where codigocandidato = ? ";
            PreparedStatement psCheck = connection.prepareStatement(sqlCheck);
            
            psCheck.setInt(1, codigoCandidato);
            ResultSet rsCheck = psCheck.executeQuery();
            rsCheck.next();
            
            return rsCheck.getInt("id");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);  
        }
        
       return 0;
   }
   
   
   public void criarVoto(Voto votousuario){
    
       
        try {
            
            String sqlInsertVoto = "insert into voto (codigovotado, eleitorid, datavoto, candidaturaid)  values (?,?,?,?)";

            PreparedStatement psInsertVoto = connection.prepareStatement(sqlInsertVoto);
            
            psInsertVoto.setInt(1, votousuario.candidatura.getCodigoCandidato());
            psInsertVoto.setInt(2, votousuario.eleitor.getId());
            psInsertVoto.setDate(3, Date.valueOf(votousuario.datahora));
            psInsertVoto.setInt(4,votousuario.candidatura.getId());
            psInsertVoto.execute();

            
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
  
   }
   
   public Boolean usuarioVotou(Integer eleitorid, Integer eleicaoid){
       
        try {
            
            String sqlVotou =  "select voto.id from candidatura" 
                                   +" join eleicao on eleicao.id = candidatura.ELEICAOID " 
                                   +" join voto on voto.CANDIDATURAID = candidatura.id WHERE voto.eleitorid = ? and candidatura.eleicaoid = ?";

            PreparedStatement psVotou = connection.prepareStatement(sqlVotou);
            psVotou.setInt(1, eleitorid);
            psVotou.setInt(2,eleicaoid);
            
            ResultSet rsVotou = psVotou.executeQuery();
            return rsVotou.next();   
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return false;
   
   
   }
  
   public DefaultTableModel getTableCampus(){
        
        try {
            
            String sqlCheck = "select * from campus";

            PreparedStatement psLogin = connection.prepareStatement(sqlCheck);
            ResultSet rs = psLogin.executeQuery();

            return buildTableModel(rs);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

   }
   
   public TreeMap<String, Integer> getComboBoxCampus(){
        try { 
               Map<String, Integer> mapCampus = new HashMap<>();

               
               String sqlDescricao = "select id,descricao from campus";
               PreparedStatement ps;
               ps = connection.prepareStatement(sqlDescricao);
               
               ResultSet rs = ps.executeQuery();

               while (rs.next()) {

               mapCampus.put(rs.getString("descricao"),rs.getInt("id"));

            }
               
               TreeMap<String, Integer> Campus = new TreeMap<>(mapCampus);
               return Campus;
            }
            catch(SQLException ex) {

            return new TreeMap<>();

        }
   }
   
   
   public DefaultTableModel getTableEleicaoComCampus(Integer campusid){
        
        try {
            
            String sqlCheck = "select id, campusid, descricao, datainicio, datafim from eleicao where eleicao.campusid = ?";

            PreparedStatement psEleicaoComCampus = connection.prepareStatement(sqlCheck);

            psEleicaoComCampus.setInt(1,campusid);
            ResultSet rs = psEleicaoComCampus.executeQuery();

        return buildTableModel(rs);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
  
   }
   
   
   public DefaultTableModel getTableUsuariosExcetoUsuarioid(Integer campusId,Integer adminId){
        
        try {
            
            String sqlCheck = "select id, nome, cpf, idade,tipousuario from usuarios where campusid = ? and usuarios.id  <> ?";

            PreparedStatement psUsuariosComCampus = connection.prepareStatement(sqlCheck);

            psUsuariosComCampus.setInt(1,campusId );
            psUsuariosComCampus.setInt(2, adminId);

            ResultSet rs = psUsuariosComCampus.executeQuery();
        
        return buildTableModel(rs);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
   
   }
   
   public DefaultTableModel getTableUsuariosCandidatos(Integer campusid){
        
        try {
            
            String sql = "select candidatura.id, usuarios.nome, usuarios.cpf, usuarios.idade, candidatura.codigocandidato from candidatura "
                    + "left join usuarios on usuarios.id = candidatura.candidatoid where usuarios.campusid = ? and tipousuario <> 0 "
                    + "and usuarios.id is not null order by RANDOM()";
        
            PreparedStatement psUsuariosComCampus = connection.prepareStatement(sql);
        
            psUsuariosComCampus.setInt(1,campusid );

            ResultSet rs = psUsuariosComCampus.executeQuery();
        
            return buildTableModel(rs);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
  
   }
   
   public DefaultTableModel getTableCandidatosEleicao(Integer eleicaoid){
        
        try {
            
            String sql = "select candidatura.id, usuarios.nome, usuarios.cpf, usuarios.idade, candidatura.codigocandidato from candidatura "
                    + "left join usuarios on usuarios.id = candidatura.candidatoid where usuarios.campusid = ? and tipousuario <> 0 and usuarios.id is not null";
        
            PreparedStatement psUsuariosComCampus = connection.prepareStatement(sql);
        
            psUsuariosComCampus.setInt(1,eleicaoid );

            ResultSet rs = psUsuariosComCampus.executeQuery();
        
            return buildTableModel(rs);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
  
   }
   
   
   public DefaultTableModel getTableVotosEleicao(Integer eleicaoid){
        
        try {
            
            String sql = " select usuarios.id, usuarios.nome, usuarios.idade, candidatura.CODIGOCANDIDATO, "
                      +  " count(voto.id) as QTD_VOTOS from usuarios" 
                      +  " join candidatura on candidatura.CANDIDATOID = usuarios.id" 
                      +  " left join voto on voto.CANDIDATURAID = candidatura.id" 
                      +  " join eleicao on eleicao.ID = candidatura.ELEICAOID" 
                      +  " where eleicao.id = ?"
                      +  " group by usuarios.id,usuarios.nome, usuarios.idade, candidatura.CODIGOCANDIDATO ";
        
            PreparedStatement psUsuariosComCampus = connection.prepareStatement(sql);
        
            psUsuariosComCampus.setInt(1,eleicaoid );

            ResultSet rs = psUsuariosComCampus.executeQuery();
        
            return buildTableModel(rs);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
  
   }
   
   
   public DefaultTableModel getTableRegistroVotos(Integer eleicaoid){
       try {
            
            String sql =  " SELECT u.nome as eleitor, voto.codigovotado, c.nome as candidato FROM voto " 
                        + "JOIN usuarios u on u.id = voto.eleitorid " 
                        + "JOIN candidatura on candidatura.id = voto.candidaturaid  " 
                        + "JOIN usuarios c on c.id = candidatura.candidatoid " 
                        + "WHERE candidatura.eleicaoid = ?";
        
            PreparedStatement psRegistroDeVotos = connection.prepareStatement(sql);
        
            psRegistroDeVotos.setInt(1,eleicaoid );

            ResultSet rs = psRegistroDeVotos.executeQuery();
        
            return buildTableModel(rs);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
       
   }
   
   
   
   public  TreeMap<String, Integer> getComboBoxUsuariosCandidatos(Integer campusid){
        
        try {
            
            String sql = "select usuarios.id,  usuarios.nome from usuarios left join candidatura on candidatura.candidatoid = usuarios.id "
                    + "where usuarios.campusid = ? and tipousuario <> 0 and candidatura.candidatoid is null";
        
            PreparedStatement psUsuariosComCampus = connection.prepareStatement(sql);
        
            psUsuariosComCampus.setInt(1,campusid );

            ResultSet rs = psUsuariosComCampus.executeQuery();
            Map<String, Integer> mapcandidatos = new HashMap<>();
            
            while (rs.next()) {

               mapcandidatos.put(rs.getString("nome"),rs.getInt("id"));

            }
               
               TreeMap<String, Integer> Campus = new TreeMap<>(mapcandidatos);
               return Campus;
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new TreeMap<>();
  
   }
   public TreeMap<String, Integer>  getComboBoxEleicao(Integer campusid) {

        try {
           
            String sqlDescricao = "select id, descricao from eleicao where campusid = ?";
            PreparedStatement ps;
            ps = connection.prepareStatement(sqlDescricao);
            ps.setInt(1, campusid);
            ResultSet rs = ps.executeQuery();

            Map<String, Integer> mapEleicoes = new HashMap<>();

            while (rs.next()) {

               mapEleicoes.put(rs.getString("descricao"),rs.getInt("id"));

            }
               
               TreeMap<String, Integer> Eleicoes = new TreeMap<>(mapEleicoes);
               return Eleicoes;
            }
            catch(SQLException ex) {

            return new TreeMap<>();
        }
   }
   
   public Usuario getUsuario(int usuarioid){
       
       try {
            PreparedStatement ps;
            
            String sql = "SELECT id, nome, idade, cpf FROM usuarios WHERE id = ?";
            
            ps = connection.prepareStatement(sql);
            ps.setInt(1, usuarioid);
            
            ResultSet rs = ps.executeQuery();
            rs.next();
            
             return  new Aluno(rs.getInt("id"),rs.getString("nome"), rs.getInt("idade"),rs.getString("cpf"), "",1, "");

            }
            catch(SQLException ex) {

            return null;
        }
   }
   
   public static DefaultTableModel buildTableModel(ResultSet rs)
            throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        // Nome das colunas
        Vector<String> columnNames = new Vector<>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            
            switch (metaData.getColumnName(column)){
                case "id": columnNames.add("id");break;
                case "nome": columnNames.add("Nome");break;
                case "idade": columnNames.add("Idade");break;
                case "cpf": columnNames.add("CPF");break;
                case "descricao": columnNames.add("Descrição");break;
                case "datainicio": columnNames.add("Data Inicial");break;
                case "datafim": columnNames.add("Data Final");break;
                case "tipousuario": columnNames.add("Tipo de Usuario");break;
                case "codigocandidato": columnNames.add("Código do Candidato");break;
                case "QTD_VOTOS": columnNames.add("Quantidade de Votos");break;
                case "eleitor": columnNames.add("Eleitor");break;
                case "codigovotado": columnNames.add("Código votado");break;
                case "candidato": columnNames.add("Candidato");break;
                
                default: columnNames.add(metaData.getColumnName(column));   
            }
            
                    
        }

        // Conteúdo do campo
        Vector<Vector<Object>> data = new Vector<>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);

    }
   
   
    
    
}
