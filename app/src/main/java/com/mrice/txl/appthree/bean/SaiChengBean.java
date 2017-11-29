package com.mrice.txl.appthree.bean;

import com.mrice.txl.appthree.http.ParamNames;

import java.io.Serializable;
import java.util.List;

/**
 * Created by cai on 2017/8/27.
 */

public class SaiChengBean implements Serializable {
    /**
     * reason : 查询成功
     * result : {"key":"法甲","tabs":{"saicheng1":"第17轮赛程","saicheng2":"第18轮赛程","saicheng3":null,"jifenbang":"积分榜","sheshoubang":"射手榜"},"views":{"saicheng1":[{"c1":"未开赛","c2":"12-06周六","c3":"03:30","c4R":"VS","c4T1":"图卢兹","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=486","c4T2":"摩纳哥","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=317","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111967"},{"c1":"未开赛","c2":"12-07周日","c3":"00:00","c4R":"VS","c4T1":"巴黎圣日耳曼","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=316","c4T2":"南特","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=480","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111963"},{"c1":"未开赛","c2":"12-07周日","c3":"03:00","c4R":"VS","c4T1":"波尔多","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=476","c4T2":"洛里昂","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=1385","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111958"},{"c1":"未开赛","c2":"12-07周日","c3":"03:00","c4R":"VS","c4T1":"卡昂","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=10165","c4T2":"尼斯","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=3165","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111959"},{"c1":"未开赛","c2":"12-07周日","c3":"03:00","c4R":"VS","c4T1":"雷恩","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=477","c4T2":"蒙彼利埃","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=1626","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111965"},{"c1":"未开赛","c2":"12-07周日","c3":"03:00","c4R":"VS","c4T1":"圣埃蒂安","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=483","c4T2":"巴斯蒂亚","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=376","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111966"},{"c1":"未开赛","c2":"12-07周日","c3":"21:00","c4R":"VS","c4T1":"埃维昂","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=35151","c4T2":"里昂","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=436","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111960"},{"c1":"未开赛","c2":"12-08周一","c3":"00:00","c4R":"VS","c4T1":"朗斯","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=396","c4T2":"里尔","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=456","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111961"},{"c1":"未开赛","c2":"12-08周一","c3":"00:00","c4R":"VS","c4T1":"兰斯","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=13205","c4T2":"甘冈","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=416","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111964"},{"c1":"未开赛","c2":"12-08周一","c3":"04:00","c4R":"VS","c4T1":"马赛","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=478","c4T2":"梅斯","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=479","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111962"}],"saicheng2":[{"c1":"未开赛","c2":"12-13周六","c3":"03:30","c4R":"VS","c4T1":"里昂","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=436","c4T2":"卡昂","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=10165","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111972"},{"c1":"未开赛","c2":"12-14周日","c3":"00:00","c4R":"VS","c4T1":"南特","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=480","c4T2":"波尔多","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=476","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111975"},{"c1":"未开赛","c2":"12-14周日","c3":"03:00","c4R":"VS","c4T1":"巴斯蒂亚","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=376","c4T2":"雷恩","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=477","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111968"},{"c1":"未开赛","c2":"12-14周日","c3":"03:00","c4R":"VS","c4T1":"洛里昂","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=1385","c4T2":"梅斯","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=479","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111971"},{"c1":"未开赛","c2":"12-14周日","c3":"03:00","c4R":"VS","c4T1":"蒙彼利埃","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=1626","c4T2":"朗斯","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=396","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111974"},{"c1":"未开赛","c2":"12-14周日","c3":"03:00","c4R":"VS","c4T1":"兰斯","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=13205","c4T2":"埃维昂","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=35151","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111977"},{"c1":"未开赛","c2":"12-14周日","c3":"21:00","c4R":"VS","c4T1":"尼斯","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=3165","c4T2":"圣埃蒂安","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=483","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111976"},{"c1":"未开赛","c2":"12-15周一","c3":"00:00","c4R":"VS","c4T1":"甘冈","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=416","c4T2":"巴黎圣日耳曼","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=316","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111969"},{"c1":"未开赛","c2":"12-15周一","c3":"00:00","c4R":"VS","c4T1":"里尔","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=456","c4T2":"图卢兹","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=486","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111970"},{"c1":"未开赛","c2":"12-15周一","c3":"04:00","c4R":"VS","c4T1":"摩纳哥","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=317","c4T2":"马赛","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=478","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111973"}],"saicheng3":null,"jifenbang":[{"c1":"1","c2":"马赛","c2L":"http://match.sports.sina.com.cn/football/team.php?id=478","c3":"16","c41":"11","c42":"2","c43":"3","c5":"19","c6":"35"},{"c1":"2","c2":"巴黎圣日耳曼","c2L":"http://match.sports.sina.com.cn/football/team.php?id=316","c3":"16","c41":"9","c42":"7","c43":"0","c5":"19","c6":"34"},{"c1":"3","c2":"圣埃蒂安","c2L":"http://match.sports.sina.com.cn/football/team.php?id=483","c3":"16","c41":"8","c42":"5","c43":"3","c5":"6","c6":"29"},{"c1":"4","c2":"雷恩","c2L":"http://match.sports.sina.com.cn/football/team.php?id=477","c3":"16","c41":"8","c42":"4","c43":"4","c5":"5","c6":"28"},{"c1":"5","c2":"波尔多","c2L":"http://match.sports.sina.com.cn/football/team.php?id=476","c3":"16","c41":"8","c42":"4","c43":"4","c5":"4","c6":"28"},{"c1":"6","c2":"里昂","c2L":"http://match.sports.sina.com.cn/football/team.php?id=436","c3":"15","c41":"8","c42":"3","c43":"4","c5":"13","c6":"27"},{"c1":"7","c2":"南特","c2L":"http://match.sports.sina.com.cn/football/team.php?id=480","c3":"16","c41":"6","c42":"6","c43":"4","c5":"1","c6":"24"},{"c1":"8","c2":"摩纳哥","c2L":"http://match.sports.sina.com.cn/football/team.php?id=317","c3":"16","c41":"6","c42":"5","c43":"5","c5":"1","c6":"23"},{"c1":"9","c2":"兰斯","c2L":"http://match.sports.sina.com.cn/football/team.php?id=13205","c3":"15","c41":"6","c42":"4","c43":"5","c5":"-6","c6":"22"},{"c1":"10","c2":"蒙彼利埃","c2L":"http://match.sports.sina.com.cn/football/team.php?id=1626","c3":"16","c41":"6","c42":"3","c43":"7","c5":"-2","c6":"21"}],"sheshoubang":[{"c1":"1","c2":"拉卡泽特","c2L":"http://match.sports.sina.com.cn/football/player.php?id=59966","c3":"里昂","c3L":"http://match.sports.sina.com.cn/football/team.php?id=436","c4":"11","c5":"1"},{"c1":"2","c2":"吉尼亚克","c2L":"http://match.sports.sina.com.cn/football/player.php?id=37827","c3":"马赛","c3L":"http://match.sports.sina.com.cn/football/team.php?id=478","c4":"11","c5":"1"},{"c1":"3","c2":"马迪巴","c2L":"http://match.sports.sina.com.cn/football/player.php?id=90126","c3":"雷恩","c3L":"http://match.sports.sina.com.cn/football/team.php?id=477","c4":"7","c5":"0"},{"c1":"4","c2":"沃斯","c2L":"http://match.sports.sina.com.cn/football/player.php?id=56624","c3":"埃维昂","c3L":"http://match.sports.sina.com.cn/football/team.php?id=35151","c4":"7","c5":"1"},{"c1":"5","c2":"本耶德尔","c2L":"http://match.sports.sina.com.cn/football/player.php?id=83912","c3":"图卢兹","c3L":"http://match.sports.sina.com.cn/football/team.php?id=486","c4":"7","c5":"1"},{"c1":"6","c2":"卡瓦尼","c2L":"http://match.sports.sina.com.cn/football/player.php?id=40720","c3":"巴黎圣日耳曼","c3L":"http://match.sports.sina.com.cn/football/team.php?id=316","c4":"7","c5":"1"},{"c1":"7","c2":"米奎尔-洛佩斯","c2L":"http://match.sports.sina.com.cn/football/player.php?id=166552","c3":"里昂","c3L":"http://match.sports.sina.com.cn/football/team.php?id=436","c4":"6","c5":"0"},{"c1":"8","c2":"爱德华多","c2L":"http://match.sports.sina.com.cn/football/player.php?id=61841","c3":"尼斯","c3L":"http://match.sports.sina.com.cn/football/team.php?id=3165","c4":"6","c5":"0"},{"c1":"9","c2":"伊布拉希莫维奇","c2L":"http://match.sports.sina.com.cn/football/player.php?id=9808","c3":"巴黎圣日耳曼","c3L":"http://match.sports.sina.com.cn/football/team.php?id=316","c4":"6","c5":"1"},{"c1":"10","c2":"迪亚巴特","c2L":"http://match.sports.sina.com.cn/football/player.php?id=33103","c3":"波尔多","c3L":"http://match.sports.sina.com.cn/football/team.php?id=476","c4":"6","c5":"2"}]}}
     * error_code : 0
     */
    @ParamNames("reason")
    private String reason;
    @ParamNames("result")
    private ResultBean result;
    @ParamNames("error_code")
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean implements Serializable {
        /**
         * key : 法甲
         * tabs : {"saicheng1":"第17轮赛程","saicheng2":"第18轮赛程","saicheng3":null,"jifenbang":"积分榜","sheshoubang":"射手榜"}
         * views : {"saicheng1":[{"c1":"未开赛","c2":"12-06周六","c3":"03:30","c4R":"VS","c4T1":"图卢兹","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=486","c4T2":"摩纳哥","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=317","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111967"},{"c1":"未开赛","c2":"12-07周日","c3":"00:00","c4R":"VS","c4T1":"巴黎圣日耳曼","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=316","c4T2":"南特","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=480","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111963"},{"c1":"未开赛","c2":"12-07周日","c3":"03:00","c4R":"VS","c4T1":"波尔多","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=476","c4T2":"洛里昂","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=1385","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111958"},{"c1":"未开赛","c2":"12-07周日","c3":"03:00","c4R":"VS","c4T1":"卡昂","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=10165","c4T2":"尼斯","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=3165","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111959"},{"c1":"未开赛","c2":"12-07周日","c3":"03:00","c4R":"VS","c4T1":"雷恩","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=477","c4T2":"蒙彼利埃","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=1626","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111965"},{"c1":"未开赛","c2":"12-07周日","c3":"03:00","c4R":"VS","c4T1":"圣埃蒂安","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=483","c4T2":"巴斯蒂亚","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=376","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111966"},{"c1":"未开赛","c2":"12-07周日","c3":"21:00","c4R":"VS","c4T1":"埃维昂","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=35151","c4T2":"里昂","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=436","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111960"},{"c1":"未开赛","c2":"12-08周一","c3":"00:00","c4R":"VS","c4T1":"朗斯","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=396","c4T2":"里尔","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=456","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111961"},{"c1":"未开赛","c2":"12-08周一","c3":"00:00","c4R":"VS","c4T1":"兰斯","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=13205","c4T2":"甘冈","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=416","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111964"},{"c1":"未开赛","c2":"12-08周一","c3":"04:00","c4R":"VS","c4T1":"马赛","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=478","c4T2":"梅斯","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=479","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111962"}],"saicheng2":[{"c1":"未开赛","c2":"12-13周六","c3":"03:30","c4R":"VS","c4T1":"里昂","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=436","c4T2":"卡昂","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=10165","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111972"},{"c1":"未开赛","c2":"12-14周日","c3":"00:00","c4R":"VS","c4T1":"南特","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=480","c4T2":"波尔多","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=476","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111975"},{"c1":"未开赛","c2":"12-14周日","c3":"03:00","c4R":"VS","c4T1":"巴斯蒂亚","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=376","c4T2":"雷恩","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=477","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111968"},{"c1":"未开赛","c2":"12-14周日","c3":"03:00","c4R":"VS","c4T1":"洛里昂","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=1385","c4T2":"梅斯","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=479","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111971"},{"c1":"未开赛","c2":"12-14周日","c3":"03:00","c4R":"VS","c4T1":"蒙彼利埃","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=1626","c4T2":"朗斯","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=396","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111974"},{"c1":"未开赛","c2":"12-14周日","c3":"03:00","c4R":"VS","c4T1":"兰斯","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=13205","c4T2":"埃维昂","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=35151","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111977"},{"c1":"未开赛","c2":"12-14周日","c3":"21:00","c4R":"VS","c4T1":"尼斯","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=3165","c4T2":"圣埃蒂安","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=483","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111976"},{"c1":"未开赛","c2":"12-15周一","c3":"00:00","c4R":"VS","c4T1":"甘冈","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=416","c4T2":"巴黎圣日耳曼","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=316","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111969"},{"c1":"未开赛","c2":"12-15周一","c3":"00:00","c4R":"VS","c4T1":"里尔","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=456","c4T2":"图卢兹","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=486","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111970"},{"c1":"未开赛","c2":"12-15周一","c3":"04:00","c4R":"VS","c4T1":"摩纳哥","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=317","c4T2":"马赛","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=478","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111973"}],"saicheng3":null,"jifenbang":[{"c1":"1","c2":"马赛","c2L":"http://match.sports.sina.com.cn/football/team.php?id=478","c3":"16","c41":"11","c42":"2","c43":"3","c5":"19","c6":"35"},{"c1":"2","c2":"巴黎圣日耳曼","c2L":"http://match.sports.sina.com.cn/football/team.php?id=316","c3":"16","c41":"9","c42":"7","c43":"0","c5":"19","c6":"34"},{"c1":"3","c2":"圣埃蒂安","c2L":"http://match.sports.sina.com.cn/football/team.php?id=483","c3":"16","c41":"8","c42":"5","c43":"3","c5":"6","c6":"29"},{"c1":"4","c2":"雷恩","c2L":"http://match.sports.sina.com.cn/football/team.php?id=477","c3":"16","c41":"8","c42":"4","c43":"4","c5":"5","c6":"28"},{"c1":"5","c2":"波尔多","c2L":"http://match.sports.sina.com.cn/football/team.php?id=476","c3":"16","c41":"8","c42":"4","c43":"4","c5":"4","c6":"28"},{"c1":"6","c2":"里昂","c2L":"http://match.sports.sina.com.cn/football/team.php?id=436","c3":"15","c41":"8","c42":"3","c43":"4","c5":"13","c6":"27"},{"c1":"7","c2":"南特","c2L":"http://match.sports.sina.com.cn/football/team.php?id=480","c3":"16","c41":"6","c42":"6","c43":"4","c5":"1","c6":"24"},{"c1":"8","c2":"摩纳哥","c2L":"http://match.sports.sina.com.cn/football/team.php?id=317","c3":"16","c41":"6","c42":"5","c43":"5","c5":"1","c6":"23"},{"c1":"9","c2":"兰斯","c2L":"http://match.sports.sina.com.cn/football/team.php?id=13205","c3":"15","c41":"6","c42":"4","c43":"5","c5":"-6","c6":"22"},{"c1":"10","c2":"蒙彼利埃","c2L":"http://match.sports.sina.com.cn/football/team.php?id=1626","c3":"16","c41":"6","c42":"3","c43":"7","c5":"-2","c6":"21"}],"sheshoubang":[{"c1":"1","c2":"拉卡泽特","c2L":"http://match.sports.sina.com.cn/football/player.php?id=59966","c3":"里昂","c3L":"http://match.sports.sina.com.cn/football/team.php?id=436","c4":"11","c5":"1"},{"c1":"2","c2":"吉尼亚克","c2L":"http://match.sports.sina.com.cn/football/player.php?id=37827","c3":"马赛","c3L":"http://match.sports.sina.com.cn/football/team.php?id=478","c4":"11","c5":"1"},{"c1":"3","c2":"马迪巴","c2L":"http://match.sports.sina.com.cn/football/player.php?id=90126","c3":"雷恩","c3L":"http://match.sports.sina.com.cn/football/team.php?id=477","c4":"7","c5":"0"},{"c1":"4","c2":"沃斯","c2L":"http://match.sports.sina.com.cn/football/player.php?id=56624","c3":"埃维昂","c3L":"http://match.sports.sina.com.cn/football/team.php?id=35151","c4":"7","c5":"1"},{"c1":"5","c2":"本耶德尔","c2L":"http://match.sports.sina.com.cn/football/player.php?id=83912","c3":"图卢兹","c3L":"http://match.sports.sina.com.cn/football/team.php?id=486","c4":"7","c5":"1"},{"c1":"6","c2":"卡瓦尼","c2L":"http://match.sports.sina.com.cn/football/player.php?id=40720","c3":"巴黎圣日耳曼","c3L":"http://match.sports.sina.com.cn/football/team.php?id=316","c4":"7","c5":"1"},{"c1":"7","c2":"米奎尔-洛佩斯","c2L":"http://match.sports.sina.com.cn/football/player.php?id=166552","c3":"里昂","c3L":"http://match.sports.sina.com.cn/football/team.php?id=436","c4":"6","c5":"0"},{"c1":"8","c2":"爱德华多","c2L":"http://match.sports.sina.com.cn/football/player.php?id=61841","c3":"尼斯","c3L":"http://match.sports.sina.com.cn/football/team.php?id=3165","c4":"6","c5":"0"},{"c1":"9","c2":"伊布拉希莫维奇","c2L":"http://match.sports.sina.com.cn/football/player.php?id=9808","c3":"巴黎圣日耳曼","c3L":"http://match.sports.sina.com.cn/football/team.php?id=316","c4":"6","c5":"1"},{"c1":"10","c2":"迪亚巴特","c2L":"http://match.sports.sina.com.cn/football/player.php?id=33103","c3":"波尔多","c3L":"http://match.sports.sina.com.cn/football/team.php?id=476","c4":"6","c5":"2"}]}
         */
        @ParamNames("key")
        private String key;
        @ParamNames("tabs")
        private TabsBean tabs;
        @ParamNames("views")
        private ViewsBean views;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public TabsBean getTabs() {
            return tabs;
        }

        public void setTabs(TabsBean tabs) {
            this.tabs = tabs;
        }

        public ViewsBean getViews() {
            return views;
        }

        public void setViews(ViewsBean views) {
            this.views = views;
        }

        public static class TabsBean implements Serializable {
            /**
             * saicheng1 : 第17轮赛程
             * saicheng2 : 第18轮赛程
             * saicheng3 : null
             * jifenbang : 积分榜
             * sheshoubang : 射手榜
             */
            @ParamNames("saicheng1")
            private String saicheng1;
            @ParamNames("saicheng2")
            private String saicheng2;
            @ParamNames("saicheng3")
            private Object saicheng3;
            @ParamNames("jifenbang")
            private String jifenbang;
            @ParamNames("sheshoubang")
            private String sheshoubang;

            public String getSaicheng1() {
                return saicheng1;
            }

            public void setSaicheng1(String saicheng1) {
                this.saicheng1 = saicheng1;
            }

            public String getSaicheng2() {
                return saicheng2;
            }

            public void setSaicheng2(String saicheng2) {
                this.saicheng2 = saicheng2;
            }

            public Object getSaicheng3() {
                return saicheng3;
            }

            public void setSaicheng3(Object saicheng3) {
                this.saicheng3 = saicheng3;
            }

            public String getJifenbang() {
                return jifenbang;
            }

            public void setJifenbang(String jifenbang) {
                this.jifenbang = jifenbang;
            }

            public String getSheshoubang() {
                return sheshoubang;
            }

            public void setSheshoubang(String sheshoubang) {
                this.sheshoubang = sheshoubang;
            }
        }

        public static class ViewsBean {
            /**
             * saicheng1 : [{"c1":"未开赛","c2":"12-06周六","c3":"03:30","c4R":"VS","c4T1":"图卢兹","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=486","c4T2":"摩纳哥","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=317","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111967"},{"c1":"未开赛","c2":"12-07周日","c3":"00:00","c4R":"VS","c4T1":"巴黎圣日耳曼","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=316","c4T2":"南特","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=480","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111963"},{"c1":"未开赛","c2":"12-07周日","c3":"03:00","c4R":"VS","c4T1":"波尔多","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=476","c4T2":"洛里昂","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=1385","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111958"},{"c1":"未开赛","c2":"12-07周日","c3":"03:00","c4R":"VS","c4T1":"卡昂","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=10165","c4T2":"尼斯","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=3165","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111959"},{"c1":"未开赛","c2":"12-07周日","c3":"03:00","c4R":"VS","c4T1":"雷恩","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=477","c4T2":"蒙彼利埃","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=1626","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111965"},{"c1":"未开赛","c2":"12-07周日","c3":"03:00","c4R":"VS","c4T1":"圣埃蒂安","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=483","c4T2":"巴斯蒂亚","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=376","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111966"},{"c1":"未开赛","c2":"12-07周日","c3":"21:00","c4R":"VS","c4T1":"埃维昂","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=35151","c4T2":"里昂","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=436","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111960"},{"c1":"未开赛","c2":"12-08周一","c3":"00:00","c4R":"VS","c4T1":"朗斯","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=396","c4T2":"里尔","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=456","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111961"},{"c1":"未开赛","c2":"12-08周一","c3":"00:00","c4R":"VS","c4T1":"兰斯","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=13205","c4T2":"甘冈","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=416","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111964"},{"c1":"未开赛","c2":"12-08周一","c3":"04:00","c4R":"VS","c4T1":"马赛","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=478","c4T2":"梅斯","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=479","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111962"}]
             * saicheng2 : [{"c1":"未开赛","c2":"12-13周六","c3":"03:30","c4R":"VS","c4T1":"里昂","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=436","c4T2":"卡昂","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=10165","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111972"},{"c1":"未开赛","c2":"12-14周日","c3":"00:00","c4R":"VS","c4T1":"南特","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=480","c4T2":"波尔多","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=476","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111975"},{"c1":"未开赛","c2":"12-14周日","c3":"03:00","c4R":"VS","c4T1":"巴斯蒂亚","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=376","c4T2":"雷恩","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=477","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111968"},{"c1":"未开赛","c2":"12-14周日","c3":"03:00","c4R":"VS","c4T1":"洛里昂","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=1385","c4T2":"梅斯","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=479","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111971"},{"c1":"未开赛","c2":"12-14周日","c3":"03:00","c4R":"VS","c4T1":"蒙彼利埃","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=1626","c4T2":"朗斯","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=396","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111974"},{"c1":"未开赛","c2":"12-14周日","c3":"03:00","c4R":"VS","c4T1":"兰斯","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=13205","c4T2":"埃维昂","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=35151","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111977"},{"c1":"未开赛","c2":"12-14周日","c3":"21:00","c4R":"VS","c4T1":"尼斯","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=3165","c4T2":"圣埃蒂安","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=483","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111976"},{"c1":"未开赛","c2":"12-15周一","c3":"00:00","c4R":"VS","c4T1":"甘冈","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=416","c4T2":"巴黎圣日耳曼","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=316","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111969"},{"c1":"未开赛","c2":"12-15周一","c3":"00:00","c4R":"VS","c4T1":"里尔","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=456","c4T2":"图卢兹","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=486","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111970"},{"c1":"未开赛","c2":"12-15周一","c3":"04:00","c4R":"VS","c4T1":"摩纳哥","c4T1URL":"http://match.sports.sina.com.cn/football/team.php?id=317","c4T2":"马赛","c4T2URL":"http://match.sports.sina.com.cn/football/team.php?id=478","c51":"视频暂无","c51Link":"","c52":"图文直播","c52Link":"http://match.sports.sina.com.cn/livecast/g/live.php?id=111973"}]
             * saicheng3 : null
             * jifenbang : [{"c1":"1","c2":"马赛","c2L":"http://match.sports.sina.com.cn/football/team.php?id=478","c3":"16","c41":"11","c42":"2","c43":"3","c5":"19","c6":"35"},{"c1":"2","c2":"巴黎圣日耳曼","c2L":"http://match.sports.sina.com.cn/football/team.php?id=316","c3":"16","c41":"9","c42":"7","c43":"0","c5":"19","c6":"34"},{"c1":"3","c2":"圣埃蒂安","c2L":"http://match.sports.sina.com.cn/football/team.php?id=483","c3":"16","c41":"8","c42":"5","c43":"3","c5":"6","c6":"29"},{"c1":"4","c2":"雷恩","c2L":"http://match.sports.sina.com.cn/football/team.php?id=477","c3":"16","c41":"8","c42":"4","c43":"4","c5":"5","c6":"28"},{"c1":"5","c2":"波尔多","c2L":"http://match.sports.sina.com.cn/football/team.php?id=476","c3":"16","c41":"8","c42":"4","c43":"4","c5":"4","c6":"28"},{"c1":"6","c2":"里昂","c2L":"http://match.sports.sina.com.cn/football/team.php?id=436","c3":"15","c41":"8","c42":"3","c43":"4","c5":"13","c6":"27"},{"c1":"7","c2":"南特","c2L":"http://match.sports.sina.com.cn/football/team.php?id=480","c3":"16","c41":"6","c42":"6","c43":"4","c5":"1","c6":"24"},{"c1":"8","c2":"摩纳哥","c2L":"http://match.sports.sina.com.cn/football/team.php?id=317","c3":"16","c41":"6","c42":"5","c43":"5","c5":"1","c6":"23"},{"c1":"9","c2":"兰斯","c2L":"http://match.sports.sina.com.cn/football/team.php?id=13205","c3":"15","c41":"6","c42":"4","c43":"5","c5":"-6","c6":"22"},{"c1":"10","c2":"蒙彼利埃","c2L":"http://match.sports.sina.com.cn/football/team.php?id=1626","c3":"16","c41":"6","c42":"3","c43":"7","c5":"-2","c6":"21"}]
             * sheshoubang : [{"c1":"1","c2":"拉卡泽特","c2L":"http://match.sports.sina.com.cn/football/player.php?id=59966","c3":"里昂","c3L":"http://match.sports.sina.com.cn/football/team.php?id=436","c4":"11","c5":"1"},{"c1":"2","c2":"吉尼亚克","c2L":"http://match.sports.sina.com.cn/football/player.php?id=37827","c3":"马赛","c3L":"http://match.sports.sina.com.cn/football/team.php?id=478","c4":"11","c5":"1"},{"c1":"3","c2":"马迪巴","c2L":"http://match.sports.sina.com.cn/football/player.php?id=90126","c3":"雷恩","c3L":"http://match.sports.sina.com.cn/football/team.php?id=477","c4":"7","c5":"0"},{"c1":"4","c2":"沃斯","c2L":"http://match.sports.sina.com.cn/football/player.php?id=56624","c3":"埃维昂","c3L":"http://match.sports.sina.com.cn/football/team.php?id=35151","c4":"7","c5":"1"},{"c1":"5","c2":"本耶德尔","c2L":"http://match.sports.sina.com.cn/football/player.php?id=83912","c3":"图卢兹","c3L":"http://match.sports.sina.com.cn/football/team.php?id=486","c4":"7","c5":"1"},{"c1":"6","c2":"卡瓦尼","c2L":"http://match.sports.sina.com.cn/football/player.php?id=40720","c3":"巴黎圣日耳曼","c3L":"http://match.sports.sina.com.cn/football/team.php?id=316","c4":"7","c5":"1"},{"c1":"7","c2":"米奎尔-洛佩斯","c2L":"http://match.sports.sina.com.cn/football/player.php?id=166552","c3":"里昂","c3L":"http://match.sports.sina.com.cn/football/team.php?id=436","c4":"6","c5":"0"},{"c1":"8","c2":"爱德华多","c2L":"http://match.sports.sina.com.cn/football/player.php?id=61841","c3":"尼斯","c3L":"http://match.sports.sina.com.cn/football/team.php?id=3165","c4":"6","c5":"0"},{"c1":"9","c2":"伊布拉希莫维奇","c2L":"http://match.sports.sina.com.cn/football/player.php?id=9808","c3":"巴黎圣日耳曼","c3L":"http://match.sports.sina.com.cn/football/team.php?id=316","c4":"6","c5":"1"},{"c1":"10","c2":"迪亚巴特","c2L":"http://match.sports.sina.com.cn/football/player.php?id=33103","c3":"波尔多","c3L":"http://match.sports.sina.com.cn/football/team.php?id=476","c4":"6","c5":"2"}]
             */
            @ParamNames("saicheng3")
            private Object saicheng3;
            @ParamNames("saicheng1")
            private List<Saicheng1Bean> saicheng1;
            @ParamNames("saicheng2")
            private List<Saicheng2Bean> saicheng2;
            @ParamNames("jifenbang")
            private List<JifenbangBean> jifenbang;
            @ParamNames("sheshoubang")
            private List<SheshoubangBean> sheshoubang;

            public Object getSaicheng3() {
                return saicheng3;
            }

            public void setSaicheng3(Object saicheng3) {
                this.saicheng3 = saicheng3;
            }

            public List<Saicheng1Bean> getSaicheng1() {
                return saicheng1;
            }

            public void setSaicheng1(List<Saicheng1Bean> saicheng1) {
                this.saicheng1 = saicheng1;
            }

            public List<Saicheng2Bean> getSaicheng2() {
                return saicheng2;
            }

            public void setSaicheng2(List<Saicheng2Bean> saicheng2) {
                this.saicheng2 = saicheng2;
            }

            public List<JifenbangBean> getJifenbang() {
                return jifenbang;
            }

            public void setJifenbang(List<JifenbangBean> jifenbang) {
                this.jifenbang = jifenbang;
            }

            public List<SheshoubangBean> getSheshoubang() {
                return sheshoubang;
            }

            public void setSheshoubang(List<SheshoubangBean> sheshoubang) {
                this.sheshoubang = sheshoubang;
            }

            public static class Saicheng1Bean implements Serializable {
                /**
                 * c1 : 未开赛
                 * c2 : 12-06周六
                 * c3 : 03:30
                 * c4R : VS
                 * c4T1 : 图卢兹
                 * c4T1URL : http://match.sports.sina.com.cn/football/team.php?id=486
                 * c4T2 : 摩纳哥
                 * c4T2URL : http://match.sports.sina.com.cn/football/team.php?id=317
                 * c51 : 视频暂无
                 * c51Link :
                 * c52 : 图文直播
                 * c52Link : http://match.sports.sina.com.cn/livecast/g/live.php?id=111967
                 */
                @ParamNames("c1")
                private String c1;
                @ParamNames("c2")
                private String c2;
                @ParamNames("c3")
                private String c3;
                @ParamNames("c4R")
                private String c4R;
                @ParamNames("c4T1")
                private String c4T1;
                @ParamNames("c4T1URL")
                private String c4T1URL;
                @ParamNames("c4T2")
                private String c4T2;
                @ParamNames("c4T2URL")
                private String c4T2URL;
                @ParamNames("c51")
                private String c51;
                @ParamNames("c51Link")
                private String c51Link;
                @ParamNames("c52")
                private String c52;
                @ParamNames("c52Link")
                private String c52Link;

                public String getC1() {
                    return c1;
                }

                public void setC1(String c1) {
                    this.c1 = c1;
                }

                public String getC2() {
                    return c2;
                }

                public void setC2(String c2) {
                    this.c2 = c2;
                }

                public String getC3() {
                    return c3;
                }

                public void setC3(String c3) {
                    this.c3 = c3;
                }

                public String getC4R() {
                    return c4R;
                }

                public void setC4R(String c4R) {
                    this.c4R = c4R;
                }

                public String getC4T1() {
                    return c4T1;
                }

                public void setC4T1(String c4T1) {
                    this.c4T1 = c4T1;
                }

                public String getC4T1URL() {
                    return c4T1URL;
                }

                public void setC4T1URL(String c4T1URL) {
                    this.c4T1URL = c4T1URL;
                }

                public String getC4T2() {
                    return c4T2;
                }

                public void setC4T2(String c4T2) {
                    this.c4T2 = c4T2;
                }

                public String getC4T2URL() {
                    return c4T2URL;
                }

                public void setC4T2URL(String c4T2URL) {
                    this.c4T2URL = c4T2URL;
                }

                public String getC51() {
                    return c51;
                }

                public void setC51(String c51) {
                    this.c51 = c51;
                }

                public String getC51Link() {
                    return c51Link;
                }

                public void setC51Link(String c51Link) {
                    this.c51Link = c51Link;
                }

                public String getC52() {
                    return c52;
                }

                public void setC52(String c52) {
                    this.c52 = c52;
                }

                public String getC52Link() {
                    return c52Link;
                }

                public void setC52Link(String c52Link) {
                    this.c52Link = c52Link;
                }
            }

            public static class Saicheng2Bean {
                /**
                 * c1 : 未开赛
                 * c2 : 12-13周六
                 * c3 : 03:30
                 * c4R : VS
                 * c4T1 : 里昂
                 * c4T1URL : http://match.sports.sina.com.cn/football/team.php?id=436
                 * c4T2 : 卡昂
                 * c4T2URL : http://match.sports.sina.com.cn/football/team.php?id=10165
                 * c51 : 视频暂无
                 * c51Link :
                 * c52 : 图文直播
                 * c52Link : http://match.sports.sina.com.cn/livecast/g/live.php?id=111972
                 */
                @ParamNames("c1")
                private String c1;
                @ParamNames("c2")
                private String c2;
                @ParamNames("c3")
                private String c3;
                @ParamNames("c4R")
                private String c4R;
                @ParamNames("c4T1")
                private String c4T1;
                @ParamNames("c4T1URL")
                private String c4T1URL;
                @ParamNames("c4T2")
                private String c4T2;
                @ParamNames("c4T2URL")
                private String c4T2URL;
                @ParamNames("c51")
                private String c51;
                @ParamNames("c51Link")
                private String c51Link;
                @ParamNames("c52")
                private String c52;
                @ParamNames("c52Link")
                private String c52Link;

                public String getC1() {
                    return c1;
                }

                public void setC1(String c1) {
                    this.c1 = c1;
                }

                public String getC2() {
                    return c2;
                }

                public void setC2(String c2) {
                    this.c2 = c2;
                }

                public String getC3() {
                    return c3;
                }

                public void setC3(String c3) {
                    this.c3 = c3;
                }

                public String getC4R() {
                    return c4R;
                }

                public void setC4R(String c4R) {
                    this.c4R = c4R;
                }

                public String getC4T1() {
                    return c4T1;
                }

                public void setC4T1(String c4T1) {
                    this.c4T1 = c4T1;
                }

                public String getC4T1URL() {
                    return c4T1URL;
                }

                public void setC4T1URL(String c4T1URL) {
                    this.c4T1URL = c4T1URL;
                }

                public String getC4T2() {
                    return c4T2;
                }

                public void setC4T2(String c4T2) {
                    this.c4T2 = c4T2;
                }

                public String getC4T2URL() {
                    return c4T2URL;
                }

                public void setC4T2URL(String c4T2URL) {
                    this.c4T2URL = c4T2URL;
                }

                public String getC51() {
                    return c51;
                }

                public void setC51(String c51) {
                    this.c51 = c51;
                }

                public String getC51Link() {
                    return c51Link;
                }

                public void setC51Link(String c51Link) {
                    this.c51Link = c51Link;
                }

                public String getC52() {
                    return c52;
                }

                public void setC52(String c52) {
                    this.c52 = c52;
                }

                public String getC52Link() {
                    return c52Link;
                }

                public void setC52Link(String c52Link) {
                    this.c52Link = c52Link;
                }
            }

            public static class JifenbangBean {
                /**
                 * c1 : 1
                 * c2 : 马赛
                 * c2L : http://match.sports.sina.com.cn/football/team.php?id=478
                 * c3 : 16
                 * c41 : 11
                 * c42 : 2
                 * c43 : 3
                 * c5 : 19
                 * c6 : 35
                 */
                @ParamNames("c1")
                private String c1;
                @ParamNames("c2")
                private String c2;
                @ParamNames("c2L")
                private String c2L;
                @ParamNames("c3")
                private String c3;
                @ParamNames("c41")
                private String c41;
                @ParamNames("c42")
                private String c42;
                @ParamNames("c43")
                private String c43;
                @ParamNames("c5")
                private String c5;
                @ParamNames("c6")
                private String c6;

                public String getC1() {
                    return c1;
                }

                public void setC1(String c1) {
                    this.c1 = c1;
                }

                public String getC2() {
                    return c2;
                }

                public void setC2(String c2) {
                    this.c2 = c2;
                }

                public String getC2L() {
                    return c2L;
                }

                public void setC2L(String c2L) {
                    this.c2L = c2L;
                }

                public String getC3() {
                    return c3;
                }

                public void setC3(String c3) {
                    this.c3 = c3;
                }

                public String getC41() {
                    return c41;
                }

                public void setC41(String c41) {
                    this.c41 = c41;
                }

                public String getC42() {
                    return c42;
                }

                public void setC42(String c42) {
                    this.c42 = c42;
                }

                public String getC43() {
                    return c43;
                }

                public void setC43(String c43) {
                    this.c43 = c43;
                }

                public String getC5() {
                    return c5;
                }

                public void setC5(String c5) {
                    this.c5 = c5;
                }

                public String getC6() {
                    return c6;
                }

                public void setC6(String c6) {
                    this.c6 = c6;
                }
            }

            public static class SheshoubangBean {
                /**
                 * c1 : 1
                 * c2 : 拉卡泽特
                 * c2L : http://match.sports.sina.com.cn/football/player.php?id=59966
                 * c3 : 里昂
                 * c3L : http://match.sports.sina.com.cn/football/team.php?id=436
                 * c4 : 11
                 * c5 : 1
                 */
                @ParamNames("c1")
                private String c1;
                @ParamNames("c2")
                private String c2;
                @ParamNames("c2L")
                private String c2L;
                @ParamNames("c3")
                private String c3;
                @ParamNames("c3L")
                private String c3L;
                @ParamNames("c4")
                private String c4;
                @ParamNames("c5")
                private String c5;

                public String getC1() {
                    return c1;
                }

                public void setC1(String c1) {
                    this.c1 = c1;
                }

                public String getC2() {
                    return c2;
                }

                public void setC2(String c2) {
                    this.c2 = c2;
                }

                public String getC2L() {
                    return c2L;
                }

                public void setC2L(String c2L) {
                    this.c2L = c2L;
                }

                public String getC3() {
                    return c3;
                }

                public void setC3(String c3) {
                    this.c3 = c3;
                }

                public String getC3L() {
                    return c3L;
                }

                public void setC3L(String c3L) {
                    this.c3L = c3L;
                }

                public String getC4() {
                    return c4;
                }

                public void setC4(String c4) {
                    this.c4 = c4;
                }

                public String getC5() {
                    return c5;
                }

                public void setC5(String c5) {
                    this.c5 = c5;
                }
            }
        }
    }
}
