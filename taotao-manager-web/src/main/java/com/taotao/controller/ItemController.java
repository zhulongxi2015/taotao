package com.taotao.controller;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemController {
    @Autowired
    private ItemService itemsService;
    @RequestMapping("/item/list")
    @ResponseBody
    public EasyUIDataGridResult<TbItem> getItemList(Integer page,Integer rows){
        return itemsService.getItemList(page,rows);
    }

    @RequestMapping(value = "item/save",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult createItem(TbItem item){
        return itemsService.createItem(item);
    }
}
