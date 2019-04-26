package UI;

import CodeBuilder.Transpiler;
import Smarty.SmartyLexer;
import Smarty.SmartyParser;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Controller implements Initializable {

    @FXML private TextArea textArea1;
    @FXML private TextArea textArea2;
    @FXML private TextArea textArea3;
    private Stage stage;
    private final FileChooser fileChooser = new FileChooser();
    ParseTree tree;
    SmartyParser parser;
    String fileName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
        fileChooser
                .getExtensionFilters()
                .addAll(
                        //new FileChooser.ExtensionFilter("Text", "*.txt"),
                        new FileChooser.ExtensionFilter("Smarty Contract", "*.sm"));
    }

    public void init(Stage myStage) {
        this.stage = myStage;
        
        File file = new File(System.getProperty("user.dir") + "/src/Smarty/Smarty.g4");
        if (file != null) {
            textArea1.clear();
            readText(file, textArea1);
        }
    }

    @FXML
    public void exit() {
        if (textArea1.getText().isEmpty()) {
            Platform.exit();
            return;
        }

        Alert alert = new Alert(
                Alert.AlertType.CONFIRMATION,
                "Exit without saving?",
                ButtonType.YES,
                ButtonType.NO,
                ButtonType.CANCEL
        );

        alert.setTitle("Confirm");
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            Platform.exit();
        }
        if (alert.getResult() == ButtonType.NO) {
            save();
            Platform.exit();
        }
    }

    @FXML
    private void save() {
        try {
            fileChooser.setTitle("Save As");
            File file = fileChooser.showSaveDialog(stage);

            if (file != null) {
                PrintWriter savedText = new PrintWriter(file);
                BufferedWriter out = new BufferedWriter(savedText);
                out.write(textArea1.getText());
                out.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void openFile() {
        fileChooser.setTitle("Open File");
        File file = fileChooser.showOpenDialog(stage);
        fileName = file.getName().substring(0, file.getName().indexOf("."));
        if (file != null) {
            textArea2.clear();
            readText(file, textArea2);
        }
    }


    // sets the textArea to the text of the opened file
    private void readText(File file, TextArea textArea) {
        String text;

        try (BufferedReader buffReader = new BufferedReader(new FileReader(file))) {
            while ((text = buffReader.readLine()) != null) {
                textArea.appendText(text + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //TODO add confirmation window if text editor has text and wasn't saved

    @FXML
    public void newFile() {
        textArea1.clear();
    }

    @FXML
    public void about() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("About");
        alert.setHeaderText("Smarty. The First Smart Contract Language based on Event-B and Design by Contract.");
        alert.setContentText("https://github.com/KonnerEL/Smarty");
        alert.showAndWait();
    }

    // TODO Add a proper font-size menu && color selection

    @FXML
    public void fontSize(ActionEvent e) {
        String choice = ((CheckMenuItem) e.getSource()).getId();

        switch (choice) {
            case "small":
                if (textArea1.isFocused()) textArea1.setStyle("-fx-font-size: 14px");
                if (textArea2.isFocused()) textArea2.setStyle("-fx-font-size: 14px");
                if (textArea3.isFocused()) textArea3.setStyle("-fx-font-size: 14px");
                break;
            case "default":
                if (textArea1.isFocused()) textArea1.setStyle("-fx-font-size: 22px");
                if (textArea2.isFocused()) textArea2.setStyle("-fx-font-size: 22px");
                if (textArea3.isFocused()) textArea3.setStyle("-fx-font-size: 22px");
                break;
            case "large":
                if (textArea1.isFocused()) textArea1.setStyle("-fx-font-size: 30px");
                if (textArea2.isFocused()) textArea2.setStyle("-fx-font-size: 30px");
                if (textArea3.isFocused()) textArea3.setStyle("-fx-font-size: 30px");
                break;
            default:
                if (textArea1.isFocused()) textArea1.setStyle("-fx-font-size: 22px");
                if (textArea2.isFocused()) textArea2.setStyle("-fx-font-size: 22px");
                if (textArea3.isFocused()) textArea3.setStyle("-fx-font-size: 22px");
                break;
        }
    }
    
     @FXML
    public void fontFace(ActionEvent e) {
        String choice = ((CheckMenuItem) e.getSource()).getId();

        switch (choice) {
            case "Consolas":
                if (textArea1.isFocused()) textArea1.setStyle("-fx-font-family: Consolas");
                if (textArea2.isFocused()) textArea2.setStyle("-fx-font-family: Consolas");
                if (textArea3.isFocused()) textArea3.setStyle("-fx-font-family: Consolas");
                break;
            case "Courier":
                if (textArea1.isFocused()) textArea1.setStyle("-fx-font-family: Courier New");
                if (textArea2.isFocused()) textArea2.setStyle("-fx-font-family: Courier New");
                if (textArea3.isFocused()) textArea3.setStyle("-fx-font-family: Courier New");
                break;
            default:
                if (textArea1.isFocused()) textArea1.setStyle("-fx-font-family: SansSerif");
                if (textArea2.isFocused()) textArea2.setStyle("-fx-font-family: SansSerif");
                if (textArea3.isFocused()) textArea3.setStyle("-fx-font-family: SansSerif");
                break;   
        }
    }
    
    @FXML
    public void Transpile() throws Exception {
        //File f = new File(System.getProperty("user.dir") + "/examples/AccountSystem.sm");
        //File f = new File(args[0]);
        //FileInputStream fis = new FileInputStream(f);
        ANTLRInputStream input = new ANTLRInputStream(textArea2.getText());
        SmartyLexer lexer = new SmartyLexer(input);
        TokenStream tokens = new CommonTokenStream(lexer);
        parser = new SmartyParser(tokens);
        Transpiler tr = new Transpiler();
        parser.addParseListener(tr);
        //parser.contractDefinition();
        tree = parser.contractDefinition();
        tr.buildPactSintax();
        String contract = tr.getProgram();
        System.out.println(contract);
        textArea3.setText(contract);
        textArea3.setEditable(false);
        File pactContract = new File(System.getProperty("user.dir") + "/examples/" + fileName + ".pact");
	FileWriter fileWriter = new FileWriter(pactContract);
	fileWriter.write(contract);
        fileWriter.flush();
	fileWriter.close();
        
    }
    
    @FXML
    public void ShowST() {
        TreeViewer viewr = new TreeViewer(Arrays.asList(parser.getRuleNames()),tree);
        viewr.open();
    }
}