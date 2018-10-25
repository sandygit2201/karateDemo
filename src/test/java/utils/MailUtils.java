package utils;

import org.apache.commons.io.FileUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

public class MailUtils {

    private MailUtils() {
    }

    public static String updateMailSubject(String filePath) {
        return String.join("\n", readMailBody(filePath)).replace("$SUBJECT", UUID.randomUUID().toString());
    }



    private static ArrayList<String> readMailBody(String filePath) {
        try {
            File file = ResourceUtils.getFile(filePath);
            return new ArrayList<String>(Arrays.asList(FileUtils.readFileToString(file).split("\n")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
