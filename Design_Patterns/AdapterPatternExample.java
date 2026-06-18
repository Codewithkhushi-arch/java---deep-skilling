interface PaymentProcessor { void processPayment(); }
class GatewayA { void makePayment() { System.out.println("Processing via Gateway A"); } }
class GatewayB { void executePayment() { System.out.println("Processing via Gateway B"); } }
class GatewayAAdapter implements PaymentProcessor {
    private GatewayA gw = new GatewayA();
    public void processPayment() { gw.makePayment(); }
}
class GatewayBAdapter implements PaymentProcessor {
    private GatewayB gw = new GatewayB();
    public void processPayment() { gw.executePayment(); }
}
public class AdapterPatternExample {
    public static void main(String[] args) {
        PaymentProcessor processor = new GatewayAAdapter();
        processor.processPayment();
    }
}

/*
Output:
Processing via Gateway A
*/
