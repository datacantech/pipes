import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script
//import jetbrains.buildServer.configs.kotlin.v2019_2.BuildType
//import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.ScriptBuildStep
//import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.script
import java.io.File

//version = "2023.05.4"

project {
    val jobNames = File("fast.txt").readLines()
    for (jobName in jobNames) {
        val jobId = jobName.replace(" ", "_")
        buildType {
            id(jobId)
            name = jobName
            steps {
                // Добавьте необходимые шаги для джобы
                script {
                    scriptContent = "echo \"Running job: $jobName\""
                }
            }
        }
    }
    subProject {
        id("SubProject")
        name = "Sub Project for test"
        for (jobName in jobNames) {
            val jobId = jobName.replace(" ", "_")
            buildType {
                id(jobId + "test")
                name = jobName
                steps {
                    // Добавьте необходимые шаги для джобы
                    script {
                        scriptContent = "echo \"Running job: $jobName\""
                    }
                }
            }
        }
    }
}