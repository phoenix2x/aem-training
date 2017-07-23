pipeline {
    agent any
    tools {
        maven '3.3.9'
    }
    stages {
        stage('build') {
            steps {
                sh 'mvn clean install -P auto-deploy'
            }
        }
    }
}