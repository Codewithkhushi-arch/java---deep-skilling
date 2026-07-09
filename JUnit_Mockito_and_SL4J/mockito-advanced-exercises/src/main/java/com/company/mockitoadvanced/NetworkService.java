package com.company.mockitoadvanced;

public class NetworkService {
    private final NetworkClient networkClient;

    public NetworkService(NetworkClient networkClient) {
        this.networkClient = networkClient;
    }

    public String connectToServer() {
        String connectionResult = networkClient.connect();
        return "Connected to " + connectionResult;
    }
}
