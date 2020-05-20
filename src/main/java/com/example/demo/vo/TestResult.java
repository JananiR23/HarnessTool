package com.example.demo.vo;

import java.util.List;

public class TestResult {

	public Integer getTotaltestcases() {
		return totaltestcases;
	}

	public void setTotaltestcases(Integer totaltestcases) {
		this.totaltestcases = totaltestcases;
	}

	public Integer getPassed() {
		return passed;
	}

	public void setPassed(Integer passed) {
		this.passed = passed;
	}

	public Integer getFailed() {
		return failed;
	}

	public void setFailed(Integer failed) {
		this.failed = failed;
	}

	public List<TestoutputResult> getTestcasesResultList() {
		return testcasesResultList;
	}

	public void setTestcasesResultList(List<TestoutputResult> testcasesResultList) {
		this.testcasesResultList = testcasesResultList;
	}

	private Integer totaltestcases;
	
	private Integer passed;
	
	private Integer failed;
	
	private List<TestoutputResult> testcasesResultList;
}
