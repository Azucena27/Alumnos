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
public class CargarArchivoException extends Exception {

    /**
     * Creates a new instance of <code>CargarArchivoException</code> without
     * detail message.
     */
    public CargarArchivoException() {
    }

    /**
     * Constructs an instance of <code>CargarArchivoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CargarArchivoException(String msg) {
        super(msg);
    }
}
