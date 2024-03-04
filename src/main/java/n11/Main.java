package n11;

import n11.constants.Category;
import n11.entity.Customer;
import n11.entity.FoodInvoice;
import n11.entity.Invoice;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();

        Customer customer1 = new Customer("Alice", LocalDate.of(2024, 6, 15));
        customer1.addInvoice(new Invoice(1200, LocalDate.of(2024, 6, 20), Category.TECHNOLOGY));
        customer1.addInvoice(new FoodInvoice(500, LocalDate.of(2024, 6, 25)));

        Customer customer2 = new Customer("Bob", LocalDate.of(2024, 3, 11));
        customer2.addInvoice(new Invoice(1600, LocalDate.of(2024, 3, 15), Category.COSMETIC));

        Customer customer3 = new Customer("Charlie", LocalDate.of(2024, 6, 5));
        customer3.addInvoice(new Invoice(800, LocalDate.of(2024, 6, 10), Category.FOOD));
        customer3.addInvoice(List.of(
                new Invoice(1000, LocalDate.now(), Category.FOOD),
                new Invoice(1500, LocalDate.now(), Category.FOOD)
        ));

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);

        System.out.println("All Customers:");
        customers.forEach(c -> System.out.println(c.getName()));

        System.out.println("*****************************");

        System.out.println("Customers with 'C' in their name:");
        customers.stream()
                .filter(c -> c.getName().contains("C"))
                .forEach(c -> System.out.println(c.getName()));

        System.out.println("*****************************");

        System.out.println("Total invoices amount for customers registered in June:");
        customers.stream()
                .filter(c -> c.getRegistrationDate().getMonth() == Month.JUNE)
                .flatMap(c -> c.getInvoices().stream())
                .mapToDouble(Invoice::getAmount)
                .sum();

        System.out.println("*****************************");

        System.out.println("All Invoices:");
        customers.stream()
                .flatMap(c -> c.getInvoices().stream())
                .forEach(i -> System.out.println("Amount: " + i.getAmount() + ", Date: " + i.getDate()));

        System.out.println("*****************************");

        System.out.println("Invoices over 1500TL:");
        customers.stream()
                .flatMap(c -> c.getInvoices().stream())
                .filter(i -> i.getAmount() > 1500)
                .forEach(i -> System.out.println("Amount: " + i.getAmount() + ", Date: " + i.getDate()));

    }
}