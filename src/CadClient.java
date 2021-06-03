import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.Scanner;

public class CadClient {
    static Scanner key = new Scanner(System.in);
    private static String strBD = "jdbc:mysql://localhost:3306,dj,\"\"";
    private static String banco = "Lanchonete";
    private static String tabela = "Cliente";
    private static String bd_tabela = banco + "." + tabela;

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int opt = -1;
        do {
            System.out.println();
            System.out.println("MENU");
            System.out.println("0 - Sair;");
            System.out.println("1 - Listar Clientes;");
            System.out.println("2 - Inserir Cliente;");
            System.out.println("3 - Atualizar Cliente;");
            System.out.println("4 - Deletar Cliente;");
            System.out.println("5 - Mostrar quantidade de Clientes;");
            System.out.print("Selecione uma opção: ");
            opt = key.nextInt();
            switch (opt) {
                case 0:
                    System.out.println("Bye");
                    break;
                case 1:
                    listaClientes();
                    break;
                case 2:
                    menuInserirCliente();
                    break;
                case 3:
                    menuAlterarCliente();
                    break;
                case 4:
                    listaClientes();
                    menuDeletaCliente();
                    break;
                case 5:
                    System.out.println("Clientes cadastrados: " + getNumClientes());
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opt != 0);
    }

    protected static int getNumClientes() {
        int rows = 0;
        try {
            Connection conn = DriverManager.getConnection(strBD);
            PreparedStatement statment = conn.prepareStatement("SELECT * FROM " + bd_tabela);
            ResultSet result = statment.executeQuery();
            rows = 0;

            while (result.next()) {
                rows++;
            }
            return rows;

        } catch (SQLException e) {
            System.out.println("Não Conectado a database");
            Logger.getLogger(CadClient.class.getName()).log(Level.SEVERE, null, e);
        }
        return rows;
    }

    public static void listaClientes() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "dj", "");
            PreparedStatement statment = conn.prepareStatement("SELECT * FROM " + bd_tabela);
            ResultSet result = statment.executeQuery();

            while (result.next()) {
                int id = result.getInt("cliente_id");
                String name = result.getString("cliente_nome");
                String snome = result.getString("cliente_sobrenome");
                String email = result.getString("cliente_email");
                String craiadoEm = result.getString("cliente_criadoem");
                String atualizadoEm = result.getString("cliente_atualizadoem");

                System.out.printf("[Id nº: %d, ", id);
                System.out.printf("Nome: %s, ", name);
                System.out.printf("Sobrenome: %s, ", snome);
                System.out.printf("Email: %s, ", email);
                System.out.printf("Cadastrado em: %s, ", craiadoEm);
                System.out.printf("Atualizado em: %s]%n", atualizadoEm);
            }
        } catch (SQLException e) {
            System.out.println("Não Conectado a database");
            Logger.getLogger(CadClient.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    protected static void buscarCliente(int id) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "dj", "");
            PreparedStatement statment = conn.prepareStatement("SELECT * FROM " + bd_tabela + " WHERE cliente_id = ?");
            statment.setInt(1, id);
            ResultSet result = statment.executeQuery();

            while (result.next()) {
                String name = result.getString("cliente_nome");
                String snome = result.getString("cliente_sobrenome");
                String email = result.getString("cliente_email");
                String craiadoEm = result.getString("cliente_criadoem");
                String atualizadoEm = result.getString("cliente_atualizadoem");

                System.out.printf("[Id nº: %d, ", id);
                System.out.printf("Nome: %s, ", name);
                System.out.printf("Sobrenome: %s, ", snome);
                System.out.printf("Email: %s, ", email);
                System.out.printf("Cadastrado em: %s, ", craiadoEm);
                System.out.printf("Atualizado em: %s]%n", atualizadoEm);
            }
        } catch (SQLException e) {
            Logger.getLogger(CadClient.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static void menuInserirCliente() {
        System.out.print("Quantos clientes desejas adicionar? ");
        int opt = key.nextInt();
        for (int h = 1; h <= opt; h++) {
            System.out.printf("Informe só o primeiro nome do %dº cliente: ", h);
            String nome = key.next();
            key.nextLine();
            System.out.printf("Informe o sobrenome do %dº cliente: ", h);
            String sNome = key.nextLine();
            System.out.printf("Informe o email do %dº cliente: ", h);
            String mail = key.nextLine();
            insereCliente(nome, sNome, mail);
        }
    }

    protected static void insereCliente(String name, String lastName, String mail) {
        Connection conn = null;
        try {
            // Driver driver = new Driver();
            // DriverManager.registerDriver(driver);
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "dj", "");
            PreparedStatement statment = conn.prepareStatement(
                    "INSERT INTO " + bd_tabela + " (cliente_nome, cliente_sobrenome, cliente_email) VALUES (?, ?, ?)");
            /*
             * esses pontos de interrogação é para dizer ao java que será inserido um valor
             * mas que eu ainda não sei qual será
             */
            statment.setString(1, name);
            statment.setString(2, lastName);
            statment.setString(3, mail);
            int rowsAffecteds = statment.executeUpdate();
            if (rowsAffecteds > 0) {

                System.out.println("Cliente inserido com sucesso!");
            } else {
                System.out.println("Não foi possível inserir cliente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected static void menuAlterarCliente() {
        System.out.println("Deseja ver a listagem de todos os clientes? (S/N)");
        if (key.next().concat(key.nextLine()).equalsIgnoreCase("s")) {
            listaClientes();
        }

        System.out.print("Qual o id do cliente pra atualizar? ");
        int id = key.nextInt();
        int opt = -1;
        do {
            System.out.println("\nId: " + id + " selecionado!");
            System.out.println();
            System.out.println("=========SUB MENU ALTERAR ==========");
            System.out.println("0 - Sair;");
            System.out.println("1 - Listar o cliente;");
            System.out.println("2 - Alterar nome;");
            System.out.println("3 - Alterar sobrenome;");
            System.out.println("4 - Alterar email;");
            System.out.print("Selecione uma opção: ");
            opt = key.nextInt();
            switch (opt) {
                case 0:
                    System.out.println("Bye");
                    break;
                case 1:
                    buscarCliente(id);
                    break;
                case 2:
                    System.out.print("Qual o novo nome que será atualizado? ");
                    atualizaNomeCliente(id, key.next());
                    key.nextLine();
                    break;
                case 3:
                    System.out.print("Qual o novo sobre nome que será atualizado? ");
                    alteraSobreNomeCliente(id, key.next().concat(key.nextLine()));
                    break;
                case 4:
                    System.out.print("Qual o novo email que será atualizado? ");
                    alteraEmailCliente(id, key.next().concat(key.nextLine()));
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opt != 0);
    }

    protected static void atualizaNomeCliente(int id, String name) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "dj", "");
            PreparedStatement statment = conn.prepareStatement(
                    "UPDATE " + bd_tabela + " SET cliente_atualizadoem = CURRENT_TIMESTAMP, cliente_nome = ? WHERE cliente_id = ?");
            /*
             * esses pontos de interrogação é para dizer ao java que será inserido um valor
             * mas que eu ainda não sei qual será
             */
            statment.setString(1, name);
            statment.setInt(2, id);
            int rowsAffecteds = statment
                    .executeUpdate(); /* Esse executeUpdate retorna uma quantidade de linhas alteradas */
            if (rowsAffecteds > 0) {
                System.out.println("Cliente alterado com sucesso!");
            } else {
                System.out.println("Não foi possível alterar cliente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected static void alteraSobreNomeCliente(int id, String sNome) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "dj", "");
            PreparedStatement statment = conn.prepareStatement(
                    "UPDATE "+ bd_tabela + " SET cliente_atualizadoem = CURRENT_TIMESTAMP, cliente_sobrenome = ? WHERE cliente_id = ?");
            /*
             * esses pontos de interrogação é para dizer ao java que será inserido um valor
             * mas que eu ainda não sei qual será
             */
            statment.setString(1, sNome);
            statment.setInt(2, id);
            int rowsAffecteds = statment
                    .executeUpdate(); /* Esse executeUpdate retorna uma quantidade de linhas alteradas */
            if (rowsAffecteds > 0) {
                System.out.println("Cliente alterado com sucesso!");
            } else {
                System.out.println("Não foi possível alterar cliente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected static void alteraEmailCliente(int id, String mail) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "dj", "");
            PreparedStatement statment = conn.prepareStatement(
                    "UPDATE "+bd_tabela + " SET cliente_atualizadoem = CURRENT_TIMESTAMP, cliente_email = ? WHERE cliente_id = ?");
            /*
             * esses pontos de interrogação é para dizer ao java que será inserido um valor
             * mas que eu ainda não sei qual será
             */
            statment.setString(1, mail);
            statment.setInt(2, id);
            int rowsAffecteds = statment
                    .executeUpdate(); /* Esse executeUpdate retorna uma quantidade de linhas alteradas */
            if (rowsAffecteds > 0) {
                System.out.println("Cliente alterado com sucesso!");
            } else {
                System.out.println("Não foi possível alterar cliente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void menuDeletaCliente() {
        System.out.print("Qual o id do cliente pra deletar? ");
        int id = key.nextInt();
        key.nextLine();
        deletaCliente(id);
    }

    protected static void deletaCliente(int id) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "dj", "");
            PreparedStatement statment = conn.prepareStatement("DELETE FROM " + bd_tabela + " WHERE cliente_id = ?");
            /*
             * esses pontos de interrogação é para dizer ao java que será inserido um valor
             * mas que eu ainda não sei qual será
             */
            statment.setInt(1, id);
            int rowsAffecteds = statment
                    .executeUpdate(); /* Esse executeUpdate retorna uma quantidade de linhas alteradas */
            if (rowsAffecteds > 0) {
                System.out.println("Cliente deletado com sucesso!");
            } else {
                System.out.println("Não foi possível deletar o cliente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
