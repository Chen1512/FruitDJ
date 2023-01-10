package cn.ndjk.fruit.test;

import cn.ndjk.fruit.view.AbstractMainframe;

/**
 * @author shkstart
 * @create 2023--03-14:21
 */
public class AbstractMainFrameTest extends AbstractMainframe {
    @Override
    public void showAdminDialog() {
        new AbstractAdminDialogTest().setVisible(true);
    }

}
