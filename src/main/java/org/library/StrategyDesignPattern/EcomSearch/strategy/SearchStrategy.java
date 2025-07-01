package org.library.StrategyDesignPattern.EcomSearch.strategy;

import java.util.List;

public interface SearchStrategy {
    List<String> searchProducts(String query);
}
