package weekly.weekly209;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static weekly.weekly207.MinimumCostToConnectTwoGroupsOfPoints.getList;

/**
 * Created on:  Oct 03, 2020
 * Questions: https://leetcode.com/problems/maximum-number-of-visible-points
 */
public class MaximumNumberOfVisiblePoints {
    public static void main(String[] args) {
        System.out.println(visiblePoints(
                getList(new int[][]{{198768142, 325231488}, {730653894, 526879029}, {482566443, 124650516}, {301750308, 786306795}, {428637509, 388444545}, {824139468, 560868920}, {46101719, 541790947}, {33117389, 306138652}, {379129552, 739264502}, {632078701, 382510936}, {648669937, 641406148}, {402494603, 290848535}, {681757446, 651339050}, {755146968, 328108553}, {856055968, 54585842}, {642810790, 781285498}, {624780623, 839525682}, {225552068, 597591380}, {941428680, 575243295}, {904246597, 409781914}, {133988308, 424694994}, {263860625, 642729245}, {725256971, 428462957}, {951188673, 24284291}, {65878467, 597579989}, {423910337, 760218568}, {375233659, 465709839}, {39079416, 44449206}, {76488044, 376497238}, {768046853, 401132958}, {862857872, 713625310}, {834212457, 613684155}, {145940546, 414657761}, {438671565, 895069996}, {486059332, 78047139}, {539611528, 236860222}, {328891159, 833572609}, {561041358, 896191043}, {469734995, 511499580}, {868786087, 593647615}, {502014973, 630219398}, {834825976, 939531210}, {232809706, 831430339}, {446916520, 518080962}, {516594877, 208057152}, {851130172, 768268153}, {665228968, 134767900}, {347594646, 46036486}, {675842115, 24895986}, {877430373, 353382710}, {167579980, 47992154}, {125351210, 769215749}, {438404131, 569154245}, {604952972, 128325995}, {304627075, 646626043}, {651998767, 527382342}, {121415369, 22955171}, {46278664, 726969424}, {650197837, 730272955}, {326340006, 424213045}, {242071539, 679004233}, {208227275, 449583956}, {688763276, 330569373}, {657221239, 659946024}, {760680906, 398786962}, {695186876, 163719246}, {416909447, 908414565}, {59247263, 674732497}, {396812330, 607544608}, {752069054, 728117920}}),
                86,
                Arrays.asList(136181398, 475556834)
        ));
    }

    public static int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int max = 0, self = 0, x = location.get(0), y = location.get(1);
        List<Double> angles = new ArrayList<>();
        for (List<Integer> point : points) {
            int curY = point.get(1), curX = point.get(0);
            if (curY == y && curX == x) {
                self++;
            } else {
                double curAngle = getAngle(x, curX, y, curY);
                angles.add(curAngle);
//        concatenate to handle edge case, where angles is negative
                angles.add(curAngle + 360);
            }
        }
        Collections.sort(angles);
//        System.out.println("angles = " + angles);
        int p1 = 0, p2 = 0;
        while (p2 < angles.size()) {
            while (angles.get(p2) - angles.get(p1) > angle) p1++;
            max = Math.max(max, p2 - p1 + 1);
            p2++;
        }
        return max + self;
    }

    private static double getAngle(int x, int curX, int y, int curY) {
        double angle = Math.toDegrees(Math.atan2(curY - y, curX - x));
        return angle < 0 ? angle + 360 : angle;
    }
}
