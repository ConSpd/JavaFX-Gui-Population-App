package KostasPackage;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Toast{
    public static void message(ObservableList<Country> country,int spot,Stage primaryStage){
        String name = country.get(spot).getName();
        int index = country.get(spot).getIndex();
        int popul = country.get(spot).getPopulation();
        
        Label lbl = new Label(index + " " + name + " " + popul);
        lbl.setTextFill(Color.WHITE);
        
        
        
        Text txt = new Text(country.get(spot).getName()); // Μετράει το μήκος του ονόματος για να δώσει μια πιο κοντινή διάσταση
        double width = txt.getLayoutBounds().getWidth();
        System.out.println(width);
        
        Rectangle rct = new Rectangle(150,150,width+150,50); // Arched Edges
        rct.setArcHeight(30);
        rct.setArcWidth(30);
        
        
        KeyValue rctValue1 = new KeyValue(rct.opacityProperty(),1);
        KeyValue rctValue0 = new KeyValue(rct.opacityProperty(),0);
        
        
        KeyValue lblValue1 = new KeyValue(lbl.opacityProperty(),1);
        KeyValue lblValue0 = new KeyValue(lbl.opacityProperty(),0);
        
        KeyFrame rctFrame = new KeyFrame(Duration.seconds(3),rctValue1,rctValue0);
        KeyFrame lblFrame = new KeyFrame(Duration.seconds(3),lblValue1,lblValue0);
        
        Timeline rctTml = new Timeline();
        Timeline lblTml = new Timeline();
        
        
        rctTml.getKeyFrames().add(rctFrame);
        lblTml.getKeyFrames().add(lblFrame);
        
        rctTml.play();
        lblTml.play();
        
        Popup popup = new Popup();
        popup.setAutoHide(true);
        popup.setAutoFix(true); // Έτσι ώστε να μην εκτυπωθεί εκτός οθόνης
        popup.setHideOnEscape(true); // Ωστε να μην χρειάζεται να περιμένουμε κάθε φορα να κλείσει
        
        
        StackPane root = new StackPane(rct,lbl);
        popup.getContent().add(root);
        
        popup.show(primaryStage);
    }
}
