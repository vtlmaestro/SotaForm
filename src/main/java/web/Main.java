package web;

import dao.DaoFactory;
import dto.UserDTO;
import mapper.BeanMapper;
import model.User;
import service.impl.UserServiceImpl;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

//        User user =  DaoFactory.getInstance().getUserDao().getBy("login", "vasya");
//        UserDTO userDTO = BeanMapper.getInstance().singleMapper(user, UserDTO.class);
//        UserServiceImpl.getInstance().upload(userDTO);
//
//        Date date = new Date(0, 0, 0);
//        int month_num =  date.getMonth();
//        int day = date.getDate();
//        int hours = date.getHours();
//        int minutes = date.getMinutes();
//        int seconds = date.getSeconds();
//
//        String []  month = {"01", "02", "03", "04", "05", "06",
//                "07", "08", "09", "10", "11", "12"};
//
//        if (day <= 9) day = Integer.parseInt("0" + day);
//        if (hours <= 9) hours = Integer.parseInt("0" + hours);
//        if (minutes <= 9) minutes = Integer.parseInt("0" + minutes);
//        if (seconds <= 9) seconds = Integer.parseInt("0" + seconds);

//        String date_time = day+"."+month[month_num]+"."+date.getYear()+"  "+"Данные переданы в"+" "+ hours + ":" + minutes + ":" + seconds;
//        date_time = "Сегодня - " + day + " " + month[month_num] + " " + d.getFullYear() +
//                " г.&nbsp;&nbsp;&nbsp;Текущее время - "+ hours + ":" + minutes + ":" + seconds;
//        if (document.layers) {
//            document.layers.doc_time.document.write(date_time);
//            document.layers.doc_time.document.close();
//        }
//        else document.getElementById("doc_time").innerHTML = date_time;
//        setTimeout("clock()", 1000);
//        System.out.println(date_time);


   }

}

