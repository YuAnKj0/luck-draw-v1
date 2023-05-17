package com.yuan.luckapp.activityconfig.command;

import com.yuan.luckclient.service.dto.ActivityConfigUpdateCmd;
import com.yuan.luckclient.service.dto.data.ActivityConfigVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Ykj
 * @date 2023/4/25/16:39
 * @apiNote
 */

@Slf4j
@Component
@AllArgsConstructor
public class ActivityConfigUpdateCmdExe {
    public ActivityConfigVO excute(ActivityConfigUpdateCmd configUpdateCmd) {
    }
}
