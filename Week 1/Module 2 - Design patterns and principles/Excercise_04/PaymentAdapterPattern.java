public class PaymentAdapterPattern {

    // Target Interface
    public interface PaymentService {
        void handlePayment(String amount);
    }

    // Adaptee Class 1
    public static class PaymentGatewayA {
        public void executePayment(String amount) {
            System.out.println("Payment of " + amount + " processed with PaymentGatewayA.");
        }
    }

    // Adaptee Class 2
    public static class PaymentGatewayB {
        public void process(String amount) {
            System.out.println("Payment of " + amount + " processed with PaymentGatewayB.");
        }
    }

    // Adapter Class for PaymentGatewayA
    public static class PaymentGatewayAAdapter implements PaymentService {
        private PaymentGatewayA gatewayA;

        public PaymentGatewayAAdapter(PaymentGatewayA gatewayA) {
            this.gatewayA = gatewayA;
        }

        @Override
        public void handlePayment(String amount) {
            gatewayA.executePayment(amount);
        }
    }

    // Adapter Class for PaymentGatewayB
    public static class PaymentGatewayBAdapter implements PaymentService {
        private PaymentGatewayB gatewayB;

        public PaymentGatewayBAdapter(PaymentGatewayB gatewayB) {
            this.gatewayB = gatewayB;
        }

        @Override
        public void handlePayment(String amount) {
            gatewayB.process(amount);
        }
    }

    // Test the Adapter Implementation
    public static void main(String[] args) {
        PaymentService gatewayAService = new PaymentGatewayAAdapter(new PaymentGatewayA());
        gatewayAService.handlePayment("150 Dollars");

        PaymentService gatewayBService = new PaymentGatewayBAdapter(new PaymentGatewayB());
        gatewayBService.handlePayment("250 Dollars");
    }
}
