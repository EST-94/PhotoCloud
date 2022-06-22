package com.photoCloud.main;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class mainController {

	private final Logger logger = LoggerFactory.getLogger(mainController.class.getName());
	
	
	@ResponseBody
	@GetMapping("/test")
	public String mainPage() {
		
		String resultString = "for test connection with server";
		
		return resultString;
	};
	
	// 1. DB에서 사용자에 관한 파라미터를 받아 테이블에 접근 및 경로를 불러옴
	@GetMapping("/initViewer")
	public String resourceDirGetter() {
		
		logger.info("/initViewer initiated.");
		
		String debugMod = "Y"; // 프로퍼티로 뺄 것
		
		if (debugMod.equals("Y")) {
			
			logger.debug("from /initViewer - debugmod initiated.");
			Map<String, String> userInfoTestTemp = new HashMap<>();
			
			userInfoTestTemp.put("ID", "admin");
			userInfoTestTemp.put("CDSID", "jhkim0001");
			
		} else {
			
		}
		
		
		return "/paramSender.do";
	};
	
	// 2. 자원경로를 받아 파라미터로 전달
	@RequestMapping("/paramSender.do")
	public String resourceParamSender() {
		
		// 2-1. 자원경로 받아오는 서비스 구현
		
		
		// 2-2. 받아온 자원경로를 통해 파일시스템 내의 파일 접근 후 리턴
		
		return "/doneViewer.do";
	};
	
	
	// 3. 화면에 자원 출력
	@RequestMapping("/doneViewer.do")
	public String photoViewer(Model model) {
		
		logger.info("user accessed to /view.");
		
		return "index";
	};
	
}
