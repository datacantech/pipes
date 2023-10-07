import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.ScriptBuildStep
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import java.io.File

version = "2023.05.4"


object Project : BuildType({
    name = "Echo Jobs"

    steps {
        val file = File("fast.txt")
        val lines = file.readLines()
        for (i in lines.indices) {
            script {
                name = "${i}"
                scriptContent = "echo ${lines[i]}"
            }
        }
    }
})

