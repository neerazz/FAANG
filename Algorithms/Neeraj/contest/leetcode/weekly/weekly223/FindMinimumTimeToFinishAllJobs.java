package weekly.weekly223;

/**
 * Created on:  Jan 09, 2021
 * Questions:
 */

public class FindMinimumTimeToFinishAllJobs {

    public static void main(String[] args) {
        System.out.println(minimumTimeRequired(new int[]{1,2,4,7,8}, 2));
        System.out.println(minimumTimeRequired(new int[]{11, 2, 20, 18, 2, 1, 7, 11, 7, 10}, 9));
    }

    public static int minimumTimeRequired(int[] jobs, int k) {
        long start = 1, end = 0;
        for (int job : jobs) end += job;
        long answer = 0;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (isPossible(jobs, mid, k)) {
                answer = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return (int) answer;
    }

    private static boolean isPossible(int[] jobs, long maxVal, int k) {
        int count = 0, sum = 0;
        for (int job : jobs) {
            if (job > maxVal) return false;
            sum += job;
            if (sum > maxVal) {
                count++;
                sum = job;
            }
        }
        if(sum > 0) count++;
        return count <= k;
    }

    static int min;

    public static int minimumTimeRequired_naive(int[] jobs, int k) {
        min = Integer.MAX_VALUE;
        long[] workers = new long[k];
        helper(jobs, workers, 0, 0);
        return min;
    }

    private static void helper(int[] jobs, long[] workers, int idx, int max) {
        if (idx == jobs.length) {
            min = Math.min(min, max);
        } else {
            for (int i = 0; i < workers.length; i++) {
                workers[i] += jobs[idx];
                helper(jobs, workers, idx + 1, Math.max(max, (int) workers[i]));
                workers[i] -= jobs[idx];
            }
        }
    }
}
