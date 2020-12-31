package br.com.urbainski.network.impl;

import br.com.urbainski.network.INetwork;
import br.com.urbainski.network.exception.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Cristian Urbainski
 * @since 31/12/2020
 */
public class NetworkIntegerImplTest {

    @Test(expected = NumberOfElementsNetworkException.class)
    public void testThrowExceptionCreateNetworkNumberOfElementsNegative() throws AbstractNetworkException {

        new NetworkIntegerImpl(-1);
    }

    @Test(expected = NumberOfElementsNetworkException.class)
    public void testThrowExceptionCreateNetworkNumberOfElementsZero() throws AbstractNetworkException {

        new NetworkIntegerImpl(0);
    }

    @Test(expected = NumberOfElementsNetworkException.class)
    public void testThrowExceptionCreateNetworkNumberOfElementsOne() throws AbstractNetworkException {

        new NetworkIntegerImpl(1);
    }

    @Test(expected = NumberOutOfRangeNetworkException.class)
    public void testThrowExceptionMethodConnectWhenV1IsNull() throws AbstractNetworkException {

        INetwork<Integer> network = new NetworkIntegerImpl(10);

        network.connect(null, 1);
    }

    @Test(expected = NumberOutOfRangeNetworkException.class)
    public void testThrowExceptionMethodConnectWhenV1IsOutOfRangeNegative() throws AbstractNetworkException {

        INetwork<Integer> network = new NetworkIntegerImpl(10);

        network.connect(-1, 1);
    }

    @Test(expected = NumberOutOfRangeNetworkException.class)
    public void testThrowExceptionMethodConnectWhenV1IsOutOfRangeZero() throws AbstractNetworkException {

        INetwork<Integer> network = new NetworkIntegerImpl(10);

        network.connect(0, 1);
    }

    @Test(expected = NumberOutOfRangeNetworkException.class)
    public void testThrowExceptionMethodConnectWhenV1IsOutOfRangePositive() throws AbstractNetworkException {

        INetwork<Integer> network = new NetworkIntegerImpl(10);

        network.connect(11, 1);
    }

    @Test(expected = NumberOutOfRangeNetworkException.class)
    public void testThrowExceptionMethodConnectWhenV2IsNull() throws AbstractNetworkException {

        INetwork<Integer> network = new NetworkIntegerImpl(10);

        network.connect(2, null);
    }

    @Test(expected = NumberOutOfRangeNetworkException.class)
    public void testThrowExceptionMethodConnectWhenV2IsOutOfRangeNegative() throws AbstractNetworkException {

        INetwork<Integer> network = new NetworkIntegerImpl(10);

        network.connect(2, -1);
    }

    @Test(expected = NumberOutOfRangeNetworkException.class)
    public void testThrowExceptionMethodConnectWhenV2IsOutOfRangeZero() throws AbstractNetworkException {

        INetwork<Integer> network = new NetworkIntegerImpl(10);

        network.connect(3, 0);
    }

    @Test(expected = NumberOutOfRangeNetworkException.class)
    public void testThrowExceptionMethodConnectWhenV2IsOutOfRangePositive() throws AbstractNetworkException {

        INetwork<Integer> network = new NetworkIntegerImpl(10);

        network.connect(2, 11);
    }

    @Test(expected = NumberOutOfRangeNetworkException.class)
    public void testThrowExceptionMethodConsultWhenV1IsNull() throws AbstractNetworkException {

        INetwork<Integer> network = new NetworkIntegerImpl(10);

        network.consult(null, 1);
    }

    @Test(expected = NumberOutOfRangeNetworkException.class)
    public void testThrowExceptionMethodConsultWhenV1IsOutOfRangeNegative() throws AbstractNetworkException {

        INetwork<Integer> network = new NetworkIntegerImpl(10);

        network.consult(-1, 1);
    }

    @Test(expected = NumberOutOfRangeNetworkException.class)
    public void testThrowExceptionMethodConsultWhenV1IsOutOfRangeZero() throws AbstractNetworkException {

        INetwork<Integer> network = new NetworkIntegerImpl(10);

        network.consult(0, 1);
    }

    @Test(expected = NumberOutOfRangeNetworkException.class)
    public void testThrowExceptionMethodConsultWhenV1IsOutOfRangePositive() throws AbstractNetworkException {

        INetwork<Integer> network = new NetworkIntegerImpl(10);

        network.consult(11, 1);
    }

    @Test(expected = NumberOutOfRangeNetworkException.class)
    public void testThrowExceptionMethodConsultWhenV2IsNull() throws AbstractNetworkException {

        INetwork<Integer> network = new NetworkIntegerImpl(10);

        network.consult(2, null);
    }

    @Test(expected = NumberOutOfRangeNetworkException.class)
    public void testThrowExceptionMethodConsultWhenV2IsOutOfRangeNegative() throws AbstractNetworkException {

        INetwork<Integer> network = new NetworkIntegerImpl(10);

        network.consult(2, -1);
    }

    @Test(expected = NumberOutOfRangeNetworkException.class)
    public void testThrowExceptionMethodConsultWhenV2IsOutOfRangeZero() throws AbstractNetworkException {

        INetwork<Integer> network = new NetworkIntegerImpl(10);

        network.consult(3, 0);
    }

    @Test(expected = NumberOutOfRangeNetworkException.class)
    public void testThrowExceptionMethodConsultWhenV2IsOutOfRangePositive() throws AbstractNetworkException {

        INetwork<Integer> network = new NetworkIntegerImpl(10);

        network.consult(2, 11);
    }

    @Test(expected = NetworkConnectionSameValueException.class)
    public void testThrowExceptionMethodConnectWhenIsSameValues() throws AbstractNetworkException {

        INetwork<Integer> network = new NetworkIntegerImpl(10);

        network.connect(2, 2);
    }

    @Test(expected = NetworkConnectionAlreadyExistsException.class)
    public void testThrowExceptionMethodConnectWhenConnectionAlreadyExists() throws AbstractNetworkException {

        INetwork<Integer> network = new NetworkIntegerImpl(10);

        network.connect(1, 2);
        network.connect(1, 2);
    }

    @Test
    public void testConnectionDirection() throws AbstractNetworkException {

        INetwork<Integer> network = new NetworkIntegerImpl(6);
        network.connect(1, 2);
        network.connect(3, 6);
        network.connect(5, 4);

        Assert.assertFalse(network.consult(1, 1));
        Assert.assertTrue(network.consult(1, 2));
        Assert.assertFalse(network.consult(1, 3));
        Assert.assertFalse(network.consult(1, 4));
        Assert.assertFalse(network.consult(1, 5));
        Assert.assertFalse(network.consult(1, 6));
        Assert.assertTrue(network.consult(2, 1));
        Assert.assertFalse(network.consult(2, 2));
        Assert.assertFalse(network.consult(2, 3));
        Assert.assertFalse(network.consult(2, 4));
        Assert.assertFalse(network.consult(2, 5));
        Assert.assertFalse(network.consult(2, 6));
        Assert.assertFalse(network.consult(3, 1));
        Assert.assertFalse(network.consult(3, 2));
        Assert.assertFalse(network.consult(3, 3));
        Assert.assertFalse(network.consult(3, 4));
        Assert.assertFalse(network.consult(3, 5));
        Assert.assertTrue(network.consult(3, 6));
        Assert.assertFalse(network.consult(4, 1));
        Assert.assertFalse(network.consult(4, 2));
        Assert.assertFalse(network.consult(4, 3));
        Assert.assertFalse(network.consult(4, 4));
        Assert.assertTrue(network.consult(4, 5));
        Assert.assertFalse(network.consult(4, 6));
        Assert.assertFalse(network.consult(5, 1));
        Assert.assertFalse(network.consult(5, 2));
        Assert.assertFalse(network.consult(5, 3));
        Assert.assertTrue(network.consult(5, 4));
        Assert.assertFalse(network.consult(5, 5));
        Assert.assertFalse(network.consult(5, 6));
        Assert.assertFalse(network.consult(6, 1));
        Assert.assertFalse(network.consult(6, 2));
        Assert.assertTrue(network.consult(6, 3));
        Assert.assertFalse(network.consult(6, 4));
        Assert.assertFalse(network.consult(6, 5));
        Assert.assertFalse(network.consult(6, 6));
    }

    @Test
    public void testConnectionIndirection() throws AbstractNetworkException {

        INetwork<Integer> network = new NetworkIntegerImpl(6);
        network.connect(1, 2);
        network.connect(2, 3);
        network.connect(3, 6);

        Assert.assertFalse(network.consult(1, 1));
        Assert.assertTrue(network.consult(1, 3));
        Assert.assertFalse(network.consult(1, 4));
        Assert.assertFalse(network.consult(1, 5));
        Assert.assertTrue(network.consult(1, 6));
        Assert.assertFalse(network.consult(2, 2));
        Assert.assertFalse(network.consult(2, 4));
        Assert.assertFalse(network.consult(2, 5));
        Assert.assertTrue(network.consult(2, 6));
        Assert.assertTrue(network.consult(3, 1));
        Assert.assertFalse(network.consult(3, 3));
        Assert.assertFalse(network.consult(3, 4));
        Assert.assertFalse(network.consult(3, 5));
        Assert.assertTrue(network.consult(3, 6));
        Assert.assertFalse(network.consult(4, 1));
        Assert.assertFalse(network.consult(4, 2));
        Assert.assertFalse(network.consult(4, 3));
        Assert.assertFalse(network.consult(4, 4));
        Assert.assertFalse(network.consult(4, 5));
        Assert.assertFalse(network.consult(4, 6));
        Assert.assertFalse(network.consult(5, 1));
        Assert.assertFalse(network.consult(5, 2));
        Assert.assertFalse(network.consult(5, 3));
        Assert.assertFalse(network.consult(5, 4));
        Assert.assertFalse(network.consult(5, 5));
        Assert.assertFalse(network.consult(5, 6));
        Assert.assertTrue(network.consult(6, 1));
        Assert.assertTrue(network.consult(6, 2));
        Assert.assertFalse(network.consult(6, 4));
        Assert.assertFalse(network.consult(6, 5));
        Assert.assertFalse(network.consult(6, 6));
    }

}