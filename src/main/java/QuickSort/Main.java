package QuickSort;

import utility.ScannerInput;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by schaud3 on 5/26/17.
 */
public class Main extends ScannerInput{
    public void sort() throws IOException {
        Scanner in = input("/QuickSort/input");
        int size = in.nextInt();
        int[] arr = new int[size];
        for(int i=0;i<size;i++){
            arr[i] = in.nextInt();
        }
        quickSort(arr,0,size-1);
        for(int i=0;i<size;i++){
            System.out.println(arr[i]);
        }

    }
    public void quickSort(int[] arr, int startIndex, int endIndex){

        if(startIndex >= endIndex){
            return;
        }
        int pivot = (endIndex + startIndex)/2;
        for(int i=pivot+1;i<=endIndex;i++){
            if(arr[i]<=arr[pivot]){
                arr[pivot+1] = arr[pivot]+arr[pivot+1];
                arr[pivot] = arr[pivot+1]-arr[pivot];
                arr[pivot+1] = arr[pivot+1]-arr[pivot];
                if(i != pivot+1){
                    arr[pivot] = arr[pivot]+arr[i];
                    arr[i] = arr[pivot]-arr[i];
                    arr[pivot] = arr[pivot]-arr[i];
                }
                pivot++;
            }
        }
        for(int i=pivot-1;i>=startIndex;i--){
            if(arr[i]>=arr[pivot]){
                arr[pivot-1] = arr[pivot]+arr[pivot-1];
                arr[pivot] = arr[pivot-1]-arr[pivot];
                arr[pivot-1] = arr[pivot-1]-arr[pivot];
                if(i != pivot-1){
                    arr[pivot] = arr[pivot]+arr[i];
                    arr[i] = arr[pivot]-arr[i];
                    arr[pivot] = arr[pivot]-arr[i];
                }
                pivot--;
            }
        }
        quickSort(arr,startIndex,pivot-1);
        quickSort(arr,pivot+1,endIndex);
    }

    public static void main(String[] args) throws IOException {
        Main program = new Main();
        program.sort();
    }
}
