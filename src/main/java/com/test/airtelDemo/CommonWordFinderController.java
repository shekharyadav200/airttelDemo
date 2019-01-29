package com.test.airtelDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CommonWordFinderController {
	private static Logger logger = LoggerFactory.getLogger(CommonWordFinderController.class);
	@Autowired
private CommonWordFinderService commonWordFinderService;

@PostMapping(name="commonWordFinder")
	public ResponseEntity<CommonWordFinderResponse> commonWordFinder(@RequestBody CommonWordFinderRequest commonWordFinderRequest) throws Exception{
	logger.info("list of file {}",commonWordFinderRequest.getFileList().toString());
	if(commonWordFinderRequest.getFileList().size()<3){
		throw new InvalidRequestParameter("minimum three file is required in input to processed further");
	}
	CommonWordFinderResponse  commonWordFinderResponse=new CommonWordFinderResponse();
	commonWordFinderResponse.setCommonWord(commonWordFinderService.duplicateFinder(commonWordFinderRequest.getFileList()));
	return new ResponseEntity<>(commonWordFinderResponse, HttpStatus.OK);
	
	
		
	}
	
}
