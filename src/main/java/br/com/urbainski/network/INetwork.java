package br.com.urbainski.network;

import br.com.urbainski.network.exception.AbstractNetworkException;

/**
 * @author Cristian Urbainski
 * @since 29/12/2020
 */
public interface INetwork<T extends Number> {

    /**
     * Método responsável por vincular dois valores.
     * @param v1 - primeiro valor
     * @param v2 - segundo valor
     * @throws AbstractNetworkException
     */
    void connect(T v1, T v2) throws AbstractNetworkException;

    /**
     * Método responsável por consultar se dois valores estão conectados direta ou indiretamente.
     *
     * @param v1 - primeiro valor
     * @param v2 - segundo valor
     * @return <code>true</code> caso os valores estejam ligados direta ou indiretamente e
     * <code>false</code> caso não existe nenhuma ligação entre os valores informados.
     * @throws AbstractNetworkException
     */
    boolean consult(T v1, T v2) throws AbstractNetworkException;

}