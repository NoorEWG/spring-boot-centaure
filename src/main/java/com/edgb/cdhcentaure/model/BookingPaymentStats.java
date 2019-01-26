package com.edgb.cdhcentaure.model;

import java.util.ArrayList;
import java.util.List;

public class BookingPaymentStats {

	Long totalPayments;
	Long paymentCheque;
	Long paymentCash;
	Long paymentOther;
	Long totalPayed;
	Long notPayed;
	Long paymentBooking;
	Long turnoverRoom1;
	Long turnoverRoom2;
	List<Long> turnoverPerMonth;
	List<Long> cumulTurnoverPerMonth;
	List<Long> turnoverRoom1PerMonth;
	List<Long> cumulTurnoverRoom1PerMonth;
	List<Long> turnoverRoom2PerMonth;
	List<Long> cumulTurnoverRoom2PerMonth;
	List<GraphData> turnOverGraphData;

	public BookingPaymentStats() {
		this.totalPayments = 0L;
		this.paymentCheque = 0L;
		this.paymentCash = 0L;
		this.paymentOther = 0L;
		this.totalPayed = 0L;
		this.notPayed = 0L;
		this.paymentBooking = 0L;
		this.turnoverRoom1 = 0L;
		this.turnoverRoom2 = 0L;
		this.turnoverPerMonth = new ArrayList<Long>();
		this.cumulTurnoverPerMonth = new ArrayList<Long>();
		this.turnoverRoom1PerMonth = new ArrayList<Long>();
		this.cumulTurnoverRoom1PerMonth = new ArrayList<Long>();
		this.turnoverRoom2PerMonth = new ArrayList<Long>();
		this.cumulTurnoverRoom2PerMonth = new ArrayList<Long>();
		this.turnOverGraphData = new ArrayList<GraphData>();
	}

	public List<Long> getTurnoverRoom1PerMonth() {
		return turnoverRoom1PerMonth;
	}

	public void setTurnoverRoom1PerMonth(List<Long> turnoverRoom1PerMonth) {
		this.turnoverRoom1PerMonth = turnoverRoom1PerMonth;
	}

	public List<Long> getCumulTurnoverRoom1PerMonth() {
		return cumulTurnoverRoom1PerMonth;
	}

	public void setCumulTurnoverRoom1PerMonth(List<Long> cumulTurnoverRoom1PerMonth) {
		this.cumulTurnoverRoom1PerMonth = cumulTurnoverRoom1PerMonth;
	}

	public List<Long> getTurnoverRoom2PerMonth() {
		return turnoverRoom2PerMonth;
	}

	public void setTurnoverRoom2PerMonth(List<Long> turnoverRoom2PerMonth) {
		this.turnoverRoom2PerMonth = turnoverRoom2PerMonth;
	}

	public List<Long> getCumulTurnoverRoom2PerMonth() {
		return cumulTurnoverRoom2PerMonth;
	}

	public void setCumulTurnoverRoom2PerMonth(List<Long> cumulTurnoverRoom2PerMonth) {
		this.cumulTurnoverRoom2PerMonth = cumulTurnoverRoom2PerMonth;
	}

	public Long getTotalPayments() {
		return totalPayments;
	}

	public List<Long> getTurnoverPerMonth() {
		return turnoverPerMonth;
	}

	public void setTurnoverPerMonth(List<Long> turnoverPerMonth) {
		this.turnoverPerMonth = turnoverPerMonth;
	}

	public List<Long> getCumulTurnoverPerMonth() {
		return cumulTurnoverPerMonth;
	}

	public void setCumulTurnoverPerMonth(List<Long> cumulTurnoverPerMonth) {
		this.cumulTurnoverPerMonth = cumulTurnoverPerMonth;
	}

	public void setTotalPayments(Long totalPayments) {
		this.totalPayments = totalPayments;
	}

	public Long getPaymentCheque() {
		return paymentCheque;
	}

	public void setPaymentCheque(Long paymentCheque) {
		this.paymentCheque = paymentCheque;
	}

	public Long getPaymentCash() {
		return paymentCash;
	}

	public void setPaymentCash(Long paymentCash) {
		this.paymentCash = paymentCash;
	}

	public Long getPaymentOther() {
		return paymentOther;
	}

	public void setPaymentOther(Long paymentOther) {
		this.paymentOther = paymentOther;
	}

	public Long getTotalPayed() {
		return totalPayed;
	}

	public void setTotalPayed(Long totalPayed) {
		this.totalPayed = totalPayed;
	}

	public Long getNotPayed() {
		return notPayed;
	}

	public void setNotPayed(Long notPayed) {
		this.notPayed = notPayed;
	}

	public Long getPaymentBooking() {
		return paymentBooking;
	}

	public void setPaymentBooking(Long paymentBooking) {
		this.paymentBooking = paymentBooking;
	}

	public Long getTurnoverRoom1() {
		return turnoverRoom1;
	}

	public void setTurnoverRoom1(Long turnoverRoom1) {
		this.turnoverRoom1 = turnoverRoom1;
	}

	public Long getTurnoverRoom2() {
		return turnoverRoom2;
	}

	public void setTurnoverRoom2(Long turnoverRoom2) {
		this.turnoverRoom2 = turnoverRoom2;
	}

	public List<GraphData> getTurnOverGraphData() {
		return turnOverGraphData;
	}

	public void setTurnOverGraphData(List<GraphData> turnOverGraphData) {
		this.turnOverGraphData = turnOverGraphData;
	}
	
	

}
