package com.mycompany.myproject.jenkins.library

class Build implements Serializable {

    // Library classes cannot directly call steps such as sh or git.
    // So a set of steps can be passed explicitly using "this" to a library class, in a constructor.
    def steps

    Build(steps) {
        this.steps = steps
    }

    def serviceBuild() {
        steps.sh "echo 'gradle build .....'"
    }

    def frontendBuild() {
        steps.sh "echo 'npm run build .....'"
    }
}
