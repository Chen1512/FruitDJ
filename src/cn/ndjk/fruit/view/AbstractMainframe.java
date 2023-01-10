package cn.ndjk.fruit.view;

import cn.ndjk.fruit.tools.GUITools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author shkstart
 * @create 2023--03-14:00
 */
public abstract class AbstractMainframe extends JFrame {
    private JLabel titleLabel=new JLabel(new ImageIcon("D:\\idea\\TEst\\Fruit\\imgs\\fruit.jpg"));
    private JButton btn=new JButton("进入系统");
    public AbstractMainframe(){
        this.init();
        this.addComponent();
        this.addListener();
    }
    private void init(){
        this.setTitle("水果超市欢迎您！");
        this.setSize(600,400);
        GUITools.center(this);
        GUITools.setTitleImage(this,"D:\\idea\\TEst\\Fruit\\imgs\\yintao.jpg");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void addComponent(){
        this.add(this.titleLabel, BorderLayout.NORTH);
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(null);
        btn.setBounds(240,20,120,50);
        btnPanel.add(btn);
        this.add(btnPanel);
    }
    private void addListener(){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAdminDialog();
            }
        });
    }
    public abstract void showAdminDialog();
}
