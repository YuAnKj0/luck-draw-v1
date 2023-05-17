package com.yuan.luckclient.service.dto.data;

import com.yuan.luckclient.service.dto.ActivityAddCmd;
import com.yuan.luckclient.service.dto.AwardAddCmd;
import lombok.Data;

import java.util.List;

@Data
public class ActivityConfigCopyVO {
    private ActivityAddCmd activityAddCmd;

    private List<Long> ruleIdList;

    private List<AwardAddCmd> awardAddCmdList;
}