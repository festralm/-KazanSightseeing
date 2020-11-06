package fillDB;

import liquibase.pro.packaged.S;
import service.SightService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FillSight {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner reader = new Scanner(new FileReader("src/main/java/fillDB/sight_info.txt"))
                .useDelimiter("thisisend");
        int i = 1;
        while (reader.hasNext()) {
            String text = reader.next().replace("\r\n", "</br>");

            String[] textArray = text.split("thisisname");

            SightService sightService = new SightService();
            sightService.addNewSight(textArray[0],
                    textArray[1].replaceFirst("</br>",""),
                    "photo/sight/" + i + "/main.jpg");

            i++;
            if (i == 10) {
                break;
            }
        }
    }
}
