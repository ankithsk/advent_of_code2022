import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class SolutionDay5{

   public static void printStacks(ArrayList<ArrayList<Character>> crates){
        // print the crate info for debugging
        // the crate number gets placed on top of each array, we can remove it
        for (ArrayList<Character> crate: crates){
            for (Character item: crate){
                System.out.print(item);
            }
            System.out.println("");
        }
   }

   public static void crateMover9000(ArrayList<ArrayList<Character>>crates, int numCrates, int source, int dest){
      for (int i = 0; i < numCrates; i++){
         crates.get(dest).add(0, crates.get(source).get(0));
         crates.get(source).remove(0);
      }
   }

   public static void crateMover9001(ArrayList<ArrayList<Character>>crates, int numCrates, int source, int dest){
      for (int i = numCrates-1; i >= 0; i--){
         crates.get(dest).add(0, crates.get(source).get(i));
      }
      for (int i = 0; i < numCrates; i++){
         crates.get(source).remove(0);
      }
   }


   public static void main(String []args){
        // Read the current crate configuration
        ArrayList<ArrayList<Character>> crates = new ArrayList<ArrayList<Character>>();
        try{
            Scanner scanner = new Scanner(new File("day5/input.txt"));

            // process the crate configuration first
            while (scanner.hasNext()){
                String line = scanner.nextLine();

                // if we find a blank line, we are done with the crates
                if (line.equals("")){
                    break;
                }
                int nextCrate = 0;
                for (int i = 0; i < line.length(); i+=4)
                {
                    if (crates.size() < nextCrate+1){
                        crates.add(new ArrayList<Character>());
                    }
                    if(line.charAt(i+1) != ' '){
                        crates.get(nextCrate).add(line.charAt(i+1));
                    }
                    nextCrate++;
                }
            }

            printStacks(crates);
            // read the moves and process them
            while(scanner.hasNext()){
              String line = scanner.nextLine();
              String []instructions = line.split(" ");
              // format is:
              // move X from N to M
              // here X is the number of items to move
              // N is the origin stack
              // M is the destination stack
              int x = Integer.parseInt(instructions[1]);
              int source = Integer.parseInt(instructions[3]) - 1;
              int dest = Integer.parseInt(instructions[5]) - 1;

              // Part 1
              // crateMover9001(crates, x, source, dest);

              // Part 2
              crateMover9001(crates, x, source, dest);
            }

            System.out.println("crates after rearranging");
            printStacks(crates);

        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
