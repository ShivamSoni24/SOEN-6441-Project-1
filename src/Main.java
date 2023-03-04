import controller.UserController;
import repository.UserRepoInterface;
import repository.UserRepository;
import service.UserService;
import service.UserSvcInterface;

public class Main {
    public static void main(String[] args) {
        UserRepoInterface userRepo = new UserRepository();
        UserSvcInterface userSvc = new UserService(userRepo);
        UserController userController = new UserController(userSvc);
    }
}