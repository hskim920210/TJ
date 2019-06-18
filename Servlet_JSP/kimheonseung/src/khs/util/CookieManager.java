package khs.util;

import java.util.*;
import javax.servlet.http.Cookie;

public class CookieManager {
	private HashMap<String, Cookie> cookieMap = new HashMap<>();
	
	public CookieManager(Cookie [] cookies) {
		if(cookies == null)
			return;
		
		for( Cookie cookie : cookies )
			cookieMap.put(cookie.getName(), cookie);		
	}
	
	public Cookie getCookie(String name) {
		return this.cookieMap.get(name);
	}
	
	public String getValue(String name) {
		Cookie target = getCookie(name);
		return target == null ? null : target.getValue();
	}
}









