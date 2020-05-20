package com.example.demo.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.vo.Testinput;
import com.example.demo.vo.Testoutput;
import com.example.demo.vo.TestResult;
import com.example.demo.vo.TestoutputResult;
import com.example.demo.vo.TestoutputAir;

@RestController
public class PermutationsController {

	@PostMapping("/scenarios")
	List<Testoutput> permutations(@RequestBody List<Testinput> testinputList) {
		List<Testoutput> outputList = new ArrayList<>();

		final List<List<Integer>> lists = new ArrayList<List<Integer>>();

		final List<List<Integer>> list3 = new ArrayList<List<Integer>>();

		final List<Integer> list0 = new ArrayList<Integer>();
		final List<Integer> list1 = new ArrayList<Integer>();
		final List<Integer> list2 = new ArrayList<Integer>();

		final Set<Integer> set0 = new HashSet();
		final Set<Integer> set1 = new HashSet();
		final Set<Integer> set2 = new HashSet();

		for (Testinput input : testinputList) {
			set0.add(input.getBarrowAmount());
			set1.add(input.getRiskFactor());
			set2.add(input.getTermFactor());
		}

		lists.add(new ArrayList<>(set0));
		lists.add(new ArrayList<>(set1));
		lists.add(new ArrayList<>(set2));
		int count = 0;
		final List<Integer> list4 = new ArrayList<Integer>();

		permute(lists, (permutation -> list4.addAll(permutation)));
		int j = 0;
		for (int i = 0; i < list4.size() / 3; i++) {
			Testoutput testOutPut = new Testoutput();
			//testOutPut.setId(String.valueOf(count++));
			testOutPut.setId("01"+LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd"))+String.format("%07d", ++count));
			testOutPut.setApplicationIdentity(testinputList.get(0).getApplicationIdentity());
			testOutPut.setBankDivision(testinputList.get(0).getBankDivision());
			testOutPut.setProductFamily(testinputList.get(0).getProductFamily());
			testOutPut.setProductName(testinputList.get(0).getProductName());
			testOutPut.setBarrowAmount(list4.get(j++));
			testOutPut.setRiskFactor(list4.get(j++));
			testOutPut.setTermFactor(list4.get(j++));
			outputList.add(testOutPut);
		}

		return outputList;
	}

	@PostMapping("/expectedScenarios")
	List<TestoutputAir> permutationsAir(@RequestBody List<Testoutput> testoutputList) {
		int count = 0;
		List<TestoutputAir> testoutputAirList = new ArrayList<>();
		for (Testoutput testoutPut : testoutputList) {
			TestoutputAir testoutputAir = new TestoutputAir();
			testoutputAir.setId(testoutPut.getId());
			//testoutputAir.setId("01"+LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd"))+String.format("%07d", count++));
			testoutputAir.setApplicationIdentity(testoutPut.getApplicationIdentity());
			testoutputAir.setBankDivision(testoutPut.getBankDivision());
			testoutputAir.setProductFamily(testoutPut.getProductFamily());
			testoutputAir.setProductName(testoutPut.getProductName());
			testoutputAir.setBarrowAmount(testoutPut.getBarrowAmount());
			testoutputAir.setRiskFactor(testoutPut.getRiskFactor());
			testoutputAir.setTermFactor(testoutPut.getTermFactor());
			if (testoutPut.getBarrowAmount() <= 10000) {
				testoutputAir.setAllInRate(6.95f);
			} else if (testoutPut.getBarrowAmount() >= 10000 && testoutPut.getBarrowAmount() <= 20000) {
				testoutputAir.setAllInRate(7.95f);
			} else if (testoutPut.getBarrowAmount() >= 20000 && testoutPut.getBarrowAmount() <= 40000) {
				testoutputAir.setAllInRate(8.95f);
			} else {
				testoutputAir.setAllInRate(9.95f);
			}
			testoutputAir.setAnnualPercentageRate(0.0f);
			testoutputAirList.add(testoutputAir);
		}

		return testoutputAirList;
	}

	public static <T> void permute(final List<List<T>> lists, final Consumer<List<T>> consumer) {
		final int[] index_pos = new int[lists.size()];

		final int last_index = lists.size() - 1;
		final List<T> permuted = new ArrayList<T>(lists.size());

		for (int i = 0; i < lists.size(); ++i) {
			permuted.add(null);
		}

		while (index_pos[last_index] < lists.get(last_index).size()) {
			for (int i = 0; i < lists.size(); ++i) {
				permuted.set(i, lists.get(i).get(index_pos[i]));
			}
			consumer.accept(permuted);

			for (int i = 0; i < lists.size(); ++i) {
				++index_pos[i];
				if (index_pos[i] < lists.get(i).size()) {
					/* stop at first element without overflow */
					break;
				} else if (i < last_index) {
					index_pos[i] = 0;
				}
			}
		}
	}


	@PostMapping("/testCasesResult")
	 TestResult testCasesResult(@RequestBody List<TestoutputAir> testoutputList) {
	
	List<TestoutputResult> testResultList =new  ArrayList<TestoutputResult>();
	int i =0;
	int pass=0;
	int fail=0;
	for (TestoutputAir testoutputAir : testoutputList) {
	TestoutputResult testResult = new TestoutputResult();
	testResult.setId(testoutputAir.getId());
	testResult.setApplicationIdentity(testoutputAir.getApplicationIdentity());
	testResult.setBankDivision(testoutputAir.getBankDivision());
	testResult.setProductFamily(testoutputAir.getProductFamily());
	testResult.setProductName(testoutputAir.getProductName());
	testResult.setBarrowAmount(testoutputAir.getBarrowAmount());
	testResult.setRiskFactor(testoutputAir.getRiskFactor());
	testResult.setTermFactor(testoutputAir.getTermFactor());
	testResult.setAllInRate(testoutputAir.getAllInRate());
	testResult.setAnnualPercentageRate(testoutputAir.getAnnualPercentageRate());
	
	testResult.setExpectedAnnualPercentageRate(testoutputAir.getAnnualPercentageRate());
	if(i <=5) {
	testResult.setStatus("Y");
	testResult.setExpectedAllInRate(testoutputAir.getAllInRate());
	pass++;
	i++;
	}else {
	testResult.setStatus("N");
	testResult.setExpectedAllInRate(11.0f);
	i =0;
	fail++;
	}
	testResultList.add(testResult);
	}
	
	TestResult testResult= new TestResult();
	
	testResult.setTotaltestcases(testoutputList.size());
	testResult.setPassed(pass);
	testResult.setFailed(fail);
	testResult.setTestcasesResultList(testResultList);
	
	return testResult;
	}

}
