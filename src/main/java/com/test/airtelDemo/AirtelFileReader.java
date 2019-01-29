package com.test.airtelDemo;

import java.util.Collection;

public interface AirtelFileReader {

	public Collection<String> readFile(String filePath) throws Exception;
	
}
