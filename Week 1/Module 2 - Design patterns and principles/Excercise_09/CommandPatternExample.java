// Command Design Pattern Example
public class CommandPatternExample {

    // Command Interface
    public interface Action {
        void perform();
    }

    // Concrete Command - TurnOnLightAction
    public static class TurnOnLightAction implements Action {
        private LightBulb lightBulb;

        public TurnOnLightAction(LightBulb lightBulb) {
            this.lightBulb = lightBulb;
        }

        @Override
        public void perform() {
            lightBulb.switchOn();
        }
    }

    // Concrete Command - TurnOffLightAction
    public static class TurnOffLightAction implements Action {
        private LightBulb lightBulb;

        public TurnOffLightAction(LightBulb lightBulb) {
            this.lightBulb = lightBulb;
        }

        @Override
        public void perform() {
            lightBulb.switchOff();
        }
    }

    // Receiver Class
    public static class LightBulb {
        public void switchOn() {
            System.out.println("Light is ON");
        }

        public void switchOff() {
            System.out.println("Light is OFF");
        }
    }

    // Invoker Class
    public static class Controller {
        private Action action;

        public void setAction(Action action) {
            this.action = action;
        }

        public void press() {
            action.perform();
        }
    }

    // Test the Command Implementation
    public static void main(String[] args) {
        LightBulb lightBulb = new LightBulb();
        Action turnOnLight = new TurnOnLightAction(lightBulb);
        Action turnOffLight = new TurnOffLightAction(lightBulb);

        Controller controller = new Controller();

        controller.setAction(turnOnLight);
        controller.press();

        controller.setAction(turnOffLight);
        controller.press();
    }
}
