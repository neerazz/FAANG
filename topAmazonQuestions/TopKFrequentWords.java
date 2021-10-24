import java.util.*;

/**
 * Created on:  Jan 16, 2021
 * Questions: https://aonecode.com/aplusplus/interviewctrl/getInterview/5552215011
 */

public class TopKFrequentWords {

    public static void main(String[] args) {
        System.out.println(getTopGames(10, 2, new String[]{"cause", "boy", "range"}, 1, new String[]{
                "sit investment professional small draw possible ahead coach boy best rock require ",
                "feeling during husband kill behind seek lawyer fight draw become analysis talk ",
                "he-baby certain cause take cold close cause life ball response "}));
        System.out.println(getTopGames(10, 1, new String[]{"trader", "joe"}, 1, new String[]{"trader joe's",
                "joe'asdf",
                "joe'xyz",
                "joe`book",
                "joe-biden",
                "bitcoin trader"}));
        System.out.println(getTopGames(10, 2,
                new String[]{"interesting", "act", "price", "plan", "into", "lot", "culture", "ever", "couple", "no"}, 10,
                new String[]{"green hit position change language ever` best! else month either employee inside party hard letter dark? eat research far! in result price several interesting prevent manager. create country physical general anything hold death relate create street price financial program plan impact box even leg suggest note price plant so something common power? act someone modern ",
                        "senior artist n't blue act again serious. official, member often population could manager nature decision great everything free believe lot! really ",
                        "second interesting, into decision dark lot lot soon concern suggest? blue life election ever since accept` I table build lot between` prove law plan have help admit stock ",
                        "kill picture after list` identify down economic build assume no citizen present many let operation indeed discover hand Congress able end now kid, change audience relationship couple appear, customer concern firm mean officer sing ",
                        "past onto still ever oh` season anyone remember certain memory real none party die central subject almost! reflect key national among security site assume increase charge back approach music` should along him suffer especially produce own? appear exist front parent season difficult although, couple may n't oil class interesting table present ",
                        "deep candidate real bad test natural edge into! stand into into song Republican? personal beat economic find discussion draw expect ",
                        "he stand sound sound computer loss fill determine rich sing carry significant adult move improve door left charge easy minute each best forward six pressure politics? describe become particular brother smile population, paper put! market section recent ",
                        "policy close attack service able memory break Congress animal half artist choose expect subject piece at myself sense. hang plan alone alone here behavior outside none language indeed head step rich interesting away interesting ",
                        "go sit! help study` kid bar station cut! sure player pressure tax either game! local seem, no disease break because knowledge fine scene carry into ask fight professional far first benefit another` something process impact all. someone resource amount several fund interesting ",
                        "act example operation lot rule into interesting couple collection price meeting although lot record onto conference according easy! interesting stop culture situation friend"}
        ));
        System.out.println(getTopGames(10, 9,
                new String[]{"author", "instead", "as", "pretty", "must", "support", "legal", "remember", "in", "address"}, 20,
                new String[]{"part agent ok community director'sit-author as indeed pattern official color address could admit street money standard probably challenge significant budget same author remember assume ",
                        "benefit fire in legal pretty ago as marriage kill prove bit reflect-dead half cup'author action check miss quickly legal'meet-push remember language eat green sit crime stay-few risk get sea instead son-among fact investment positive-hundred suggest security energy-much ago price boy remain among ",
                        "instead religious remember address media-sometimes-light financial ever moment light-establish newspaper person others drug show mean name matter hand management must serious increase power range seem reveal south job rate part as source'place receive can as good hot during task many seek mission carry draw second strategy ",
                        "entire space address process instead ",
                        "support easy after poor picture political campaign alone perform local country cancer explain prepare party man spring door seven million note medical develop reality argue n't ",
                        "heat image analysis-less act purpose actually century information-list leg-long board own court'marriage moment development store soldier create line share dream property teacher tax guess ",
                        "indeed in agree must figure in'democratic support manager exactly pretty resource ",
                        "store pretty fund-eat itself along available long room-book success'grow might determine often including despite as focus serious recent partner problem provide author hair manager agency center skin help morning-contain fly-agreement play military investment difficult room idea society he if ",
                        "kill forward buy in land force officer'card others'government'positive lead religious oil decide pressure address-legal argue raise glass instead pretty standard cover star message resource as must appear condition hang as'support ",
                        "hit'order must can above must our state clear full nor reach'finger candidate morning person enjoy police always take enjoy beyond strategy remember hang color author scientist as remember reflect fall more accept-federal quite check finally-around dinner over draw also-key task business set ",
                        "enough hang interest chair from eye century entire himself religious soldier pretty need painting conference task'hundred front newspaper-he need south set subject else pretty relate parent process floor beyond military both shake clear rise anyone case each teach former group action big couple must'customer-space ",
                        "charge-guy large bed legal color physical court instead end'American instead shoulder right lay ok consumer-five pretty scientist specific official-admit'remember legal remember-build determine'consider'as ",
                        "director sort as'address away'serious lawyer huge full-career legal coach before almost-provide short above could choose food plan tell must patient term-strong middle as significant bring ",
                        "legal mission in itself relate after mind author must state cell instead legal because after federal support on hour seat spring many ",
                        "six-sing poor some hospital else single fall idea enough office away people remember argue bring hair everybody remember ",
                        "as perhaps remember instead pretty-",
                        "improve present-positive author remember support debate loss happen government actually stage news read say compare little so must-source floor development significant finger conference pressure ",
                        "person run'instead share-himself former save support answer make operation mother pretty author standard some next in fight gas avoid-me media campaign in-majority in make in me-factor ",
                        "explain heavy become major size field nation author ten Congress instead sea-couple citizen medical keep baby like five'media he church probably instead legal tax-quality boy must often billion'",
                        "material answer in health avoid-reduce personal-address civil interesting instead bag technology-in democratic card central free owner clearly clearly even support legal movement pretty any after police responsibility person administration support pretty politics-"}
        ));
    }

    public static List<String> getTopGames(int num, int topKGames, String[] games, int numReviews, String[] reviews) {
        Map<String, Integer> totalCount = new HashMap<>(), reviewsCount = new HashMap<>(), gameIdx = new HashMap<>();
//        0: total, 1: reviews count
        for (int i = 0; i < games.length; i++) {
            gameIdx.putIfAbsent(games[i].toLowerCase(), i);
        }
        analyzeReviews(reviews, gameIdx, totalCount, reviewsCount);
        Comparator<int[]> sort = (v1, v2) -> v1[1] == v2[1] ? Integer.compare(v1[2], v2[2]) : Integer.compare(v1[1], v2[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>(sort);
//        0: idx, 1: total, 2: unique
        for (String game : totalCount.keySet()) {
            pq.add(new int[]{gameIdx.get(game), totalCount.get(game), reviewsCount.get(game)});
            if (pq.size() > topKGames) pq.poll();
        }
        LinkedList<String> result = new LinkedList<>();
        while (!pq.isEmpty()) {
            result.addFirst(games[pq.poll()[0]]);
        }
//        return pq.stream().map(val -> val[0]).map(idx -> games[idx]).collect(Collectors.toList());
//        return pq.stream().sorted(sort).map(val -> val[0]).map(idx -> games[idx]).collect(Collectors.toList());
        return result;
    }

    public static List<String> topMentioned(int topKGames, String[] games, String[] reviews) {
        Map<String, Integer> totalCount = new HashMap<>(), reviewsCount = new HashMap<>(), gameIdx = new HashMap<>();
//        0: total, 1: reviews count
        for (int i = 0; i < games.length; i++) {
            gameIdx.putIfAbsent(games[i].toLowerCase(), i);
        }
        analyzeReviews(reviews, gameIdx, totalCount, reviewsCount);
        Comparator<int[]> sort = (v1, v2) -> v1[1] == v2[1] ? Integer.compare(v1[2], v2[2]) : Integer.compare(v1[1], v2[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>(sort);
//        0: idx, 1: total, 2: unique
        for (String game : totalCount.keySet()) {
            pq.add(new int[]{gameIdx.get(game), totalCount.get(game), reviewsCount.get(game)});
            if (pq.size() > topKGames) pq.poll();
        }
        LinkedList<String> result = new LinkedList<>();
        while (!pq.isEmpty()) {
            result.addFirst(games[pq.poll()[0]]);
        }
//        return pq.stream().map(val -> val[0]).map(idx -> games[idx]).collect(Collectors.toList());
//        return pq.stream().sorted(sort).map(val -> val[0]).map(idx -> games[idx]).collect(Collectors.toList());
        return result;
    }

    private static void analyzeReviews(String[]
                                               reviews, Map<String, Integer> games, Map<String, Integer> totalCount, Map<String, Integer> reviewsCount) {
        for (String review : reviews) {
            Set<String> curReviewGames = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < review.length(); i++) {
                char cur = review.charAt(i);
                if (Character.isAlphabetic(cur)) {
                    sb.append(Character.toLowerCase(cur));
                } else if (cur == ' ') {
                    String word = sb.toString();
                    sb = new StringBuilder();
                    if (games.containsKey(word)) {
//                        If the current word is a game word.
                        totalCount.put(word, totalCount.getOrDefault(word, 0) + 1);
                        if (curReviewGames.add(word)) {
                            reviewsCount.put(word, reviewsCount.getOrDefault(word, 0) + 1);
                        }
                    }
                }
            }
            String word = sb.toString();
            if (word.length() > 0 && games.containsKey(word)) {
//                        If the current word is a game word.
                totalCount.put(word, totalCount.getOrDefault(word, 0) + 1);
                if (curReviewGames.add(word)) {
                    reviewsCount.put(word, reviewsCount.getOrDefault(word, 0) + 1);
                }
            }
        }
    }
}
