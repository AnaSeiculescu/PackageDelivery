package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor

public class Package {
	private String targetLocation;
	private int targetDistance;
	private int packageValue;
	private LocalDate deliveryDate;

	@Override
	public String toString() {
		return "Package{" +
				"targetLocation='" + targetLocation + '\'' +
				", targetDistance=" + targetDistance +
				", packageValue=" + packageValue +
				", deliveryDate=" + deliveryDate +
				'}';
	}
}
