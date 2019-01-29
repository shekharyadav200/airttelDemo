package com.test.airtelDemo;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
@Service
public class CommonWordFinderService {
	private static Logger logger = LoggerFactory.getLogger(CommonWordFinderService.class);
	public Collection<String> duplicateFinder(List<String> fileList) throws Exception {
		Collection<String> collection = null;
		Collection<String> duplicateWords = null;
		AirtelFileReader airtelFileReader = new TextFileReaderService();
		for (String filePath : fileList) {
			if (collection == null) {
				collection = new HashSet<String>();
				collection.addAll(airtelFileReader.readFile(filePath));
			} else {
				duplicateWords = new HashSet<String>();
				for (String word : airtelFileReader.readFile(filePath)) {
					if (collection.contains(word)) {
						duplicateWords.add(word);
					}
				}
			}
			if (duplicateWords != null)
				collection = duplicateWords;
		}
		logger.debug("duplicate words find in files {}",duplicateWords.toString());
		return duplicateWords;
	}

}
