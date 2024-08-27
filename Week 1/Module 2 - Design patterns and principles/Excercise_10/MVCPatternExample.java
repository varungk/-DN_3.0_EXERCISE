// MVC Design Pattern Example
public class MVCPatternExample {

    // Model Class
    public static class Learner {
        private String name;
        private String identifier;
        private String gradeLevel;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIdentifier() {
            return identifier;
        }

        public void setIdentifier(String identifier) {
            this.identifier = identifier;
        }

        public String getGradeLevel() {
            return gradeLevel;
        }

        public void setGradeLevel(String gradeLevel) {
            this.gradeLevel = gradeLevel;
        }
    }

    // View Class
    public static class LearnerView {
        public void showLearnerDetails(String learnerName, String learnerId, String learnerGrade) {
            System.out.println("Learner Details:");
            System.out.println("Name: " + learnerName);
            System.out.println("ID: " + learnerId);
            System.out.println("Grade: " + learnerGrade);
        }
    }

    // Controller Class
    public static class LearnerController {
        private Learner model;
        private LearnerView view;

        public LearnerController(Learner model, LearnerView view) {
            this.model = model;
            this.view = view;
        }

        public void setLearnerName(String name) {
            model.setName(name);
        }

        public String getLearnerName() {
            return model.getName();
        }

        public void setLearnerId(String id) {
            model.setIdentifier(id);
        }

        public String getLearnerId() {
            return model.getIdentifier();
        }

        public void setLearnerGrade(String grade) {
            model.setGradeLevel(grade);
        }

        public String getLearnerGrade() {
            return model.getGradeLevel();
        }

        public void refreshView() {
            view.showLearnerDetails(model.getName(), model.getIdentifier(), model.getGradeLevel());
        }
    }

    // Test the MVC Implementation
    public static void main(String[] args) {
        Learner learner = new Learner();
        learner.setName("John Doe");
        learner.setIdentifier("12345");
        learner.setGradeLevel("A");

        LearnerView view = new LearnerView();

        LearnerController controller = new LearnerController(learner, view);
        controller.refreshView();

        controller.setLearnerName("Jane Doe");
        controller.refreshView();
    }
}
