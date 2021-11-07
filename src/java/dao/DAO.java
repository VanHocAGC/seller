/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Category;
import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
     
    public List<Product> getAllProduct(){
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM Product";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Product(
                        rs.getInt(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getInt(4), 
                        rs.getString(5), 
                        rs.getString(6), 
                        rs.getInt(7), 
                        rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return list ;
    }
    public List<Category> getAllCategory(){
        List<Category> list = new ArrayList<>();
        String query = "SELECT * FROM Category";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Category(
                        rs.getInt(1), 
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list ;
    }
    public Product getLastProduct(){
        Product pro = new Product();
        String query = "SELECT TOP 1 * FROM Product ORDER BY id DESC";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                pro = new Product(rs.getInt(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getInt(4), 
                        rs.getString(5), 
                        rs.getString(6), 
                        rs.getInt(7), 
                        rs.getInt(8));
            }
        } catch (Exception e) {
        }
        return pro;
    }
    public List<Product> getProductByCateID(String cid){
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM Product WHERE cateID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Product(
                        rs.getInt(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getInt(4), 
                        rs.getString(5), 
                        rs.getString(6), 
                        rs.getInt(7), 
                        rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return list ;
    }
        public Product getProductByID(String productID){
        Product pro = new Product();
        String query = "SELECT * FROM Product WHERE id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, productID);
            rs = ps.executeQuery();
            while(rs.next()){
                pro = new Product(rs.getInt(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getInt(4), 
                        rs.getString(5), 
                        rs.getString(6), 
                        rs.getInt(7), 
                        rs.getInt(8));
            }
        } catch (Exception e) {
        }
        return pro;
    }
    public static void main(String[] args) {
        DAO dao = new DAO();
        Product pro = dao.getProductByID("4");
        List<Product> listP = dao.getProductByCateID("1");
         
        System.out.println(pro);
//        for (Product product : listP) {
//            System.out.println(product);
//        }
    }
}
