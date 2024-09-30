package ch.heigvd.dai.ios.binary;

import ch.heigvd.dai.ios.Readable;

import java.io.BufferedInputStream;
import java.io.*;

/**
 * A class that reads binary files. This implementation reads the file using a buffered input
 * stream. It manages the input stream and the buffered input stream properly with a
 * try-with-resources block.
 */
public class BufferedBinaryFileReader implements Readable {

    @Override
    public void read(String filename) {
        InputStream fis = null;
        InputStream bis = null;
        try {
            fis = new FileInputStream(filename);
            bis = new BufferedInputStream(fis);
            int byteRead;
            while ((byteRead = bis.read()) != -1) {
                // System.out.print(byteRead + " ");
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
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    System.out.println("Exception in close reader: " + e);
                }
            }
        }
    }
}
