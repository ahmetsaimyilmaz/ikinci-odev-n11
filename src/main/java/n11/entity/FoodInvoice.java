package n11.entity;

import n11.constants.Category;

import java.time.LocalDate;

public class FoodInvoice extends Invoice {
    public FoodInvoice(double amount, LocalDate date) {
        super(amount, date, Category.FOOD);
    }
}