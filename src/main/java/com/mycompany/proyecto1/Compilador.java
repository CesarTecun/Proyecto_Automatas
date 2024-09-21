package com.mycompany.proyecto1;

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
        Compilacion = new javax.swing.JButton();
        Limpiar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Diagramita = new javax.swing.JPanel();

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

        Compilacion.setText("Compilar");
        Compilacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompilacionActionPerformed(evt);
            }
        });

        Limpiar.setText("Limpiar");
        Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\cesar\\Desktop\\Proyecto1modificado\\Proyecto_Automatas\\src\\main\\java\\Resources_image\\ab.jpg")); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(200, 200));

        javax.swing.GroupLayout DiagramitaLayout = new javax.swing.GroupLayout(Diagramita);
        Diagramita.setLayout(DiagramitaLayout);
        DiagramitaLayout.setHorizontalGroup(
            DiagramitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        DiagramitaLayout.setVerticalGroup(
            DiagramitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 163, Short.MAX_VALUE)
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
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Ejecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Compilacion, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 240, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Diagramita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Diagramita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Ejecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Compilacion, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Limpiar)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void EjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EjecutarActionPerformed
        String texto = Compiladoristo.getText().trim();

        // Dividimos el texto ingresado por líneas
        String[] lineas = texto.split("\\r?\\n");

        for (String linea : lineas) {
            linea = linea.trim();  // Eliminar espacios en blanco

            // Verificar si la línea es una declaración enum
            if (linea.startsWith("#enum")) {
                String error = Validaciones.validarEnum(linea);
                if (error != null) {
                    Salidas.append(error + "\n");
                    continue;  // Si hay un error, saltamos a la siguiente línea
                }
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
                    Salidas.append("Resultado de " + linea + ": " + resultado + "\n");
                } catch (Exception ex) {
                    Salidas.append("Error al evaluar la expresión: " + linea + ". Verifica que las variables estén declaradas correctamente.\n");
                }
            } else {
                String error = Validaciones.validarDeclaracion(linea);
                if (error != null) {
                    Salidas.append(error + "\n");
                }
            }
        }
    }//GEN-LAST:event_EjecutarActionPerformed

    private void crearTablaTransiciones() {
        String[] columnNames = {"Estado", "Entrada (a-z)", "Entrada (0-9)", "Operadores"};
        Object[][] data = {
            {"q0", "q1", "-", "-", "-"},
            {"q1", "q1", "q2", "-", "-"},
            {"q2", "-", "-", "q3", "-"},
            {"q3", "-", "-", "q3", "-"},
            {"q4", "-", "-", "q3", "-"},
            {"q5", "-", "-", "-", "-", "-"}
        };

        transitionTable = new JTable(new DefaultTableModel(data, columnNames));
        transitionTable.setFillsViewportHeight(true);

        // Crear un JScrollPane para la tabla de transiciones
        JScrollPane scrollPane = new JScrollPane(transitionTable);
        scrollPane.setPreferredSize(new java.awt.Dimension(400, 200)); // Ajusta el tamaño como desees

        // Agregar el JScrollPane al JPanel Diagramita
        Diagramita.setLayout(new java.awt.BorderLayout());
        Diagramita.add(scrollPane, java.awt.BorderLayout.CENTER);
    }

    private boolean esDeclaracionEnumCompleta(String linea) {
        // Verifica si la declaración tiene el formato correcto
        // Asumimos que el formato correcto es '#enum nombre = valor,'
        // donde 'nombre' y 'valor' pueden ser nombres de variables y números respectivamente.

        // Regex para validar el formato '#enum nombre = valor,'
        String regex = "#enum\\s+\\w+\\s*=\\s*\\d+(\\.\\d+)?,";

        return linea.matches(regex);
    }

    private void CompilacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompilacionActionPerformed
        String texto = Compiladoristo.getText();

        // Realiza solo el análisis léxico sin ejecutar ni asignar variables
        List<String[]> tokens = AnalizadorLexico.analizar(texto);
        DefaultTableModel modelo = (DefaultTableModel) Analisis_Lexico.getModel();

        // Actualiza la tabla con los tokens analizados
        AnalizadorLexico.actualizarTabla(modelo, tokens);

        // Mostrar un mensaje en el área de salida
        Salidas.setText("Análisis léxico completado.");
    }//GEN-LAST:event_CompilacionActionPerformed


    private void LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarActionPerformed
        // Limpia el contenido del JTextArea llamado Salidas
        Salidas.setText(""); // Asumiendo que Salidas es el nombre del JTextArea
    }//GEN-LAST:event_LimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Analisis_Lexico;
    private javax.swing.JButton Compilacion;
    private javax.swing.JTextArea Compiladoristo;
    private javax.swing.JPanel Diagramita;
    private javax.swing.JButton Ejecutar;
    private javax.swing.JButton Limpiar;
    private javax.swing.JScrollPane Panel_Scroleo;
    private javax.swing.JTextArea Salidas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
