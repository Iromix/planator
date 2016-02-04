/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.List;

import database.ITag;
import planat0r.Engine;
import planat0r.IEngine;
import planat0r.IQuestion;
import planat0r.Planator;
import planat0r.Question;

/**
 *
 * @author ima3k
 */
public class QuestionJFrame extends javax.swing.JFrame {

    List<Question> questions;    
    int questionNumber = 0;
    /**
     * Creates new form QuestionJFrame
     */
    public QuestionJFrame() {
        initComponents();
        
        
        questions = Planator.engine.getQuestions();        
        
        
        if (questions!=null) {
            jButton1.setText( questions.get(questionNumber).getLeftText() );
            jButton2.setText( questions.get(questionNumber).getRightText() );
        }                 
        
    }

    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Co wolisz?");

        jButton1.setText("leftAnswer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("wrightAnswer");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(26, 26, 26)
                        .addComponent(jButton2)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //clikc leftAnswer
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        answerLeftQuestion(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    //click rightAnswer
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        answerLeftQuestion(false);
    }//GEN-LAST:event_jButton2ActionPerformed
   
    
    void answerLeftQuestion(boolean leftAnswer)
    {
        if (leftAnswer)
            questions.get(questionNumber).leftPushed();
        else
            questions.get(questionNumber).rightPushed();
        
        questionNumber++;
        
        if (questionNumber<questions.size()) {
            jButton1.setText( questions.get(questionNumber).getLeftText() );
            jButton2.setText( questions.get(questionNumber).getRightText() );
        }
        else {            
            runResourceFrame();
        }            
    }

    void runResourceFrame()
    {
        this.setVisible(false);
        this.dispose();
        List<ITag> tags = Planator.engine.submitAnswers(questions);		        		        
        
        new ResourcesjFrame( tags ).setVisible(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
