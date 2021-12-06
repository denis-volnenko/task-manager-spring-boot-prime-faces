package school.volnenko.tm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import school.volnenko.tm.dto.TaskDto;
import school.volnenko.tm.model.Task;
import school.volnenko.tm.repository.TaskDtoRepository;
import school.volnenko.tm.repository.TaskRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class TaskDtoService {

    @Autowired
    private TaskDtoRepository taskRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void persist(final TaskDto taskDto) {
        entityManager.persist(taskDto);
    }

    public List<TaskDto> findAll() {
        return taskRepository.findAll();
    }

    @Transactional
    public TaskDto save(final TaskDto task) {
        return taskRepository.save(task);
    }

    public Optional<TaskDto> findById(final String id) {
        return taskRepository.findById(id);
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
    public void delete(final TaskDto task) {
        taskRepository.delete(task);
    }

    @Transactional
    public void deleteAll(final Iterable<TaskDto> iterable) {
        taskRepository.deleteAll(iterable);
    }

    @Transactional
    public void deleteAll() {
        taskRepository.deleteAll();
    }

}
