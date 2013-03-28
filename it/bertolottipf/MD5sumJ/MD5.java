/*    */ package it.bertolottipf.MD5sumJ;
/*    */ 
/*    */ import java.io.FileInputStream;
/*    */ import java.io.InputStream;
/*    */ import java.security.MessageDigest;
/*    */ 
/*    */ public class MD5
/*    */ {
/*    */   private static byte[] createChecksum(String filename)
/*    */     throws Exception
/*    */   {
/* 21 */     InputStream fis = new FileInputStream(filename);
/*    */ 
/* 23 */     byte[] buffer = new byte[1024];
/* 24 */     MessageDigest complete = MessageDigest.getInstance("MD5");
/*    */     int numRead;
/*    */     do
/*    */     {
/* 27 */       numRead = fis.read(buffer);
/* 28 */       if (numRead > 0)
/* 29 */         complete.update(buffer, 0, numRead);
/*    */     }
/* 31 */     while (numRead != -1);
/* 32 */     fis.close();
/* 33 */     return complete.digest();
/*    */   }
/*    */ 
/*    */   public static String getMD5Checksum(String filename)
/*    */     throws Exception
/*    */   {
/* 45 */     byte[] b = createChecksum(filename);
/* 46 */     String result = "";
/* 47 */     for (int i = 0; i < b.length; i++) {
/* 48 */       result = result + Integer.toString((b[i] & 0xFF) + 256, 16).substring(1);
/*    */     }
/* 50 */     return result;
/*    */   }
/*    */ }

/* Location:           C:\MD5sumJ4.4\
 * Qualified Name:     it.bertolottipf.MD5sumJ.MD5
 * JD-Core Version:    0.6.2
 */