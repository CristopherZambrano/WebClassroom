/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Tutor;
import ModelsDAO.TutorDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Crisito
 */
@Named(value = "tutorMB")
@ViewScoped
public class TutorController implements Serializable{
    private List<Tutor> lstTutor;
    private Tutor ttr;
    TutorDAO ttrDao = new TutorDAO();

    public TutorController() throws SQLException{
        System.out.println("Controlador");
        this.lstTutor= new ArrayList<>();
        this.ttr = new Tutor();
        this.lstTutor= this.ttrDao.getAllTeacher();
    }
    
    @PostConstruct
    public void init(){
        this.lstTutor = this.ttrDao.getAllTeacher();
    }

    public void getAllTeacher() {
        try{
            System.out.println("Metodo controlador");
            this.lstTutor=this.ttrDao.getAllTeacher();
        }catch(Exception e){
            System.out.println(e.getMessage().toString());
        }
    }

    public List<Tutor> getLstTutor() {
        return lstTutor;
    }

    public void setLstTutor(List<Tutor> lstTutor) {
        this.lstTutor = lstTutor;
    }
}
