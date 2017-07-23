pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        sh 'mvn clean install -P auto-deploy'
      }
    }
    stage('restart') {
      steps {
        sh 'echo restarting'
      }
    }
  }
  tools {
    maven '3.3.9'
  }
}