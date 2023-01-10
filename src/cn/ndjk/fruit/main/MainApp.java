package cn.ndjk.fruit.main;

import cn.ndjk.fruit.controller.MainFramController;
import cn.ndjk.fruit.test.AbstractMainFrameTest;

/**
 * @author shkstart
 * @create 2023--03-14:24
 */
public class MainApp {
    public static void main(String[] args) {
        new MainFramController().setVisible(true);
    }
}
