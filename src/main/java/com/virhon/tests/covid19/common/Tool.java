package com.virhon.tests.covid19.common;

import java.io.*;

public class Tool {
    public static final String readFile(final String filename) throws IOException {
        String result = "";
        InputStreamReader isReader = new InputStreamReader(new FileInputStream(new File(filename)));
        BufferedReader br = new BufferedReader(isReader);
        String brLine = br.readLine();
        while (brLine != null) {
            result = result.concat(brLine);
            brLine = br.readLine();
        }
        return result;
    }
}
