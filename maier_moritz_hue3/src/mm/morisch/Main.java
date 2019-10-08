package mm.morisch;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {



    public static void main(String[] args) {
        List<Weapon> weapons = new ArrayList<>();
        Weapon w = new Weapon();
        weapons = w.readCSV("weapons.csv");
        Printable printable = (n) -> n.forEach(System.out::println);
        System.out.println("Weapons");
        printable.print(Collections.unmodifiableList(weapons));
    }






}
