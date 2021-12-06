package school.volnenko.tm.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.volnenko.tm.dto.ProjectDto;
import school.volnenko.tm.dto.ResultDto;
import school.volnenko.tm.dto.SuccessDto;
import school.volnenko.tm.service.ProjectDtoService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
@RestController
public class ProjectEndpoint {

    @Autowired
    private ProjectDtoService projectDtoService;

    @WebMethod
    @GetMapping("/api/project/ping")
    public ResultDto pingOne() {
        return new SuccessDto();
    }

    @WebMethod
    @GetMapping("/api/projects/ping")
    public ResultDto pingAll() {
        return new SuccessDto();
    }

    @WebMethod
    @GetMapping("/api/projects")
    public List<ProjectDto> selectAll() {
        return projectDtoService.findAll();
    }

    @WebMethod
    @PostMapping("/api/projects")
    public void insertAll(
            @WebParam(name = "projects")
            @RequestBody List<ProjectDto> projects
    ) {
        projects.forEach(this::insertOne);
    }

    @WebMethod
    @PutMapping("/api/projects")
    public void updateAll(
            @WebParam(name = "projects")
            @RequestBody List<ProjectDto> projects
    ) {
        projects.forEach(this::updateOne);
    }

    @WebMethod
    @DeleteMapping("/api/projects")
    public void deleteAll(
            @WebParam(name = "projects")
            @RequestBody List<ProjectDto> projects
    ) {
        projectDtoService.deleteAll(projects);
    }

    @WebMethod
    @GetMapping("/api/project/{id}")
    public ProjectDto selectOne(
            @WebParam(name = "id")
            @PathVariable("id") String id
    ) {
        return projectDtoService.findById(id).orElse(null);
    }

    @WebMethod
    @PostMapping("/api/project")
    public void insertOne(
            @WebParam(name = "project")
            @RequestBody ProjectDto project
    ) {
        projectDtoService.persist(project);
    }

    @WebMethod
    @PutMapping("/api/project")
    public void updateOne(
            @WebParam(name = "project")
            @RequestBody ProjectDto project
    ) {
        projectDtoService.save(project);
    }

    @WebMethod
    @DeleteMapping("/api/project")
    public void deleteOne(
            @WebParam(name = "project")
            @RequestBody ProjectDto project
    ) {
        projectDtoService.delete(project);
    }

}
