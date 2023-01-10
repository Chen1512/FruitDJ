package cn.ndjk.fruit.date;

import cn.ndjk.fruit.bean.FruitItem;

import javax.crypto.interfaces.PBEKey;
import java.util.ArrayList;

/**
 * @author shkstart
 * @create 2023--04-15:13
 */
public class DataBase {
    public static ArrayList<FruitItem> data=new ArrayList<FruitItem>();
    //初始数据
    static {
        data.add(new FruitItem("1","苹果",10.0,"斤"));
    }
}
