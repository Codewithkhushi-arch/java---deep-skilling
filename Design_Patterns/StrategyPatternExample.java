interface PaymentStrategy { void pay(int amount); }
class CreditCardPayment implements PaymentStrategy { public void pay(int amount) { System.out.println("Paid " + amount + " via Credit Card"); } }
class PayPalPayment implements PaymentStrategy { public void pay(int amount) { System.out.println("Paid " + amount + " via PayPal"); } }
class PaymentContext {
    private PaymentStrategy strategy;
    public void setStrategy(PaymentStrategy strategy) { this.strategy = strategy; }
    public void executePayment(int amount) { strategy.pay(amount); }
}
public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();
        context.setStrategy(new CreditCardPayment());
        context.executePayment(500);
        context.setStrategy(new PayPalPayment());
        context.executePayment(300);
    }
}

/*
Output:
Paid 500 via Credit Card
Paid 300 via PayPal
*/
