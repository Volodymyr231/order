package step.khb.order.forms;

import step.khb.order.model.Customer;
import step.khb.order.model.Delivery;
import step.khb.order.model.Product;

import java.time.LocalDate;

public class OrderForm {
    private String id;
    private String delivery;
    private String product;
    private String customer;
    private int price;
    private int number;
    private String date;

    public OrderForm() {
    }

    public OrderForm(String delivery, String product, String customer, int price, int number, String date) {
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

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "OrderForm{" +
                "id='" + id + '\'' +
                ", delivery='" + delivery + '\'' +
                ", product='" + product + '\'' +
                ", customer='" + customer + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", date=" + date +
                '}';
    }

}
