package yadisk.nitribubbles.com.yadisk.data.repository;

import yadisk.nitribubbles.com.yadisk.data.store.LocalStorage;

/**
 * Created by konstantinaksenov on 29.01.17.
 */

public class ProductionRepository implements Repository {
    private final LocalStorage localStorage;


    public ProductionRepository(LocalStorage localStorage) {
        this.localStorage = localStorage;
    }
}
