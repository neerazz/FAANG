import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on:  May 25, 2020
 */
public class Tools {
    public static void main(String[] args) {
        System.out.println("************************* Contest ***********************************");
        getContest(
                "Special Array With X Elements Greater Than or Equal X3\n" +
                        "Even Odd Tree4\n" +
                        "Maximum Number of Visible Points5\n" +
                        "Minimum One Bit Operations to Make Integers Zero"
        );
        System.out.println("************************* Top FB Questions ***********************************");
        printCamelCase(
                "Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold"
//                "Product of Array Except Self",
        );
        getReplaced(
                Collections.singletonList("""
                                [[198768142,325231488],[730653894,526879029],[482566443,124650516],[301750308,786306795],[428637509,388444545],[824139468,560868920],[46101719,541790947],[33117389,306138652],[379129552,739264502],[632078701,382510936],[648669937,641406148],[402494603,290848535],[681757446,651339050],[755146968,328108553],[856055968,54585842],[642810790,781285498],[624780623,839525682],[225552068,597591380],[941428680,575243295],[904246597,409781914],[133988308,424694994],[263860625,642729245],[725256971,428462957],[951188673,24284291],[65878467,597579989],[423910337,760218568],[375233659,465709839],[39079416,44449206],[76488044,376497238],[768046853,401132958],[862857872,713625310],[834212457,613684155],[145940546,414657761],[438671565,895069996],[486059332,78047139],[539611528,236860222],[328891159,833572609],[561041358,896191043],[469734995,511499580],[868786087,593647615],[502014973,630219398],[834825976,939531210],[232809706,831430339],[446916520,518080962],[516594877,208057152],[851130172,768268153],[665228968,134767900],[347594646,46036486],[675842115,24895986],[877430373,353382710],[167579980,47992154],[125351210,769215749],[438404131,569154245],[604952972,128325995],[304627075,646626043],[651998767,527382342],[121415369,22955171],[46278664,726969424],[650197837,730272955],[326340006,424213045],[242071539,679004233],[208227275,449583956],[688763276,330569373],[657221239,659946024],[760680906,398786962],[695186876,163719246],[416909447,908414565],[59247263,674732497],[396812330,607544608],[752069054,728117920]]
                                                                                   86
                                                                                   [136181398,475556834]
                        """),
                Arrays.asList("[", "{"),
                Arrays.asList("\"", "'"),
                Arrays.asList("]", "}")
        ).forEach(System.out::println);
    }

    private static void getContest(String input) {
        String[] strings = input.split("\n");
        for (int i = 0; i < strings.length; i++) {
            System.out.println(getCamelCase(i != strings.length - 1 ? strings[i].substring(0, strings[i].length() - 1) : strings[i]));
        }
    }

    private static void printCamelCase(String... input) {
        Arrays.stream(input).map(Tools::getCamelCase).forEach(System.out::println);
    }

    private static String getCamelCase(String input) {
        StringBuilder sb = new StringBuilder();
        boolean capitalize = true;
        for (char c : input.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                if (sb.length() == 0 && Character.isDigit(c)) {
                    continue;
                } else if (capitalize) {
                    sb.append(Character.toUpperCase(c));
                    capitalize = false;
                } else {
                    sb.append(c);
                }
            } else {
                capitalize = true;
            }
        }
        return sb.toString();
    }

    private static List<String> getReplaced(List<String> input, List<String>... replaces) {
        return input.parallelStream().map(val -> getReplaced(val, replaces)).collect(Collectors.toList());
    }

    private static String getReplaced(String input) {
        return input
                .replace("[", "{")
                .replace("]", "}")
                .replace("\"", "'");
    }

    private static String getReplaced(String input, List<String>... replaces) {
        for (List<String> replace : replaces) {
            input = input.replace(replace.get(0), replace.get(1));
        }
        return input;
    }
}
