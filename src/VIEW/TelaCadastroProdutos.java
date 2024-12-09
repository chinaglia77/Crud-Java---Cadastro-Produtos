/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VIEW;

import DAO.ProdutoDAO;
import DTO.ProdutoDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pichau
 */
public class TelaCadastroProdutos extends javax.swing.JFrame {

    public TelaCadastroProdutos() {
        initComponents();
        configurarTabela();
    }

    ProdutoDTO proDTO = new ProdutoDTO();
    ProdutoDAO proDAO = new ProdutoDAO();

    private void preencherTabela() {
        try {
            ProdutoDAO proDAO = new ProdutoDAO();
            ArrayList<ProdutoDTO> listaProdutos = proDAO.listarProdutos();

            DefaultTableModel modelo = (DefaultTableModel) tabelaPrdoutos.getModel();
            modelo.setRowCount(0);

            if (listaProdutos.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Tabela vazia adicione um produto para a tabela");
            }

            for (int i = 0; i < listaProdutos.size(); i++) {
                // Adicionando a linha na tabela corretamente
                modelo.addRow(new Object[]{
                    listaProdutos.get(i).getIdProduto(),
                    listaProdutos.get(i).getNomeProduto(),
                    listaProdutos.get(i).getCategoriaProduto(),
                    listaProdutos.get(i).getQtdEstoqueProduto(),
                    listaProdutos.get(i).getPreco(),});
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar os produtos");
        }
        
    }

    private void atualizarTabelaComResultado() {
        try {
            ProdutoDTO proDTO = new ProdutoDTO();
            ProdutoDAO proDAO = new ProdutoDAO();

            proDTO.setIdProduto(Integer.parseInt(txtPesquisarProdutos.getText()));
            ArrayList<ProdutoDTO> produtosPesquisados = proDAO.pesquisarProduto(proDTO);

            DefaultTableModel modelo = (DefaultTableModel) tabelaPrdoutos.getModel();
            modelo.setRowCount(0);

            if (produtosPesquisados.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum produto encontrado com o ID informado.", "Pesquisar produtos", JOptionPane.WARNING_MESSAGE);
                return;
            }

            for (int i = 0; i < produtosPesquisados.size(); i++) {
                modelo.addRow(new Object[]{
                    produtosPesquisados.get(i).getIdProduto(),
                    produtosPesquisados.get(i).getNomeProduto(),
                    produtosPesquisados.get(i).getCategoriaProduto(),
                    produtosPesquisados.get(i).getQtdEstoqueProduto(),
                    produtosPesquisados.get(i).getPreco(),});
                JOptionPane.showMessageDialog(null, "Produto encontrado com sucesso", "Pesquisar produtos", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar produtos");
        }
    }
              
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIdProduto = new javax.swing.JTextField();
        txtNomeProduto = new javax.swing.JTextField();
        txtCategoriaProduto = new javax.swing.JTextField();
        txtPreco = new javax.swing.JTextField();
        txtQuantidadeProduto = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPrdoutos = new javax.swing.JTable();
        btnPesquisarProdutos = new javax.swing.JButton();
        txtPesquisarProdutos = new javax.swing.JTextField();
        btnListarTabelaPrdutos = new javax.swing.JButton();
        btnAlterarProduto = new javax.swing.JButton();
        txtExcluirProduto = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnLimparCampos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nome Produto");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Categoria");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Preço");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Quantidade Estoque");

        txtIdProduto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIdProduto.setMargin(new java.awt.Insets(0, 4, 0, 0));
        txtIdProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdProdutoActionPerformed(evt);
            }
        });

        txtNomeProduto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNomeProduto.setMargin(new java.awt.Insets(0, 4, 0, 0));

        txtCategoriaProduto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCategoriaProduto.setMargin(new java.awt.Insets(0, 4, 0, 0));

        txtPreco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPreco.setMargin(new java.awt.Insets(0, 4, 0, 0));
        txtPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecoActionPerformed(evt);
            }
        });

        txtQuantidadeProduto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtQuantidadeProduto.setMargin(new java.awt.Insets(0, 4, 0, 0));

        btnCadastrar.setBackground(new java.awt.Color(0, 102, 0));
        btnCadastrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icon-registrar.png"))); // NOI18N
        btnCadastrar.setText("CADASTRAR");
        btnCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        tabelaPrdoutos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tabelaPrdoutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID PRODUTO", "NOME PRODUTO", "CATEGORIA", "QUANTIDADE ESTOQUE", "PRECO"
            }
        ));
        tabelaPrdoutos.setRowHeight(30);
        jScrollPane1.setViewportView(tabelaPrdoutos);

        btnPesquisarProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icon-pesquisar.png"))); // NOI18N
        btnPesquisarProdutos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPesquisarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarProdutosActionPerformed(evt);
            }
        });

        txtPesquisarProdutos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtPesquisarProdutos.setForeground(new java.awt.Color(0, 0, 0));
        txtPesquisarProdutos.setMargin(new java.awt.Insets(0, 4, 0, 0));
        txtPesquisarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisarProdutosActionPerformed(evt);
            }
        });

        btnListarTabelaPrdutos.setBackground(new java.awt.Color(0, 102, 255));
        btnListarTabelaPrdutos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnListarTabelaPrdutos.setForeground(new java.awt.Color(255, 255, 255));
        btnListarTabelaPrdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icon-listar.png"))); // NOI18N
        btnListarTabelaPrdutos.setText("LISTAR PRODUTOS");
        btnListarTabelaPrdutos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnListarTabelaPrdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarTabelaPrdutosActionPerformed(evt);
            }
        });

        btnAlterarProduto.setBackground(new java.awt.Color(153, 153, 0));
        btnAlterarProduto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAlterarProduto.setForeground(new java.awt.Color(255, 255, 255));
        btnAlterarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icon-atualizar.png"))); // NOI18N
        btnAlterarProduto.setText("ALTERAR PRODUTOS");
        btnAlterarProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlterarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarProdutoActionPerformed(evt);
            }
        });

        txtExcluirProduto.setBackground(new java.awt.Color(204, 0, 0));
        txtExcluirProduto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtExcluirProduto.setForeground(new java.awt.Color(255, 255, 255));
        txtExcluirProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icon-excluir.png"))); // NOI18N
        txtExcluirProduto.setText("APAGAR PRODUTO");
        txtExcluirProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtExcluirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtExcluirProdutoActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/img-logo-cantinhdoSabor.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 60)); // NOI18N
        jLabel7.setText(" TELA DE CADASTRO CANTINHO");

        btnLimparCampos.setBackground(new java.awt.Color(255, 255, 255));
        btnLimparCampos.setForeground(new java.awt.Color(0, 0, 0));
        btnLimparCampos.setText("LIMPAR CAMPOS");
        btnLimparCampos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparCamposActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtExcluirProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnListarTabelaPrdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAlterarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(txtPesquisarProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 779, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnPesquisarProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnLimparCampos))
                                        .addComponent(txtNomeProduto)
                                        .addComponent(txtCategoriaProduto)
                                        .addComponent(txtQuantidadeProduto)
                                        .addComponent(jLabel4)
                                        .addComponent(txtPreco))
                                    .addComponent(jLabel6)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 884, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPesquisarProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesquisarProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCategoriaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQuantidadeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtExcluirProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnListarTabelaPrdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAlterarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void configurarTabela() {
        // Adicionando o MouseListener para capturar o clique na tabela
        tabelaPrdoutos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                // Obter a linha selecionada na tabela
                int linhaSelecionada = tabelaPrdoutos.getSelectedRow();
                System.out.println(linhaSelecionada);

                if (linhaSelecionada != -1) {
                    // Carregar os dados da linha clicada nos campos de texto
                    txtIdProduto.setText(tabelaPrdoutos.getValueAt(linhaSelecionada, 0).toString());
                    txtNomeProduto.setText(tabelaPrdoutos.getValueAt(linhaSelecionada, 1).toString());
                    txtCategoriaProduto.setText(tabelaPrdoutos.getValueAt(linhaSelecionada, 2).toString());
                    txtQuantidadeProduto.setText(tabelaPrdoutos.getValueAt(linhaSelecionada, 3).toString());
                    txtPreco.setText(tabelaPrdoutos.getValueAt(linhaSelecionada, 4).toString());
                }
            }
        });
    }
    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {                                             
        ProdutoDTO proDTO = new ProdutoDTO();
        ProdutoDAO proDAO = new ProdutoDAO();

        try {
            if (verificarCampos()) {
                JOptionPane.showMessageDialog(null, "Digite todos os campos", "Tela cadastro", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            int idProduto;
            try {
                idProduto = Integer.parseInt(txtIdProduto.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ID inválido. Digite um número inteiro válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                limparCampos();
                return;
            }
            proDTO.setIdProduto(idProduto);

            if (proDAO.verificarID(proDTO)) {
                JOptionPane.showMessageDialog(null, "ID " + proDTO.getIdProduto() + " já possui cadastro", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Preenchimento dos outros campos
            try {
                proDTO.setNomeProduto(txtNomeProduto.getText().trim());
                proDTO.setCategoriaProduto(txtCategoriaProduto.getText().trim());
                proDTO.setPreco(Double.parseDouble(txtPreco.getText()));
                proDTO.setQtdEstoqueProduto(Integer.parseInt(txtQuantidadeProduto.getText()));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erro ao preencher os dados. Verifique os valores de preço e quantidade.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Cadastrar produto e atualizar tabela
            proDAO.cadastrarProduto(proDTO);
            preencherTabela();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        limparCampos();
    }                                            

    private void btnPesquisarProdutosActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        if (verificarCampoPesquisa()) {
            JOptionPane.showMessageDialog(null, "Por favor informe o ID ");
        } else {
            atualizarTabelaComResultado();
        }
    }                                                    

    private void btnListarTabelaPrdutosActionPerformed(java.awt.event.ActionEvent evt) {                                                       
        preencherTabela();
    }                                                      

    private void btnAlterarProdutoActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        alterarCampos();
        preencherTabela();
        limparCampos();
    }                                                 


    private void txtExcluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        exluirProdutoSelecionado();
    }                                                 

    private void txtPrecoActionPerformed(java.awt.event.ActionEvent evt) {                                         
    }                                        

    private void txtIdProdutoActionPerformed(java.awt.event.ActionEvent evt) {                                             
    }                                            

    private void txtPesquisarProdutosActionPerformed(java.awt.event.ActionEvent evt) {                                                     

    }                                                    

    private void btnLimparCamposActionPerformed(java.awt.event.ActionEvent evt) {                                                
       limparCampos();
    }                                               

    private void exluirProdutoSelecionado() {
        int selectedRow = tabelaPrdoutos.getSelectedRow();

        if (selectedRow != -1) { // Verifica se há uma linha selecionada
            int idProduto = (int) tabelaPrdoutos.getValueAt(selectedRow, 0); // Supondo que a coluna 0 contém o ID
            String nomeProduto = (String) tabelaPrdoutos.getValueAt(selectedRow, 1); // Supondo que a coluna 1 contém o nome

            int confirmacao = JOptionPane.showConfirmDialog(null,
                    "Deseja realmente excluir o produto " + nomeProduto + "?",
                    "Confirmação",
                    JOptionPane.YES_NO_OPTION);

            if (confirmacao == JOptionPane.YES_OPTION) {
                try {
                    ProdutoDTO produtoDTO = new ProdutoDTO();
                    produtoDTO.setIdProduto(idProduto);
                    produtoDTO.setNomeProduto(nomeProduto);

                    proDAO.excluirProdutos(produtoDTO);

                    ((DefaultTableModel) tabelaPrdoutos.getModel()).removeRow(selectedRow);

                    JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!");
                    limparCampos();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao excluir o produto: " + e.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto na tabela para excluir.");
        }
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroProdutos().setVisible(true);
            }
        });
    }

    private Boolean verificarCampos() {
        return txtIdProduto.getText().trim().isEmpty()
                || txtNomeProduto.getText().trim().isEmpty()
                || txtCategoriaProduto.getText().trim().isEmpty()
                || txtQuantidadeProduto.getText().trim().isEmpty()
                || txtPreco.getText().trim().isEmpty();

    }

    private Boolean verificarCampoPesquisa() {
        return txtPesquisarProdutos.getText().trim().isEmpty();
    }

    private void limparCampos() {
        txtIdProduto.setText("");
        txtNomeProduto.setText("");
        txtCategoriaProduto.setText("");
        txtQuantidadeProduto.setText("");
        txtPreco.setText("");
    }

    private void alterarCampos() {

        try {
            if (verificarCampos()) {
                JOptionPane.showMessageDialog(null, "Digite todos os campos", "Tela cadastro", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            int idProduto;
            try {
                idProduto = Integer.parseInt(txtIdProduto.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ID inválido. Digite um número inteiro válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            proDTO.setIdProduto(idProduto);

            try {
                proDTO.setNomeProduto(txtNomeProduto.getText().trim());
                proDTO.setCategoriaProduto(txtCategoriaProduto.getText().trim());
                proDTO.setPreco(Double.parseDouble(txtPreco.getText()));
                proDTO.setQtdEstoqueProduto(Integer.parseInt(txtQuantidadeProduto.getText()));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erro ao preencher os dados. Verifique os valores de preço e quantidade.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            ProdutoDAO proDAO = new ProdutoDAO();
            proDAO.alterarProduto(proDTO);
            limparCampos();

            JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAlterarProduto;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnLimparCampos;
    private javax.swing.JButton btnListarTabelaPrdutos;
    private javax.swing.JButton btnPesquisarProdutos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaPrdoutos;
    private javax.swing.JTextField txtCategoriaProduto;
    private javax.swing.JButton txtExcluirProduto;
    private javax.swing.JTextField txtIdProduto;
    private javax.swing.JTextField txtNomeProduto;
    private javax.swing.JTextField txtPesquisarProdutos;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQuantidadeProduto;
    // End of variables declaration                   
}

