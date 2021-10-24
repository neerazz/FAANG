/**
 * Created on:  Aug 19, 2020
 * Questions: https://www.hackerrank.com/challenges/designer-pdf-viewer/problem
 */
public class DesignerPDFViewer {
    public static void main(String[] args) {

    }

    static int designerPdfViewer(int[] h, String word) {
        int tallest = 0;
        for (char cur : word.toCharArray()) {
            tallest = Math.max(tallest, h[cur - 'a']);
        }
        return tallest * word.length();
    }
}
