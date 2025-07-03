package view;

import javax.swing.JOptionPane;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import comum.conexaoMongo;
import controller.CandidatoController;
import controller.VotoController;
import javax.swing.ImageIcon;
import model.Candidato;

public class urnaGUI extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(urnaGUI.class.getName());
    private VotoController votoController = new VotoController();
    private int proximoLabel = 1;
    private CandidatoController candidatoController = new CandidatoController();
    private boolean votacaoEncerrada = false;
    private final String SENHA_ADMIN = "99999";
    private boolean primeiraVotacao = true;
    private String ultimoPartidoExibido = "";
    private String numeroDigitadoAnterior = "";
    
    public urnaGUI() {
        initComponents();
        lblNomeCandidato.setVisible(false);
        lblPartidoCandidato.setVisible(false);
        lblNumeroCandidato.setVisible(false);
        lblFotoCandidato.setIcon(null);
        limparVotosAnteriores();
        limparCamposCandidato();
    }
    
    private void registrarVoto(String nomeCandidato, String numeroCandidato, String partidoCandidato) {
    try {
        MongoCollection<Document> votos = conexaoMongo.getDatabase()
            .getCollection("votos");
            
        Document voto = new Document()
            .append("candidato", nomeCandidato)
            .append("numero", numeroCandidato)
            .append("partido", partidoCandidato);
        
        votos.insertOne(voto);
        lblStatus.setText("Voto registrado com sucesso!");
    } catch (Exception e) {
        lblStatus.setText("Erro ao registrar voto");
        System.err.println("Erro ao registrar voto: " + e.getMessage());
    }
}

    private void atualizarLabel(String numero) {
        switch (proximoLabel) {
            case 1:
                label1.setText(numero);
                break;
            case 2:
                label2.setText(numero);
                break;
            case 3:
                label3.setText(numero);
                break;
            case 4:
                label4.setText(numero);
                break;
            case 5:
                label5.setText(numero);
                break;
            default:
                return;
        }
        proximoLabel++; // Avança para o próximo label
        
         atualizarExibicaoCandidato();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label5 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        lblNumeroCandidato = new javax.swing.JLabel();
        lblNomeCandidato = new javax.swing.JLabel();
        lblPartidoCandidato = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblFotoCandidato = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btn0 = new javax.swing.JButton();
        btnBranco = new javax.swing.JButton();
        btnCorrige = new javax.swing.JButton();
        btnConfirma = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnListaCandidatos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Vereador");

        label1.setAlignmentX(4.0F);
        label1.setAlignmentY(4.0F);
        label1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        label2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        label5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        label4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        label3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblNumeroCandidato.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNumeroCandidato.setText("jLabel9");

        lblNomeCandidato.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNomeCandidato.setText("jLabel9");

        lblPartidoCandidato.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPartidoCandidato.setText("jLabel9");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Seu Voto Para");

        lblFotoCandidato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/golfe.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNumeroCandidato)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPartidoCandidato)
                                    .addComponent(lblNomeCandidato))
                                .addGap(0, 139, Short.MAX_VALUE))
                            .addComponent(lblStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFotoCandidato))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(157, 157, 157)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNumeroCandidato)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNomeCandidato)
                        .addGap(32, 32, 32)
                        .addComponent(lblPartidoCandidato)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblFotoCandidato))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        btn1.setText("1");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn2.setText("2");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btn3.setText("3");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btn4.setText("4");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        btn5.setText("5");
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });

        btn6.setText("6");
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });

        btn7.setText("7");
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });

        btn8.setText("8");
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });

        btn9.setText("9");
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });

        btn0.setText("0");
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });

        btnBranco.setText("BRANCO");
        btnBranco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrancoActionPerformed(evt);
            }
        });

        btnCorrige.setBackground(new java.awt.Color(255, 153, 0));
        btnCorrige.setText("CORRIGE");
        btnCorrige.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCorrigeActionPerformed(evt);
            }
        });

        btnConfirma.setBackground(new java.awt.Color(0, 204, 51));
        btnConfirma.setText("CONFIRMA");
        btnConfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btn7, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                            .addComponent(btn4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btn0, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnConfirma))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBranco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCorrige)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn1)
                    .addComponent(btn2)
                    .addComponent(btn3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn4)
                    .addComponent(btn6)
                    .addComponent(btn5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn7)
                    .addComponent(btn8)
                    .addComponent(btn9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn0)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBranco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCorrige, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnConfirma, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLabel8.setText("Para visualização dos candidatos e partidos, aperte o botão!!!");

        btnListaCandidatos.setText("Lista dos Candidatos");
        btnListaCandidatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaCandidatosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(248, 248, 248)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(jLabel8)))
                        .addGap(18, 18, 18)
                        .addComponent(btnListaCandidatos)
                        .addGap(0, 693, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(622, 622, 622))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnListaCandidatos)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        atualizarLabel("7");
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        atualizarLabel("1");
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
       atualizarLabel("2");
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        atualizarLabel("3");
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        atualizarLabel("5");
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        atualizarLabel("6");
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        atualizarLabel("9");
    }//GEN-LAST:event_btn9ActionPerformed

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed
        atualizarLabel("0");
    }//GEN-LAST:event_btn0ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
       atualizarLabel("8");
    }//GEN-LAST:event_btn8ActionPerformed

    private void btnListaCandidatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaCandidatosActionPerformed
      listaCandidatos listaFrame = new listaCandidatos();
      
      listaFrame.setVisible(true);
      
    }//GEN-LAST:event_btnListaCandidatosActionPerformed

    private void btnCorrigeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCorrigeActionPerformed
    // Limpa os números
    label1.setText("");
    label2.setText("");
    label3.setText("");
    label4.setText("");
    label5.setText("");
    lblStatus.setText("");
        
    
    label1.setVisible(true);
    label2.setVisible(true);
    label3.setVisible(true);
    label4.setVisible(true);
    label5.setVisible(true);
    
    // Limpa os dados do candidato
    lblNomeCandidato.setText("");
    lblPartidoCandidato.setText("");
    lblNumeroCandidato.setText("");
    lblFotoCandidato.setIcon(null);
   
    // Reinicia o contador 
    proximoLabel = 1;
    
    
    }//GEN-LAST:event_btnCorrigeActionPerformed

    private void btnBrancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrancoActionPerformed
    //Limpa 
    label1.setText("");
    label2.setText("");
    label3.setText("");
    label4.setText("");
    label5.setText("");
    
    proximoLabel = 1; 

    if (votoController.registrarVotoBranco()) {
        lblStatus.setText("VOTO EM BRANCO REGISTRADO");
    } else {
        lblStatus.setText("Erro ao registrar voto branco");
    }
    }//GEN-LAST:event_btnBrancoActionPerformed

    private void btnConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmaActionPerformed
    String numeroDigitado = label1.getText() + label2.getText() + label3.getText() + label4.getText() + label5.getText();
    
    // Verifica se é a ADM
    if (numeroDigitado.equals(SENHA_ADMIN)) {
        votacaoEncerrada = true;
        exibirRelatorio();
        desabilitarUrna();
        return;
    }
    
    if (votoController.candidatoExiste(numeroDigitado)) {
        // Atualiza a interface
        exibirDadosCandidato(numeroDigitado);
        
        // Registra o voto válido
        if (votoController.registrarVotoValido(numeroDigitado)) {
            lblStatus.setText("Voto confirmado!");
        } else {
            lblStatus.setText("Erro ao registrar voto");
        }
    } else {
        // Registra voto nulo
        if (votoController.registrarVotoNulo(numeroDigitado)) {
            lblStatus.setText("Candidato não existe - VOTO NULO");
        } else {
            lblStatus.setText("Erro ao registrar voto nulo");
        }
    }
}

    private void exibirDadosCandidato(String numeroCandidato) {
    // Oculta os labels do numero
    label1.setVisible(false);
    label2.setVisible(false);
    label3.setVisible(false);
    label4.setVisible(false);
    label5.setVisible(false);

    lblNomeCandidato.setVisible(true);
    lblPartidoCandidato.setVisible(true);
    lblNumeroCandidato.setVisible(true);

    Candidato candidato = votoController.getCandidato(numeroCandidato);

    if (candidato != null) {
        lblNumeroCandidato.setText("Número: " + candidato.getNumero());
        lblNomeCandidato.setText("Nome: " + candidato.getNome());
        lblPartidoCandidato.setText("Partido: " + candidato.getPartido());
        lblFotoCandidato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/" + numeroCandidato + ".png")));
    } else {
        lblStatus.setText("Erro ao carregar dados do candidato.");
    }
    }//GEN-LAST:event_btnConfirmaActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        atualizarLabel("4");
    }//GEN-LAST:event_btn4ActionPerformed
private void atualizarExibicaoCandidato() {
    String numeroDigitado = label1.getText() + label2.getText() 
                         + label3.getText() + label4.getText() + label5.getText();
    
    // Se não digitou nada, limpa tudo
    if (numeroDigitado.isEmpty() || numeroDigitado.length() < numeroDigitadoAnterior.length()) {
        limparCamposCandidato();
        numeroDigitadoAnterior = numeroDigitado;
        return;
    }
    
    // Atualiza o número digitado anterior
    numeroDigitadoAnterior = numeroDigitado;
    
    // Mostra todos os campos 
    lblNomeCandidato.setVisible(true);
    lblPartidoCandidato.setVisible(true);
    lblNumeroCandidato.setVisible(true);
    lblFotoCandidato.setVisible(true);
    
    // Busca e mostra o partido assim que tiver 2 dígitos
    if (numeroDigitado.length() >= 2) {
        String prefixoPartido = numeroDigitado.substring(0, 2);
        String partido = votoController.buscarPartidoPorNumero(prefixoPartido);
        
        if (partido != null && !partido.equals(ultimoPartidoExibido)) {
            lblPartidoCandidato.setText("Partido: " + partido);
            ultimoPartidoExibido = partido;
        } else if (partido == null) {
            lblPartidoCandidato.setText("Partido: Não encontrado");
        }
    }
    
    // Busca candidato completo
    Candidato candidato = votoController.buscarCandidatoPorNumero(numeroDigitado);
    if (candidato != null) {
        lblNumeroCandidato.setText("Número: " + candidato.getNumero());
        lblNomeCandidato.setText("Nome: " + candidato.getNome());
        
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/img/" + candidato.getNumero() + ".png"));
            lblFotoCandidato.setIcon(icon);
        } catch (Exception e) {
            lblFotoCandidato.setIcon(null);
        }
    } else {
        lblNumeroCandidato.setText("");
        lblNomeCandidato.setText("");
        lblFotoCandidato.setIcon(null);
    }
    
    // Atualiza status da primeira votação
    if (primeiraVotacao && !numeroDigitado.isEmpty()) {
        primeiraVotacao = false;
    }
}
     private void verificarSenhaEncerramento() {
    String senhaDigitada = label1.getText() + label2.getText() + label3.getText() + label4.getText() + label5.getText();
    
    if (senhaDigitada.equals(SENHA_ADMIN)) {
        votacaoEncerrada = true;
        exibirRelatorio();
        desabilitarUrna();
    } else {
        lblStatus.setText("Senha incorreta");
        limparCamposCandidato();
    }
}

    private void exibirRelatorio() {
    try {
        // Gera o relatório
        String relatorio = votoController.gerarRelatorioFormatado();
        
        // Cria e exibe a tela de relatório
        relatorioVotos relatorioTela = new relatorioVotos();
        relatorioTela.exibirRelatorioCompleto(relatorio);
        relatorioTela.setVisible(true);
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, 
            "Erro ao exibir relatório: " + e.getMessage(),
            "Erro", 
            JOptionPane.ERROR_MESSAGE);
    }
}

    private void limparVotosAnteriores() {
    try {
        conexaoMongo.getDatabase().getCollection("votos").deleteMany(new Document());
        System.out.println("Votos anteriores limpos!");
    } catch (Exception e) {
        System.err.println("Erro ao limpar votos: " + e.getMessage());
    }
}
    private void desabilitarUrna() {
    btn0.setEnabled(false);
    btn1.setEnabled(false);
    btn2.setEnabled(false);
    btn3.setEnabled(false);
    btn4.setEnabled(false);
    btn5.setEnabled(false);
    btn6.setEnabled(false);
    btn7.setEnabled(false);
    btn8.setEnabled(false);
    btn9.setEnabled(false);
    btnBranco.setEnabled(false);
    btnCorrige.setEnabled(false);
    btnConfirma.setEnabled(false);
    
    lblStatus.setText("VOTAÇÃO ENCERRADA");
}
    
    private void limparCamposCandidato() {
    lblNomeCandidato.setText("");
    lblPartidoCandidato.setText("");
    lblNumeroCandidato.setText("");
    lblFotoCandidato.setIcon(null);
    ultimoPartidoExibido = "";
    numeroDigitadoAnterior = "";
    
    // Mantém os campos visíveis
    lblNomeCandidato.setVisible(true);
    lblPartidoCandidato.setVisible(true);
    lblNumeroCandidato.setVisible(true);
    lblFotoCandidato.setVisible(true);
}

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new urnaGUI().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnBranco;
    private javax.swing.JButton btnConfirma;
    private javax.swing.JButton btnCorrige;
    private javax.swing.JButton btnListaCandidatos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel lblFotoCandidato;
    private javax.swing.JLabel lblNomeCandidato;
    private javax.swing.JLabel lblNumeroCandidato;
    private javax.swing.JLabel lblPartidoCandidato;
    private javax.swing.JLabel lblStatus;
    // End of variables declaration//GEN-END:variables
}
