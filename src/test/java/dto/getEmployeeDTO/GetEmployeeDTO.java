package dto.getEmployeeDTO;

public class GetEmployeeDTO {
    private String status;
    private GetEmployeeDataDTO data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public GetEmployeeDataDTO getData() {
        return data;
    }

    public void setData(GetEmployeeDataDTO data) {
        this.data = data;
    }
}
