package cn.ndjk.fruit.controller;

import cn.ndjk.fruit.view.AbstractAdminDialog;
import cn.ndjk.fruit.view.AbstractMainframe;

import javax.crypto.interfaces.PBEKey;

/**
 * @author shkstart
 * @create 2023--05-9:23
 */
//主界面操作类
public class MainFramController extends AbstractMainframe {
    public void showAdminDialog(){
        new AdminDialogController(this,true).setVisible(true);
    }

}
