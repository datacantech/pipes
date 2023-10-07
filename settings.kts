import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script.buildScript
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script.kscript
import java.io.File

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

