/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campeonatos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Wesley
 */
public class Principal extends javax.swing.JFrame {
    ArrayList<Estadios> ListaEstadios;
    ArrayList<Jogos> ListaJogos;
    String modoEstadios;
    String modoJogo;
  
    
    
    
    
    public void LoadTableEstadios(){
        DefaultTableModel modelo= new DefaultTableModel(new Object[]{"Código","Nome do Estádio","Cidade","Estado","Capacidade"},0);
        
        for(int i=0; i<ListaEstadios.size();i++){
            Object linha[]= new Object[]{ListaEstadios.get(i).getCodigo(),ListaEstadios.get(i).getNomeEstadio(),
                                         ListaEstadios.get(i).getCidade(), ListaEstadios.get(i).getEstado(),
                                         ListaEstadios.get(i).getCapacidade()};
            modelo.addRow(linha);
        }
   
        tbl_esta_estadios.setModel(modelo);
        tbl_esta_estadios.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbl_esta_estadios.getColumnModel().getColumn(1).setPreferredWidth(200);
        tbl_esta_estadios.getColumnModel().getColumn(2).setPreferredWidth(250);
        tbl_esta_estadios.getColumnModel().getColumn(3).setPreferredWidth(200);
        tbl_esta_estadios.getColumnModel().getColumn(4).setPreferredWidth(200);
        
        
        
        LoadCBEstadios();
        
    }
    
    
    
    public void LoadTableJogo(){
        DefaultTableModel modelo= new DefaultTableModel(new Object[]{"Código","Data","Time A","Time B","Renda","Público","Estádio"},0);
          
        for(int i=0; i<ListaJogos.size();i++){
            Object linha[]= new Object[]{ListaJogos.get(i).getCodigo(),ListaJogos.get(i).getData(),
                                         ListaJogos.get(i).getTimeA(), ListaJogos.get(i).getTimeB(),
                                         ListaJogos.get(i).getRenda(), ListaJogos.get(i).getPublico(),
                                         ListaJogos.get(i).getEstadios().getNomeEstadio()};
            modelo.addRow(linha);
        }
        
        
        tbl_jogo_jogos.setModel(modelo);
        tbl_jogo_jogos.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbl_jogo_jogos.getColumnModel().getColumn(1).setPreferredWidth(150);
        tbl_jogo_jogos.getColumnModel().getColumn(2).setPreferredWidth(200);
        tbl_jogo_jogos.getColumnModel().getColumn(3).setPreferredWidth(200);
        tbl_jogo_jogos.getColumnModel().getColumn(4).setPreferredWidth(200);
        
    }
    
    
    public void LoadCBEstadios(){
        cb_jogo_estadios.removeAllItems();
        cb_jogo_estadios.addItem("Selecione");
        for(int i=0; i<ListaEstadios.size(); i++){
            cb_jogo_estadios.addItem(ListaEstadios.get(i).getNomeEstadio());
        }
    }
    
    
    
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        setLocationRelativeTo(null);
        ListaEstadios = new ArrayList();
        ListaJogos = new ArrayList();
        modoEstadios= "Navegar";
        modoJogo= "Navegar";

        try {
            ListaEstadios = Estadios.deserealiza();
            ListaJogos = Jogos.deserealiza();
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        ManipulaInterfaceEstadios();
        ManipulaInterfaceJogo();
        
        LoadTableEstadios();
        LoadTableJogo();
    }
    
    
    public void ManipulaInterfaceEstadios(){
        switch(modoEstadios){
            case "Navegar":
                    btn_esta_salvar.setEnabled(false);
                    btn_esta_cancelar.setEnabled(false);
                    c_esta_codigo.setEditable(false);
                    c_esta_nomeEsta.setEditable(false);
                    c_esta_cidade.setEditable(false);
                    c_esta_estado.setEditable(false);
                    c_esta_capacidade.setEditable(false);
                    btn_esta_novo.setEnabled(true);
                    btn_esta_editar.setEnabled(false);
                    btn_esta_excluir.setEnabled(false);
                    break;
             
            case "Novo":
                    btn_esta_salvar.setEnabled(true);
                    btn_esta_cancelar.setEnabled(true);
                    c_esta_codigo.setEditable(true);
                    c_esta_nomeEsta.setEditable(true);
                    c_esta_cidade.setEditable(true);
                    c_esta_estado.setEditable(true);
                    c_esta_capacidade.setEditable(true);
                    btn_esta_novo.setEnabled(false);
                    btn_esta_editar.setEnabled(false);
                    btn_esta_excluir.setEnabled(false);
                    break;
                
            case "Editar":
                    btn_esta_salvar.setEnabled(true);
                    btn_esta_cancelar.setEnabled(true);
                    c_esta_codigo.setEditable(true);
                    c_esta_nomeEsta.setEditable(true);
                    c_esta_cidade.setEditable(true);
                    c_esta_estado.setEditable(true);
                    c_esta_capacidade.setEditable(true);
                    btn_esta_novo.setEnabled(true);
                    btn_esta_editar.setEnabled(false);
                    btn_esta_excluir.setEnabled(false);
                break;
                
            case "Excluir":
                    btn_esta_salvar.setEnabled(false);
                    btn_esta_cancelar.setEnabled(false);
                    c_esta_codigo.setEditable(false);
                    c_esta_nomeEsta.setEditable(false);
                    c_esta_cidade.setEditable(false);
                    c_esta_estado.setEditable(false);
                    c_esta_capacidade.setEditable(false);
                    btn_esta_novo.setEnabled(true);
                    btn_esta_editar.setEnabled(false);
                    btn_esta_excluir.setEnabled(false);
                break;
                
                case "Selecao":
                    btn_esta_salvar.setEnabled(false);
                    btn_esta_cancelar.setEnabled(false);
                    c_esta_codigo.setEditable(false);
                    c_esta_nomeEsta.setEditable(false);
                    c_esta_cidade.setEditable(false);
                    c_esta_estado.setEditable(false);
                    c_esta_capacidade.setEditable(false);
                    btn_esta_novo.setEnabled(true);
                    btn_esta_editar.setEnabled(true);
                    btn_esta_excluir.setEnabled(true);
                    break;
            default:System.out.println("Modo Inválido");
        }
    }
    
     public void ManipulaInterfaceJogo(){
        switch(modoJogo){
            case "Navegar":
                    btn_jogo_salvar.setEnabled(false);
                    btn_jogo_cancelar.setEnabled(false);
                    c_jogo_codigo.setEditable(false);
                    c_jogo_data.setEditable(false);
                    c_jogo_timeA.setEditable(false);
                    c_jogo_timeB.setEditable(false);
                    c_jogo_renda.setEditable(false);
                    c_jogo_publico.setEditable(false);
                    btn_jogo_novo.setEnabled(true);
                    btn_jogo_editar.setEnabled(false);
                    btn_jogo_excluir.setEnabled(false);
                    cb_jogo_estadios.setEnabled(false);
                    break;
             
            case "Novo":
                    btn_jogo_salvar.setEnabled(true);
                    btn_jogo_cancelar.setEnabled(true);
                    c_jogo_codigo.setEditable(true);
                    c_jogo_data.setEditable(true);
                    c_jogo_timeA.setEditable(true);
                    c_jogo_timeB.setEditable(true);
                    c_jogo_renda.setEditable(true);
                    c_jogo_publico.setEditable(true);
                    cb_jogo_estadios.setEnabled(true);
                    btn_jogo_novo.setEnabled(false);
                    btn_jogo_editar.setEnabled(false);
                    btn_jogo_excluir.setEnabled(false);
                    break;
                
            case "Editar":
                    btn_jogo_salvar.setEnabled(true);
                    btn_jogo_cancelar.setEnabled(true);
                    c_jogo_codigo.setEditable(true);
                    c_jogo_data.setEditable(true);
                    c_jogo_timeA.setEditable(true);
                    c_jogo_timeB.setEditable(true);
                    c_jogo_renda.setEditable(true);
                    c_jogo_publico.setEditable(true);
                    cb_jogo_estadios.setEnabled(true);
                    btn_jogo_novo.setEnabled(true);
                    btn_jogo_editar.setEnabled(false);
                    btn_jogo_excluir.setEnabled(false);
                    break;
                
            case "Excluir":
                    btn_jogo_salvar.setEnabled(false);
                    btn_jogo_cancelar.setEnabled(false);
                    c_jogo_codigo.setEditable(false);
                    c_jogo_data.setEditable(false);
                    c_jogo_timeA.setEditable(false);
                    c_jogo_timeB.setEditable(false);
                    c_jogo_renda.setEditable(false);
                    c_jogo_publico.setEditable(false);
                    cb_jogo_estadios.setEnabled(false);
                    btn_jogo_novo.setEnabled(true);
                    btn_jogo_editar.setEnabled(false);
                    btn_jogo_excluir.setEnabled(false);
                break;
                
                case "Selecao":
                    btn_jogo_salvar.setEnabled(false);
                    btn_jogo_cancelar.setEnabled(false);
                    c_jogo_codigo.setEditable(false);
                    c_jogo_data.setEditable(false);
                    c_jogo_timeA.setEditable(false);
                    c_jogo_timeB.setEditable(false);
                    c_jogo_renda.setEditable(false);
                    c_jogo_publico.setEditable(false);
                    cb_jogo_estadios.setEnabled(false);
                    btn_jogo_novo.setEnabled(true);
                    btn_jogo_editar.setEnabled(true);
                    btn_jogo_excluir.setEnabled(true);
                    break;
            default:System.out.println("Modo Inválido");
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

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_esta_estadios = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        c_esta_codigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        c_esta_nomeEsta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        c_esta_cidade = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        c_esta_estado = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        c_esta_capacidade = new javax.swing.JTextField();
        btn_esta_salvar = new javax.swing.JToggleButton();
        btn_esta_cancelar = new javax.swing.JToggleButton();
        btn_esta_novo = new javax.swing.JToggleButton();
        btn_esta_editar = new javax.swing.JToggleButton();
        btn_esta_excluir = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_jogo_jogos = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        c_jogo_codigo = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        c_jogo_data = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        c_jogo_timeA = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        c_jogo_timeB = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        c_jogo_renda = new javax.swing.JTextField();
        btn_jogo_salvar = new javax.swing.JToggleButton();
        btn_jogo_cancelar = new javax.swing.JToggleButton();
        jLabel21 = new javax.swing.JLabel();
        c_jogo_publico = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        cb_jogo_estadios = new javax.swing.JComboBox<>();
        btn_jogo_novo = new javax.swing.JToggleButton();
        btn_jogo_editar = new javax.swing.JToggleButton();
        btn_jogo_excluir = new javax.swing.JToggleButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome do Estádio", "Cidade", "Estado", "Capacidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(70);
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTabbedPane1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        tbl_esta_estadios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome  do Estádio", "Cidade", "Estado", "Capacidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_esta_estadios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_esta_estadiosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_esta_estadios);
        if (tbl_esta_estadios.getColumnModel().getColumnCount() > 0) {
            tbl_esta_estadios.getColumnModel().getColumn(0).setPreferredWidth(150);
            tbl_esta_estadios.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbl_esta_estadios.getColumnModel().getColumn(2).setPreferredWidth(200);
            tbl_esta_estadios.getColumnModel().getColumn(3).setPreferredWidth(150);
            tbl_esta_estadios.getColumnModel().getColumn(4).setPreferredWidth(200);
        }

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Estádios"));

        jLabel1.setText("Código:");

        jLabel2.setText("Nome do Estádio:");

        c_esta_nomeEsta.setText(" ");
        c_esta_nomeEsta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_esta_nomeEstaActionPerformed(evt);
            }
        });

        jLabel3.setText("Cidade:");

        c_esta_cidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_esta_cidadeActionPerformed(evt);
            }
        });

        jLabel4.setText("Estado:");

        jLabel5.setText("Capacidade:");

        c_esta_capacidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_esta_capacidadeActionPerformed(evt);
            }
        });

        btn_esta_salvar.setText("Salvar");
        btn_esta_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_esta_salvarActionPerformed(evt);
            }
        });

        btn_esta_cancelar.setText("Cancelar");
        btn_esta_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_esta_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(c_esta_nomeEsta, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                            .addComponent(c_esta_cidade)
                            .addComponent(c_esta_codigo)
                            .addComponent(c_esta_estado)
                            .addComponent(c_esta_capacidade))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btn_esta_salvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_esta_cancelar)
                        .addGap(167, 167, 167))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(c_esta_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(c_esta_nomeEsta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(c_esta_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(c_esta_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(c_esta_capacidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_esta_salvar)
                    .addComponent(btn_esta_cancelar))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        btn_esta_novo.setText("Novo");
        btn_esta_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_esta_novoActionPerformed(evt);
            }
        });

        btn_esta_editar.setText("Editar");
        btn_esta_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_esta_editarActionPerformed(evt);
            }
        });

        btn_esta_excluir.setText("Excluir");
        btn_esta_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_esta_excluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 908, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(btn_esta_novo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_esta_editar)
                .addGap(251, 251, 251)
                .addComponent(btn_esta_excluir)
                .addGap(75, 75, 75))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_esta_excluir)
                    .addComponent(btn_esta_editar)
                    .addComponent(btn_esta_novo))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(192, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Estádios", jPanel1);

        tbl_jogo_jogos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Time A", "Time B", "Renda", "Público", "Estádio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_jogo_jogos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_jogo_jogosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_jogo_jogos);
        if (tbl_jogo_jogos.getColumnModel().getColumnCount() > 0) {
            tbl_jogo_jogos.getColumnModel().getColumn(0).setPreferredWidth(150);
            tbl_jogo_jogos.getColumnModel().getColumn(1).setPreferredWidth(150);
            tbl_jogo_jogos.getColumnModel().getColumn(2).setPreferredWidth(200);
            tbl_jogo_jogos.getColumnModel().getColumn(3).setPreferredWidth(200);
            tbl_jogo_jogos.getColumnModel().getColumn(4).setPreferredWidth(150);
            tbl_jogo_jogos.getColumnModel().getColumn(5).setPreferredWidth(150);
            tbl_jogo_jogos.getColumnModel().getColumn(6).setPreferredWidth(200);
        }

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Estádios"));

        jLabel16.setText("Código:");

        jLabel17.setText("Data:");

        c_jogo_data.setText(" ");
        c_jogo_data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_jogo_dataActionPerformed(evt);
            }
        });

        jLabel18.setText("Time A:");

        c_jogo_timeA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_jogo_timeAActionPerformed(evt);
            }
        });

        jLabel19.setText("Time B:");

        jLabel20.setText("Renda:");

        c_jogo_renda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_jogo_rendaActionPerformed(evt);
            }
        });

        btn_jogo_salvar.setText("Salvar");
        btn_jogo_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_jogo_salvarActionPerformed(evt);
            }
        });

        btn_jogo_cancelar.setText("Cancelar");
        btn_jogo_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_jogo_cancelarActionPerformed(evt);
            }
        });

        jLabel21.setText("Público:");

        jLabel22.setText("Estádio:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(c_jogo_publico, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(c_jogo_data, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(c_jogo_timeA, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(c_jogo_codigo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(c_jogo_timeB, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(c_jogo_renda, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_jogo_estadios, 0, 229, Short.MAX_VALUE))
                        .addContainerGap(561, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btn_jogo_salvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_jogo_cancelar)
                        .addGap(185, 185, 185))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(c_jogo_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(c_jogo_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(c_jogo_timeA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(c_jogo_timeB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(c_jogo_renda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(c_jogo_publico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(cb_jogo_estadios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_jogo_salvar)
                    .addComponent(btn_jogo_cancelar))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        btn_jogo_novo.setText("Novo");
        btn_jogo_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_jogo_novoActionPerformed(evt);
            }
        });

        btn_jogo_editar.setText("Editar");
        btn_jogo_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_jogo_editarActionPerformed(evt);
            }
        });

        btn_jogo_excluir.setText("Excluir");
        btn_jogo_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_jogo_excluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(btn_jogo_novo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_jogo_editar)
                .addGap(258, 258, 258)
                .addComponent(btn_jogo_excluir)
                .addGap(94, 94, 94))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 898, Short.MAX_VALUE)
                    .addGap(5, 5, 5)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(275, 275, 275)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_jogo_editar)
                    .addComponent(btn_jogo_excluir)
                    .addComponent(btn_jogo_novo))
                .addGap(48, 48, 48)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(438, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Jogos", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Estádio
    
    
    private void c_esta_nomeEstaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_esta_nomeEstaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_esta_nomeEstaActionPerformed

    private void c_esta_cidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_esta_cidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_esta_cidadeActionPerformed

    private void c_esta_capacidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_esta_capacidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_esta_capacidadeActionPerformed

    private void btn_esta_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_esta_novoActionPerformed
            c_esta_codigo.setText("");
            c_esta_nomeEsta.setText("");
            c_esta_cidade.setText("");
            c_esta_estado.setText("");
            c_esta_capacidade.setText("");
           
            modoEstadios= "Novo";
            ManipulaInterfaceEstadios();
    }//GEN-LAST:event_btn_esta_novoActionPerformed

    private void btn_esta_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_esta_cancelarActionPerformed
            c_esta_codigo.setText("");
            c_esta_nomeEsta.setText("");
            c_esta_cidade.setText("");
            c_esta_estado.setText("");
            c_esta_capacidade.setText("");
            
            modoEstadios= "Navegar";
            ManipulaInterfaceEstadios();
    }//GEN-LAST:event_btn_esta_cancelarActionPerformed

    private void btn_esta_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_esta_salvarActionPerformed
            int cod = Integer.parseInt(c_esta_codigo.getText()); 
            int capa = Integer.parseInt(c_esta_capacidade.getText());
            if(modoEstadios.equals("Novo")){
                  Estadios E = new Estadios(cod,c_esta_nomeEsta.getText(),c_esta_cidade.getText(),c_esta_estado.getText(),capa);
                  ListaEstadios.add(E); 
             }else if(modoEstadios.equals("Editar")){
                  int index = tbl_esta_estadios.getSelectedRow();
                  ListaEstadios.get(index).setCodigo(cod);
                  ListaEstadios.get(index).setNomeEstadio(c_esta_nomeEsta.getText());
                  ListaEstadios.get(index).setCidade(c_esta_cidade.getText());
                  ListaEstadios.get(index).setEstado(c_esta_estado.getText());
                  ListaEstadios.get(index).setCapacidade(capa);
              }
             try {
                   Estadios.serializar(ListaEstadios);
             }catch(Exception ex){
                  
             }
                  
             LoadTableEstadios();
             modoEstadios= "Navegar";
             ManipulaInterfaceEstadios();
             c_esta_codigo.setText("");
             c_esta_nomeEsta.setText("");
             c_esta_cidade.setText("");
             c_esta_estado.setText("");
             c_esta_capacidade.setText("");
    }//GEN-LAST:event_btn_esta_salvarActionPerformed

    private void tbl_esta_estadiosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_esta_estadiosMouseClicked
        int index = tbl_esta_estadios.getSelectedRow();
        if(index>=0 && index<ListaEstadios.size()){
             Estadios E = ListaEstadios.get(index);
             c_esta_codigo.setText(String.valueOf(E.getCodigo()));
             c_esta_nomeEsta.setText(E.getNomeEstadio());
             c_esta_cidade.setText(E.getCidade());
             c_esta_estado.setText(E.getEstado());
             c_esta_capacidade.setText(String.valueOf(E.getCapacidade()));
             modoEstadios= "Selecao";
             ManipulaInterfaceEstadios();
        }     
    }//GEN-LAST:event_tbl_esta_estadiosMouseClicked

    private void btn_esta_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_esta_editarActionPerformed
            modoEstadios= "Editar";
            ManipulaInterfaceEstadios();
    }//GEN-LAST:event_btn_esta_editarActionPerformed

    private void btn_esta_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_esta_excluirActionPerformed
        int index = tbl_esta_estadios.getSelectedRow();
        if(index>=0 && index<ListaEstadios.size()){
            Estadios E = ListaEstadios.get(index);
            ListaEstadios.remove(index);   
        } 
            LoadTableEstadios();
            modoEstadios= "Navegar";
            ManipulaInterfaceEstadios();
    }//GEN-LAST:event_btn_esta_excluirActionPerformed

    
    //Jogos
    
    private void tbl_jogo_jogosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_jogo_jogosMouseClicked
                 
        int index = tbl_jogo_jogos.getSelectedRow();
            if (index >= 0 && index < ListaJogos.size()){
                Jogos J = ListaJogos.get(index);
                c_jogo_codigo.setText(String.valueOf(J.getCodigo()));
                c_jogo_data.setText(J.getData());
                c_jogo_timeA.setText(J.getTimeA());
                c_jogo_timeB.setText(J.getTimeB());
                c_jogo_renda.setText(String.valueOf(J.getRenda()));
                c_jogo_publico.setText(String.valueOf(J.getPublico()));
                modoJogo= "Selecao";
                ManipulaInterfaceJogo();   
            }
    }//GEN-LAST:event_tbl_jogo_jogosMouseClicked

    private void c_jogo_dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_jogo_dataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_jogo_dataActionPerformed

    private void c_jogo_timeAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_jogo_timeAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_jogo_timeAActionPerformed

    private void c_jogo_rendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_jogo_rendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_jogo_rendaActionPerformed

    private void btn_jogo_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_jogo_salvarActionPerformed
       if (modoJogo.equals("Novo")){
             int index = cb_jogo_estadios.getSelectedIndex();
             if (index==0){
                JOptionPane.showMessageDialog(this,"Você deve selecionar um Estádio");
                }else{
                    Jogos J = new Jogos();
                    J.setCodigo(Integer.parseInt(c_jogo_codigo.getText()));
                    J.setData(c_jogo_data.getText());
                    J.setTimeA(c_jogo_timeA.getText());
                    J.setTimeB(c_jogo_timeB.getText());
                    J.setRenda(Double.parseDouble(c_jogo_renda.getText()));
                    if(Integer.parseInt(c_jogo_publico.getText()) > ListaEstadios.get(index-1).getCapacidade()){
                       JOptionPane.showMessageDialog(null, "Capacidade excedida!");
                       return;
                    }
                    J.setPublico(Integer.parseInt(c_jogo_publico.getText()));
                    J.setEstadios(ListaEstadios.get(index-1));
                    ListaJogos.add(J);
                    ListaEstadios.get(index-1).addjJogos(J);
                  }
      }else if(modoJogo.equals("Editar")){
            int index = cb_jogo_estadios.getSelectedIndex();
            if(index == 0){
                JOptionPane.showMessageDialog(this,"Você deve selecionar um Estádio");
             }else{
                   int indexTable = tbl_jogo_jogos.getSelectedRow();
                   Jogos J = new Jogos();
                   J.setCodigo(Integer.parseInt(c_jogo_codigo.getText()));
                   J.setData(c_jogo_data.getText());
                   J.setTimeA(c_jogo_timeA.getText());
                   J.setTimeB(c_jogo_timeB.getText());
                   J.setRenda(Double.parseDouble(c_jogo_renda.getText()));
                   if(Integer.parseInt(c_jogo_publico.getText()) > ListaEstadios.get(index-1).getCapacidade()){
                       JOptionPane.showMessageDialog(null, "Capacidade excedida!");
                       return;
                   }
                   J.setPublico(Integer.parseInt(c_jogo_publico.getText())); 
                   J.setEstadios(ListaEstadios.get(index-1));
                   ListaJogos.set(indexTable, J);
                   ListaEstadios.get(index-1).addjJogos(J);
                   try{
                       Jogos.serializar(ListaJogos);
                   }catch(Exception ex){
                   
                   }
              }
          }
       try{
           Jogos.serializar(ListaJogos);
       }catch(Exception ex){
                    
       }
                    
       LoadTableJogo();
       modoJogo = "Navegar";
       ManipulaInterfaceJogo();  
    }//GEN-LAST:event_btn_jogo_salvarActionPerformed

    private void btn_jogo_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_jogo_cancelarActionPerformed
        c_jogo_codigo.setText("");
        c_jogo_data.setText("");
        c_jogo_timeA.setText("");
        c_jogo_timeB.setText("");
        c_jogo_publico.setText("");
        c_jogo_renda.setText("");
        modoJogo = "Navegar";
        ManipulaInterfaceJogo();
    }//GEN-LAST:event_btn_jogo_cancelarActionPerformed

    private void btn_jogo_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_jogo_novoActionPerformed
        c_jogo_codigo.setText("");
        c_jogo_data.setText("");
        c_jogo_timeA.setText("");
        c_jogo_timeB.setText("");
        c_jogo_publico.setText("");
        c_jogo_renda.setText("");
        modoJogo = "Novo";
        ManipulaInterfaceJogo();
    }//GEN-LAST:event_btn_jogo_novoActionPerformed

    private void btn_jogo_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_jogo_editarActionPerformed
        modoJogo = "Editar";
        ManipulaInterfaceJogo();
    }//GEN-LAST:event_btn_jogo_editarActionPerformed

    private void btn_jogo_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_jogo_excluirActionPerformed
        int index = tbl_jogo_jogos.getSelectedRow();
            if (index >= 0 && index < ListaJogos.size()){
                Jogos J = ListaJogos.get(index);
                ListaJogos.remove(index);
            }
            LoadTableJogo();
            modoJogo = "Navegar";
            ManipulaInterfaceJogo();
    }//GEN-LAST:event_btn_jogo_excluirActionPerformed

    private void jTabbedPane1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTabbedPane1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1AncestorAdded

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btn_esta_cancelar;
    private javax.swing.JToggleButton btn_esta_editar;
    private javax.swing.JToggleButton btn_esta_excluir;
    private javax.swing.JToggleButton btn_esta_novo;
    private javax.swing.JToggleButton btn_esta_salvar;
    private javax.swing.JToggleButton btn_jogo_cancelar;
    private javax.swing.JToggleButton btn_jogo_editar;
    private javax.swing.JToggleButton btn_jogo_excluir;
    private javax.swing.JToggleButton btn_jogo_novo;
    private javax.swing.JToggleButton btn_jogo_salvar;
    private javax.swing.JTextField c_esta_capacidade;
    private javax.swing.JTextField c_esta_cidade;
    private javax.swing.JTextField c_esta_codigo;
    private javax.swing.JTextField c_esta_estado;
    private javax.swing.JTextField c_esta_nomeEsta;
    private javax.swing.JTextField c_jogo_codigo;
    private javax.swing.JTextField c_jogo_data;
    private javax.swing.JTextField c_jogo_publico;
    private javax.swing.JTextField c_jogo_renda;
    private javax.swing.JTextField c_jogo_timeA;
    private javax.swing.JTextField c_jogo_timeB;
    private javax.swing.JComboBox<String> cb_jogo_estadios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tbl_esta_estadios;
    private javax.swing.JTable tbl_jogo_jogos;
    // End of variables declaration//GEN-END:variables
}
