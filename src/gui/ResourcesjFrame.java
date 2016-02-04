/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import database.ITag;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;


import planat0r.Planator;

/**
 *
 * @author ima3k
 */
public class ResourcesjFrame extends javax.swing.JFrame {

	javax.swing.GroupLayout layout;
    List<ITag> tags;
    List<ITag> returnTags;
    ArrayList<JCheckBox> checkboxes = new ArrayList<JCheckBox>();
    /**
     * Creates new form ResourcesjFrame
     */
    public ResourcesjFrame( List<ITag> tags) {
    	
    	this.tags = tags;
        initComponents();
        
                
        createCheckboxes();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("time");

        jLabel2.setText("money");

        jLabel3.setText("add tags");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 267, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 93, Short.MAX_VALUE)
        );

        jButton1.setText("generate activities");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1)
                    .addComponent(jLabel3)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton1)
                .addContainerGap(23, Short.MAX_VALUE))
        );	      
        
        pack();
    }// </editor-fold>//GEN-END:initComponents

    JCheckBox checkbox;
    void createCheckboxes() {           	 
    	
    	
    	jPanel1.setLayout(new GridBagLayout());
    	GridBagConstraints c = new GridBagConstraints();

    	int row = 0, rowMax = 3;
    	int column = 0;
        for (int i=0; i< tags.size(); i++) {
        	        	
            checkbox = new JCheckBox();  
            checkbox.setName(tags.get(i).getName());
            checkbox.setLabel(tags.get(i).getName());
            
            c.gridx = row++;
            c.gridy = column;
            
            if (row==rowMax) {
            	row = 0;
            	column++;
            }
            	
            jPanel1.add(checkbox,c);
            checkboxes.add(checkbox);
                        
        }                                      
                
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        generateActivities();
        runActivationsjFrame();
    }//GEN-LAST:event_jButton1ActionPerformed

    void generateActivities() {
        //Date date = Date.parse( TextField2.getText() );
        //int money = Integer.parseInt( jTextField2.getText() );
        returnTags = new ArrayList<ITag>();
        
        for (int i=0; i<checkboxes.size(); i++) {
            
           if (checkboxes.get(i).isSelected()) {              	   
               for (int j=0; j< tags.size(); j++) {                  	                   	  
                   if ( tags.get(j).getName().equals( checkboxes.get(i).getName() )) 
                   {                	  
                       returnTags.add( tags.get(j) );
                       break;
                   }
               }
           }           
        }
                        
        /*for (int i=0;i<returnTags.size();i++)
        	System.out.println(returnTags.get(i).getName());*/
                        
        Planator.engine.submitTags(returnTags);
    }
    
    void runActivationsjFrame()
    {
        this.setVisible(false);
        this.dispose();
        
        new ActivationsjFrame().setVisible(true);
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
