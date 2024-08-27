class Job {
    private int jobId;
    private String jobName;
    private String progress;

    public Job(int jobId, String jobName, String progress) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.progress = progress;
    }

    public int getJobId() {
        return jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public String getProgress() {
        return progress;
    }

    @Override
    public String toString() {
        return "Job[ID=" + jobId + ", Name=" + jobName + ", Progress=" + progress + "]";
    }
}

class JobNode {
    Job job;
    JobNode next;

    JobNode(Job job) {
        this.job = job;
        this.next = null;
    }
}

class JobList {
    private JobNode head;

    public void addJob(Job job) {
        JobNode newNode = new JobNode(job);
        if (head == null) {
            head = newNode;
        } else {
            JobNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Job findJob(int jobId) {
        JobNode current = head;
        while (current != null) {
            if (current.job.getJobId() == jobId) {
                return current.job;
            }
            current = current.next;
        }
        return null;
    }

    public void removeJob(int jobId) {
        if (head == null) {
            return;
        }

        if (head.job.getJobId() == jobId) {
            head = head.next;
            return;
        }

        JobNode current = head;
        while (current.next != null && current.next.job.getJobId() != jobId) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public void displayJobs() {
        JobNode current = head;
        while (current != null) {
            System.out.println(current.job);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        JobList jobList = new JobList();
        jobList.addJob(new Job(1, "Design Database", "Pending"));
        jobList.addJob(new Job(2, "Develop API", "In Progress"));
        jobList.addJob(new Job(3, "Test Application", "Pending"));

        System.out.println("All Jobs:");
        jobList.displayJobs();

        System.out.println("\nSearching for Job with ID 2:");
        Job foundJob = jobList.findJob(2);
        System.out.println(foundJob != null ? foundJob : "Job not found");

        System.out.println("\nRemoving Job with ID 1:");
        jobList.removeJob(1);
        jobList.displayJobs();
    }
}
