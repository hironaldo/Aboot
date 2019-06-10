package com.cheery.util;

import java.util.UUID;

/**
 * desc: 全局唯一标识符工具类
 * Created by FanYanGen on 2019-05-22 10:01
 */
public class UUIDUtil {

    /**
     * desc: 获取java.util的UUID
     *
     * @return string
     * @auther FanYanGen
     * @date 2019-05-22 10:02
     */
    public static String javaUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * desc: 获取Twitter的SnowFlake的ID
     *
     * @return String
     * @auther FanYanGen
     * @date 2019-05-22 10:41
     */
    public static String snowFlakeUUID() {
        return String.valueOf(new UUIDUtil(1, 1).nextId());
    }

    /* copy Twitter的雪花算法SnowFlake!!! */

    /**
     * 起始的时间戳
     */
    private final static long START_TIMESTAMP = 1480166465631L;

    /**
     * SEQUENCE_BIT 序列号占用的位数
     * MACHINE_BIT 机器标识占用的位数
     * DATA_CENTER_BIT 数据中心占用的位数
     */
    private final static long SEQUENCE_BIT = 12;
    private final static long MACHINE_BIT = 5;
    private final static long DATA_CENTER_BIT = 5;

    /**
     * 每一部分的最大值
     */
    private final static long MAX_DATA_CENTER_NUM = -1L ^ (-1L << DATA_CENTER_BIT);
    private final static long MAX_MACHINE_NUM = -1L ^ (-1L << MACHINE_BIT);
    private final static long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BIT);

    /**
     * 每一部分向左的位移
     */
    private final static long MACHINE_LEFT = SEQUENCE_BIT;
    private final static long DATA_CENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
    private final static long TIMESTAMP_LEFT = DATA_CENTER_LEFT + DATA_CENTER_BIT;

    /**
     * dataCenterId 数据中心
     * machineId 机器标识
     * sequence 序列号
     * lastTimestamp 上一次时间戳
     */
    private long dataCenterId;
    private long machineId;
    private long sequence = 0L;
    private long lastTimestamp = -1L;

    private UUIDUtil(long dataCenterId, long machineId) {
        if (dataCenterId > MAX_DATA_CENTER_NUM || dataCenterId < 0) {
            throw new IllegalArgumentException("dataCenterId can't be greater than MAX_DATACENTER_NUM or less than 0");
        }
        if (machineId > MAX_MACHINE_NUM || machineId < 0) {
            throw new IllegalArgumentException("machineId can't be greater than MAX_MACHINE_NUM or less than 0");
        }
        this.dataCenterId = dataCenterId;
        this.machineId = machineId;
    }

    /**
     * 产生下一个ID
     */
    private synchronized long nextId() {
        long currTimestamp = getNewsTimestamp();
        if (currTimestamp < lastTimestamp) {
            throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
        }
        if (currTimestamp == lastTimestamp) {
            //相同毫秒内，序列号自增
            sequence = (sequence + 1) & MAX_SEQUENCE;
            //同一毫秒的序列数已经达到最大
            if (sequence == 0L) {
                currTimestamp = getNextMill();
            }
        } else {
            //不同毫秒内，序列号置为0
            sequence = 0L;
        }
        lastTimestamp = currTimestamp;
        return (currTimestamp - START_TIMESTAMP) << TIMESTAMP_LEFT | lastTimestamp << MAX_DATA_CENTER_NUM | machineId << MACHINE_LEFT | sequence;
    }

    private long getNextMill() {
        long mill = getNewsTimestamp();
        while (mill <= lastTimestamp) {
            mill = getNewsTimestamp();
        }
        return mill;
    }

    private long getNewsTimestamp() {
        return System.currentTimeMillis();
    }

}
