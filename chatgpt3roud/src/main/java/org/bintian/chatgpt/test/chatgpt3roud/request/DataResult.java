package org.bintian.chatgpt.test.chatgpt3roud.request;

// Create a data wrapper for the response
public class DataResult {
    private String errorMsg;
    private String content;

    private String status = "success";

    // getter and setter for all fields
    public String getErrorMsg() {
        return errorMsg;
    }
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
