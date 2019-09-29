package com.thanh.object;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
//@PropertySource("classpath:kanji.yml")
@ConfigurationProperties(prefix="myclass")
public class MyClass {
	String id;
	List<Map<String,String>> list;
	
	public List<Kanji> getListKanji(){
		List<Kanji> kq = new ArrayList<Kanji>();
		for (Map<String,String> m : list) {
			Kanji tmp = new Kanji();
			tmp.setId(Integer.parseInt(m.get("id")));
			tmp.setHAN_VIET(m.get("hanviet"));
			tmp.setJp(m.get("jp"));
			tmp.setVN(m.get("vn"));
			tmp.setHIRAGANA(m.get("hiragana"));
			kq.add(tmp);
		}
		return kq;
		
	}

	public Kanji findByJp(String kanji, List<Kanji> listKanji) {
		for(Kanji k:listKanji)
			if(k.getJp().equals(kanji))
				return k;
		return null;
	};
}
