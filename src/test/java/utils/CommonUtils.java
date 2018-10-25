package utils;

public class CommonUtils {

    private static final int MILLISECONDS_IN_SECOND = 1000;

    private CommonUtils(){
    }

    public static String sleepSeconds(int seconds){

        try {
            Thread.sleep(seconds* MILLISECONDS_IN_SECOND);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    return "done";
    }
}
