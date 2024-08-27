import java.util.ArrayList;
import java.util.List;

// Observer Design Pattern Example
public class ObserverPatternExample {

    // Subject Interface
    public interface StockMarketSubject {
        void addSubscriber(Subscriber subscriber);
        void removeSubscriber(Subscriber subscriber);
        void notifySubscribers();
    }

    // Concrete Subject
    public static class StockExchange implements StockMarketSubject {
        private List<Subscriber> subscribers = new ArrayList<>();
        private double price;

        public void setPrice(double price) {
            this.price = price;
            notifySubscribers();
        }

        @Override
        public void addSubscriber(Subscriber subscriber) {
            subscribers.add(subscriber);
        }

        @Override
        public void removeSubscriber(Subscriber subscriber) {
            subscribers.remove(subscriber);
        }

        @Override
        public void notifySubscribers() {
            for (Subscriber subscriber : subscribers) {
                subscriber.update(price);
            }
        }
    }

    // Observer Interface
    public interface Subscriber {
        void update(double price);
    }

    // Concrete Observer - Mobile Application
    public static class MobileAppSubscriber implements Subscriber {
        @Override
        public void update(double price) {
            System.out.println("MobileAppSubscriber: Stock price updated to " + price);
        }
    }

    // Concrete Observer - Web Application
    public static class WebAppSubscriber implements Subscriber {
        @Override
        public void update(double price) {
            System.out.println("WebAppSubscriber: Stock price updated to " + price);
        }
    }

    // Test the Observer Implementation
    public static void main(String[] args) {
        StockExchange stockExchange = new StockExchange();
        Subscriber mobileAppSubscriber = new MobileAppSubscriber();
        Subscriber webAppSubscriber = new WebAppSubscriber();

        stockExchange.addSubscriber(mobileAppSubscriber);
        stockExchange.addSubscriber(webAppSubscriber);

        stockExchange.setPrice(100.50);
        stockExchange.setPrice(102.75);
    }
}
