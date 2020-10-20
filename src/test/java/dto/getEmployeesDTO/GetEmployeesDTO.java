package dto.getEmployeesDTO;

import dto.getEmployeeDTO.GetEmployeeDataDTO;

import java.util.ArrayList;

public class GetEmployeesDTO {
    private String status;
    private ArrayList<GetEmployeeDataDTO> data;

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

    public ArrayList<GetEmployeeDataDTO> getData() {
        return data;
    }

    public void setData(ArrayList<GetEmployeeDataDTO> data) {
        this.data = data;
    }
}
