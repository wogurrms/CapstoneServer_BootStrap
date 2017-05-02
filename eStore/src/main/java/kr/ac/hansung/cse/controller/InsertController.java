package kr.ac.hansung.cse.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.cse.model.Record;
import kr.ac.hansung.cse.model.Tobacco;
import kr.ac.hansung.cse.model.User;
import kr.ac.hansung.cse.service.RecordService;
import kr.ac.hansung.cse.service.TobaccoService;
import kr.ac.hansung.cse.service.UserService;

@Controller
public class InsertController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private RecordService recordService;
	@Autowired
	private TobaccoService tobaccoService;
	
	@RequestMapping("/insertUser")
	public String insert() throws ParseException{
		SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String now = formatter.format(new Date());
		
		
		Tobacco tobacco = new Tobacco();
		tobacco.setName("말보로레드");
		tobacco.setPrice(4500);
		tobacco.setNicotine(8);
		
		User user = new User();
		user.setMac("6B:45:34:1");
		user.setNick("wogur");
		user.setTobac(tobacco);
		
		Record record = new Record();
		record.setUser(user);
		record.setDate(formatter.parse(now));
		
		user.getRecords().add(record);
		
		tobaccoService.addTobacco(tobacco);
		userService.addUser(user);
		
		return "home";
	}
	
	
	@RequestMapping("/insertRecord")
	public String insertRecord() throws ParseException{
		SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String now = formatter.format(new Date());
		
		User user = userService.getUserByNick("wogur");
		
		Record record = new Record();
		record.setUser(user);
		record.setDate(formatter.parse(now));
		
		user.getRecords().add(record);
		
		recordService.addRecord(record);
		
		return "home";
	}
	
	@RequestMapping("/insertYesterDayRecord")
	public String insertYesterDayRecord() throws ParseException{
		SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String yesterday = "2017-05-01 00:37:20";
		
		User user = userService.getUserByNick("wogur");
		
		Record record = new Record();
		record.setUser(user);
		record.setDate(formatter.parse(yesterday));
		
		user.getRecords().add(record);
		
		recordService.addRecord(record);
		
		return "home";
	}
}
