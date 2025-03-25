Desafio proposto para criar um programa onde o usuário entrará com cadastros feitos via console: 

Passo 1  
Você deverá criar um arquivo chamado formulario.txt, nele, deverá conter as seguintes 
perguntas: 
1 - Qual seu nome completo? 
2 - Qual seu email de contato? 
3 - Qual sua idade? 
4 - Qual sua altura? 
O primeiro passo, é criar uma aplicação que irá LER este arquivo .txt e PRINTAR as 
perguntas no terminal. (java.io). 
Não é permitido escrever as perguntas no seu código e printa-las na tela, você deverá LER 
o arquivo, guardar o conteúdo em alguma estrutura de dados a sua escolha e, printar na 
tela. 
O USUÁRIO DEVERÁ ENTRAR COM OS DADOS VIA TERMINAL, MAS A LEITURA 
DEVE SER DO ARQUIVO .TXT 

Passo 2  
Agora, você irá cadastrar um usuário e vai ter de RESPONDER essas 4 perguntas, e, após 
respondê-las, você deverá imprimir a resposta no terminal, algo como: 
Lucas Carrilho  
lucascarrilho123@gmail.com 
28 
1.77 
Neste ponto, recomendo que você pense no Paradigma de OO, pois será legal se você 
armazenar essas informações em um objeto. 

Passo 3  
Você deverá agora, SALVAR em um arquivo .txt, essas 4 respostas dadas no passo anterior 
a respeito do usuário em um arquivo txt com o seguinte formato: 1-LUCASCARRILHO.TXT. 
Você deverá CONCATENAR o nome que a pessoa responder na primeira pergunta e 
salvá-la com letras maiusculas e na seguinte ordem, 1,2,3,4 e assim sucessivamente. 

Passo 4 
Agora, você deverá criar um “menu principal” com as seguintes duas opções: 
1 - Cadastrar o usuário 
2 - Listar todos usuários cadastrados 
3 - Cadastrar nova pergunta no formulário 
4 - Deletar pergunta do formulário 
5 - Pesquisar usuário por nome ou idade ou email 
Neste caso, você o usuário vai poder escolher entre a opção 1 e 5, como a 1 já foi 
desenvolvida, na 2, ele deverá pegar todas as pessoas cadastradas e listar SOMENTE O 
NOME DE TODAS ELAS, como no exemplo a seguir que o usuário selecione a opção 2: 
1 - Lucas Carrilho 
2 - Joao Pe de Feijao 

Passo 5 
Você agora, vai criar a função de adicionar nova pergunta ao formulário e deletar pergunta 
cadastrada, uma regra aqui -> Não será POSSÍVEL apagar as 4 primeiras perguntas, 
apenas da 5 em diante. 

Passo 6 
Agora, você deverá implementar outra função que BUSCA por todos os usuários 
cadastrados na aplicação, seja por parte do nome ou o termo inteiro, exemplo: 
Cadastrados : Lucas Almeida, Luca De Sá, Luc Montavão. 
Caso o usuário digite “Luca”, deverá retornar somente o primeiro e o segundo com suas 
devidas informações. (OO + ordenação). 

Passo 7 
Agora, vamos adicionar algumas validações à nossa aplicação. 
1 - > Momento de cadastro de usuário: 
O usuário deverá possuir no mínimo 10 caracteres de nome, deverá possuir 
obrigatoriamente o campo @ no e-mail, deverá ter mais de 18 anos, e o formato da altura 
preenchida deverá ser sempre o número com vírgulas. 
