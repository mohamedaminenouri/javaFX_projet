package edu.conncection_alt.services;

import edu.conncection_alt.entities.Personne;
import edu.conncection_alt.tools.MyConncetion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonneServices implements IServices<Personne> {
    @Override
    public void addEntity(Personne personne) {
        String requete="INSERT INTO personne (nom, prenom)   VALUES ('"+personne.getNom()+"','"+personne.getPrenom()+"')";
        try  {
            Statement st = new MyConncetion().getCnx().createStatement();

            st.executeUpdate(requete);
            System.out.println("ajout success");
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
    public void addEntity2(Personne p){
        String requete="insert into personne (nom,prenom) values (?,?)";
        try  {
            PreparedStatement pst = new MyConncetion()
                    .getCnx()
                    .prepareStatement(requete);
            pst.setString(1,p.getNom());
            pst.setString(2,p.getPrenom());
            pst.executeUpdate();
            System.out.println("personne added");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Personne> getAllData() {
        ArrayList<Personne> list=new ArrayList<>();
        String requete="Select * from personne";
        try  {
            Statement st1 = new MyConncetion().getCnx().createStatement();
          ResultSet re= st1.executeQuery(requete);
          while (re.next()){
              Personne p=new Personne();
              p.setId(re.getInt(1));
              p.setNom(re.getString("nom"));
              p.setPrenom(re.getString("prenom"));
              list.add(p);
          }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        return list;
    }
}
