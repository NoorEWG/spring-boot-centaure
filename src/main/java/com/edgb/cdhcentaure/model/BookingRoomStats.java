package com.edgb.cdhcentaure.model;

public class BookingRoomStats {
	Long personsRoom1;
	Long personsRoom2;
	Long totalPersons;

	public BookingRoomStats() {
		this.personsRoom1 = 0L;
		this.personsRoom2 = 0L;
		this.totalPersons = 0L;
	}

	public Long getPersonsRoom1() {
		return personsRoom1;
	}

	public void setPersonsRoom1(Long personsRoom1) {
		this.personsRoom1 = personsRoom1;
	}

	public Long getPersonsRoom2() {
		return personsRoom2;
	}

	public void setPersonsRoom2(Long personsRoom2) {
		this.personsRoom2 = personsRoom2;
	}

	public Long getTotalPersons() {
		return totalPersons;
	}

	public void setTotalPersons(Long totalPersons) {
		this.totalPersons = totalPersons;
	}

}
