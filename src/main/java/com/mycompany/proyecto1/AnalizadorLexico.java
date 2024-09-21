package com.mycompany.proyecto1;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;

public class AnalizadorLexico {

    // Mapa para almacenar variables y sus valores
    private static HashMap<String, Object> variables = new HashMap<>();

    // Método para analizar el texto y generar tokens
    public static List<String[]> analizar(String texto) {
        List<String[]> tokens = new ArrayList<>();
        String[] lineas = texto.split("\\r?\\n");

        for (String linea : lineas) {
            linea = linea.trim();
            Pattern pattern = Pattern.compile("\\s*(#enum|\\d+(\\.\\d+)?|[a-zA-Z_][a-zA-Z0-9_]*|[=,+\\-*/^()])\\s*");
            Matcher matcher = pattern.matcher(linea);
            while (matcher.find()) {
                String token = matcher.group(1);
                if (token.equals("#enum")) {
                    tokens.add(new String[]{"Palabra clave", token}); // Mostrar que es una palabra clave 
                } else if (token.matches("\\d+(\\.\\d+)?")) {
                    tokens.add(new String[]{"Número", token});
                } else if (token.matches("[a-zA-Z_][a-zA-Z0-9_]*")) {
                    tokens.add(new String[]{"Identificador", token});
                } else if (token.matches("[=,]")) {
                    tokens.add(new String[]{"Operador o Delimitador", token});
                } else if (token.matches("[+\\-*/^]")) {
                    tokens.add(new String[]{"Operador", token});
                } else if (token.matches("[()]+")) {
                    tokens.add(new String[]{"Paréntesis", token});
                } else {
                    tokens.add(new String[]{"Desconocido", token});
                }
            }
        }
        return tokens;
    }

    // Método para actualizar la tabla con los tokens
    public static void actualizarTabla(DefaultTableModel modelo, List<String[]> tokens) {
        modelo.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos
        for (String[] token : tokens) {
            modelo.addRow(token);
        }
    }

    // Validar declaración de variables como #enum numero = 10, o #Text variable = "texto"
    public static boolean validarDeclaracion(String texto) {
        String declaracionRegex = "#(enum|int|float|double)\\s+[a-zA-Z_][a-zA-Z0-9_]*\\s*=\\s*\\d+(\\.\\d+)?\\s*,$"; // Para números
        String declaracion2Regex = "#(Text|String|char)\\s+[a-zA-Z_][a-zA-Z0-9_]*\\s*=\\s*\"[^\"]*\"\\s*,$"; // Para texto
        return texto.matches(declaracionRegex) || texto.matches(declaracion2Regex);
    }

    // Asignar variables al mapa de variables
    public static void asignarVariable(String texto) {
        String[] partes = texto.split("\\s*=\\s*");
        String identificadorConHash = partes[0].trim().split(" ")[1]; // Identificador con el tipo
        String identificador = identificadorConHash.substring(1); // Identificador sin el #

        // Determina si el valor es numérico o de texto
        if (partes[1].contains("\"")) {
            // Valor de tipo texto (cadena)
            String valor = partes[1].replace(",", "").replace("\"", "").trim();
            variables.put(identificador, valor); // Guardar la variable de texto
        } else {
            // Valor numérico
            double valor = Double.parseDouble(partes[1].replace(",", "").trim());
            variables.put(identificador, valor); // Guardar el identificador sin el #
        }
    }

    // Eliminar una variable del mapa de variables
    public static void eliminarVariable(String nombre) {
        if (variables.containsKey(nombre)) {
            variables.remove(nombre);
            System.out.println("Variable eliminada: " + nombre);
        }
    }

    // Validar operaciones como numero + numero2,
    public static boolean validarOperacion(String texto) {
        String operacionRegex = ".*[+\\-*/^].*,"; // Permite operaciones con , al final
        return texto.matches(operacionRegex);
    }

    // Evaluar expresiones con variables
    public static double evaluarExpresion(String expresion) {
        expresion = expresion.replace(",", ""); // Remover la coma
        expresion = reemplazarVariables(expresion); // Reemplazar variables
        return Evaluar.evaluarExpresion(expresion);
    }

    // Reemplazar las variables en la expresión por sus valores
    public static String reemplazarVariables(String expresion) {
        System.out.println("Expresión original: " + expresion);
        for (String var : variables.keySet()) {
            Object valor = variables.get(var);
            expresion = expresion.replace(var, String.valueOf(valor));
        }
        System.out.println("Expresión con variables reemplazadas: " + expresion);
        return expresion;
    }

    // Imprimir las variables actuales en la consola
    public static void imprimirVariables() {
        System.out.println("Contenido de variables:");
        for (Map.Entry<String, Object> entry : variables.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    // Procesar declaraciones dinámicamente, eliminando variables existentes antes de agregar nuevas
    public static void procesarDeclaraciones(List<String> declaraciones) {
        // Eliminar todas las variables actuales
        for (String declaracion : declaraciones) {
            if (validarDeclaracion(declaracion)) {
                String[] partes = declaracion.split("\\s*=\\s*");
                String identificadorConHash = partes[0].trim().split(" ")[1]; // Identificador con el valor
                String identificador = identificadorConHash.substring(1); // Identificador sin el #
                eliminarVariable(identificador); // Eliminar la variable si ya existe
            }
        }

        // Luego, agregar las nuevas variables
        for (String declaracion : declaraciones) {
            if (validarDeclaracion(declaracion)) {
                asignarVariable(declaracion);
            } else {
                System.out.println("Declaración no válida: " + declaracion);
            }
        }
    }
}
