package com.mmacedo.todolist.repository;

import com.mmacedo.todolist.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
    @Query("SELECT obj FROM Todo obj WHERE obj.finished = false ORDER BY obj.dateToFinishTask DESC")
    public List<Todo> listOpenTasks();
    @Query("SELECT obj FROM Todo obj WHERE obj.finished = true ORDER BY obj.dateToFinishTask DESC")
    public List<Todo> listFinishedTasks();
}
