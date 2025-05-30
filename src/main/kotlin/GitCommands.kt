import java.io.File
import java.io.FileWriter

fun main() {

    val gitCommand = readln().toString()

    if (gitCommand.isEmpty()) {
        return;
    }

    if (gitCommand == "/Init") {

        println("Enter Command to Commit To Repo: ");
        val finalCommand = readln().toString()

        createProcess(finalCommand);

        val file = readln().toString()
        getFile(file)

        println("Enter Push Branch: ");
        val cmdEndingCommand = readln().toString()
        pushData(cmdEndingCommand);


        val fileNamed = FileAppendedText.CreateFileAppended("Commands.txt");
        fileNamed.write("Commit Message: $finalCommand")
        fileNamed.write("Pushed Branch: $cmdEndingCommand")
        fileNamed.close();

    }

}

fun pushData(cmd: String) {
    RunTimeProcess.GetProcess("git push -u origin $cmd");
}

fun createProcess(value: String) {
    RunTimeProcess.GetProcess("git add .");
    RunTimeProcess.GetProcess("git commit -u $value");

}

fun getFile(file: String) {
    RunTimeProcess.GetProcess("git add $file");

}