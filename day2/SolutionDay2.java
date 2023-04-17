import java.io.*;
import java.util.Scanner;
import java.util.HashMap;

public class SolutionDay2{
    public static int win = 6;
    public static int tie = 3;
    public static int lose = 0;

    public static int rock = 1;
    public static int paper = 2;
    public static int scissors = 3;

    public static int getScorePart1(String line){
        HashMap<String, Integer> results = new HashMap<String, Integer>();
        results.put("A Y", win + paper);  // A - rock, Y - paper
        results.put("A X", tie + rock);  //           X - Rock
        results.put("A Z", lose + scissors); //          Z - scissors
        results.put("B Y", tie + paper);  // B - paper
        results.put("B X", lose + rock);
        results.put("B Z", win + scissors);
        results.put("C Y", lose + paper); // C - scissors
        results.put("C X", win + rock);
        results.put("C Z", tie + scissors);
        return results.get(line);
    }

    public static int getScorePart2(String value){
        HashMap<String, Integer> results = new HashMap<String, Integer>();
        results.put("A Y", tie + rock);  // A - rock
        results.put("A X", lose + scissors);  //           X - Rock
        results.put("A Z", win + paper); //          Z - scissors
        results.put("B Y", tie + paper);  // B - paper
        results.put("B X", lose + rock);
        results.put("B Z", win + scissors);
        results.put("C Y", tie + scissors); // C - scissors
        results.put("C X", lose + paper);
        results.put("C Z", win + rock);      
        return results.get(value);  
    }

    public static void main(String []args){


        int totalScore1 = 0;
        int totalScore2 = 0;
        try{
            Scanner scanner = new Scanner(new File("day2/input.txt"));
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                int scorePart1 = getScorePart1(line);
                int scorePart2 = getScorePart2(line);
                totalScore1+=scorePart1;
                totalScore2+=scorePart2;
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Part 1 score is " + totalScore1);
        System.out.println("Part 2 score is " + totalScore2);
    }
}