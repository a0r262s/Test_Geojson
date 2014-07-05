package HS.src;

/**
 * Created by a0r262s on 30.06.2014.
 */


import com.beust.jcommander.JCommander;



import com.beust.jcommander.JCommander;

/**
 * Created by a0r262s on 26.06.2014.
 */
public class ArgsParser {
    static String jsonFile;
    static String tag;
    static String android;
    static String dirOut;
    static String property;
    static String jarSignPath;
    /*
    ArgsParser(String file, String android, String dirOut,boolean boolJimple )
    {
        this.android=android;
        this.file=file;
        this.boolJimple=boolJimple;
        this.dirOut=dirOut;

    }
    */
    public static void extractor (String args[])
    {
        MyJCommander myJCommander = new MyJCommander();
        new JCommander(myJCommander, args);

        jsonFile=myJCommander.jsonFile;
        tag=myJCommander.tag;

        //android=myJCommander.androidJar;
        //dirOut=myJCommander.outputdir;

        //jarSignPath=myJCommander.jarSigner;
    }
}
