package ac.il.haifa.cs.sweng.HelloTestFX;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.control.LabeledMatchers;
import org.testfx.matcher.control.TextInputControlMatchers;

@ExtendWith(ApplicationExtension.class)
public class AppTest {

  private static Parent loadFXML(String fxml) throws IOException {
    var loader = new FXMLLoader(App.class.getResource("primary.fxml"));
    return loader.load();
  }

  @Start
  public void start(Stage stage) throws IOException{
    var scene = new Scene(loadFXML("primary"), 640,480);
    stage.setScene(scene);
    stage.show();
//    String[] args = new String[3];
//    newApp.main(args);
  }

  @Test
  void test_label_is_empty(FxRobot robot){
    FxAssert.verifyThat("#textField", TextInputControlMatchers.hasText(""));
  }

  @Test
  void test_button_test(FxRobot robot){
    FxAssert.verifyThat(".button", LabeledMatchers.hasText("Say Hello"));
  }

  @Test
  void test_button_click(FxRobot robot){
    robot.clickOn(".button");

    FxAssert.verifyThat("#textField", TextInputControlMatchers.hasText("Hello World"));
  }
}
