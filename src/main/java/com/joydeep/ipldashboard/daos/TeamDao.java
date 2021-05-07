package com.joydeep.ipldashboard.daos;

import com.joydeep.ipldashboard.domains.Team;

import java.util.List;

public interface TeamDao<T,M> {

    void createTeams();
    List<T> getTeams();
    T findByName(String name);
    List<M> findByNameAndYear(String name,int year);
    
}
