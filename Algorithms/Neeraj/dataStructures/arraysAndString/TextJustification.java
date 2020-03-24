import java.util.*;

class TextJustification{
  public static void main(String[] args) {
    // System.out.println(fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."},16));
    // System.out.println(fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"},16));
    System.out.println(fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain",
         "to","a","computer.","Art","is","everything","else","we","do"},20));
  }
  public static List<String> fullJustify(String[] words, int maxWidth) {
    List<String> output = new ArrayList<>();
    List<String> temp = new ArrayList<>();
    int currStringLength =0, space=0, lineCounter =0;
    Map<Integer, List<String>> map = new HashMap<>();
    Map<Integer, Integer> lineCounterMap = new HashMap<>();
    for(String word: words){
      // System.out.println("currStringLength=" + currStringLength + "space = " + space + " word=" + word);
      if(currStringLength+space+word.length() > maxWidth){
        map.put(lineCounter, new ArrayList<>(temp));
        lineCounterMap.put(lineCounter, currStringLength);
        // Then reset the temp list, currStringLength, space.
        temp.clear();
        currStringLength = space=0;
        lineCounter++;
      }
      temp.add(word);
      currStringLength += word.length();
      space++;
    }
    if(temp.size() >0){
      map.put(lineCounter, new ArrayList<>(temp));
      lineCounterMap.put(lineCounter, currStringLength);
    }
    // System.out.println("map = "+ map);
    // System.out.println("lineCounterMap = " + lineCounterMap);
    int lines = map.size();
    for(int i = 0; i < lines; i++){
      if(map.containsKey(i)){
        output.add(padListOfStrings(map.get(i),lineCounterMap.get(i),maxWidth,i,lineCounter));
      }
    }
    return output;
  }
  private static String padListOfStrings(List<String> words, int count, int maxCount, int currLine, int totalLine){
    int totalSpaces = maxCount - count;
    int size = words.size();
    StringBuilder sb = new StringBuilder();
    if(size ==1){
      sb.append(words.get(0));
      sb.append(getSpaceString(totalSpaces));
    }else if(currLine == totalLine){
      int spaceCount = 0;
      for(int i = 0; i < size- 1; i++){
        sb.append(words.get(i));
        sb.append(" ");
        spaceCount++;
      }
      sb.append(words.get(size-1));
      sb.append(getSpaceString(totalSpaces - spaceCount));
    }else{
      int perWordCount = totalSpaces / (size-1);
      int rem = totalSpaces % (size-1);
      for(int i =0; i < size-1 ; i++){
        sb.append(words.get(i));
        if(rem >0){
          sb.append(getSpaceString(perWordCount+1));
          rem--;
        }else{
          sb.append(getSpaceString(perWordCount));
        }
      }
      sb.append(words.get(size-1));
    }
    return sb.toString();
  }
  private static String getSpaceString(int count){
    char[] chars = new char[count];
    Arrays.fill(chars, ' ');
    return new String(chars);
  }
}
