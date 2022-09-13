/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelsDAO;
import Models.Tutor;
import ModelsDAO.Conection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Crisito
 */
public class TutorDAO {
    private Conection con;
    public Tutor tut;

    public TutorDAO() {
        this.con = new Conection();
    }
    
    public List<Tutor> getAllTeacher(){
        System.out.println("Metodo DAO");
        List<Tutor> listTutor = new ArrayList<>();
        try{
            this.con.conectar();
            String query ="select * from getusers(1)";
            ResultSet rs=this.con.ejecutarSql(query);
            while(rs.next()){
                this.tut = new Tutor();
                this.tut.setId(rs.getInt(1));
                this.tut.setEmail(rs.getString(3));
                this.tut.setApellido(rs.getString(2));
                this.tut.setNombre(rs.getString(4));
                this.tut.setTelefono(rs.getString(5));
                this.tut.setTipoUser(rs.getString(6));
                listTutor.add(tut);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            this.con.desconectar();
        }
        return listTutor;
    }
    
}
