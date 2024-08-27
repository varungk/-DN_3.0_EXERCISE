// Dependency Injection Design Pattern Example
public class DependencyInjectionExample {

    // Repository Interface
    public interface UserRepository {
        String retrieveUserById(String id);
    }

    // Concrete Repository
    public static class UserRepositoryImpl implements UserRepository {
        @Override
        public String retrieveUserById(String id) {
            // In a real application, this would query a database
            return "User information for ID: " + id;
        }
    }

    // Service Class
    public static class UserService {
        private UserRepository userRepository;

        public UserService(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        public void displayUserDetails(String id) {
            System.out.println(userRepository.retrieveUserById(id));
        }
    }

    // Test the Dependency Injection Implementation
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepositoryImpl();
        UserService userService = new UserService(userRepository);
        userService.displayUserDetails("12345");
    }
}
