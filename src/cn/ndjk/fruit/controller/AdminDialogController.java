package cn.ndjk.fruit.controller;

import cn.ndjk.fruit.bean.FruitItem;
import cn.ndjk.fruit.services.AdminService;
import cn.ndjk.fruit.view.AbstractAdminDialog;
import jdk.nashorn.internal.scripts.JD;
import sun.security.x509.IPAddressName;

import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author shkstart
 * @create 2023--04-16:10
 */
/**
 * @Description:
管理员界面操作类
 * @return:
 * @author: chen
 * @date: 2023/1/4 16:12
 */
public class AdminDialogController extends AbstractAdminDialog {
    //定义服务类，提供完整的功能服务
    private AdminService adminService=new AdminService();
    //无参构造方法
    public AdminDialogController() {
        super();
    }

    //有参构造方法
    public AdminDialogController(Frame owner, boolean modal) {
        super(owner, modal);
        //创建对象时展示所有数据
        queryFruitItem();
    }

    @Override
    public void queryFruitItem() {
        String[] thead=new String[]{"水果编号","水果名称","水果单价（/元）","计价单位"};
        //调用adminService
        ArrayList<FruitItem> dataList=adminService.queryFruitItem();
        //list2Array方法，集合转化数组，方便给Jtable赋值
        String[][] tbody=List2Array(dataList);
        DefaultTableModel tableModel = new DefaultTableModel(tbody,thead);
        table.setModel(tableModel);
    }

    public String[][] List2Array(ArrayList<FruitItem> list){
        String[][] tbody=new String[list.size()][4];
        for (int i = 0; i <list.size() ; i++) {
            FruitItem fruitItem=list.get(i);
            tbody[i][0]=fruitItem.getNumber();
            tbody[i][1]=fruitItem.getName();
            tbody[i][2]=fruitItem.getPrice()+"";
            tbody[i][3]=fruitItem.getUnit();

        }
        return tbody;
    }
/**
 * @Description:
添加方法
 * @return: void
 * @author: chen
 * @date: 2023/1/5 8:56
 */
    @Override
    public void addFruitItem() {
        //获取数据
        String addNumber=addNumberText.getText();
        String addName=addNameText.getText();
        String addPrice=addPriceText.getText();
        String addUnit=addUnitText.getText();
        //调用添加服务
        boolean addSuccess = adminService.addFruitItem(addNumber, addName, addPrice, addUnit);
        //如果添加成功
        if (addSuccess){
            queryFruitItem();
        }
        //没有添加，弹出错误的提示信息
        else{
            JOptionPane.showMessageDialog(this,"水果编号不能重复，请检查数据");
        }
    }
/**
 * @Description:
修改方法
 * @return: void
 * @author: chen
 * @date: 2023/1/5 8:56
 */
    @Override
    public void updateFruitItem() {
        //获取数据
        String updateNumber=updateNumberText.getText();
        String updateName=updateNameText.getText();
        String updatePrice=updatePriceText.getText();
        String updateUnit=updateUnitText.getText();
        //调用修改服务
        boolean updateSuccess = adminService.updateFruitItem(updateNumber, updateName, updatePrice, updateUnit);
        //如果修改成功
        if (updateSuccess){
            //刷新表格数据
            queryFruitItem();
        }
        else {
            //没有修改，弹出错误的提示信息
            JOptionPane.showMessageDialog(this,"没有这个编号水果，请检查数据");
        }

    }
/**
 * @Description:
删除方法
 * @return: void
 * @author: chen
 * @date: 2023/1/5 8:57
 */
    @Override
    public void deleteFruitItem() {
        //获取数据
        String delNumber=deleteNumberText.getText();
        //调用删除服务
        boolean delSuccess = adminService.delFruitItem(delNumber);
        //如果成功，刷新表格数据
        if (delSuccess){
            queryFruitItem();
        }
        //没有成功，弹出相应错误信息
        else {
            JOptionPane.showMessageDialog(this,"没有这个编号水果，请检查数据");
        }
    }
/**
 * @Description:
条件查询
 * @return: void
 * @author: chen
 * @date: 2023/1/5 9:19
 */
    @Override
    public void queryFruitItemForCon() {
        //获取数据
        String number=queryNumberText.getText().trim();
        String name=queryNameText.getText().trim();
        String price=queryPriceText.getText().trim();
        String unit=queryUnitText.getText().trim();
        try {
            FruitItem fruitItem=new FruitItem();
            fruitItem.setNumber(number);
            fruitItem.setName(name);
            if (price==null||price.length()==0){
                fruitItem.setPrice(0);
            }
            else {
                fruitItem.setPrice(Double.parseDouble(price));
            }
            fruitItem.setUnit(unit);
            ArrayList<FruitItem> fruitItems=adminService.queryFruitByCon(fruitItem);
            String []thead=new String[]{"水果编号","水果名称","水果单价（/元）","计价单位"};
            String[][]tbody=List2Array(fruitItems);
            TableModel data=new DefaultTableModel(tbody,thead);
            table.setModel(data);
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this,"单价数据格式有误，请检查数据");
        }finally {
            queryNumberText.setText("");
            queryNameText.setText("");
            queryPriceText.setText("");
            queryUnitText.setText("");
        }


    }
}
