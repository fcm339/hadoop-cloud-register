package com.hzl.hadoop.app.vo;

/**
 * description
 *
 * @author hzl 2021/07/15 9:58 AM
 */
public class Pinyin {

	/**
	 * 中文简体
	 */
	String zwjt;
	/**
	 拼音
	 */
	String pinyin;
	/**
	中文繁体
	*/
	String zwft;
	/**
	分隔符
	*/
	String fg;

	/**
	 是否中午
	 */
	Boolean isCh;

	public String getZwjt() {
		return zwjt;
	}

	public void setZwjt(String zwjt) {
		this.zwjt = zwjt;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public String getZwft() {
		return zwft;
	}

	public void setZwft(String zwft) {
		this.zwft = zwft;
	}

	public String getFg() {
		return fg;
	}

	public void setFg(String fg) {
		this.fg = fg;
	}

	public Boolean getCh() {
		return isCh;
	}

	public void setCh(Boolean ch) {
		isCh = ch;
	}

	public static Pinyin convert(String par){
		//第一步将字符串转换成char
		char[] charArr = par.toCharArray();
		Pinyin pinyin = new Pinyin();

		return pinyin;
	}


}
