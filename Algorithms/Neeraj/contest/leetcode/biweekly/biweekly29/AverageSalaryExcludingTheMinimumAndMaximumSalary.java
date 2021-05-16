package biweekly.biweekly29;

/**
 * Created on:  Jun 27, 2020
 * Questions: https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary
 */
public class AverageSalaryExcludingTheMinimumAndMaximumSalary {
    public static void main(String[] args) {
        System.out.println(average(new int[]{4000, 3000, 1000, 2000}));
    }

    public static double average(int[] salary) {
        double sum = 0, max = salary[0], min = max;
        for (int sal : salary) {
            max = Math.max(sal, max);
            min = Math.min(sal, min);
            sum += sal;
        }
        return (sum - min - max) / (salary.length - 2);
    }
}
