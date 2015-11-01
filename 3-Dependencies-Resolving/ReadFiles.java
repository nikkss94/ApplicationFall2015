package com.hackbulgari.niki;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadFiles {
	public static String generateJsonObj(String fileURL) {
		String stringJSONObj = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileURL));
			String line;
			while ((line = br.readLine()) != null) {
				stringJSONObj = stringJSONObj + " " + line;
			}
			br.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return stringJSONObj;
	}

}
