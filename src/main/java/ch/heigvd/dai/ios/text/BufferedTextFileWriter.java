package ch.heigvd.dai.ios.text;

import ch.heigvd.dai.ios.Writable;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * A class that writes text files. This implementation writes the file using a buffered writer
 * around a file writer. It manages the writer and the buffered writer properly with a
 * try-with-resources block.
 */
public class BufferedTextFileWriter implements Writable {

  @Override
  public void write(String filename, int sizeInBytes) {
    Writer writer = null;
    BufferedWriter bw = null;
    try {
      writer = new FileWriter(filename, StandardCharsets.UTF_8);
      bw = new BufferedWriter(writer);
      for (int i = 0; i < sizeInBytes; i++) {
        bw.write(i);
      }
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    } finally {
      if (writer != null) {
        try {
          writer.close();
        } catch (IOException e) {
          System.out.println(e.getMessage());
        }
      }
      if (bw != null) {
        try {
          bw.close();
        } catch (IOException e) {
          System.out.println(e.getMessage());
        }
      }
    }
  }
}
