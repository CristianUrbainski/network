package br.com.urbainski.network.impl;

import br.com.urbainski.network.INetwork;
import br.com.urbainski.network.exception.AbstractNetworkException;

/**
 * @author Cristian Urbainski
 * @since 29/12/2020
 */
public class NetworkIntegerImpl extends AbstractGenericNetworkImpl<Integer> implements INetwork<Integer> {

    public NetworkIntegerImpl(Integer numberOfElements) throws AbstractNetworkException {

        super(numberOfElements);
    }

}