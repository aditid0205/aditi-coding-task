package org.example.pojo;

@SuppressWarnings("unused")
public class LogEntry {

    private String ipAddress;
    private String timeStamp;
    private String httpMethod;
    private String url;
    private String statusCode;

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return "LogEntry{" +
                "ipAddress='" + ipAddress + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", httpMethod='" + httpMethod + '\'' +
                ", url='" + url + '\'' +
                ", statusCode='" + statusCode + '\'' +
                '}';
    }
}
