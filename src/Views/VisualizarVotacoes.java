/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.Usuario;
import Services.Conexao;
/**
 *
 * @author Altimar
 */
public class VisualizarVotacoes extends javax.swing.JInternalFrame {

    private Conexao con;
    private Usuario usuarioLogado;
    public VisualizarVotacoes() {
        initComponents();
        btnRegistroVotos.setVisible(false);

        con = new Conexao();
        inicializarTabela();

    }
    
    public void inicializarTabela() {
        tblCampus.setModel(getCon().getTableCampus()); 
        tblCampus.removeColumn(tblCampus.getColumnModel().getColumn(0));
        tblCampus.setDefaultEditor(Object.class, null);
        tblCampus.setRowHeight(20);      
    }
    
    public void VisualizarRegistroVotos(){
        btnRegistroVotos.setVisible(true);
    }
    
    public void setUsuario(Usuario usuarioNovo){
        this.usuarioLogado = usuarioNovo;
    }
    
    
    public void processarCampus(){
        
        Integer campusid;
        campusid = Integer.valueOf(tblCampus.getModel().getValueAt(tblCampus.getSelectedRow(), 0).toString());



        tblEleicoes.setModel(getCon().getTableEleicaoComCampus(campusid));
        tblEleicoes.removeColumn(tblEleicoes.getColumnModel().getColumn(0));
        tblEleicoes.removeColumn(tblEleicoes.getColumnModel().getColumn(0));
        tblEleicoes.setDefaultEditor(Object.class, null);
        tblEleicoes.setRowHeight(20);


        jTabbedPane2.setSelectedIndex(1);
    
    }
    
    public void processarEleicoes(){
        
        Integer eleicaoid;
        Integer campusid;
       
        eleicaoid = Integer.valueOf(tblEleicoes.getModel().getValueAt(tblEleicoes.getSelectedRow(), 0).toString());
        campusid = Integer.valueOf(tblCampus.getModel().getValueAt(tblCampus.getSelectedRow(), 0).toString());

        tblCandidatos.setModel(getCon().getTableVotosEleicao(eleicaoid));
        tblCandidatos.removeColumn(tblCandidatos.getColumnModel().getColumn(0));
        
        tblCandidatos.setDefaultEditor(Object.class, null);
        tblCandidatos.setRowHeight(20);

        jTabbedPane2.setSelectedIndex(2);
    }
    
    
    public void processarRegistroDeVotos(){
        Integer eleicaoid;
       
        eleicaoid = Integer.valueOf(tblEleicoes.getModel().getValueAt(tblEleicoes.getSelectedRow(), 0).toString());
        tblRegistroDeVotos.setModel(getCon().getTableRegistroVotos(eleicaoid));
        
        tblRegistroDeVotos.setDefaultEditor(Object.class, null);
        tblRegistroDeVotos.setRowHeight(20);
        jTabbedPane2.setSelectedIndex(3);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        pnAba1 = new javax.swing.JPanel();
        pnFundo1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCampus = new javax.swing.JTable();
        btnAvancarCampus = new javax.swing.JButton();
        lblcampus = new javax.swing.JLabel();
        pnAba2 = new javax.swing.JPanel();
        pnFundo2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblEleicoes = new javax.swing.JTable();
        btnvoltarEleicoes = new javax.swing.JButton();
        btnAvancarEleicoes2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        pnAba3 = new javax.swing.JPanel();
        pnFundo4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblCandidatos = new javax.swing.JTable();
        btnVoltarCandidatos = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnRegistroVotos = new javax.swing.JButton();
        pnAba4 = new javax.swing.JPanel();
        pnFundo3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblRegistroDeVotos = new javax.swing.JTable();
        btnvoltarRegistroDeVotos = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.highlight")));
        setClosable(true);
        setTitle("Visualizar Votos");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName(""); // NOI18N
        setVisible(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnAba1.setBackground(new java.awt.Color(0, 51, 204));
        pnAba1.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.highlight")));

        pnFundo1.setBackground(new java.awt.Color(0, 51, 204));

        tblCampus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "teste", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCampus.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblCampus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCampusMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCampus);

        btnAvancarCampus.setBackground(new java.awt.Color(0, 102, 255));
        btnAvancarCampus.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        btnAvancarCampus.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        btnAvancarCampus.setText("Avançar");
        btnAvancarCampus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvancarCampusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnFundo1Layout = new javax.swing.GroupLayout(pnFundo1);
        pnFundo1.setLayout(pnFundo1Layout);
        pnFundo1Layout.setHorizontalGroup(
            pnFundo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFundo1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFundo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnFundo1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAvancarCampus)))
                .addContainerGap())
        );
        pnFundo1Layout.setVerticalGroup(
            pnFundo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFundo1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAvancarCampus)
                .addContainerGap())
        );

        lblcampus.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblcampus.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        lblcampus.setText("Selecione a cidade");

        javax.swing.GroupLayout pnAba1Layout = new javax.swing.GroupLayout(pnAba1);
        pnAba1.setLayout(pnAba1Layout);
        pnAba1Layout.setHorizontalGroup(
            pnAba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAba1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnFundo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnAba1Layout.createSequentialGroup()
                .addContainerGap(300, Short.MAX_VALUE)
                .addComponent(lblcampus, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(253, 253, 253))
        );
        pnAba1Layout.setVerticalGroup(
            pnAba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAba1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(lblcampus, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnFundo1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab1", pnAba1);

        pnAba2.setBackground(new java.awt.Color(0, 51, 204));
        pnAba2.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.highlight")));
        pnAba2.setToolTipText("");

        pnFundo2.setBackground(new java.awt.Color(0, 51, 204));

        tblEleicoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEleicoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEleicoesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblEleicoes);

        btnvoltarEleicoes.setBackground(new java.awt.Color(0, 102, 255));
        btnvoltarEleicoes.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        btnvoltarEleicoes.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        btnvoltarEleicoes.setText("Voltar");
        btnvoltarEleicoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvoltarEleicoesActionPerformed(evt);
            }
        });

        btnAvancarEleicoes2.setBackground(new java.awt.Color(0, 102, 255));
        btnAvancarEleicoes2.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        btnAvancarEleicoes2.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        btnAvancarEleicoes2.setText("Avançar");
        btnAvancarEleicoes2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvancarEleicoes2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnFundo2Layout = new javax.swing.GroupLayout(pnFundo2);
        pnFundo2.setLayout(pnFundo2Layout);
        pnFundo2Layout.setHorizontalGroup(
            pnFundo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFundo2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFundo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 903, Short.MAX_VALUE)
                    .addGroup(pnFundo2Layout.createSequentialGroup()
                        .addComponent(btnvoltarEleicoes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAvancarEleicoes2)))
                .addContainerGap())
        );
        pnFundo2Layout.setVerticalGroup(
            pnFundo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFundo2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnFundo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnvoltarEleicoes)
                    .addComponent(btnAvancarEleicoes2))
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        jLabel3.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        jLabel3.setText("Eleições disponiveis para visualização");

        javax.swing.GroupLayout pnAba2Layout = new javax.swing.GroupLayout(pnAba2);
        pnAba2.setLayout(pnAba2Layout);
        pnAba2Layout.setHorizontalGroup(
            pnAba2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAba2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnFundo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnAba2Layout.createSequentialGroup()
                .addContainerGap(300, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(253, 253, 253))
        );
        pnAba2Layout.setVerticalGroup(
            pnAba2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAba2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnFundo2, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab1", pnAba2);

        pnAba3.setBackground(new java.awt.Color(0, 51, 204));
        pnAba3.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.highlight")));
        pnAba3.setToolTipText("");

        pnFundo4.setBackground(new java.awt.Color(0, 51, 204));

        tblCandidatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCandidatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCandidatosMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblCandidatos);

        btnVoltarCandidatos.setBackground(new java.awt.Color(0, 102, 255));
        btnVoltarCandidatos.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        btnVoltarCandidatos.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        btnVoltarCandidatos.setText("Voltar");
        btnVoltarCandidatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarCandidatosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnFundo4Layout = new javax.swing.GroupLayout(pnFundo4);
        pnFundo4.setLayout(pnFundo4Layout);
        pnFundo4Layout.setHorizontalGroup(
            pnFundo4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFundo4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFundo4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 903, Short.MAX_VALUE)
                    .addGroup(pnFundo4Layout.createSequentialGroup()
                        .addComponent(btnVoltarCandidatos)
                        .addGap(0, 835, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnFundo4Layout.setVerticalGroup(
            pnFundo4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFundo4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVoltarCandidatos)
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        jLabel4.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        jLabel4.setText("Candidatos e seus respectivos votos");

        btnRegistroVotos.setText("Registro de votos");
        btnRegistroVotos.setName("btnRegistroVotos"); // NOI18N
        btnRegistroVotos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroVotosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnAba3Layout = new javax.swing.GroupLayout(pnAba3);
        pnAba3.setLayout(pnAba3Layout);
        pnAba3Layout.setHorizontalGroup(
            pnAba3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAba3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnFundo4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnAba3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(btnRegistroVotos, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        pnAba3Layout.setVerticalGroup(
            pnAba3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAba3Layout.createSequentialGroup()
                .addGroup(pnAba3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnAba3Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(btnRegistroVotos)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnAba3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(pnFundo4, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab1", pnAba3);

        pnAba4.setBackground(new java.awt.Color(0, 51, 204));
        pnAba4.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.highlight")));
        pnAba4.setToolTipText("");

        pnFundo3.setBackground(new java.awt.Color(0, 51, 204));

        tblRegistroDeVotos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRegistroDeVotos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRegistroDeVotosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblRegistroDeVotos);

        btnvoltarRegistroDeVotos.setBackground(new java.awt.Color(0, 102, 255));
        btnvoltarRegistroDeVotos.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        btnvoltarRegistroDeVotos.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        btnvoltarRegistroDeVotos.setText("Voltar");
        btnvoltarRegistroDeVotos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvoltarRegistroDeVotosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnFundo3Layout = new javax.swing.GroupLayout(pnFundo3);
        pnFundo3.setLayout(pnFundo3Layout);
        pnFundo3Layout.setHorizontalGroup(
            pnFundo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFundo3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFundo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 903, Short.MAX_VALUE)
                    .addGroup(pnFundo3Layout.createSequentialGroup()
                        .addComponent(btnvoltarRegistroDeVotos)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnFundo3Layout.setVerticalGroup(
            pnFundo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFundo3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnvoltarRegistroDeVotos)
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        jLabel5.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        jLabel5.setText("Registro de Votos");

        javax.swing.GroupLayout pnAba4Layout = new javax.swing.GroupLayout(pnAba4);
        pnAba4.setLayout(pnAba4Layout);
        pnAba4Layout.setHorizontalGroup(
            pnAba4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAba4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnFundo3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnAba4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(381, 381, 381))
        );
        pnAba4Layout.setVerticalGroup(
            pnAba4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAba4Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnFundo3, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab1", pnAba4);

        getContentPane().add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -29, 950, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
      //if (this.usuarioLogado != null) 
         //   lblUsuarioBoasVindas.setText("Bem vindo " + this.usuarioLogado.getClasse() + " " + usuarioLogado.getNome());
        //else {
        //    lblUsuarioBoasVindas.setText("Bem vindo");
        //}
    }//GEN-LAST:event_formInternalFrameOpened

    private void tblCampusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCampusMouseClicked
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
                    evt.consume();
                    
                    processarCampus();
            }
    }//GEN-LAST:event_tblCampusMouseClicked

    private void btnAvancarCampusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvancarCampusActionPerformed
        processarCampus();
    }//GEN-LAST:event_btnAvancarCampusActionPerformed

    private void tblEleicoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEleicoesMouseClicked
       if (evt.getClickCount() == 2 && !evt.isConsumed()) {
                    evt.consume();
                    
                    processarEleicoes();
            }
    }//GEN-LAST:event_tblEleicoesMouseClicked

    private void tblCandidatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCandidatosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblCandidatosMouseClicked

    private void btnVoltarCandidatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarCandidatosActionPerformed
       jTabbedPane2.setSelectedIndex(1);
    }//GEN-LAST:event_btnVoltarCandidatosActionPerformed

    private void btnAvancarEleicoes2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvancarEleicoes2ActionPerformed
        processarEleicoes();
    }//GEN-LAST:event_btnAvancarEleicoes2ActionPerformed

    private void btnvoltarEleicoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvoltarEleicoesActionPerformed
        jTabbedPane2.setSelectedIndex(0);
    }//GEN-LAST:event_btnvoltarEleicoesActionPerformed

    private void btnRegistroVotosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroVotosActionPerformed
       processarRegistroDeVotos();
    }//GEN-LAST:event_btnRegistroVotosActionPerformed

    private void tblRegistroDeVotosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRegistroDeVotosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblRegistroDeVotosMouseClicked

    private void btnvoltarRegistroDeVotosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvoltarRegistroDeVotosActionPerformed
      jTabbedPane2.setSelectedIndex(2);
    }//GEN-LAST:event_btnvoltarRegistroDeVotosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvancarCampus;
    private javax.swing.JButton btnAvancarEleicoes2;
    private javax.swing.JButton btnRegistroVotos;
    private javax.swing.JButton btnVoltarCandidatos;
    private javax.swing.JButton btnvoltarEleicoes;
    private javax.swing.JButton btnvoltarRegistroDeVotos;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lblcampus;
    private javax.swing.JPanel pnAba1;
    private javax.swing.JPanel pnAba2;
    private javax.swing.JPanel pnAba3;
    private javax.swing.JPanel pnAba4;
    private javax.swing.JPanel pnFundo1;
    private javax.swing.JPanel pnFundo2;
    private javax.swing.JPanel pnFundo3;
    private javax.swing.JPanel pnFundo4;
    private javax.swing.JTable tblCampus;
    private javax.swing.JTable tblCandidatos;
    private javax.swing.JTable tblEleicoes;
    private javax.swing.JTable tblRegistroDeVotos;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the con
     */
    public Conexao getCon() {
        return con;
    }
}