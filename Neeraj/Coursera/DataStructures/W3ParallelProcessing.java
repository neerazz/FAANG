import java.util.*;

/*
Task. You have a program which is parallelized and uses 𝑛 independent threads to process the given list of 𝑚
jobs. Threads take jobs in the order they are given in the input. If there is a free thread, it immediately
takes the next job from the list. If a thread has started processing a job, it doesn’t interrupt or stop
until it finishes processing the job. If several threads try to take jobs from the list simultaneously, the
thread with smaller index takes the job. For each job you know exactly how long will it take any thread
to process this job, and this time is the same for all the threads. You need to determine for each job
which thread will process it and when will it start processing.
Sample 1.
Input:
2 5
1 2 3 4 5
Sample 2.
Input:
4 20
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
Output:
0 0
1 0
2 0
3 0
0 1
1 1
2 1
3 1
0 2
1 2
2 2
3 2
0 3
1 3
2 3
3 3
0 4
1 4
2 4
3 4
 */
public class W3ParallelProcessing {

    private static List<Task> taskLog = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int threads = Integer.parseInt(scanner.next());
        int taskCount = Integer.parseInt(scanner.next());
        LinkedList<Integer> tasks = new LinkedList<>();
//        int[] tasks = new int[taskCount];
        for (int i = 0; i < taskCount; i++) {
            tasks.add(Integer.parseInt(scanner.next()));
        }
//        getTaskProcessingTime(threads, taskCount, tasks);
        getTaskProcessingTime2(threads, taskCount, tasks);
        taskLog.forEach(t -> System.out.println(t.processor + " " + t.startTime));
    }

    private static void getTaskProcessingTime2(int threads, int taskCount, LinkedList<Integer> tasks) {
        TreeSet<Task> processor = new TreeSet<>();
        long time = 0;

        while (!tasks.isEmpty()) {
//            Assign tasks to all the threads.
            if (processor.size() == 0) {
                for (int i = 0; i < threads; i++) {
                    Task task = new Task(tasks.poll(), time, i);
                    processor.add(task);
                    taskLog.add(task);
                    if (tasks.isEmpty()) break;
                }
            }

//            Get the task from processor that is about to be completed first.
            while (processor.size() <= threads && !processor.isEmpty() && !tasks.isEmpty()) {
                Task fistTaskToBeCompleted = processor.pollFirst();
                time = fistTaskToBeCompleted.endTime;
                Task task = new Task(tasks.poll(), time, fistTaskToBeCompleted.processor);
                processor.add(task);
                taskLog.add(task);
            }
        }
    }

    private static List<Task> getTaskProcessingTime(int threads, int taskCount, Queue<Integer> tasks) {
        Task[] processor = new Task[threads];

        long time = 0;
        while (!tasks.isEmpty()) {
            for (int i = 0; i < threads; i++) {
                if (processor[i] == null) {
                    Integer taskNumber = tasks.poll();
                    Task task = new Task(taskNumber, time, i);
                    processor[i] = task;
                    taskLog.add(task);
                } else {
                    if (processor[i].endTime == time && !tasks.isEmpty()) {
                        Integer taskNumber = tasks.poll();
                        Task task = new Task(taskNumber, time, i);
                        processor[i] = task;
                        taskLog.add(task);
                    }
                }
                if (tasks.isEmpty()) {
                    break;
                }
            }
            time++;
        }
        return taskLog;
    }

    static class Task implements Comparable {
        int taskNumber;
        long startTime;
        long endTime;
        int processor;

        public Task(int taskNumber, long startTime, int processor) {
            this.taskNumber = taskNumber;
            this.startTime = startTime;
            this.endTime = taskNumber + startTime;
            this.processor = processor;
        }

        @Override
        public String toString() {
            return String.valueOf(processor + " " + startTime);
        }

        @Override
        public int compareTo(Object o) {
            Task t = (Task) o;
            return Long.compare(this.endTime, t.endTime);
        }
    }
}
