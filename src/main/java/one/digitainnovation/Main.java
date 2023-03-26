package one.digitainnovation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ListaDuplamenteEncadeada<String> doublyLinkedList = new ListaDuplamenteEncadeada<>();

        int i=0,menu=0;
        String e, p, s="nao";
        do{
            if (doublyLinkedList.size() != 0) {
                System.out.print("Escolha o que deseja fazer:\n" +
                        "[1] Exibir lista completa\n"+
                        "[2] Exibir determinado elemento\n"+
                        "[3] Adicionar novo elemento à lista\n"+
                        "[4] Remover elemento da lista\n"+
                        "[5] Encerrar execução\n"+
                        "- ");
                menu = scan.nextInt();

                switch (menu){
                    case 1:
                        System.out.println(doublyLinkedList);
                        break;
                    case 2:
                        System.out.println("Escolha o indice do elemento a ser exibido:");
                        i= scan.nextInt();
                        System.out.println("O elemento no indice "+i+" é "+ doublyLinkedList.get(i));
                        break;
                    case 3:
                        System.out.println("Digite o elemento à ser adicionado:");
                        e = scan.next();
                        System.out.println("Deseja adicionar o elemento em uma posição especifica?");
                        p = scan.next();
                        if(p.equalsIgnoreCase("sim")){
                            System.out.println("Informe o indice a ser adicionado: ");
                            i = scan.nextInt();
                            doublyLinkedList.add(i, e);

                        } else doublyLinkedList.add(e);
                        break;
                    case 4:
                        System.out.println("Informe o indice do elemento que deseja remover:");
                        i= scan.nextInt();
                        doublyLinkedList.remove(i);
                        System.out.println("Elemento na posição "+i+" removido com sucesso.");
                        break;
                    case 5:
                        System.out.println("Deseja finalizar o programa?");
                        s = scan.next();
                    default:
                        System.out.println("Opção selecionada invalida.");
                        break;
                }

            } else {
                System.out.println("A lista está vazia, adicione um novo elemento.");
                doublyLinkedList.add("Primeiro elemento");
                System.out.println("Novo elemento adicionado!");
            }
        } while(s.equalsIgnoreCase("nao"));


    }
}
