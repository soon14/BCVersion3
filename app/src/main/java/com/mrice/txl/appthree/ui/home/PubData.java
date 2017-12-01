package com.mrice.txl.appthree.ui.home;

import com.mrice.txl.appthree.bean.MultipleItem;
import com.mrice.txl.appthree.ui.me.RebackItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by app on 2017/11/30.
 */
public class PubData {

    public static List<MultipleItem> getHomeData(int p) {
        List<MultipleItem> list = new ArrayList<>();

        switch (p) {
            case 0:
                MultipleItem m1 = new MultipleItem(MultipleItem.MUKUAI);
                m1.setTitle("双色球");
                m1.setPubTime("第17140期");
                m1.setContent("21,22,25,28,29,30,08");
                MultipleItem m2 = new MultipleItem(MultipleItem.MUKUAI);
                m2.setTitle("七乐彩");
                m2.setPubTime("第17140期");
                m2.setContent("01,13,20,23,25,26,28");
                MultipleItem m3 = new MultipleItem(MultipleItem.XINWEN);
                m3.setTitle("假如没有了彩票……");
                m3.setPubTime("来源：中彩网      2017-12-01");
                m3.setContent("file:///android_asset/p1_1.html");
                m3.setUrl("file:///android_asset/p1_1.jpg");
                MultipleItem m4 = new MultipleItem(MultipleItem.XINWEN);
                m4.setTitle("扶老助老，中国福利彩票在行动");
                m4.setPubTime("来源：福彩网      2017-12-01");
                m4.setContent("file:///android_asset/p1_2.html");
                m4.setUrl("file:///android_asset/p1_9.jpg");
                MultipleItem m5 = new MultipleItem(MultipleItem.XINWEN);
                m5.setTitle("盘点今年以来的5000万+大奖 投入均在百元以内");
                m5.setPubTime("来源：网易彩票      2017-11-30");
                m5.setContent("file:///android_asset/p1_3.html");
                m5.setUrl("file:///android_asset/p1_3.jpg");
                MultipleItem m6 = new MultipleItem(MultipleItem.XINWEN);
                m6.setTitle("“复式盛宴 再度来袭”双色球9亿元大派奖11月5日开启");
                m6.setPubTime("来源：网易彩票      2017-11-30");
                m6.setContent("file:///android_asset/p1_4.html");
                m6.setUrl("file:///android_asset/p1_4.jpg");
                MultipleItem m7 = new MultipleItem(MultipleItem.BANNER);
                m7.setUrl("file:///android_asset/p1_bar.jpg");
                MultipleItem m8 = new MultipleItem(MultipleItem.XINWEN);
                m8.setTitle("福彩进影院·开启新公益 别样慈善助力文化建设");
                m8.setPubTime("来源：中彩网      2017-11-29");
                m8.setContent("file:///android_asset/p1_5.html");
                m8.setUrl("file:///android_asset/p1_5.jpg");
                MultipleItem m9 = new MultipleItem(MultipleItem.XINWEN);
                m9.setTitle("走近双色球代表“麻辣”登场 共同期待幸运降临");
                m9.setPubTime("来源：福彩网      2017-11-28");
                m9.setContent("file:///android_asset/p1_6.html");
                m9.setUrl("file:///android_asset/p1_6.jpg");
                MultipleItem m10 = new MultipleItem(MultipleItem.XINWEN);
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
                MultipleItem n1 = new MultipleItem(MultipleItem.MUKUAI);
                n1.setTitle("大乐透");
                n1.setPubTime("第17140期");
                n1.setContent("10,16,25,26,29,01,05");
                MultipleItem n2 = new MultipleItem(MultipleItem.MUKUAI);
                n2.setTitle("排列三");
                n2.setPubTime("第17326期");
                n2.setContent("7,2,3,4,5,6,7");
                MultipleItem n22 = new MultipleItem(MultipleItem.MUKUAI);
                n22.setTitle("排列五");
                n22.setPubTime("第17326期");
                n22.setContent("7,2,3,1,4,6,7");
                MultipleItem n3 = new MultipleItem(MultipleItem.XINWEN);
                n3.setTitle("一触即发 胜平负'单固'7天猜10场");
                n3.setPubTime("来源：中彩网      2017-12-01");
                n3.setContent("file:///android_asset/page1.html");
                n3.setUrl("file:///android_asset/p2_1.jpg");
                MultipleItem n4 = new MultipleItem(MultipleItem.XINWEN);
                n4.setTitle("北京彩站晒红单 “猜球者”出手现194倍高回报");
                n4.setPubTime("来源：体彩网      2017-12-01");
                n4.setContent("file:///android_asset/page2.html");
                n4.setUrl("file:///android_asset/p2_2.jpg");
                MultipleItem n5 = new MultipleItem(MultipleItem.XINWEN);
                n5.setTitle("竞彩品牌欢歌不断 “魅力竞彩”活动定位兰州");
                n5.setPubTime("来源：网易彩票      2017-11-30");
                n5.setContent("file:///android_asset/page3.html");
                n5.setUrl("file:///android_asset/p10.png");
                MultipleItem n6 = new MultipleItem(MultipleItem.XINWEN);
                n6.setTitle("“魅力竞彩·快乐同行”系列活动相约洛阳");
                n6.setPubTime("来源：网易彩票      2017-11-30");
                n6.setContent("file:///android_asset/page4.html");
                n6.setUrl("file:///android_asset/p2_4.jpg");
                MultipleItem n7 = new MultipleItem(MultipleItem.BANNER);
                n7.setUrl("file:///android_asset/p_bar2.jpg");
                MultipleItem n8 = new MultipleItem(MultipleItem.XINWEN);
                n8.setTitle("湖南长沙业主合力出票 彩民喜中竞彩篮球340万");
                n8.setPubTime("来源：中彩网      2017-11-29");
                n8.setContent("file:///android_asset/page6.html");
                n8.setUrl("file:///android_asset/p2_5.jpg");
                MultipleItem n9 = new MultipleItem(MultipleItem.XINWEN);
                n9.setTitle("提升销量从竞彩入手 业主用坚持换彩民认可");
                n9.setPubTime("来源：体彩网      2017-11-28");
                n9.setContent("file:///android_asset/page8.html");
                n9.setUrl("file:///android_asset/p3.png");
                MultipleItem n10 = new MultipleItem(MultipleItem.XINWEN);
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

    public static List<MultipleItem> getBallData(int p) {
        List<MultipleItem> list = new ArrayList<>();
        MultipleItem rr;
        switch (p) {
            case 1:
                MultipleItem m1 = new MultipleItem(MultipleItem.MUKUAI2);
                m1.setTitle("双色球");
                m1.setPubTime("第17140期");
                m1.setContent("21,22,25,28,29,30,08");
                MultipleItem m2 = new MultipleItem(MultipleItem.MUKUAI2);
                m2.setTitle("双色球");
                m2.setPubTime("第17139期");
                m2.setContent("02,14,20,24,28,32,16");
                MultipleItem m3 = new MultipleItem(MultipleItem.MUKUAI2);
                m3.setTitle("双色球");
                m3.setPubTime("第17138期");
                m3.setContent("01,17,24,28,32,33,02");
                MultipleItem m4 = new MultipleItem(MultipleItem.MUKUAI2);
                m4.setTitle("双色球");
                m4.setPubTime("第17137期");
                m4.setContent("05,10,20,23,26,31,03");
                MultipleItem m5 = new MultipleItem(MultipleItem.MUKUAI2);
                m5.setTitle("双色球");
                m5.setPubTime("第17136期");
                m5.setContent("03,07,10,18,21,24,12");
                MultipleItem m6 = new MultipleItem(MultipleItem.MUKUAI2);
                m6.setTitle("双色球");
                m6.setPubTime("第17135期");
                m6.setContent("01,06,07,14,18,26,16");
                MultipleItem m7 = new MultipleItem(MultipleItem.MUKUAI2);
                m7.setTitle("双色球");
                m7.setPubTime("第17134期");
                m7.setContent("04,05,11,14,28,32,04");
                MultipleItem m8 = new MultipleItem(MultipleItem.MUKUAI2);
                m8.setTitle("双色球");
                m8.setPubTime("第17133期");
                m8.setContent("06,15,11,14,28,32,04");
                MultipleItem m9 = new MultipleItem(MultipleItem.MUKUAI2);
                m9.setTitle("双色球");
                m9.setPubTime("第17132期");
                m9.setContent("02,03,05,09,13,28,11");
                MultipleItem m10 = new MultipleItem(MultipleItem.MUKUAI2);
                m10.setTitle("双色球");
                m10.setPubTime("第17131期");
                m10.setContent("01,07,10,11,26,27,11");
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
                for (int i = 17130; i > 17080; i--) {
                    int[] s = randomCommon(1, 33, 7);
                    rr = new MultipleItem(MultipleItem.MUKUAI2);
                    rr.setTitle("双色球");
                    rr.setPubTime("第" + i + "期");
                    rr.setContent(exchange(s[0]) + "," + exchange(s[1]) + "," + exchange(s[2]) + "," + exchange(s[3]) + "," + exchange(s[4]) + "," + exchange(s[5]) + "," + exchange(s[6]));
                    list.add(rr);
                }
                break;
            case 2:
                MultipleItem n1 = new MultipleItem(MultipleItem.MUKUAI2);
                n1.setTitle("七乐彩");
                n1.setPubTime("第17140期");
                n1.setContent("01,13,20,23,25,26,28");
                MultipleItem n2 = new MultipleItem(MultipleItem.MUKUAI2);
                n2.setTitle("七乐彩");
                n2.setPubTime("第17139期");
                n2.setContent("01,03,05,06,12,13,30");
                MultipleItem n22 = new MultipleItem(MultipleItem.MUKUAI2);
                n22.setTitle("七乐彩");
                n22.setPubTime("第17138期");
                n22.setContent("02,03,04,06,08,09,18");
                MultipleItem n3 = new MultipleItem(MultipleItem.MUKUAI2);
                n3.setTitle("七乐彩");
                n3.setPubTime("第17137期");
                n3.setContent("01,13,15,16,24,25,29");
                MultipleItem n4 = new MultipleItem(MultipleItem.MUKUAI2);
                n4.setTitle("七乐彩");
                n4.setPubTime("第17136期");
                n4.setContent("07,09,11,18,19,21,27");
                MultipleItem n5 = new MultipleItem(MultipleItem.MUKUAI2);
                n5.setTitle("七乐彩");
                n5.setPubTime("第17135期");
                n5.setContent("06,08,19,20,21,25,27");
                MultipleItem n6 = new MultipleItem(MultipleItem.MUKUAI2);
                n6.setTitle("七乐彩");
                n6.setPubTime("第17134期");
                n6.setContent("01,12,04,07,10,16,27");
                MultipleItem n7 = new MultipleItem(MultipleItem.MUKUAI2);
                n7.setTitle("七乐彩");
                n7.setPubTime("第17133期");
                n7.setContent("01,07,11,12,26,27,29");
                MultipleItem n8 = new MultipleItem(MultipleItem.MUKUAI2);
                n8.setTitle("七乐彩");
                n8.setPubTime("第17132期");
                n8.setContent("02,08,16,17,20,23,25");
                list.add(n1);
                list.add(n2);
                list.add(n22);
                list.add(n3);
                list.add(n4);
                list.add(n7);
                list.add(n5);
                list.add(n6);
                list.add(n8);
                for (int i = 17131; i > 17080; i--) {
                    int[] s = randomCommon(1, 33, 7);
                    rr = new MultipleItem(MultipleItem.MUKUAI2);
                    rr.setTitle("七乐彩");
                    rr.setPubTime("第" + i + "期");
                    rr.setContent(exchange(s[0]) + "," + exchange(s[1]) + "," + exchange(s[2]) + "," + exchange(s[3]) + "," + exchange(s[4]) + "," + exchange(s[5]) + "," + exchange(s[6]));
                    list.add(rr);
                }
                break;
            case 3:
                MultipleItem d1 = new MultipleItem(MultipleItem.MUKUAI2);
                d1.setTitle("大乐透");
                d1.setPubTime("第17140期");
                d1.setContent("10,16,25,26,29,01,05");
                MultipleItem d2 = new MultipleItem(MultipleItem.MUKUAI2);
                d2.setTitle("大乐透");
                d2.setPubTime("第17139期");
                d2.setContent("02,06,19,25,32,09,12");
                MultipleItem d3 = new MultipleItem(MultipleItem.MUKUAI2);
                d3.setTitle("大乐透");
                d3.setPubTime("第17138期");
                d3.setContent("04,07,09,20,25,02,11");
                MultipleItem d4 = new MultipleItem(MultipleItem.MUKUAI2);
                d4.setTitle("大乐透");
                d4.setPubTime("第17137期");
                d4.setContent("01,20,22,28,29,05,07");
                MultipleItem d5 = new MultipleItem(MultipleItem.MUKUAI2);
                d5.setTitle("大乐透");
                d5.setPubTime("第17136期");
                d5.setContent("01,11,20,21,22,03,04");
                MultipleItem d6 = new MultipleItem(MultipleItem.MUKUAI2);
                d6.setTitle("大乐透");
                d6.setPubTime("第17135期");
                d6.setContent("01,20,22,28,29,05,07");
                MultipleItem d7 = new MultipleItem(MultipleItem.MUKUAI2);
                d7.setTitle("大乐透");
                d7.setPubTime("第17134期");
                d7.setContent("07,18,19,32,34,02,10");
                MultipleItem d8 = new MultipleItem(MultipleItem.MUKUAI2);
                d8.setTitle("大乐透");
                d8.setPubTime("第17133期");
                d8.setContent("15,17,19,32,33,01,03");
                list.add(d1);
                list.add(d2);
                list.add(d3);
                list.add(d4);
                list.add(d5);
                list.add(d6);
                list.add(d7);
                list.add(d8);
                for (int i = 17132; i > 17080; i--) {
                    int[] s = randomCommon(1, 33, 7);
                    rr = new MultipleItem(MultipleItem.MUKUAI2);
                    rr.setTitle("大乐透");
                    rr.setPubTime("第" + i + "期");
                    rr.setContent(exchange(s[0]) + "," + exchange(s[1]) + "," + exchange(s[2]) + "," + exchange(s[3]) + "," + exchange(s[4]) + "," + exchange(s[5]) + "," + exchange(s[6]));
                    list.add(rr);
                }
                break;
            case 4:
                MultipleItem q1 = new MultipleItem(MultipleItem.MUKUAI2);
                q1.setTitle("七星彩");
                q1.setPubTime("第17140期");
                q1.setContent("0,6,9,1,1,0,7");
                MultipleItem q2 = new MultipleItem(MultipleItem.MUKUAI2);
                q2.setTitle("七星彩");
                q2.setPubTime("第17139期");
                q2.setContent("9,1,7,6,3,1,8");
                MultipleItem q3 = new MultipleItem(MultipleItem.MUKUAI2);
                q3.setTitle("七星彩");
                q3.setPubTime("第17138期");
                q3.setContent("0,2,6,8,6,5,5");
                MultipleItem q4 = new MultipleItem(MultipleItem.MUKUAI2);
                q4.setTitle("七星彩");
                q4.setPubTime("第17137期");
                q4.setContent("3,7,2,9,0,5,4");
                MultipleItem q5 = new MultipleItem(MultipleItem.MUKUAI2);
                q5.setTitle("七星彩");
                q5.setPubTime("第17136期");
                q5.setContent("9,0,4,3,1,8,1");
                MultipleItem q6 = new MultipleItem(MultipleItem.MUKUAI2);
                q6.setTitle("七星彩");
                q6.setPubTime("第17135期");
                q6.setContent("2,3,4,6,9,6,4");
                MultipleItem q7 = new MultipleItem(MultipleItem.MUKUAI2);
                q7.setTitle("七星彩");
                q7.setPubTime("第17134期");
                q7.setContent("1,8,3,7,2,2,6");
                MultipleItem q8 = new MultipleItem(MultipleItem.MUKUAI2);
                q8.setTitle("七星彩");
                q8.setPubTime("第17133期");
                q8.setContent("4,6,2,9,0,9,4");
                list.add(q1);
                list.add(q2);
                list.add(q3);
                list.add(q4);
                list.add(q5);
                list.add(q6);
                list.add(q7);
                list.add(q8);
                for (int i = 17132; i > 17080; i--) {
                    int[] s = randomCommon(1, 10, 7);
                    rr = new MultipleItem(MultipleItem.MUKUAI2);
                    rr.setTitle("七星彩");
                    rr.setPubTime("第" + i + "期");
                    rr.setContent(s[0] + "," + s[1] + "," + s[2] + "," + s[3] + "," + s[4] + "," + s[5] + "," + s[6]);
                    list.add(rr);
                }
                break;
            case 5:
                MultipleItem p1 = new MultipleItem(MultipleItem.MUKUAI2);
                p1.setTitle("排列三");
                p1.setPubTime("第17327期");
                p1.setContent("1,4,5,1,1,0,7");
                MultipleItem p2 = new MultipleItem(MultipleItem.MUKUAI2);
                p2.setTitle("排列三");
                p2.setPubTime("第17326期");
                p2.setContent("7,2,3,6,3,1,8");
                MultipleItem p3 = new MultipleItem(MultipleItem.MUKUAI2);
                p3.setTitle("排列三");
                p3.setPubTime("第17325期");
                p3.setContent("5,0,9,8,6,5,5");
                MultipleItem p4 = new MultipleItem(MultipleItem.MUKUAI2);
                p4.setTitle("排列三");
                p4.setPubTime("第324期");
                p4.setContent("8,2,8,9,0,5,4");
                MultipleItem p5 = new MultipleItem(MultipleItem.MUKUAI2);
                p5.setTitle("排列三");
                p5.setPubTime("第323期");
                p5.setContent("5,7,2,3,1,8,1");
                MultipleItem p6 = new MultipleItem(MultipleItem.MUKUAI2);
                p6.setTitle("排列三");
                p6.setPubTime("第323期");
                p6.setContent("1,7,3,6,9,6,4");
                MultipleItem p7 = new MultipleItem(MultipleItem.MUKUAI2);
                p7.setTitle("排列三");
                p7.setPubTime("第17321期");
                p7.setContent("4,3,5,7,2,2,6");
                MultipleItem p8 = new MultipleItem(MultipleItem.MUKUAI2);
                p8.setTitle("排列三");
                p8.setPubTime("第17320期");
                p8.setContent("0,3,6,9,0,9,4");
                list.add(p1);
                list.add(p2);
                list.add(p3);
                list.add(p4);
                list.add(p5);
                list.add(p6);
                list.add(p7);
                list.add(p8);
                for (int i = 17119; i > 17080; i--) {
                    int[] s = randomCommon(1, 10, 7);
                    rr = new MultipleItem(MultipleItem.MUKUAI2);
                    rr.setTitle("排列三");
                    rr.setPubTime("第" + i + "期");
                    rr.setContent(s[0] + "," + s[1] + "," + s[2] + "," + s[3] + "," + s[4] + "," + s[5] + "," + s[6]);
                    list.add(rr);
                }
                break;
            case 6:
                MultipleItem p15 = new MultipleItem(MultipleItem.MUKUAI2);
                p15.setTitle("排列五");
                p15.setPubTime("第17327期");
                p15.setContent("1,4,5,4,3,0,7");
                MultipleItem p25 = new MultipleItem(MultipleItem.MUKUAI2);
                p25.setTitle("排列五");
                p25.setPubTime("第17326期");
                p25.setContent("7,2,3,1,4,1,8");
                MultipleItem p35 = new MultipleItem(MultipleItem.MUKUAI2);
                p35.setTitle("排列五");
                p35.setPubTime("第17325期");
                p35.setContent("5,0,9,0,8,5,5");
                MultipleItem p45 = new MultipleItem(MultipleItem.MUKUAI2);
                p45.setTitle("排列五");
                p45.setPubTime("第324期");
                p45.setContent("8,2,8,5,8,5,4");
                MultipleItem p55 = new MultipleItem(MultipleItem.MUKUAI2);
                p55.setTitle("排列五");
                p55.setPubTime("第323期");
                p55.setContent("5,7,2,3,6,8,1");
                MultipleItem p65 = new MultipleItem(MultipleItem.MUKUAI2);
                p65.setTitle("排列五");
                p65.setPubTime("第323期");
                p65.setContent("1,7,3,8,3,6,4");
                MultipleItem p75 = new MultipleItem(MultipleItem.MUKUAI2);
                p75.setTitle("排列五");
                p75.setPubTime("第17321期");
                p75.setContent("4,3,5,0,2,2,6");
                MultipleItem p85 = new MultipleItem(MultipleItem.MUKUAI2);
                p85.setTitle("排列五");
                p85.setPubTime("第17320期");
                p85.setContent("0,3,6,3,7,9,4");
                list.add(p15);
                list.add(p25);
                list.add(p35);
                list.add(p45);
                list.add(p55);
                list.add(p65);
                list.add(p75);
                list.add(p85);
                for (int i = 17119; i > 17080; i--) {
                    int[] s = randomCommon(1, 10, 7);
                    rr = new MultipleItem(MultipleItem.MUKUAI2);
                    rr.setTitle("排列五");
                    rr.setPubTime("第" + i + "期");
                    rr.setContent(s[0] + "," + s[1] + "," + s[2] + "," + s[3] + "," + s[4] + "," + s[5] + "," + s[6]);
                    list.add(rr);
                }
                break;
            case 7:
                MultipleItem k1 = new MultipleItem(MultipleItem.MUKUAI2);
                k1.setTitle("快三");
                k1.setPubTime("第171201011期");
                k1.setContent("1,2,3,1,1,0,7");
                MultipleItem k2 = new MultipleItem(MultipleItem.MUKUAI2);
                k2.setTitle("快三");
                k2.setPubTime("第171201010期");
                k2.setContent("1,2,2,6,3,1,8");
                MultipleItem k3 = new MultipleItem(MultipleItem.MUKUAI2);
                k3.setTitle("快三");
                k3.setPubTime("第171201009期");
                k3.setContent("4,4,6,8,6,5,5");
                MultipleItem k4 = new MultipleItem(MultipleItem.MUKUAI2);
                k4.setTitle("快三");
                k4.setPubTime("第171201008期");
                k4.setContent("1,3,6,9,0,5,4");
                MultipleItem k5 = new MultipleItem(MultipleItem.MUKUAI2);
                k5.setTitle("快三");
                k5.setPubTime("第171201007期");
                k5.setContent("1,2,5,3,1,8,1");
                MultipleItem k6 = new MultipleItem(MultipleItem.MUKUAI2);
                k6.setTitle("快三");
                k6.setPubTime("第171201006期");
                k6.setContent("1,3,5,6,9,6,4");
                MultipleItem k7 = new MultipleItem(MultipleItem.MUKUAI2);
                k7.setTitle("快三");
                k7.setPubTime("第171201005期");
                k7.setContent("3,4,5,7,2,2,6");
                MultipleItem k8 = new MultipleItem(MultipleItem.MUKUAI2);
                k8.setTitle("快三");
                k8.setPubTime("第171201004期");
                k8.setContent("2,4,5,9,0,9,4");
                list.add(k1);
                list.add(k2);
                list.add(k3);
                list.add(k4);
                list.add(k5);
                list.add(k6);
                list.add(k7);
                list.add(k8);
                for (int i = 1004; i > 960; i--) {
                    int[] s = randomCommon(1, 10, 7);
                    rr = new MultipleItem(MultipleItem.MUKUAI2);
                    rr.setTitle("快三");
                    rr.setPubTime("第17120" + i + "期");
                    rr.setContent(s[0] + "," + s[1] + "," + s[2] + "," + s[3] + "," + s[4] + "," + s[5] + "," + s[6]);
                    list.add(rr);
                }
                break;
            case 8:
                MultipleItem x1 = new MultipleItem(MultipleItem.MUKUAI2);
                x1.setTitle("11选5");
                x1.setPubTime("第17120108期");
                x1.setContent("08,06,01,10,02,0,7");
                MultipleItem x2 = new MultipleItem(MultipleItem.MUKUAI2);
                x2.setTitle("11选5");
                x2.setPubTime("第17120107期");
                x2.setContent("08,10,11,01,05,1,8");
                MultipleItem x3 = new MultipleItem(MultipleItem.MUKUAI2);
                x3.setTitle("11选5");
                x3.setPubTime("第17120106期");
                x3.setContent("01,05,11,02,03,5,5");
                MultipleItem x4 = new MultipleItem(MultipleItem.MUKUAI2);
                x4.setTitle("11选5");
                x4.setPubTime("第17120105期");
                x4.setContent("01,03,06,09,11,5,4");
                MultipleItem x5 = new MultipleItem(MultipleItem.MUKUAI2);
                x5.setTitle("11选5");
                x5.setPubTime("第17120104期");
                x5.setContent("11,04,02,07,09,8,1");
                MultipleItem x6 = new MultipleItem(MultipleItem.MUKUAI2);
                x6.setTitle("11选5");
                x6.setPubTime("第17120103期");
                x6.setContent("02,10,04,08,09,6,4");
                MultipleItem x7 = new MultipleItem(MultipleItem.MUKUAI2);
                x7.setTitle("11选5");
                x7.setPubTime("第17120102期");
                x7.setContent("01,11,10,07,09,2,6");
                MultipleItem x8 = new MultipleItem(MultipleItem.MUKUAI2);
                x8.setTitle("11选5");
                x8.setPubTime("第17120101期");
                x8.setContent("02,10,04,08,09,9,4");
                list.add(x1);
                list.add(x2);
                list.add(x3);
                list.add(x4);
                list.add(x5);
                list.add(x6);
                list.add(x7);
                list.add(x8);
                for (int i = 17120101; i > 17120050; i--) {
                    int[] s = randomCommon(1, 10, 7);
                    rr = new MultipleItem(MultipleItem.MUKUAI2);
                    rr.setTitle("11选5");
                    rr.setPubTime("第" + i + "期");
                    rr.setContent(exchange(s[0]) + "," + exchange(s[1]) + "," + exchange(s[2]) + "," + exchange(s[3]) + "," + exchange(s[4]) + "," + exchange(s[5]) + "," + exchange(s[6]));
                    list.add(rr);
                }
                break;
        }
        return list;
    }

    private static String exchange(int n) {
        String s = String.valueOf(n);
        if (s.length() == 1) {
            return "0" + s;
        }
        return s;
    }


    public static int[] randomCommon(int min, int max, int n) {
        if (n > (max - min + 1) || max < min) {
            return null;
        }
        int[] result = new int[n];
        int count = 0;
        while (count < n) {
            int num = (int) (Math.random() * (max - min)) + min;
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (num == result[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result[count] = num;
                count++;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
