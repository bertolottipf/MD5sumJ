/*    */ package it.bertolottipf.MD5sumJ;
/*    */ 
/*    */ import java.io.FileInputStream;
/*    */ import java.io.InputStream;
/*    */ import java.security.MessageDigest;
/*    */ 
/*    */ public class Crypto
/*    */ {
/*    */   private static byte[] createChecksum(String filename, String tipology)
/*    */     throws Exception
/*    */   {
/* 19 */     InputStream fis = new FileInputStream(filename);
/*    */ 
/* 21 */     byte[] buffer = new byte[1024];
/* 22 */     MessageDigest complete = MessageDigest.getInstance(tipology);
/*    */     int numRead;
/*    */     do
/*    */     {
/* 25 */       numRead = fis.read(buffer);
/* 26 */       if (numRead > 0)
/* 27 */         complete.update(buffer, 0, numRead);
/*    */     }
/* 29 */     while (numRead != -1);
/* 30 */     fis.close();
/* 31 */     return complete.digest();
/*    */   }
/*    */ 
/*    */   public static String getChecksum(String filename, String tipology)
/*    */     throws Exception
/*    */   {
/* 44 */     byte[] b = createChecksum(filename, tipology);
/* 45 */     String result = "";
/* 46 */     for (int i = 0; i < b.length; i++) {
/* 47 */       result = result + Integer.toString((b[i] & 0xFF) + 256, 16).substring(1);
/*    */     }
/* 49 */     return result;
/*    */   }
/*    */ }

/* Location:           C:\MD5sumJ4.4\
 * Qualified Name:     it.bertolottipf.MD5sumJ.Crypto
 * JD-Core Version:    0.6.2
 */