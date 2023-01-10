package cn.ndjk.fruit.view;

import cn.ndjk.fruit.tools.GUITools;
import sun.font.TrueTypeFont;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;

/**
 * @author shkstart
 * @create 2023--03-14:41
 */
public abstract class AbstractAdminDialog extends JDialog {
    private JLabel tableLabel=new JLabel("水果列表");
    private JScrollPane tablepane=new JScrollPane();
    protected JTable table=new JTable();
    private JLabel numberLabel=new JLabel("水果编号");
    private JLabel nameLabel=new JLabel("水果名称");
    private JLabel priceLabel=new JLabel("水果价格");
    private JLabel unitLabel=new JLabel("计价单位");
    //添加功能组件
    protected JTextField addNumberText=new JTextField(6);
    protected JTextField addNameText=new JTextField(6);
    protected JTextField addPriceText=new JTextField(6);
    protected JTextField addUnitText=new JTextField(6);
    private JButton addBtn=new JButton("添加水果");
    //修改功能组件
    protected JTextField updateNumberText=new JTextField(6);
    protected JTextField updateNameText=new JTextField(6);
    protected JTextField updatePriceText=new JTextField(6);
    protected JTextField updateUnitText=new JTextField(6);
    private JButton updateBtn=new JButton("修改水果");
    //删除功能组件
    protected JTextField deleteNumberText=new JTextField(6);
    private JButton deleteBtn=new JButton("删除水果");
    //条件查询功能组件
    protected JTextField queryNumberText=new JTextField(6);
    protected JTextField queryNameText=new JTextField(6);
    protected JTextField queryPriceText=new JTextField(6);
    protected JTextField queryUnitText=new JTextField(6);
    private JButton queryBtn=new JButton("条件查询");

    public AbstractAdminDialog(){
        this(null, true);
    }
    public AbstractAdminDialog(Frame owner,boolean modal){
        super(owner,true);
        this.init();
        this.addComponent();
        this.addListener();
    }
    private void init(){
        this.setTitle("超市管理系统");
        this.setSize(600,500);
        GUITools.center(this);
        this.setResizable(false);
    }
    private void addComponent(){
        this.setLayout(null);
        tableLabel.setBounds(265,20,70,25);
        table.setEnabled(false);
        this.add(tableLabel);
        tablepane.setBounds(50,50,500,200);
        tablepane.setViewportView(table);
        this.add(tablepane);
        //字段标题
        numberLabel.setBounds(50,250,70,25);
        nameLabel.setBounds(150,250,70,25);
        priceLabel.setBounds(250,250,70,25);
        unitLabel.setBounds(350,250,70,25);
        this.add(numberLabel);
        this.add(nameLabel);
        this.add(priceLabel);
        this.add(unitLabel);
        //增加组件
        addNumberText.setBounds(50,280,80,25);
        addNameText.setBounds(150,280,80,25);
        addPriceText.setBounds(250,280,80,25);
        addUnitText.setBounds(350,280,80,25);
        addBtn.setBounds(460,280,90,25);
        this.add(addNumberText);
        this.add(addNameText);
        this.add(addPriceText);
        this.add(addUnitText);
        this.add(addBtn);
        //修改组件
        updateNumberText.setBounds(50,310,80,25);
        updateNameText.setBounds(150,310,80,25);
        updatePriceText.setBounds(250,310,80,25);
        updateUnitText.setBounds(350,310,80,25);
        updateBtn.setBounds(460,310,90,25);
        this.add(updateNumberText);
        this.add(updateNameText);
        this.add(updatePriceText);
        this.add(updateUnitText);
        this.add(updateBtn);
        //删除组件
        deleteNumberText.setBounds(50,340,80,25);
        deleteBtn.setBounds(460,340,90,25);
        this.add(deleteBtn);
        this.add(deleteNumberText);
        //查询组件
        queryNumberText.setBounds(50,370,80,25);
        queryNameText.setBounds(150,370,80,25);
        queryPriceText.setBounds(250,370,80,25);
        queryUnitText.setBounds(350,370,80,25);
        queryBtn.setBounds(460,370,90,25);
        this.add(queryNumberText);
        this.add(queryNameText);
        this.add(queryPriceText);
        this.add(queryUnitText);
        this.add(queryBtn);
    }
    private void addListener(){
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFruitItem();
            }
        });
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFruitItem();
            }
        });
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteFruitItem();
            }
        });
        queryBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                queryFruitItemForCon();//条件查询
            }
        });
    }
    public abstract void queryFruitItem();
    public abstract void addFruitItem();
    public abstract void updateFruitItem();
    public abstract void deleteFruitItem();
    public abstract void queryFruitItemForCon();




}
