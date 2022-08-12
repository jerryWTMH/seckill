package com.example.seckill.controller;


import com.example.seckill.pojo.User;
import com.example.seckill.rabbitmq.MQSender;
import com.example.seckill.vo.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jerry
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private MQSender mqSender;
    /**
     * User Information
     * @param user
     * @return
     */
    @RequestMapping("/info")
    @ResponseBody
    public RespBean info(User user){
        return RespBean.success(user);
    }

//    /**
//     * Testing send RabbitMQ message
//     */
//    @RequestMapping("/mq")
//    @ResponseBody
//    public void mq(){
//    mqSender.send("Hello");
//    }
//
//    /**
//     * Fanout Mode
//     */
//    @RequestMapping("/mq/fanout")
//    @ResponseBody
//    public void mq01(){
//        mqSender.send("Hello");
//    }
//
//    /**
//     * Direct Mode
//     */
//    @RequestMapping("/mq/direct01")
//    @ResponseBody
//    public void mq02(){
//        mqSender.send01("Hello, Red");
//    }
//
//    /**
//     * Direct Mode
//     */
//    @RequestMapping("/mq/direct02")
//    @ResponseBody
//    public void mq03(){
//        mqSender.send02("Hello, Green");
//    }
//
//    /**
//     * Topic Mode
//     */
//    @RequestMapping("/mq/topic01")
//    @ResponseBody
//    public void mq04(){
//        mqSender.send03("Hello, Red");
//    }
//
//    /**
//     * Topic Mode
//     */
//    @RequestMapping("/mq/topic02")
//    @ResponseBody
//    public void mq05(){
//        mqSender.send04("Hello, Green");
//    }
//
//    /**
//     * Header Mode
//     */
//    @RequestMapping("/mq/head01")
//    @ResponseBody
//    public void mq06(){
//        mqSender.send05("Hello, Header01");
//    }
//
//    /**
//     * Header Mode
//     */
//    @RequestMapping("/mq/head02")
//    @ResponseBody
//    public void mq07(){
//        mqSender.send06("Hello, Header02");
//    }
}
