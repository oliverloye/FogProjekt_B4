/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import data.Interfaces.ImaterialFacade;
import business.entity.Material;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Oliver
 */
public class MaterialMapper implements ImaterialFacade {
    
    @Override
    public Material getMaterial(int id) {
        Material material = null;
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM materials WHERE mid = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                int mid = rs.getInt("mid");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int stock = rs.getInt("stock");
                material = new Material(mid, name, price, stock);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return material;
    }
    
}
