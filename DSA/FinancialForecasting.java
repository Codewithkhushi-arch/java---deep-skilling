public class FinancialForecasting {
    
    // Recursive method to calculate future value
    public static double calculateFutureValue(double presentValue, double rate, int years) {
        // Base Case
        if (years == 0) {
            return presentValue;
        }
        // Recursive step: FV = PV * (1 + rate)^years
        return (1 + rate) * calculateFutureValue(presentValue, rate, years - 1);
    }

    public static void main(String[] args) {
        double pv = 25000.0;
        double rate = 0.06; // 6%
        int trackingYears = 10;
        
        double finalForecast = calculateFutureValue(pv, rate, trackingYears);
        System.out.printf("Forecasted value after %d years: ₹%.2f\n", trackingYears, finalForecast);
    }
}
/*
Output:
Forecasted value after 10 years: ₹44771.19
*/
