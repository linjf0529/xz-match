package com.xz.match.utils.excel;

import java.io.Serializable;

/**
 * 
 * @author chenwf
 *
 * @param <K>
 * @param <V>
 */
public class Tuple<K, V> implements Serializable {
    public final K key;
    public final V value;
     
    public Tuple(K k, V v) {
        this.key = k;
        this.value = v;
    }
}