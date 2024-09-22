package com.mycompany.proyecto1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cesar
 */
public class Compilador extends javax.swing.JPanel {

    private JTable transitionTable;

    public Compilador() {
        initComponents();
        crearTablaTransiciones();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Ejecutar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Panel_Scroleo = new javax.swing.JScrollPane();
        Compiladoristo = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        Salidas = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        Analisis_Lexico = new javax.swing.JTable();
        Limpiar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Diagramita = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1000, 700));

        Ejecutar.setText("Ejecutar");
        Ejecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EjecutarActionPerformed(evt);
            }
        });

        Compiladoristo.setColumns(20);
        Compiladoristo.setRows(5);
        Panel_Scroleo.setViewportView(Compiladoristo);

        jScrollPane2.setViewportView(Panel_Scroleo);

        Salidas.setColumns(20);
        Salidas.setRows(5);
        jScrollPane1.setViewportView(Salidas);

        Analisis_Lexico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Componente léxico", "Lexema"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(Analisis_Lexico);

        Limpiar.setText("Limpiar");
        Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\cesar\\Desktop\\Proyecto1modificado\\Proyecto_Automatas\\src\\main\\java\\Resources_image\\ab.jpg")); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(200, 200));

        Diagramita.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Diagramita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Estado", "#", "enum", "Entrada (a-z, 0-9)", "Espacio", "=", "Numero (0-9)", "Operadores", ","
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(Diagramita);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Ejecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane4))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Ejecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void EjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EjecutarActionPerformed
        String texto = Compiladoristo.getText();
        List<String[]> tokens = AnalizadorLexico.analizar(texto);
        AnalizadorLexico.actualizarTabla((DefaultTableModel) Analisis_Lexico.getModel(), tokens);

        String[] lineas = texto.split("\\r?\\n");
        for (String linea : lineas) {
            linea = linea.trim();

            // Validar caracteres no permitidos
            if (!validarCaracteres(linea)) {
                Salidas.append("Error: La línea contiene caracteres no permitidos: " + linea + "\n");
                continue; // Saltar a la siguiente línea
            }

            // Verificamos si la línea no termina con una coma
            if (!linea.endsWith(",")) {
                Salidas.append("Error: La declaración debe terminar con una coma: " + linea + "\n");
                continue; // Saltamos a la siguiente línea
            }

            // Validamos si es una declaración de variable
            if (AnalizadorLexico.validarDeclaracion(linea)) {
                try {
                    AnalizadorLexico.asignarVariable(linea);
                    Salidas.append("Variable asignada correctamente: " + linea + "\n");
                    AnalizadorLexico.imprimirVariables();  // Imprime variables para depuración
                } catch (Exception e) {
                    Salidas.append("Error al asignar la variable: " + linea + ". Asegúrate de que la asignación sea correcta.\n");
                }
            } else if (AnalizadorLexico.validarOperacion(linea)) {
                try {
                    double resultado = AnalizadorLexico.evaluarExpresion(linea);
                    Salidas.append("Resultado de la operación: " + resultado + "\n");
                } catch (Exception e) {
                    Salidas.append("Error en la operación: " + linea + "\n");
                }
            } else {
                String error = Validaciones.validarDeclaracion(linea);
                if (error != null) {
                    Salidas.append(error + "\n");
                }
            }
        }
    }//GEN-LAST:event_EjecutarActionPerformed
    private boolean validarCaracteres(String linea) {
        // Permite letras, números, espacios, signos de puntuación y operadores
        String regex = "^[\\w\\s=,\\-+*/^()#]*"; // Ajusta según lo que necesites permitir
        return linea.matches(regex);
    }

    private void crearTablaTransiciones() {
        Object[][] data = {
            {"q0", "q0", "q1", "q1", "-", "-", "-", "-", "-"}, // Espera `#`, transita a `q1` al recibir `#`
            {"q1", "-", "-", "q2", "-", "-", "-", "-", "-"}, // Espera `enum`, transita a `q2` al recibir `enum`
            {"q2", "-", "-", "q2", "-", "q3", "-", "-", "-"}, // Permite caracteres (a-z, 0-9) para el nombre de variable, transita a `q3` al recibir `=`
            {"q3", "-", "-", "-", "-", "-", "q4", "q5", "-"}, // Espera un número (0-9), transita a `q4` al recibir un número
            {"q4", "-", "-", "-", "-", "-", "-", "q3", "q5"}, // Espera `,` para finalizar la declaración, transita a `q5` al recibir `,`
            {"q5", "-", "-", "-", "-", "-", "-", "-", "-"} // Almacena la declaración y espera el siguiente operador o más declaraciones
        };

        // Suponiendo que Diagramita es un JTable
        DefaultTableModel model = (DefaultTableModel) Diagramita.getModel();
        model.setRowCount(0); // Limpiar filas existentes

        // Agregar datos a la tabla
        for (Object[] row : data) {
            model.addRow(row);
        }

        // Ajustar el modo de redimensionamiento de la tabla
        Diagramita.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS); // Ajusta todas las columnas

        // Actualiza la interfaz gráfica si es necesario
        Diagramita.revalidate();
        Diagramita.repaint();
    }

    private boolean esDeclaracionEnumCompleta(String linea) {
        // Verifica si la declaración tiene el formato correcto
        // Asumimos que el formato correcto es '#enum nombre = valor,'
        // donde 'nombre' y 'valor' pueden ser nombres de variables y números respectivamente.

        // Regex para validar el formato '#enum nombre = valor,'
        String regex = "#enum\\s+\\w+\\s*=\\s*\\d+(\\.\\d+)?,";

        return linea.matches(regex);
    }


    private void LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarActionPerformed
        // Limpia el contenido del JTextArea llamado Salidas
        Salidas.setText(""); // Asumiendo que Salidas es el nombre del JTextArea
    }//GEN-LAST:event_LimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Analisis_Lexico;
    private javax.swing.JTextArea Compiladoristo;
    private javax.swing.JTable Diagramita;
    private javax.swing.JButton Ejecutar;
    private javax.swing.JButton Limpiar;
    private javax.swing.JScrollPane Panel_Scroleo;
    private javax.swing.JTextArea Salidas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
