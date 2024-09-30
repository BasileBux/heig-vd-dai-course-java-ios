package ch.heigvd.dai.ios.binary;

import ch.heigvd.dai.ios.Readable;

import java.io.*;

/**
 * A class that reads binary files. This implementation reads the file byte per byte. It manages the
 * file input stream properly with a try-catch-finally block.
 */
public class BinaryFileReader implements Readable {

  @Override
  public void read(String filename) {
    InputStream fis = null;
    try {
      fis = new FileInputStream(filename);
      int byteRead;
      while ((byteRead = fis.read()) != -1) {
        //  System.out.print(byteRead + " ");
      }
    } catch (IOException e) {
      System.out.println("Error reading file: " + e.getMessage());
    } finally {
      if (fis != null) {
        try {
          fis.close();
        } catch (IOException e) {
          System.out.println("Exception in close reader: " + e);
        }
      }
    }
  }
}
