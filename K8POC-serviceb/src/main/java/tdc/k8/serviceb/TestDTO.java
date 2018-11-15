package tdc.k8.serviceb;

public class TestDTO {

    private String testEnv;

    public TestDTO() {
    }

    public TestDTO(String testEnv) {
        this.testEnv = testEnv;
    }

    public String getTestEnv() {
        return testEnv;
    }

    public void setTestEnv(String testEnv) {
        this.testEnv = testEnv;
    }
}
