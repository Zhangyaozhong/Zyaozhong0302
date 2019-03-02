package com.bwie.android.zyaozhong0302.bean;

import java.util.List;

public class AddressListBean {

    /**
     * result : [{"address":"北京 海淀区 八维","createTime":1551376133000,"id":152,"phone":"18311122498","realName":"张三","userId":3,"whetherDefault":2,"zipCode":"101010"},{"address":"上海市 奉贤区 海湾镇","createTime":1551385759000,"id":160,"phone":"15234493537","realName":"李四","userId":3,"whetherDefault":2,"zipCode":"101010"},{"address":"上海市 奉贤区 海湾镇","createTime":1551387540000,"id":166,"phone":"15234493537","realName":"李四","userId":3,"whetherDefault":2,"zipCode":"101010"},{"address":"上海市 奉贤区 海湾镇","createTime":1551387545000,"id":167,"phone":"15234493537","realName":"李四","userId":3,"whetherDefault":2,"zipCode":"101010"},{"address":"天津市 北辰区","createTime":1551402311000,"id":184,"phone":"13011802187","realName":"王麻子","userId":3,"whetherDefault":2,"zipCode":"032258"},{"address":"北京市 海淀区 上地七街","createTime":1551403502000,"id":187,"phone":"16924852399","realName":"李小二","userId":3,"whetherDefault":2,"zipCode":"036603"},{"address":"北京市 海淀区 上地七街","createTime":1551403555000,"id":188,"phone":"16924852399","realName":"的撒打算","userId":3,"whetherDefault":2,"zipCode":"036604"},{"address":"北京市 海淀区 上地七街","createTime":1551403907000,"id":193,"phone":"16924852399","realName":"张飞","userId":3,"whetherDefault":1,"zipCode":"035528"},{"address":"北京市 海淀区 上地七街","createTime":1551404029000,"id":195,"phone":"16924852399","realName":"李小78","userId":3,"whetherDefault":2,"zipCode":"036603"},{"address":"北京市 海淀区 上地七街","createTime":1551470515000,"id":209,"phone":"16924852399","realName":"李小二","userId":3,"whetherDefault":2,"zipCode":"036603"},{"address":"澳门澳门半岛大堂区","createTime":1551478159000,"id":223,"phone":"16924852399","realName":"李小二","userId":3,"whetherDefault":2,"zipCode":"036603"}]
     * message : 查询成功
     * status : 0000
     */

    public String message;
    public String status;
    public List<ResultBean> result;

    public static class ResultBean {
        /**
         * address : 北京 海淀区 八维
         * createTime : 1551376133000
         * id : 152
         * phone : 18311122498
         * realName : 张三
         * userId : 3
         * whetherDefault : 2
         * zipCode : 101010
         */

        public String address;
        public long createTime;
        public int id;
        public String phone;
        public String realName;
        public int userId;
        public int whetherDefault;
        public String zipCode;
    }
}
