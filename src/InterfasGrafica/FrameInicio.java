
package InterfasGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jfree.chart.JFreeChart;


// Importaciones de prueba:

import Abstracto.Instruccion;
import Simbolo.Arbol;
import Simbolo.TablaSimbolos;

//Fin de las importaciones de prueba

public class FrameInicio extends javax.swing.JFrame {

    /**
     * Creates new form FrameInicio
     */
    
    public String nombreArchivo = "";
    private static int indiceGraficaActual = 0;
    private static LinkedList<JFreeChart> graficas = new LinkedList<>();
    
    public static LinkedList<Object> retorno = new LinkedList<>();
    
    //Esta es donde se alamcenan los valores de la grafica de barras
    public static HashMap<String, Object> graficasBarras = new HashMap<>();
    //Esta es donde se alamcenan los valores de la grafica de Pie
    public static HashMap<String, Object> graficasPie = new HashMap<>();
    //Esta es donde se alamcenan los valores de la grafica de Line
    public static HashMap<String, Object> graficasLine = new HashMap<>();
    //Esta es donde se alamcenan los valores de las calculos de Histgram
    public static HashMap<String, Object> graficasHistogram = new HashMap<>();
    
    public FrameInicio() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        jTextArea1.setEditable(false);
        //jTextArea1.setEnabled(false);
        
        //inicio

        ImageIcon icon = new ImageIcon(getClass().getResource("add.png")); // Icono de pestaña
        jTabbedPane1.insertTab("", icon, null, "Nueva pestaña", 0); // Inserta una pestaña por defecto para agregar las demás pestañas
        jTabbedPane1.getModel().clearSelection(); // Deselecciona las pestañas (por estética)

        jTabbedPane1.addMouseListener(new MouseAdapter() { // Se agrega el evento
            @Override
            public void mousePressed(MouseEvent e) {
                JTabbedPane jTabbedPane1 = (JTabbedPane) e.getSource(); // Obtiene el JTabbedPane

                if (jTabbedPane1.getSelectedIndex() == 0) { // Comprueba si la pestaña seleccionada es la primera pestaña (utilizada para agregar más pestañas)
                    int tab = jTabbedPane1.getTabCount(); // Obtiene la cantidad de pestañas (esto para agregar el nombre nuevo a la pestaña)

                    
                    
                    JPanel pane = new JPanel(); // JPanel de prueba 
                    JTextArea areaDeTexto = new JTextArea();//Genera el area de Texto
                    JScrollPane scrollPane = new JScrollPane(areaDeTexto);//Coloca el area de texto dentro de un panel de scroll
                    pane.add(scrollPane); // Se agrega el scroll al panel
                    scrollPane.setPreferredSize(new Dimension(1221, 410));//Se especifican las dimenciones
                    

                    
                    
                    jTabbedPane1.insertTab("Pestaña " + tab, null, pane, "Pestaña " + tab, tab); // Inserta una nueva pestaña llamada Ronda <tab>, donde <tab> es el número de pestaña.
                    jTabbedPane1.setSelectedIndex(tab); // Selecciona la nueva pestaña creada
                }

            }
        });
        //Fin
        
    }
    
    //clase de degradado
    //Postriormente en propiedades y en code colocar una instancia de la clase: new jPanelGradient()
    class jPanelGradient extends JPanel{

      jPanelGradient() {
      }
      protected void paintComponent(Graphics g){
        Graphics2D g2d=(Graphics2D) g;
        int width=getWidth();
        int height=getHeight();

        Color color1=new Color(33, 47, 61);
        Color color2=new Color(51, 57, 255);
        GradientPaint gp=new GradientPaint(0,0,color1,180,height,color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);
      }
    }
    //clase de degradado

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new jPanelGradient();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DataForge");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CONSOLA:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1221, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(104, 104, 104))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Nuevo Archivo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Abrir Archivo");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Guardar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Pestañas");

        jMenuItem4.setText("Eliminar Pestaña");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuBar1.add(jMenu4);

        jMenu2.setText("Ejecutar");
        jMenu2.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu2MenuSelected(evt);
            }
        });
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Reportes");
        jMenu3.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu3MenuSelected(evt);
            }
        });
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu2MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu2MenuSelected
        // Ejecutar:
        //Almacena el texto de la Pestaña seleccionada
        String texto = "";
        boolean validacion = false;
        
        // Obtén el índice de la pestaña seleccionada
        int selectedIndex = jTabbedPane1.getSelectedIndex();

        // Solo procede si hay una pestaña seleccionada
        if (selectedIndex != -1) {
            // Obtén el componente contenido en la pestaña seleccionada
            Component selectedComponent = jTabbedPane1.getComponentAt(selectedIndex);

            // Verifica si el componente es un JPanel
            if (selectedComponent instanceof JPanel) {
                // Recorre los componentes del panel para encontrar el JTextArea
                for (Component component : ((JPanel) selectedComponent).getComponents()) {
                    if (component instanceof JScrollPane) {
                        JScrollPane scrollPane = (JScrollPane) component;
                        Component viewportComponent = scrollPane.getViewport().getView();
                        if (viewportComponent instanceof JTextArea) {
                            JTextArea textArea = (JTextArea) viewportComponent;
                            texto = textArea.getText();
                            validacion = true;
                            // Haz lo que necesites con el texto (por ejemplo, imprimirlo en la consola)
                            //System.out.println("Texto en la pestaña " + selectedIndex + ": " + texto);
                        }
                    }
                }
            }
        }
        //Fin de pestaña que almacena el texto
        
        //Analisis del texto ingresado
            //Ruta en donde se enceuntra nuestra clase principal Main
            // es:  src/Analizadores
        if (validacion){
            
            
            //Aritmeticas nuevo = new Aritmeticas();
           
            
            //Expresion operaciones = new Aritmetica(23,"+",45);
            //ejemplo de utilizacion de la funcion analizadores
            // primer atributo: ruta donde se encuentran los archivos flex y cup
            //Segundo paramentro el nombre del jflex al igual que el tercer parametro
            //Comente la llamada a la funcion ya que solo se debe de ejecutar una ves, para que genere los archivos .java en 
            //el paquete analizador
            
            analizadores("src/Analizadores/", "Lexer.jflex", "Parser.cup");//------------------------------------------------------------- Aqui 1 
            
            //Se ingresa el texto a la consola sin comillas
            //String consola2 = Funciones.Instruccion.consola.replace("\"", "");
            
              /* //------------------------------------------------------------------------------- Aqui 2
            try{
                //System.out.println(texto);
                var resultado2 = analizar(texto); 
                
                //System.out.println(resultado2);
                
                var ast = new Arbol((LinkedList<Instruccion>) resultado2);
                var tabla = new TablaSimbolos();
                tabla.setNombre("GLOBAL");
                ast.setConsola("");
                System.out.println(ast.getInstrucciones());
                for (var a : ast.getInstrucciones()) {
                    var res = a.interpretar(ast, tabla);
                }
                //System.out.println(ast.getConsola());
                jTextArea1.setText(ast.getConsola());
                
            } catch(Exception e){
                System.out.println("Algo salio mal");
                System.out.println(e);
            }
            // */
            //jTextArea1.setText(consola2);
        }
        
    }//GEN-LAST:event_jMenu2MenuSelected

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // Abrir Achivo:
        String contenidoArchivo = abrirArchivo();
        if (contenidoArchivo != null) {
                //Cargar el archivo al area de texto:
                // Obtén el índice de la pestaña seleccionada
                int selectedIndex = jTabbedPane1.getSelectedIndex();

                // Solo procede si hay una pestaña seleccionada
                if (selectedIndex != -1) {
                    // Obtén el componente contenido en la pestaña seleccionada
                    Component selectedComponent = jTabbedPane1.getComponentAt(selectedIndex);

                    // Verifica si el componente es un JPanel
                    if (selectedComponent instanceof JPanel) {
                        // Recorre los componentes del panel para encontrar el JTextArea
                        for (Component component : ((JPanel) selectedComponent).getComponents()) {
                            if (component instanceof JScrollPane) {
                                JScrollPane scrollPane = (JScrollPane) component;
                                Component viewportComponent = scrollPane.getViewport().getView();
                                if (viewportComponent instanceof JTextArea) {
                                    JTextArea textArea = (JTextArea) viewportComponent;
                                    textArea.setText(contenidoArchivo);//Se ingresa el texto
                                    jTabbedPane1.setTitleAt(selectedIndex, nombreArchivo);//Se establece el nombre de la pestaña
                                }
                            }
                        }
                    }
                }
        } else {
            System.out.println("No se seleccionó ningún archivo.");
        }
        
 
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // Nuevo Archivo:
        // Obtén el índice de la pestaña seleccionada
        int selectedIndex = jTabbedPane1.getSelectedIndex();

        // Solo procede si hay una pestaña seleccionada
        if (selectedIndex != -1) {
            // Obtén el componente contenido en la pestaña seleccionada
            Component selectedComponent = jTabbedPane1.getComponentAt(selectedIndex);

            // Verifica si el componente es un JPanel
            if (selectedComponent instanceof JPanel) {
                // Recorre los componentes del panel para encontrar el JTextArea
                for (Component component : ((JPanel) selectedComponent).getComponents()) {
                    if (component instanceof JScrollPane) {
                        JScrollPane scrollPane = (JScrollPane) component;
                        Component viewportComponent = scrollPane.getViewport().getView();
                        if (viewportComponent instanceof JTextArea) {
                            JTextArea textArea = (JTextArea) viewportComponent;
                            guardarTextoEnArchivoDF(textArea);//Se guarda el archivo con el texto seleccionado
                            
                        }
                    }
                }
            }
        }
        //fin
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // Guardar:
        // Obtén el índice de la pestaña seleccionada
        int selectedIndex = jTabbedPane1.getSelectedIndex();

        // Solo procede si hay una pestaña seleccionada
        if (selectedIndex != -1) {
            // Obtén el componente contenido en la pestaña seleccionada
            Component selectedComponent = jTabbedPane1.getComponentAt(selectedIndex);

            // Verifica si el componente es un JPanel
            if (selectedComponent instanceof JPanel) {
                // Recorre los componentes del panel para encontrar el JTextArea
                for (Component component : ((JPanel) selectedComponent).getComponents()) {
                    if (component instanceof JScrollPane) {
                        JScrollPane scrollPane = (JScrollPane) component;
                        Component viewportComponent = scrollPane.getViewport().getView();
                        if (viewportComponent instanceof JTextArea) {
                            JTextArea textArea = (JTextArea) viewportComponent;
                            guardarCambiosEnArchivo(textArea);
                            //guardarTextoEnArchivoDF(textArea);//Se guarda el archivo con el texto seleccionado 
                        }
                    }
                }
            }
        }
        //fin
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // Eliminar Ultima Pestaña:
        int tabCount = jTabbedPane1.getTabCount();
        if (tabCount > 0) {
            int selectedTabIndex = jTabbedPane1.getSelectedIndex();
            if (selectedTabIndex !=0) { // Si se hizo clic en la última pestaña  selectedTabIndex == tabCount - 1 && 
                jTabbedPane1.remove(selectedTabIndex); // Elimina la última pestaña
            }
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        // none:
        
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenu3MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu3MenuSelected
        // Reportes:
        //Funciones.Expresion.imprecionLexemas();
        //Funciones.Expresion.imprecionErrores();
        //Funciones.Expresion.imprecionSimbolos();
        JOptionPane.showMessageDialog(null, "Tablas generadas y guardadas en: src/Tablas(Reportes)/.... " );
    }//GEN-LAST:event_jMenu3MenuSelected

    //Generador de Analizadores, la cual se encutra en el repo
    public static void analizadores(String ruta, String jflexFile, String cupFile){
        try {
            String opcionesJflex[] =  {ruta+jflexFile,"-d",ruta};
            jflex.Main.generate(opcionesJflex);

            String opcionesCup[] =  {"-destdir", ruta,"-parser","Parser",ruta+cupFile};
            java_cup.Main.main(opcionesCup);
            
        } catch (Exception e) {
            System.out.println("No se ha podido generar los analizadores");
            System.out.println(e);
            //Funciones.Instruccion.agregarError("No se ha podido generar los analizadores");
            //Funciones.Instruccion.agregarError(e);
        }
    }
    
    //Funcion analizar, la cual se encutra en el repo
        // Realizar Analisis
    //Esta funcion recibe un estring u la analiza 
    public static Object analizar (String entrada){
        try {
            Analizadores.Lexer lexer = new Analizadores.Lexer(new StringReader(entrada));//este es el analizaro lexico 
            Analizadores.Parser parser = new Analizadores.Parser(lexer);//lugo lo pasa al parser
            var resultado = parser.parse();//aqui ya lo traduce
            return resultado.value;
        } catch (Exception e) {//esta son esepciones por si hay errores
            System.out.println("Error fatal en compilación de entrada.");
            System.out.println(e);
            //Funciones.Instruccion.agregarError("Error fatal en compilación de entrada.");
            //Funciones.Instruccion.agregarError(e);
            return null;
        } 
    } 
    
    
    
    //metodo para abrir un archivo:
    public String abrirArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecciona un archivo .jc");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos .jc", "jc"));

        int seleccion = fileChooser.showOpenDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            try {
                StringBuilder contenido = new StringBuilder();
                BufferedReader lector = new BufferedReader(new FileReader(archivoSeleccionado));
                String linea;
                while ((linea = lector.readLine()) != null) {
                    contenido.append(linea).append("\n");
                }
                lector.close();
                nombreArchivo = archivoSeleccionado.getName();
                return contenido.toString();
            } catch (IOException e) {
                nombreArchivo = "null";
                e.printStackTrace();
            }
        }
        return null;
    }
    
    
    
    
    //metodo para "Nuevo Archivo":
    public void guardarTextoEnArchivoDF(JTextArea textArea) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar como archivo .jc");
        
        // Configuración para sugerir un nombre de archivo predeterminado
        fileChooser.setSelectedFile(new File("miArchivo.jc"));
        
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File archivoParaGuardar = fileChooser.getSelectedFile();
            
            // Asegura que el archivo tenga la extensión .jc
            if (!archivoParaGuardar.getPath().toLowerCase().endsWith(".jc")) {
                archivoParaGuardar = new File(archivoParaGuardar.getPath() + ".jc");
            }

            try (FileWriter fileWriter = new FileWriter(archivoParaGuardar)) {
                fileWriter.write(textArea.getText());
                JOptionPane.showMessageDialog(null, "Archivo guardado exitosamente: " + archivoParaGuardar.getAbsolutePath());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error al guardar el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }
    
    //metodo para "Guardar":  
    public static void guardarCambiosEnArchivo(JTextArea textArea) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar como"); // Título del diálogo
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        // Filtra solo archivos con extensión .df
        fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos JC (*.jc)", "jc"));

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            // Asegura que el archivo tenga la extensión .df
            if (!fileToSave.getAbsolutePath().endsWith(".jc")) {
                fileToSave = new File(fileToSave + ".jc");
            }

            try (FileWriter fileWriter = new FileWriter(fileToSave, false)) { // false para sobrescribir
                fileWriter.write(textArea.getText());
                JOptionPane.showMessageDialog(null, "Cambios guardados exitosamente en: " + fileToSave.getAbsolutePath());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error al guardar los cambios.", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Guardado cancelado por el usuario.", "Guardado Cancelado", JOptionPane.WARNING_MESSAGE);
        }
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
