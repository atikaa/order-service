package com.atilayakkan.assignment.orderservice.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class CreateOrderDTO {

    @NotNull(message = "productID cannot be null!")
    private String productID;

    @NotEmpty(message = "email cannot be null or empty!")
    @Email(message = "Invalid email format!")
    private String email;

    public CreateOrderDTO() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateOrderDTO)) return false;
        CreateOrderDTO that = (CreateOrderDTO) o;
        return productID.equals(that.productID) && email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID, email);
    }

    @Override
    public String toString() {
        return "CreateOrderDTO{" +
                "productID=" + productID +
                ", email='" + email + '\'' +
                '}';
    }
}
