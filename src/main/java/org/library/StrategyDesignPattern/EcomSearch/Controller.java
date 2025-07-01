package org.library.StrategyDesignPattern.EcomSearch;

import org.library.StrategyDesignPattern.EcomSearch.strategy.SearchStrategy;

import java.util.List;

public class Controller {
    public static void main(String[] args){
        StrategyAssigner strategyAssigner = new StrategyAssigner();

        SearchStrategy strategy = strategyAssigner.assign(1);
        List<String> products = strategy.searchProducts("Iphone");

//        System.out.println(products.toString());
        products.forEach(System.out::println);
    }
}
