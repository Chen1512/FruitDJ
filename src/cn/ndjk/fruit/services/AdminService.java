package cn.ndjk.fruit.services;

/**
 * @author shkstart
 * @create 2023--04-15:27
 */

import cn.ndjk.fruit.bean.FruitItem;
import cn.ndjk.fruit.dao.AdminDao;

import java.util.ArrayList;

/**
 * @Description:
管理员的服务类：窗口界面中进行增、删、查、改等操作
 * @return:
 * @author: chen
 * @date: 2023/1/4 15:27
 */
public class AdminService {
    private AdminDao adminDao=new AdminDao();
    //查询服务
    public ArrayList<FruitItem> queryFruitItem(){
        //调用Dao层获取所有的数据方法来获取所有数据
        ArrayList<FruitItem> data=adminDao.queryAllData();
        return data;
    }
    //添加服务
    public boolean addFruitItem(String number,String name,String price,String unit){
        //调用Dao层获取所有数据方法获取所有数据
        ArrayList<FruitItem> data=adminDao.queryAllData();
        //使用输入的编号与所有的数据编号进行比较
        for (int i = 0; i <data.size() ; i++) {
            FruitItem fruitItem=data.get(i);
            //如果存在重复的编号水果信息，则添加失败
            if (number.equals(fruitItem.getNumber())){
                return false;
            }
        }
        //如果没有重复，将数据封装为FruitItem对象
        FruitItem thisFruitItem=new FruitItem(number,name,Double.parseDouble(price),unit);
        //调用Dao层的添加数据方法
        adminDao.addFruitItem(thisFruitItem);
        return true;
    }

    //修改服务
    public boolean updateFruitItem(String number,String name,String price,String unit){
        //调用Dao层获取所有数据方法获取所有数据
        ArrayList<FruitItem> data=adminDao.queryAllData();
        //如果存在相同的编号,则可以修改
        for (int i = 0; i <data.size() ; i++) {
            FruitItem fruitItem=data.get(i);
            if (number.equals(fruitItem.getNumber())){
                //调用Dao层的删除指定编号数据的方法
                adminDao.delFruitItem(number);
                //如果没有重复编号的数据，就将数据封装为FruitItem对象
                FruitItem thisFruitItem=new FruitItem(number,name,Double.parseDouble(price),unit);
                //调用Dao层添加数据方法
                adminDao.addFruitItem(thisFruitItem);
                return true;
            }
        }
        return false;
    }

    //删除服务
    public boolean delFruitItem(String delnumber){
        //调用Dao层获取所有数据方法获取所有数据
        ArrayList<FruitItem> data=adminDao.queryAllData();
        //使用输入的编号与所有的数据对比
        for (int i = 0; i <data.size() ; i++) {
            FruitItem fruitItem=data.get(i);
            if (delnumber.equals(fruitItem.getNumber())){
                //调用Dao层的删除指定编号数据的方法
                adminDao.delFruitItem(delnumber);
                return true;
                }
            }
        return false;
    }
    /**
     * @Description:
条件查询
     * @return:
     * @author: chen
     * @date: 2023/1/5 13:52
     */
    public ArrayList<FruitItem> queryFruitByCon(FruitItem fruitItem){
        ArrayList<FruitItem> fruitItems=adminDao.queryFruitByCon(fruitItem);
        return fruitItems;
    }
}
