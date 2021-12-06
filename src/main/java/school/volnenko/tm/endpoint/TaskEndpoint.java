package school.volnenko.tm.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.volnenko.tm.dto.TaskDto;
import school.volnenko.tm.dto.ResultDto;
import school.volnenko.tm.dto.SuccessDto;
import school.volnenko.tm.service.TaskDtoService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
@RestController
public class TaskEndpoint {

    @Autowired
    private TaskDtoService taskDtoService;

    @WebMethod
    @GetMapping("/api/task/ping")
    public ResultDto pingOne() {
        return new SuccessDto();
    }

    @WebMethod
    @GetMapping("/api/tasks/ping")
    public ResultDto pingAll() {
        return new SuccessDto();
    }

    @WebMethod
    @GetMapping("/api/tasks")
    public List<TaskDto> selectAll() {
        return taskDtoService.findAll();
    }

    @WebMethod
    @PostMapping("/api/tasks")
    public void insertAll(
            @WebParam(name = "tasks")
            @RequestBody List<TaskDto> tasks
    ) {
        tasks.forEach(this::insertOne);
    }

    @WebMethod
    @PutMapping("/api/tasks")
    public void updateAll(
            @WebParam(name = "tasks")
            @RequestBody List<TaskDto> tasks
    ) {
        tasks.forEach(this::updateOne);
    }

    @WebMethod
    @DeleteMapping("/api/tasks")
    public void deleteAll(
            @WebParam(name = "tasks")
            @RequestBody List<TaskDto> tasks
    ) {
        taskDtoService.deleteAll(tasks);
    }

    @WebMethod
    @GetMapping("/api/task/{id}")
    public TaskDto selectOne(
            @WebParam(name = "id")
            @PathVariable("id") String id
    ) {
        return taskDtoService.findById(id).orElse(null);
    }

    @WebMethod
    @PostMapping("/api/task")
    public void insertOne(
            @WebParam(name = "task")
            @RequestBody TaskDto task
    ) {
        taskDtoService.persist(task);
    }

    @WebMethod
    @PutMapping("/api/task")
    public void updateOne(
            @WebParam(name = "task")
            @RequestBody TaskDto task
    ) {
        taskDtoService.save(task);
    }

    @WebMethod
    @DeleteMapping("/api/task")
    public void deleteOne(
            @WebParam(name = "task")
            @RequestBody TaskDto task
    ) {
        taskDtoService.delete(task);
    }

}
