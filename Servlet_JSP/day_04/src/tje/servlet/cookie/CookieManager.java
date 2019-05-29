package tje.servlet.cookie;

import java.util.*;

import javax.servlet.http.Cookie;

public class CookieManager {
	private HashMap<String, Cookie> cookieMap = new HashMap<>();
	
	public CookieManager(Cookie [] cookies) {
		if(cookies == null) {
			return;
		}
		
		for(Cookie cookie : cookies) {
			// 현재 배열로 들어온 모든 쿠키를 해쉬맵에 저장
			cookieMap.put(cookie.getName(), cookie);
		}
		
	}
	
	
	
	public Cookie getCookie(String name) {
		return this.cookieMap.get(name);
	}
	
	
	public String getValue(String name) {
		Cookie target = getCookie(name);
		return target == null ? null : target.getValue();
	}
	
	
}
