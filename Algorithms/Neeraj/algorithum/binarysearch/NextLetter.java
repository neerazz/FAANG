import java.util.*;
import java.io.*;

/**
 * Created on:  Oct 08, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/g2w6QPBA2Nk
 */

public class NextLetter {

    public static char searchNextLetter(char[] letters, char key) {
        int start = 0, end = letters.length-1;
        while(start < end){
            int mid = start + (end - start) /2;
            if(letters[mid] == key){
                if(mid == letters.length-1) return letters[0];
                else return letters[mid+1];
            }else if(letters[mid] < key){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        if(letters[start] > key){
            return letters[start];
        }
        return letters[0];
    }

    public static void main(String[] args) {
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
    }
}
