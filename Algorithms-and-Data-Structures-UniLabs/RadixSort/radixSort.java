import java.io.*;
import java.util.*;

public class radixSort {
    public static void radixSort(String[] arr){
        int length = 7;
        for(int i = arr.length; i > 0; i--){
            countingSort(arr, length-1);
            length--;
        }
    }

    public static void countingSort(String[] arr, int pos){
        String[] output = new String[arr.length];
        int[] count = new int[26];
        int i;
        Arrays.fill(count, 0);

        for(i = 0; i < arr.length; i++) {
            char[] name = arr[i].toCharArray();
            count[((int)(name[pos]))-96]++;
        }

        for(i = 1; i < 26; i++) {
            count[i] += count[i-1];
        }

        for(i = arr.length-1; i >= 0; i--) {
            char[] name = arr[i].toCharArray();
            output[count[((int)(name[pos]))-96]] = arr[i];
            count[((int)(name[pos]))-96]--;
        }

        for(i = 0; i < arr.length; i++) {
            arr[i]=output[i];
        }
    }

    public static void main(String[] args){
        String[] lista = {"abcdbad","agbamsd","afbehsh","asdbend","arbelel","abbaba","arghklj"};
        System.out.println(lista);
        radixSort(lista);
        System.out.println(lista);
    }
}