package org.library.StrategyDesignPattern.EcomSearch.strategy;

import java.util.List;

public class RatingStrategy implements SearchStrategy{
    @Override
    public List<String> searchProducts(String query) {
        return List.of("Rating1", "Rating2", "Rating3");
    }
}
