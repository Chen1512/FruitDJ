package cn.ndjk.fruit.test;

import cn.ndjk.fruit.view.AbstractAdminDialog;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;

/**
 * @author shkstart
 * @create 2023--03-15:42
 */
public class AbstractAdminDialogTest extends AbstractAdminDialog {
    public AbstractAdminDialogTest() {
        super();
        queryFruitItem();//测试数据
    }

    @Override
    public void queryFruitItem() {
        String[] thead=new String[]{"水果编号","水果名称","水果单价（/元）","计价单位"};
        String[][] tbody=new String[][]{
                {"1","苹果","5.0","斤"},
                {"2","葡萄","3.2","斤"},
                {"3","雪梨","3.8","斤"},
                {"4","泰国大榴莲","120","个"}
        };
        TableModel data=new DefaultTableModel(tbody,thead);
        table.setModel(data);
    }

    @Override
    public void addFruitItem() {

    }

    @Override
    public void updateFruitItem() {

    }

    @Override
    public void deleteFruitItem() {

    }

    @Override
    public void queryFruitItemForCon() {

    }
}
