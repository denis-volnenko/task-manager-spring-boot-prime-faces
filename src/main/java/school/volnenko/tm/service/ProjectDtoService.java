package school.volnenko.tm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import school.volnenko.tm.dto.ProjectDto;
import school.volnenko.tm.repository.ProjectDtoRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectDtoService {

    @Autowired
    private ProjectDtoRepository projectRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void persist(final ProjectDto project) {
        entityManager.persist(project);
    }

    public List<ProjectDto> findAll() {
        return projectRepository.findAll();
    }

    @Transactional
    public ProjectDto save(final ProjectDto project) {
        return projectRepository.save(project);
    }

    public Optional<ProjectDto> findById(final String id) {
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
    public void delete(final ProjectDto project) {
        projectRepository.delete(project);
    }

    @Transactional
    public void deleteAll(final Iterable<ProjectDto> iterable) {
        projectRepository.deleteAll(iterable);
    }

    @Transactional
    public void deleteAll() {
        projectRepository.deleteAll();
    }

}
