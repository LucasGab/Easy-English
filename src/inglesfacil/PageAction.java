package inglesfacil;

import javafx.animation.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class PageAction {
    public static void transitionScene(Parent root, Scene scene, AnchorPane anchorPane) {
        root.translateYProperty().set(scene.getHeight());
        anchorPane.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(),0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(event1 ->{
            //stackpane.getChildren().remove(panel);
        });
        timeline.play();
    }
    public static void backScene(Scene scene, AnchorPane panel) {
        AnchorPane anchorPane = (AnchorPane) scene.getRoot();

        TranslateTransition trans = new TranslateTransition(Duration.seconds(1), panel);
        trans.setFromY(0);
        trans.setToY(-scene.getHeight());
        trans.play();

        trans.setOnFinished(event1 -> {
            anchorPane.getChildren().remove(panel);
        });
    }
}
