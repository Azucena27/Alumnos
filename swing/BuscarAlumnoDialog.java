/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import alumnos.Alumno;
import alumnos.Carrera;
import controlador.Controller;
import exception.BuscarAlumnoException;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Azucena
 */
public class BuscarAlumnoDialog extends JDialog{
    
    private JLabel lblNoControl;
    private JTextField edtNoControl;
    private JButton btnBuscar;
    private JButton btnCancelar; 
    private Controller controlador;
    private BuscarDialogListener listener;
    
    public BuscarAlumnoDialog(JFrame parent){
        super(parent,true);
        super.setSize(330,260);
        super.setLocationRelativeTo(parent);
        super.setLayout(new FlowLayout());
        
        lblNoControl = new JLabel("No. de Control:");
        edtNoControl = new JTextField(10);
        
        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              /*
                controlador.(edtNoControl.getText());
                listener.buscarButtonClick(alumno);*/
            }
    });
        
      btnCancelar = new JButton("Cancelar");
      btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             listener.cancelarButtonClick();
            }
    }); 
    
}
    public void setListener(BuscarDialogListener listener) {
      this.listener = listener;
    }
}
