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
        parallel(
          "clear cache": {
            sh 'echo clearing'
            
          },
          "asd": {
            sh 'echo asd'
            
          }
        )
      }
    }
    stage('asd') {
      steps {
        sh 'echo asd'
      }
    }
  }
  tools {
    maven '3.3.9'
  }
}