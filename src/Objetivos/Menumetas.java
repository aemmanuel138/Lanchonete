package Objetivos;

import java.util.Scanner;

public class Menumetas {
    public static void main(String[] args) {
        Metas.showMetas(1);
        Menumetas menuses = new Menumetas();
        menuses.menu();
    }

    protected void menu() {
        int opt = -1;
        Scanner key = new Scanner(System.in);
        do {
            System.out.println("Menu de relações com as metas");
            System.out.println("0 - Para sair desse menu");
            System.out.println("1 - Para exibir todas as metas");
            System.out.println("2 - Para exibir as metas cumpridas");
            System.out.println("3 - Para exibir as metas pendentes");
            System.out.println("4 - Para adicionar uma meta");
            System.out.println("5 - Para remover uma meta");
            opt = key.nextInt();
            switch (opt) {
                case 0:

                    break;
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;

                default:
                    menu();
            }
        } while (opt != 0);
        key.close();

    }
}
