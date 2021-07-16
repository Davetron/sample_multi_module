package co.databeast.pipeline;

import static co.databeast.conveyor.Conveyor.conveyor;
import static co.databeast.conveyor.job.DefaultJob.job;
import static co.databeast.conveyor.stage.DefaultStage.stage;
import static co.databeast.conveyor.task.GitCloneTask.gitClone;
import static co.databeast.conveyor.task.MavenTask.maven;

public class Pipeline {

    public static final String REPOSITORY_URI = "https://github.com/Davetron/sample_multi_module.git";

    public static void main(String[] args) {

        String repository = System.getProperty("repository", REPOSITORY_URI);

        conveyor("co.databeast.co.databeast.pipeline.Pipeline",
                stage("Build",
                        job("Application Build",
                                gitClone(repository),
                                maven("install")
                        )
                )
        ).start();
        System.out.println("Completed pipeline");
    }
}
