import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.lang.Math;

public class Hash {

    static String[] convert(String filepath, int mod) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        String[] output = new String[mod];
        String temp;
        String[] ttab;
        for(int i = 0; i < mod; i++) {
            temp = br.readLine();
            ttab = temp.split(" ");
            output[i] = ttab[1];
        }
        br.close();
        return output;
    }

    static int[] hashValue(Item[] tab, int k) {
        int i = 0;
        int m = tab.length;
        int h1, h2, h;
        int[] output = new int[2];
        do {
            h1 = k%m;
            h2 = 1 + (k%(m-2));
            h = h1 + (i*h2);
            i++;
        } while(!(tab[h].name.equals(null)));
        output[0] = h;
        output[1] = i;
        return output;
    }

    static int intValue(String name) {
        char[] temp = name.toCharArray();
        int val = 0;
        for(int i = 1; i <= temp.length; i++) val += i*((int)temp[i-1]);
        return val;
    }

    static double checkCapacity(Item[] tab) {
        int count = 0;
        for(int i = 0; i < tab.length; i++) if(tab[i].num != 0) count++;
        return ((double)count)/((double)tab.length);
    }

    static double avgTry(Item[] tab) {
        int count = 0;
        int sum = 0;
        for(int i = 0; i < tab.length; i++) {
            if(tab[i].num != 0) {
                sum += tab[i].num;
                count++;
            }
        }
        return ((double)sum)/((double)count);
    }

    static void hashIt(String[] input, Item[] output) {
        double cap = 0.5;
        for(int i = 0; i < input.length; i++) {
            if(checkCapacity(output) >= cap) {
                System.out.println("Średnia ilość prób wstawienia przy "+Math.round(cap*100)+"% wypełnienia tabeli wynosi "+avgTry(output));
                cap+=20;
            }
            int[] temp = hashValue(output, intValue(input[i]));
            output[temp[0]].name = (input[i]);
            output[temp[0]].num = (temp[1]);
        }
    }
    
    public static void main(String[] args) throws IOException {
        String filepath = "nazwiskaASCII.txt";
        int mod1 = 29;
        int mod2 = 2539;

        String[] names1 = new String[mod1];
        names1 = convert(filepath, mod1);
        Item[] hashTable1 = new Item[mod1];
        Arrays.fill(hashTable1, new Item());
        hashIt(names1, hashTable1);

        String[] names2 = new String[mod2];
        names2 = convert(filepath, mod2);
        Item[] hashTable2 = new Item[mod2];
        Arrays.fill(hashTable2, new Item());
        hashIt(names2, hashTable2);
    }
}