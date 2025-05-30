import java.io.File
import java.io.FileWriter

private var title = "a"
private var file: String = "";
private var cmdEndingCommand: String = "";
private var listRoutes:List<String> = emptyList()

fun main() {

    println(title);

    println("Enter Route: ")
    val gitCommand = readln().toString()



    if (gitCommand == "/Types") {
        println(getRoutes());
    }

    if (gitCommand.isEmpty()) {
        return;
    }

    if (gitCommand == "/Init") {

        println("Enter Cloned Github Repo Link: ");
        val clonedLink = readln().toString();
        copyRepoToPath(clonedLink);

        println("Enter Route for Repo: ");
        val route = readln().toString()
        pickRouteCommand(route);

        println("Enter Command to Commit To Repo: ");
        val finalCommand = readln().toString()
        createProcess(finalCommand);

        file = readln().toString()
        getFile(file)

        println("Enter Push Branch: ");
        cmdEndingCommand = readln().toString()
        pushData(cmdEndingCommand);

        createREADMEFile();

        val fileNamed = FileAppendedText.CreateFileAppended("Commands.txt");
        fileNamed.write("Commit Message: $finalCommand")
        fileNamed.write("Pushed Branch: $cmdEndingCommand")
        fileNamed.close();

    }

}

fun createREADMEFile() {
    val repoFile = File("README.md");
    repoFile.createNewFile();
    println("Created README File");
}

fun getRoutes() {
    listRoutes = listOf("/Init")
    return listRoutes.forEach { e -> e }
}


fun copyRepoToPath(repoLink: String) {
    Runtime.getRuntime().exec("git clone $repoLink")
}

fun pickRouteCommand(route: String) {
    Runtime.getRuntime().exec("cd /c $route");
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