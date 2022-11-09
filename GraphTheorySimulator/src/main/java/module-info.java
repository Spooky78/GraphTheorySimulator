module com.example.graphtheorysimulator {
  requires javafx.controls;
  requires javafx.fxml;


  opens com.example.graphtheorysimulator to javafx.fxml;
  exports com.example.graphtheorysimulator;
}