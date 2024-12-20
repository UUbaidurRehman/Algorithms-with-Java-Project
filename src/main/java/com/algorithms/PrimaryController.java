package com.algorithms;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.Parent;


import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javafx.stage.Stage;

// public class PrimaryController {
    
//     @FXML
//     private void switchToSecondary() throws IOException {
//         App.setRoot("secondary");
//     }
// }

public class PrimaryController {

    @FXML
    private TextField inputField;  // To input numbers
    @FXML
    private ComboBox<String> algorithmComboBox;  // To select sorting algorithm
    @FXML
    private Button sortButton;  // Button to trigger sorting
    @FXML
    private TextArea resultArea;  // To display sorted results

    public void initialize() {
        algorithmComboBox.getItems().addAll("Bubble Sort", "Merge Sort", "Quick Sort", "Selection Sort", "Insertion Sort");
    }

    @FXML
    public void sortNumbers(ActionEvent event) {
        try {
            // Get input and convert it to a list of integers
            String input = inputField.getText();
            List<Integer> numbers = Arrays.stream(input.split(","))
                                          .map(String::trim)
                                          .map(Integer::parseInt)
                                          .collect(Collectors.toList());

            // Get selected sorting algorithm
            String selectedAlgorithm = algorithmComboBox.getValue();

            // Sort based on the selected algorithm
            switch (selectedAlgorithm) {
                case "Bubble Sort":
                    SortingAlgorithms.bubbleSort(numbers);
                    break;
                case "Merge Sort":
                    SortingAlgorithms.mergeSort(numbers);
                    break;
                case "Quick Sort":
                    SortingAlgorithms.quickSort(numbers, 0, numbers.size() - 1);
                    break;
                case "Selection Sort":
                    SortingAlgorithms.selectionSort(numbers);
                    break;
                case "Insertion Sort":
                    SortingAlgorithms.insertionSort(numbers);
                    break;
            }

            // Display sorted result
            resultArea.setText(numbers.toString());
        } catch (Exception e) {
            showError("Invalid input! Please enter numbers separated by commas.");
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Input Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
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
