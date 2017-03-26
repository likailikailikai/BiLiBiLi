package com.atguigu.bilibili.modle.faxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by 情v枫 on 2017/3/26.
 * <p>
 * 作用：
 */

public class FanjuBean {

    /**
     * code : 0
     * data : [{"title":"【1月/完结】火影忍者 疾风传 720","cover":"http://i1.hdslb.com/bfs/archive/2deda6733b8266ec67ae536aee93aa068ecdc5d7.jpg_320x200.jpg","uri":"bilibili://video/9341465","param":"9341465","goto":"av","name":"TV-TOKYO","play":908869,"danmaku":74195,"pts":774537},{"title":"【1月】小林家的龙女仆 11【独家正版】","cover":"http://i0.hdslb.com/bfs/archive/a1080d35c404c099ee066646113fca17a5f131e5.jpg_320x200.jpg","uri":"bilibili://video/9326290","param":"9326290","goto":"av","name":"哔哩哔哩番剧","play":1251865,"danmaku":25177,"pts":617927},{"title":"【1月】人渣的本愿 11【幻樱】","cover":"http://i1.hdslb.com/bfs/archive/1e2ce0f65ab7d6be7464cb64dcf71158117d7a8a.jpg_320x200.jpg","uri":"bilibili://video/9352370","param":"9352370","goto":"av","name":"真鱼","play":672517,"danmaku":28067,"pts":474685},{"title":"【4月】双星之阴阳师 49","cover":"http://i1.hdslb.com/bfs/archive/4a69258c93dba82814810066f57b0f981a3d3ac5.jpg_320x200.jpg","uri":"bilibili://video/9323043","param":"9323043","goto":"av","name":"TV-TOKYO","play":232083,"danmaku":7086,"pts":216690},{"title":"【1月/完结】SEIREN 清恋 12","cover":"http://i0.hdslb.com/bfs/archive/92992943edf75317a8f61bb9dae8f1a8f8d06e17.jpg_320x200.jpg","uri":"bilibili://video/9354347","param":"9354347","goto":"av","name":"哔哩哔哩番剧","play":228854,"danmaku":13649,"pts":215713},{"title":"【1月/完结】风夏 12","cover":"http://i1.hdslb.com/bfs/archive/35568a527a83e51b8dfa391d9aa946e15a19c4cc.jpg_320x200.jpg","uri":"bilibili://video/9361867","param":"9361867","goto":"av","name":"哔哩哔哩番剧","play":210455,"danmaku":15636,"pts":207328},{"title":"【1月/完结】URARA迷路帖 12【独家正版】","cover":"http://i0.hdslb.com/bfs/archive/c07088fed4a6314824b6dc1af72cb120e8acef1c.jpg_320x200.jpg","uri":"bilibili://video/9354354","param":"9354354","goto":"av","name":"哔哩哔哩番剧","play":195762,"danmaku":16507,"pts":180402},{"title":"【1月】人渣的本愿 01【幻樱/澄空】","cover":"http://i1.hdslb.com/bfs/archive/b61bc343b7bf19f82c30b671615bd0df9aad4fbb.jpg_320x200.jpg","uri":"bilibili://video/7964205","param":"7964205","goto":"av","name":"真鱼","play":207744,"danmaku":3060,"pts":179887},{"title":"【1月】小林家的龙女仆 10【独家正版】","cover":"http://i0.hdslb.com/bfs/archive/c1ef52083ec6339fba7eac7ce796ef9f37bbaf12.jpg_320x200.jpg","uri":"bilibili://video/9187768","param":"9187768","goto":"av","name":"哔哩哔哩番剧","play":198705,"danmaku":3681,"pts":171121},{"title":"【1月】小林家的龙女仆 01【独家正版】","cover":"http://i2.hdslb.com/bfs/archive/4a2420aa6d3664aa69fe35e94fdaac364a053452.jpg_320x200.jpg","uri":"bilibili://video/7961887","param":"7961887","goto":"av","name":"哔哩哔哩番剧","play":161035,"danmaku":1667,"pts":145396},{"title":"【1月】珈百璃的堕落 11","cover":"http://i0.hdslb.com/bfs/archive/050cee70527166eed3a8f9c85007e83dbd6f77d1.jpg_320x200.jpg","uri":"bilibili://video/9291420","param":"9291420","goto":"av","name":"哔哩哔哩番剧","play":153419,"danmaku":4167,"pts":140782},{"title":"【1月】小林家的龙女仆 02【独家正版】","cover":"http://i0.hdslb.com/bfs/archive/fbc8ce3986e7dd4d587501fa1dde45d8d729da47.jpg_320x200.jpg","uri":"bilibili://video/8084513","param":"8084513","goto":"av","name":"哔哩哔哩番剧","play":129248,"danmaku":1416,"pts":122549},{"title":"【1月】小林家的龙女仆 09【独家正版】","cover":"http://i0.hdslb.com/bfs/archive/1ec8ffb12a9c6313cba04cd7ac27cd47eb39a3fc.jpg_320x200.jpg","uri":"bilibili://video/9042355","param":"9042355","goto":"av","name":"哔哩哔哩番剧","play":118947,"danmaku":1541,"pts":115080},{"title":"【1月】火影忍者 疾风传 719","cover":"http://i0.hdslb.com/bfs/archive/f04d6bb6bf9f98db58a02bdecb832c04.jpg_320x200.jpg","uri":"bilibili://video/9197096","param":"9197096","goto":"av","name":"TV-TOKYO","play":116900,"danmaku":940,"pts":114402},{"title":"【1月】人渣的本愿 09【幻樱/澄空学园】","cover":"http://i2.hdslb.com/bfs/archive/d1e950ca10dbe7c197725cd478426cdfd124ed11.jpg_320x200.jpg","uri":"bilibili://video/9067130","param":"9067130","goto":"av","name":"真鱼","play":114961,"danmaku":2217,"pts":112746},{"title":"【1月】人渣的本愿 02【幻樱/澄空学园】","cover":"http://i1.hdslb.com/bfs/archive/c639a23d5644eee78950096635d95d38e2cbc547.jpg_320x200.jpg","uri":"bilibili://video/9183946","param":"9183946","goto":"av","name":"真鱼","play":114500,"danmaku":1510,"pts":111469},{"title":"【OVA】机动战士敢达 雷霆宙域战线 05【独家正版】","cover":"http://i1.hdslb.com/bfs/archive/4782a41b9bafd53aba9373126d572624792d851c.jpg_320x200.jpg","uri":"bilibili://video/9343907","param":"9343907","goto":"av","name":"哔哩哔哩番剧","play":105349,"danmaku":2662,"pts":111334},{"title":"【1月】小林家的龙女仆 03【独家正版】","cover":"http://i1.hdslb.com/bfs/archive/bed04be09056c1ed547cfe7571511f3a2caf2e59.jpg_320x200.jpg","uri":"bilibili://video/8212411","param":"8212411","goto":"av","name":"哔哩哔哩番剧","play":109801,"danmaku":1290,"pts":108056},{"title":"【1月】小林家的龙女仆 08【独家正版】","cover":"http://i2.hdslb.com/bfs/archive/f952f9281e98422e38d8f3bebb271534e809046f.jpg_320x200.jpg","uri":"bilibili://video/8908904","param":"8908904","goto":"av","name":"哔哩哔哩番剧","play":106085,"danmaku":1107,"pts":105336},{"title":"【1月/完结】黑白来看守所 25【独家正版】","cover":"http://i2.hdslb.com/bfs/archive/cd8f757cd39cd5be9b83d85532ea925bdd36f39a.jpg_320x200.jpg","uri":"bilibili://video/9310212","param":"9310212","goto":"av","name":"哔哩哔哩番剧","play":101434,"danmaku":2550,"pts":105142}]
     * message :
     */

    private int code;
    private String message;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * title : 【1月/完结】火影忍者 疾风传 720
         * cover : http://i1.hdslb.com/bfs/archive/2deda6733b8266ec67ae536aee93aa068ecdc5d7.jpg_320x200.jpg
         * uri : bilibili://video/9341465
         * param : 9341465
         * goto : av
         * name : TV-TOKYO
         * play : 908869
         * danmaku : 74195
         * pts : 774537
         */

        private String title;
        private String cover;
        private String uri;
        private String param;
        @JSONField(name = "goto")
        private String gotoX;
        private String name;
        private int play;
        private int danmaku;
        private int pts;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getParam() {
            return param;
        }

        public void setParam(String param) {
            this.param = param;
        }

        public String getGotoX() {
            return gotoX;
        }

        public void setGotoX(String gotoX) {
            this.gotoX = gotoX;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPlay() {
            return play;
        }

        public void setPlay(int play) {
            this.play = play;
        }

        public int getDanmaku() {
            return danmaku;
        }

        public void setDanmaku(int danmaku) {
            this.danmaku = danmaku;
        }

        public int getPts() {
            return pts;
        }

        public void setPts(int pts) {
            this.pts = pts;
        }
    }
}
