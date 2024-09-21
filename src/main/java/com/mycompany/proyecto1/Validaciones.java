/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

/**
 *
 * @author cesar
 */
public class Validaciones {

    public static String validarEnum(String linea) {
        if (!linea.matches("#enum\\s+[a-zA-Z_][a-zA-Z0-9_]*\\s*=\\s*\\w+\\s*,?")) {
            StringBuilder error = new StringBuilder("Error: ");
            error.append("Falta la variable, valor numérico, ");
            if (linea.equals("#enum")) {
                error.append(" '=', valor y la ','");
            } else if (linea.matches("#enum\\s+[a-zA-Z_][a-zA-Z0-9_]*")) {
                error.append("Faltan '=', valor numérico y la ','");
            } else if (linea.matches("#enum\\s+[a-zA-Z_][a-zA-Z0-9_]*\\s*=")) {
                error.append("Falta valor numérico y la ','");
            }
            return error.toString();
        }
        return null;  // Sin errores
    }

    public static String validarDeclaracion(String linea) {
        if (linea.startsWith("#enum")) {
            return validarEnum(linea);
        }

        if (!linea.contains("=")) {
            return "Error al declarar " + linea + " lo correcto seria #enum";
        } else if (!linea.endsWith(",")) {
            return "Error: Falta ',' al final de la línea: " + linea;
        } else if (!linea.matches(".*\\d+(\\.\\d+)?")) {
            return "Error: Falta el valor numérico asignado a la variable en la línea: " + linea;
        } else if (linea.startsWith("#") && !linea.startsWith("#enum") && !linea.matches("#(int|float|double|String|char)\\s+[a-zA-Z_][a-zA-Z0-9_]*.*")) {
            return "Error: Declaración de tipo incorrecto o no soportado: " + linea;
        }
        return null;  // Sin errores
    }

    public static String validarTodasLasDeclaraciones(String linea) {
        String error = validarDeclaracion(linea);
        if (error != null) {
            return error;  // Devuelve error si hay problemas
        }
        return null;  // Sin errores
    }
}
