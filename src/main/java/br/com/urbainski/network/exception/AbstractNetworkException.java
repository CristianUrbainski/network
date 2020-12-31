package br.com.urbainski.network.exception;

/**
 * @author Cristian Urbainski
 * @since 29/12/2020
 */
public abstract class AbstractNetworkException extends Exception {

    public AbstractNetworkException(String message) {

        super(message);
    }

}