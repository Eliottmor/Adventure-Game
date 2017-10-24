//* I declare that the following source code is my work.
//        * I understand and can explain everything I have written, if asked.
//        * I understand that copying any source code, in whole or in part,
//        * that is not in my textbook nor provided or expressly permitted by the instructor,
//        * constitutes cheating. I will provide references/citations where I
//        * have borrowed ideas from other sources. I will receive a zero on this project for
//        * poor academic performance if I am found in violation of this policy.



import java.util.*;

public class Adventure {

    public static void main(String[] args) {

        //initialized all the objects
        GameChar character = new GameChar();
        Scanner input = null;
        Map gameMap = new Map(args, input);

        //printed the map to start out
        gameMap.printMap();
        //reads in users input and parses it.
        input = new Scanner(System.in);
        do {
            System.out.print("> ");
            String command = input.nextLine();
            if (command.length() > 0) {
                character.parseCommand(command);
            }
        } while (true);
    }


}
