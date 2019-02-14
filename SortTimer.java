import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

class SortTimer 
{ 
  // copy and paste your code in here:
  public void sort(double arr[], long start, long end) {

   // double sort(double arr[]) 
    { 
        int n = arr.length; 
        for (int gap = n/2; gap > 0; gap /= 2) 
        { 
            for (int i = gap; i < n; i += 1) 
            { 
                double temp = arr[i]; 
                int j; 
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) 
                    arr[j] = arr[j - gap]; 
                arr[j] = temp; 
            } 
        } 
      //  return 0; 
    } 
  }
  
  // Test program 
  public static void main(String args[]) 
  { 
    SortTimer st = new SortTimer(); 
    Scanner myScanner = new Scanner(System.in);  // to read in the number of elements
    
    System.out.println("How many items would you like to sort?"); 
    int numNums = myScanner.nextInt();
    myScanner.close();
    
    if (numNums < 1 || numNums > 1000000) {
      System.out.println("Invalid # please try again from 1 to 1000000");
      return;
    }
    
    System.out.println("Creating a random array of doubles of length " + numNums);
    double arr[] = new double[numNums];
    Random randomno = new Random();
    for (int i = 0; i < numNums; i++) {
      arr[i] = randomno.nextDouble() * 20000000 - 10000000;
    }
    
    // only print out the array if there are less than 10 (for testing)
    if (numNums <= 10) {
      System.out.println(Arrays.toString(arr));
    }
    
    System.out.println("Starting sort"); 
    long startTime = System.nanoTime();                // get the starting time
    st.sort(arr, 0, arr.length - 1);                   // This calls your sort method from the st object on the array arr
    long duration = (System.nanoTime() - startTime);   // calculates how long your method ran
    double durSecs = ((double)duration) / 1000000000;  // converts the time to seconds
    
    if (duration / 1000000 > 0) {
      System.out.println("It took: " + durSecs + " seconds, or " + duration / 1000000 + " MILLIseconds to sort " + numNums + " items");
    } else if (duration / 1000 > 0) {
      System.out.println("It took: " + durSecs + " seconds, or " + duration / 1000 + " MICROseconds to sort " + numNums + " items");
    } else {
      System.out.println("It took: " + durSecs + " seconds, or " + duration + " NANOseconds to sort " + numNums + " items");
    }
    
    // only print out the sorted array if there are less than 10 elements (for testing)
    if (numNums <= 10) {
      System.out.println(Arrays.toString(arr));
    }
  } 
} 