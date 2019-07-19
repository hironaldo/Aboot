package com.cheery.repository;

import com.cheery.entity.SysLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * desc: 日志模块-数据访问层服务接口
 * Created by FanYanGen on 2019-05-20 17:26
 */
@Repository
public interface LogRepository extends JpaRepository<SysLog, Long> {

    /**
     * desc: 检查数据是否存在
     *
     * @param logId 日志ID
     * @return one result
     * @auther FanYanGen
     * @date 2019-06-10 15:08
     */
    @Query(value = "SELECT COUNT(1) FROM `logs` WHERE log_id = ?1 AND del_flag = 0", nativeQuery = true)
    int checkDataIsExists(String logId);

    /**
     * desc: 根据日志ID删除
     *
     * @param logId 日志ID
     * @return one result
     * @auther FanYanGen
     * @date 2019-06-10 15:34
     */
    int deleteByLogId(String logId);

}
