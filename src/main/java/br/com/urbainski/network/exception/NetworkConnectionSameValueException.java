package br.com.urbainski.network.exception;

/**
 * @author Cristian Urbainski
 * @since 31/12/2020
 */
public class NetworkConnectionSameValueException extends AbstractNetworkException {

    public NetworkConnectionSameValueException() {

        super("Não é possível conectar dois valores iguais.");
    }

}