import java.util.ArrayList;
import java.util.List;

/**
 * Created on:  Sep 06, 2020
 * Questions: https://www.algoexpert.io/questions/Lowest%20Common%20Manager
 */
public class LowestCommonManager {
    public static void main(String[] args) {

    }

    public static OrgChart getLowestCommonManager(OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
        if (topManager.name == reportOne.name || topManager.name == reportTwo.name) return topManager;
        List<OrgChart> result = new ArrayList<>();
        for (OrgChart dep : topManager.directReports) {
            OrgChart manager = getLowestCommonManager(dep, reportOne, reportTwo);
            if (manager != null) result.add(manager);
        }
        if (result.size() == 2) return topManager;
        else if (result.size() == 1) return result.get(0);
        return null;
    }

    static class OrgChart {
        public char name;
        public List<OrgChart> directReports;

        OrgChart(char name) {
            this.name = name;
            this.directReports = new ArrayList<OrgChart>();
        }

        // This method is for testing only.
        public void addDirectReports(OrgChart[] directReports) {
            for (OrgChart directReport : directReports) {
                this.directReports.add(directReport);
            }
        }
    }
}
