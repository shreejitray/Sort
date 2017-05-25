package mergeSort;

import utility.ScannerInput;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by schaud3 on 5/24/17.
 */
public class Main extends ScannerInput {
    public void sort() throws IOException {
        Scanner in = input("/mergeSort/input");
        int size = in.nextInt();
        int[] arr = new int[size];
        int[] sorted = new int[size];
        for (int i=0;i<size;i++){
            arr[i]=in.nextInt();
        }
        int startIndex,endIndex,midIndex;
        startIndex=0;
        endIndex=size-1;
        mergeSort(arr,startIndex,endIndex);
        for (int i=0;i<size;i++){
            System.out.println(arr[i]);
        }
    }


    public void mergeSort(int[] arr, int startIndex,int endIndex){
        if (startIndex >= endIndex){
            return;
        }
        int midIndex = (endIndex + startIndex)/2;
        mergeSort(arr,startIndex,midIndex);
        mergeSort(arr,midIndex+1,endIndex);
        merge2(arr,startIndex,midIndex,endIndex);
    }

    // O(n) space, O(n) time
    public void merge(int[] arr,int startIndex,int midIndex,int endIndex){
        int index1 = startIndex;
        int index2 = midIndex+1;
        int insertAt = 0;
        int[] sorted = new int[endIndex-startIndex+1];

        while(index1 <= midIndex && index2 <= endIndex){
            if(arr[index1]<arr[index2]){
                sorted[insertAt] = arr[index1];
                index1++;
                insertAt++;
            }else {
                sorted[insertAt] = arr[index2];
                index2++;
                insertAt++;
            }
        }
        if(index1 <= midIndex) {
            while(index1 <= midIndex) {
                sorted[insertAt] = arr[index1];
                index1++;
                insertAt++;
            }
        }
        if(index2 <= endIndex) {
            while(index2 <= endIndex){
                sorted[insertAt] = arr[index2];
                index2++;
                insertAt++;
            }
        }
        for(int i=0;i<sorted.length;i++) {
            arr[startIndex + i] = sorted[i];
        }
    }


    // // O(1) space, O(n2) time
    public void merge2(int[] arr, int startIndex, int midIndex, int endIndex){
        int index1 = startIndex;
        int index2 = midIndex+1;
        while(index1<=midIndex && index2 <= endIndex){
            if(arr[index1]<arr[index2]){
                index1++;
            }else{
                int temp = arr[index2];
                for(int i=index2-1;i>=index1;i--){
                    arr[i+1] = arr[i];
                }
                arr[index1] = temp;
                index2++;
                index1++;
                midIndex++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main program = new Main();
        program.sort();
    }
}
