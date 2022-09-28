package com.example.puntodeventa;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Controller {
    @FXML
    private Label welcomeText;

    @FXML
    private Button Ingresar;
    @FXML
    private TextField usuarioLogin_TextField;
    @FXML
    private PasswordField contrasenaLogin_TextField;
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private void mouseexit(MouseEvent event){
        System.exit(0);
    }

    @FXML
    private void Ingresar(ActionEvent event){

        if (usuarioLogin_TextField.getText().isBlank() == false && contrasenaLogin_TextField.getText().isBlank() == false){
            System.out.println("Intentando iniciar sesion....");
            validarLogin();
        }
        else {
            System.out.println("Por favor ingresa usuario y contrasena");
        }
    }

    private void validarLogin() {
        conexion conectarAhora = new conexion();
        Connection conectarBase = conectarAhora.getConnection();

        String verificarInicio = "SELECT count(1) FROM tb_usuario WHERE usuario = '"+ usuarioLogin_TextField.getText()+"' AND password = '"+contrasenaLogin_TextField.getText()+"'";
        try {
            Statement statement = conectarBase.createStatement();
            ResultSet queryResult = statement.executeQuery(verificarInicio);

            while (queryResult.next()){
                if (queryResult.getInt(1)==1){
                    System.out.println("Bienvenido");
                }
                else {
                    System.out.println("Sesion invalida,Porfavor intente otra vez");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}