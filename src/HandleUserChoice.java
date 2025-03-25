import readers_writters.Readers;
import readers_writters.Register;
import readers_writters.Writers;

import java.util.List;
import java.util.Scanner;

public class HandleUserChoice {

    public static void handleUserChoice(int choice, Scanner scanner){
        switch (choice) {
            case 1:
                Register.registerUser(scanner);
                break;

            case 2:
                List<String> list = Readers.totalUsers();
                for(String s: list){
                    System.out.println(s);
                }
                System.out.println();
                break;

            case 3:
                Writers.addQuestion(scanner);
                break;

            case 4:
                Writers.removeQuestion(scanner);
                break;

            case 5:
                List<String> users = Readers.searchByName(scanner);
                for(String u: users){
                    System.out.println(u);
                }
                    System.out.println();

        }

    }
}
