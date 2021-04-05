/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Martha Jazmín
 */
public class BuscarAlumnoException extends Exception {

    /**
     * Creates a new instance of <code>BuscarAlumnoException</code> without
     * detail message.
     */
    public BuscarAlumnoException() {
    }

    /**
     * Constructs an instance of <code>BuscarAlumnoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public BuscarAlumnoException(String msg) {
        super(msg);
    }
}
