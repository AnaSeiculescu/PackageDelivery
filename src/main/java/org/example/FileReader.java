package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
	private List<String> packagesEntries = new ArrayList<>();
	private final Path path;

	private FileReader(Path path) {
		this.path = path;
	}

	private void readFile() {
		try {
			packagesEntries = Files.readAllLines(path);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public List<String> getPackagesEntries() {
		if (packagesEntries.isEmpty()) {
			readFile();
		}
		return packagesEntries;
	}

}
