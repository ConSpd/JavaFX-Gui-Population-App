package KostasPackage;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author conspd
 */
public class Graph {

    int i=0;
    int j=0;    
    
    public static void window(ObservableList<Country> country,Stage primaryStage) {
        int lastYear = country.get(5).getLastYear(); // Τυχαίο Country απλώς για να πάρουμε την τελική χρονιά μέτρησης
        
        
        Stage secondStage = new Stage();
        secondStage.setTitle("World Population App - Line Chart");
        ComboBox cBox = new ComboBox<String>();
        cBox.setPromptText("Select Country");
        for(int i=0;i<country.size();i++)
            cBox.getItems().add(country.get(i).getName());
        
        
        Button btn4 = new Button("Close");
        

        NumberAxis xAxis = new NumberAxis(1950,lastYear,1);
        xAxis.setTickLabelRotation(270); // Ώστε να εμφανιστούν οι χρονίες κατακόρυφα
        xAxis.setLabel("Year");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Population");
        LineChart chart = new LineChart(xAxis, yAxis);
        
        

        HBox hbox = new HBox(10);
        hbox.getChildren().addAll(cBox, btn4);
        hbox.setAlignment(Pos.CENTER);

        btn4.setOnAction(event -> secondStage.close());
        
        cBox.setOnAction(e-> {
            String str = (String) cBox.getValue();
            XYChart.Series dSeries = new XYChart.Series();
            for(int i=0;i<country.size();i++){
                if(str.equals(country.get(i).getName())){
                    dSeries.setName(country.get(i).getName());
                    
                    for(int j=0;j<country.get(i).getDBSize();j++)
                        dSeries.getData().add(new XYChart.Data(j+1950,country.get(i).getDBPopulation(j+1950)));
                    
                    break;
                }
            }
            chart.getData().add(dSeries);             
        });

        BorderPane root = new BorderPane();
        root.setBottom(hbox);
        root.setCenter(chart);
        Scene scene = new Scene(root,1250,600);
        
        secondStage.initOwner(primaryStage);
        secondStage.initModality(Modality.WINDOW_MODAL);
        secondStage.setResizable(false);
        secondStage.setScene(scene);
        secondStage.showAndWait();
    }
}
