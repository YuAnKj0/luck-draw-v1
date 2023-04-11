package com.yuan.luckinfrastrusture.convertor;

import com.yuan.base.config.utils.SecurityUtil;
import com.yuan.luckdomain.prize.PrizeEntity;
import com.yuan.luckdomain.prize.Tnventory;
import com.yuan.luckinfrastrusture.gateway.impl.dataobject.PrizeDB;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Ykj
 * @date 2023/4/11/10:24
 * @apiNote
 */
public class PrizeConvertor {
   public static PrizeDB toPrizeDB(PrizeEntity entity) {
      PrizeDB prizeDB = new PrizeDB();
      prizeDB.setId(entity.getId());
      prizeDB.setPrizeName(entity.getPrizeName());
      prizeDB.setInventory(entity.getInventory().getInventory());
      prizeDB.setMoney(new BigDecimal(entity.getMoney().toString()));
      prizeDB.setType(entity.getType());
      prizeDB.setCreateTime(LocalDateTime.now());
      prizeDB.setCreator(SecurityUtil.getName());
      prizeDB.setUpdateTime(LocalDateTime.now());
      prizeDB.setUpdater(SecurityUtil.getName());      
      return prizeDB;
   }
   
   public static PrizeEntity toPrizeEntity(PrizeDB prizeDB) {
      PrizeEntity prizeEntity = new PrizeEntity();
      prizeEntity.setId(prizeDB.getId());
      prizeEntity.setPrizeName(prizeDB.getPrizeName());
      prizeEntity.setInventory(new Tnventory(prizeDB.getInventory()));
      prizeEntity.setMoney(new BigDecimal(prizeDB.getMoney().toString()));
      prizeEntity.setType(prizeDB.getType());
      prizeEntity.setCreateTime(prizeDB.getCreateTime());
      prizeEntity.setCreator(prizeDB.getCreator());
      prizeEntity.setUpdateTime(prizeDB.getUpdateTime());
      prizeEntity.setUpdater(prizeDB.getUpdater());
      
      return prizeEntity;
   }
}
