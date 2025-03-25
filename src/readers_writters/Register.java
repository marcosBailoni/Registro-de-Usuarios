package readers_writters;

import entities.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Register {

    //método para registrar usuário

    public static void registerUser(Scanner scanner) {

        List<String> questions = Readers.formReader(); // lista de perguntas
        List<String> answers = new ArrayList<>(); // lista de respostas;

        User user = new User();
        user.setId((long) (Readers.lastUserId() + 1)); // setar id no usuário igual o ultimo id salvo + 1

        for (int i = 0; i < questions.size(); i++) {
            System.out.println(questions.get(i));
            String userAnswer = scanner.nextLine();

            // bloqueia números e minimo de 10 caracteres para cadastrar o nome
            if (i == 0) {
                while (userAnswer.length() < 10 || (userAnswer.chars().anyMatch(Character::isDigit))){
                    System.out.println("Nome do usuário precisa ter mais de 10 caracteres e nenhum número");
                    System.out.println("Digite o nome novamente: ");
                    userAnswer = scanner.nextLine();

                }
            }
            // valida se tem @ no email
            if (i == 1) {
                while (!userAnswer.contains("@")) {
                    System.out.println("email inválido, necessário caractere @");
                    System.out.println("Digite o email novamente: ");
                    userAnswer = scanner.nextLine();
                }
            }

            //valida idade +18 e se a entrada é valida (numero inteiro)
            if (i == 2) {
                while(true) {
                    try{
                        int age = Integer.parseInt(userAnswer);
                        if(age == 0){
                            return;
                        } else if (age < 18){
                            System.out.println("Proibido para menores de idade, digite 0 para sair ou uma idade válida: ");
                            userAnswer = scanner.nextLine();
                        } else {
                            break;
                        }
                        // para formatos inválidos sem ser numeros na entrada:
                    } catch (NumberFormatException e) {
                        System.out.println("Idade inválida, digite 0 para sair ou uma idade válida: ");
                        userAnswer = scanner.nextLine();
                    }
                }
            }

            //valida se a entrada é valida (double) e obriga digitação da virgula
            if (i == 3){
                while(true){
                    try{

                        if(!userAnswer.contains(",")) {
                            System.out.println("Altura inválida, digite novamente informando vírgula: ");
                            userAnswer = scanner.nextLine();

                        } else {
                            userAnswer = userAnswer.replace(",", ".");
                            Double age = Double.parseDouble(userAnswer);
                            break;
                        }


                    } catch (Exception e){
                        System.out.println("Altura inválida, digite novamente: "+ e.getMessage());
                        userAnswer = scanner.nextLine();
                    }
                }
            }

            answers.add(userAnswer); // adicionando cada resposta do console na lista de respostas


            //switch para preencher o objeto User
            switch (i) {
                case 0:
                    user.setName(userAnswer);
                    break;
                case 1:
                    user.setEmail(userAnswer);
                    break;
                case 2:
                    user.setAge(Integer.parseInt(userAnswer));
                    break;
                case 3:
                    user.setHeight(Double.parseDouble(userAnswer));
                    break;
            }

        }
        //registrar o usuário nessa pasta, com um nome padrão de id + hifen + nome maiusculo sem espaço
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\arquivos\\usuarios\\" + user.getId() + "-" + user.getName().toUpperCase().replace(" ", "") + ".txt"))) {
            for (String s : answers) {
                bw.write(s);
                bw.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(user + "\n");
    }
}
