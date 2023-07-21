package org.bintian.chatgpt.test.chatgpt3roud.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.bintian.chatgpt.test.chatgpt3roud.request.HolidayRequest;
import org.bintian.chatgpt.test.chatgpt3roud.request.HolidayResponse;
import org.springframework.stereotype.Component;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class HolidayService {

    private static final String RESOURCE_DIR = "src/main/resources";
    private static final String CSV_FILE_NAME = "holidays.csv";

    public List<HolidayResponse> getNextYearHoliday(String countryCode) throws IOException {
        return getHolidayByCountryCode(countryCode);
    }


    // Generate by chat gpt for all code in this method
    private List<HolidayResponse> getHolidayByCountryCode(String countryCode) throws IOException {
        int nextYear = LocalDate.now().getYear() + 1;
        FileReader fileReader = new FileReader("my_file.csv");
        CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withHeader("CountryCode", "CountryDesc", "HolidayDate", "HolidayName").withIgnoreHeaderCase().withTrim());

        List<CSVRecord> records = csvParser.getRecords();
        List<CSVRecord> collected = records.stream().filter(record -> record.get("CountryCode").equals(countryCode)).collect(Collectors.toList());
        List<HolidayResponse> holidayResponses = collected.stream().map(v -> {
            HolidayResponse response = new HolidayResponse();
            response.setCountryCode(v.get("CountryCode"));
            response.setCountryDesc(v.get("CountryDesc"));
            response.setHolidayDate(v.get("HolidayDate"));
            response.setHolidayName(v.get("HolidayName"));
            return response;
        }).filter(v -> parseDateFroString(v.getHolidayDate()).getYear() > nextYear)
                .collect(Collectors.toList());
        return holidayResponses;
    }

    private LocalDate parseDateFroString(String holidayDate) {
        String[] dateArr = holidayDate.split("-");
        int year = Integer.parseInt(dateArr[0]);
        int month = Integer.parseInt(dateArr[1]);
        int day = Integer.parseInt(dateArr[2]);
        return LocalDate.of(year, month, day);

}


    public void addHoliday(HolidayRequest request) throws IOException {
        String[] holidayArray = {request.getCountryCode(), request.getCountryDesc(), request.getHolidayDate(), request.getHolidayName()};
        File csvFile = new File(RESOURCE_DIR + "/" + CSV_FILE_NAME);
        FileWriter fileWriter = new FileWriter(csvFile);
        CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("CountryCode", "CountryDesc", "HolidayDate", "HolidayName").withIgnoreHeaderCase().withTrim();

        // create CSFFotmat object
        CSVPrinter csvPrinter = new CSVPrinter(fileWriter, csvFormat);
        csvPrinter.print(request);
        fileWriter.close();
    }

}
