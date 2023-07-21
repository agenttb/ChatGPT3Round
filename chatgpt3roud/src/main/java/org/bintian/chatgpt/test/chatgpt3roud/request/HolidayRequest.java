package org.bintian.chatgpt.test.chatgpt3roud.request;

public class HolidayRequest {
    private String countryCode;
    private String countryDesc;
    private String holidayDate;
    private String holidayName;

    // create getter and setter for all fields
    public String getCountryCode() {
        return countryCode;
    }
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryDesc() {
        return countryDesc;
    }
    public void setCountryDesc(String countryDesc) {
        this.countryDesc = countryDesc;
    }

    public String getHolidayDate() {
        return holidayDate;
    }
    public void setHolidayDate(String holidayDate) {
        this.holidayDate = holidayDate;
    }

    public String getHolidayName() {
        return holidayName;
    }
    public void setHolidayName(String holidayName) {
        this.holidayName = holidayName;
    }
}
