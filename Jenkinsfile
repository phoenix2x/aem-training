pipeline {
    agent any
    tools {
        maven '3.3.9'
    }
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
            }
        }
        stage('Sanity check') {
            steps {
                input "Does the staging environment look ok?"
            }
        }
        stage('deploy') {
            steps {
                sh 'ls'
            }
        }
    }
}