package com.company.mockitobasic;

public class MyService {
    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }

    public String fetchDataWithKey(String key) {
        return externalApi.getData(key);
    }

    public void updateData(String data) {
        externalApi.saveData(data);
    }
}
