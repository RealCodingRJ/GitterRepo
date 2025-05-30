public class RunTimeProcess {

    public static String GetProcess(String cmd) throws Exception {

        return Runtime.getRuntime().exec(cmd).toString();
    }

}
