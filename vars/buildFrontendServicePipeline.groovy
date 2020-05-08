import com.mycompany.myproject.jenkins.library.Build
import com.mycompany.myproject.jenkins.library.Docker
import com.mycompany.myproject.jenkins.library.Git
import com.mycompany.myproject.jenkins.library.Test

def call(Map config=[:]) {
    pipeline {
        agent any
        options {
            skipStagesAfterUnstable()
        }
        environment {

        }
        stages {
            stage("Checkout SCM") {
                steps {
                    script{
                        git = new Git(this)
                        git.gitCheckout(config)
                    }
                }
            }
            stage("Install NPM Dependencies") {
                steps {
                    sh "echo 'npm ci ......'"
                }
            }
            stage("Run Tests") {
                steps {
                    script {
                        test = new Test(this)
                        test.runFrontendTests()
                    }
                }
            }
            stage("Build") {
                steps {
                    script {
                        build = new Build(this)
                        build.frontendBuild()
                    }
                }
            }
            stage("Build Docker Image") {
                steps {
                    script {
                        docker = new Docker(this)
                        docker.buildImage()
                    }
                }
            }
            stage("Push Docker Image on Artifactory") {
                steps {
                    script {
                        docker.pushImage()
                    }
                }
            }
        }
    }
}
