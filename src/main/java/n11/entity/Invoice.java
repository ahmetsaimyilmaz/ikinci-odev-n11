package n11.entity;

import lombok.Getter;
import lombok.Setter;
import n11.constants.Category;

import java.time.LocalDate;
@Getter
@Setter
public class Invoice {
    private double amount;
    private LocalDate date;
    final Category category;
    public Invoice(double amount, LocalDate date, Category category) {
        this.amount = amount;
        this.date = date;
        this.category=category;
    }


}
