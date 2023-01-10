package cn.ndjk.fruit.dao;

/**
 * @author shkstart
 * @create 2023--04-15:08
 */

import cn.ndjk.fruit.bean.FruitItem;
import cn.ndjk.fruit.date.DataBase;
import cn.ndjk.fruit.tools.JDBCUtils;
import org.springframework.orm.jpa.vendor.Database;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @Description:
管理员数据访问类
 * @return:
 * @author: chen
 * @date: 2023/1/4 15:09
 */
public class AdminDao {
    //获取所有数据
    public ArrayList<FruitItem> queryAllData(){
        //return DataBase.data;
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        ArrayList<FruitItem> list=new ArrayList<FruitItem>();
        try {
            //获取数据库的连接
            conn= JDBCUtils.getConnection();
            //获取Statement对象
            stmt=conn.createStatement();
            //发送sql'语句
            String sql="select * from fruit";
            rs=stmt.executeQuery(sql);
            //处理结果集
            while (rs.next()){
                FruitItem fruitItem=new FruitItem();
                fruitItem.setNumber(rs.getString("number"));
                fruitItem.setName(rs.getString("name"));
                fruitItem.setPrice(rs.getDouble("price"));
                fruitItem.setUnit(rs.getString("unit"));
                list.add(fruitItem);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(conn,stmt,rs);
        }
        return null;
    }
    //添加数据
    public void addFruitItem(FruitItem fruitItem){
        //DataBase.data.add(fruitItem);
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        try {
            //获取数据库的连接
            conn= JDBCUtils.getConnection();
            //获取Statement对象
            stmt=conn.createStatement();
            //发送sql'语句
            String sql="insert into fruit(number,name,price,unit) values('"+fruitItem.getNumber()+"','"+fruitItem.getName()
                    +"','"+fruitItem.getPrice()+"','"+fruitItem.getUnit()+"')";
            int num=stmt.executeUpdate(sql);
            if (num>0){
                System.out.println("插入数据成功");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(conn,stmt,rs);
        }
    }
    //删除数据
    public void delFruitItem(String delNumber){
        //for (int i = 0; i <DataBase.data.size() ; i++) {
        //    FruitItem thisFruitItem=DataBase.data.get(i);
        //    if (thisFruitItem.getNumber().equals(delNumber)){
        //        DataBase.data.remove(i);
        //    }
        //}
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        try {
            //获取数据库的连接
            conn= JDBCUtils.getConnection();
            //获取Statement对象
            stmt=conn.createStatement();
            //发送sql'语句
            String sql="delete from fruit where number="+delNumber;
            int num=stmt.executeUpdate(sql);
            if (num>0){
                System.out.println("删除数据成功");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(conn,stmt,rs);
        }
    }
    /**
     * @Description:
水果条件查询
     * @return:
     * @author: chen
     * @date: 2023/1/5 13:56
     */
    public ArrayList<FruitItem> queryFruitByCon(FruitItem fruitItem){
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        ArrayList<FruitItem> fruitItems=new ArrayList<FruitItem>();
        try {
            //获取数据库的连接
            conn= JDBCUtils.getConnection();
            //获取Statement对象
            stmt=conn.createStatement();
            //发送sql语句
            String sql="select * from fruit where 1=1";
            if (fruitItem.getNumber()!=null&&fruitItem.getNumber().length()>0){
                sql=sql+" and number='"+fruitItem.getNumber()+"'";
            }
            if (fruitItem.getName()!=null&&fruitItem.getName().length()>0){
                sql=sql+" and name like'%"+fruitItem.getName()+"%'";
            }
            if (fruitItem.getPrice()!=0){
                sql=sql+" and price='"+fruitItem.getPrice()+"'";
            }
            if (fruitItem.getUnit()!=null&&fruitItem.getUnit().length()>0){
                sql=sql+" and unit like'%"+fruitItem.getUnit()+"%'";
                System.out.println(fruitItem.getUnit());
            }
            rs=stmt.executeQuery(sql);
            while (rs.next()){
                FruitItem date=new FruitItem();
                date.setNumber(rs.getString("number"));
                date.setName(rs.getString("name"));
                date.setPrice(rs.getDouble("price"));
                date.setUnit(rs.getString("unit"));
                fruitItems.add(date);
            }
            return fruitItems;
    } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtils.release(conn,stmt,rs);
        }
        return null;
        }
    }
