package gui.lui.projet2024;


	import java.sql.ResultSet;
	import java.sql.DriverManager;
	import com.mysql.jdbc.Connection;
	import com.mysql.jdbc.Statement;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
	import javax.swing.table.DefaultTableModel;


	@SuppressWarnings("serial")
	public class Exposejava extends javax.swing.JFrame  implements ActionListener{

	    public DefaultTableModel tbModel;
	    public Connection con;
	    public  Exposejava () {
	        super("Gestionnaire de Contacts");
	        this.setLocation(400, 170);
	        this.pack();
	        initComponents();
	        tbModel = (DefaultTableModel) table.getModel();
	        ajouterButton.addActionListener(this);
	        //modifierButton.addActionListener(this);
	        Quitter.addActionListener(this);
	        
	        try {
	            try{
	                Class.forName("com.mysql.jdbc.Driver");
	            }catch(Exception e1){
	                
	            }
	            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gestiondebibliotheque", "root", "");
	            
	        }catch(Exception e2){
	            
	        }
	        afficherTout();
	        this.setSize(600,463);
	    }
	    
	    

	   public void afficherTout(){
	       int n = tbModel.getRowCount();
	       for(int i=0;i<n;i++){
	           tbModel.removeRow(0);
	       }
	       try {
	           Statement Statement = (Statement) con.createStatement();
	           ResultSet rsultSet = Statement.executeQuery("Select * from livre");
	           Object[] titres = new  Object[3];
	           while(rsultSet.next()){
	        	   titres[0]= rsultSet.getInt(1);
	                titres[1]=rsultSet.getString(2);
	                titres[2]=rsultSet.getString(3);
	                        
	                
	                tbModel.addRow(titres);
	           }
	       }catch(Exception e){
	           
	       }
	       
	   }
	    @SuppressWarnings("unchecked")
	    // <editor-fold defaultstate="collapsed" desk="Generated Code">//GEN-BEGIN:initComponents
	    private void initComponents() {

	        jPopupMenu1 = new javax.swing.JPopupMenu();
	        jPanel1 = new javax.swing.JPanel();
	        iSBNField = new javax.swing.JTextField();
	        jLabel1 = new javax.swing.JLabel();
	        jLabel2 = new javax.swing.JLabel();
	        titreField = new javax.swing.JTextField();
	        jLabel3 = new javax.swing.JLabel();
	        idAuteurField = new javax.swing.JTextField();
	        ajouterButton = new javax.swing.JButton();
	        modifierButton = new javax.swing.JButton();
	        jScrollPane1 = new javax.swing.JScrollPane();
	        table = new javax.swing.JTable();
	        jMenuBar1 = new javax.swing.JMenuBar();
	        jMenu1 = new javax.swing.JMenu();
	        Quitter = new javax.swing.JCheckBoxMenuItem();
	        jMenu2 = new javax.swing.JMenu();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

	        jLabel1.setText("ISBN");

	        jLabel2.setText("titre");

	        jLabel3.setText("idAuteur");

	        ajouterButton.setText("Ajouter");

	        table.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {

	            },
	            new String [] {
	                "ISBN", "Titre" ,"IdAuteur"
	            }
	        ));
	        table.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	                tableMouseClicked(evt);
	            }
	        });
	        jScrollPane1.setViewportView(table);

	        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addGap(40, 40, 40)
	                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jLabel1)
	                            .addComponent(jLabel2)
	                            .addComponent(jLabel3))
	                        .addGap(18, 18, 18)
	                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
	                            .addComponent(titreField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
	                            .addComponent(iSBNField, javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(idAuteurField))
	                        .addGap(40, 40, 40)
	                        .addComponent(ajouterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addGap(25, 25, 25)
	                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap(19, Short.MAX_VALUE))
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addGap(23, 23, 23)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(iSBNField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel1)
	                    .addComponent(ajouterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(23, 23, 23)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(titreField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel2))
	                .addGap(23, 23, 23)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(idAuteurField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel3))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(208, Short.MAX_VALUE))
	        );

	        jMenu1.setText("Option");

	        Quitter.setSelected(true);
	        Quitter.setText("Quitter");
	        jMenu1.add(Quitter);

	        jMenuBar1.add(jMenu1);

	        jMenu2.setText("Aide");
	        jMenuBar1.add(jMenu2);

	        setJMenuBar(jMenuBar1);

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(0, 0, Short.MAX_VALUE))
	        );

	        pack();
	    }// </editor-fold>//GEN-END:initComponents

	    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked

	    }//GEN-LAST:event_tableMouseClicked

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
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(Exposejava.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(Exposejava.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(Exposejava.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(Exposejava.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	        //</editor-fold>

	        /* Create and display the form */
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new  Exposejava().setVisible(true);
	            }
	        });
	    }

	    // Variables declaration - do not modify//GEN-BEGIN:variables
	    private javax.swing.JCheckBoxMenuItem Quitter;
	    private javax.swing.JButton ajouterButton;
	    private javax.swing.JButton modifierButton;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JMenu jMenu1;
	    private javax.swing.JMenu jMenu2;
	    private javax.swing.JMenuBar jMenuBar1;
	    private javax.swing.JPanel jPanel1;
	    private javax.swing.JPopupMenu jPopupMenu1;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JTextField iSBNField;
	    private javax.swing.JTextField titreField;
	    private javax.swing.JTextField idAuteurField;
	    private javax.swing.JTable table;
	    // End of variables declaration//GEN-END:variables

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        if(e.getSource()==ajouterButton){
	                               
	           System.out.println("selamm:");
	            if(!iSBNField.getText().equals("") && !titreField.getText().equals("") && !idAuteurField.getText().equals("")){
	                 
	                
	                System.out.println("khedjetou 1");
	                String matric=iSBNField.getText();
	                System.out.println("matric: "+matric);
	                boolean wror=false;
	                char[] chara=matric.toCharArray();
	                for(int i=0;i<chara.length;i++){
	                  String ss=String.valueOf(chara[i]);
	                  String ler="0123456789";
	                  if(!ler.contains(ss)){
	                      wror=true;
	                  }
	                }
	                int iSBN=0;
	                if(!wror){
	                 iSBN = Integer.parseInt(iSBNField.getText());   
	                }
	                int idAuteur=0;
	                
					if(!wror) {
	                	idAuteur= Integer.parseInt(idAuteurField.getText());
	                }
	                
	                
	                   
	                             
	                String titre = titreField.getText();
	                titre= titre.trim();
	               
	                                
	                if( titre.isEmpty()){
	                    System.out.println("khedjetou 2");
	                    
	                }
	                else{
	                    String queryCheck = "Select * from etudiant where matricule="+iSBN;
	                    String query = "Insert into etudiant (matricule,nom,prenom) values ("+iSBN+",'"+titre+"','"+idAuteur+"');";
	                    try {
	                        Statement stmt = (Statement) con.createStatement();
	                        ResultSet rs = stmt.executeQuery(queryCheck);
	                        int check = 0;
	                        while(rs.next()){
	                            check++;
	                        }
	                        
	                        if(check==0){
	                            stmt.executeUpdate(query);
	                            JOptionPane.showMessageDialog(this, "Etudiant Ajouté");

	                        }
	                          
	                     
	                     
	                    }catch(Exception e3){

	              }
	                    afficherTout();  
	                    vider();
	                }
	            }
	            
	            
	            if(e.getSource()==Quitter){
	                this.dispose();
	            }
	            
	            
	            
	            else{
	                                 JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs");
	                                } 
	           
	            
	            
	       }       
	     
	        else{
	                                                          JOptionPane.showMessageDialog(this,"Cet matricule contient des erreurs");   
	 
	                } 

	         
	    }
	    public void vider(){
	        iSBNField.setText("");
	        titreField.setText("");  
	        idAuteurField.setText("");
	         
	    
	}
	}      

