package dto.putEmployeeDTO;

public class PutEmployeeDTO {
    private String status;
    private PutEmployeeDataDTO data;
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PutEmployeeDataDTO getData() {
        return data;
    }

    public void setData(PutEmployeeDataDTO data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
