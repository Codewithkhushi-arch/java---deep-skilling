package com.company.mockitobasic;

public interface ExternalApi {
    String getData();
    String getData(String key);
    void saveData(String data);
}
