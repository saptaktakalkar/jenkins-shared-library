package com.mycompany.myproject.jenkins.library

class Test implements Serializable {

    // Library classes cannot directly call steps such as sh or git.
    // So a set of steps can be passed explicitly using "this" to a library class, in a constructor.
    def steps

    Test(steps) {
        this.steps = steps
    }

    def runServiceTests() {
        steps.sh "echo 'gradle test .....'"
    }

    def runFrontendTests() {
        steps.sh "echo 'npm run test ......'"
    }
}
