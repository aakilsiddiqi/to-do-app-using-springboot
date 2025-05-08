package com.todoapp.todoapp.repo;

import com.todoapp.todoapp.entity.TaskTracker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends CrudRepository<TaskTracker,Integer> {

}
