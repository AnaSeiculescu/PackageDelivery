package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
public class GroupedPackagesByDate {
	private LocalDate deliveryDate;
	private List<Package> groupedPackages;

	@Override
	public String toString() {
		return "GroupedPackagesByDate{" +
				"deliveryDate=" + deliveryDate +
				", groupedPackages=" + groupedPackages +
				'}' + '\n';
	}
}
