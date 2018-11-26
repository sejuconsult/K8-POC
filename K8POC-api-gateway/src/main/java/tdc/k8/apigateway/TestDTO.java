package tdc.k8.apigateway;

public class TestDTO {

    private String testEnv;

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
