pipeline {
  agent any
  stages {
    stage('build-deploy') {
      steps {
        retry(count: 2) {
          sh 'mvn clean install -P auto-deploy'
        }
        
      }
      post {
        always {
          sh 'This will always run'
        }
        failure {
          sh 'This will run only if failed'
        }
        changed {
          sh 'This will run only if the state of the Pipeline has changed'
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