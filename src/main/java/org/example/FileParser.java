package org.example;

import lombok.Getter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
@Getter
public class FileParser {

	public List<String> readFile(Path path) {
		List<String> lines;
		if (!Files.exists(path)) {
			System.out.println("File not found!");
			System.exit(1);
		}
		try {
			lines = Files.readAllLines(path);
		} catch (IOException e) {
			throw new RuntimeException("Something went wrong reading the file: " + e);
		}
		return lines;
	}

	public List<Package> parseFileContent(List<String> linesFromFile) {

		if (linesFromFile.isEmpty()) {
			System.out.println("File is empty or has invalid entries.");
			return Collections.emptyList();
		}
		List<Package> packages = linesFromFile.stream()
				.map(this::parseLine)
				.filter(Optional::isPresent)
				.map(Optional::get)
				.collect(Collectors.toList());

		return packages;
	}

	private Optional<Package> parseLine(String line) {
		String[] parts = line.split(",");

		if (parts.length < 3) {
			System.out.println("Found less than three elements at line: " + line);
			return Optional.empty();
		}

		for (String element : parts) {
			if (element.trim().isEmpty()) {
				System.out.println("Entry is incomplete at line: " + line);
				return Optional.empty();
			}
		}
		try {
			LocalDate deliveryDate = LocalDate.parse(parts[3]);
			return Optional.of(new Package(parts[0], parseInt(parts[1]), parseInt(parts[2]), deliveryDate));
		} catch (DateTimeParseException e) {
			System.out.println("Invalid delivery date format at line: " + line);
			return Optional.empty();
		}
	}
}
