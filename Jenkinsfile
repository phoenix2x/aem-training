pipeline {
  agent any
  stages {
    stage('build-deploy') {
      steps {
        sh 'mvn clean install -P auto-deploy'
      }
      post {
        always {
          sh 'restarting'
        }
        failure {
          sh 'mvn clean install -P auto-deploy'
          sh 'restarting'
        }
      }
    }
    stage('clear cache') {
      steps {
        sh 'echo clearing'
      }
    }
  }
  tools {
    maven '3.3.9'
  }
}