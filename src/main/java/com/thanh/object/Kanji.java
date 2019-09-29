package com.thanh.object;

import java.util.Collection;


import lombok.Data;

@Data
public class Kanji {	
	private Integer id;
	
	private String jp;
	private String VN;
	private String HIRAGANA;
	private String HAN_VIET;
	private String HINH_ANH;
	
//	@OneToMany(mappedBy="id_KANJI", fetch=FetchType.EAGER)
//	private Collection<KanjiRel> kanjiRels;
	
}
