/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Azucena
 */
public class AlumnoExistenteException extends Exception {

    /**
     * Creates a new instance of <code>AlumnoExistenteException</code> without
     * detail message.
     */
    public AlumnoExistenteException() {
    }

    /**
     * Constructs an instance of <code>AlumnoExistenteException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public AlumnoExistenteException(String msg) {
        super(msg);
    }
}
