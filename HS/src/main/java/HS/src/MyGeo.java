package HS.src;
import com.beust.jcommander.JCommander;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.geojson.Feature;
import org.geojson.FeatureCollection;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by SAP on 05.07.2014.
 */
public class MyGeo {

    public void reader () throws IOException {
        String sFileName = ".\\Result_"+ArgsParser.jsonFile+".csv";
        String file = ".\\GeoJSON\\"+ArgsParser.jsonFile;
        String tag = ArgsParser.tag;
        Pattern pattern=null;

        FileWriter writer = new FileWriter(sFileName);

        InputStream inputStream =  new FileInputStream(file);

        FeatureCollection featureCollection =
                new ObjectMapper().readValue(inputStream, FeatureCollection.class);

        List<Feature> featureList =featureCollection.getFeatures();
        System.out.println("\nSize:    " + featureList.size());
        if (file.contains("planungsraeume.geojson")) {
            pattern = Pattern.compile("<td>(\\d{8})</td>");
            writer.append("Name");
            writer.append(',');
            writer.append("PLR");
            writer.append('\n');
        }
        if (file.contains("bezirksregionen.geojson")){
            pattern = Pattern.compile("<td>(\\d{6})</td>");
            writer.append("Name");
            writer.append(',');
            writer.append("BZR");
            writer.append('\n');
        }
        if (file.contains("prognoseraeme.geojson")){
            pattern = Pattern.compile("<td>(\\d{4})</td>");
            writer.append("Name");
            writer.append(',');
            writer.append("PGR");
            writer.append('\n');
        }
        for (Feature f:featureList){
            System.out.print("\nName\t"+f.getProperty(tag)+"\n");
            writer.append(f.getProperty(tag).toString());
            writer.append(',');
            //System.out.print("\n Description:"+f.getProperty("description"));
            String str = f.getProperty("description").toString();

            Matcher matcher = pattern.matcher(str);
            while (matcher.find()) {
                //if (tag.equals("name"))
                if (file.contains("planungsraeume.geojson")) {
                    System.out.println("\n\tPLR\t" + matcher.group(1));

                    writer.append(matcher.group(1));
                    writer.append('\n');
                }
                if (file.contains("bezirksregionen.geojson")){
                    System.out.println("\n\tBZR\t" + matcher.group(1));
                    writer.append(matcher.group(1));
                    writer.append('\n');
                }
                if (file.contains("prognoseraeme.geojson")){
                    System.out.print("\n\tPGR\t" + matcher.group(1));
                    writer.append(matcher.group(1));
                    writer.append('\n');

                }
                //if (tag.equals(""))
            }
        }
        writer.flush();
        writer.close();

    }
}
