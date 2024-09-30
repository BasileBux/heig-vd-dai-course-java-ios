package ch.heigvd.dai.ios.text;

import ch.heigvd.dai.ios.Readable;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * A class that reads text files. This implementation reads the file using a buffered reader around
 * a file reader. It manages the reader and the buffered reader properly with a try-with-resources
 * block.
 */
public class BufferedTextFileReader implements Readable {

  @Override
  public void read(String filename) {
    Reader reader = null;
    BufferedReader br = null;
    try {
      reader = new FileReader(filename, StandardCharsets.UTF_8);
      br = new BufferedReader(reader);
      int c;
      while ((c = br.read()) != -1) {
        // System.out.print((char) c);
      }
    } catch (IOException e) {
      System.err.println("Error reading file: " + filename);
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {
          System.err.println("Error closing file: " + filename);
        }
      }

      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
          System.err.println("Error closing file: " + filename);
        }
      }
    }
  }
}
