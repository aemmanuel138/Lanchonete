package Objetivos;

import java.util.Scanner;

public class Menumetas {
    public static void main(String[] args) {
        Menumetas menuses = new Menumetas();
        menuses.menu();
    }
    
    protected void menu() {
        int opt = -1;
        Scanner key = new Scanner(System.in);
        do {
            System.out.println("\nMenu de relações com as metas");
            System.out.println("0 - Para sair desse menu");
            System.out.println("1 - Para exibir todas as metas");
            System.out.println("2 - Para exibir as metas cumpridas");
            System.out.println("3 - Para exibir as metas pendentes");
            System.out.println("4 - Para adicionar uma meta");
            System.out.println("5 - Para remover uma meta");
            opt = key.nextInt();
            switch (opt) {
                case 0:
                System.out.println("Você escolheu sair.");
                break;
                case 1:
                System.out.println("Você escolheu exibir todas as metas:\n");
                Metas.showMetas(1);
                    break;
                case 2:
                    System.out.println("Você escolheu exibir todas as metas cumpridas");
                    break;
                case 3:
                    System.out.println("Você escolheu exibir todas as metas pendentes");
                    break;
                case 4:
                    System.out.println("Você escolheu adicionar uma meta");
                    break;
                case 5:
                    System.out.println("Você escolheu remover uma meta");
                    break;
                case 6:
                    System.out.println("O que você escolheu ainda não existe");
                    break;
            }
        } while (opt != 0);
        key.close();

    }
}
