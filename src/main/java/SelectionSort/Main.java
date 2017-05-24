package SelectionSort;

import utility.ScannerInput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by schaud3 on 5/24/17.
 */
public class Main extends ScannerInput {
    public void selectionSort() throws IOException {
        Scanner in = input("/SelectionSort/input.txt");
        int size = in.nextInt();
        int[] arr = new int[size];
        int index = 0;
        while(index < size) {
            arr[index] = in.nextInt();
            index++;
        }
        index = 0;
        for(;index<size-1;index++) {
            int min = arr[index];
            int minIndex = index;
            for(int i=index+1;i<size;i++){
                if(min > arr[i]){
                    min = arr[i];
                    minIndex = i;
                }
            }
            if(minIndex != index){
                arr[minIndex] = arr[minIndex]+arr[index];
                arr[index] = arr[minIndex] - arr[index];
                arr[minIndex] = arr[minIndex] - arr[index];
            }
        }
        for(int i=0;i<size;i++){
            System.out.println(arr[i]);
        }

    }
    public static void main(String[] args) throws IOException {
        Main program = new Main();
        program.selectionSort();
    }
}
