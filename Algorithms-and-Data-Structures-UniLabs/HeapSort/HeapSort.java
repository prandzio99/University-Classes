import java.io.*;
import java.lang.*;

public class HeapSort { 

static void buildMaxHeap(int arr[], int n) { 
	for (int i = 1; i < n; i++)	{ 
	if (arr[i] > arr[(i-1)/2]) 
	{ 
		int j = i; 
		while (arr[j] > arr[(j-1)/2]) { 
		    swap(arr, j, (j-1)/2); 
		    j = (j-1)/2; 
		    } 
	    } 
	} 
} 

static void heapSort(int arr[], int n) { 
	buildMaxHeap(arr, n); 

	for (int i = n-1; i > 0; i--) { 
	swap(arr, 0, i); 

	int j = 0, index; 

	do { 
		index = (2*j+1); 
		if (index < (i-1) && arr[index] < arr[index+1]) index++; 
		if (index < i && arr[j] < arr[index]) swap(arr, j, index);
		j = index; 
	    } while (index < i); 
	}
}

public static void swap(int[] a, int i, int j) { 
	int temp = a[i]; 
	a[i]=a[j]; 
	a[j] = temp; 
} 

public static int Size() throws IOException {
	BufferedReader br = null;
	try {br = new BufferedReader(new FileReader("input.txt"));} 
	catch (FileNotFoundException el) {el.printStackTrace();}

	int x = 0;
	String line;
	try {while ((line = br.readLine()) != null) x++;}
	catch (IOException e) {System.out.println("File read error");}
	return x;
}

public static void printArrayToFile(int[] array) throws IOException {
	PrintWriter pw = new PrintWriter(new FileWriter("output.txt", false));
	for (int i = 0; i < array.length; i++) pw.print(array[i]+"\n");
	pw.close();
}

public static void main(String args[]) throws IOException { 
	int[] array = new int[Size()];
	BufferedReader br = null;
	br = new BufferedReader(new FileReader("input.txt"));
	String line;
	for (int i = 0; (line = br.readLine()) != null; i++) {
		int value = Integer.parseInt(line);
		array[i] = value;
	}
	heapSort(array, array.length);
	printArrayToFile(array);
	br.close();
    } 
}