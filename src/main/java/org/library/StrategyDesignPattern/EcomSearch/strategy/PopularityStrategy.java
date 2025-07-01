package org.library.StrategyDesignPattern.EcomSearch.strategy;

import java.util.List;

public class PopularityStrategy implements SearchStrategy{
    @Override
    public List<String> searchProducts(String query) {
        return List.of("Popularity1", "Popularity2", "Popularity3");
    }
}
