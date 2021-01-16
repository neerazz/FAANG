import java.util.*;

/**
 * Created on:  Jan 16, 2021
 * Questions: https://aonecode.com/amazon-online-assessment-highest-tenure
 */

public class HighestTenure {


    public static void main(String[] args) {
        Team president = new Team(20);
        Team t1 = new Team(12);
        Team t2 = new Team(18);
        t1.reporties.addAll(Arrays.asList(new Team(11), new Team(2), new Team(3)));
        t2.reporties.addAll(Arrays.asList(new Team(15), new Team(8)));
        president.reporties.addAll(Arrays.asList(t1, t2));
        System.out.println(highestTenure(president));
    }

    private static double maxAvg;
    private static Team maxTeam;

    private static Team highestTenure(Team head) {
        maxAvg = 0;
        helper(head);
        System.out.println("maxAvg = " + maxAvg);
        return maxTeam;
    }

    private static int[] helper(Team team) {
        if (team == null) return new int[2];
//        0: count, 1: total experience
        if (team.reporties.isEmpty()) return new int[]{1, team.years};
        int count = 1, total = team.years;
        for (Team can : team.reporties) {
            int[] next = helper(can);
            count += next[0];
            total += next[1];
        }
        double curAvg = (double) total / count;
        if (curAvg > maxAvg) {
            maxAvg = curAvg;
            maxTeam = team;
        }
        return new int[]{count, total};
    }
}

class Team {
    int years;
    List<Team> reporties;

    public Team(int years) {
        this.years = years;
        reporties = new ArrayList<>();
    }

    public Team(int years, List<Team> reporties) {
        this.years = years;
        this.reporties = reporties;
    }

    @Override
    public String toString() {
        return "Team{" +
                "years=" + years +
                ", reporties=" + reporties +
                '}';
    }
}