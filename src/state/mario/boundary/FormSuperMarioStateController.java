/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state.mario.boundary;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import state.mario.pattern.Mario;
import state.mario.pattern.MarioCapa;
import state.mario.pattern.MarioFogo;
import state.mario.pattern.MarioGrande;
import state.mario.pattern.MarioMorto;
import state.mario.pattern.MarioPequeno;
import state.mario.pattern.MarioState;

/**
 * FXML Controller class
 *
 * @author Fernando
 */
public class FormSuperMarioStateController implements Initializable, Observer {

    @FXML
    private ImageView imgPequeno;
    @FXML
    private ImageView imgPeninha;
    @FXML
    private ImageView imgMorre;
    @FXML
    private ImageView imgGrande;
    @FXML
    private ImageView imgFogo;
    
    private Mario mario;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btPegarCogumeloOnAction(ActionEvent event) {
        if (mario != null) {
            mario.pegarCogumelo();
        }
    }

    @FXML
    private void btPegarFlorOnAction(ActionEvent event) {
        if (mario != null) {
            mario.pegarFlor();
        }
    }

    @FXML
    private void btPegarPenaOnAction(ActionEvent event) {
        if (mario != null) {
            mario.pegarPena();
        }
    }

    @FXML
    private void btLevarDanoOnAction(ActionEvent event) {
        if (mario != null) {
            mario.levarDano();
        }
    }

    public void initData(Stage stage) {
        mario = new Mario();
        mario.addObserver(this);
        mario.notifica();
    }

    @Override
    public void update(Observable o, Object arg) {
        if (((MarioState) arg) instanceof MarioMorto || ((MarioState) arg) == null) {
            imgMorre.setVisible(true);
            imgFogo.setVisible(false);
            imgGrande.setVisible(false);
            imgPeninha.setVisible(false);
            imgPequeno.setVisible(false);
        } else if (((MarioState) arg) instanceof MarioPequeno) {
            imgMorre.setVisible(false);
            imgFogo.setVisible(false);
            imgGrande.setVisible(false);
            imgPeninha.setVisible(false);
            imgPequeno.setVisible(true);
        } else if (((MarioState) arg) instanceof MarioCapa) {
            imgMorre.setVisible(false);
            imgFogo.setVisible(false);
            imgGrande.setVisible(false);
            imgPeninha.setVisible(true);
            imgPequeno.setVisible(false);
        } else if (((MarioState) arg) instanceof MarioFogo) {
            imgMorre.setVisible(false);
            imgFogo.setVisible(true);
            imgGrande.setVisible(false);
            imgPeninha.setVisible(false);
            imgPequeno.setVisible(false);
        } else if (((MarioState) arg) instanceof MarioGrande) {
            imgMorre.setVisible(false);
            imgFogo.setVisible(false);
            imgGrande.setVisible(true);
            imgPeninha.setVisible(false);
            imgPequeno.setVisible(false);
        }
    }
    
}
