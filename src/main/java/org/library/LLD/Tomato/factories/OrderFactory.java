package org.library.LLD.Tomato.factories;

import org.library.LLD.Tomato.models.*;
import org.library.LLD.Tomato.strategies.PaymentStrategy;

import java.util.List;

public interface OrderFactory {
    Order createOrder(User user, Cart cart, Restaurant restaurant, List<MenuItem> menuItems, PaymentStrategy paymentStrategy, double totalCost, String orderType);
}
