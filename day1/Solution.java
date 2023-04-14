import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Solution{
    public static void main(String []args){
        ArrayList<Integer> calories = new ArrayList<Integer>();
        int maxSum = 0;
        try{
            Scanner scanner = new Scanner(new File("day1/input.txt"));
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                if (line.equals("")){
                    int totalCalories = 0;
                    for (Integer i: calories){
                        totalCalories+=i;
                    }
                    if (totalCalories > maxSum){
                        maxSum = totalCalories;
                    }
                    calories.clear();
                }
                else{
                    calories.add(Integer.parseInt(line));
                }
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }

        System.out.println(maxSum);
        
    }
}