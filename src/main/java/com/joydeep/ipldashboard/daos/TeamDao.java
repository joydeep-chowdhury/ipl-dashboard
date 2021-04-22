package com.joydeep.ipldashboard.daos;

import com.joydeep.ipldashboard.domains.Team;

import java.util.List;

public interface TeamDao<T> {

    void createTeams();
    List<T> getTeams();

}
