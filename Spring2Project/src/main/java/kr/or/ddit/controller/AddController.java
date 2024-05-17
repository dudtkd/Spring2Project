package kr.or.ddit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.Add;


@Controller
@RequestMapping("/add")
public class AddController {

	static List<Add> addList = new ArrayList<>();
	
	@RequestMapping(value = "/addAddress.do" , method = RequestMethod.GET)
	public String addAddressForm() {
		return "script/addAddress";
		
	}
	
	@RequestMapping(value = "/addressBook.do" , method = RequestMethod.GET)
	public String addressBook(Model model) {
		
		model.addAttribute("addList", addList);
		
		return "script/addressBook";
		
	}
	
	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	public String addAddress(Add add , Model model) {
		
		if(add.getGender().equals("male")) {
			add.setGender("남자");
		}else {
			add.setGender("여자");
		}
		
		addList.add(add);
		
		System.out.println(addList.get(0));
		
		
		
		return "redirect:/add/addressBook.do";
		
		
		
		
	}
	
	
	
}
