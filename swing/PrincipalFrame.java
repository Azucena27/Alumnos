/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import alumnos.Alumno;
import alumnos.Carrera;
import controlador.Controller;
import exception.AlumnoExistenteException;
import exception.ArchivoInvalidoException;
import exception.BuscarAlumnoException;
import exception.CalificacionErroneaException;
import exception.CargarArchivoException;
import exception.GuardarArchivoException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

/**
 *
 * @author Azucena
 */
public class PrincipalFrame extends JFrame {

    private BusquedaPanel pnlBusqueda;
    private JTable tblAlumnos;
    private Controller controlador;
    private AlumnoDialog dlgAlumno;
    private BuscarAlumnoDialog dglBuscar;
    private AlumnosTableModel modelAlumnos;

    public PrincipalFrame() /*throws CalificacionErroneaException, AlumnoExistenteException*/{
        super("Control Escolar");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(500, 300);
        super.setLayout(new BorderLayout());
        super.setLocationRelativeTo(null);

        try {
            controlador = new Controller();
        } catch (ArchivoInvalidoException ex) {
            JOptionPane.showMessageDialog(PrincipalFrame.this, ex.getMessage(), "Error de archivo", JOptionPane.ERROR_MESSAGE);
        } catch (CargarArchivoException ex) {
            JOptionPane.showMessageDialog(PrincipalFrame.this, ex.getMessage(), "Error al cargar", JOptionPane.ERROR_MESSAGE);
        }

        modelAlumnos = new AlumnosTableModel(controlador);
        tblAlumnos = new JTable(modelAlumnos);
        //tblAlumnos = new JTable(new AlumnosTableModel(controlador));
        pnlBusqueda = new BusquedaPanel();

        dlgAlumno = new AlumnoDialog(this);
        dlgAlumno.setListener(new AlumnoDialogListener() {
            @Override
            public void aceptarButtonClick(Alumno a) {
                try {
                    System.out.println(a.getNoControl());
                    controlador.add(a);
                    modelAlumnos.fireTableDataChanged();
                    dlgAlumno.setVisible(false);
                } catch (AlumnoExistenteException ex) {
                    JOptionPane.showMessageDialog(PrincipalFrame.this, ex.getMessage(), "Alumno no ingresado", JOptionPane.ERROR_MESSAGE);
                }
            }

            @Override
            public void cancelarButtonClick() {
                dlgAlumno.setVisible(false);
            }
        });
        
        dglBuscar= new BuscarAlumnoDialog(this);
        dglBuscar.setListener(new BuscarDialogListener(){
            @Override
            public void buscarButtonClick(Alumno a) {       
                 dglBuscar.setVisible(true);          
            };
            
            @Override
            public void cancelarButtonClick() {
                dglBuscar.setVisible(false);
            }
             
        });

        super.setJMenuBar(makeMenu());
        super.add(new JScrollPane(tblAlumnos), BorderLayout.CENTER);
        super.add(pnlBusqueda, BorderLayout.SOUTH);
        super.setVisible(true);
    }

    private JMenuBar makeMenu() {
        JMenuBar mnBar = new JMenuBar();
        mnBar.setLayout(new FlowLayout(FlowLayout.LEADING));
        mnBar.setPreferredSize(new Dimension(434, 24));

        JMenu mnAyuda = new JMenu("Ayuda");
        JMenu mnAlumno = new JMenu("Alumno");
        JMenuItem mitNuevo = new JMenuItem();
        JMenuItem mitSalir = new JMenuItem();

        mitSalir.setText("Salir");
        mitSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JMenuItem mitAcerca = new JMenuItem();

        JSeparator separador = new JSeparator();

        mitNuevo.setText("Nuevo alumno");
        mitNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        mitNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dlgAlumno.setVisible(true);
            }
        });

        JMenuItem mnGuardar = new JMenuItem("Guardar");
        mnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controlador.guardar();
                } catch (GuardarArchivoException ex) {
                    JOptionPane.showMessageDialog(PrincipalFrame.this, ex.getMessage(), "Error al guardar", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JMenuItem mnCargar = new JMenuItem("Cargar");
        mnCargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controlador.cargar();
                } catch (CargarArchivoException ex) {
                    JOptionPane.showMessageDialog(PrincipalFrame.this, ex.getMessage(), "Error al cargar", JOptionPane.ERROR_MESSAGE);
                } catch (ArchivoInvalidoException ex) {
                    JOptionPane.showMessageDialog(PrincipalFrame.this, ex.getMessage(), "Archivo inválido", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        JMenuItem mnBuscar = new JMenuItem("Buscar");
        mnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                controlador.buscarAlumno(noControl);
                
                }
        });
        
        mnAlumno.add(mitNuevo);
        mnAlumno.add(mnGuardar);
        mnAlumno.add(mnCargar);
        mnAlumno.add(mnBuscar);
        mnAlumno.add(separador);
        mnAlumno.add(mitSalir);

        mnBar.add(mnAlumno);

        mitAcerca.setText("Acerca de...");
        mitAcerca.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.CTRL_DOWN_MASK));

        mnAyuda.add(mitAcerca);

        mnBar.add(mnAyuda, BorderLayout.NORTH);

        return mnBar;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PrincipalFrame();
            }
        });
    }

}
