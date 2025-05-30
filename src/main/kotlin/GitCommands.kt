
fun main() {

    val gitCommand = readln().toString()

    if (gitCommand.isEmpty()) {
        return;
    }

    if (gitCommand == "/Init") {
        createProcess();

        val file = readln().toString()
        getFile(file)

        println("Enter Push Branch: ");
        val cmdEndingCommand = readln().toString()
        pushData(cmdEndingCommand);


    }

}

fun pushData(cmd: String) {
    RunTimeProcess.GetProcess("git push -u origin $cmd");
}

fun createProcess() {
    RunTimeProcess.GetProcess("git add .");
    RunTimeProcess.GetProcess("git commit");

}

fun getFile(file: String) {
    RunTimeProcess.GetProcess("git add $file");

}