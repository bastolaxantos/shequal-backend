package org.shequal.jobportal.service;

import java.util.List;
import org.shequal.jobportal.exception.JobNotFoundException;
import org.shequal.jobportal.models.Job;
import org.shequal.jobportal.repository.JobRepository;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService {
    private final JobRepository repository;

    public JobServiceImpl(JobRepository repository) {
        this.repository = repository;
    }

    public List<Job> getAllJobs() {
        return repository.findAll();
    }

    public Job getJob(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new JobNotFoundException("Job post not found for id: " + id));
    }

    public Job createJob(Job job) {
        return repository.save(job);
    }

    public void deleteJob(Long id) {
        repository.deleteById(id);
    }

    public Job updateJob(Long id, Job job) {
        // 1. Get the post with id
        var savedJob = getJob(id);

        // 2. Modify the returned object
        savedJob.setTitle(job.getTitle());
        savedJob.setCategory(job.getCategory());
        savedJob.setDescription(job.getDescription());
        savedJob.setApplyLink(job.getApplyLink());
        savedJob.setExpiresAt(job.getExpiresAt());
        savedJob.setCompanyName(job.getCompanyName());

        // 3. Save modified object
        return repository.save(savedJob);
    }
}
