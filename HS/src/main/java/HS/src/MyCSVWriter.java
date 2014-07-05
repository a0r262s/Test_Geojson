package HS.src;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by SAP on 05.07.2014.
 */
public class MyCSVWriter {
    public void generateCsvFile() {
        String f =ArgsParser.jsonFile;
        String sFileName = ".\\csv_f.csv";
        {
            try {
                FileWriter writer = new FileWriter(sFileName);
                if (f.contains("planungsraeume.geojson")) {
                    writer.append("Name");
                    writer.append(',');
                    writer.append("PLR");
                    writer.append('\n');
                }
                if (f.contains("bezirksregionen.geojson")) {
                    writer.append("Name");
                    writer.append(',');
                    writer.append("BZR");
                    writer.append('\n');
                }
                if (f.contains("prognoseraeme.geojson")) {
                    writer.append("NAme");
                    writer.append(',');
                    writer.append("PGR");
                    writer.append('\n');
                }
                //generate whatever data you want

                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
