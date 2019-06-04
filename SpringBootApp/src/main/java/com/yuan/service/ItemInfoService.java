package com.yuan.service;

import com.yuan.mapper.ItemInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemInfoService {
    @Autowired
    private ItemInfoMapper itemInfoMapper;

    public void buying(int goods_id, String addr_pro, String addr_city, String addr_det) {
        itemInfoMapper.Buying(goods_id, addr_pro, addr_city, addr_det);
    }

}
