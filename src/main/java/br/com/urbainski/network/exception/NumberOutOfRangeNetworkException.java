package br.com.urbainski.network.exception;

import br.com.urbainski.util.StringUtils;

/**
 * @author Cristian Urbainski
 * @since 30/12/2020
 */
public class NumberOutOfRangeNetworkException extends AbstractNetworkException {

    public NumberOutOfRangeNetworkException(Number val, Integer numberOfElements) {

        super(String.format("O valor informado: %s não está no range de 1 até %d", StringUtils.valueOf(val), numberOfElements));
    }

}