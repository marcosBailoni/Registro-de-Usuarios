import prints_msgs.MenuPrint;
import prints_msgs.WelcomePrint;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        WelcomePrint.welcomeMsg();

        try(Scanner scanner = new Scanner(System.in)){

            int userChoice;

            do {
                MenuPrint.printMenu();
                userChoice = scanner.nextInt();
                scanner.nextLine();
                HandleUserChoice.handleUserChoice(userChoice, scanner);
            } while (userChoice >= 1 && userChoice <= 5);

            System.out.println("Programa Finalizado!!");
        }

    }
}