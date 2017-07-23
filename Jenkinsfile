pipeline {
  agent any
  stages {
    stage('build-deploy') {
      steps {
        retry(count: 2) {
          sh 'mvn clean install -P auto-deploy'
          sh 'echo restart'
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