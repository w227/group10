/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */

package com.example.daiduditu.clusterutil.clustering.algo;




import java.util.Collection;

/**
 * Logic for computing clusters
 */
public interface Algorithm<T > {
    void addItem(T item);

    void addItems(Collection<T> items);

    void clearItems();

    void removeItem(T item);



    Collection<T> getItems();
}