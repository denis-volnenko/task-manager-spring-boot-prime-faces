package school.volnenko.tm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import school.volnenko.tm.model.Task;
import school.volnenko.tm.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Transactional
    public Task save(final Task task) {
        return taskRepository.save(task);
    }

    public Optional<Task> findById(final String s) {
        return taskRepository.findById(s);
    }

    public boolean existsById(final String s) {
        return taskRepository.existsById(s);
    }

    public long count() {
        return taskRepository.count();
    }

    @Transactional
    public void deleteById(final String id) {
        taskRepository.deleteById(id);
    }

    @Transactional
    public void delete(final Task task) {
        taskRepository.delete(task);
    }

    @Transactional
    public void deleteAll(final Iterable<Task> iterable) {
        taskRepository.deleteAll(iterable);
    }

    @Transactional
    public void deleteAll() {
        taskRepository.deleteAll();
    }

}
