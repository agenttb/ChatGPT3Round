package org.bintian.chatgpt.test.chatgpt3roud.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bintian.chatgpt.test.chatgpt3roud.request.DataResult;
import org.bintian.chatgpt.test.chatgpt3roud.request.HolidayRequest;
import org.bintian.chatgpt.test.chatgpt3roud.request.HolidayResponse;
import org.bintian.chatgpt.test.chatgpt3roud.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/holiday")
public class HolidayController {

     @Autowired
     private HolidayService holidayService;
     // Create a restful method for get the next year`s holiday
     @RequestMapping("/nextYear")
     public DataResult getNextYearHoliday(@RequestParam(name="countryCode", defaultValue="US") String countryCode) {
          DataResult dataResult = new DataResult();
          try {
               List<HolidayResponse> responses = holidayService.getNextYearHoliday(countryCode);
               ObjectMapper mapper = new ObjectMapper();
               dataResult.setContent(mapper.writeValueAsString(responses));
          } catch (IOException e) {
               dataResult.setErrorMsg(e.getMessage());
          }
          return dataResult;
     }

     // Create an API take JSON request to add new holiday (support single and bulk)
     @RequestMapping("/add")
     public DataResult addHoliday(@RequestBody HolidayRequest request) {
          DataResult dataResult = new DataResult();
          try {
               holidayService.addHoliday(request);
               dataResult.setStatus("success");
          } catch (IOException e) {
               dataResult.setErrorMsg(e.getMessage());
          }
          return dataResult;
     }
     // Create an API to delete holiday (support single and bulk)
     @RequestMapping("/delete")
     public String deleteHoliday() {
         return "Delete holiday";
     }
     // Create an API to update holiday (support single and bulk)
     @RequestMapping("/update")
     public String updateHoliday() {
         return "Update holiday";
     }
     // Create an API to get holiday by date
     @RequestMapping("/getByDate")
     public String getHolidayByDate() {
         return "Get holiday by date";
     }
     // Create an API to get holiday by month
     @RequestMapping("/getByMonth")
     public String getHolidayByMonth() {
         return "Get holiday by month";
     }
     // Create an API to get holiday by year
     @RequestMapping("/getByYear")
     public String getHolidayByYear() {
         return "Get holiday by year";
     }
     // Create an API to get holiday by country
     @RequestMapping("/getByCountry")
     public String getHolidayByCountry() {
         return "Get holiday by country";
     }
     // Create an API to get holiday by religion
     @RequestMapping("/getByReligion")
     public String getHolidayByReligion() {
         return "Get holiday by religion";
     }
     // Create an API to get holiday by state
     @RequestMapping("/getByState")
     public String getHolidayByState() {
         return "Get holiday by state";
     }
     // Create an API to get holiday by city
     @RequestMapping("/getByCity")
     public String getHolidayByCity() {
         return "Get holiday by city";
     }
     // Create an API to get holiday by company
     @RequestMapping("/getByCompany")
     public String getHolidayByCompany() {
         return "Get holiday by company";
     }
     // Create an API to get holiday by school
     @RequestMapping("/getBySchool")
     public String getHolidayBySchool() {
         return "Get holiday by school";
     }
     // Create an API to get holiday by university
     @RequestMapping("/getByUniversity")
     public String getHolidayByUniversity() {
         return "Get holiday by university";
     }


}
