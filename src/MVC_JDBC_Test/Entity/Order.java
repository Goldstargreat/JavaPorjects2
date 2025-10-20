package MVC_JDBC_Test.Entity;

import oracle.sql.TIMESTAMP;

import java.util.Date;

public class Order {
    // 고객이름, 고객아이디, 배송지, 수량, 주문일자, 제품명
    private String orderNum;
    private String oderCustomer;
    private String orderProduct;
    private int quantity;
    public String shippingAdress;
    public Date shippingDate;
    public String customerName;
    public String customerId;
    public String productName;

    public void setOrderNum() {
        this.orderNum = orderNum;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getOderCustomer() {
        return oderCustomer;
    }

    public void setOderCustomer(String oderCustomer) {
        this.oderCustomer = oderCustomer;
    }

    public String getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(String orderProduct) {
        this.orderProduct = orderProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getShippingAdress() {
        return shippingAdress;
    }

    public void setShippingAdress(String shippingAdress) {
        this.shippingAdress = shippingAdress;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
