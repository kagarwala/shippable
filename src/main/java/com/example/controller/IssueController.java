package com.example.controller;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.jmx.access.InvalidInvocationException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;


import com.example.model.GitIssue;
import com.example.model.Issue;

@Controller
public class IssueController {
	private static String gitPublicDomain =  "https://github.com/";
	private int total;
	private int first ;
	private int second;
	private Map<String,String> info;
   @RequestMapping(value = "/issue", method = RequestMethod.GET)
   public ModelAndView student() {
      return new ModelAndView("issue", "command", new Issue());
   }
   
   @RequestMapping(value = "/track", method = RequestMethod.POST)
   public String trackIssue(@RequestParam("url") String url, 
   ModelMap model) {
	   try{
      model.addAttribute("url", url);
      info = getOwnerNRepo( url);
      
      buildData(1);
	   }catch(Exception e){
		   
	   }
    model.addAttribute("total", total);	
    model.addAttribute("first", first);	
    model.addAttribute("second", second);
    model.addAttribute("third", total - first - second);	
      return "track";
   }
   public final static long MILLIS_PER_DAY = 24 * 60 * 60 * 1000L;
   public final static long MILLIS_PER_WEEK = 7 * 24 * 60 * 60 * 1000L;
private void buildData(int page) {
	// TODO Auto-generated method stub
	List<GitIssue> resultList = new ArrayList<GitIssue>();
	  
	try{
	
	String gitUrl = String.format("https://api.github.com/repos/%s/%s/issues?state=open&per_page=100&page=%d", info.get("owner"),info.get("repo"),page);
    RestTemplate restTemplate = new RestTemplate();
    List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
  messageConverters.add(new MappingJacksonHttpMessageConverter());
  restTemplate.setMessageConverters(messageConverters);
   resultList = new ArrayList<GitIssue>();
   resultList = Arrays.asList(restTemplate.getForObject(gitUrl, GitIssue[].class));
   DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
   Date issueDate = null;
   long now = new Date().getTime();
   long diff =0;
   for(GitIssue g : resultList) {
	   try{
	   issueDate = df1.parse(g.getUpdated_at());
	  
	    diff = now - issueDate.getTime();
	   if( diff < MILLIS_PER_DAY){
		   first++;
	   }else{
		   if(diff < MILLIS_PER_WEEK){
			   econd++;
		   }else{
			   break;
		   }
	   }
	   }catch(Exception e){
			  continue;	 
			   
		   }
   }
  }catch(Exception e){
  	 
  
  }
	total = total + resultList.size();
	if(resultList.size() == 100){
		buildData(page +1);
	}
}

private Map<String, String> getOwnerNRepo(String url) throws Exception {
	// TODO Auto-generated method stub
	Map<String, String> info = new HashMap<String, String>();
	String lowerUrl = url.toLowerCase();
	if(!lowerUrl.startsWith(gitPublicDomain)){
		throw new InvalidUrlException();
	}
	lowerUrl = lowerUrl.substring(gitPublicDomain.length());
	String[] parts = lowerUrl.split("/");
	if(parts.length < 2)
		throw new InvalidUrlException();
	info.put("owner", parts[0]);
	info.put("repo", parts[1]);
	return info;
	
	
}
}