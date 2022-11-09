package KostasPackage;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{
    
    ObservableList<Country> country;
    
    public static void main(String args[]){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("World Population App");
        
        TableColumn<Country,Integer> indexColumn = new TableColumn<>("Index");
        indexColumn.setCellValueFactory(new PropertyValueFactory<>("Index"));
        
        TableColumn<Country,String> variantColumn = new TableColumn<>("Variant");
        variantColumn.setCellValueFactory(new PropertyValueFactory<>("Variant"));
        
        TableColumn<Country,String> countryColumn = new TableColumn<>("Country");
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        
        TableColumn<Country,Integer> notesColumn = new TableColumn<>("Notes");
        notesColumn.setCellValueFactory(new PropertyValueFactory<>("Notes"));
        
        TableColumn<Country,Integer> countryCodeColumn = new TableColumn<>("Country Code");
        countryCodeColumn.setCellValueFactory(new PropertyValueFactory<>("Code"));
        
        TableColumn<Country,String> typeColumn = new TableColumn<>("Type");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("Type"));
        
        TableColumn<Country,Integer> parentCodeColumn = new TableColumn<>("Parent Code");
        parentCodeColumn.setCellValueFactory(new PropertyValueFactory<>("ParentCode"));
        
        TableColumn<Country,Integer> populationColumn = new TableColumn<>("Population");
        populationColumn.setCellValueFactory(new PropertyValueFactory<>("Population"));
        
        country = excelReader.Process();
        
        TableView table = new TableView<>();
        table.setItems(country);
        table.getColumns().addAll(indexColumn,variantColumn,countryColumn,notesColumn,countryCodeColumn,typeColumn,parentCodeColumn,populationColumn);
        
        Button btn1 = new Button("Chart");
        btn1.setMinSize(70, 30);
        Button btn2 = new Button("Exit");
        btn2.setMinSize(70, 30);
        btn2.setOnAction(event-> primaryStage.close());
        btn1.setOnAction(event->Graph.window(country,primaryStage));
        
        
        table.setOnMouseClicked((MouseEvent event)->{
            if(event.getClickCount()>1){
                int index = table.getSelectionModel().getSelectedIndex(); // Διαλέγει το που πάτησε
                Toast.message(country, index, primaryStage);
            }
        });
        
        
        HBox hbox = new HBox(10);        
        hbox.getChildren().addAll(btn1,btn2);
        hbox.setAlignment(Pos.CENTER);
        hbox.setMinHeight(20);
        
        VBox vbox = new VBox(10); 
        vbox.getChildren().addAll(table);
        
        BorderPane root = new BorderPane();
        root.setTop(vbox);
        root.setBottom(hbox);
        
        Scene scene = new Scene(root,855,500);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
};