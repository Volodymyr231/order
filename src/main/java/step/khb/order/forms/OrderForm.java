package step.khb.order.forms;

import step.khb.order.model.Customer;
import step.khb.order.model.Delivery;
import step.khb.order.model.Product;

import java.time.LocalDate;

public class OrderForm {
    private String id;
    private Delivery delivery;
    private Product product;
    private Customer customer;
    private int price;
    private int number;
    private LocalDate date;

    public OrderForm() {
    }

    public OrderForm(Delivery delivery, Product product, Customer customer, int price, int number, LocalDate date) {
        this.delivery = delivery;
        this.product = product;
        this.customer = customer;
        this.price = price;
        this.number = number;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "OrderForm{" +
                "id='" + id + '\'' +
                ", delivery=" + delivery +
                ", product=" + product +
                ", customer=" + customer +
                ", price=" + price +
                ", number=" + number +
                ", date=" + date +
                '}';
    }
}
