package readers_writters;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Readers {
    static String pathForms = System.getProperty("user.dir") + "\\arquivos\\formulario\\formulario.txt";
    static String pathUsers = System.getProperty("user.dir") + "\\arquivos\\usuarios";

    //Método para percorrer linhas do arquivo "formulario" e retornar a lista das perguntas.
    public static List<String> formReader() {

        List<String> questions = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(pathForms))){
            String line;

            while((line = br.readLine()) != null) {
                questions.add(line);
            }
        } catch (IOException |NullPointerException e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
        return questions;
    }



    //retorna uma lista com o nome de todos os usuários cadastrados (pega o nome de todos txt e retorna em uma lista)
    public static List<String> totalUsers(){
        File file = new File(pathUsers);
        List<String> list = new ArrayList<>();

        if(file.exists() && file.isDirectory()){
            File[] files = file.listFiles();

            if (files != null) {
                for(File f: files){
                    list.add(f.getName());
                }
            }
        }

        list.sort((s1, s2) -> {
            int num1 = Integer.parseInt(s1.replaceAll("\\D", ""));
            int num2 = Integer.parseInt(s2.replaceAll("\\D", ""));
            return Integer.compare(num1, num2);
        });

        return list;
    }

    //procura usuários que tenham parte da string digitada no scanner em seu nome.
    public static List<String> searchByName(Scanner scanner){

        List<String> listTotalUsers = totalUsers();
        List<String> usersFind = new ArrayList<>();

        System.out.println("Digite o nome ou parte do nome que está procurando:");
        String name = scanner.nextLine().toUpperCase();

        for (String userFromList : listTotalUsers) {
            if (userFromList.contains(name)) {
                usersFind.add(userFromList);
            }
        }

        return usersFind;
    }

    //retorna o identificador do ultimo usuário/txt cadastrado
    public static int lastUserId(){
        List<String> list = totalUsers();

        if(list.isEmpty()){
            return 0;
        }

        return Integer.parseInt(list.getLast().replaceAll("\\D", ""));
//        return Integer.parseInt(list.getLast().substring(0, list.getLast().indexOf("-")));

    }



}
