package com.thanh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thanh.object.Kanji;
import com.thanh.object.MyClass;


@Controller
public class MyController {
	int stt = 0;
	@Autowired
	MyClass myClass;
	
	String kanjiCu;	
	List<Kanji> listKanji;
	
	@RequestMapping("/listKanji")
	public String getListKanji(Model model) {
		List<Kanji> listKanji = myClass.getListKanji();
		model.addAttribute("listKanji",listKanji);
		return "listKanji";
	}
	
	// Sử dụng RESTFUL_API
	
	// Học kanji controller
	@RequestMapping("/hoc_index")
	public String getHocKanji() {
		return "hocKanji_index";
	}
	@GetMapping("/hoc")
	public String getHocKanji(Model model) {
		//Load lại danh sách
		listKanji = myClass.getListKanji();
		
		if(stt >= listKanji.size()-1)
			stt = 0;
		else 
			stt++; 
		
		Kanji kanji2 =  listKanji.get(stt);
		model.addAttribute("kanji",kanji2);
		model.addAttribute("stt", stt);
		return "getLearnKanji";
	}
	
	@RequestMapping("/test")
	public String test() {
		return "test";
	}
}
