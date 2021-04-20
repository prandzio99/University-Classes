import java.io.*;

public class HashTable {
    Item[] list;

    public class Item {
        private int count;
        private String name;

        Item() {
            count = 0;
            name = null;
        }

        int getCount() {return count;}
        String getName() {return name;}
        void setCount(int c) {count = c;}
        void setName(String n) {name = n;}
    }
    
    HashTable(int size) {
        list = new Item[size];
        fill();
    }

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

    static HashTable hashIt(String[] input) {
        HashTable output = new HashTable(input.length);
        double cap = 0.5;
        for(int i = 0; i < input.length; i++) {
            if(output.cap() >= cap) {
                System.out.println("Średnia ilość prób wstawienia przy "+Math.round(cap)+"% wypełnienia tabeli: "+output.avg());
                cap+=0.2;
            }
            output.insert(input[i]);
        }
        return output;
    }

    void fill() {
        for(int i = 0; i < list.length; i++) list[i] = new Item();
    }

    double cap() {
        int counter = 0;
        for(int i = 0; i < list.length; i++) {
            if(list[i].count != 0) {
                counter++;
            }
        }
        return ((double)counter)/((double)list.length);
    }

    double avg() {
        int counter = 0;
        int sum = 0;
        for(int i = 0; i < list.length; i++) {
            if(list[i].getCount() != 0) {
                sum += list[i].getCount();
                counter++;
            }
        }
        return ((double)sum)/((double)counter);
    }

    void insert(String name) {
        int k = intValue(name);
        int i = 0;
        int m = list.length;
        int h, h1, h2;
        do {
            h1 = k%m;
            h2 = 1 + (k%(m-2));
            h = h1 + (i*h2);
        } while(list[h].getCount() != 0);
        list[h].setCount(i+1);
        list[h].setName(name);
    }

    static int intValue(String name) {
        char[] temp = name.toCharArray();
        int val = 0;
        for(int i = 1; i <= temp.length; i++) {
            val += i*((int)temp[i-1]);
        }
        return val;
    }



    public static void main(String[] args) throws IOException {
        String filepath = "nazwiskaASCII.txt";
        int mod1 = 29;
        int mod2 = 2539;

        String[] names1 = convert(filepath, mod1);
        HashTable one = hashIt(names1);

        String[] names2 = convert(filepath, mod2);
        HashTable two = hashIt(names2);
    }
}