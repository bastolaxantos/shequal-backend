package org.shequal.jobportal.service;

import java.util.List;
import org.shequal.jobportal.models.Job;

public interface JobService {
     List<Job> getAllJobs();

     Job getJob(Long id);

     Job createJob(Job job);

     void deleteJob(Long id);

     Job updateJob(Long id, Job job);
}
