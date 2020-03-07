package view;

import java.net.URL;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;


public class PrincipalController implements Initializable {
    
    //decimal
    //final = variável para constante
    private final char ds = new DecimalFormatSymbols(Locale.getDefault(Locale.Category.FORMAT)).getDecimalSeparator();
    private final NumberFormat nf = NumberFormat.getInstance(Locale.getDefault());
    
    @FXML
    private Label lblRes;
    
    @FXML
    private TextField txtfld;
    
    @FXML
    private TextField txtfld2;
   
    @FXML
    private Button btnSomar;
    
    @FXML
    private Button btnSubtrair;
    
    @FXML
    private Button btnDividir;
    
    @FXML
    private Button btnMultiplicar;
    
    @FXML
    private Button btnExit;
    
    @FXML
    private Button btnClear;
    
    @FXML
    private void btnSomarClick (ActionEvent event) {
        try {
            double valor1 = nf.parse(txtfld.getText()).doubleValue();
            double valor2 = nf.parse(txtfld2.getText()).doubleValue();
            lblRes.setText(nf.format(valor1 + valor2));
        } catch (ParseException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnSubtrairClick (ActionEvent event) {
        try {
            double valor1 = nf.parse(txtfld.getText()).doubleValue();
            double valor2 = nf.parse(txtfld2.getText()).doubleValue();
            lblRes.setText(nf.format(valor1 - valor2));
        } catch (ParseException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void btnDividirClick (ActionEvent event) {
        try {
            double valor1 = nf.parse(txtfld.getText()).doubleValue();
            double valor2 = nf.parse(txtfld2.getText()).doubleValue();
            lblRes.setText(nf.format(valor1 / valor2));
        } catch (ParseException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void btnMultiplicarClick (ActionEvent event) {
        try {
            double valor1 = nf.parse(txtfld.getText()).doubleValue();
            double valor2 = nf.parse(txtfld2.getText()).doubleValue();
            lblRes.setText(nf.format(valor1 * valor2));
        } catch (ParseException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
 
    private void HabiliteBotoes() {
        btnSomar.setDisable(txtfld.getText().isEmpty() || txtfld2.getText().isEmpty());
        btnSubtrair.disableProperty().set(btnSomar.isDisable());
        btnDividir.disableProperty().set(btnSomar.isDisable());
        btnMultiplicar.disableProperty().set(btnSomar.isDisable());
    }
    
    @FXML
    private void btnExitClick (ActionEvent event) {
        System.exit(0);
    }
    
    @FXML
    private void btnClearClick (ActionEvent event){
        txtfld.clear();
        txtfld2.clear();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        txtfld.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (!newValue.matches("(\\-)?\\d*(\\" + ds + "\\d*)?")
                    && !newValue.isEmpty()) {
                        txtfld.setText(oldValue);
                    }
                    HabiliteBotoes();
                });

        txtfld2.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (!newValue.matches("(\\-)?\\d*(\\" + ds + "\\d*)?")
                    && !newValue.isEmpty()) {
                        txtfld2.setText(oldValue);
                    }
                    HabiliteBotoes();
                });

    }

}


    
