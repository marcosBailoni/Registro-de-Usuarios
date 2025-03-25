package readers_writters;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Writers {

    // método para adicionar uma pergunta
    public static void addQuestion(Scanner scanner) {

        System.out.println("Digite a pergunta que será adicionada: \n");
        String newQuestion = scanner.nextLine();

        List<String> listAnswers = Readers.formReader();
        int questNumber = listAnswers.size() + 1;


        try(BufferedWriter bw = new BufferedWriter(new FileWriter(Readers.pathForms, true))){
            bw.newLine();
            bw.write(questNumber + " - " + newQuestion);
            System.out.println("Pergunta adicionada com Sucesso! \n");

        }catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void removeQuestion(Scanner scanner) {

        List<String> questions = Readers.formReader();

        System.out.println("Não é possível excluir as 4 primeiras perguntas!! \n");
        System.out.println("Digite o número da pergunta que deseja remover ou 0 para cancelar: \n");

        for(String q: questions){
            System.out.println(q);
        }

        int userChoice;

        while(true) {

            userChoice = scanner.nextInt();
            scanner.nextLine();

            if(userChoice == 0){
                System.out.println("Operação Cancelada!! \n");
                return;

            } else if (userChoice > 0 && userChoice <= 4){
                System.out.println("Não é possível excluir as 4 primeiras perguntas!! \n");

            } else if (userChoice > 4 && userChoice <= questions.size()) {
                System.out.println("Excluindo questão desejada..... \n");
                break;

            } else {
                System.out.println("Numero inválido!! Digite novamente!\n!");
            }

        }

        questions.remove(userChoice - 1);

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(Readers.pathForms))){

            for(int j = 0; j < questions.size(); j++) {
                String questionWithoutComplement = questions.get(j).substring(questions.get(j).indexOf(" - "));
                bw.write((j + 1) + questionWithoutComplement);
                if((j + 1) == questions.size()){
                    break;
                }
                bw.newLine();

            }
            System.out.println("Pergunta excluída com Sucesso! \n");
        }catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}
