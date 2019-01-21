package hu.simplesoft.dualis.library.web.controller.exception;

public class ControllerExceptionObject {

    String status;

    public ControllerExceptionObject(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
