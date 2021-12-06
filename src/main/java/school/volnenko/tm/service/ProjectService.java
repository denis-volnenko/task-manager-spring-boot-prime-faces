package school.volnenko.tm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import school.volnenko.tm.model.Project;
import school.volnenko.tm.repository.ProjectRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Transactional
    public Project save(final Project project) {
        return projectRepository.save(project);
    }

    public Optional<Project> findById(final String id) {
        return projectRepository.findById(id);
    }

    public boolean existsById(final String id) {
        return projectRepository.existsById(id);
    }

    public long count() {
        return projectRepository.count();
    }

    @Transactional
    public void deleteById(final String id) {
        projectRepository.deleteById(id);
    }

    @Transactional
    public void delete(final Project project) {
        projectRepository.delete(project);
    }

    @Transactional
    public void deleteAll(final Iterable<Project> iterable) {
        projectRepository.deleteAll(iterable);
    }

    @Transactional
    public void deleteAll() {
        projectRepository.deleteAll();
    }

}
