package com.mycompany.proyecto1;

public class OperacionesMatematicas {

    // Nodo del árbol de expresión
    static abstract class Nodo {
        abstract double evaluar();
    }

    // Nodo hoja para operandos
    static class NodoNumero extends Nodo {
        double valor;

        NodoNumero(double valor) {
            this.valor = valor;
        }

        @Override
        double evaluar() {
            return valor;
        }
    }

    // Nodo interno para operadores
    static class NodoOperacion extends Nodo {
        Nodo izquierda;
        Nodo derecha;
        char operador;

        NodoOperacion(Nodo izquierda, Nodo derecha, char operador) {
            this.izquierda = izquierda;
            this.derecha = derecha;
            this.operador = operador;
        }

        @Override
        double evaluar() {
            double izquierdaValor = izquierda.evaluar();
            double derechaValor = derecha.evaluar();
            switch (operador) {
                case '+': return izquierdaValor + derechaValor;
                case '-': return izquierdaValor - derechaValor;
                case '*': return izquierdaValor * derechaValor;
                case '/': return izquierdaValor / derechaValor;
                case '^': return Math.pow(izquierdaValor, derechaValor);
                default: throw new RuntimeException("Operador inesperado: " + operador);
            }
        }
    }

    // Método para evaluar una expresión
    public static double evaluar(String expresion) {
        return new Evaluador(expresion).evaluar();
    }

    private static class Evaluador {
        private final String expresion;
        private int pos = -1, c;

        Evaluador(String expresion) {
            this.expresion = expresion;
        }

        void siguienteChar() {
            c = (++pos < expresion.length()) ? expresion.charAt(pos) : -1;
        }

        boolean come(int charEsperado) {
            if (c == charEsperado) {
                siguienteChar();
                return true;
            }
            return false;
        }

        double evaluar() {
            siguienteChar();
            Nodo arbol = parseExpression();
            if (pos < expresion.length()) {
                throw new RuntimeException("Caracter inesperado: " + (char) c);
            }
            return arbol.evaluar();
        }

        // Expresión: maneja paréntesis y operadores de suma/resta
        Nodo parseExpression() {
            Nodo nodo = parseTerm();
            while (true) {
                if (come('+')) {
                    nodo = new NodoOperacion(nodo, parseTerm(), '+');
                } else if (come('-')) {
                    nodo = new NodoOperacion(nodo, parseTerm(), '-');
                } else {
                    return nodo;
                }
            }
        }

        // Término: maneja paréntesis y operadores de multiplicación/división
        Nodo parseTerm() {
            Nodo nodo = parseFactor();
            while (true) {
                if (come('*')) {
                    nodo = new NodoOperacion(nodo, parseFactor(), '*');
                } else if (come('/')) {
                    nodo = new NodoOperacion(nodo, parseFactor(), '/');
                } else {
                    return nodo;
                }
            }
        }

        // Factor: maneja exponentes y paréntesis
        Nodo parseFactor() {
            Nodo nodo = parsePrimary();
            while (true) {
                if (come('^')) {
                    nodo = new NodoOperacion(nodo, parsePrimary(), '^');
                } else {
                    return nodo;
                }
            }
        }

        // Primario: maneja números (incluidos negativos) y expresiones entre paréntesis
        Nodo parsePrimary() {
            if (come('(')) { // Paréntesis
                Nodo nodo = parseExpression();
                if (!come(')')) {
                    throw new RuntimeException("Falta el paréntesis de cierre.");
                }
                // Manejo de multiplicación implícita al salir de paréntesis
                if (c == '*' || c == '/' || c == '(' || (c >= '0' && c <= '9') || c == '.') {
                    Nodo siguienteNodo = parsePrimary();
                    nodo = new NodoOperacion(nodo, siguienteNodo, '*');
                }
                return nodo;
            } else if (c == '-') { // Números negativos
                siguienteChar();
                Nodo nodo = new NodoOperacion(new NodoNumero(0), parsePrimary(), '-');
                return nodo;
            } else if ((c >= '0' && c <= '9') || c == '.') { // Números positivos
                int startPos = pos;
                while ((c >= '0' && c <= '9') || c == '.') {
                    siguienteChar();
                }
                double valor = Double.parseDouble(expresion.substring(startPos, pos));
                Nodo nodo = new NodoNumero(valor);

                // Manejo de multiplicación implícita
                if (c == '(' || (c >= '0' && c <= '9') || c == '.') {
                    Nodo siguienteNodo = parsePrimary();
                    nodo = new NodoOperacion(nodo, siguienteNodo, '*');
                }
                return nodo;
            } else {
                throw new RuntimeException("Carácter inesperado: " + (char) c);
            }
        }
    }
}
