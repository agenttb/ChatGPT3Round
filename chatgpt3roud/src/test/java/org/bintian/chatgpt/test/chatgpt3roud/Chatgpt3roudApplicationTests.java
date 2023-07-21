package org.bintian.chatgpt.test.chatgpt3roud;

import org.bintian.chatgpt.test.chatgpt3roud.request.HolidayResponse;
import org.bintian.chatgpt.test.chatgpt3roud.service.HolidayService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
class Chatgpt3roudApplicationTests {

	@Test
	void contextLoads() {
	}

	// create a unit test for HolidayService.getNextYearHoliday method
	@Test
	public void testGetNextYearHoliday() {
		HolidayService holidayService = new HolidayService();
		String countryCode = "US";
		try {
			List<HolidayResponse> usNextYearHolidays = holidayService.getNextYearHoliday(countryCode);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// create a unit test for HolidayService  getHolidayByCountryCode method

	@Test
	public void testIndexOfString() {
		String holiday = "New Year's Day";
		int i = holiday.indexOf(" ");
		System.out.println();
	}
}
