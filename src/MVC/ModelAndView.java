package MVC;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ModelAndView {

	private String viewName;
	
	private Map<String, String> responseValues;
	private Map<String, String[]> requestValues;
	
	public ModelAndView(HttpServletRequest req, HttpSession session){
		requestValues = req.getParameterMap();
		for(String key : requestValues.keySet()){
			session.setAttribute(key, requestValues.get(key)[0]);
		}
	}
	
	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
		
	public String getMap(String name){
		return requestValues.get(name)[0];
	}
	
		public void addObject(String name, String value){
		responseValues.put(name, value);
	}
}
