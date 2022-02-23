package spring.girish.jQueryMvc.controller;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class ImageController {

	@RequestMapping("/welcome")
	public ModelAndView init() {
		System.out.println("inside init()");
		ModelAndView model = new ModelAndView("welcome");
		return model;
		
	}
	
	@RequestMapping("/crontoSign")
	@ResponseBody
	public String getImage() {
		String json="";
		Map<String, String> map = new HashMap();	
		System.out.println("inside getImage()");
		ObjectMapper mapper = new ObjectMapper();
		String res ="SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=SGksIHRoaXMgaXMgUVI=";
		//ModelAndView model = new ModelAndView();
		//JSONObject json = new JSONObject();
		 //json.put("QrImage",res);
		try {
			map.put("QRImage", res);
		json = mapper.writeValueAsString(map);
		}
		catch(Exception e) {System.out.println("Exceptionoccured : "+e.getMessage());}
		System.out.println("response in json format : "+json);
		System.out.println("Exiting getImage()");
		return json;
	}
}
