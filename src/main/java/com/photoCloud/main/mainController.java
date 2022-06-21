package com.photoCloud.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class mainController {

	private final Logger logger = LoggerFactory.getLogger(mainController.class.getName());
	
	
	@ResponseBody
	@GetMapping("/test")
	public String mainPage() {
		
		String resultString = "for testt";
		
		return resultString;
	};
	
	// 1. DB에서 사용자에 관한 파라미터를 받아 테이블에 접근 및 경로를 불러옴
	@GetMapping
	public String resourceDirGetter() {
		
		return "1";
	};
	
	// 2. 자원경로를 받아 파라미터로 전달
	@GetMapping()
	public String resourceParamSender() {
		
		return "1";
	};
	
	
	// 3. void-do 방식으로 자원경로를 받아 자원을 리턴함
	@GetMapping("/sender.do")
	public void photoSender() {
		
	};
	
	
	
	// 4. 화면에 자원 출력
	@GetMapping("/view")
	public String photoViewer(Model model) {
		
		logger.info("user accessed to /view.");
		
		return "index";
	};
	
}
