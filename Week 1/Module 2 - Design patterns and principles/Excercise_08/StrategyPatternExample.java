// Strategy Design Pattern Example
public class StrategyPatternExample {

    // Strategy Interface
    public interface PaymentMethod {
        void processPayment(String amount);
    }

    // Concrete Strategy - Credit Card Payment
    public static class CreditCardMethod implements PaymentMethod {
        @Override
        public void processPayment(String amount) {
            System.out.println("Processing payment of " + amount + " with Credit Card.");
        }
    }

    // Concrete Strategy - PayPal Payment
    public static class PayPalMethod implements PaymentMethod {
        @Override
        public void processPayment(String amount) {
            System.out.println("Processing payment of " + amount + " with PayPal.");
        }
    }

    // Context Class
    public static class PaymentProcessor {
        private PaymentMethod paymentMethod;

        public void setPaymentMethod(PaymentMethod paymentMethod) {
            this.paymentMethod = paymentMethod;
        }

        public void executePayment(String amount) {
            paymentMethod.processPayment(amount);
        }
    }

    // Test the Strategy Implementation
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        paymentProcessor.setPaymentMethod(new CreditCardMethod());
        paymentProcessor.executePayment("100 USD");

        paymentProcessor.setPaymentMethod(new PayPalMethod());
        paymentProcessor.executePayment("200 USD");
    }
}
