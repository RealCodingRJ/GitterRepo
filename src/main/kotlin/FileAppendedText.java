import java.io.FileWriter;

public class FileAppendedText {

    public static FileWriter CreateFileAppended(String name) throws Exception {

        return new FileWriter(name, true);
    }


}
