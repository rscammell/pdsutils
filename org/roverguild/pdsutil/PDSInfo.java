package org.roverguild.pdsutil;

/**
 * This class uses the PDSFilenameTranslator class to
 * provide a human readable summary of the metadata contained
 * within a PDS file provided as a command line argument.
 * @author <a href="mailto:rupe@sbcglobal.net">Rupert Scammell</a><br>
 * Project site: <a href="http://hobbiton.thisside.net/pdsutil">PDS Utilities Project Site</a>
 * @version 0.1 / 2004-08-15
 */

public class PDSInfo {

    /**
     * A utility method used to format field names and translated data
     * into tidy, printable strings.
     * @param fieldName a String containing the PDS field name
     * @param transData a String containing the translated PDS data
     * @return A string containing a formatted version of the field name and data.
     */
     public static String formatData(String fieldName, String transData) {
           String fs = fieldName + ": " + transData;
           return fs;
     }

    /**
     * Make a separator line of a specified length.
     * @param length Length of the separator line to create.
     * @param chr The character to use in creating the separator.
     * @return a String containing a separator line of the desired length.
     */
     public static String makeSeparatorLine(int length, char chr) {
           String sl = new String();
           String chrString = new String();
           chrString = chrString.valueOf(chr); 
           for (int i = 0 ; i < length ; i++ ) {
               sl = sl + chr;
           }
           return sl;
     }

    /**
     * Main method.
     * @param args Arguments from the command line, specifically,
     * the PDS filename string to be translated.
     */
     public static void main(String args[]) {
         /**
          * Instantiate a PDSFilenameTranslator object with the
          * given filename argument.
          */
          PDSFilenameTranslator t = new PDSFilenameTranslator(args[0]);

          /**
           * Print a human readable summary of the PDS metadata.
           */
          String title = "PDS Label Information for file " + args[0];
          System.out.println("\n" + title);
          System.out.println(makeSeparatorLine(title.length(), '-') + "\n");
          String tdata = "Translated information";
          System.out.println("\n" + tdata);
          System.out.println(makeSeparatorLine(tdata.length(), '-') + "\n");
          System.out.println(formatData(t.getSCIDName(), t.getSCIDTranslation()));
          System.out.println(formatData(t.getINSTName(), t.getINSTTranslation()));
          System.out.println(formatData(t.getSCLKName(), t.getSCLKTranslation()));
          System.out.println(formatData(t.getPRODName(), t.getPRODTranslation()));
          System.out.println(formatData(t.getSITEName(), t.getSITETranslation()));
          System.out.println(formatData(t.getPOSName(), t.getPOSTranslation()));
          System.out.println(formatData(t.getSeqTypeName(), 
          t.getSeqTypeTranslation()));
          System.out.println(formatData(t.getSeqOpName(), t.getSeqOpTranslation()));
          System.out.println(formatData(t.getEYEName(), t.getEYETranslation()));
          System.out.println(formatData(t.getFILTName(), t.getFILTTranslation()));
          System.out.println(formatData(t.getWHOName(), t.getWHOTranslation()));
          System.out.println(formatData(t.getVERName(), t.getVERTranslation()));
          System.out.println(formatData(t.getEXTName(), t.getEXTTranslation()));

          String rdata = "Raw PDS Label information";
          System.out.println("\n" + rdata);
          System.out.println(makeSeparatorLine(rdata.length(), '-') + "\n"); 
          System.out.println(formatData(t.getSCIDName(), t.getSCIDRaw()));
          System.out.println(formatData(t.getINSTName(), t.getINSTRaw()));
          System.out.println(formatData(t.getSCLKName(), t.getSCLKRaw()));
          System.out.println(formatData(t.getPRODName(), t.getPRODRaw()));
          System.out.println(formatData(t.getSITEName(), t.getSITERaw()));
          System.out.println(formatData(t.getPOSName(), t.getPOSRaw()));
          System.out.println(formatData(t.getSeqTypeName(), 
          t.getSeqTypeRaw()));
          System.out.println(formatData(t.getSeqOpName(), t.getSeqOpRaw()));
          System.out.println(formatData(t.getEYEName(), t.getEYERaw()));
          System.out.println(formatData(t.getFILTName(), t.getFILTRaw()));
          System.out.println(formatData(t.getWHOName(), t.getWHORaw()));
          System.out.println(formatData(t.getVERName(), t.getVERRaw()));
          System.out.println(formatData(t.getEXTName(), t.getEXTRaw()));
     }
}


          
