package com.stephenhu.artistichorizons.utils;

import com.stephenhu.artistichorizons.config.SnowFlakeConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Stephen Hu
 */
@Component
public class SnowFlakeUtil {
    private static long startTimeStamp;
    private static long workID;
    private static long dataCenterID;
    private static long sequence;
    private static long dataCenterIndex;
    private static long workIDIndex;
    private static long timeStampIndex;
    private static long lastTimeStamp;
    private static long sequenceMask;
    private static long sequenceLength;

    @Autowired
    public SnowFlakeUtil(SnowFlakeConfig config) {
        startTimeStamp = config.getStartTimeStamp();
        workID = config.getWorkID();
        dataCenterID = config.getDataCenterID();
        sequence = 0L;
        dataCenterIndex = 12L;
        workIDIndex = 17L;
        timeStampIndex = 22L;
        lastTimeStamp = -1L;
        sequenceLength = 12L;
        sequenceMask = -1L ^ (-1L << sequenceLength);
    }

    public synchronized static long getID() {
        long now = System.currentTimeMillis();
        if (now < lastTimeStamp) {
            throw new RuntimeException("时钟回拨异常");
        }
        if (now == lastTimeStamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0L) {
                try {
                    Thread.sleep(1L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                now = System.currentTimeMillis();
            }
        } else {
            sequence = 0L;
        }
        lastTimeStamp = now;
        long handleTimeStamp = (now - startTimeStamp) << timeStampIndex;
        long handleWorkID = (dataCenterID << dataCenterIndex) | handleTimeStamp;
        long handleDataCenterID = (workID << workIDIndex) | handleWorkID;
        long ID = handleDataCenterID | sequence;
        return ID;
    }
    static void main(String[] args){
        System.out.println(SnowFlakeUtil.getID());
    }
}
