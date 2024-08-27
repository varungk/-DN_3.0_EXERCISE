class InvestmentProjection {

    public static double computeFutureWorth(double initialAmount, double interestRate, int duration) {
        if (duration == 0) {
            return initialAmount;
        }
        return (1 + interestRate) * computeFutureWorth(initialAmount, interestRate, duration - 1);
    }

    public static void main(String[] args) {
        double initialAmount = 1000;
        double interestRate = 0.05;
        int duration = 10;

        double futureWorth = computeFutureWorth(initialAmount, interestRate, duration);
        System.out.println("Future Worth after " + duration + " periods: " + futureWorth);
    }
}
