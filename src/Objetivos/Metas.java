package Objetivos;

import java.util.Map;
import java.util.HashMap;

public class Metas {
    private static Map<String, Boolean> map = new HashMap<String, Boolean>();
    private static int espacamento = 0;
    private static String[][] metas = {        
            { "Definir as classes e categorias", "f" },
            {"Cadastro de Insumos", "f"},
            {"Cadastro de Clientes", "f"},
            {"Listar ingredientes", "f"}, // ** Estarão numa estrutura de dicionário?
            {"Selecionar ingredientes e quantidades", "f"},
            {"Listar itens selecionados e valores","f"},
            {"Contabilizar o valor total da seleção", "f"},
            {"Modelo de pagamento de Confirmação do Pedido", "f"},        //redução dos ingredientes
            {"Tempo estimado para entrega", "f"},// Baseado na fila de espera
            {"Definir um tempo de produção x", "f"},
            {"Quantidade de pedidos", "f"},
            {"Confirmação da finalização do pedido", "f"},
            {"Confirmação da entrega do pedido", "f"},
            {"Informar a conclusão do lanche", "f"},
            {"Lista de pedidos", "f"},
            {"Confirmação de inicialização da produção do pedido", "f"},
            {"Ganhos e Gastos diários", "f"},
            {"Quantidade de Clientes diários", "f"},
            {"Anãlise de Satisfação do Cliente", "f"},
            {"Alerta de Validade dos ingredientes", "f"},
            { "Definir rota de entrega de pedidos", "f" },
            // ... Depois podemos expandir um pouco mais!
        };
    
    protected static void showMetas(int opt) {
        if (opt == 1) {
            mostraMetas1(getDicionarioMetas());
            return;
        }
        mostraMetas2(getDicionarioMetas());    
    }

    protected static void addMetas(String meta, boolean feitoOuNao) {
        System.out.println("Método de adicionar metas ainda não completado.");
    }

    private static Map<String, Boolean> getDicionarioMetas() {
        setDicionarioDeMetas();
            return map;
    }
    
    private static void setDicionarioDeMetas() {
        espacamento = 0;
        for (String[] strings : metas) {
            if (strings[0].length() > espacamento) espacamento = strings[0].length();
            map.put(strings[0], strings[1].equalsIgnoreCase("t") || strings[1].equalsIgnoreCase("true") ? true : false);
        }
    }
    
    private static void mostraMetas1(Map<String, Boolean> m) {
        for (Map.Entry<String, Boolean> entradas : m.entrySet()) {
            String espaces = ajustaEspacos(entradas.getKey().length(), espacamento);
            System.out.printf("%s%s --> %s\n", entradas.getKey(), espaces, entradas.getValue());
        }
    }
    
    private static void mostraMetas2(Map<String, Boolean> m) {        
        m.forEach((chave, valor) -> System.out.printf("%s --> %s\n", chave, valor));
    }

    private static String ajustaEspacos(int a, int b) {
        String s = " ";
        for (int i = a - 1; i < b; i++) {
            s += "-";
        }
        return s;
    }
}