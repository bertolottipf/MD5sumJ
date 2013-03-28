/*    */ package it.bertolottipf.MD5sumJ;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ 
/*    */ public class Console
/*    */ {
/*    */   public Console(String fi, String tipology)
/*    */   {
/* 11 */     new Console(fi, "", tipology, false);
/*    */   }
/*    */ 
/*    */   public Console(String fi, String c, String tipology, boolean toDigest)
/*    */   {
/* 23 */     String checksumGot = null;
/* 24 */     String checksumRead = null;
/*    */     try
/*    */     {
/* 27 */       checksumGot = Crypto.getChecksum(fi, tipology);
/*    */     } catch (Exception e) {
/* 29 */       checksumGot = "ERROR 100: general error";
/*    */     }
/*    */ 
/* 34 */     System.out.println("True CHECKSUM\t" + checksumGot + "\n");
/* 35 */     if (!c.isEmpty()) {
/* 36 */       if (toDigest)
/*    */         try {
/* 38 */           checksumRead = ReadFile.getCksum(tipology, c);
/*    */         } catch (Exception e) {
/* 40 */           checksumRead = "ERROR 100: general error";
/*    */         }
/*    */       else {
/* 43 */         checksumRead = c;
/*    */       }
/*    */ 
/* 46 */       System.out.println("Aspected CHECKSUM\t" + checksumRead + "\n");
/*    */ 
/* 48 */       if (checksumGot.equals(checksumRead))
/* 49 */         System.out.println("OK");
/*    */       else
/* 51 */         System.out.println("KO");
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\MD5sumJ4.4\
 * Qualified Name:     it.bertolottipf.MD5sumJ.Console
 * JD-Core Version:    0.6.2
 */