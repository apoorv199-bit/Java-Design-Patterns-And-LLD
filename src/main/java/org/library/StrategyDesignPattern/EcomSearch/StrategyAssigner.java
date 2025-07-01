package org.library.StrategyDesignPattern.EcomSearch;

import org.library.StrategyDesignPattern.EcomSearch.strategy.PopularityStrategy;
import org.library.StrategyDesignPattern.EcomSearch.strategy.RatingStrategy;
import org.library.StrategyDesignPattern.EcomSearch.strategy.SearchStrategy;

import java.util.HashMap;
import java.util.Map;

public class StrategyAssigner {
    private final Map<Integer, SearchStrategy> strategyMap;

    public StrategyAssigner(){
        this.strategyMap = new HashMap<>();
        this.strategyMap.put(0, new PopularityStrategy());
        this.strategyMap.put(1, new RatingStrategy());
    }

    public SearchStrategy assign(int context){
        return strategyMap.getOrDefault(context, null);
    }
}
