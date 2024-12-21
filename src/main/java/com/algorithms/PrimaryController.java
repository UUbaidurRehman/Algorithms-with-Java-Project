package com.algorithms;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.Parent;


import javafx.scene.Scene;
import javafx.stage.Stage;

// public class PrimaryController {
    
//     @FXML
//     private void switchToSecondary() throws IOException {
//         App.setRoot("secondary");
//     }
// }

import javafx.scene.Node;

public class PrimaryController {
    // private Stage stage;

    @FXML
    private void openSortingScreen(javafx.event.ActionEvent event) throws Exception {
        switchScene("Sorting.fxml", event);
    }

    @FXML
    private void openTreeScreen(javafx.event.ActionEvent event) throws Exception {
        switchScene("Tree.fxml", event);
    }

    private void switchScene(String fxml, javafx.event.ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    
}











// ---------------------------------------
// package com.algorithms;

// import javafx.fxml.FXML;
// import javafx.scene.control.ComboBox;
// import javafx.scene.control.TextArea;
// import javafx.scene.control.TextField;
// import javafx.scene.control.Button;

// public class PrimaryController {
    
//     @FXML
//     private TextField inputField;
//     @FXML
//     private ComboBox<String> algorithmComboBox;
//     @FXML
//     private TextArea resultArea;
//     @FXML
//     private Button sortButton;
    
//     @FXML
//     private void initialize() {
//         // Initialize ComboBox with sorting algorithms
//         algorithmComboBox.getItems().addAll("Bubble Sort", "Merge Sort", "Quick Sort", "Insertion Sort", "Selection Sort");
//     }

//     @FXML
//     private void sortNumbers() {
//         String input = inputField.getText();
//         String[] inputArray = input.split(",");
//         int[] numbers = new int[inputArray.length];
        
//         // Convert string input to integer array
//         try {
//             for (int i = 0; i < inputArray.length; i++) {
//                 numbers[i] = Integer.parseInt(inputArray[i].trim());
//             }
//         } catch (NumberFormatException e) {
//             resultArea.setText("Invalid input. Please enter numbers separated by commas.");
//             return;
//         }
        
//         String selectedAlgorithm = algorithmComboBox.getValue();
        
//         // Apply the selected sorting algorithm
//         if (selectedAlgorithm != null) {
//             switch (selectedAlgorithm) {
//                 case "Bubble Sort":
//                     SortingAlgorithms.bubbleSort(numbers);
//                     break;
//                 case "Merge Sort":
//                     SortingAlgorithms.mergeSort(numbers);
//                     // mergeSort(numbers, 0, numbers.length - 1);
//                     break;
//                 case "Quick Sort":
//                     SortingAlgorithms.quickSort(numbers, 0, numbers.length - 1);
//                     break;
//                 case "Insertion Sort":
//                     SortingAlgorithms.insertionSort(numbers);
//                     break;
//                 case "Selection Sort":
//                     SortingAlgorithms.selectionSort(numbers);
//                     break;
//                 default:
//                     resultArea.setText("Select a sorting algorithm.");
//                     return;
//             }
//             // Display sorted result
//             resultArea.setText("Sorted numbers: " + arrayToString(numbers));
//         } else {
//             resultArea.setText("Select a sorting algorithm.");
//         }
//     }
    
//     // Sorting algorithms methods here (e.g., bubbleSort, mergeSort, quickSort, etc.)

//     @FXML
//     private void switchToSecondary() {
//         // Switch to secondary view (e.g., load Secondary.fxml)
//     }
    
//     private String arrayToString(int[] array) {
//         StringBuilder sb = new StringBuilder();
//         for (int num : array) {
//             sb.append(num).append(" ");
//         }
//         return sb.toString();
//     }
// }
