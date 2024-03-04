package n11.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.*;
@Getter
@Setter
public class Customer {
    private String name;
    private LocalDate registrationDate;
    private List<Invoice> invoices = new ArrayList<>();

    public Customer(String name, LocalDate registrationDate) {
        this.name = name;
        this.registrationDate = registrationDate;
    }
    public void addInvoice(Invoice invoice) {
        this.invoices.add(invoice);
    }

    public void addInvoice(List<Invoice> invoiceList) {
        this.invoices.addAll(invoiceList);
    }

}
