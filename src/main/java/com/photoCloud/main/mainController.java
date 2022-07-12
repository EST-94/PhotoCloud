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

	private static PropertiesReader propertiesReader = new PropertiesReader("settings.properties");
	private static final String CUSTOM_MOD = propertiesReader.getProperty("CUSTOM_MOD");
	private final Logger logger = LoggerFactory.getLogger(mainController.class.getName());
	private SessionVO stub = new SessionVO(null, null);
	
	
	@ResponseBody
	@GetMapping("/test")
	public String mainPage() {
		
		String resultString = "for test connection with server";
		
		return resultString;
	};
	
	// 1. DB에서 사용자에 관한 파라미터를 받아 테이블에 접근 및 경로를 불러옴
	// 0628 - DB 연결 미완, 현재 View에서 이미지 출력에 필요한 데이터타입 확인 중
	
	@GetMapping("/initViewer")
	public String resourceDirGetter(Model model) {
		
		logger.info("/initViewer called. CUSTOM_MOD = " + CUSTOM_MOD.toString());
				
		if (CUSTOM_MOD.toString().equals("DEBUG")) {
			
			boolean isDebug = true;
			logger.debug("from /initViewer - debug mod selected.");
			
			Map<String, String> testerVO = new HashMap<>();
			
			testerVO.put("ID", "admin");
			testerVO.put("CDSID", "jhkim0001");
			testerVO.put("dir", "<DIR_RESOURCE>");
			
			stub.setAll(
					testerVO.get("ID"), 
					testerVO.get("dir")
					);
			
			model.addAttribute("isDebug", isDebug);
			model.addAttribute("ConnectedInfos", stub);
			
			return "mainView";
			
		} else {
			
			//
			// 테스터 작동 확인 이후 작성
			//
		
			return "/paramSender.do";
		}
		
		
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
