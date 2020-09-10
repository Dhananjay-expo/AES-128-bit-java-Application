/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aes.pkg128.bit;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.imageio.ImageIO;   

/**
 * 
 * @author djay1
 */


public class Aes128Bit extends Application {
    

    private Scene scene1, scene2;
    @Override
    public void start(Stage primaryStage)throws Exception{
        
        Label encrypt = new Label();  
        encrypt.setText("For Encryption "); 
        File file =new File("D://personal");
        if(!file.exists()){

            file.mkdir();
            if(!file.exists() ){
                file.getParentFile().mkdir();
                file.createNewFile();
            }
        }
        Label succes = new Label();
        Label path = new Label("Give path of file in box");
        TextField image = new TextField("Only image file");
        Button image_button =new Button("Encrypt Image file");
        TextField text = new TextField("Only Txt File");
        Button text_button =new Button("Encrypt text file");
        TextField pdf = new TextField("Only Pdf File");
        Button pdf_button =new Button("Encrypt Pdf File");
        TextField docx = new TextField("Only Docx file");
        Button docx_button =new Button("Encrypt Docx File");
        Label decrypt = new Label("Decrypt your file");
        Button decrypt_button = new Button("Decrypted File");
        VBox vbox = new VBox(5);
        vbox.setAlignment(Pos.TOP_CENTER); 
        vbox.getChildren().add(encrypt);
        vbox.getChildren().add(path);
        vbox.getChildren().add(image);
        vbox.getChildren().add(image_button);
        vbox.getChildren().add(text);
        vbox.getChildren().add(text_button);
        vbox.getChildren().add(pdf);
        vbox.getChildren().add(pdf_button);
        vbox.getChildren().add(docx);
        vbox.getChildren().add(docx_button);
        vbox.getChildren().add(succes);
        vbox.getChildren().add(decrypt);
        vbox.getChildren().add(decrypt_button);
        image_button.setOnAction(new EventHandler<ActionEvent>(){  
              
            @Override  
            public void handle(ActionEvent arg0) {  
                // TODO Auto-generated method stub  
               String str = image.getText().trim();
               if(str.length()==0){
                   image.setText("please give image path");
               }else{
                   byte []key = main_file.getKey();
                   try{
                    BufferedImage bImage = ImageIO.read(new File(str));
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    ImageIO.write(bImage, "jpg", bos );
                    byte [] data = bos.toByteArray();
                    Aes_128_bit_algorithm obj =new Aes_128_bit_algorithm();
                    data =obj.encrypt(data, key);
                    FileOutputStream fos = new FileOutputStream(file+"\\encrypted.jpg");
                    fos.write(data);
                    fos.flush();
                    fos.close();
                    succes.setText("successfully encrypted in"+str);
                   }catch(Exception e){
                       image.setText("Wrong Path");
                   }
               }
                  
            }  
        } );  
        text_button.setOnAction(new EventHandler<ActionEvent>() {  
              
            @Override  
            public void handle(ActionEvent arg0) {  
                // TODO Auto-generated method stub  
                String str = text.getText().trim();
                if(str.length()==0){
                    text.setText("please give text file path");
                }
                else{
                    String path = str;
                    String finalPath = file+"\\testout1.txt";
                    
                    try {
                        byte []key = main_file.getKey();
                        byte[] encoded = Files.readAllBytes(Paths.get(path));
                        Aes_128_bit_algorithm obj2 =new Aes_128_bit_algorithm();
                        byte[] data_file =obj2.encrypt(encoded, key);
                        Files.write(Paths.get(finalPath), data_file);
                        byte[] encoded2 = Files.readAllBytes(Paths.get(finalPath));
                        succes.setText("successfully encrypted in"+str);
                        
                    } 
                    catch (IOException e) {
                        text.setText("Invalid path");
                    }
               }
                  
            }  
        } ); 
        pdf_button.setOnAction(new EventHandler<ActionEvent>() {  
              
            @Override  
            public void handle(ActionEvent arg0) {  
                // TODO Auto-generated method stub  
               String str = pdf.getText().trim();
               if(str.length()==0){
                   pdf.setText("please give pdf file path");
               }
                  
            }  
        } ); 
        docx_button.setOnAction(new EventHandler<ActionEvent>() {  
              
            @Override  
            public void handle(ActionEvent arg0) {  
                // TODO Auto-generated method stub  
               String str = docx.getText().trim();
               if(str.length()==0){
                   docx.setText("please give docx file path");
               }                  
            }  
        } );  
        decrypt_button.setOnAction(new EventHandler<ActionEvent>() {  
              
            @Override  
            public void handle(ActionEvent arg0) {  
                // TODO Auto-generated method stub  
               primaryStage.setScene(scene2);
            }  
        } ); 
        
        Label decrypt_ = new Label();  
        decrypt_.setText("For decryption "); 
        Label succes_ = new Label();
        Label path_ = new Label("Give path of file in box");
        TextField image_ = new TextField("Only decrpyted image file");
        Button image_button_ =new Button("decrpyted Image file");
        TextField text_ = new TextField("Only decrpyted Txt File");
        Button text_button_ =new Button("decrpyted text file");
        TextField pdf_ = new TextField("Only decrpyted Pdf File");
        Button pdf_button_ =new Button("decrpyted Pdf File");
        TextField docx_ = new TextField("Only decrpyted Docx file");
        Button docx_button_ =new Button("decrpyted Docx File");
        Label encrypt_1 = new Label("Encrypt your file");
        Button encrypt_button_ = new Button("Encrypt File");
        VBox vbox_ = new VBox(5);
        vbox_.setAlignment(Pos.TOP_CENTER); 
        vbox_.getChildren().add(decrypt_);
        vbox_.getChildren().add(path_);
        vbox_.getChildren().add(image_);
        vbox_.getChildren().add(image_button_);
        vbox_.getChildren().add(text_);
        vbox_.getChildren().add(text_button_);
        vbox_.getChildren().add(pdf_);
        vbox_.getChildren().add(pdf_button_);
        vbox_.getChildren().add(docx_);
        vbox_.getChildren().add(docx_button_);
        vbox_.getChildren().add(succes_);
        vbox_.getChildren().add(encrypt_1);
        vbox_.getChildren().add(encrypt_button_);
        
        image_button_.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String str = image_.getText();
                if(str.length()==0){
                    image_.setText("Invalid path");
                }
            }
        });
        text_button_.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String str = text_.getText();
                if(str.length()==0){
                    text_.setText("Invalid path");
                }
            }
        });
        pdf_button_.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String str = pdf_.getText();
                if(str.length()==0){
                    pdf_.setText("Invalid path");
                }
            }
        });
        docx_button_.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String str = docx_.getText();
                if(str.length()==0){
                    docx_.setText("Invalid path");
                }
            }
        });
        encrypt_button_.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(scene1);
            }
        });
        
        
        
        
        
        
        
        
        scene2 = new Scene(vbox_, 600, 600);
        scene1 = new Scene(vbox,600,600);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("AES 128 bit");  
        primaryStage.show();  
    
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
