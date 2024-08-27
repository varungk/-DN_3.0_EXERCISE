public class NotificationDecoratorPattern {

    // Component Interface
    public interface Messenger {
        void deliver(String message);
    }

    // Concrete Component
    public static class EmailMessenger implements Messenger {
        @Override
        public void deliver(String message) {
            System.out.println("Email sent with message: " + message);
        }
    }

    // Decorator Class
    public static abstract class MessengerDecorator implements Messenger {
        protected Messenger messenger;

        public MessengerDecorator(Messenger messenger) {
            this.messenger = messenger;
        }

        @Override
        public void deliver(String message) {
            messenger.deliver(message);
        }
    }

    // Concrete Decorator Class for SMS
    public static class SMSDecorator extends MessengerDecorator {
        public SMSDecorator(Messenger messenger) {
            super(messenger);
        }

        @Override
        public void deliver(String message) {
            super.deliver(message);
            sendSMS(message);
        }

        private void sendSMS(String message) {
            System.out.println("SMS sent with message: " + message);
        }
    }

    // Concrete Decorator Class for Slack
    public static class SlackDecorator extends MessengerDecorator {
        public SlackDecorator(Messenger messenger) {
            super(messenger);
        }

        @Override
        public void deliver(String message) {
            super.deliver(message);
            sendSlackMessage(message);
        }

        private void sendSlackMessage(String message) {
            System.out.println("Slack message sent: " + message);
        }
    }

    // Test the Decorator Implementation
    public static void main(String[] args) {
        Messenger emailMessenger = new EmailMessenger();
        Messenger smsMessenger = new SMSDecorator(emailMessenger);
        Messenger slackMessenger = new SlackDecorator(smsMessenger);

        slackMessenger.deliver("Hello, World!");
    }
}
