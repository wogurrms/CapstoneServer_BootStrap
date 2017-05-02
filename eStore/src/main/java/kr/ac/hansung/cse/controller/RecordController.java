package kr.ac.hansung.cse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.hansung.cse.model.ChartResponseData;
import kr.ac.hansung.cse.model.Record;
import kr.ac.hansung.cse.model.ResponseData;
import kr.ac.hansung.cse.service.RecordService;

@RestController
public class RecordController {
	@Autowired
	private RecordService recordService;
	
	@RequestMapping("/records")
	public String getRecords(Model model){
		List<Record> records = recordService.getRecords();
		model.addAttribute("records",records);
		return "records";
	}

	@RequestMapping("/records/{recordId}")
	public String getRecordDetail(@PathVariable int recordId, Model model){
		Record record = recordService.getRecordById(recordId);
		model.addAttribute("record",record);
		return "recorddetail";
	}
	
	@RequestMapping("/todayamount")
	public String getTodayAmount(Model model){
	
		int todayAmount = recordService.getTodayAmount();
		float myAvg = recordService.getAvgAmount();
		ResponseData responseData = new ResponseData();
		responseData.setTodayAmount(todayAmount);
		responseData.setAvg(myAvg);
		model.addAttribute("responseData",responseData);
		return "todayamount";
	}
	

	@RequestMapping("/chartFromRecord")
	public String chartFromRecord(Model model){
		List<ChartResponseData> chartResponseData = recordService.getChartResponseData();
		model.addAttribute("results",chartResponseData);
		return "chart";
	}

	@RequestMapping(value="/chartFromRecordToRest", method=RequestMethod.GET)
	public ResponseEntity<List<ChartResponseData>> chartFromRecordToRest(Model model){
		List<ChartResponseData> chartResponseDataList = recordService.getChartResponseData();

		if(chartResponseDataList.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ChartResponseData>>(chartResponseDataList,HttpStatus.OK);
	}
	
}
