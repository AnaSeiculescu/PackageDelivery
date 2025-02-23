package org.example;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PackagesGrouping {
	private Path inputPath;

	public PackagesGrouping(String pathString) {
		this.inputPath = Paths.get(pathString);
	}

	private List<Package> getDataFromFile() {
		FileParser fileParser = new FileParser();
		List<String> linesFromFile = new ArrayList<>();
		try {
			linesFromFile = fileParser.readFile(inputPath);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		List<Package> allPackages = fileParser.parseFileContent(linesFromFile);
		return allPackages;
	}

	public List<GroupedPackagesByLoc> groupingPackagesByLocation() {
		List<Package> allPackages = getDataFromFile();

		List<GroupedPackagesByLoc> groupedPackages = allPackages.stream()
				.collect(Collectors.groupingBy(Package::getTargetLocation))  // grouping packages by location, resulting in a Map<String, List<Package>>
				.entrySet()
				.stream() // converting the entries of the Map back into a stream
				.map(entry -> new GroupedPackagesByLoc(entry.getKey(), entry.getValue())) // for each we create a new GroupedPackagesByLoc
				.collect(Collectors.toList());

		return groupedPackages;
	}

//	public List<GroupedPackagesByDate> groupingPackagesByDate() {
//		List<GroupedPackagesByLoc> groupedPackagesByLocation = groupingPackagesByLocation();
//
//		return groupedPackagesByDate;
//	}
}
