package school.volnenko.tm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.volnenko.tm.model.Project;

public interface ProjectRepository extends JpaRepository<Project, String> {

}
