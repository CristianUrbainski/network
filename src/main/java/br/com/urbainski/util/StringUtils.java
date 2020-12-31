package br.com.urbainski.util;

/**
 * @author Cristian Urbainski
 * @since 30/12/2020
 */
public abstract class StringUtils {

    public static String valueOf(Object o) {

        return (o == null) ? "null" : o.toString();
    }

}