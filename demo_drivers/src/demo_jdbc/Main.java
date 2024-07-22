package demo_jdbc;


import demo_jdbc.models.DriverMaxPoint;

import demo_jdbc.repositories.QueryRepository;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Conductores con mas puntos");

        TableView<DriverMaxPoint> table = new TableView<>();
        TableColumn<DriverMaxPoint, String> nameColumn = new TableColumn<>("Conductor");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("driverName"));

        TableColumn<DriverMaxPoint, Double> pointsColumn = new TableColumn<>("Puntos");
        pointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));

        table.getColumns().add(nameColumn);
        table.getColumns().add(pointsColumn);

        QueryRepository queryRepository = new QueryRepository();
        var results = queryRepository.getDriversMaxPoints();

        table.getItems().addAll(results);

        VBox vbox = new VBox(table);
        Scene scene = new Scene(vbox, 350, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
		

		
		
		
	


