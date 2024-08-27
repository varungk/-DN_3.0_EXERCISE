public class ComputerBuilderPattern {

    // Product Class
    public static class PC {
        private String processor;
        private String memory;
        private String storageDrive;
        private String graphicsCard;
        private String powerUnit;
        private String mainboard;

        private PC(Builder builder) {
            this.processor = builder.processor;
            this.memory = builder.memory;
            this.storageDrive = builder.storageDrive;
            this.graphicsCard = builder.graphicsCard;
            this.powerUnit = builder.powerUnit;
            this.mainboard = builder.mainboard;
        }

        // Static nested Builder class
        public static class Builder {
            private String processor;
            private String memory;
            private String storageDrive;
            private String graphicsCard;
            private String powerUnit;
            private String mainboard;

            public Builder setProcessor(String processor) {
                this.processor = processor;
                return this;
            }

            public Builder setMemory(String memory) {
                this.memory = memory;
                return this;
            }

            public Builder setStorageDrive(String storageDrive) {
                this.storageDrive = storageDrive;
                return this;
            }

            public Builder setGraphicsCard(String graphicsCard) {
                this.graphicsCard = graphicsCard;
                return this;
            }

            public Builder setPowerUnit(String powerUnit) {
                this.powerUnit = powerUnit;
                return this;
            }

            public Builder setMainboard(String mainboard) {
                this.mainboard = mainboard;
                return this;
            }

            public PC create() {
                return new PC(this);
            }
        }

        @Override
        public String toString() {
            return "PC [Processor=" + processor + ", Memory=" + memory + ", StorageDrive=" + storageDrive + ", GraphicsCard=" + graphicsCard + ", PowerUnit="
                    + powerUnit + ", Mainboard=" + mainboard + "]";
        }
    }

    // Test the Builder Implementation
    public static void main(String[] args) {
        PC gamingPC = new PC.Builder()
                .setProcessor("AMD Ryzen 9")
                .setMemory("32GB")
                .setStorageDrive("2TB SSD")
                .setGraphicsCard("AMD Radeon RX 6800")
                .setPowerUnit("850W")
                .setMainboard("MSI MAG")
                .create();

        PC officePC = new PC.Builder()
                .setProcessor("Intel i7")
                .setMemory("16GB")
                .setStorageDrive("1TB SSD")
                .create();

        System.out.println("Gaming PC: " + gamingPC);
        System.out.println("Office PC: " + officePC);
    }
}
