//* I declare that the following source code is my work.
//        * I understand and can explain everything I have written, if asked.
//        * I understand that copying any source code, in whole or in part,
//        * that is not in my textbook nor provided or expressly permitted by the instructor,
//        * constitutes cheating. I will provide references/citations where I
//        * have borrowed ideas from other sources. I will receive a zero on this project for
//        * poor academic performance if I am found in violation of this policy.



public class GameChar {
    static private int northSouthLocation = 0;
    static private int eastWestLocation = 0;
    static String[] inventory = {"brass lantern", "rope", "rations", "staff"};

     private void printInventory(String[] inventory) {

        for (int i = 0; i < inventory.length; i++) {
            System.out.println(inventory[i]);
        }
    }

    //parses the users command
     public void parseCommand(String command) {

         //removes any extra spaces
        String[] parseResult = command.toLowerCase().trim().split(" +");

        if (parseResult[0].charAt(0) != 'g' && parseResult[0].charAt(0) != 'i' && parseResult[0].charAt(0) != 'q') {
            System.out.println("Invalid Command: " + parseResult[0].charAt(0));
        }

        if (parseResult[0].charAt(0) == 'g' && parseResult.length > 1) {
            //depending on the command it either moves or prints inventory. 
            if (parseResult[1].charAt(0) == 'n' && northSouthLocation > 0) {

                northSouthLocation--;
                System.out.println("Moving North");
                System.out.println("You are at Location " + northSouthLocation + "," + eastWestLocation + " in terrain " + Map.map[northSouthLocation][eastWestLocation]);
                Map.whereAmI(northSouthLocation,eastWestLocation);

            } else if (parseResult[1].charAt(0) == 'w' && eastWestLocation > 0 ) {
                eastWestLocation--;
                System.out.println("Moving West");
                System.out.println("You are at Location " + northSouthLocation + "," + eastWestLocation + " in terrain " + Map.map[northSouthLocation][eastWestLocation]);
                Map.whereAmI(northSouthLocation,eastWestLocation);
            } else if (parseResult[1].charAt(0) == 's' && northSouthLocation < Map.map.length-1 ) {

                northSouthLocation++;
                System.out.println("Moving South");
                System.out.println("You are at Location " + northSouthLocation + "," + eastWestLocation  + " in terrain " + Map.map[northSouthLocation][eastWestLocation]);
                Map.whereAmI(northSouthLocation,eastWestLocation);
            } else if (parseResult[1].charAt(0) == 'e' && eastWestLocation < Map.map[0].length-1) {
                eastWestLocation++;
                System.out.println("Moving East");
                System.out.println("You are at Location " + northSouthLocation + "," + eastWestLocation  + " in terrain " + Map.map[northSouthLocation][eastWestLocation]);
                Map.whereAmI(northSouthLocation,eastWestLocation);
            } else {
                System.out.println("You are trying to move out of bounds.");
                System.out.println("You are at Location " + northSouthLocation + "," + eastWestLocation  + " in terrain " + Map.map[northSouthLocation][eastWestLocation]);
                Map.whereAmI(northSouthLocation,eastWestLocation);
            }

        } else if (parseResult[0].charAt(0) == 'i') {
            printInventory(inventory);
        } else if (parseResult[0].charAt(0) == 'q' ) {
            System.out.println("Goodbye.");
            System.exit(0);
        } else {
            System.out.println("You are at Location " + northSouthLocation + "," + eastWestLocation);
        }

    }
}
