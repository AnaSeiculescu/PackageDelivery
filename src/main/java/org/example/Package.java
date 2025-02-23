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


}
