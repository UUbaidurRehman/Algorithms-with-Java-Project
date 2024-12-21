package com.algorithms;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import javafx.scene.Node;



public class BinaryController {

    @FXML
    private TextField inputField;  // To input node value
    @FXML
    private Button insertButton;  // Button for insertion
    @FXML
    private Button deleteButton;  // Button for deletion
    @FXML
    private Button inorderButton;  // Button for inorder traversal
    @FXML
    private Button preorderButton;  // Button for preorder traversal
    @FXML
    private Button postorderButton;  // Button for postorder traversal
    @FXML
    private TextArea resultArea;  // To display results

    private BinarySearchTree bst;

    public void initialize() {
        bst = new BinarySearchTree();
    }

    // @FXML
    // public void insertNode(ActionEvent event) {
    //     try {
    //         int value = Integer.parseInt(inputField.getText());
    //         bst.insert(value);
    //         resultArea.setText("Node inserted: " + value);
    //     } catch (NumberFormatException e) {
    //         showError("Invalid input! Please enter a valid integer.");
    //     }
    // }

    // @FXML
    // public void deleteNode(ActionEvent event) {
    //     try {
    //         int value = Integer.parseInt(inputField.getText());
    //         bst.delete(value);
    //         resultArea.setText("Node deleted: " + value);
    //     } catch (NumberFormatException e) {
    //         showError("Invalid input! Please enter a valid integer.");
    //     }
    // }

    // @FXML
    // public void inorderTraversal(ActionEvent event) {
    //     bst.inorder();
    //     resultArea.setText("Inorder Traversal: " + bst);
    // }

    // @FXML
    // public void preorderTraversal(ActionEvent event) {
    //     bst.preorder();
    //     resultArea.setText("Preorder Traversal: " + bst);
    // }

    // @FXML
    // public void postorderTraversal(ActionEvent event) {
    //     bst.postorder();
    //     resultArea.setText("Postorder Traversal: " + bst);
    // }

    private void showError(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Input Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
        public void goBackToPrimary(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("primary.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!



    @FXML
    public void insertNode(ActionEvent event) {
        try {
            int value = Integer.parseInt(inputField.getText());
            bst.insert(value);
            resultArea.setText("Node inserted: " + value + "\nTree: " + bst.inorder());
        } catch (NumberFormatException e) {
            showError("Invalid input! Please enter a valid integer.");
        } catch (IllegalArgumentException e) {
            showError(e.getMessage());
        }
    }

    @FXML
    public void deleteNode(ActionEvent event) {
        try {
            int value = Integer.parseInt(inputField.getText());
            bst.delete(value);
            resultArea.setText("Node deleted: " + value + "\nTree: " + bst.inorder());
        } catch (NumberFormatException e) {
            showError("Invalid input! Please enter a valid integer.");
        } catch (IllegalArgumentException e) {
            showError(e.getMessage());
        }
    }

    @FXML
    public void inorderTraversal(ActionEvent event) {
        resultArea.setText("Inorder Traversal: " + bst.inorder());
    }

    @FXML
    public void preorderTraversal(ActionEvent event) {
        resultArea.setText("Preorder Traversal: " + bst.preorder());
    }

    @FXML
    public void postorderTraversal(ActionEvent event) {
        resultArea.setText("Postorder Traversal: " + bst.postorder());
    }


}
