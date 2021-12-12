package com.atilayakkan.assignment.orderservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "orders")
@CompoundIndex(name = "productID_email", def = "{'productID' : 1, 'email': 1}")
@JsonPropertyOrder({"_id", "productID", "email", "firstName", "lastName"})
public class Order {

    @Id
    @JsonProperty("orderID")
    private String _id;
    private String productID;
    private String email;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;

    public Order() {
    }

    public Order(String _id, String productID, String email, String firstName, String lastName) {
        this._id = _id;
        this.productID = productID;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return _id.equals(order._id) && productID.equals(order.productID) && email.equals(order.email) && firstName.equals(order.firstName) && lastName.equals(order.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, productID, email, firstName, lastName);
    }

    @Override
    public String toString() {
        return "Order{" +
                "_id='" + _id + '\'' +
                ", productID=" + productID +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
