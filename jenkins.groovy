pipeline {
    agent any
   stages{
       stage('checkout') {
           steps {
               git branch: 'main', url: 'https://github.com/your-username/Rasolutions.git'
           }
       }
       stage('build') {
           steps {
               sh 'mvn clean install -DskipTests'
           }
       }
       stage('Tests'){
           steps {
               sh 'mvn test'
           }
       }
       stage('package'){
           steps {
               sh 'mvn package'
           }
       }
       stage('Archive artifact'){
           steps {
               archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
           }
       }
   }
    post {
        always {
            echo 'pipeline finshed'
        }
        success {
            echo 'Build & tests passed successfully'
        }
        failure {
            echo'Build failed check logs'
        }
    }
}