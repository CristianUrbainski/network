package br.com.urbainski.network.impl;

import br.com.urbainski.network.INetwork;
import br.com.urbainski.network.exception.*;
import br.com.urbainski.util.ComparableUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Cristian Urbainski
 * @since 29/12/2020
 */
public abstract class AbstractGenericNetworkImpl<T extends Number & Comparable> implements INetwork<T> {

    protected final Integer numberOfElements;
    protected final Map<T, List<T>> connected;

    public AbstractGenericNetworkImpl(Integer numberOfElements) throws AbstractNetworkException {

        if (numberOfElements == null || numberOfElements < 2) {

            throw new NumberOfElementsNetworkException(numberOfElements);
        }

        this.numberOfElements = numberOfElements;
        this.connected = new HashMap<>();
    }

    @Override
    public void connect(T v1, T v2) throws AbstractNetworkException {

        validateRange(v1);
        validateRange(v2);

        if (ComparableUtils.equals(v1, v2)) {

            throw new NetworkConnectionSameValueException();
        }

        if (existsDirectConnection(v1, v2)) {

            throw new NetworkConnectionAlreadyExistsException(v1, v2);
        }

        internalConnect(v1, v2);
        internalConnect(v2, v1);
    }

    @Override
    public boolean consult(T v1, T v2) throws AbstractNetworkException {

        validateRange(v1);
        validateRange(v2);

        if (ComparableUtils.equals(v1, v2)) {

            return false;
        }

        boolean existsDirectConnection = existsDirectConnection(v1, v2);

        if (existsDirectConnection) {

            return true;
        }

        boolean existIndirectConnection = existsIndirectConnection(v1, v2, new ArrayList<>());

        return existIndirectConnection;
    }

    private void internalConnect(T v1, T v2) {

        List<T> values = connected.get(v1);

        if (values == null) {

            values = new ArrayList<>();
        }

        values.add(v2);

        connected.put(v1, values);
    }

    protected boolean existsDirectConnection(T v1, T v2) {

        return connected.containsKey(v1) && connected.get(v1).contains(v2);
    }

    protected boolean existsIndirectConnection(T v1, T v2, List<T> visitedKeys) {

        visitedKeys.add(v1);

        if (connected.containsKey(v1)) {

            List<T> values = connected.get(v1);

            if (values.contains(v2)) {

                return true;
            }

            for (T value : values) {

                if (visitedKeys.contains(value)) {

                    continue;
                }

                boolean result = existsIndirectConnection(value, v2, visitedKeys);

                if (result) {

                    return true;
                }
            }
        }

        return false;
    }

    protected void validateRange(T v) throws NumberOutOfRangeNetworkException {

        if (v == null || ComparableUtils.lessThanOrEqual(v, 0) || ComparableUtils.greatherThan(v, numberOfElements)) {

            throw new NumberOutOfRangeNetworkException(v, numberOfElements);
        }
    }

}