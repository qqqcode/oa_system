package com.qqq.oasys.mapper;

import com.qqq.oasys.model.user.UserLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Johnson
 * 2021/2/20
 */
@Repository
public interface UserLogMapper extends JpaRepository<UserLog, Long>  {
    @Query(nativeQuery=true,value=("SELECT * FROM aoa_user_log WHERE aoa_user_log.user_id=?1 ORDER BY aoa_user_log.log_time DESC LIMIT 0,13"))
    List<UserLog> findByUser(Long userId);
}
