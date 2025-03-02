package com.edureka.hotelservice.domain;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "order_table")
//@Data
//@Getter @Setter
//@Builder
//@NoArgsConstructor
//@ToString
public class Order {
	
	
    public Order() {
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotelOrderId;
    private Long orderId;
//    @Enumerated(EnumType.STRING)
    private String orderState;
//    @Enumerated(EnumType.STRING)
    private String orderStatus;
    private String sourceLocation;
    private String destinationLocation;

    private BigDecimal amount;

    private LocalDate bookingDate;

	public Long getHotelOrderId() {
		return hotelOrderId;
	}

	public void setHotelOrderId(Long hotelOrderId) {
		this.hotelOrderId = hotelOrderId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getSourceLocation() {
		return sourceLocation;
	}

	public void setSourceLocation(String sourceLocation) {
		this.sourceLocation = sourceLocation;
	}

	public String getDestinationLocation() {
		return destinationLocation;
	}

	public void setDestinationLocation(String destinationLocation) {
		this.destinationLocation = destinationLocation;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
    
    
}
