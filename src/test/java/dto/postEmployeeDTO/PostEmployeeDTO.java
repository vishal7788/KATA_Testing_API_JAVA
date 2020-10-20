package dto.postEmployeeDTO;

public class PostEmployeeDTO {
    private String status;
    private PostEmployeeDataDTO data;

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

    public PostEmployeeDataDTO getData() {
        return data;
    }

    public void setData(PostEmployeeDataDTO data) {
        this.data = data;
    }
}
