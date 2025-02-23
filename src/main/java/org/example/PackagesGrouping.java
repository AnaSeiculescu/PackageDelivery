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

	public List<GroupedPackages> groupingPackages() {
		List<Package> allPackages = getDataFromFile();

		List<GroupedPackages> groupedPackages = allPackages.stream()
				.collect(Collectors.groupingBy(Package::getTargetLocation))
				.entrySet()
				.stream()
				.map(entry -> new GroupedPackages(entry.getKey(), entry.getValue()))
				.collect(Collectors.toList());

		return groupedPackages;
	}
}
