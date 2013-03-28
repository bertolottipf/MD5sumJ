/*    */ package it.bertolottipf.MD5sumJ;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.FileReader;
/*    */ import java.io.IOException;
/*    */ 
/*    */ public class ReadFile
/*    */ {
/* 10 */   private static String v = null;
/*    */ 
/*    */   public static String getCksum(String tipology, String nomefile) {
/* 13 */     String text = null;
/* 14 */     String chks = null;
/*    */     try {
/* 16 */       text = getAllText(nomefile);
/* 17 */       chks = getChecksum(tipology, text);
/*    */     } catch (IOException e) {
/* 19 */       chks = "ERROR 100: general error";
/*    */     }
/* 21 */     return chks;
/*    */   }
/*    */ 
/*    */   private static String getAllText(String nomefile)
/*    */     throws IOException
/*    */   {
/* 30 */     FileReader f = new FileReader(nomefile);
/* 31 */     BufferedReader in = new BufferedReader(f);
/* 32 */     int i = 0;
/* 33 */     String linea = in.readLine();
/* 34 */     while (linea != null) {
/* 35 */       v = linea;
/* 36 */       linea = in.readLine();
/* 37 */       i++;
/*    */     }
/* 39 */     f.close();
/* 40 */     return v;
/*    */   }
/*    */ 
/*    */   private static String getChecksum(String tipology, String textToAnalize)
/*    */   {
/* 47 */     int reqLength = 0;
/*    */ 
/* 49 */     if (tipology.equals("MD5"))
/* 50 */       reqLength = 32;
/* 51 */     else if (tipology.equals("SHA1"))
/* 52 */       reqLength = 40;
/* 53 */     else if (tipology.equals("SHA256"))
/* 54 */       reqLength = 256;
/* 55 */     else if (tipology.equals("SHA384"))
/* 56 */       reqLength = 384;
/* 57 */     else if (tipology.equals("SHA512")) {
/* 58 */       reqLength = 512;
/*    */     }
/*    */ 
/* 62 */     String[] arrTTA = textToAnalize.split(" ");
/*    */ 
/* 64 */     int i = 0;
/* 65 */     int numFounded = 0;
/* 66 */     int lastFound = 0;
/*    */ 
/* 69 */     for (String el : arrTTA)
/*    */     {
/* 72 */       if (el.length() == reqLength)
/*    */       {
/* 74 */         numFounded++;
/*    */ 
/* 76 */         lastFound = i;
/*    */       }
/*    */ 
/* 79 */       i++;
/*    */     }
/*    */ 
/* 83 */     if (numFounded == 1)
/*    */     {
/* 85 */       return arrTTA[lastFound];
/*    */     }
/* 87 */     return textToAnalize;
/*    */   }
/*    */ }

/* Location:           C:\MD5sumJ4.4\
 * Qualified Name:     it.bertolottipf.MD5sumJ.ReadFile
 * JD-Core Version:    0.6.2
 */