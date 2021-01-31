import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;


public class FileProcessRunner {

    private final Process process;
    private int status;

    public FileProcessRunner(List<String> commands) throws IOException {
        this.process = createProcess(commands);
    }

    public List<String> startProcess() throws InterruptedException {
        return processOutput(runProcess(process));
    }

    private Process createProcess(List<String> commands) throws IOException {
        ProcessBuilder pb = new ProcessBuilder(commands);
        return pb.start();
    }

    private InputStream runProcess(Process process) throws InterruptedException {
        process.waitFor();
        status = process.exitValue();
        return process.getInputStream();
    }

    private List<String> processOutput(InputStream stream) {
        return new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.toList());
    }

    public int getStatus() {
        return status;
    }
}