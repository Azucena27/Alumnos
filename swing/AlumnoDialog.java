/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import alumnos.Alumno;
import alumnos.Carrera;
import exception.CalificacionErroneaException;
import java.awt.BorderLayout;
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
public class AlumnoDialog extends JDialog {

    private JLabel lblNoControl;
    private JTextField edtNoControl;
    private JLabel lblNombre;
    private JTextField edtNombre;
    private JLabel lblPaterno;
    private JTextField edtPaterno;
    private JLabel lblMaterno;
    private JTextField edtMaterno;
    private JLabel lblCalificacion;
    private JTextField edtCalificacion;
    private JLabel lblCarrera;
    private JTextField edtCarrera;
    private JButton btnAceptar;
    private JButton btnCancelar;
    private AlumnoDialogListener listener;

    public AlumnoDialog(JFrame parent) {
        super(parent, true);
        super.setSize(330, 260);
        super.setLocationRelativeTo(parent);
        super.setLayout(new FlowLayout());

        lblNoControl = new JLabel("No. de Control:");
        edtNoControl = new JTextField(17);

        lblNombre = new JLabel("Nombre:");
        edtNombre = new JTextField(20);

        lblPaterno = new JLabel("Paterno:");
        edtPaterno = new JTextField(20);

        lblMaterno = new JLabel("Materno:");
        edtMaterno = new JTextField(20);

        lblCalificacion = new JLabel("Calificación: ");
        edtCalificacion = new JTextField(18);

        lblCarrera = new JLabel("Carrera: ");
        edtCarrera = new JTextField(20);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Alumno alumno = new Alumno(
                            edtNoControl.getText(),
                            edtNombre.getText(),
                            edtPaterno.getText(),
                            edtMaterno.getText(),
                            Double.valueOf(edtCalificacion.getText()),
                            Carrera.valueOf(edtCarrera.getText())
                    );
                    listener.aceptarButtonClick(alumno);
                } catch (CalificacionErroneaException ex) {
                    JOptionPane.showMessageDialog(AlumnoDialog.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(AlumnoDialog.this, "Error al ingresar la calificación", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.cancelarButtonClick();
            }
        });
        JLabel lblEspacio = new JLabel(" ");

        super.add(lblNoControl);
        super.add(edtNoControl);

        super.add(lblNombre);
        super.add(edtNombre);

        super.add(lblPaterno);
        super.add(edtPaterno);

        super.add(lblMaterno);
        super.add(edtMaterno);

        super.add(lblCalificacion);
        super.add(edtCalificacion);

        super.add(lblCarrera);
        super.add(edtCarrera);
        super.add(lblEspacio);

        super.add(btnAceptar);

        super.add(btnCancelar);

    }

    public void setListener(AlumnoDialogListener listener) {
        this.listener = listener;
    }
}
