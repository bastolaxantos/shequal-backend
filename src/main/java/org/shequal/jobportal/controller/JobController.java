package org.shequal.jobportal.controller;

import com.fasterxml.jackson.databind.ser.Serializers.Base;
import java.util.List;
import org.shequal.jobportal.dto.BaseResponse;
import org.shequal.jobportal.models.Job;
import org.shequal.jobportal.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/jobs")
public class JobController {

    private final JobService service;

    public JobController(JobService service) {
        this.service = service;
    }

    // http://localhost:8080/api/jobs => Return all Job posts
    // http://localhost:8080/api/jobs/1 => Return a Job post whose id is 1
    // http://localhost:8080/api/jobs (Http method: POST) => Add a new Job Post
    // http://localhost:8080/api/jobs/1 (Http method: PUT) => Update an existing Job Post whose id is 1
    // http://localhost:8080/api/jobs/1 (Http method: DELETE) -> Delete an existing Job Post whose id is 1

    @GetMapping
    @CrossOrigin
    public BaseResponse<List<Job>> getAllJobs() {
        var list = service.getAllJobs();
        return new BaseResponse(HttpStatus.OK.value(), "Success", list);
    }

    @GetMapping("/{id}")
    public BaseResponse<Job> getJob(@PathVariable("id") Long id) {
        var job = service.getJob(id);
        return new BaseResponse<>(HttpStatus.OK.value(), "Success", job);
    }

    @PostMapping
    public BaseResponse<Job> addJob(@RequestBody Job job) {
        var savedJob = service.createJob(job);
        return new BaseResponse<>(HttpStatus.CREATED.value(), "Post created", savedJob);
    }

    @PutMapping("/{id}")
    public BaseResponse<Job> editJob(@PathVariable("id") Long id, @RequestBody Job job) {
        var editedJob = service.updateJob(id, job);
        return new BaseResponse<>(HttpStatus.OK.value(), "Post Updated Successfully", editedJob);
    }

    @DeleteMapping("/{id}")
    public BaseResponse<String> deleteJob(@PathVariable("id") Long id) {
        service.deleteJob(id);
        return new BaseResponse<>(HttpStatus.OK.value(), "Post Deleted Successfully", null);
    }
}