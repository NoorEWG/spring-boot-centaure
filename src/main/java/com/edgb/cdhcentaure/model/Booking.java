package com.edgb.cdhcentaure.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bookings")
public class Booking implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="id")
    private int id;
	
	@Column(name="name", length = 100, nullable = false)
	private String name;
	
	@Column(name="address", length = 100)
	private String address;
	
	@Column(name="city", length = 70)
	private String city;
	
	@Column(name="email", length = 50)
	private String email;
	
	@Column(name="tel", length = 20)
	private String phone;
	
	@Column(name="arrival")
	private LocalDate arrival;
	
	@Column(name="departure")
	private LocalDate departure;
	
	@Column(name="room1", nullable = false)
	private boolean room1;
	
	@Column(name="room2", nullable = false)
	private boolean room2;
	
	@Column(name="room1_disposition", length = 100)
	private String room1Disposition;
	
	@Column(name="room2_disposition", length = 100)
	private String room2Disposition;
	
	@Column(name="room1_price", length = 2)
	private int room1Price;
	
	@Column(name="room2_price", length = 2)
	private int room2Price;
	
	@Column(name="nights", length = 2)
	private int nights;
	
	@Column(name="no_pers_room1", length = 2)
	private int numberPersRoom1;
	
	@Column(name="no_pers_room2", length = 2)
	private int numberPersRoom2;
	
	@Column(name="dinner", length = 2)
	private int numberDinner;
	
	@Column(name="dinner_price", length = 2)
	private int dinnerPrice;
	
	@Column(name="dinner_child", length = 2)
	private int numberDinnerChild;
	
	@Column(name="dinner_child_price", length = 2)
	private int dinnerChildPrice;
	
	@Column(name="breakfast", length = 2)
	private boolean breakfast;
	
	@Column(name="price_breakfast", length = 2)
	private int breakfastPrice;
	
	@Column(name="no_breakfast", length = 2)
	private int numberBreakfast;
	
	@Column(name="price", length = 4)
	private int price;
	
	@Column(name="reduction", length = 3)
	private int reduction;
	
	@Column(name="closed")
	private boolean closed;
	
	@Column(name="receipt_nr", length = 8)
	private int receiptNumber;
	
	@Column(name="billing")
	private boolean billing;
	
	@Column(name="booking")
	private boolean booking;
	
	@Column(name="payment", length = 50)
	private String payment;
	
	@Column(name="access_code", length = 50)
	private String access_code;
		
	public Booking() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDate getArrival() {
		return arrival;
	}

	public void setArrival(LocalDate arrival) {
		this.arrival = arrival;
	}

	public LocalDate getDeparture() {
		return departure;
	}

	public void setDeparture(LocalDate departure) {
		this.departure = departure;
	}

	public boolean isRoom1() {
		return room1;
	}

	public void setRoom1(boolean room1) {
		this.room1 = room1;
	}

	public boolean isRoom2() {
		return room2;
	}

	public void setRoom2(boolean room2) {
		this.room2 = room2;
	}

	public String getRoom1Disposition() {
		return room1Disposition;
	}

	public void setRoom1Disposition(String room1Disposition) {
		this.room1Disposition = room1Disposition;
	}

	public String getRoom2Disposition() {
		return room2Disposition;
	}

	public void setRoom2Disposition(String room2Disposition) {
		this.room2Disposition = room2Disposition;
	}

	public int getRoom1Price() {
		return room1Price;
	}

	public void setRoom1Price(int room1Price) {
		this.room1Price = room1Price;
	}

	public int getRoom2Price() {
		return room2Price;
	}

	public void setRoom2Price(int room2Price) {
		this.room2Price = room2Price;
	}

	public int getNights() {
		return nights;
	}

	public void setNights(int nights) {
		this.nights = nights;
	}

	public int getNumberPersRoom1() {
		return numberPersRoom1;
	}

	public void setNumberPersRoom1(int numberPersRoom1) {
		this.numberPersRoom1 = numberPersRoom1;
	}

	public int getNumberPersRoom2() {
		return numberPersRoom2;
	}

	public void setNumberPersRoom2(int numberPersRoom2) {
		this.numberPersRoom2 = numberPersRoom2;
	}

	public int getNumberDinner() {
		return numberDinner;
	}

	public void setNumberDinner(int numberDinner) {
		this.numberDinner = numberDinner;
	}

	public int getDinnerPrice() {
		return dinnerPrice;
	}

	public void setDinnerPrice(int dinnerPrice) {
		this.dinnerPrice = dinnerPrice;
	}

	public int getNumberDinnerChild() {
		return numberDinnerChild;
	}

	public void setNumberDinnerChild(int numberDinnerChild) {
		this.numberDinnerChild = numberDinnerChild;
	}

	public int getDinnerChildPrice() {
		return dinnerChildPrice;
	}

	public void setDinnerChildPrice(int dinnerChildPrice) {
		this.dinnerChildPrice = dinnerChildPrice;
	}

	public boolean isBreakfast() {
		return breakfast;
	}

	public void setBreakfast(boolean breakfast) {
		this.breakfast = breakfast;
	}

	public int getBreakfastPrice() {
		return breakfastPrice;
	}

	public void setBreakfastPrice(int breakfastPrice) {
		this.breakfastPrice = breakfastPrice;
	}

	public int getNumberBreakfast() {
		return numberBreakfast;
	}

	public void setNumberBreakfast(int numberBreakfast) {
		this.numberBreakfast = numberBreakfast;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getReduction() {
		return reduction;
	}

	public void setReduction(int reduction) {
		this.reduction = reduction;
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public int getReceiptNumber() {
		return receiptNumber;
	}

	public void setReceiptNumber(int receiptNumber) {
		this.receiptNumber = receiptNumber;
	}

	public boolean isBilling() {
		return billing;
	}

	public void setBilling(boolean billing) {
		this.billing = billing;
	}

	public boolean isBooking() {
		return booking;
	}

	public void setBooking(boolean booking) {
		this.booking = booking;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getAccess_code() {
		return access_code;
	}

	public void setAccess_code(String access_code) {
		this.access_code = access_code;
	}
	
	
	
	
}
