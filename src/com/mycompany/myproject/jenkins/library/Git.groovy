package com.mycompany.myproject.jenkins.library

class Git implements Serializable {

    // Library classes cannot directly call steps such as sh or git.
    // So a set of steps can be passed explicitly using 'this' to a library class, in a constructor.
    def steps
    def credentialsId
    def url
    def branch

    Git(steps) {
        this.steps = steps

    }

    def gitCheckout(Map config=[:]) {
        steps.sh "echo 'git checkout ......'"
    }
}