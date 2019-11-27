import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


public class TestClass {
	
	public static long doheapSort(int arr[]) 
    {   long start = System.currentTimeMillis();
        int n = arr.length; 
  
        // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(arr, n, i); 
  
        // One by one extract an element from heap 
        for (int i=n-1; i>=0; i--) 
        { 
            // Move current root to end 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
  
            // call max heapify on the reduced heap 
            heapify(arr, i, 0); 
        }
       
        long time = System.currentTimeMillis() - start;
        return time;
    } 
  
    // To heapify a subtree rooted with node i which is 
    // an index in arr[]. n is size of heap 
  public static void heapify(int arr[], int n, int i) 
    { 
        int largest = i; // Initialize largest as root 
        int l = 2*i + 1; // left = 2*i + 1 
        int r = 2*i + 2; // right = 2*i + 2 
  
        // If left child is larger than root 
        if (l < n && arr[l] > arr[largest]) 
            largest = l; 
  
        // If right child is larger than largest so far 
        if (r < n && arr[r] > arr[largest]) 
            largest = r; 
  
        // If largest is not root 
        if (largest != i) 
        { 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
  
            // Recursively heapify the affected sub-tree 
            heapify(arr, n, largest); 
        } 
    } 
	 public static void merge(int arr[], int l, int m, int r) 
	    { 
	        // Find sizes of two subarrays to be merged 
	        int n1 = m - l + 1; 
	        int n2 = r - m; 
	  
	        /* Create temp arrays */
	        int L[] = new int [n1]; 
	        int R[] = new int [n2]; 
	  
	        /*Copy data to temp arrays*/
	        for (int i=0; i<n1; ++i) 
	            L[i] = arr[l + i]; 
	        for (int j=0; j<n2; ++j) 
	            R[j] = arr[m + 1+ j]; 
	  
	  
	        /* Merge the temp arrays */
	  
	        // Initial indexes of first and second subarrays 
	        int i = 0, j = 0; 
	  
	        // Initial index of merged subarry array 
	        int k = l; 
	        while (i < n1 && j < n2) 
	        { 
	            if (L[i] <= R[j]) 
	            { 
	                arr[k] = L[i]; 
	                i++; 
	            } 
	            else
	            { 
	                arr[k] = R[j]; 
	                j++; 
	            } 
	            k++; 
	        } 
	  
	        /* Copy remaining elements of L[] if any */
	        while (i < n1) 
	        { 
	            arr[k] = L[i]; 
	            i++; 
	            k++; 
	        } 
	  
	        /* Copy remaining elements of R[] if any */
	        while (j < n2) 
	        { 
	            arr[k] = R[j]; 
	            j++; 
	            k++; 
	        } 
	    } 
	  
	    // Main function that sorts arr[l..r] using 
	    // merge() 
	 public static long domergeSort(int arr[], int l, int r) 
	    {   
		    long start = System.currentTimeMillis();
	        if (l < r) 
	        { 
	            // Find the middle point 
	            int m = (l+r)/2; 
	  
	            // Sort first and second halves 
	            domergeSort(arr, l, m); 
	            domergeSort(arr , m+1, r); 
	  
	            // Merge the sorted halves 
	            merge(arr, l, m, r); 
	        }
	        long time1 = System.currentTimeMillis() - start;
	        return time1;
	    } 
	public static long doquickSort(int[] arr, int start, int end){
	    long start1 = System.currentTimeMillis();
	    
        int partition = partition(arr, start, end);
 
        if(partition-1>start) {
            doquickSort(arr, start, partition - 1);
        }
        if(partition+1<end) {
           doquickSort(arr, partition + 1, end);
        }
        long time1 = System.currentTimeMillis() - start1;
        return time1;
        
    }
 
    public static int partition(int[] arr, int start, int end){
        int pivot = arr[end];
 
        for(int i=start; i<end; i++){
            if(arr[i]<pivot){
                int temp= arr[start];
                arr[start]=arr[i];
                arr[i]=temp;
                start++;
            }
        }
 
        int temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;
 
        return start;
    }
	
	  public static long docountingSort(int[] input, int k) {
		   long start1 = System.currentTimeMillis();
		    int counter[] = new int[k + 1];
		    
		    // fill buckets
		    for (int i : input) {
		      counter[i]++;
		    }
		    
		    // sort array
		    int ndx = 0;
		    for (int i = 0; i < counter.length; i++) {
		      while (0 < counter[i]) {
		        input[ndx++] = i;
		        counter[i]--;
		      }
		    }
		    long time1 = System.currentTimeMillis() - start1;
	        return time1;
		    
		 }


	   public static long doselectionSort(int arr[])
	    {   
		    long start1 = System.currentTimeMillis();
	        int n = arr.length;
	 
	        // One by one move boundary of unsorted subarray
	        for (int i = 0; i < n-1; i++)
	        {
	            // Find the minimum element in unsorted array
	            int min_idx = i;
	            for (int j = i+1; j < n; j++)
	                if (arr[j] < arr[min_idx])
	                    min_idx = j;
	 
	            // Swap the found minimum element with the first
	            // element
	            int temp = arr[min_idx];
	            arr[min_idx] = arr[i];
	            arr[i] = temp;
	        }
	        long time1 = System.currentTimeMillis() - start1;
	        return time1;
	       
	    }
	   
	public static long doInsertionsort(int arr[]) throws IOException 
	    { 
		    long start1 = System.currentTimeMillis();
	        int n = arr.length; 
	        for (int i=1; i<n; ++i) 
	        { 
	            int key = arr[i]; 
	            int j = i-1; 
	  
	            /* Move elements of arr[0..i-1], that are 
	               greater than key, to one position ahead 
	               of their current position */
	            while (j>=0 && arr[j] > key) 
	            { 
	                arr[j+1] = arr[j]; 
	                j = j-1; 
	            } 
	            arr[j+1] = key; 
	        }
	        long time1 = System.currentTimeMillis() - start1;
	        BufferedWriter outputWriter = null;
	       
	        outputWriter = new BufferedWriter(new FileWriter("/Users/ziyayilmaz/Desktop/Sortednumbers.txt"));
	        for (int i = 0; i < arr.length; i++) {
	          // Maybe:
	          outputWriter.write(arr[i]+"\n");
	          // Or:
	          outputWriter.write(Integer.toString(arr[i]));
	          outputWriter.newLine();
	        }
	        outputWriter.flush();  
	        outputWriter.close();
	        return time1;
	    } 
	    


	public static void main(String[] args) throws IOException {
		
		File file = new File("/Users/ziyayilmaz/Desktop/numbers.txt");
		Scanner S = new Scanner(file);
		ArrayList <Integer> arr = new ArrayList <Integer>();
		while (S.hasNextInt()) {
			arr.add(S.nextInt());
		}
		int [] array = new int [arr.size()];
		for(int i = 0 ; i<arr.size(); i++) {
			array[i]=arr.get(i);
		}
		//System.out.print(array.length);
		//long arr2 = doselectionSort(array);
		//System.out.println("the time for sorting using Selection sort is :"+arr2);
		//long arr21 = doInsertionsort(array);
		//System.out.println("The Time for sorting using Insertion sort is: "+arr21);
		//long arr213 = docountingSort(array, 999998);
	   // System.out.println("The Time for sorting using Counting sort is: "+arr213);
		//long arr2134= doquickSort(array,0,array.length-1);
	   // System.out.println("The Time for sorting using quick sort is: "+arr2134);
		//long  arr21345 = domergeSort(array,0,array.length-1);
		//System.out.println("The Time for sorting using merge sort is: "+arr21345);
		//long arr213456 = doheapSort(array);
		//System.out.println("The Time for sorting using heap sort is: "+arr213456);
  }
}
