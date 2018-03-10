package com.yz.v1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.yz.Entity.JsonSendback;
import com.yz.Entity.Wallpaper;
import com.yz.dao.HibernateUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class imgShow {

    //imgshow图片展示
    public String showImg(int pageNum){
        List<Wallpaper> list = HibernateUtil.selectTag(pageNum);
        String jsonStr = JSON.toJSONString(list);
        return jsonStr;
    }

    //updateImg更新图片：先从前端页面获取了列表，然后将tag存入数据库
    public void updataImg(String jsonStr){
        List<JsonSendback> list = JSONArray.parseArray(jsonStr,JsonSendback.class);
        HibernateUtil.updateTag(list);
    }

    //delete删除图片：确认删除图片后，从数据库中进行删除图片
    public void deleteImg() throws Exception{
        HibernateUtil.deleteWallpaper();
        HibernateUtil.closeSession();
    }

    public JSONArray strToJson(String res){
        JSONArray jsonArray = JSONArray.parseArray(res);
        return  jsonArray;
    }


}
