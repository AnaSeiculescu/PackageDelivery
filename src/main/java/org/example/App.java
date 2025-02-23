package org.example;

import java.nio.file.Paths;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        FileParser fileParser = new FileParser();
//        System.out.println( fileParser.parseFileContent(fileParser.readFile(Paths.get("input.csv"))));

        PackagesGrouping packagesGrouping = new PackagesGrouping("input.csv");
        System.out.println(packagesGrouping.groupingPackagesByLocation());
    }
}
