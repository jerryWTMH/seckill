package com.example.seckill.controller;

import com.example.seckill.pojo.User;
import com.example.seckill.service.IGoodsService;
import com.example.seckill.service.IUserService;
import com.example.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IGoodsService goodService;
    /**
     * Redirect to the page of goods
     * Mac QPS:5488 (before optimization)
     * Linux QPS: 937 (before optimization)
     * @param model
     * @return
     */
    @RequestMapping("/toList")
    public String toList(Model model, User user){
        model.addAttribute("user", user);
        model.addAttribute("goodsList", goodService.findGoodsVo());
        return "goodsList";
    }

    /**
     * Redicrect to Detail Page
     * @param goodsId
     * @return
     */
    @RequestMapping("/toDetail/{goodsId}")
    public String toDetail(Model model, User user, @PathVariable Long goodsId){
        model.addAttribute("user", user);
        GoodsVo goodsVo = goodService.findGoodsVoByGoodsId(goodsId);
        Date startDate = goodsVo.getStartDate();
        Date endDate = goodsVo.getEndDate();
        Date nowDate = new Date();
        // Discount status
        int secKillStatus = 0;
        // Discount count down
        int remainSeconds = 0;
        // Discount haven't started
        if(nowDate.before(startDate)){
            remainSeconds = (int)(startDate.getTime() - nowDate.getTime()) / 1000;
        } else if(nowDate.after(endDate)){
            // Discount end
            secKillStatus = 2;
            remainSeconds = -1;
        } else{
            secKillStatus = 1;
            remainSeconds = 0;
        }
        model.addAttribute("remainSeconds", remainSeconds);
        model.addAttribute("secKillStatus", secKillStatus);
        model.addAttribute("goods", goodsVo);
        return "goodsDetail";
    }
}
