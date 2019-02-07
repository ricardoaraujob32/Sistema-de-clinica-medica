/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author ricardobalduino
 */
public class GenericDAOException extends Exception {

    /**
     * Creates a new instance of <code>GenericDAOException</code> without detail
     * message.
     */
    public GenericDAOException(Exception e) {
        super(e);
    }

    /**
     * Constructs an instance of <code>GenericDAOException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public GenericDAOException(String msg, Exception e) {
        super(msg, e);
    }
}
