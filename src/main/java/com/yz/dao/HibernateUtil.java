package com.yz.dao;

import com.yz.Entity.JsonSendback;
import com.yz.Entity.Wallpaper;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static Session session;
    private static Transaction transaction = null;
    public static Session getSession(){
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        sessionFactory = cfg.buildSessionFactory();
        session = sessionFactory.openSession();
        return  session;
    }

    public static List<Wallpaper> selectTag(int pageNum){
        if(session == null || !session.isConnected()){
            session = getSession();
        }
        int i = (pageNum-1)*20;     //计算当前页数记录的查询起始位置
        String hql = "select wallpaper from Wallpaper wallpaper";
        Query query = session.createQuery(hql);
        query.setFirstResult(i);
        query.setMaxResults(20);
        List<Wallpaper> list = query.list();
        return list;
    }

    public static void updateTag(List<JsonSendback> list){
        if(session== null || !session.isConnected()){
            session = getSession();
        }
        if (transaction == null || !transaction.isActive()) {
            transaction = session.beginTransaction();
        }
        Iterator it = list.iterator();
        String hql = "update Wallpaper wallpaper set wallpaper.tag = :tag where wallpaper.id = :id";
        while (it.hasNext()){
            JsonSendback jsonSendback = (JsonSendback) it.next();
            Query query = session.createQuery(hql);
            query.setParameter("tag",jsonSendback.getTag());
            query.setParameter("id",jsonSendback.getId());
            query.executeUpdate();
        }
        transaction.commit();
    }

    public static void deleteWallpaper(){
        if(session== null || !session.isConnected()){
            session = getSession();
        }
        if (transaction == null || !transaction.isActive()) {
            transaction = session.beginTransaction();
        }
        String hql = "delete Wallpaper wallpaper where tag= 'false'";
        Query query = session.createQuery(hql);
        query.executeUpdate();
        transaction.commit();
    }

    public static void closeSession(){
        session.close();
    }

//    public static void main(String[] args) {
//        List<Wallpaper> list = HibernateUtil.selectTag(1);
//        Iterator it = list.iterator();
//        int i = 1;
//        while (it.hasNext()){
//            Wallpaper wallpaper =(Wallpaper) it.next();
//            System.out.println("id:"+wallpaper.getId());
//            System.out.println("imgUrl:"+wallpaper.getImgUrl());
//            System.out.println("tag:"+wallpaper.getTag());
//            System.out.println("--------------------------------------"+i);
//            i++;
//        }
//    }
}
