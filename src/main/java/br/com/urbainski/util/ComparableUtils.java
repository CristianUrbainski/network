package br.com.urbainski.util;

/**
 * @author Cristian Urbainski
 * @since 30/12/2020
 */
public abstract class ComparableUtils {

    public static <T extends Comparable> boolean equals(T n1, T n2) {

        if (n1 == null) {

            return n2 == null;
        } else if (n2 == null) {

            return false;
        }

        return n1.compareTo(n2) == 0;
    }

    public static <T extends Comparable> boolean lessThanOrEqual(T n1, T n2) {

        if (n1 == null) {

            return n2 == null;
        } else if (n2 == null) {

            return false;
        }

        return n1.compareTo(n2) <= 0;
    }

    public static <T extends Comparable> boolean greatherThan(T n1, T n2) {

        if (n1 == null) {

            return n2 == null;
        } else if (n2 == null) {

            return false;
        }

        return n1.compareTo(n2) > 0;
    }

}