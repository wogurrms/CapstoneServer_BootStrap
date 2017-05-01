package kr.ac.hansung.cse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ChartController {

	@RequestMapping(value = "/chart", method = RequestMethod.GET)
	public String chart() {
		return "chart";
	}
}
