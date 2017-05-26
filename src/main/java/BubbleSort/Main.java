package BubbleSort;

import utility.ScannerInput;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by schaud3 on 5/25/17.
 */
public class Main extends ScannerInput {
    public void sort() throws IOException {
        Scanner in = input("/BubbleSort/input");
        int size = in.nextInt();
        int[] arr = new int[size];
        for(int i=0;i<size;i++){
            arr[i] = in.nextInt();
        }
        Boolean swap = true;
        while(swap) {
            swap=false;
            for(int i=0;i<size-1;i++){
                if(arr[i] > arr[i+1]){
                    arr[i+1] = arr[i]+arr[i+1];
                    arr[i] = arr[i+1]-arr[i];
                    arr[i+1] = arr[i+1]-arr[i];
                    swap = true;
                }
            }
        }
        for(int i=0;i<size;i++){
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        Main program = new Main();
        program.sort();
    }
}
