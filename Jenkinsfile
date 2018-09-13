pipeline {
  agent {
    docker {
      image 'maven:3.3.9-jdk7'
    }

  }
  stages {
    stage(' Initialize') {
      steps {
        sh '''echo PATH=${PATH}
echo M_HOME=${M2_HOME}
mvn clean'''
      }
    }
  }
}