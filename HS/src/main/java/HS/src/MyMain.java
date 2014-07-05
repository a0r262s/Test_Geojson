package HS.src;
import java.io.IOException;

/**
 * Created by SAP on 05.07.2014.
 */
class MyMain {
    public  static void main(String args[]) throws IOException {
        ArgsParser argsParser = new ArgsParser();
        argsParser.extractor(args);
        MyGeo myGeo = new MyGeo();
        myGeo.reader();
        //MyCSVWriter myCSVWriter = new MyCSVWriter();
        //myCSVWriter.generateCsvFile();

    }
}
