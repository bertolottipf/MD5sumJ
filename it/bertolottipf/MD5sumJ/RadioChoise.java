/*    */ package it.bertolottipf.MD5sumJ;
/*    */ 
/*    */ import javax.swing.ButtonGroup;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JRadioButton;
/*    */ 
/*    */ public class RadioChoise extends JPanel
/*    */ {
/*    */   public ButtonGroup group;
/*    */   public JRadioButton md5;
/*    */   public JRadioButton sha1;
/*    */   public JRadioButton sha256;
/*    */   public JRadioButton sha384;
/*    */   public JRadioButton sha512;
/*    */ 
/*    */   public RadioChoise()
/*    */   {
/* 20 */     this.md5 = new JRadioButton("MD5");
/* 21 */     this.sha1 = new JRadioButton("SHA-1");
/* 22 */     this.sha256 = new JRadioButton("SHA-256");
/* 23 */     this.sha384 = new JRadioButton("SHA-384");
/* 24 */     this.sha512 = new JRadioButton("SHA-512");
/*    */ 
/* 27 */     this.group = new ButtonGroup();
/* 28 */     this.group.add(this.md5);
/* 29 */     this.group.add(this.sha1);
/* 30 */     this.group.add(this.sha256);
/* 31 */     this.group.add(this.sha384);
/* 32 */     this.group.add(this.sha512);
/*    */ 
/* 35 */     add(this.md5);
/* 36 */     add(this.sha1);
/* 37 */     add(this.sha256);
/* 38 */     add(this.sha384);
/* 39 */     add(this.sha512);
/*    */   }
/*    */ 
/*    */   public boolean isChoised() {
/* 43 */     if ((!this.md5.isSelected()) && (!this.sha1.isSelected()) && 
/* 44 */       (!this.sha384.isSelected()) && (!this.sha256.isSelected()) && 
/* 45 */       (!this.sha512.isSelected())) {
/* 46 */       return false;
/*    */     }
/* 48 */     return true;
/*    */   }
/*    */ 
/*    */   public void reset() {
/* 52 */     this.group.clearSelection();
/*    */   }
/*    */ }

/* Location:           C:\MD5sumJ4.4\
 * Qualified Name:     it.bertolottipf.MD5sumJ.RadioChoise
 * JD-Core Version:    0.6.2
 */