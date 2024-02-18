import controllers.AnimalController;
import repositories.InMemoryAnimalRepository;
import views.OutputTextRu;
import views.ViewByConsole;

public class MainApp {
    public static void main(String[] args) {
        AnimalController controller = new AnimalController(
                new InMemoryAnimalRepository(), new ViewByConsole(), new OutputTextRu());
        controller.start();
    }
}
