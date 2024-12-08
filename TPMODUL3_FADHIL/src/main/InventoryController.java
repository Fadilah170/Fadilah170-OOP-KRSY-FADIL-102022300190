package main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class InventoryController {

    @FXML
    private TableView<Album> albumTable;

    @FXML
    private TableColumn<Album, String> albumNameColumn;

    @FXML
    private TableColumn<Album, String> artistColumn;

    @FXML
    private TableColumn<Album, Integer> availableColumn;

    @FXML
    private TableColumn<Album, Integer> totalColumn;

    @FXML
    private TextField albumNameField;

    @FXML
    private TextField artistField;

    @FXML
    private TextField totalField;

    @FXML
    private TextField rentedField;

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button rentButton;

    private final ObservableList<Album> albumList = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        albumNameColumn.setCellValueFactory(new PropertyValueFactory<>("albumName"));
        artistColumn.setCellValueFactory(new PropertyValueFactory<>("artist"));
        availableColumn.setCellValueFactory(new PropertyValueFactory<>("available"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));

        albumTable.setItems(albumList);

        albumTable.setOnMouseClicked(this::onRowSelected);
    }

    @FXML
    private void handleAdd() {
        try {
            String albumName = albumNameField.getText();
            String artist = artistField.getText();
            int total = Integer.parseInt(totalField.getText());
            int rented = Integer.parseInt(rentedField.getText());
            int available = total - rented;

            if (available < 0) {
                showAlert(Alert.AlertType.ERROR, "Invalid Input", "Rented albums cannot exceed total albums.");
                return;
            }

            Album newAlbum = new Album(albumName, artist, total, available, rented);
            albumList.add(newAlbum);

            showAlert(Alert.AlertType.INFORMATION, "Success", "Album added successfully!");
            clearFields();
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please enter valid numbers for total and rented fields.");
        }
    }

    @FXML
    private void handleDelete() {
        Album selectedAlbum = albumTable.getSelectionModel().getSelectedItem();
        if (selectedAlbum != null) {
            albumList.remove(selectedAlbum);
            showAlert(Alert.AlertType.INFORMATION, "Success", "Album deleted successfully!");
        } else {
            showAlert(Alert.AlertType.ERROR, "No Selection", "Please select an album to delete.");
        }
    }

    @FXML
    private void handleUpdate() {
        Album selectedAlbum = albumTable.getSelectionModel().getSelectedItem();
        if (selectedAlbum != null) {
            try {
                String albumName = albumNameField.getText();
                String artist = artistField.getText();
                int total = Integer.parseInt(totalField.getText());
                int rented = Integer.parseInt(rentedField.getText());
                int available = total - rented;

                if (available < 0) {
                    showAlert(Alert.AlertType.ERROR, "Invalid Input", "Rented albums cannot exceed total albums.");
                    return;
                }

                selectedAlbum.setAlbumName(albumName);
                selectedAlbum.setArtist(artist);
                selectedAlbum.setTotal(total);
                selectedAlbum.setAvailable(available);
                selectedAlbum.setRented(rented);

                albumTable.refresh();

                showAlert(Alert.AlertType.INFORMATION, "Success", "Album updated successfully!");
                clearFields();
            } catch (NumberFormatException e) {
                showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please enter valid numbers for total and rented fields.");
            }
        } else {
            showAlert(Alert.AlertType.ERROR, "No Selection", "Please select an album to update.");
        }
    }

    @FXML
    private void handleRent() {
        Album selectedAlbum = albumTable.getSelectionModel().getSelectedItem();
        if (selectedAlbum != null) {
            if (selectedAlbum.getAvailable() > 0) {
                selectedAlbum.setAvailable(selectedAlbum.getAvailable() - 1);
                selectedAlbum.setRented(selectedAlbum.getRented() + 1);
                albumTable.refresh();
                showAlert(Alert.AlertType.INFORMATION, "Success", "Album rented successfully!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Unavailable", "No more copies available for rent.");
            }
        } else {
            showAlert(Alert.AlertType.ERROR, "No Selection", "Please select an album to rent.");
        }
    }

    private void onRowSelected(MouseEvent event) {
        Album selectedAlbum = albumTable.getSelectionModel().getSelectedItem();
        if (selectedAlbum != null) {
            albumNameField.setText(selectedAlbum.getAlbumName());
            artistField.setText(selectedAlbum.getArtist());
            totalField.setText(String.valueOf(selectedAlbum.getTotal()));
            rentedField.setText(String.valueOf(selectedAlbum.getRented()));
        }
    }

    private void clearFields() {
        albumNameField.clear();
        artistField.clear();
        totalField.clear();
        rentedField.clear();
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
