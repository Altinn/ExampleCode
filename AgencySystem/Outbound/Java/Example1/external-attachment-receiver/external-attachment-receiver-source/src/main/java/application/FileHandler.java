package application;

import org.apache.commons.io.FileUtils;

import java.io.*;

/**
 * Created by andreas.naess on 29.09.2016.
 */

/**
 * Writes to disk, and performs duplication checks.
 */
public class FileHandler {

    private String receiversReference;
    private File dataDirectory = new File("data");

    public FileHandler(String receiversReference) {
        this.receiversReference = receiversReference;

        // This is only true the first the application runs
        if (dataDirectory.mkdir()) {
            System.out.println("Data folder created");
        }
    }

    /**
     * Writes the databatch and attachments (if any) to disk. The content is written to the "data" folder within the
     * application root folder
     *
     * @param dataBatch   Escaped xml, the request payload
     * @param attachments External attachments are saved as .zip files
     * @return The path to the created databatch
     * @throws IOException Throws an exception if it fails to write to disk.
     */
    public File write(String dataBatch, byte[] attachments) throws IOException {

        // Create directory
        File directoryPath = new File(dataDirectory + "/" + receiversReference);
        directoryPath.mkdir();

        if (attachments != null && attachments.length != 0) {
            File attachmentPath = new File(dataDirectory + "/" + receiversReference + "/" + receiversReference + ".zip");
            FileUtils.writeByteArrayToFile(attachmentPath, attachments);
        }

        File dataBatchPath = new File(dataDirectory + "/" + receiversReference + "/" + receiversReference + ".xml");
        FileUtils.write(dataBatchPath, dataBatch, "UTF-8");
        return dataBatchPath;
    }

    /**
     * Before writing the dataBatch to disk, it is important to check if it already exists.
     * This is accomplished by checking the receivers reference for uniqueness.
     * @return True if the file exists, false if not.
     */
    public boolean fileExists()  {
        return new File(dataDirectory + "/" + receiversReference).exists();
    }

}