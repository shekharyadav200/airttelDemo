package com.test.airtelDemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;




@Service
public class TextFileReaderService implements AirtelFileReader {
	Logger logger = LoggerFactory.getLogger(TextFileReaderService.class);

	public Collection<String> readFile(String filePath) throws Exception {
		logger.info("File Path: " + filePath);
		Collection<String> words = new HashSet<String>();
		File file = new File(filePath);
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			throw new Exception("File not Found " + filePath);

		}
		
		String st;
		try {
			while ((st = br.readLine()) != null) {
				String[] wordsTemp = st.split(" ");
				for (String string : wordsTemp) {
					words.add(StringUtil.replaceSpecialCharcter(string));
				}
			}
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		finally {
			br.close();
		}
		logger.debug("words {} find in file {} ",words.toString(),filePath);
		return words;
	}

}
