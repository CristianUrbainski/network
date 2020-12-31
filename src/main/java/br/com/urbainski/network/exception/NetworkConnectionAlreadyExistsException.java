package br.com.urbainski.network.exception;

import br.com.urbainski.util.StringUtils;

/**
 * @author Cristian Urbainski
 * @since 30/12/2020
 */
public class NetworkConnectionAlreadyExistsException extends AbstractNetworkException {

    public NetworkConnectionAlreadyExistsException(Number v1, Number v2) {

        super(String.format("Conexão entre os números: %s e %s já existe", StringUtils.valueOf(v1), StringUtils.valueOf(v2)));
    }

}