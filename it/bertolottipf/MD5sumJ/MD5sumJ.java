/*    */ package it.bertolottipf.MD5sumJ;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.InputMismatchException;
/*    */ import java.util.Scanner;
/*    */ 
/*    */ public class MD5sumJ
/*    */ {
/*    */   public static void main(String[] args)
/*    */   {
/* 12 */     StringBuilder help = new StringBuilder();
/*    */ 
/* 14 */     help.append("MD5sumJ v4.4\n");
/* 15 */     help.append("made by BERTOLOTTI Paolo Francesco\n");
/* 16 */     help.append("----------------------------------\n");
/* 17 */     help.append("\n");
/*    */ 
/* 19 */     help.append("How to use: java -jar comand [opts]\n");
/* 20 */     help.append("\n");
/*    */ 
/* 22 */     help.append("commands:\n");
/* 23 */     help.append("\t -h: help mode\n");
/* 24 */     help.append("\t -g: graphic mode\n");
/* 25 */     help.append("\t -c: console mode\n");
/* 26 */     help.append("\t -ch: console help mode\n");
/* 27 */     help.append("\n");
/*    */ 
/* 29 */     help.append("options (for command -c;  option -t and -fi needed):\n");
/* 30 */     help.append("\t -t: tipology of checksum (MD5, SHA-1, SHA-256, SHA-384, SHA-512)\n");
/* 31 */     help.append("\t -fi: file interested\n");
/* 32 */     help.append("\t -fc: file containing checksum (can't be -ck option)\n");
/* 33 */     help.append("\t -ck: checksum (can't be -fc option)\n");
/*    */ 
/* 36 */     if (args.length == 0) {
/* 37 */       System.out.println(help.toString());
/*    */     }
/* 40 */     else if ((args[0].equals("-h")) && (args.length == 1)) {
/* 41 */       System.out.println(help.toString());
/*    */     }
/* 44 */     else if ((args[0].equals("-g")) && (args.length == 1)) {
/* 45 */       System.out.println("---------------------------------");
/* 46 */       System.out.println("| MD5sumJ open in graphical mode |");
/* 47 */       System.out.println("---------------------------------");
/*    */ 
/* 49 */       Graph inst = new Graph();
/* 50 */       inst.setLocationRelativeTo(null);
/* 51 */       inst.setVisible(true);
/* 52 */       inst.setTitle("MD5sumJ");
/* 53 */     } else if ((args[0].equals("-ch")) && (args.length == 1)) {
/* 54 */       System.out.println("------------------------------------");
/* 55 */       System.out.println("| MD5sumJ open in console help mode |");
/* 56 */       System.out.println("------------------------------------");
/*    */ 
/* 58 */       String domTipology = "What is the type of checksum that interests you? ";
/* 59 */       String domFileInterested = "What's the file you'd like to know the true checksum? ";
/* 60 */       String domFileChecksum = "What's the file that have the aspected checksum (if it exists)? ";
/* 61 */       String domChecksum = "What's the the aspected checksum (if it exists)? ";
/* 62 */       String rispTipology = null;
/* 63 */       String rispFileInterested = null;
/* 64 */       String rispFileChecksum = null;
/* 65 */       String rispChecksum = null;
/*    */ 
/* 67 */       Scanner scanner = new Scanner(System.in);
/*    */       try
/*    */       {
/*    */         do
/*    */         {
/* 72 */           System.out.println(domTipology);
/* 73 */           rispTipology = scanner.nextLine();
/*    */         }
/* 71 */         while (
/* 74 */           rispTipology.isEmpty());
/*    */         do
/*    */         {
/* 78 */           System.out.print(domFileInterested);
/* 79 */           rispFileInterested = scanner.nextLine();
/*    */         }
/* 77 */         while (
/* 80 */           rispFileInterested.isEmpty());
/*    */ 
/* 82 */         System.out.print(domFileChecksum);
/* 83 */         rispFileChecksum = scanner.nextLine();
/*    */ 
/* 85 */         if (!rispFileChecksum.isEmpty()) {
/* 86 */           new Console(rispFileInterested, rispFileChecksum, rispTipology, true);
/*    */         } else {
/* 88 */           System.out.print(domChecksum);
/* 89 */           rispChecksum = scanner.nextLine();
/* 90 */           if (!rispChecksum.isEmpty())
/* 91 */             new Console(rispFileInterested, rispFileChecksum, rispTipology, false);
/*    */           else
/* 93 */             new Console(rispFileInterested, rispTipology);
/*    */         }
/*    */       }
/*    */       catch (InputMismatchException ex)
/*    */       {
/* 98 */         System.out.println(ex);
/*    */       } finally {
/* 100 */         scanner.close();
/*    */       }
/* 102 */     } else if ((args[0].equals("-c")) && (
/* 103 */       (args.length == 5) || (args.length == 7))) {
/* 104 */       System.out.println("--------------------------------");
/* 105 */       System.out.println("| MD5sumJ open in console mode |");
/* 106 */       System.out.println("--------------------------------");
/* 107 */       ArrayList argsList = new ArrayList(
/* 108 */         Arrays.asList(args));
/* 109 */       boolean fcExists = argsList.contains("-fc");
/* 110 */       boolean ckExists = argsList.contains("-ck");
/* 111 */       boolean fiExists = argsList.contains("-fi");
/* 112 */       boolean tExists = argsList.contains("-t");
/*    */ 
/* 114 */       if (!tExists) {
/* 115 */         System.out.println("ERROR 102: parameter not found OR syntax error");
/* 116 */         System.out.println("");
/* 117 */         System.out.println(help.toString());
/* 118 */       } else if (!fiExists) {
/* 119 */         System.out.println("ERROR 102: parameter not found OR syntax error");
/* 120 */         System.out.println("");
/* 121 */         System.out.println(help.toString());
/*    */       } else {
/* 123 */         int fiPlace = argsList.indexOf("-fi");
/* 124 */         int tPlace = argsList.indexOf("-t");
/* 125 */         if ((!fcExists) && (!ckExists)) {
/* 126 */           new Console(args[(fiPlace + 1)], args[(tPlace + 1)]);
/* 127 */         } else if ((fcExists) && (!ckExists)) {
/* 128 */           int fcPlace = argsList.indexOf("-fc");
/* 129 */           new Console(args[(fiPlace + 1)], args[(fcPlace + 1)], args[(tPlace + 1)], true);
/* 130 */         } else if ((!fcExists) && (ckExists)) {
/* 131 */           int ckPlace = argsList.indexOf("-ck");
/* 132 */           new Console(args[(fiPlace + 1)], args[(ckPlace + 1)], args[(tPlace + 1)], false);
/*    */         } else {
/* 134 */           System.out.println("ERROR 100: general error");
/*    */         }
/*    */       }
/*    */     }
/*    */     else {
/* 139 */       System.out.println("ERROR 101: command not found OR syntax error");
/* 140 */       System.out.println("");
/* 141 */       System.out.println(help.toString());
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\MD5sumJ4.4\
 * Qualified Name:     it.bertolottipf.MD5sumJ.MD5sumJ
 * JD-Core Version:    0.6.2
 */