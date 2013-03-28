/*    */ package it.bertolottipf.MD5sumJ;
/*    */ 
/*    */ import java.awt.GridLayout;
/*    */ import javax.swing.BoxLayout;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JTextField;
/*    */ 
/*    */ public class SecondView extends JPanel
/*    */ {
/*    */   public RadioChoise rc;
/*    */   public JButton openFile;
/*    */   public JButton openFileMd5;
/*    */   public JTextField trueMd5;
/*    */   public JTextField aspectedMd5;
/*    */   public JTextField result;
/*    */ 
/*    */   public SecondView()
/*    */   {
/* 23 */     setLayout(new BoxLayout(this, 1));
/*    */ 
/* 25 */     this.rc = new RadioChoise();
/* 26 */     add(this.rc);
/*    */ 
/* 28 */     JPanel components = new JPanel();
/* 29 */     components.setLayout(new GridLayout(1, 3));
/* 30 */     add(components);
/*    */ 
/* 33 */     JPanel jLabels = new JPanel(new GridLayout(2, 1));
/* 34 */     components.add(jLabels);
/*    */ 
/* 36 */     JLabel trueMd5L = new JLabel("True MD5");
/* 37 */     jLabels.add(trueMd5L);
/*    */ 
/* 39 */     JLabel aspectedMd5L = new JLabel("Aspected MD5");
/* 40 */     jLabels.add(aspectedMd5L);
/*    */ 
/* 43 */     JPanel jTextFields = new JPanel(new GridLayout(2, 1));
/* 44 */     components.add(jTextFields);
/*    */ 
/* 46 */     this.trueMd5 = new JTextField();
/* 47 */     this.trueMd5.setEditable(false);
/* 48 */     jTextFields.add(this.trueMd5);
/*    */ 
/* 50 */     this.aspectedMd5 = new JTextField();
/* 51 */     this.aspectedMd5.setEditable(false);
/* 52 */     jTextFields.add(this.aspectedMd5);
/*    */ 
/* 55 */     JPanel jButtons = new JPanel(new GridLayout(2, 1));
/* 56 */     components.add(jButtons);
/*    */ 
/* 58 */     this.openFile = new JButton("Open file");
/* 59 */     jButtons.add(this.openFile);
/*    */ 
/* 61 */     this.openFileMd5 = new JButton("Open file MD5");
/* 62 */     jButtons.add(this.openFileMd5);
/*    */ 
/* 65 */     this.result = new JTextField();
/* 66 */     this.result.setHorizontalAlignment(0);
/* 67 */     this.result.setEditable(false);
/* 68 */     add(this.result);
/*    */   }
/*    */ 
/*    */   public void reset()
/*    */   {
/* 73 */     this.trueMd5.setText(null);
/* 74 */     this.aspectedMd5.setText(null);
/* 75 */     this.result.setText(null);
/* 76 */     this.result.setBackground(null);
/* 77 */     this.rc.reset();
/*    */   }
/*    */ }

/* Location:           C:\MD5sumJ4.4\
 * Qualified Name:     it.bertolottipf.MD5sumJ.SecondView
 * JD-Core Version:    0.6.2
 */