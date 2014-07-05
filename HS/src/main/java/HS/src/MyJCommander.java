package HS.src;

/**
 * Created by SAP on 05.07.2014.
 */
import com.beust.jcommander.Parameter;

import java.util.ArrayList;
import java.util.List;

public class MyJCommander {



        @Parameter
        private List<String> parameters = new ArrayList<String>();

        @Parameter(names =  "-jsonFile")
        protected String jsonFile ;

        @Parameter(names = "-tag")
        protected String tag;


    }


