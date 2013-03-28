/*     */ package it.bertolottipf.MD5sumJ;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.File;
/*     */ import java.io.PrintStream;
/*     */ import javax.swing.BoxLayout;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFileChooser;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JMenu;
/*     */ import javax.swing.JMenuBar;
/*     */ import javax.swing.JMenuItem;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JRadioButton;
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ public class Graph extends JFrame
/*     */   implements ActionListener
/*     */ {
/*     */   private FirstView firstView;
/*     */   public SecondView secondView;
/*     */   private String fileString;
/*     */   private String fileString2;
/*     */   private String text;
/*     */   private String text2;
/*     */   private String tipology;
/*     */   public JMenuBar mb;
/*     */   public JMenu mnFile;
/*     */   public JMenu mnEdit;
/*     */   public JMenu mnHelp;
/*     */   public JMenuItem mntmNew;
/*     */   public static JMenuItem mntmInfo;
/*     */   public JMenuItem mntmExit;
/*     */   public static JMenuItem mntmPasteAspectedChecksum;
/*     */ 
/*     */   public Graph()
/*     */   {
/*     */     try
/*     */     {
/*  42 */       BoxLayout thisLayout = new BoxLayout(getContentPane(), 
/*  43 */         1);
/*  44 */       getContentPane().setLayout(thisLayout);
/*  45 */       setDefaultCloseOperation(2);
/*  46 */       setSize(331, 300);
/*  47 */       setResizable(false);
/*     */ 
/*  50 */       this.mb = new JMenuBar();
/*     */ 
/*  52 */       this.mnFile = new JMenu("File");
/*  53 */       this.mb.add(this.mnFile);
/*     */ 
/*  55 */       this.mntmNew = new JMenuItem("New");
/*  56 */       this.mnFile.add(this.mntmNew);
/*  57 */       this.mntmNew.addActionListener(this);
/*     */ 
/*  59 */       this.mntmExit = new JMenuItem("Exit");
/*  60 */       this.mnFile.add(this.mntmExit);
/*  61 */       this.mntmExit.addActionListener(this);
/*     */ 
/*  63 */       this.mnEdit = new JMenu("Edit");
/*  64 */       this.mb.add(this.mnEdit);
/*     */ 
/*  66 */       mntmPasteAspectedChecksum = new JMenuItem("Paste aspected checksum");
/*  67 */       this.mnEdit.add(mntmPasteAspectedChecksum);
/*  68 */       mntmPasteAspectedChecksum.addActionListener(this);
/*     */ 
/*  70 */       this.mnHelp = new JMenu("Help");
/*  71 */       this.mb.add(this.mnHelp);
/*     */ 
/*  73 */       mntmInfo = new JMenuItem("Info");
/*  74 */       this.mnHelp.add(mntmInfo);
/*  75 */       mntmInfo.addActionListener(this);
/*     */ 
/*  77 */       setJMenuBar(this.mb);
/*     */ 
/*  80 */       this.firstView = new FirstView();
/*  81 */       getContentPane().add(this.firstView);
/*  82 */       this.firstView.setPreferredSize(new Dimension(391, 137));
/*     */ 
/*  85 */       this.secondView = new SecondView();
/*  86 */       this.secondView.openFile.addActionListener(this);
/*  87 */       this.secondView.openFileMd5.addActionListener(this);
/*     */ 
/*  89 */       this.secondView.rc.md5.addActionListener(this);
/*  90 */       this.secondView.rc.sha1.addActionListener(this);
/*  91 */       this.secondView.rc.sha256.addActionListener(this);
/*  92 */       this.secondView.rc.sha384.addActionListener(this);
/*  93 */       this.secondView.rc.sha512.addActionListener(this);
/*     */ 
/*  95 */       getContentPane().add(this.secondView);
/*  96 */       this.secondView.setVisible(false);
/*     */ 
/*  98 */       pack();
/*  99 */       setSize(399, 250);
/*     */     }
/*     */     catch (Exception localException)
/*     */     {
/*     */     }
/*     */   }
/*     */ 
/*     */   public void actionPerformed(ActionEvent ev)
/*     */   {
/* 113 */     Object pulsantePremuto = ev.getSource();
/*     */ 
/* 115 */     if (pulsantePremuto == this.secondView.rc.md5) {
/* 116 */       this.tipology = "MD5";
/*     */     }
/*     */ 
/* 119 */     if (pulsantePremuto == this.secondView.rc.sha1) {
/* 120 */       this.tipology = "SHA-1";
/*     */     }
/*     */ 
/* 123 */     if (pulsantePremuto == this.secondView.rc.sha256) {
/* 124 */       this.tipology = "SHA-256";
/*     */     }
/*     */ 
/* 127 */     if (pulsantePremuto == this.secondView.rc.sha384) {
/* 128 */       this.tipology = "SHA-384";
/*     */     }
/*     */ 
/* 131 */     if (pulsantePremuto == this.secondView.rc.sha512) {
/* 132 */       this.tipology = "SHA-512";
/*     */     }
/*     */ 
/* 135 */     if (pulsantePremuto == this.secondView.openFile)
/*     */     {
/* 137 */       if (this.secondView.rc.isChoised())
/*     */       {
/* 140 */         JFileChooser chooser = new JFileChooser();
/* 141 */         int returnVal = chooser.showOpenDialog(this);
/*     */ 
/* 143 */         if (returnVal == 0) {
/* 144 */           this.fileString = chooser.getSelectedFile().getPath();
/*     */           try
/*     */           {
/* 147 */             this.text = Crypto.getChecksum(this.fileString, this.tipology);
/*     */           } catch (Exception e) {
/* 149 */             this.text = "ERROR 100: general error";
/*     */           }
/* 151 */           this.secondView.trueMd5.setText(this.text);
/*     */         }
/*     */       }
/*     */       else {
/* 155 */         JOptionPane.showMessageDialog(this, 
/* 156 */           "You need select a encrypt option before", 
/* 157 */           "Encrypt option need", 0);
/*     */       }
/*     */     }
/*     */ 
/* 161 */     if (pulsantePremuto == this.secondView.openFileMd5)
/*     */     {
/* 163 */       if (this.secondView.rc.isChoised())
/*     */       {
/* 165 */         JFileChooser chooser = new JFileChooser();
/* 166 */         int returnVal = chooser.showOpenDialog(this);
/*     */ 
/* 168 */         if (returnVal == 0) {
/* 169 */           this.fileString2 = chooser.getSelectedFile().getPath();
/* 170 */           this.text2 = ReadFile.getCksum(this.tipology, this.fileString2);
/* 171 */           this.secondView.aspectedMd5.setText(this.text2);
/*     */         }
/*     */       } else {
/* 174 */         JOptionPane.showMessageDialog(this, 
/* 175 */           "You need select a encrypt option before", 
/* 176 */           "Encrypt option need", 0);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 181 */     if ((!this.secondView.aspectedMd5.getText().equals("")) && 
/* 182 */       (!this.secondView.trueMd5.getText().equals(""))) {
/* 183 */       if (this.secondView.aspectedMd5.getText().equals(
/* 184 */         this.secondView.trueMd5.getText())) {
/* 185 */         this.secondView.result.setText("OK");
/* 186 */         this.secondView.result.setBackground(Color.GREEN);
/*     */       } else {
/* 188 */         this.secondView.result.setText("KO");
/* 189 */         this.secondView.result.setBackground(Color.RED);
/*     */       }
/*     */     }
/*     */ 
/* 193 */     if (pulsantePremuto == this.mntmNew) {
/* 194 */       this.firstView.setVisible(false);
/* 195 */       this.secondView.setVisible(true);
/* 196 */       this.secondView.reset();
/* 197 */       mntmInfo.setEnabled(true);
/* 198 */       mntmPasteAspectedChecksum.setEnabled(true);
/*     */     }
/*     */ 
/* 201 */     if (pulsantePremuto == mntmInfo) {
/* 202 */       this.firstView.setVisible(true);
/* 203 */       this.secondView.setVisible(false);
/* 204 */       mntmInfo.setEnabled(false);
/* 205 */       mntmPasteAspectedChecksum.setEnabled(false);
/*     */     }
/*     */ 
/* 208 */     if (pulsantePremuto == this.mntmExit) {
/* 209 */       System.out.println("Bye!");
/* 210 */       System.exit(0);
/*     */     }
/*     */ 
/* 213 */     if (pulsantePremuto == mntmPasteAspectedChecksum) {
/* 214 */       String chksum = JOptionPane.showInputDialog("Insert aspected checksum");
/* 215 */       this.secondView.aspectedMd5.setText(chksum);
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\MD5sumJ4.4\
 * Qualified Name:     it.bertolottipf.MD5sumJ.Graph
 * JD-Core Version:    0.6.2
 */