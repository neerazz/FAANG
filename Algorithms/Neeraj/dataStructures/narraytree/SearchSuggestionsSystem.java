import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 13, 2021
 * Questions: https://leetcode.com/problems/search-suggestions-system/
 */

public class SearchSuggestionsSystem {

    public static void main(String[] args) {
        System.out.println(suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse"));
        System.out.println(suggestedProducts(new String[]{"havana"}, "havana"));
        System.out.println(suggestedProducts(new String[]{"bags", "baggage", "banner", "box", "cloths"}, "bags"));
        System.out.println(suggestedProducts(new String[]{"havana"}, "tatiana"));
        System.out.println(suggestedProducts(new String[]{"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnunqerptgas", "zmmirsxdhyxvmdybjzondyvrkzeafhvualsivfueweuusmsxbttdeofzeripaqv", "tyqcpfvorznmxxdzepfxabibcagilwjsqncxnpjqsxjzqqqbae", "tyqcpfvacyrjvmadrmntxotgvgivdvcuwygpjfwcuppunolukrum", "tyqcpfvrqwrcpusmfyhxaiasfbb", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqyalwiaj", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchidnpt", "lfjkcljnd", "zibrwfpwecubjlsjbkrhnvolnnzrqhdynloplzagwnuhpxhbvpxnqaifnln", "ybswoottdgryxtupichpvqjmcoytrwnfgzrrnaejojvpzmttlzw", "tyqcplghosxjviooiyddhvzzrhuuwkiosmgafxyajcdyqlmthqkoylxhtxdruw", "okoscfpxcndzgbtsozdofgnomtglmoaewgzzjvrxezoq", "cxkwvaytkxgafeltbanhsvxlorigkuxnsxlmhvwqm", "iamtabcpdagicnvdvqcfykonsazrbdivxtczpgqgxjrifukmqjw", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbneryahanhrhkal", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnunl", "tyqcpfvorznmxxdzsuyushueegfrnlzbydnefcfagqnxglkulegntoml", "zlovtmburfkd", "vlzfaamutsfqefpafzffwhvpfw", "bbufxzwpryyakbxuhwwplvdptgybbykqxirsrahsokviihxrawcbgwrktvgacmwtc", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbzw", "kjundphljswl", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqhlqnapfkcqpdb", "stcphvgxvcaysehvrfdfllwvxf", "epbtkgnnupbbdqgheyaks", "gilhnlfkdz", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwghy", "yswdsvnzucvsdzrmeghevjrfuhoebfedvyvortaxppwqncmspctdcjlwdxfnc", "baizdtmgozykukcrkapsnp", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgcsfjgtwqqubbhjkzmio", "iblyydfzztmtyjmgrxvyjwcobfyxcgyrbtnfhhxswxahze", "tyqcpfyggtmjahhpjzwhohvchyofsxwkehq", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniaymgkdduoabmp", "gpsqlqorcbqffdxlnijgvzvxilnbkynwscuoymqyg", "eidradnaqjwmucbrgtp", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzopnqxxcxshbhdmippldmcuxlvc", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbfmryrbgicgzqecje", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuze", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqandxbuvshebs", "tyqcqqxonxtwakxlrceyknbockvovdwumbjkfrgmudiafbqlflonfavpsrfq", "tyqcpfvorznmxxdzsnkjnrrzpfourbghe", "ziarqmfvzqpqhunfxwfwjtetotozkjaszznbtrvtxarysaxq", "tyqcpfvorznmxfmlzlcuikpxvahtfbfipjcgmeusshufvnirwcopdnvnop", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvdertpdpdjsngezrnyjxotgonuigmqkgipgb", "tyqcpfvorznmxxdzsnkjnrrzpfvfcvufmzzuqrjubsfzp", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqorqffebhoyfvgkspenqpcmvoxpybkjg", "oqojrvinnhlwuqllcsabkpfiusfucpjbsxzzhlgduawaqyp", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchviaxsw", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqnzudhzclswotlbgdffwiekw", "csgadyglxddodloklsegvsbtgtkloklmxkbxxyorcqwybktuzpyeaqasn", "tyqitegmijccjwxuwvchbvuvllmgsdugzxdkiqvnllhmsjyskxpzzds", "tyqcpfvorznigwmavbguxwhunsshdybhzszxvlnpingqgaghkqzeynbbbhgcxeydir", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnunflh", "tyqcpfvorznmbwmhfmudnurhismirfgvojpdmclw", "tyqcpfvjijiwoup", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejemb", "tyqcpfvorznmxxdzsnkjhvabtzucyooctzzrgehlsuyinrrnzjilfpalvqgwoey", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchvie", "tyqcpfvorznmxxxvjwfgcwegpibuifhfxyomnicutaegshpnschktxknqytritr", "tyqcpfvorznetvhiaobezckojwjbeg", "tyqcpfvorzmjabuccipqln", "frutebajqddrtrsmabfmdcgipssymldwscxbbrbpb", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchviotvqi", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchxeyrnlh", "yaxaddctugikoutgcwqsdekghoemtooljxvysnzqqvgpc", "tyqcpfvorznmxxdzsnkjn", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqggjwxdvqesbgrqei", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckoktdj", "mzwjshgbgbdogqbrhfgbjkrqogyynbdwwkdclsbpynlrhxeucuuo", "tyqcpfvorznmxxdzsnkjnrrztrqgpbvvxm", "u", "tyqcpfvorznmxjnsgyirdtzpwywpnrvgadkmdjghlmerbqysaebyge", "tyqcpfvorznmxxdzsnkjnrkjelwoqorxsnyjqdnxfava", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchvqqy", "hcav", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchviof", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwreznx", "yesupowwycvcdbknhrkfyvnpoqtdhcbhybqvhnvgukoohh", "hcvlnbmcrepblcqrvwpfsyevlpyldptubnxkntqhpounxjcw", "lwaxzivycjkanvikqpbrvdvjkaclyuyfitwfycsnfwjg", "tkruiswrcbzsbkwbhhvjzzuuiayqzbxjosjssacislcvbtcojpmyatkfgyx", "ftujoohzvjonlwxwskeydoxpfvbvrdndbhgpuvykif", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqqngbpbdtufkgunalbekxbkpajlgbjtqmswh", "tyqcpfvorznmxxdzsnkjnrrzpewgvvnicz", "tyqcpfvorznmxxdzsnkjnrrzpfgknjxnepksgdzwxsbziwdzsiiyarxhtpp", "jumcvboxaxjfybdlezcjrarolxjtsuweaigkiudusinfmnczdualqzlpwkm", "tyqcpfvoxegnpqesbaugr", "bteznmwyh", "rtbpifxevchngjnlumvtqtpebgtoznvvrzfxqzmcktoxydbstbvukrunnyeqwfd", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejysfrlewzsgukyahggau", "mvrrbfbfwyrxooopgcbwmtjfepejyfrqdkyaqencqqlagoilrtdndfyn", "tyqcpfvorznmyrzwhjxvhooytltygrakvgkqumrimazzhzoueyqnjz", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchviob", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwoyvqczogovza", "tyqcpfvorznmxxdzsnkjnrrzpfgknvfnzshqqfpr", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjghvqg", "zqrnaierpnsigujuxrftdiauazddadqmrwcimxyztwumwzyjcrqvuexnitdecfgo", "xusxbbilivpovzsjvfsdnacipk", "tyqcpfvorznmxxdzkbqgrgeolnwhtvlckmiattpmxwwtmlifnexxbgtpjslwhczrjlhr", "eiuytvdzhcodcrdgthxynurtpsdyguupijjluucpfinrfnsjkdbbzexfmctejlgvd", "tyqcpfudqjrabwwvdvwmsyscnazaxpsjjhetouegipqevvointclztzummwrrbntjlsj", "tyqcpfvobzfvbiuoktjcqjfx", "tyqcpfvorznmxxdzsnamc", "ajqpomnpmsayhelmhfehjbvjaeszqigfqyuixbtyjy", "jpfxangixfavlhcssecxljksydrjxmaldhwpftinywtbmffsmtslefcuddk", "txryxhtutwdrqmpcapbcrlmhzsobueefwfekusmmylr", "etzqiepphjcleaocnwljcdn", "tyqcpfvokfxlbmbzmitacnromkoaoxl", "iddmxxcmwecfutbrbqeihhlnypckofuhkbydmljfemzrvlxsuskxkbgviybzu", "tyqcpfvorznmxxdzwilcfwrdlfqppdnuvgltuoooppwyomtvtggmsfxsxievdlsyame", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvzquhbkvburnhmerkuabrfcjwanzmfenz", "tyqcpqgaus", "zsbcqgctsjdjyfkdvcehawsqzacafwtjmhemfygdahkexvmkqkcehvek", "tyqcpfvorznmxxdzsnkjfesxjshxtlinfjltdfl", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnubpoqoghhgbpew", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdcuudsuqq", "tyqcpgwivyfquxqhbkjbioekqbsd", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnudxocavmwpggka", "tyqcpfvorznmxxdzsnkjnrrzpfgknvnlxdokehsjhiohwdeyikeajzipztzhwmxc", "pmpoycdxttisazazsgiswnsnhdmejpjbygvtjhwqydeugbouekvornbeiwmpehikbz", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwcpoxr", "qmgnrjtavzsqtwareroiihendgcvbzbcolvfoanmixxrxdtnmtevvv", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnunix", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetxpdyhmk", "tyqcpfvorznmxxdzsnkjnrfmy", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetaoqgbczdcemzlmqemy", "tyqcpfzmlffhifutomuvfvwaqatopvur", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvdvagddprewvlgx", "ozmyertmnlwybntwxmpynuynhqdbqhosvjwexzqgvdtnvxexxwwwwhqktmzbfkjfn", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckohyof", "rniiqnzbctzeyeeyrxhfzqgbccplsncvtswcrqmevplfzadlulazmpmhdojwaokn", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzakckmtmjxx", "tyqcpfvorznmxxdzsnkjnrrzpfgkhdwienfhpsqbyrvotbgchkkmvk", "tyqcpfvorznmxxdzsnkjnrrumaqtylptffsjzygeumkahutdmalkqtrhtgrsrqcyyti", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchvioncnr", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchvigzpo", "tyqcpfvorznmxxdzsnkjnrrzpfgkeduq", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnccdnakfkhtg", "lhehmbyzcnlwvr", "tyqcpfvojuuprlby", "wds", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqvegfwmtdcrvdb", "tyqcpfvorznpkeynkmbbyptclmhxxlyjzejqbcatgfrmkbbmxs", "tyqcpfvorznmiqmfrhihxsagizcrwyaukrjwbbgrxdzknq", "ghhlssixrouzbqcpmxzmsnybaygtb", "jndewk", "tyqcpfvorznmxxdzsnkjnrrzpdqanmxattjhgnflnoyynevsxvpbwfmfrnlc"},
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchviotvdticwxwcliylrpvrokbcguhnfvpd"));
    }

    public static List<List<String>> suggestedProducts_rev2(String[] products, String searchWord) {
        List<List<String>> suggestions = new ArrayList<>();
        int productsLength = products.length;
        int wordsLength = searchWord.length();
        int maxSuggestions = 3;
        Arrays.sort(products);

        for (int i = 1; i <= wordsLength; i++) {
            String prefix = searchWord.substring(0, i);
            List<String> suggestion = new ArrayList<>();
            for (int j = 0; j < productsLength; j++) {
                String product = products[j];
                if (suggestion.size() >= maxSuggestions) break;
                if (product.startsWith(prefix)) {
                    suggestion.add(product);
                }
            }
            suggestions.add(suggestion);
        }
        return suggestions;
    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Node node = new Node();
        for (String product : products) {
            node.add(product, 0);
        }
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            char cur = searchWord.charAt(i);
            List<String> top = new ArrayList<>();
            if (node != null) {
                Node next = node.next[cur - 'a'];
                if (next != null) {
                    top.addAll(next.pq);
                    Collections.sort(top);
                }
                node = next;
            }
            result.add(top);
        }
        return result;
    }

    static class Node {
        PriorityQueue<String> pq = new PriorityQueue<>((v1, v2) -> v2.compareTo(v1));
        Node[] next = new Node[26];

        public void add(String str, int idx) {
            pq.add(str);
            if (str.length() == idx) return;
            char cur = str.charAt(idx);
            if (next[cur - 'a'] == null) next[cur - 'a'] = new Node();
            next[cur - 'a'].add(str, idx + 1);
            if (pq.size() > 3) pq.poll();
        }
    }
}
