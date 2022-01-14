pipeline {
    agent any
  //triggers {pollSCM('* * * * *')}
  stages {
    stage('Checkout') {
      steps {
        // Get some code from a GitHub repository
<<<<<<< HEAD
        git branch: "newVersion", url: 'https://github.com/hrhowell/ec2P2.git'
=======
        git branch: "main", url: 'https://github.com/hrhowell/ec2P2.git'
>>>>>>> 5f279ef36273302d738d10e7da193d2df6b7230c
	
      }
    }
        stage('Build') {
      steps {
        sh 'chmod a+x mvnw'
        sh './mvnw clean package -DskipTests=true'
      }

          post {
        always {
          archiveArtifacts 'target/*.jar'
        }
          }
        }
        stage('DockerBuild') {
      steps {
        sh 'docker build -t p2/recApp:latest .'
      }
        }
         stage('DockerRun') {
      steps {
        sh 'docker run -d -p 9090:9090 p2/recApp'
      }
        }
  }
<<<<<<< HEAD
}
=======
} 
>>>>>>> 5f279ef36273302d738d10e7da193d2df6b7230c
