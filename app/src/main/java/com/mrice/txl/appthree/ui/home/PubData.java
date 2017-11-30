package com.mrice.txl.appthree.ui.home;

import com.mrice.txl.appthree.bean.MultipleItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by app on 2017/11/30.
 */
public class PubData {

    public static List<MultipleItem> getHomeData(int p){
        List<MultipleItem> list=new ArrayList<>();

        switch (p){
            case 0:
                MultipleItem m1=new MultipleItem(MultipleItem.MUKUAI);
                m1.setTitle("双色球");
                m1.setPubTime("第17140期");
                m1.setContent("21,22,25,28,29,30,07");
                MultipleItem m2=new MultipleItem(MultipleItem.MUKUAI);
                m2.setTitle("七乐彩");
                m2.setPubTime("第17140期");
                m2.setContent("01,13,20,23,25,28,18");
                MultipleItem m3=new MultipleItem(MultipleItem.XINWEN);
                m3.setTitle("假如没有了彩票……");
                m3.setPubTime("来源：中彩网      2017-12-01");
                m3.setContent("file:///android_asset/p1_1.html");
                m3.setUrl("file:///android_asset/p1_1.jpg");
                MultipleItem m4=new MultipleItem(MultipleItem.XINWEN);
                m4.setTitle("扶老助老，中国福利彩票在行动");
                m4.setPubTime("来源：福彩网      2017-12-01");
                m4.setContent("file:///android_asset/p1_2.html");
                m4.setUrl("file:///android_asset/p1_9.jpg");
                MultipleItem m5=new MultipleItem(MultipleItem.XINWEN);
                m5.setTitle("盘点今年以来的5000万+大奖 投入均在百元以内");
                m5.setPubTime("来源：网易彩票      2017-11-30");
                m5.setContent("file:///android_asset/p1_3.html");
                m5.setUrl("file:///android_asset/p1_3.jpg");
                MultipleItem m6=new MultipleItem(MultipleItem.XINWEN);
                m6.setTitle("“复式盛宴 再度来袭”双色球9亿元大派奖11月5日开启");
                m6.setPubTime("来源：网易彩票      2017-11-30");
                m6.setContent("file:///android_asset/p1_4.html");
                m6.setUrl("file:///android_asset/p1_4.jpg");
                MultipleItem m7=new MultipleItem(MultipleItem.BANNER);
                m7.setUrl("file:///android_asset/p1_bar.jpg");
                MultipleItem m8=new MultipleItem(MultipleItem.XINWEN);
                m8.setTitle("福彩进影院·开启新公益 别样慈善助力文化建设");
                m8.setPubTime("来源：中彩网      2017-11-29");
                m8.setContent("file:///android_asset/p1_5.html");
                m8.setUrl("file:///android_asset/p1_5.jpg");
                MultipleItem m9=new MultipleItem(MultipleItem.XINWEN);
                m9.setTitle("走近双色球代表“麻辣”登场 共同期待幸运降临");
                m9.setPubTime("来源：福彩网      2017-11-28");
                m9.setContent("file:///android_asset/p1_6.html");
                m9.setUrl("file:///android_asset/p1_6.jpg");
                MultipleItem m10=new MultipleItem(MultipleItem.XINWEN);
                m10.setTitle("10元机选票喜中双色球982万");
                m10.setPubTime("来源：福彩网      2017-11-28");
                m10.setContent("file:///android_asset/p1_7.html");
                m10.setUrl("file:///android_asset/p1_7.jpg");
                list.add(m1);
                list.add(m2);
                list.add(m3);
                list.add(m4);
                list.add(m5);
                list.add(m6);
                list.add(m7);
                list.add(m8);
                list.add(m9);
                list.add(m10);
                break;
            case 1:
                MultipleItem n1=new MultipleItem(MultipleItem.MUKUAI);
                n1.setTitle("大乐透");
                n1.setPubTime("第17140期");
                n1.setContent("10,16,25,26,29,01,05");
                MultipleItem n2=new MultipleItem(MultipleItem.MUKUAI);
                n2.setTitle("排列三");
                n2.setPubTime("第17326期");
                n2.setContent("7,2,3,4,5,6,7");
                MultipleItem n22=new MultipleItem(MultipleItem.MUKUAI);
                n22.setTitle("排列五");
                n22.setPubTime("第17326期");
                n22.setContent("7,2,3,1,4,6,7");
                MultipleItem n3=new MultipleItem(MultipleItem.XINWEN);
                n3.setTitle("一触即发 胜平负'单固'7天猜10场");
                n3.setPubTime("来源：中彩网      2017-12-01");
                n3.setContent("file:///android_asset/page1.html");
                n3.setUrl("file:///android_asset/p2_1.jpg");
                MultipleItem n4=new MultipleItem(MultipleItem.XINWEN);
                n4.setTitle("北京彩站晒红单 “猜球者”出手现194倍高回报");
               n4.setPubTime("来源：体彩网      2017-12-01");
                n4.setContent("file:///android_asset/page2.html");
                n4.setUrl("file:///android_asset/p2_2.jpg");
                MultipleItem n5=new MultipleItem(MultipleItem.XINWEN);
                n5.setTitle("竞彩品牌欢歌不断 “魅力竞彩”活动定位兰州");
                n5.setPubTime("来源：网易彩票      2017-11-30");
                n5.setContent("file:///android_asset/page3.html");
                n5.setUrl("file:///android_asset/p10.png");
                MultipleItem n6=new MultipleItem(MultipleItem.XINWEN);
                n6.setTitle("“魅力竞彩·快乐同行”系列活动相约洛阳");
                n6.setPubTime("来源：网易彩票      2017-11-30");
                n6.setContent("file:///android_asset/page4.html");
                n6.setUrl("file:///android_asset/p2_4.jpg");
                MultipleItem n7=new MultipleItem(MultipleItem.BANNER);
                n7.setUrl("file:///android_asset/p_bar2.jpg");
                MultipleItem n8=new MultipleItem(MultipleItem.XINWEN);
                n8.setTitle("湖南长沙业主合力出票 彩民喜中竞彩篮球340万");
                n8.setPubTime("来源：中彩网      2017-11-29");
                n8.setContent("file:///android_asset/page6.html");
                n8.setUrl("file:///android_asset/p2_5.jpg");
                MultipleItem n9=new MultipleItem(MultipleItem.XINWEN);
                n9.setTitle("提升销量从竞彩入手 业主用坚持换彩民认可");
                n9.setPubTime("来源：体彩网      2017-11-28");
                n9.setContent("file:///android_asset/page8.html");
                n9.setUrl("file:///android_asset/p3.png");
                MultipleItem n10=new MultipleItem(MultipleItem.XINWEN);
                n10.setTitle("营口竞彩高手倍投“2串1” 中奖17万余元");
                n10.setPubTime("来源：体彩网     2017-11-28");
                n10.setContent("file:///android_asset/page9.html");
                n10.setUrl("file:///android_asset/p9.png");
                list.add(n1);
                list.add(n2);
                list.add(n22);
                list.add(n3);
                list.add(n4);
                list.add(n7);
                list.add(n5);
                list.add(n6);
                list.add(n8);
                list.add(n9);
                list.add(n10);
                break;
            case 2:

                break;
        }
        return list;
    }

}
