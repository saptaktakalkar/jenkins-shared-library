package com.mycompany.myproject.jenkins.library

class Docker implements Serializable {

    // Library classes cannot directly call steps such as sh or git.
    // So a set of steps can be passed explicitly using "this" to a library class, in a constructor.
    def steps

    Docker(steps) {
        this.steps = steps
    }

    def buildImage(String serviceName) {
        steps.sh "echo 'docker build .......'"
    }

    def pushImage() {
        steps.sh "echo 'docker push ........'"
    }
}
