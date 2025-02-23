package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class GroupedPackagesByLoc {
	private String location;
	private List<Package> groupedPackages;

	@Override
	public String toString() {
		return "GroupedPackagesByLoc{" +
				"location='" + location + '\'' +
				", groupedPackages=" + groupedPackages +
				'}' + '\n';
	}
}
