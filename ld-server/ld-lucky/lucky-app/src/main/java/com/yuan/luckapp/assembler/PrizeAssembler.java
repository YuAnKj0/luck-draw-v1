package com.yuan.luckapp.assembler;

import com.yuan.base.config.utils.SecurityUtil;
import com.yuan.luckclient.service.dto.PrizeAddCmd;
import com.yuan.luckclient.service.dto.PrizeUpdateCmd;
import com.yuan.luckclient.service.dto.data.PrizeVO;
import com.yuan.luckdomain.prize.PrizeEntity;
import com.yuan.luckdomain.prize.Tnventory;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Ykj
 * @date 2023/4/10/16:54
 * @apiNote
 */
public class PrizeAssembler {
   public static PrizeEntity toAddEntity(PrizeAddCmd cmd) {
       PrizeEntity prizeEntity = new PrizeEntity();
       prizeEntity.setPrizeName(cmd.getPrizeName());
       prizeEntity.setInventory(new Tnventory(cmd.getInventory()));
       prizeEntity.setMoney(new BigDecimal(cmd.getMoney().toString()));
       prizeEntity.setType(cmd.getType());
       prizeEntity.setCreateTime(LocalDateTime.now());
       prizeEntity.setCreator(SecurityUtil.getName());
       //prizeEntity.setUpdateTime(LocalDateTime.now());
       //prizeEntity.setUpdater(SecurityUtil.getName());
       return prizeEntity;
     
   }
   
   public static PrizeVO toPrizeVO(PrizeEntity prizeEntity) {
      PrizeVO prizeVo = new PrizeVO();
      prizeVo.setId(prizeEntity.getId());
      prizeVo.setPrizeName(prizeEntity.getPrizeName());
      prizeVo.setInventory(prizeEntity.getInventory().getInventory());
      prizeVo.setMoney(new BigDecimal(prizeEntity.getMoney().toString()));
      prizeVo.setType(prizeEntity.getType());
      prizeVo.setCreateTime(prizeEntity.getCreateTime());
      prizeVo.setCreator(prizeEntity.getCreator());
      prizeVo.setUpdateTime(prizeEntity.getUpdateTime());
      prizeVo.setUpdater(prizeEntity.getUpdater());
      return prizeVo;
      
   }
   
   public static PrizeEntity toUpdateEntity(PrizeUpdateCmd cmd) {
      PrizeEntity prizeEntity = new PrizeEntity();
      prizeEntity.setId(cmd.getId());
      prizeEntity.setPrizeName(cmd.getPrizeName());
      prizeEntity.setInventory(new Tnventory(cmd.getInventory()));
      prizeEntity.setMoney(new BigDecimal(cmd.getMoney().toString()));
      prizeEntity.setType(cmd.getType());
      prizeEntity.setUpdateTime(LocalDateTime.now());
      prizeEntity.setUpdater(SecurityUtil.getName());
      return prizeEntity;
   }
}
