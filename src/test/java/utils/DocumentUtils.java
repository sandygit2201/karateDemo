package utils;

import org.apache.commons.io.FileUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

public class DocumentUtils {

    private DocumentUtils(){
    }

    public static String updateDocumentNumber(String filePath) {
        return String.join("\n", readDocumentBody(filePath)).replace("$DOCUMENT_NUMBER", UUID.randomUUID().toString());
    }

    public static String updateDocumentRevision(String filePath, String rev) {
        return String.join("\n", readDocumentBody(filePath)).replace("<Revision>A</Revision>", "<Revision>"+rev+"</Revision>");
    }
    public static String deleteDocumentNumber(String content) {
        return content.replace("<DocumentNumber>$DOCUMENT_NUMBER</DocumentNumber>", "");
    }


    public static ArrayList<String> readDocumentBody(String filePath)  {

            try {
                File file = ResourceUtils.getFile(filePath);
                return new ArrayList<String>(Arrays.asList(FileUtils.readFileToString(file).split("\n")));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
    }

}
