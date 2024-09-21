package com.mycompany.proyecto1;

import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

public class Evaluar {

    // Mapa para almacenar las variables y sus valores
    private static final Map<String, Double> variables = new HashMap<>();

    // Método para procesar declaraciones #enum
    public static void procesarEnum(String declaracion) {
        String[] partes = declaracion.split("=");
        if (partes.length != 2) {
            throw new IllegalArgumentException("Formato inválido en la declaración #enum");
        }
        String nombre = partes[0].replace("#enum", "").trim();
        String expresion = partes[1].replace(";", "").trim();

        double resultado = evaluarExpresion(expresion);
        agregarVariable(nombre, resultado);
    }

    // Método para agregar una variable
    public static void agregarVariable(String nombre, double valor) {
        variables.put(nombre, valor);
    }

    // Método para evaluar una expresión
    public static double evaluarExpresion(String expresion) {
        // Reemplazar variables en la expresión
        expresion = reemplazarVariables(expresion);

        // Eliminar espacios en blanco
        expresion = expresion.replaceAll("\\s+", "");

        // Evaluar la expresión
        return evaluar(expresion);
    }

    private static double evaluar(String expresion) {
        Stack<Double> numeros = new Stack<>();
        Stack<Character> operadores = new Stack<>();

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            // Manejo de números y punto decimal
            if (Character.isDigit(c) || c == '.') {
                StringBuilder sb = new StringBuilder();
                while (i < expresion.length() && (Character.isDigit(expresion.charAt(i)) || expresion.charAt(i) == '.')) {
                    sb.append(expresion.charAt(i++));
                }
                i--; // Decrementamos i porque el bucle avanza uno más al final
                numeros.push(Double.parseDouble(sb.toString()));
            } // Manejo de operador unario '-'
            else if (c == '-' && (i == 0 || expresion.charAt(i - 1) == '(' || "+-*/^".indexOf(expresion.charAt(i - 1)) != -1)) {
                StringBuilder sb = new StringBuilder("-");
                i++; // Avanza el índice para procesar el número después del signo negativo
                while (i < expresion.length() && (Character.isDigit(expresion.charAt(i)) || expresion.charAt(i) == '.')) {
                    sb.append(expresion.charAt(i++));
                }
                i--; // Retrocede una posición al terminar de leer el número
                numeros.push(Double.parseDouble(sb.toString()));
            } // Manejo de paréntesis de apertura
            else if (c == '(') {
                operadores.push(c);
            } // Manejo de paréntesis de cierre
            else if (c == ')') {
                while (operadores.peek() != '(') {
                    numeros.push(aplicarOperador(numeros.pop(), numeros.pop(), operadores.pop()));
                }
                operadores.pop(); // Eliminar el '(' de la pila
            } // Manejo de operadores (+, -, *, /, ^)
            else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
                while (!operadores.isEmpty() && precedencia(operadores.peek()) >= precedencia(c)) {
                    numeros.push(aplicarOperador(numeros.pop(), numeros.pop(), operadores.pop()));
                }
                operadores.push(c); // Agregar el operador actual a la pila
            }
        }

        // Aplicar los operadores restantes
        while (!operadores.isEmpty()) {
            numeros.push(aplicarOperador(numeros.pop(), numeros.pop(), operadores.pop()));
        }

        // El último número en la pila es el resultado
        return numeros.pop();
    }

    private static double aplicarOperador(double b, double a, char operador) {
        switch (operador) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("División por cero");
                }
                return a / b;
            case '^':
                return Math.pow(a, b);
            default:
                throw new IllegalArgumentException("Operador inválido: " + operador);
        }
    }

    private static int precedencia(char operador) {
        switch (operador) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    private static String reemplazarVariables(String expresion) {
        for (Map.Entry<String, Double> entry : variables.entrySet()) {
            expresion = expresion.replace(entry.getKey(), String.valueOf(entry.getValue()));
        }
        return expresion;
    }
}
