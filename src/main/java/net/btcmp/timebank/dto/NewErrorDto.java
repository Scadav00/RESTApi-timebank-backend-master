package net.btcmp.timebank.dto;

public class NewErrorDto {

    private int status;
    private String errorMessage;

    public NewErrorDto(int status, String errorMessage) {
        this.status = status;
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
