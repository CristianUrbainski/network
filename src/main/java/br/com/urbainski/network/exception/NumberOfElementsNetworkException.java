package br.com.urbainski.network.exception;

/**
 * @author Cristian Urbainski
 * @since 29/12/2020
 */
public class NumberOfElementsNetworkException extends AbstractNetworkException {

    public NumberOfElementsNetworkException(Integer numberOfElements) {

        super(String.format("O número mínimo de elementos é: 2, valor informado: %d", numberOfElements));
    }

}