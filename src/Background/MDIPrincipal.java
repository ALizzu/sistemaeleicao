/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Background;

import Models.Administrador;
import Models.Aluno;
import Models.Eleitor;
import Views.CriarCandidatura;
import Models.Usuario;
import Models.Visitante;
import Views.ConfiguracaoAdmin;
import Views.Login;
import Views.VisualizarVotacoes;
import Views.Votacao;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;


/**
 *
 * @author Altimar
 */
public class MDIPrincipal extends javax.swing.JFrame {
    
    private Usuario usuarioLogado = null;
    private Votacao telaVotacao = null;
    private Login telaLogin = null;
    private CriarCandidatura telaCandidatura = null;
    private VisualizarVotacoes telaVisualizar = null;
    private ConfiguracaoAdmin telaAdmin = null;
   
    public MDIPrincipal() {
        initComponents();
        inicializarTelaLogin();
        
        
    }
    
     public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

 
    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
    
    
    public void inicializarTelaCandidatura(){
        
        if (usuarioLogado != null  && "Administrador".equals(usuarioLogado.getClasse())){
            
            if(telaCandidatura == null || telaCandidatura.isClosed())        
        {
            telaCandidatura = new CriarCandidatura();
            telaCandidatura.setUsuarioCandidatura(this.usuarioLogado);
            desktopPane.add(telaCandidatura);
            telaCandidatura.setLocation(this.getWidth()/2 - telaCandidatura.getWidth()/2,(this.getHeight()-20)/2 - telaCandidatura.getHeight()/2 - 20);
            telaCandidatura.setVisible(true);
        }
        else
        {
            telaCandidatura.setLocation(this.getWidth()/2 - telaCandidatura.getWidth()/2,(this.getHeight()-20)/2 - telaCandidatura.getHeight()/2 - 20);
            telaCandidatura.setVisible(true);
        }

    }
    
    }
    
  
    public final void inicializarTelaLogin() { 
        if(telaLogin == null || telaLogin.isClosed())        
        {
            telaLogin = new Login();
            desktopPane.add(telaLogin);
            telaLogin.setLocation(this.getWidth()/2 - telaLogin.getWidth()/2,(this.getHeight()-20)/2 - telaLogin.getHeight()/2 - 20);
            telaLogin.setVisible(true);
        }
        else
        {
            telaLogin.setLocation(this.getWidth()/2 - telaLogin.getWidth()/2,(this.getHeight()-20)/2 - telaLogin.getHeight()/2 - 20);
            telaLogin.setVisible(true);
        }
        
        
        telaLogin.addInternalFrameListener(new InternalFrameListener() {
            @Override
            public void internalFrameClosing(InternalFrameEvent e) {
                
                setUsuarioLogado(telaLogin.usuarioLogin);
                telaLogin.dispose();
                atualizarVisibles();
                
            }
           @Override
                public void internalFrameOpened(InternalFrameEvent e) {}
                @Override
                public void internalFrameClosed(InternalFrameEvent e) {}
                @Override
                public void internalFrameIconified(InternalFrameEvent e) {}
                @Override
                public void internalFrameDeiconified(InternalFrameEvent e) {}
                @Override
                public void internalFrameActivated(InternalFrameEvent e) {}
                @Override
                public void internalFrameDeactivated(InternalFrameEvent e) {}
        });


    }
    
    void atualizarVisibles(){
        if (this.getUsuarioLogado() != null ){
                lblBemVindo.setText("Bem vindo "+ getUsuarioLogado().getNome());
                jMenuFazerLogin.setVisible(false);
                jMenuTrocarUsuario.setVisible(true);
                btnVotar.setVisible(true);
                
                if (usuarioLogado.getClasse().equals("Administrador")){
                   
                    btnVotar.setVisible(false);
                    btnVisualizar.setVisible(true);
                    btnTelaCadastro.setVisible(true);
            }
                
            }else{
            btnVotar.setVisible(false);
            jMenuTrocarUsuario.setVisible(false);
            jMenuFazerLogin.setVisible(true);  
            btnVotar.setVisible(false);
            btnTelaCadastro.setVisible(false);
            lblBemVindo.setText("Bem vindo ");

        }
    }
    
    public void inicializarTelaVisualizarVotacoes(){  
        
        
         if(telaVisualizar == null || telaVisualizar.isClosed())
    {
        telaVisualizar = new VisualizarVotacoes();
        
        if(usuarioLogado != null && usuarioLogado instanceof Administrador){
            telaVisualizar.VisualizarRegistroVotos();
        }
            
        desktopPane.add(telaVisualizar);
        telaVisualizar.setLocation(this.getWidth()/2 - telaVisualizar.getWidth()/2,(this.getHeight()-20)/2 - telaVisualizar.getHeight()/2 - 20);
        telaVisualizar.setVisible(true);
             try {
                 telaVisualizar.setSelected(rootPaneCheckingEnabled);
             } catch (PropertyVetoException ex) {
                 Logger.getLogger(MDIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
             }
   
    }
    else
    {
        telaVisualizar.setLocation(this.getWidth()/2 - telaVisualizar.getWidth()/2,(this.getHeight()-20)/2 - telaVisualizar.getHeight()/2 - 20);
        telaVisualizar.setVisible(true);
    }
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        btnVotar = new javax.swing.JButton();
        btnTelaCadastro = new javax.swing.JButton();
        btnVisualizar = new javax.swing.JButton();
        lblBemVindo = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        jMenuTrocarUsuario = new javax.swing.JMenuItem();
        jMenuFazerLogin = new javax.swing.JMenuItem();
        jMenuVisualizarVotacoes = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Eleicões FACEMP");
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        desktopPane.setBackground(new java.awt.Color(0, 51, 204));
        desktopPane.setForeground(new java.awt.Color(51, 102, 255));
        desktopPane.setToolTipText("");

        btnVotar.setBackground(new java.awt.Color(255, 255, 255));
        btnVotar.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        btnVotar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/voto.png"))); // NOI18N
        btnVotar.setText("Votar");
        btnVotar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVotarActionPerformed(evt);
            }
        });

        btnTelaCadastro.setBackground(new java.awt.Color(255, 255, 255));
        btnTelaCadastro.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        btnTelaCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/administrador.png"))); // NOI18N
        btnTelaCadastro.setText("Tela de Cadastro");
        btnTelaCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTelaCadastroActionPerformed(evt);
            }
        });

        btnVisualizar.setBackground(new java.awt.Color(255, 255, 255));
        btnVisualizar.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        btnVisualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/voto.png"))); // NOI18N
        btnVisualizar.setText("Visualizar Votos");
        btnVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarActionPerformed(evt);
            }
        });

        lblBemVindo.setFont(new java.awt.Font("Malgun Gothic", 0, 24)); // NOI18N
        lblBemVindo.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        lblBemVindo.setText("Bem vindo ");

        desktopPane.setLayer(btnVotar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(btnTelaCadastro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(btnVisualizar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(lblBemVindo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBemVindo, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTelaCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVotar, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(490, Short.MAX_VALUE))
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBemVindo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTelaCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVotar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        menuBar.setToolTipText("");
        menuBar.setName(""); // NOI18N

        fileMenu.setMnemonic('f');
        fileMenu.setText("Opções");

        jMenuTrocarUsuario.setText("Alternar usuario");
        jMenuTrocarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuTrocarUsuarioActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuTrocarUsuario);

        jMenuFazerLogin.setText("Fazer Login");
        jMenuFazerLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuFazerLoginActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuFazerLogin);

        jMenuVisualizarVotacoes.setText("Visualizar Votações");
        jMenuVisualizarVotacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuVisualizarVotacoesActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuVisualizarVotacoes);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Sair");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void jMenuFazerLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuFazerLoginActionPerformed
        inicializarTelaLogin();
    }//GEN-LAST:event_jMenuFazerLoginActionPerformed

    private void jMenuVisualizarVotacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuVisualizarVotacoesActionPerformed

       
      
    }//GEN-LAST:event_jMenuVisualizarVotacoesActionPerformed

    private void jMenuTrocarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuTrocarUsuarioActionPerformed
        setUsuarioLogado(null);
        atualizarVisibles();
        inicializarTelaLogin();
    }//GEN-LAST:event_jMenuTrocarUsuarioActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       inicializarTelaLogin();
    }//GEN-LAST:event_formWindowOpened

    private void btnTelaCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelaCadastroActionPerformed
        inicializarTelaConfiguracao();
        
    }//GEN-LAST:event_btnTelaCadastroActionPerformed

    private void btnVotarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVotarActionPerformed
        inicializarTelaVotacao();
    }//GEN-LAST:event_btnVotarActionPerformed

    private void btnVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarActionPerformed
         inicializarTelaVisualizarVotacoes();
    }//GEN-LAST:event_btnVisualizarActionPerformed
    public void inicializarTelaConfiguracao(){
        if (usuarioLogado != null  && usuarioLogado instanceof Administrador){
            
            if(telaAdmin == null || telaAdmin.isClosed())        
        {
            telaAdmin = new ConfiguracaoAdmin();
            
            telaAdmin.setAdminLogado(usuarioLogado);
            desktopPane.add(telaAdmin);
            telaAdmin.setLocation(this.getWidth()/2 - telaAdmin.getWidth()/2,(this.getHeight()-20)/2 - telaAdmin.getHeight()/2 - 20);
            telaAdmin.setVisible(true);
        }
        else
        {
            telaAdmin.setLocation(this.getWidth()/2 - telaAdmin.getWidth()/2,(this.getHeight()-20)/2 - telaAdmin.getHeight()/2 - 20);
            telaAdmin.setVisible(true); 
        }

    }
   
    }
                
    public void inicializarTelaVotacao(){
    
         if (usuarioLogado != null){
            
            if(telaVotacao == null || telaVotacao.isClosed())        
        {
            telaVotacao = new Votacao();

            Eleitor eleitorVotacao = null;
            
            switch (getUsuarioLogado().getClasse()){
            case "Aluno":
                    eleitorVotacao = new Aluno(getUsuarioLogado().getId(),
                    getUsuarioLogado().getNome(), getUsuarioLogado().getIdade(), 
                    getUsuarioLogado().getCPF(),getUsuarioLogado().getSenha(), 
                    getUsuarioLogado().getCampusId(), "");break;
            case "Visitante":
                  eleitorVotacao = new Visitante(getUsuarioLogado().getId(),
                    getUsuarioLogado().getNome(), getUsuarioLogado().getIdade(), 
                    getUsuarioLogado().getCPF(),getUsuarioLogado().getSenha(), 
                    getUsuarioLogado().getCampusId());break;
            }   
            
            telaVotacao.setEleitor(eleitorVotacao);
            desktopPane.add(telaVotacao);
                try {
                    telaVotacao.setSelected(rootPaneCheckingEnabled);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(MDIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            telaVotacao.setLocation(this.getWidth()/2 - telaVotacao.getWidth()/2,(this.getHeight()-20)/2 - telaVotacao.getHeight()/2 - 20);
            telaVotacao.setVisible(true);
            
        }
        else
        {
            telaVotacao.setLocation(this.getWidth()/2 - telaVotacao.getWidth()/2,(this.getHeight()-20)/2 - telaVotacao.getHeight()/2 - 20);
            telaVotacao.setVisible(true);
        }
         }

    }
    public static void main(String args[]) {
        
         new MDIPrincipal(){{
             setExtendedState(JFrame.MAXIMIZED_BOTH);
             pack();
             setVisible(true);
             atualizarVisibles();
             
         }};
        
    }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTelaCadastro;
    private javax.swing.JButton btnVisualizar;
    private javax.swing.JButton btnVotar;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem jMenuFazerLogin;
    private javax.swing.JMenuItem jMenuTrocarUsuario;
    private javax.swing.JMenuItem jMenuVisualizarVotacoes;
    private javax.swing.JLabel lblBemVindo;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

  
    public CriarCandidatura getTelaCandidatura() {
        return this.telaCandidatura;
    }



}
