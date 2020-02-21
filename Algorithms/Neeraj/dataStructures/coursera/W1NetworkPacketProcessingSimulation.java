import java.util.LinkedList;
import java.util.Scanner;

/*
Sample 1.
Input:
1 0
Output:
Explanation:
If there are no packets, you shouldn’t output anything.
9
Sample 2.
Input:
1 1
0 0
Output:
0
Explanation:
The only packet arrived at time 0, and computer started processing it immediately.
Sample 3.
Input:
1 2
0 1
0 1
Output:
0
-1
Explanation:
The first packet arrived at time 0, the second packet also arrived at time 0, but was dropped, because
the network buffer has size 1 and it was full with the first packet already. The first packet started
processing at time 0, and the second packet was not processed at all.
Sample 4.
Input:
1 2
0 1
1 1
Output:
0
1
Explanation:
The first packet arrived at time 0, the computer started processing it immediately and finished at time
1. The second packet arrived at time 1, and the computer started processing it immediately.
Sample 5:
Input:
1 1
1 0
Correct output:
1
Sample 6:
Input:
2 2
0 1
0 1
Output:
0
1

Solution: https://github.com/danuzclaudes/COMP-550-AlgorithmAnalysis/blob/master/coursera-data-structures/list_stack_tree/process_packages.java
 */
public class W1NetworkPacketProcessingSimulation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfBuffer = Integer.parseInt(scanner.next());
        int noOfBuffer = Integer.parseInt(scanner.next());
        int[][] buffers = new int[noOfBuffer][2];

        for (int i = 0; i < noOfBuffer; i++) {
            buffers[i][0] = Integer.parseInt(scanner.next());
            buffers[i][1] = Integer.parseInt(scanner.next());
        }
        int[] packetProcessed = getPacketProcessed(buffers, noOfBuffer, sizeOfBuffer);
        for (int i = 0; i < noOfBuffer; i++) {
            System.out.println(packetProcessed[i]);
        }
    }

    private static int[] getPacketProcessed(int[][] buffers, int noOfBuffer, int sizeOfBuffer) {
        if (noOfBuffer == 0) {
            return new int[noOfBuffer];
        }
        if (noOfBuffer == 1 && sizeOfBuffer >= noOfBuffer) {
            return new int[]{buffers[0][0]};
        } else {
            int[] result = new int[noOfBuffer];
            LinkedList<Packets> packetsLinkedList = new LinkedList<>();

            packetsLinkedList.add(new Packets(buffers[0][0], buffers[0][1], buffers[0][0], buffers[0][0] + buffers[0][1]));
            result[0] = buffers[0][0];

            int bufferEndTime = 0;

            for (int i = 1; i < noOfBuffer; i++) {

                Packets firstPacket = packetsLinkedList.peekFirst();
                Packets lastPacket = packetsLinkedList.peekLast();
                int starTime = Math.max(lastPacket.starTime + lastPacket.timeTaken, buffers[i][0]);
                int finishTime = starTime + buffers[i][1];
                Packets currentPacket = new Packets(buffers[i][0], buffers[i][1], starTime, finishTime);

                boolean canBeProcessed = false;

                if (firstPacket.starTime + firstPacket.timeTaken <= i) {
                    packetsLinkedList.pollFirst();
                }

                if (packetsLinkedList.size() < sizeOfBuffer && currentPacket.starTime <= bufferEndTime) {
//                    Check if the current packet can be processed.
                    canBeProcessed = true;
                }

                if (canBeProcessed) {
                    result[i] = starTime;
                    bufferEndTime = currentPacket.finishTime;
                } else {
                    result[i] = -1;
                }
            }
            return result;
        }
    }

    static class Packets {
        int arrival;
        int timeTaken;
        int starTime;
        int finishTime;

        public Packets(int arrival, int timeTaken, int starTime, int finishTime) {
            this.arrival = arrival;
            this.timeTaken = timeTaken;
            this.starTime = starTime;
            this.finishTime = finishTime;
        }
    }
}
