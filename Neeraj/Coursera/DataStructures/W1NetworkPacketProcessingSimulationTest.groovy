import groovy.io.FileType
import spock.lang.Shared
import spock.lang.Specification

class W1NetworkPacketProcessingSimulationTest extends Specification {
    W1NetworkPacketProcessingSimulation networkPacketProcessingSimulation = new W1NetworkPacketProcessingSimulation()

    @Shared
    String testFileFolder = "D:\\OneDrive - leverage proactive deliverables\\Java\\JavaProjects\\FAANGJobPreperation\\Resources\\Coursera\\Data Structures\\week1_basic_data_structures\\3_network_simulation\\tests"

    @Shared
    Map<Integer, List> inputFile = new HashMap<String, String>()

    @Shared
    Map<Integer, List> outputFile = new HashMap<String, String>()

    def setupSpec() {
        def dir = new File(testFileFolder)
        int totalFiles
        dir.eachFileRecurse(FileType.FILES) { file ->
            if (file.name.endsWith(".a")) {
                outputFile.put(file.name.replace(".a", "") as int, file.readLines())
            } else {
                inputFile.put(file.name as int, file.readLines())
            }
            totalFiles++
        }

        inputFile.each { k, v ->
            println(Test: k)
            testWithInput(v, outputFile.get(k))
        }
//        testWithInput(inputFile.get(8), outputFile.get(8))
    }

    boolean testWithInput(List input, List output) {

        def var = input.get(0).split()
        int sizeOfBuffer = var[0] as int
        int noOfBuffer = var[1] as int
        int[][] buffers = new int[noOfBuffer][2]

        for (int i = 1; i < input.size(); i++) {
            var = input.get(i).split()
            buffers[i - 1][0] = var[0] as int
            buffers[i - 1][1] = var[1] as int
        }

        List result = Arrays.asList(W1NetworkPacketProcessingSimulation.getPacketProcessed(buffers, noOfBuffer, sizeOfBuffer))
        assert result.size() == noOfBuffer
        for (int i = 0; i < noOfBuffer; i++) {
            if (result.get(i) != output.get(i) as int) {
                println("Test Failed for below input.")
                println(input: input)
                println(sizeOfBuffer: sizeOfBuffer)
                println(noOfBuffer: noOfBuffer)
                println(buffers: buffers)
                println(Result: result)
                println(Expected: output)
                assert result == output
            }
        }
    }
}