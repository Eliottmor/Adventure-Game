//* I declare that the following source code is my work.
//        * I understand and can explain everything I have written, if asked.
//        * I understand that copying any source code, in whole or in part,
//        * that is not in my textbook nor provided or expressly permitted by the instructor,
//        * constitutes cheating. I will provide references/citations where I
//        * have borrowed ideas from other sources. I will receive a zero on this project for
//        * poor academic performance if I am found in violation of this policy.



import java.io.*;
import java.util.Scanner;

public class Map {

    //declared my variables in the map class
    File file;
   static char[][] map;

   //map constructor creates map and passes in the scanner object from main method.
    Map(String[] mapFileName, Scanner input) {

        file = new File(mapFileName[0]);
        ReadMap(file, input);
    }

    private void ReadMap(File mapFileName, Scanner input){
        //tries to read the map file.
        try {
            input = new Scanner(mapFileName);
        //if file doesn't exist it creates an error
        } catch (FileNotFoundException x) {
            //if it fails, prints out it failed.
            System.out.print("File open failed.");
            x.printStackTrace();
            System.exit(0);
        }

        //creates variabls needed for map
        String dimension = input.nextLine();
        String[] dimensions = dimension.split(" ");
        int row = Integer.parseInt(dimensions[0]);
        int column = Integer.parseInt(dimensions[1]);
        map = new char[row][column];

        int counter = 0;
        String line;
        //reads in the map into the map array.
        while(input.hasNextLine()) {
            line = input.nextLine();
            for(int i = 0; i < column; i++) {
                map[counter][i] = line.charAt(i);

            }
            counter++;
        }
    }

    // prints the map
    public void printMap() {

        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

    }

    //prints out the 3x3 map
    static public void whereAmI(int row, int column) {
        int startingRow = row -1;
        int startingColumn = column-1;

        for (int i = startingRow; i < startingRow + 3; i++) {
            for(int j = startingColumn; j < startingColumn + 3; j++) {
                //if it is out of bounds, it adds an X
                if(i < 0 || j <0 || i > map.length-1 || j > map[0].length-1) {
                    System.out.print("X");
                } else {
                    System.out.print(map[i][j]);
                }
            }
            System.out.println();
        }

    }

}
