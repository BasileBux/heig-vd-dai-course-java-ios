package ch.heigvd.dai.ios.binary;

import ch.heigvd.dai.ios.Writable;

import java.io.*;

/**
 * A class that writes binary files. This implementation writes the file using a buffered output
 * stream. It manages the file output stream properly with a try-with-resources block.
 */
public class BufferedBinaryFileWriter implements Writable {

  @Override
  public void write(String filename, int sizeInBytes) {
    OutputStream fos = null;
    OutputStream bos = null;
    try {
      fos = new FileOutputStream(filename);
      bos = new BufferedOutputStream(fos);
      for (int i = 0; i < sizeInBytes; i++) {
        bos.write(i);
      }
      bos.flush();
    } catch (IOException e) {
      System.out.println("Error writing file: " + e.getMessage());
    } finally {
      if (fos != null) {
        try {
          fos.close();
        } catch (IOException e) {
          System.out.println("Exception in close writer: " + e);
        }
      }
      if (bos != null) {
        try {
          bos.close();
        } catch (IOException e) {
          System.out.println("Exception in close writer: " + e);
        }
      }
    }
  }
}
