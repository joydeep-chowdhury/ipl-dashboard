package com.joydeep.ipldashboard.listeners;

import com.joydeep.ipldashboard.daos.TeamDao;
import com.joydeep.ipldashboard.domains.Team;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    private final JdbcTemplate jdbcTemplate;

    private final TeamDao<Team> teamDao;

    @Autowired
    public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate, TeamDao<Team> teamDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.teamDao = teamDao;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("!!! JOB FINISHED! Time to verify the results");
            teamDao.createTeams();
            List<Team> teams = teamDao.getTeams();
            System.out.println(teams);

        }
    }
}
