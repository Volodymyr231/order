package step.khb.order.model;

import java.time.LocalDate;

public class Order {
    private String id;
    private Delivery delivery;
    private Product product;
    private Customer customer;
    private int price;
    private int number;
    private LocalDate date;

    public Order() {
    }

    public Order(Delivery delivery, Product product, Customer customer, int price, int number, LocalDate date) {
        this.delivery = delivery;
        this.product = product;
        this.customer = customer;
        this.price = price;
        this.number = number;
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "Order{" +
                "id='" + id + '\'' +
                ", product=" + product +
                ", customer=" + customer +
                ", number=" + number +
                ", date=" + date +
                '}';
    }
}
