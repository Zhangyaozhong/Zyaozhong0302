package com.bwie.android.zyaozhong0302.bean;

import java.io.Serializable;
import java.util.List;

public class CartBean implements Serializable {

    /**
     * result : [{"commodityId":29,"commodityName":"秋冬新款平底毛毛豆豆鞋加绒单鞋一脚蹬懒人鞋休闲","count":3,"pic":"http://mobile.bwstudent.com/images/small/commodity/nx/ddx/5/1.jpg","price":278},{"commodityId":23,"commodityName":"小白鞋 女款 时尚百搭休闲板鞋","count":4,"pic":"http://mobile.bwstudent.com/images/small/commodity/nx/bx/6/1.jpg","price":139}]
     * message : 查询成功
     * status : 0000
     */

    public String message;
    public String status;
    public List<ResultBean> result;

    public static class ResultBean {
        /**
         * commodityId : 29
         * commodityName : 秋冬新款平底毛毛豆豆鞋加绒单鞋一脚蹬懒人鞋休闲
         * count : 3
         * pic : http://mobile.bwstudent.com/images/small/commodity/nx/ddx/5/1.jpg
         * price : 278
         */

        public String commodityId;
        public String commodityName;
        public int count;
        public String pic;
        public double price;
        public boolean flag;
    }
}
