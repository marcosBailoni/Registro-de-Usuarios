package prints_msgs;

public class MenuPrint {

    public static void printMenu(){

        System.out.println(
                "Digite o número da função desejada: \n" +
                "1 - Cadastrar o usuário \n" +
                "2 - Listar todos usuários cadastrados \n" +
                "3 - Cadastrar nova pergunta no formulário \n" +
                "4 - Deletar pergunta do formulário \n" +
                "5 - Pesquisar usuário por nome ou idade ou email \n "+
                "OU DIGITE QUALQUER OUTRO CARACTERE PARA SAIR \n"
        );
    }
}
