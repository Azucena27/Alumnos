/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import alumnos.Alumno;

/**
 *
 * @author Azucena
 */
public interface BuscarDialogListener {
    
    public void buscarButtonClick(Alumno a);
    
    public void cancelarButtonClick();
}
