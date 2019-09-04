package org.sparkliang.miniutils.textbasedftp;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Base64;

public class FileToBase64 {
    private static final int FILE_BUFFER_LENGTH = 1024;

    /**
     * Encode the file with Base64.
     *
     * @param args <ul>
     *             <li>args[0]: source file name. Please provide the absolute path of the file.</li>
     *             <li>args[1]: target file name. Please provide the absolute path of the file.</li>
     *             </ul>
     */
    public static void main(String[] args) throws Exception {
        validateArgs(args);

        String sourceFileName = args[0], targetFileName = args[1];

        try (
                FileInputStream in = new FileInputStream(sourceFileName);
                FileWriter out = new FileWriter(targetFileName);
        ) {
            byte[] buffer = new byte[FILE_BUFFER_LENGTH];
            int len;
            Base64.Encoder encoder = Base64.getEncoder();
            while ((len = in.read(buffer)) != -1) {
                if (len == FILE_BUFFER_LENGTH){
                    out.write(encoder.encodeToString(buffer));
                }else{
                    out.write(encoder.encodeToString(Arrays.copyOf(buffer,len)));
                }
            }

        }
    }

    private static void validateArgs(String[] args) {

    }
}
