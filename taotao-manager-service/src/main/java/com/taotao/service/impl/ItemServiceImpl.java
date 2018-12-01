package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.IDUtils;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper tbItemMapper;
    @Override
    public EasyUIDataGridResult<TbItem> getItemList(Integer page, Integer rows) {
        if(page==null)page=1;
        if(rows==null)rows=30;
        PageHelper.startPage(page,rows);
        List<TbItem> tbItemList = tbItemMapper.selectByExample(new TbItemExample());
        PageInfo<TbItem> info=new PageInfo<>(tbItemList);
        EasyUIDataGridResult<TbItem> easyUIDataGridResult = new EasyUIDataGridResult<>();
        easyUIDataGridResult.setTotal((int)info.getTotal());
        easyUIDataGridResult.setRows(info.getList());
        return easyUIDataGridResult;
    }

    @Override
    public TaotaoResult createItem(TbItem item) {
        Long itemId= IDUtils.genItemId();
        item.setId(itemId);
        item.setStatus((byte)1);
        item.setCreated(new Date());
        item.setUpdated(new Date());
        tbItemMapper.insert(item);
        return TaotaoResult.ok();
    }
}
