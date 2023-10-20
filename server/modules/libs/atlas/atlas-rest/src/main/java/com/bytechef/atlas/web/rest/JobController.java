/*
 * Copyright 2016-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Modifications copyright (C) 2021 <your company/name>
 */

package com.bytechef.atlas.web.rest;

import com.bytechef.atlas.Constants;
import com.bytechef.atlas.data.Page;
import com.bytechef.atlas.job.JobSummary;
import com.bytechef.atlas.job.domain.Job;
import com.bytechef.atlas.message.broker.MessageBroker;
import com.bytechef.atlas.message.broker.Queues;
import com.bytechef.atlas.service.job.JobService;
import com.bytechef.atlas.uuid.UUIDGenerator;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Arik Cohen
 */
@RestController
public class JobController {

    private final MessageBroker messageBroker;
    private final JobService jobService;

    public JobController(JobService jobService, MessageBroker messageBroker) {
        this.jobService = jobService;
        this.messageBroker = messageBroker;
    }

    @GetMapping(value = "/jobs", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<JobSummary> list(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber) {
        return jobService.getJobSummaries(pageNumber);
    }

    @PostMapping(value = "/jobs", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String create(@RequestBody Map<String, Object> jobRequestMap) {
        String id = UUIDGenerator.generate();

        jobRequestMap.put(Constants.ID, id);

        messageBroker.send(Queues.REQUESTS, jobRequestMap);

        return id;
    }

    @GetMapping(value = "/jobs/{id}")
    public Job get(@PathVariable("id") String jobId) {
        return jobService.getJob(jobId);
    }

    @GetMapping(value = "/jobs/latest", produces = MediaType.APPLICATION_JSON_VALUE)
    public Job latest() {
        Optional<Job> job = jobService.getLatestJob();

        Assert.isTrue(job.isPresent(), "no jobs");

        return job.get();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public void handleIllegalArgumentException(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.sendError(HttpStatus.BAD_REQUEST.value());
    }

    @PutMapping(value = "/jobs/{id}/restart")
    public ResponseEntity<Void> restart(@PathVariable("id") String jobId) {
        messageBroker.send(Queues.RESTARTS, jobId);

        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/jobs/{id}/stop")
    public ResponseEntity<Void> stop(@PathVariable("id") String jobId) {
        messageBroker.send(Queues.STOPS, jobId);

        return ResponseEntity.ok().build();
    }
}
