pipeline {
    agent any
   stages{
       stage('checkout') {
           steps {
               git branch: 'main', url: 'https://github.com/RA-Product/springbootChecker.git'
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
              archiveArtifacts artifacts: 'target/Rasolutions-0.0.1-SNAPSHOT.jar', fingerprint: true
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