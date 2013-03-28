/*    */ package it.bertolottipf.MD5sumJ;
/*    */ 
/*    */ import javax.swing.BoxLayout;
/*    */ import javax.swing.JMenuItem;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JTextArea;
/*    */ 
/*    */ public class FirstView extends JPanel
/*    */ {
/*    */   public FirstView()
/*    */   {
/* 12 */     setLayout(new BoxLayout(this, 1));
/*    */ 
/* 14 */     String presentazioneString = "\nThis program is made by BERTOLOTTI Paolo Francesco and is under Commons Creative License.\n\nThis program can be usefull for programmers that would like distribute software with MD5, SHA1 (the others are improbaly) or for people that downloads software and want to control the integity. I hope that will be yousefull to yot to.";
/*    */ 
/* 20 */     JTextArea presentazione = new JTextArea();
/* 21 */     presentazione.setSize(300, 250);
/* 22 */     presentazione.setEditable(false);
/* 23 */     presentazione.setWrapStyleWord(true);
/* 24 */     presentazione.setLineWrap(true);
/* 25 */     add(presentazione);
/* 26 */     presentazione.setText(presentazioneString);
/*    */ 
/* 28 */     Graph.mntmInfo.setEnabled(false);
/* 29 */     Graph.mntmPasteAspectedChecksum.setEnabled(false);
/*    */   }
/*    */ }

/* Location:           C:\MD5sumJ4.4\
 * Qualified Name:     it.bertolottipf.MD5sumJ.FirstView
 * JD-Core Version:    0.6.2
 */